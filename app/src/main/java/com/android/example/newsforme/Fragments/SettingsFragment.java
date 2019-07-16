package com.android.example.newsforme.Fragments;

import android.os.Bundle;
import android.preference.SwitchPreference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.SwitchPreferenceCompat;

import com.android.example.newsforme.R;

public class SettingsFragment extends PreferenceFragmentCompat {


    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.menu_preferences);
    }
}
