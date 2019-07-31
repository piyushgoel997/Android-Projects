package com.example.piyush.pushmessaging;

import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;

public class MessagingService extends FirebaseMessagingService {

    private static final String TAG = "MessagingService";

    public MessagingService() {
        super();
        Log.d(TAG, "MessagingService: ");
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "onMessageReceived: ");
        Map<String, String> msgData = remoteMessage.getData();
        for (String s : msgData.keySet()) {
            Log.d(TAG, "onMessageReceived: " + s + " : " + msgData.get(s));
        }
    }
}

// Make Chat app using Firebase databases
// transparent activity
// putty