package com.ebees.util;

import java.util.Arrays;

import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets.Details;
 
public class GoogleOAuthTest {
     
    public static void main(String[] args) throws Exception {
        String authCode = "4/yU4cQZTMnnMtetyFcIWNItG32eKxxxgXXX-Z4yyJJJo.4qHskT-UtugceFc0ZRONyF4z7U4UmAI";
 
        String redirectUri = "http://localhost:8999/test2.html";
         
        Details details = new Details();
        details.setClientId("44041201285-v5o3j9i7ve3slnmap077ga1asdvd8u8f.apps.googleusercontent.com");
        details.setClientSecret("TtEZ8yhHlp8i30L4xN1iQli2");
        details.setRedirectUris(Arrays.asList(redirectUri));
 
        GoogleClientSecrets clientSecrets = new GoogleClientSecrets();
        clientSecrets.setInstalled(details);
         
        GoogleTokenResponse tokenResponse =
                  new GoogleAuthorizationCodeTokenRequest(
                      new NetHttpTransport(),
                      JacksonFactory.getDefaultInstance(),
                      "https://www.googleapis.com/oauth2/v4/token",
                      clientSecrets.getDetails().getClientId(),
                      clientSecrets.getDetails().getClientSecret(),
                      authCode,
                      redirectUri)
                      .execute();
 
        System.out.println("Access token: " + tokenResponse.getAccessToken());
        System.out.println("Expires in: " + tokenResponse.getExpiresInSeconds());
        System.out.println("Refresh token: " + tokenResponse.getRefreshToken());
         
        // Get profile info from ID token
        GoogleIdToken idToken = tokenResponse.parseIdToken();
        GoogleIdToken.Payload payload = idToken.getPayload();
        System.out.println("User ID: " + payload.getSubject());  // Use this value as a key to identify a user.
        System.out.println("Email: " + payload.getEmail());
        System.out.println("Email verified: " + payload.getEmailVerified());
        System.out.println("Name: " + payload.get("name"));
        System.out.println("Picture Url: " + payload.get("picture"));
        System.out.println("Locale: " + payload.get("locale"));
        System.out.println("Family name: " + payload.get("family_name"));
        System.out.println("Given name: " + payload.get("given_name"));
    }
     
}