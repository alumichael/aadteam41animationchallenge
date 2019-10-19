package com.team41.aad_team_41_animation_challenge.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.team41.aad_team_41_animation_challenge.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Michael on 10/18/2019.
 */

public class Splash extends AppCompatActivity {


    /*Binded View using ButterKnife,
    * This library saves us from defining the
    * long findViewById for our views
    * Please Note you only need to pick the Widget variable e.g txtDesc
    * to make use of it e.g txtDesc.setText("Mike")
     */
    @BindView(R.id.img_logo)
    ImageView imgLogo;

    @BindView(R.id.txt_desc)
    TextView txtDesc;

    // Animation variable
    Animation slide_from_bottom, blink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);


            // load the animation
        slide_from_bottom = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.slide_in_from_buttom);

            blink = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.blink);

            //start animation
            imgLogo.startAnimation(slide_from_bottom);
            txtDesc.startAnimation(blink);


            Thread myThread = new Thread(){
                @Override
                public void run() {
                    try {
                        sleep(3000);
                        //Go to SignIN
                        startActivity(new Intent(getApplicationContext(),SignIn.class));
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            myThread.start();

    }


}
