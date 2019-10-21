package com.team41.aad_team_41_animation_challenge.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.team41.aad_team_41_animation_challenge.R;
import com.team41.aad_team_41_animation_challenge.util.UserPreferences;
import com.team41.aad_team_41_animation_challenge.util.Constant;
import com.wang.avi.AVLoadingIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;
import maes.tech.intentanim.CustomIntent;

public class SignIn extends AppCompatActivity implements View.OnClickListener{

    /** ButterKnife Code **/
    @BindView(R.id.layout_signIn)
    FrameLayout mLayoutSignIn;
    @BindView(R.id.inputLayoutEmail)
    TextInputLayout mInputLayoutEmail;
    @BindView(R.id.email_editxt)
    EditText mEmailEditxt;
    @BindView(R.id.inputLayoutPassword)
    TextInputLayout mInputLayoutPassword;
    @BindView(R.id.password_editxt)
    EditText mPasswordEditxt;
    @BindView(R.id.signin_btn)
    Button mSigninBtn;
    @BindView(R.id.progress)
    AVLoadingIndicatorView mProgress;

    /** ButterKnife Code **/

    UserPreferences userPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);


        userPreferences = new UserPreferences(this);

        mSigninBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.signin_btn:
                ValidateForm();
                break;
        }

    }

    private void ValidateForm() {

            //Form input validation, even though
            //we don't use DB
            boolean isValid = true;

            if (mEmailEditxt.getText().toString().isEmpty()) {
                mInputLayoutEmail.setError("Email is required!");
                isValid = false;
            }  else {
                mInputLayoutEmail.setErrorEnabled(false);
            }
            if (mPasswordEditxt.getText().toString().isEmpty()) {
                mInputLayoutPassword.setError("Password is required!");
                isValid = false;
            } else if (mPasswordEditxt.getText().toString().trim().length()<6 && mInputLayoutPassword.isClickable()) {
                mInputLayoutPassword.setError("Your Password must not less than 6 character");
                isValid = false;
            } else {
                mInputLayoutPassword.setErrorEnabled(false);
            }

            if (isValid) {

                //Save on pref and continue to Dashboard
                mProgress.setVisibility(View.VISIBLE);
                mSigninBtn.setVisibility(View.GONE);

                String email=mEmailEditxt.getText().toString();
                userPreferences.setEmail(email);
                showMessage("Successfully Sign In");
                Intent intent=new Intent(SignIn.this, MainActivity.class);
                startActivity(intent);
                CustomIntent.customType(this,"up-to-bottom");
                finish();

            }


    }



    //Snack Toast
    private void showMessage(String s) {
        Snackbar.make(mLayoutSignIn, s, Snackbar.LENGTH_LONG).show();
    }
}
