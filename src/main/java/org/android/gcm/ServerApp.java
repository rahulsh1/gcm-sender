package org.android.gcm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Main Class
 */
public final class ServerApp {

  final static String URL = "https://android.googleapis.com/gcm/send";

  // Change this with your Api Key obtained from GDC Credentials.
  final static String apiKey = "AIzaxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

  // Change the registration Id. Add one or more to this Array
  private final static String[] myDevices = {
    "APA91bxxxxxxxxxxxxxxxxxxxxxx-NyIEN7qnwSbg"
  };

  public static void main(String[] args) {
    // Example taken from Google docs
    final JSONContent content = JSONContent.of("score_update", 300, false)
        .withData("score", "4x8")
        .withData("time", "15:16.2342")
        .withRegistrationId(myDevices[0]);

    final ObjectMapper mapper = new ObjectMapper();
    try {
      System.out.println("Sending \n" + mapper.writeValueAsString(content) + "\n");
      final boolean result = HttpSender.post(apiKey, content);
      System.out.println("Message sent: " + result);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}
