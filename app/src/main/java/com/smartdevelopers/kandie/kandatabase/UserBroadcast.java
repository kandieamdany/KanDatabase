package com.smartdevelopers.kandie.kandatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by 4331 on 04/07/2015.
 */
public class UserBroadcast extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_user);
    }
    public void broadcastCustomIntent(View view)

    {
        Intent intent = new Intent("MyCustomIntent");
        EditText et = (EditText)findViewById(R.id.extraIntent);
        // add data to the Intent
        intent.putExtra("message", (CharSequence) et.getText().toString());
        intent.setAction("com.smartdevelopers.kandie.kandatabase.A_CUSTOM_INTENT");
        sendBroadcast(intent);

    }
}
