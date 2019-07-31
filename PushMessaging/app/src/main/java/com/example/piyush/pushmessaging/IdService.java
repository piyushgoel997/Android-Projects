package com.example.piyush.pushmessaging;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceIdService;

public class IdService extends FirebaseInstanceIdService {

    private static final String TAG = "IdService";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        Log.d(TAG, "onTokenRefresh: ");
    }

    public IdService() {
        super();
        Log.d(TAG, "IdService: ");
    }
}
