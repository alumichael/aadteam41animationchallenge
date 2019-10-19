package com.team41.aad_team_41_animation_challenge.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.team41.aad_team_41_animation_challenge.R;
import com.team41.aad_team_41_animation_challenge.util.Constant;
import com.wang.avi.AVLoadingIndicatorView;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * Created by Michael on 10/18/2019.
 */

public class MemberDetail extends AppCompatActivity {

    /** ButterKnife Code **/
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.user_img)
    ImageView mUserImg;
    @BindView(R.id.status_badge)
    ImageView mStatusBadge;
    @BindView(R.id.name_txt)
    TextView mName;
    @BindView(R.id.gender)
    TextView mGender;
    @BindView(R.id.phone_no)
    TextView mPhoneNum;
    @BindView(R.id.email)
    TextView mEmail;
    @BindView(R.id.info_txt)
    TextView mInfo_txt;
    @BindView(R.id.progress)
    AVLoadingIndicatorView mProgress;

    /** ButterKnife Code **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_detail);
        ButterKnife.bind(this);
        //Applying some text style on Appbar
        applyToolbarChildren("Member Detail");

        Intent intent=getIntent();
        String email=intent.getStringExtra(Constant.EMAIL);
        String name = intent.getStringExtra(Constant.NAME);
        String img=intent.getStringExtra(Constant.IMG);
        String gender=intent.getStringExtra(Constant.GENDER);
        String phone_no=intent.getStringExtra(Constant.PHONE_NUM);
        String status=intent.getStringExtra(Constant.STATUS);


        mName.setText(name);
        mEmail.setText(email);
        mGender.setText(gender);
        mPhoneNum.setText(phone_no);
        mInfo_txt.setText("We Grow with Google\n#growwithgoogle\n#alc\n#andela\n#googleafrica\n#pluralsight");


        //If any member is not active he or she don't
        //get to see badge
       if(status.equals("Active")){
           mStatusBadge.setImageResource(R.drawable.badge);
       }
        mProgress.setVisibility(View.VISIBLE);
        if (img != null) {
            Glide.with(this).load(img).apply(new RequestOptions().fitCenter()).into(this.mUserImg);
            mProgress.setVisibility(View.GONE);
        }


    }


    private void applyToolbarChildren(String title) {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_keyboard_arrow_left_black_24dp);
        //setting Elevation for > API 21
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mToolbar.setElevation(10f);
        }

    }

    //on back arrow appbar option click
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

}
