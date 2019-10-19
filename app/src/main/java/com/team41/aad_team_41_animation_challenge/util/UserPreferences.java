package com.team41.aad_team_41_animation_challenge.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.team41.aad_team_41_animation_challenge.util.Constant;


/**
 * Created by Michael on 10/18/2019.
 *
 *
 *
 * Here is Our Shared Preference Class to only save our Login Mail Address,
 * for us to see on the Navigation Header, please let maintain the simplicity
 */
public class UserPreferences {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context _context;

    @SuppressLint("CommitPrefEdits")
    public UserPreferences(Context _context) {
        this._context = _context;
        sharedPreferences = _context.getSharedPreferences(Constant.USER_PREF, Constant.PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void setEmail(String email) {
        editor.putString(Constant.EMAIL, email);
        editor.apply();
    }

    public String getEmail() {
        return sharedPreferences.getString(Constant.EMAIL, "");
    }

}
