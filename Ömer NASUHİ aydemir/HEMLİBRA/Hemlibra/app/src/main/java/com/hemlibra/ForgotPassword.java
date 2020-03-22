package com.hemlibra;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.kevalpatel2106.rulerpicker.RulerValuePicker;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

public class Login extends AppCompatActivity {

    RulerValuePicker rulerValuePicker;
    TextView member_login_text,welcome_hemlibra_text,password_is_case_text,error_textview,and_privacy_text;
    EditText e_mail_edit_text, password_edittext;
    int kilo;
    Context context=this;
    int goz_kontrol=0;

    ImageView kilit_icon,mail_icon;

    String sifre_girilen,e_mail_girilen;


    private String valid_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

/*
        ParseObject object = new ParseObject("Meyveler");
        object.put("isim","elma");
        object.put("kalori",100);
        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {

                if (e!=null){


                    Toast.makeText(getApplicationContext(), String.valueOf(e), Toast.LENGTH_SHORT).show();



                }
                else{


                    Toast.makeText(getApplicationContext(), "Kaydedildi", Toast.LENGTH_SHORT).show();



                }


            }
        });


 */


       /* ParseUser user = new ParseUser();
        user.setUsername("berkay.oflaz@gmail.com");
        user.setPassword("123456");
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {

                if (e!=null){


                    Toast.makeText(getApplicationContext(), String.valueOf(e), Toast.LENGTH_SHORT).show();



                }
                else{


                    Toast.makeText(getApplicationContext(), "Kullanıcı kaydedildi", Toast.LENGTH_SHORT).show();



                }

            }
        });



        */



















        final Button sign_in_button=(Button)findViewById(R.id.sign_in_button);
        final Button goz_button=(Button)findViewById(R.id.goz_button);


        final TextView forgot_password_text=(TextView) findViewById(R.id.forgot_password_text);
        final TextView terms_of_service=(TextView) findViewById(R.id.terms_of_service);
        final TextView privacy_policy=(TextView) findViewById(R.id.privacy_policy);


