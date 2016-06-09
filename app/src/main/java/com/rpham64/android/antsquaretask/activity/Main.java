package com.rpham64.android.antsquaretask.activity;

import com.twilio.auth.AccessToken;
import com.twilio.auth.ConversationsGrant;

/**
 * NOTE: Unnecessary file. Kept for testing purposes.
 *
 * Generates an Access Token via Helper Library
 *
 * Taken from: https://www.twilio.com/user/account/video/dev-tools/testing-tools
 */
public class Main {

    // Substitute the following values using the details from your Twilio Account
    public static final String ACCOUNT_SID = "AC0fc554d3f7182116c6ca5bf319c25e1b";
    public static final String API_KEY_SID = "SKfa240d8271d971332b06b263adc46d71";
    public static final String API_KEY_SECRET = "BgxSm7Jt1zZrBCmfX3kybqJN4wCmTDUi";
    public static final String CONFIGURATION_PROFILE_SID = "VS2dfcb3eca82b25c9d7ce750566047ce8";

    public static void main(String[] args) throws Exception {
        // Create a ConversationsGrant
        ConversationsGrant grant = new ConversationsGrant();
        grant.setConfigurationProfileSid(CONFIGURATION_PROFILE_SID);

        // Create an Access Token
        AccessToken token = new AccessToken.Builder(ACCOUNT_SID, API_KEY_SID, API_KEY_SECRET)
                .identity("example-user") // Set the Identity of this token
                .grant(grant) // Grant access to Conversations
                .build();

        // Serialize the token as a JWT
        String jwt = token.toJWT();
        System.out.println(jwt);
    }
}