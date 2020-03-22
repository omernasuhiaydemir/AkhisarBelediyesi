package com.hemlibra;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Information extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);


        Button back_button=findViewById(R.id.back_button);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            int key = bundle.getInt("key");

            if (key==1){

                back_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(getApplicationContext(),ResultEnSon.class);
                        startActivity(i);



                    }
                });
            }



            }


        else
        {
            back_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);



                }
            });

        }


            TextView hemlibra_information_textview=(TextView)findViewById(R.id.hemlibra_information_textview);


        Typeface Trade_Gothic_Bold = Typeface.createFromAsset(getAssets(),  "font/trade_gothic_bold.ttf");
        hemlibra_information_textview.setTypeface(Trade_Gothic_Bold);





}
}