        forgot_password_text.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        terms_of_service.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        privacy_policy.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);





        member_login_text=findViewById(R.id.member_login);
        welcome_hemlibra_text=findViewById(R.id.welcome_to_hemlibra);
        password_is_case_text=findViewById(R.id.password_is_case);

        error_textview=findViewById(R.id.error_text);

        kilit_icon=findViewById(R.id.kilit_icon);
        mail_icon=findViewById(R.id.mail_icon);






        ParseUser.requestPasswordResetInBackground("berkay.oflaz@gmail.com",
                new RequestPasswordResetCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(getApplicationContext(), "mail gönderildi", Toast.LENGTH_SHORT).show();

                        } else {

                            e.printStackTrace();
                            Log.e("HATAA", e.getLocalizedMessage());
                        }
                    }
                });










        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {

            startActivity(new Intent(Login.this,MainActivity.class));
            finish();

        } else {

        }


        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                final String e_mail_adresi_str=e_mail_edit_text.getText().toString();
                final String şifre_str=password_edittext.getText().toString();


                ParseUser.logInInBackground(e_mail_adresi_str, şifre_str, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {




                        if ((e_mail_adresi_str.matches(""))||(şifre_str.matches(""))){


                            Toast.makeText(getApplicationContext(), "Please enter your e-mail and password...", Toast.LENGTH_SHORT).show();



                        }

                        else{


                            final ProgressDialog progressDialog = new ProgressDialog(Login.this);
                            progressDialog.setMessage("Please wait...");
                            progressDialog.show();



                            if (e!=null){

                                e.printStackTrace();
                                error_textview.setVisibility(View.VISIBLE);
                                mail_icon.setBackgroundResource(R.drawable.mail_turuncu);
                                error_textview.setText(e.getLocalizedMessage());
                                sign_in_button.setBackgroundResource(R.drawable.siyah_button);
                                progressDialog.dismiss();
                                mail_icon.setBackgroundResource(R.drawable.mail);

                            }
                            else{



                                startActivity(new Intent(Login.this,MainActivity.class));
                                finish();

                            }


                        }





                    }
                });


            }
        });





        Typeface Trade_Gothic_Bold = Typeface.createFromAsset(getAssets(),  "font/trade_gothic_bold.ttf");

        member_login_text.setTypeface(Trade_Gothic_Bold);
        welcome_hemlibra_text.setTypeface(Trade_Gothic_Bold);




        e_mail_edit_text=findViewById(R.id.e_mail_edittext);
        password_edittext=findViewById(R.id.sifre_edittext);





       /* password_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                InputMethodManager imm1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm1.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);



            }
        });

        */


       terms_of_service.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               Intent i = new Intent(getApplicationContext(),Terms.class);
               i.putExtra("gelen_key",  1);
               startActivity(i);


           }
       });

        privacy_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(getApplicationContext(),Terms.class);
                i.putExtra("gelen_key",  2);
                startActivity(i);


            }
        });




        e_mail_edit_text.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    e_mail_edit_text.setHint("");
                else
                    e_mail_edit_text.setHint("Your e-mail");
            }
        });






        password_edittext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    password_edittext.setHint("");
                else
                    password_edittext.setHint("Your password");
            }
        });



        e_mail_edit_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s_2, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s_2, int start, int before, int count) {
                if (s_2.toString().length() > 0) {

                    sign_in_button.setBackgroundResource(R.drawable.turuncu_oval_button);
                    mail_icon.setBackgroundResource(R.drawable.mail_siyah);

                }
                else{

                    sign_in_button.setBackgroundResource(R.drawable.siyah_button);
                    mail_icon.setBackgroundResource(R.drawable.mail);



                }

                if (e_mail_edit_text.equals("") || password_edittext.equals("")){

                    sign_in_button.setBackgroundResource(R.drawable.siyah_button);

                }
                else {
                    sign_in_button.setBackgroundResource(R.drawable.turuncu_oval_button);

                }


            }


            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

                // TODO Auto-generated method stub
                Is_Valid_Email(e_mail_edit_text);
                // pass your EditText Obj here.
            }

            public void Is_Valid_Email(EditText edt) {
                if (edt.getText().toString() == null) {

                    valid_email = null;
                } else if (isEmailValid(edt.getText().toString()) == false) {


                    valid_email = null;

                } else {

                    valid_email = edt.getText().toString();
                    mail_icon.setBackgroundResource(R.drawable.mail_turuncu);

                }
            }

            boolean isEmailValid(CharSequence email) {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                        .matches();
            } // end of TextWatcher (email)
        });



        password_edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s_1, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s_1, int start, int before, int count) {
                if (s_1.toString().length() > 0) {

                    sign_in_button.setBackgroundResource(R.drawable.turuncu_oval_button);
                    kilit_icon.setBackgroundResource(R.drawable.kilit_siyah);
                    goz_button.setBackgroundResource(R.drawable.goz_siyah);

                    sifre_girilen=password_edittext.getText().toString();


                }
                else{

                    sign_in_button.setBackgroundResource(R.drawable.siyah_button);
                    kilit_icon.setBackgroundResource(R.drawable.sifre);
                    goz_button.setBackgroundResource(R.drawable.goz);

                    sifre_girilen=password_edittext.getText().toString();




                }


                if (e_mail_edit_text.equals("") || password_edittext.equals("")){

                    sign_in_button.setBackgroundResource(R.drawable.siyah_button);

                }
                else {
                    sign_in_button.setBackgroundResource(R.drawable.turuncu_oval_button);

                }
            }

            @Override
            public void afterTextChanged(Editable s_1) {

            }
        });


        goz_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (goz_kontrol==0){
                    goz_kontrol=1;


                    password_edittext.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                    goz_button.setBackgroundResource(R.drawable.goz_turuncu);


                }
                else if(goz_kontrol==1){
                    goz_kontrol=0;
                    password_edittext.setTransformationMethod(PasswordTransformationMethod.getInstance());

                    goz_button.setBackgroundResource(R.drawable.goz);



                }


            }
        });





      /*  auth = FirebaseAuth.getInstance();

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


                                        error_textview.setVisibility(View.VISIBLE);
                                        mail_icon.setBackgroundResource(R.drawable.mail_turuncu);
                                        error_textview.setText("The email address you entered is invalid");
                                        sign_in_button.setBackgroundResource(R.drawable.siyah_button);
                                        progressDialog.dismiss();
                                        mail_icon.setBackgroundResource(R.drawable.mail);

                                    }

                                }
                            });




                }


            }
        });


       */


    }






    @Override
    public void onBackPressed() {


        this.finish();
}


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

}

