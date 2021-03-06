package com.skipop.nathan.phoneguard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by nathan on 12/17/14.
 * Nathan Prat
 */
public class BootListener extends BroadcastReceiver {

    //TODO receive boot event
    //TODO-> if security was on before : restart service
    //TODO-> if security and new sim : send new number to old one

    @SuppressWarnings("EmptyMethod")
    public void getPreviousSimId(){

    }

    @SuppressWarnings("EmptyMethod")
    public void getCurrentSimId(){

    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String tag = "PhoneGuard BOOT";
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            //we have received the correct Intent
            Log.d(tag, "BOOT_COMPLETED");

            SecurityManager securityManager = new SecurityManager(context);
            boolean previousState = securityManager.isSecurityActivated();
            Log.d(tag, "security was "+previousState);
            int duration = Toast.LENGTH_LONG;
            Toast.makeText(context, "PhoneGuard: Security was "+previousState, duration).show();
        }
        else{
            //we have received the wrong Intent
            Log.d(tag, "BOOT_COMPLETED wrong intent");
        }
    }
}
