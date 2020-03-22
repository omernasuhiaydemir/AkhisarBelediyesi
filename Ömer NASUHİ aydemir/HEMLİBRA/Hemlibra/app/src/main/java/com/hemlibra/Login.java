package com.hemlibra;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.kevalpatel2106.rulerpicker.RulerValuePicker;
import com.kevalpatel2106.rulerpicker.RulerValuePickerListener;

public class Login extends AppCompatActivity {

    RulerValuePicker rulerValuePicker;
    TextView member_login_text,welcome_hemlibra_text,password_is_case_text,by_signing_text,and_privacy_text;
    EditText e_mail_edit_text, password_edittext;
    int kilo;
    Context context=this;
    int goz_kontrol=0;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deneme);

        final Button sign_in_button=(Button)findViewById(R.id.sign_in_button);
        final ImageView goz_button=(ImageView)findViewById(R.id.goz_button);
        final ImageView mail_icon=(ImageView)findViewById(R.id.mail_icon);



        member_login_text=findViewById(R.id.member_login);
        welcome_hemlibra_text=findViewById(R.id.welcome_to_hemlibra);
        password_is_case_text=findViewById(R.id.password_is_case);



        Typeface Trade_Gothic_Bold = Typeface.createFromAsset(getAssets(),  "font/trade_gothic_bold.ttf");

        member_login_text.setTypeface(Trade_Gothic_Bold);
        welcome_hemlibra_text.setTypeface(Trade_Gothic_Bold);




        e_mail_edit_text=findViewById(R.id.e_mail_edittext);
        password_edittext=findViewById(R.id.sifre_edittext);




        if ( FirebaseAuth.getInstance().getCurrentUser()!=null){

            startActivity(new Intent(Login.this,MainActivity.class));
            finish();


        }


        goz_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (goz_kontrol==0){
                    goz_kontrol=1;


                    password_edittext.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }
                else if(goz_kontrol==1){
                    goz_kontrol=0;
                    password_edittext.setTransformationMethod(PasswordTransformationMethod.getInstance());


                }


            }
        });





        auth = FirebaseAuth.getInstance();

        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String e_mail_adresi_str=e_mail_edit_text.getText().toString();
                String şifre_str=password_edittext.getText().toString();







                if ((e_mail_adresi_str.matches(""))||(şifre_str.matches(""))){


                    Toast.makeText(getApplicationContext(), "Please enter your e-mail and password...", Toast.LENGTH_SHORT).show();



                }
                else {



                    final ProgressDialog progressDialog = new ProgressDialog(Login.this);
                    progressDialog.setMessage("Please wait...");
                    progressDialog.show();


                    auth.signInWithEmailAndPassword(e_mail_adresi_str, şifre_str)
                            .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {


                                        startActivity(new Intent(Login.this,MainActivity.class));
                                        finish();





                                    }

                                    else {


                                        e_mail_edit_text.setText("");
                                        mail_icon.setBackgroundResource(R.drawable.mail_turuncu);
                                        e_mail_edit_text.setTextSize(14);
                                        e_mail_edit_text.setHint("The email address you entered is invalid");
                                        e_mail_edit_text.setHintTextColor(getResources().getColor(R.color.asıl_turuncu));
                                        sign_in_button.setBackgroundResource(R.drawable.turuncu_oval_button);

                                        progressDialog.dismiss();

                                    }

                                }
                            });




                }


            }
        });


    }



    @Override
    public void onBackPressed() {


        this.finish();
}

}

