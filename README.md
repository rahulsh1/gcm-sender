# gcm-sender
Java Program that acts as a GCM Server for HTTP connections with JSON payload.

[![Build Status](https://travis-ci.org/rahulsh1/gcm-sender.svg?branch=master)](https://travis-ci.org/rahulsh1/gcm-sender)

Note this is not a full implementation and is good for testing purposes only.

##### Prerequisites
1. Maven
2. JDK 1.7

##### Code changes
Modify ServerApp.java with your api key and Device Registration Ids.

    // Change this with your Api Key obtained from GDC Credentials.
    final static String apiKey = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

    // Change the registration Id. Add one or more to this Array
    private final static String[] myDevices = {
        "xxxxxxxxxxxxxxxxxxxxxxx"
    };

##### Build
    $ mvn clean install

##### To Run
    $ mvn install -PRun


##### Sample output
    Sending
    {"data":{"time":"15:16.2342","score":"4x6"},"collapse_key":"score_update","time_to_live":300,"delay_while_idle":false,"registration_ids":["APA9
    1bFlmPxDGNWp42wCJssxxxxxxxx"]}

    Sent POST request to https://android.googleapis.com/gcm/send
    Got Response Code : 200
    Response::
    {"multicast_id":6594286974355097061,"success":1,"failure":0,"canonical_ids":0,"results":[{"message_id":"0:142733423424246507%921c249a66d6cf16"}]}


##### Client App
Inside your Android App, you can extract values from the Intent as shown below

    String score = intent.getStringExtra("score");
    String time  = intent.getStringExtra("time");


More information on Implementing GCM Server can be found [here](https://developer.android.com/google/gcm/server.html)
