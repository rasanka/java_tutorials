package com.ebees.util;

import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TradeMeTest {

    public static void main(String[] args) {
        
        try{
        System.setProperty("webdriver.firefox.marionette", "/home/vagrant/git/geckodriver");
        
        FirefoxDriver driver = new FirefoxDriver();
        driver.setLogLevel(Level.SEVERE);
        driver.manage().deleteAllCookies();
        driver.get("https://www.trademe.co.nz/property");

        WebElement regionSelect = driver.findElement(By.id("PropertyRegionSelect"));
        Select regionDropdown= new Select(regionSelect);
        regionDropdown.selectByVisibleText("Auckland");
        
        //Thread.sleep(5000);
        
        WebElement districtSelect = driver.findElement(By.id("PropertyDistrictSelect"));
        Select districtDropdown= new Select(districtSelect);
        districtDropdown.selectByIndex(1);
        
        //Thread.sleep(5000);
        
        WebElement suburbSelect = driver.findElement(By.id("PropertySuburbSelect"));
        Select suburbDropdown= new Select(suburbSelect);
        suburbDropdown.selectByIndex(1);
         System.out.println(suburbDropdown.getAllSelectedOptions().size());   

        driver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
