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
        Log.i(LOG_TAG, "Inicializamos Comscore");
    }

    @Override
    public void onResume(boolean multitasking) {
        super.onResume(multitasking);
        comScore.onEnterForeground();
        Log.i(LOG_TAG, "Foreground");
    }

    @Override
    public void onPause(boolean multitasking) {
       super.onPause(multitasking);
       comScore.onExitForeground();
       Log.i(LOG_TAG, "Background");
    }

     @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        PluginResult.Status status = PluginResult.Status.OK;
        String result = "";
        if (action.equals("create")) {
            comScore.setCustomerC2(args.getString(0));
            comScore.setPublisherSecret(args.getString(1));
            Log.i(LOG_TAG, "Añadimos datos. C2:"+args.getString(0)+" y Secret:"+args.getString(1));
        }
        return false;
    }

}
