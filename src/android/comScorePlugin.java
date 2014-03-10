package com.example.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import com.comscore.analytics.comScore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class comScorePlugin extends CordovaPlugin {

    private static final String LOG_TAG = "comScore";

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        Context context=this.cordova.getActivity().getApplicationContext();

        comScore.setAppContext(context);
        comScore.setCustomerC2("14600568");
        comScore.setPublisherSecret("ae7ddf31c603051f21d1d166921079aa");
        Log.i(LOG_TAG, "Inicializamos Comscore");
    }

    @Override
    public void onResume() {
        super.onResume();
        comScore.onEnterForeground();
        Log.i(LOG_TAG, "Foreground");
    }

    @Override
    public void onPause() {
       super.onPause();
       comScore.onExitForeground();
       Log.i(LOG_TAG, "Background");
    }

     @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        PluginResult.Status status = PluginResult.Status.OK;
        String result = "";
        if (action.equals("create")) {

        }
        return false;
    }

}
