package com.smartdevelopers.kandie.kandatabase;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by 4331 on 02/07/2015.
 */
public class UserSettingActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }

}
