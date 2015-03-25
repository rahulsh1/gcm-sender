package org.android.gcm;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpSender {

  /**
   * Sends the request to GCM URL.
   * @param apiKey key
   * @param content json data
   * @return true if request was sent successfully
   */
  public static boolean post(String apiKey, JSONContent content) {
    boolean status = false;

    try {
      final URL url = new URL(ServerApp.URL);
      final HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      connection.setRequestMethod("POST");
      connection.setRequestProperty("Content-Type", "application/json");
      connection.setRequestProperty("Authorization", "key=" + ServerApp.apiKey);
      connection.setDoOutput(true);

      // Add JSON data into POST request body
      ObjectMapper mapper = new ObjectMapper();
      try (DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream())) {
        mapper.writeValue(dataOutputStream, content);
        dataOutputStream.flush();
      }

      // Check response
      int responseCode = connection.getResponseCode();
      System.out.println("Sent POST request to " + ServerApp.URL);
      System.out.println("Got Response Code : " + responseCode);
      try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
        String inputLine;
        final StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
          response.append(inputLine);
        }
        System.out.println("Response::\n" + response.toString());
        status = true;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return status;
  }
}
