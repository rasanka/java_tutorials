package com.ebees.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.firefox.marionette", "/home/vagrant/workspace/selenium-test/geckodriver");

		String baseUrl = "https://url";

		List<String> emails = new ArrayList<>();

		File folder = new File(args[0]);
		for (File emailsFile : folder.listFiles()) {
			if (emailsFile.isDirectory()) {
				continue;
			}

			BufferedReader in = new BufferedReader(new FileReader(emailsFile));
			String line;
			while ((line = in.readLine()) != null) {
				if (line.trim().length() > 0) {
					emails.add(line.trim());
				}
			}
			in.close();
		}

		Collections.shuffle(emails);

		System.out.println(emails);

		for (String email : emails) {
			System.out.println("Voting for: " + email);

			FirefoxDriver driver = new FirefoxDriver();
			driver.setLogLevel(Level.SEVERE);
			driver.manage().deleteAllCookies();
			driver.get(baseUrl);

			WebElement searchField = driver.findElement(By.id("search"));
			searchField.sendKeys("searchkey");
			searchField.sendKeys(Keys.ENTER);

			Thread.sleep(5000);

			WebElement voteButton = driver.findElement(By.className("modal-button"));
			voteButton.click();

			Thread.sleep(1000);

			WebElement emailField = driver.findElement(By.id("email"));
			emailField.sendKeys(email);

			Thread.sleep(1000);

			WebElement submitButton = driver.findElement(By.className("js-login-and-vote-submit-button"));
			submitButton.click();

			int wait = 20000 + new Random().nextInt(300000);
			System.out.println("Waiting for " + (wait / 1000) + " seconds");
			Thread.sleep(wait);

			driver.close();
		}
	}

}
