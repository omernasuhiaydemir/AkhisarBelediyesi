package com.hemlibra;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class Loading_Injection_Result extends AppCompatActivity {

    int kilo = 0;
    int dose_int_1,dose_int_2,dose_int_3=30;
    int total_dose;
    double amount;
    int vial;
    double volume_1,volume_2,volume_3=0.0;
    double total_volume;
    int bir_mg_syringe;
    int iki_uc_mg_syringe;
    String ilac_adı_1,ilaç_adı_2,ilaç_adı_3;

    Context context=this;

    int birinci_ilaç_layout_height,ikinci_ilaç_layout_height,üçüncü_ilaç_layout_height,text_layout_height;


    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;

    double[] aranacak_dizi;

    String vial_değeri ;

    String volume_değeri;

    String sky_blue_dose,sky_blue_volume_değeri,sky_blue_vial_değeri, total_dose_değeri, total_volume_değeri, bir_mg_syringe_değeri, iki_üç_syringe_değeri;


    String purple_volume_değeri,purple_vial_değeri,turquoise_volume_değeri,turquoise_vial_değeri,orange_volume_değeri,orange_vial_değeri;

    String purple_dose,turquoise_dose,orange_dose;



    String ilaç_harf_1, ilaç_harf_2, ilaç_harf_3, ilaç_harf_4 = "Y";

    String ilaç_sıralaması;

    int kriter;




        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_en_son);


        ilaç_harf_1 = "y";
        ilaç_harf_2 = "y";
        ilaç_harf_3 = "y";
        ilaç_harf_4 = "y";


        sky_blue_dose="30 mg";
        purple_dose="60 mg";
        turquoise_dose="105 mg";
        orange_dose="150 mg";









            TextView exaple=(TextView)findViewById(R.id.example);
            TextView vıal_com=(TextView)findViewById(R.id.vıal_com);
            TextView inj_text=(TextView)findViewById(R.id.inj_text);


            TextView ilaç_adı_1=(TextView)findViewById(R.id.ilaç_adı_1);
            TextView dose_1=(TextView)findViewById(R.id.dose_1);
            TextView amount_1=(TextView)findViewById(R.id.amount_1);
            TextView form_1=(TextView)findViewById(R.id.form_1);
            TextView dose_ml_1=(TextView)findViewById(R.id.dose_ml_1);
            TextView amount_ml_1=(TextView)findViewById(R.id.amount_ml_1);
            TextView form_vial_1=(TextView)findViewById(R.id.form_vial_1);
            TextView ilaç_adı_2=(TextView)findViewById(R.id.ilaç_adı_2);
            TextView dose_2=(TextView)findViewById(R.id.dose_2);
            TextView amount_2=(TextView)findViewById(R.id.amount_2);
            TextView form_2=(TextView)findViewById(R.id.form_2);
            TextView dose_ml_2=(TextView)findViewById(R.id.dose_ml_2);
            TextView amount_ml_2=(TextView)findViewById(R.id.amount_ml_2);
            TextView form_vial_2=(TextView)findViewById(R.id.form_vial_2);
            TextView ilaç_adı_3=(TextView)findViewById(R.id.ilaç_adı_3);
            TextView dose_3=(TextView)findViewById(R.id.dose_3);
            TextView amount_3=(TextView)findViewById(R.id.amount_3);
            TextView form_3=(TextView)findViewById(R.id.form_3);
            TextView dose_ml_3=(TextView)findViewById(R.id.dose_ml_3);
            TextView amount_ml_3=(TextView)findViewById(R.id.amount_ml_3);
            TextView form_vial_3=(TextView)findViewById(R.id.form_vial_3);

            TextView total_dose_textview=(TextView)findViewById(R.id.total_dose_textview);

            TextView total_volume_textview=(TextView)findViewById(R.id.total_volume_textview);

            TextView bir_mgl_syringe_textview=(TextView)findViewById(R.id.bir_mgl_syringe_textview);
            TextView iki_uc_syringe_textview=(TextView)findViewById(R.id.iki_uc_syringe_textview);

            final FrameLayout birinci_ilaç_layout=(FrameLayout)findViewById(R.id.birinci_ilaç_layout);
            FrameLayout ikinci_ilaç_layout=(FrameLayout)findViewById(R.id.ikinci_ilaç_layout);
            FrameLayout üçüncü_ilaç_layout=(FrameLayout)findViewById(R.id.üçüncü_ilaç_layout);
            final LinearLayout text_layout=(LinearLayout) findViewById(R.id.text_layout);


            final LinearLayout birinci_ilaç_backgound=(LinearLayout) findViewById(R.id.birinci_ilaç_backgound);
            final ImageView birinci_ilaç_image=(ImageView)findViewById(R.id.birinci_ilaç_image);


            final LinearLayout ikinci_ilaç_backgournd=(LinearLayout) findViewById(R.id.ikinci_ilaç_backgournd);
            final ImageView ikinci_ilaç_image=(ImageView)findViewById(R.id.ikinci_ilaç_image);


            final LinearLayout üçüncü_ilaç_backgournd=(LinearLayout) findViewById(R.id.üçüncü_ilaç_backgournd);
            final ImageView üçüncü_ilaç_image=(ImageView)findViewById(R.id.üçüncü_ilaç_image);




            mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            mNavigationView = (NavigationView) findViewById(R.id.navigationView);



            View header = mNavigationView.getHeaderView(0);

            LinearLayout administrations_button = (LinearLayout) header.findViewById(R.id.admin_button);
            LinearLayout log_out_layout = (LinearLayout) header.findViewById(R.id.log_out_layout);



            TextView information_text = (TextView) header.findViewById(R.id.information_text);





            Bundle bnd = getIntent().getExtras();
        if(bnd != null)
        {
            kilo = bnd.getInt("kilo_key");

            kriter = bnd.getInt("kriter_key");

        }


            total_dose_değeri = String.valueOf(kilo*3);





            double loading_injections_3 [] = {	3,	999,	999,	1,	0.3,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.3,	1,	0 };
            double loading_injections_4 [] = {4,	999,	999,	1,	0.4,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.4,	1,	0	 };
            double loading_injections_5 [] = {	5,	999,	999,	1,	0.5,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.5,	1,	0 };
            double loading_injections_6 [] = {6,	999,	999,	1,	0.6,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.6,	1,	0	 };
            double loading_injections_7 [] = {7,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.7,	1,	0	 };
            double loading_injections_8 [] = {	8,	999,	999,	1,	0.8,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.8,	1,	0 };
            double loading_injections_9 [] = {	9,	999,	999,	1,	0.9,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.9,	1,	0 };
            double loading_injections_10 [] = {	10,	1,	1,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	0 };
            double loading_injections_11 [] = {	11,	999,	999,	999,	999,	999,	999,	1,	0.22,	999,	999,	999,	999,	999,	999,	999,	999,	0.22,	1,	0 };
            double loading_injections_12 [] = {	12,	999,	999,	999,	999,	999,	999,	1,	0.24,	999,	999,	999,	999,	999,	999,	999,	999,	0.24,	1,	0 };
            double loading_injections_13 [] = {	13,	999,	999,	999,	999,	999,	999,	1,	0.26,	999,	999,	999,	999,	999,	999,	999,	999,	0.26,	1,	0 };
            double loading_injections_14 [] = {	14,	999,	999,	999,	999,	999,	999,	1,	0.28,	999,	999,	999,	999,	999,	999,	999,	999,	0.28,	1,	0 };
            double loading_injections_15 [] = {	15,	999,	999,	999,	999,	999,	999,	1,	0.3,	999,	999,	999,	999,	999,	999,	999,	999,	0.3,	1,	0 };
            double loading_injections_16 [] = {	16,	999,	999,	999,	999,	999,	999,	1,	0.32,	999,	999,	999,	999,	999,	999,	999,	999,	0.32,	1,	0 };
            double loading_injections_17 [] = {17,	999,	999,	999,	999,	999,	999,	1,	0.34,	999,	999,	999,	999,	999,	999,	999,	999,	0.34,	1,	0	 };
            double loading_injections_18 [] = {	18,	999,	999,	999,	999,	999,	999,	1,	0.36,	999,	999,	999,	999,	999,	999,	999,	999,	0.36,	1,	0 };
            double loading_injections_19 [] = {	19,	999,	999,	999,	999,	999,	999,	1,	0.38,	999,	999,	999,	999,	999,	999,	999,	999,	0.38,	1,	0 };
            double loading_injections_20 [] = {	20,	999,	999,	999,	999,	1,	0.4,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.4,	1,	0 };
            double loading_injections_21 [] = {21,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.42,	999,	999,	999,	999,	0.42,	1,	0	 };
            double loading_injections_22 [] = {22,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.44,	999,	999,	999,	999,	0.44,	1,	0	 };
            double loading_injections_23 [] = {	23,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.46,	999,	999,	999,	999,	0.46,	1,	0 };
            double loading_injections_24 [] = {	24,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.48,	999,	999,	999,	999,	0.48,	1,	0 };
            double loading_injections_25 [] = {	 25,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.5,	999,	999,	999,	999,	0.5,	1,	0};
            double loading_injections_26 [] = {26,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.52,	999,	999,	999,	999,	0.52,	1,	0	 };
            double loading_injections_27 [] = {27,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.54,	999,	999,	999,	999,	0.54,	1,	0	 };
            double loading_injections_28 [] = {	28,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.56,	999,	999,	999,	999,	0.56,	1,	0 };
            double loading_injections_29 [] = {	29,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.58,	999,	999,	999,	999,	0.58,	1,	0 };
            double loading_injections_30 [] = {	30,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.6,	999,	999,	999,	999,	0.6,	1,	0 };
            double loading_injections_31 [] = {	31,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.62,	999,	999,	999,	999,	0.62,	1,	0 };
            double loading_injections_32 [] = {	32,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.64,	999,	999,	999,	999,	0.64,	1,	0 };
            double loading_injections_33 [] = {	33,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.66,	999,	999,	999,	999,	0.66,	1,	0 };
            double loading_injections_34 [] = {	34,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.68,	999,	999,	999,	999,	0.68,	1,	0 };
            double loading_injections_35 [] = {	 35,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.7,	999,	999,	999,	999,	0.7,	1,	0};
            double loading_injections_36 [] = {	36,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.72,	0.72,	1,	0 };
            double loading_injections_37 [] = {	37,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.74,	0.74,	1,	0 };
            double loading_injections_38 [] = {38,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.76,	0.76,	1,	0	 };
            double loading_injections_39 [] = {	39,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.78,	0.78,	1,	0 };
            double loading_injections_40 [] = {	40,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.8,	0.8,	1,	0 };
            double loading_injections_41 [] = {	41,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.82,	0.82,	1,	0 };
            double loading_injections_42 [] = {	42,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.84,	0.84,	1,	0 };
            double loading_injections_43 [] = {	43,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.86,	0.86,	1,	0 };
            double loading_injections_44 [] = {44,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.88,	0.88,	1,	0	 };
            double loading_injections_45 [] = {	45,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.9,	0.9,	1,	0 };
            double loading_injections_46 [] = {	46,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.92,	0.92,	1,	046,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.92,	0.92,	1,	0 };
            double loading_injections_47 [] = {	47,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.94,	0.94,	1,	0 };
            double loading_injections_48 [] = {48,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.96,	0.96,	1,	0	 };
            double loading_injections_49 [] = {	49,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.98,	0.98,	1,	0 };
            double loading_injections_50 [] = {50,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	999,	999,	1,	1,	0	 };
            double loading_injections_51 [] = {51,	999,	999,	999,	999,	999,	999,	1,	0.32,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.02,	2,	0	 };
            double loading_injections_52 [] = {	52,	999,	999,	999,	999,	999,	999,	1,	0.34,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.04,	2,	0 };
            double loading_injections_53 [] = {	53,	999,	999,	999,	999,	999,	999,	1,	0.36,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.06,	2,	0 };
            double loading_injections_54 [] = {	54,	999,	999,	999,	999,	999,	999,	1,	0.38,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.08,	2,	0 };
            double loading_injections_55 [] = {	55,	999,	999,	999,	999,	999,	999,	1,	0.4,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.1,	0,	1 };
            double loading_injections_56 [] = {	56,	999,	999,	1,	0.6,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	999,	999,	1.6,	2,	0 };
            double loading_injections_57 [] = {	57,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	999,	999,	1.7,	2,	0 };
            double loading_injections_58 [] = {	58,	999,	999,	1,	0.8,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	999,	999,	1.8,	2,	0 };
            double loading_injections_59 [] = {	59,	999,	999,	1,	0.9,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	999,	999,	1.9,	2,	0 };
            double loading_injections_60 [] = {	60,	999,	999,	999,	999,	3,	0.4,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1.2,	0,	1 };
            double loading_injections_61 [] = {	61,	999,	999,	999,	999,	999,	999,	1,	0.22,	999,	999,	999,	999,	1,	1,	999,	999,	1.22,	2,	0 };
            double loading_injections_62 [] = {	62,	999,	999,	999,	999,	999,	999,	1,	0.24,	999,	999,	999,	999,	1,	1,	999,	999,	1.24,	2,	0 };
            double loading_injections_63 [] = {63,	999,	999,	999,	999,	999,	999,	1,	0.26,	999,	999,	999,	999,	1,	1,	999,	999,	1.26,	2,	0	 };
            double loading_injections_64 [] = {	64,	999,	999,	999,	999,	999,	999,	1,	0.28,	999,	999,	999,	999,	1,	1,	999,	999,	1.28,	2,	0 };
            double loading_injections_65 [] = {	65,	999,	999,	999,	999,	999,	999,	1,	0.3,	999,	999,	999,	999,	1,	1,	999,	999,	1.3,	2,	0 };
            double loading_injections_66 [] = {66,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.7,	1,	0.62,	999,	999,	999,	999,	1.32,	2,	0	 };
            double loading_injections_67 [] = {	67,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.7,	1,	0.64,	999,	999,	999,	999,	1.34,	2,	0 };
            double loading_injections_68 [] = {	68,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.7,	1,	0.66,	999,	999,	999,	999,	1.36,	2,	0 };
            double loading_injections_69 [] = {	69,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.7,	1,	0.68,	999,	999,	999,	999,	1.38,	2,	0 };
            double loading_injections_70 [] = {70,	999,	999,	999,	999,	999,	999,	999,	999,	2,	0.7,	999,	999,	999,	999,	999,	999,	1.4,	0,	1	 };
            double loading_injections_71 [] = {	71,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.42,	1,	1,	999,	999,	1.42,	2,	0 };
            double loading_injections_72 [] = {72,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.44,	1,	1,	999,	999,	1.44,	2,	0	 };
            double loading_injections_73 [] = {73,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.46,	1,	1,	999,	999,	1.46,	2,	0	 };
            double loading_injections_74 [] = {	 74,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.48,	1,	1,	999,	999,	1.48,	2,	0};
            double loading_injections_75 [] = {	 75,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.5,	1,	1,	999,	999,	1.5,	0,	1};
            double loading_injections_76 [] = {76,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.52,	1,	1,	999,	999,	1.52,	2,	0	 };
            double loading_injections_77 [] = {	77,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.54,	1,	1,	999,	999,	1.54,	2,	0 };
            double loading_injections_78 [] = {	78,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.56,	1,	1,	999,	999,	1.56,	2,	0 };
            double loading_injections_79 [] = {79,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.58,	1,	1,	999,	999,	1.58,	2,	0	 };
            double loading_injections_80 [] = {	80,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.6,	1,	1,	999,	999,	1.6,	0,	1 };
            double loading_injections_81 [] = {	81,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.62,	1,	1,	999,	999,	1.62,	2,	0 };
            double loading_injections_82 [] = {	82,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.64,	1,	1,	999,	999,	1.64,	2,	0 };
            double loading_injections_83 [] = {	83,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.66,	1,	1,	999,	999,	1.66,	2,	0 };
            double loading_injections_84 [] = {84,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.68,	1,	1,	999,	999,	1.68,	2,	0	 };
            double loading_injections_85 [] = {85,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.7,	999,	999,	1,	1,	999,	999,	1.7,	0,	1	 };
            double loading_injections_86 [] = {	86,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	1,	0.72,	1.72,	2,	0 };
            double loading_injections_87 [] = {	87,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	1,	0.74,	1.74,	2,	0 };
            double loading_injections_88 [] = {	88,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	1,	0.76,	1.76,	2,	0 };
            double loading_injections_89 [] = {89,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	1,	0.78,	1.78,	2,	0	 };
            double loading_injections_90 [] = {	90,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	1,	0.8,	1.8,	0,	1 };
            double loading_injections_91 [] = {	91,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	1,	0.82,	1.82,	2,	0 };
            double loading_injections_92 [] = {	92,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	1,	0.84,	1.84,	2,	0 };
            double loading_injections_93 [] = {93,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	1,	0.86,	1.86,	2,	0	 };
            double loading_injections_94 [] = {	 94,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	1,	0.88,	1.88,	2,	0};
            double loading_injections_95 [] = {	95,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	1,	0.9,	1.9,	0,	1 };
            double loading_injections_96 [] = {	96,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	1,	0.92,	1.92,	2,	0 };
            double loading_injections_97 [] = {	97,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	1,	0.94,	1.94,	2,	0 };
            double loading_injections_98 [] = {	98,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	1,	0.96,	1.96,	2,	0 };
            double loading_injections_99 [] = {	99,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	1,	0.98,	1.98,	2,	0 };
            double loading_injections_100 [] = {100,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	999,	999,	2,	0,	1	 };
            double loading_injections_101 [] = {101,	999,	999,	999,	999,	999,	999,	999,	999,	2,	0.7,	1,	0.62,	999,	999,	999,	999,	2.02,	1,	1	 };
            double loading_injections_102 [] = {102,	999,	999,	999,	999,	999,	999,	999,	999,	2,	0.7,	1,	0.64,	999,	999,	999,	999,	2.04,	1,	1	 };
            double loading_injections_103 [] = {	103,	999,	999,	999,	999,	999,	999,	999,	999,	2,	0.7,	1,	0.66,	999,	999,	999,	999,	2.06,	1,	1 };
            double loading_injections_104 [] = {	104,	999,	999,	999,	999,	999,	999,	999,	999,	2,	0.7,	1,	0.68,	999,	999,	999,	999,	2.08,	1,	1 };
            double loading_injections_105 [] = {105,	999,	999,	999,	999,	999,	999,	999,	999,	3,	0.7,	999,	999,	999,	999,	999,	999,	2.1,	1,	1	 };
            double loading_injections_106 [] = {106,	999,	999,	1,	0.6,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	999,	999,	2.6,	1,	1	 };
            double loading_injections_107 [] = {107,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	999,	999,	2.7,	1,	1	 };
            double loading_injections_108 [] = {108,	999,	999,	1,	0.8,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	999,	999,	2.8,	1,	1	 };
            double loading_injections_109 [] = {109,	999,	999,	1,	0.9,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	999,	999,	2.9,	1,	1	 };
            double loading_injections_110 [] = {110,	1,	1,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	999,	999,	3,	1,	1	 };
            double loading_injections_111 [] = {111,	999,	999,	999,	999,	999,	999,	1,	0.22,	999,	999,	999,	999,	2,	1,	999,	999,	2.22,	1,	1	 };
            double loading_injections_112 [] = {112,	999,	999,	999,	999,	999,	999,	1,	0.24,	999,	999,	999,	999,	2,	1,	999,	999,	2.24,	1,	1	 };
            double loading_injections_113 [] = {113,	999,	999,	999,	999,	999,	999,	1,	0.26,	999,	999,	999,	999,	2,	1,	999,	999,	2.26,	1,	1	 };
            double loading_injections_114 [] = {114,	999,	999,	999,	999,	999,	999,	1,	0.28,	999,	999,	999,	999,	2,	1,	999,	999,	2.28,	1,	1	 };
            double loading_injections_115 [] = {115,	999,	999,	999,	999,	999,	999,	1,	0.3,	999,	999,	999,	999,	2,	1,	999,	999,	2.3,	1,	1	 };
            double loading_injections_116 [] = {116,	999,	999,	999,	999,	999,	999,	1,	0.32,	999,	999,	999,	999,	2,	1,	999,	999,	2.32,	1,	1	 };
            double loading_injections_117 [] = {	117,	999,	999,	999,	999,	999,	999,	1,	0.34,	999,	999,	999,	999,	2,	1,	999,	999,	2.34,	1,	1 };
            double loading_injections_118 [] = {118,	999,	999,	999,	999,	999,	999,	1,	0.36,	999,	999,	999,	999,	2,	1,	999,	999,	2.36,	1,	1	 };
            double loading_injections_119 [] = {119,	999,	999,	999,	999,	999,	999,	1,	0.38,	999,	999,	999,	999,	2,	1,	999,	999,	2.38,	1,	1	 };
            double loading_injections_120 [] = {120,	999,	999,	999,	999,	1,	0.4,	999,	999,	999,	999,	999,	999,	2,	1,	999,	999,	2.4,	1,	1	 };
            double loading_injections_121 [] = {	121,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.42,	2,	1,	999,	999,	2.42,	1,	1 };
            double loading_injections_122 [] = {122,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.44,	2,	1,	999,	999,	2.44,	1,	1	 };
            double loading_injections_123 [] = {123,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.46,	2,	1,	999,	999,	2.46,	1,	1	 };
            double loading_injections_124 [] = {	124,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.48,	2,	1,	999,	999,	2.48,	1,	1 };
            double loading_injections_125 [] = {125,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.5,	2,	1,	999,	999,	2.5,	1,	1	 };
            double loading_injections_126 [] = {	126,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.52,	2,	1,	999,	999,	2.52,	1,	1 };
            double loading_injections_127 [] = {127,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.54,	2,	1,	999,	999,	2.54,	1,	1	 };
            double loading_injections_128 [] = {128,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.56,	2,	1,	999,	999,	2.56,	1,	1	 };
            double loading_injections_129 [] = {129,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.58,	2,	1,	999,	999,	2.58,	1,	1	 };
            double loading_injections_130 [] = {130,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.6,	2,	1,	999,	999,	2.6,	1,	1	 };
            double loading_injections_131 [] = {	131,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.62,	2,	1,	999,	999,	2.62,	1,	1 };
            double loading_injections_132 [] = {132,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.64,	2,	1,	999,	999,	2.64,	1,	1	 };
            double loading_injections_133 [] = {133,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.66,	2,	1,	999,	999,	2.66,	1,	1	 };
            double loading_injections_134 [] = {134,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.68,	2,	1,	999,	999,	2.68,	1,	1	 };
            double loading_injections_135 [] = {	135,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.7,	999,	999,	2,	1,	999,	999,	2.7,	1,	1 };
            double loading_injections_136 [] = {136,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	1,	0.72,	2.72,	1,	1	 };
            double loading_injections_137 [] = {137,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	1,	0.74,	2.74,	1,	1	 };
            double loading_injections_138 [] = {138,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	1,	0.76,	2.76,	1,	1	 };
            double loading_injections_139 [] = {139,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	1,	0.78,	2.78,	1,	1	 };
            double loading_injections_140 [] = {	140,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	1,	0.8,	2.8,	1,	1 };
            double loading_injections_141 [] = {141,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	1,	0.82,	2.82,	1,	1	 };
            double loading_injections_142 [] = {142,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	1,	0.84,	2.84,	1,	1	 };
            double loading_injections_143 [] = {143,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	1,	0.86,	2.86,	1,	1	 };
            double loading_injections_144 [] = {144,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	1,	0.88,	2.88,	1,	1	 };
            double loading_injections_145 [] = {145,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	1,	0.9,	2.9,	1,	1	 };
            double loading_injections_146 [] = {146,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	1,	0.92,	2.92,	1,	1	 };
            double loading_injections_147 [] = {147,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	1,	0.94,	2.94,	1,	1	 };
            double loading_injections_148 [] = {	148,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	1,	0.96,	2.96,	1,	1 };
            double loading_injections_149 [] = {	149,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	1,	0.98,	2.98,	1,	1 };
            double loading_injections_150 [] = {150,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	3,	1,	999,	999,	3,	1,	1	 };






            if (kilo==3  ){

                aranacak_dizi = loading_injections_3;


            }
            else  if (kilo == 4 ){

                aranacak_dizi = loading_injections_4;

            }
            else  if (kilo == 5 ){

                aranacak_dizi = loading_injections_5;

            }
            else  if (kilo == 6 ){

                aranacak_dizi = loading_injections_6;

            }
            else  if (kilo == 7 ){

                aranacak_dizi = loading_injections_7;

            }
            else  if (kilo == 8 ){

                aranacak_dizi = loading_injections_8;

            }
            else  if (kilo == 9 ){

                aranacak_dizi = loading_injections_9;

            }
            else  if (kilo == 10 ){

                aranacak_dizi = loading_injections_10;

            }
            else  if (kilo == 11 ){

                aranacak_dizi = loading_injections_11;

            }
            else  if (kilo == 12 ){

                aranacak_dizi = loading_injections_12;

            }
            else  if (kilo == 13 ){

                aranacak_dizi = loading_injections_13;

            }
            else  if (kilo == 14 ){

                aranacak_dizi = loading_injections_14;

            }
            else  if (kilo == 15 ){

                aranacak_dizi = loading_injections_15;



            }
            else  if (kilo == 16 ){

                aranacak_dizi = loading_injections_16;



            } else  if (kilo == 17 ){

                aranacak_dizi = loading_injections_17;



            } else  if (kilo == 18 ){

                aranacak_dizi = loading_injections_18;



            } else  if (kilo == 19 ){

                aranacak_dizi = loading_injections_19;



            } else  if (kilo == 20 ){

                aranacak_dizi = loading_injections_20;



            } else  if (kilo == 21 ){

                aranacak_dizi = loading_injections_21;



            } else  if (kilo == 22 ){

                aranacak_dizi = loading_injections_22;



            } else  if (kilo == 23 ){

                aranacak_dizi = loading_injections_23;



            } else  if (kilo == 24 ){

                aranacak_dizi = loading_injections_24;



            } else  if (kilo == 25 ){

                aranacak_dizi = loading_injections_25;



            } else  if (kilo == 26 ){

                aranacak_dizi = loading_injections_26;



            } else  if (kilo == 27 ){

                aranacak_dizi = loading_injections_27;



            } else  if (kilo == 28 ){

                aranacak_dizi = loading_injections_28;



            } else  if (kilo == 29 ){

                aranacak_dizi = loading_injections_29;



            } else  if (kilo == 30 ){

                aranacak_dizi = loading_injections_30;



            } else  if (kilo == 31 ){

                aranacak_dizi = loading_injections_31;



            } else  if (kilo == 32 ){

                aranacak_dizi = loading_injections_32;



            } else  if (kilo == 33 ){

                aranacak_dizi = loading_injections_33;



            } else  if (kilo == 34 ){

                aranacak_dizi = loading_injections_34;



            } else  if (kilo == 35 ){

                aranacak_dizi = loading_injections_35;



            } else  if (kilo == 36 ){

                aranacak_dizi = loading_injections_36;



            } else  if (kilo == 37 ){

                aranacak_dizi = loading_injections_37;



            } else  if (kilo == 38 ){

                aranacak_dizi = loading_injections_38;



            } else  if (kilo == 39 ){

                aranacak_dizi = loading_injections_39;



            } else  if (kilo == 40 ){

                aranacak_dizi = loading_injections_40;



            } else  if (kilo == 41 ){

                aranacak_dizi = loading_injections_41;



            } else  if (kilo == 42 ){

                aranacak_dizi = loading_injections_42;



            } else  if (kilo == 43 ){

                aranacak_dizi = loading_injections_43;



            } else  if (kilo == 44 ){

                aranacak_dizi = loading_injections_44;



            } else  if (kilo == 45 ){

                aranacak_dizi = loading_injections_45;



            } else  if (kilo == 46 ){

                aranacak_dizi = loading_injections_46;



            } else  if (kilo == 47 ){

                aranacak_dizi = loading_injections_47;



            } else  if (kilo == 48 ){

                aranacak_dizi = loading_injections_48;



            } else  if (kilo == 49 ){

                aranacak_dizi = loading_injections_49;



            } else  if (kilo == 50 ){

                aranacak_dizi = loading_injections_50;



            } else  if (kilo == 51 ){

                aranacak_dizi = loading_injections_51;



            } else  if (kilo == 52 ){

                aranacak_dizi = loading_injections_52;



            } else  if (kilo == 53 ){

                aranacak_dizi = loading_injections_53;



            } else  if (kilo == 54 ){

                aranacak_dizi = loading_injections_54;



            } else  if (kilo == 55 ){

                aranacak_dizi = loading_injections_55;



            } else  if (kilo == 56 ){

                aranacak_dizi = loading_injections_56;



            } else  if (kilo == 57 ){

                aranacak_dizi = loading_injections_57;



            } else  if (kilo == 58 ){

                aranacak_dizi = loading_injections_58;



            } else  if (kilo == 59 ){

                aranacak_dizi = loading_injections_59;



            } else  if (kilo == 60 ){

                aranacak_dizi = loading_injections_60;



            } else  if (kilo == 61 ){

                aranacak_dizi = loading_injections_61;



            } else  if (kilo == 62 ){

                aranacak_dizi = loading_injections_62;



            } else  if (kilo == 63 ){

                aranacak_dizi = loading_injections_63;



            } else  if (kilo == 64 ){

                aranacak_dizi = loading_injections_64;



            } else  if (kilo == 65 ){

                aranacak_dizi = loading_injections_65;



            } else  if (kilo == 66 ){

                aranacak_dizi = loading_injections_66;



            } else  if (kilo == 67 ){

                aranacak_dizi = loading_injections_67;



            } else  if (kilo == 68 ){

                aranacak_dizi = loading_injections_68;



            } else  if (kilo == 69 ){

                aranacak_dizi = loading_injections_69;



            } else  if (kilo == 70 ){

                aranacak_dizi = loading_injections_70;



            } else  if (kilo == 71 ){

                aranacak_dizi = loading_injections_71;



            } else  if (kilo == 72 ){

                aranacak_dizi = loading_injections_72;



            } else  if (kilo == 73 ){

                aranacak_dizi = loading_injections_73;



            } else  if (kilo == 74 ){

                aranacak_dizi = loading_injections_74;



            } else  if (kilo == 75 ){

                aranacak_dizi = loading_injections_75;



            } else  if (kilo == 76 ){

                aranacak_dizi = loading_injections_76;



            } else  if (kilo == 77 ){

                aranacak_dizi = loading_injections_77;



            } else  if (kilo == 78 ){

                aranacak_dizi = loading_injections_78;



            } else  if (kilo == 79 ){

                aranacak_dizi = loading_injections_79;



            } else  if (kilo == 80 ){

                aranacak_dizi = loading_injections_80;



            } else  if (kilo == 81 ){

                aranacak_dizi = loading_injections_81;



            } else  if (kilo == 82 ){

                aranacak_dizi = loading_injections_82;



            } else  if (kilo == 83 ){

                aranacak_dizi = loading_injections_83;



            } else  if (kilo == 84 ){

                aranacak_dizi = loading_injections_84;



            } else  if (kilo == 85 ){

                aranacak_dizi = loading_injections_85;



            } else  if (kilo == 86 ){

                aranacak_dizi = loading_injections_86;



            } else  if (kilo == 87 ){

                aranacak_dizi = loading_injections_87;



            } else  if (kilo == 88 ){

                aranacak_dizi = loading_injections_88;



            }

            else  if (kilo == 89 ){

                aranacak_dizi = loading_injections_89;



            }
            else  if (kilo == 90 ){

                aranacak_dizi = loading_injections_90;



            }else  if (kilo == 91 ){

                aranacak_dizi = loading_injections_91;



            }else  if (kilo == 92 ){

                aranacak_dizi = loading_injections_92;



            }else  if (kilo == 93 ){

                aranacak_dizi = loading_injections_93;



            }else  if (kilo == 94 ){

                aranacak_dizi = loading_injections_94;



            }else  if (kilo == 95 ){

                aranacak_dizi = loading_injections_95;



            }else  if (kilo == 96 ){

                aranacak_dizi = loading_injections_96;



            }else  if (kilo == 97 ){

                aranacak_dizi = loading_injections_97;



            }else  if (kilo == 98 ){

                aranacak_dizi = loading_injections_98;



            }else  if (kilo == 99 ){

                aranacak_dizi = loading_injections_99;



            }else  if (kilo == 100 ){

                aranacak_dizi = loading_injections_100;



            }else  if (kilo == 101 ){

                aranacak_dizi = loading_injections_101;



            }else  if (kilo == 102 ){

                aranacak_dizi = loading_injections_102;



            }else  if (kilo == 103 ){

                aranacak_dizi = loading_injections_103;



            }else  if (kilo == 104 ){

                aranacak_dizi = loading_injections_104;



            }else  if (kilo == 105 ){

                aranacak_dizi = loading_injections_105;



            }else  if (kilo == 106 ){

                aranacak_dizi = loading_injections_106;



            }else  if (kilo == 107 ){

                aranacak_dizi = loading_injections_107;



            }else  if (kilo == 108 ){

                aranacak_dizi = loading_injections_108;



            }else  if (kilo == 109 ){

                aranacak_dizi = loading_injections_109;



            }else  if (kilo == 110 ){

                aranacak_dizi = loading_injections_110;



            }else  if (kilo == 111 ){

                aranacak_dizi = loading_injections_111;



            }else  if (kilo == 112 ){

                aranacak_dizi = loading_injections_112;



            }else  if (kilo == 113 ){

                aranacak_dizi = loading_injections_113;



            }else  if (kilo == 114 ){

                aranacak_dizi = loading_injections_114;



            }else  if (kilo == 115 ){

                aranacak_dizi = loading_injections_115;



            }else  if (kilo == 116 ){

                aranacak_dizi = loading_injections_116;



            }else  if (kilo == 117 ){

                aranacak_dizi = loading_injections_117;



            }else  if (kilo == 118 ){

                aranacak_dizi = loading_injections_118;



            }else  if (kilo == 119 ){

                aranacak_dizi = loading_injections_119;



            }else  if (kilo == 120 ){

                aranacak_dizi = loading_injections_120;



            }else  if (kilo == 121 ){

                aranacak_dizi = loading_injections_121;



            }else  if (kilo == 122 ){

                aranacak_dizi = loading_injections_122;



            }else  if (kilo == 123 ){

                aranacak_dizi = loading_injections_123;



            }else  if (kilo == 124 ){

                aranacak_dizi = loading_injections_124;



            }else  if (kilo == 125 ){

                aranacak_dizi = loading_injections_125;



            }else  if (kilo == 126 ){

                aranacak_dizi = loading_injections_126;



            }else  if (kilo == 127 ){

                aranacak_dizi = loading_injections_127;



            }else  if (kilo == 128 ){

                aranacak_dizi = loading_injections_128;



            }else  if (kilo == 129 ){

                aranacak_dizi = loading_injections_129;



            }else  if (kilo == 130 ){

                aranacak_dizi = loading_injections_130;



            }else  if (kilo == 131 ){

                aranacak_dizi = loading_injections_131;



            }else  if (kilo == 132 ){

                aranacak_dizi = loading_injections_132;



            }else  if (kilo == 133 ){

                aranacak_dizi = loading_injections_133;



            }else  if (kilo == 134 ){

                aranacak_dizi = loading_injections_134;



            }else  if (kilo == 135 ){

                aranacak_dizi = loading_injections_135;



            }else  if (kilo == 136 ){

                aranacak_dizi = loading_injections_136;



            }else  if (kilo == 137 ){

                aranacak_dizi = loading_injections_137;



            }else  if (kilo == 138 ){

                aranacak_dizi = loading_injections_138;



            }else  if (kilo == 139 ){

                aranacak_dizi = loading_injections_139;



            }else  if (kilo == 140 ){

                aranacak_dizi = loading_injections_140;



            }else  if (kilo == 141 ){

                aranacak_dizi = loading_injections_141;



            }else  if (kilo == 142 ){

                aranacak_dizi = loading_injections_142;



            }else  if (kilo == 143 ){

                aranacak_dizi = loading_injections_143;



            }else  if (kilo == 144 ){

                aranacak_dizi = loading_injections_144;



            }else  if (kilo == 145 ){

                aranacak_dizi = loading_injections_145;



            }else  if (kilo == 146 ){

                aranacak_dizi = loading_injections_146;



            }else  if (kilo == 147 ){

                aranacak_dizi = loading_injections_147;



            }else  if (kilo == 148 ){

                aranacak_dizi = loading_injections_148;



            }else  if (kilo == 149 ){

                aranacak_dizi = loading_injections_149;



            }else  if (kilo == 150 ){

                aranacak_dizi = loading_injections_150;



            }












            if (aranacak_dizi[1] != 999 || aranacak_dizi[3] != 999  ) {


                total_volume_değeri = String.valueOf(aranacak_dizi[17]);

                bir_mg_syringe_değeri = String.valueOf(aranacak_dizi[18]);

                iki_üç_syringe_değeri = String.valueOf(aranacak_dizi[19]);




                if (aranacak_dizi[1] != 999){


                    sky_blue_vial_değeri = String.valueOf(aranacak_dizi[1]);

                    sky_blue_volume_değeri =  String.valueOf(aranacak_dizi[2]);



                }
                else if (aranacak_dizi[3] != 999){

                    sky_blue_vial_değeri = String.valueOf(aranacak_dizi[3]);

                    sky_blue_volume_değeri =  String.valueOf(aranacak_dizi[4]);

                }
                else  if(aranacak_dizi[1] != 999 || aranacak_dizi[3] != 999 ){


                    sky_blue_vial_değeri = String.valueOf(aranacak_dizi[1] + (aranacak_dizi[3]));

                    sky_blue_volume_değeri =  String.valueOf((aranacak_dizi[1]*aranacak_dizi[2]) + aranacak_dizi[3]*aranacak_dizi[4]);

                }


                Log.e("lOOOOG", "İlaç adı: Sky Blue"+ " Dose: 30 mg "+  "Vial dğeri: "+sky_blue_vial_değeri+"Volume değeri: "+sky_blue_volume_değeri+" Total dose "+ String.valueOf(kilo*3)+" Total Volume: "+ String.valueOf(aranacak_dizi[17]) +" 1 mg Syringe: "+ String.valueOf(aranacak_dizi[18])+" 2 or 3 mg Syringe: "+String.valueOf(aranacak_dizi[19]));



                ilaç_harf_1 = "S";




            }
            else{


                Log.e("lOOOOG", "İlaç adı: Sky blue DEĞİİL");

            }







            if (aranacak_dizi[5] != 999 || aranacak_dizi[7] != 999  ) {



                total_volume_değeri = String.valueOf(aranacak_dizi[17]);

                bir_mg_syringe_değeri = String.valueOf(aranacak_dizi[18]);

                iki_üç_syringe_değeri = String.valueOf(aranacak_dizi[19]);




                if (aranacak_dizi[5] != 999){



                    if(aranacak_dizi[5] != 999 && aranacak_dizi[7] != 999 ){


                        purple_vial_değeri = String.valueOf(aranacak_dizi[5] + (aranacak_dizi[7]));

                        purple_volume_değeri = String.valueOf(aranacak_dizi[17]);

                    }
                    else {

                        purple_vial_değeri = String.valueOf(aranacak_dizi[5]);

                        purple_volume_değeri =  String.valueOf(aranacak_dizi[6]);


                    }


                }
                else if (aranacak_dizi[7] != 999){


                    if(aranacak_dizi[5] != 999 && aranacak_dizi[7] != 999 ){


                        purple_vial_değeri = String.valueOf(aranacak_dizi[5] + (aranacak_dizi[7]));

                        purple_volume_değeri = String.valueOf(aranacak_dizi[17]);

                    }
                    else {

                        purple_vial_değeri = String.valueOf(aranacak_dizi[7]);

                        purple_volume_değeri =  String.valueOf(aranacak_dizi[8]);


                    }

                }



                Log.e("lOOOOG", "İlaç adı: Purple,   "+ " Dose: 60 mg,   "+ "Vial dğeri: "+vial_değeri+ "   Amount değeri: "+volume_değeri+", Total dose "+ String.valueOf(kilo*3)+" Total Volume: "+ String.valueOf(aranacak_dizi[17]) +" 1 mg Syringe: "+ String.valueOf(aranacak_dizi[18])+" 2 or 3 mg Syringe: "+String.valueOf(aranacak_dizi[19]));

                ilaç_harf_2 = "P";


            }
            else{


                Log.e("lOOOOG", "İlaç adı: Purple DEĞİİL");

            }










            if (aranacak_dizi[9] != 999 || aranacak_dizi[11] != 999  ) {



                total_volume_değeri = String.valueOf(aranacak_dizi[17]);

                bir_mg_syringe_değeri = String.valueOf(aranacak_dizi[18]);

                iki_üç_syringe_değeri = String.valueOf(aranacak_dizi[19]);





                if (aranacak_dizi[9] != 999){



                    if(aranacak_dizi[9] != 999 && aranacak_dizi[11] != 999 ){


                        turquoise_vial_değeri = String.valueOf(aranacak_dizi[9] + (aranacak_dizi[11]));

                        turquoise_volume_değeri = String.valueOf(aranacak_dizi[17]);

                    }
                    else {

                        turquoise_vial_değeri = String.valueOf(aranacak_dizi[9]);

                        turquoise_volume_değeri =  String.valueOf(aranacak_dizi[10]);


                    }


                }
                else if (aranacak_dizi[11] != 999){


                    if(aranacak_dizi[9] != 999 && aranacak_dizi[11] != 999 ){


                        turquoise_vial_değeri = String.valueOf(aranacak_dizi[9] + (aranacak_dizi[11]));

                        turquoise_volume_değeri = String.valueOf(aranacak_dizi[17]);

                    }
                    else {

                        turquoise_vial_değeri = String.valueOf(aranacak_dizi[11]);

                        turquoise_volume_değeri =  String.valueOf(aranacak_dizi[12]);


                    }

                }



                Log.e("lOOOOG", "İlaç adı: Turquoise,   "+ " Dose: 60 mg,   "+ "Vial dğeri: "+vial_değeri+ "   Amount değeri: "+volume_değeri+", Total dose "+ String.valueOf(kilo*3)+" Total Volume: "+ String.valueOf(aranacak_dizi[17]) +" 1 mg Syringe: "+ String.valueOf(aranacak_dizi[18])+" 2 or 3 mg Syringe: "+String.valueOf(aranacak_dizi[19]));

                ilaç_harf_3 = "T";


            }
            else{


                Log.e("lOOOOG", "İlaç adı: Turquoise DEĞİİL");

            }




            if (aranacak_dizi[13] != 999 || aranacak_dizi[15] != 999  ) {



                total_volume_değeri = String.valueOf(aranacak_dizi[17]);

                bir_mg_syringe_değeri = String.valueOf(aranacak_dizi[18]);

                iki_üç_syringe_değeri = String.valueOf(aranacak_dizi[19]);






                if (aranacak_dizi[13] != 999){



                    if(aranacak_dizi[13] != 999 && aranacak_dizi[15] != 999 ){


                        orange_vial_değeri = String.valueOf(aranacak_dizi[13] + (aranacak_dizi[15]));

                        orange_volume_değeri = String.valueOf(aranacak_dizi[17]);

                    }
                    else {

                        orange_vial_değeri = String.valueOf(aranacak_dizi[13]);

                        orange_volume_değeri =  String.valueOf(aranacak_dizi[14]);


                    }


                }
                else if (aranacak_dizi[15] != 999){


                    if(aranacak_dizi[13] != 999 && aranacak_dizi[15] != 999 ){


                        orange_vial_değeri = String.valueOf(aranacak_dizi[13] + (aranacak_dizi[15]));

                        orange_volume_değeri = String.valueOf(aranacak_dizi[17]);

                    }
                    else {

                        orange_vial_değeri = String.valueOf(aranacak_dizi[15]);

                        orange_volume_değeri =  String.valueOf(aranacak_dizi[16]);


                    }

                }



                Log.e("lOOOOG", "İlaç adı: Orange,   "+ " Dose: 150 mg,   "+ "Vial dğeri: "+vial_değeri+ "   Amount değeri: "+volume_değeri+", Total dose "+ String.valueOf(kilo*3)+" Total Volume: "+ String.valueOf(aranacak_dizi[17]) +" 1 mg Syringe: "+ String.valueOf(aranacak_dizi[18])+" 2 or 3 mg Syringe: "+String.valueOf(aranacak_dizi[19]));

                ilaç_harf_4 = "O";


            }
            else{


                Log.e("lOOOOG", "İlaç adı: Orange DEĞİİL");

            }





            ilaç_sıralaması = ilaç_harf_1+ilaç_harf_2+ilaç_harf_3+ilaç_harf_4;

            Toast.makeText(getApplicationContext(),ilaç_sıralaması,Toast.LENGTH_LONG).show();

            Log.e("lOOOOG", ilaç_sıralaması);























            if (ilaç_sıralaması.equals("Syyy")){


                ikinci_ilaç_layout.setVisibility(View.INVISIBLE);
                üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);


                birinci_ilaç_image.setBackgroundResource(R.drawable.pill_sky_blue);
                birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_sky_blue);
                ilaç_adı_1.setText(getString(R.string.SkyBule));


                dose_ml_1.setText(String.valueOf(sky_blue_dose));
                amount_ml_1.setText(String.valueOf(sky_blue_volume_değeri)+" mL");
                form_vial_1.setText(String.valueOf(sky_blue_vial_değeri)+" Vial");

                total_dose_textview.setText(String.valueOf(total_dose_değeri)+" mG");
                total_volume_textview.setText(String.valueOf(total_volume_değeri+" mL"));

                bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe_değeri));
                iki_uc_syringe_textview.setText(String.valueOf(iki_üç_syringe_değeri));


            }
            else if (ilaç_sıralaması.equals("yPyy")){



                ikinci_ilaç_layout.setVisibility(View.INVISIBLE);
                üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);


                birinci_ilaç_image.setBackgroundResource(R.drawable.pill_purple);
                birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_purple);
                ilaç_adı_1.setText(getString(R.string.Purple));


                dose_ml_1.setText(String.valueOf(purple_dose));
                amount_ml_1.setText(String.valueOf(purple_volume_değeri)+" mL");
                form_vial_1.setText(String.valueOf(purple_vial_değeri)+" Vial");

                total_dose_textview.setText(String.valueOf(total_dose_değeri)+" mG");
                total_volume_textview.setText(String.valueOf(total_volume_değeri+" mL"));

                bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe_değeri));
                iki_uc_syringe_textview.setText(String.valueOf(iki_üç_syringe_değeri));



            }
            else if (ilaç_sıralaması.equals("SPyy")){




                üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);


                birinci_ilaç_image.setBackgroundResource(R.drawable.pill_sky_blue);
                birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_sky_blue);
                ilaç_adı_1.setText(getString(R.string.SkyBule));


                ikinci_ilaç_image.setBackgroundResource(R.drawable.pill_purple);
                ikinci_ilaç_backgournd.setBackgroundResource(R.drawable.oval_button_purple);
                ilaç_adı_2.setText(getString(R.string.Purple));


                dose_ml_1.setText(String.valueOf(sky_blue_dose));
                amount_ml_1.setText(String.valueOf(sky_blue_volume_değeri)+" mL");
                form_vial_1.setText(String.valueOf(sky_blue_vial_değeri)+" Vial");


                dose_ml_2.setText(String.valueOf(purple_dose));
                amount_ml_2.setText(String.valueOf(purple_volume_değeri)+" mL");
                form_vial_2.setText(String.valueOf(purple_vial_değeri)+" Vial");



                total_dose_textview.setText(String.valueOf(total_dose_değeri)+" mG");
                total_volume_textview.setText(String.valueOf(total_volume_değeri+" mL"));

                bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe_değeri));
                iki_uc_syringe_textview.setText(String.valueOf(iki_üç_syringe_değeri));



            }
            else if (ilaç_sıralaması.equals("yyTy")){


                ikinci_ilaç_layout.setVisibility(View.INVISIBLE);
                üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);


                birinci_ilaç_image.setBackgroundResource(R.drawable.pill_turquoise);
                birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_turquoise);
                ilaç_adı_1.setText(getString(R.string.Turquoise));


                dose_ml_1.setText(String.valueOf(turquoise_dose));
                amount_ml_1.setText(String.valueOf(turquoise_volume_değeri)+" mL");
                form_vial_1.setText(String.valueOf(turquoise_vial_değeri)+" Vial");

                total_dose_textview.setText(String.valueOf(total_dose_değeri)+" mG");
                total_volume_textview.setText(String.valueOf(total_volume_değeri+" mL"));

                bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe_değeri));
                iki_uc_syringe_textview.setText(String.valueOf(iki_üç_syringe_değeri));



            }
            else if (ilaç_sıralaması.equals("SyTy")){




                üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);


                birinci_ilaç_image.setBackgroundResource(R.drawable.pill_sky_blue);
                birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_sky_blue);
                ilaç_adı_1.setText(getString(R.string.SkyBule));


                ikinci_ilaç_image.setBackgroundResource(R.drawable.pill_turquoise);
                ikinci_ilaç_backgournd.setBackgroundResource(R.drawable.oval_button_turquoise);
                ilaç_adı_2.setText(getString(R.string.Turquoise));


                dose_ml_1.setText(String.valueOf(sky_blue_dose));
                amount_ml_1.setText(String.valueOf(sky_blue_volume_değeri)+" mL");
                form_vial_1.setText(String.valueOf(sky_blue_vial_değeri)+" Vial");


                dose_ml_2.setText(String.valueOf(turquoise_dose));
                amount_ml_2.setText(String.valueOf(turquoise_volume_değeri)+" mL");
                form_vial_2.setText(String.valueOf(turquoise_vial_değeri)+" Vial");



                total_dose_textview.setText(String.valueOf(total_dose_değeri)+" mG");
                total_volume_textview.setText(String.valueOf(total_volume_değeri+" mL"));

                bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe_değeri));
                iki_uc_syringe_textview.setText(String.valueOf(iki_üç_syringe_değeri));



            }
            else if (ilaç_sıralaması.equals("yyyO")){



                ikinci_ilaç_layout.setVisibility(View.INVISIBLE);
                üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);


                birinci_ilaç_image.setBackgroundResource(R.drawable.pill_orange);
                birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_orange);
                ilaç_adı_1.setText(getString(R.string.Orange));


                dose_ml_1.setText(String.valueOf(orange_dose));
                amount_ml_1.setText(String.valueOf(orange_volume_değeri)+" mL");
                form_vial_1.setText(String.valueOf(orange_vial_değeri)+" Vial");

                total_dose_textview.setText(String.valueOf(total_dose_değeri)+" mG");
                total_volume_textview.setText(String.valueOf(total_volume_değeri+" mL"));

                bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe_değeri));
                iki_uc_syringe_textview.setText(String.valueOf(iki_üç_syringe_değeri));



            }
            else if (ilaç_sıralaması.equals("yPTy")){


                üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);


                birinci_ilaç_image.setBackgroundResource(R.drawable.pill_purple);
                birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_purple);
                ilaç_adı_1.setText(getString(R.string.Purple));


                ikinci_ilaç_image.setBackgroundResource(R.drawable.pill_turquoise);
                ikinci_ilaç_backgournd.setBackgroundResource(R.drawable.oval_button_turquoise);
                ilaç_adı_2.setText(getString(R.string.Turquoise));


                dose_ml_1.setText(String.valueOf(purple_dose));
                amount_ml_1.setText(String.valueOf(purple_volume_değeri)+" mL");
                form_vial_1.setText(String.valueOf(purple_vial_değeri)+" Vial");


                dose_ml_2.setText(String.valueOf(turquoise_dose));
                amount_ml_2.setText(String.valueOf(turquoise_volume_değeri)+" mL");
                form_vial_2.setText(String.valueOf(turquoise_vial_değeri)+" Vial");



                total_dose_textview.setText(String.valueOf(total_dose_değeri)+" mG");
                total_volume_textview.setText(String.valueOf(total_volume_değeri+" mL"));

                bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe_değeri));
                iki_uc_syringe_textview.setText(String.valueOf(iki_üç_syringe_değeri));




            }
            else if (ilaç_sıralaması.equals("SyyO")){




                üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);


                birinci_ilaç_image.setBackgroundResource(R.drawable.pill_sky_blue);
                birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_sky_blue);
                ilaç_adı_1.setText(getString(R.string.SkyBule));


                ikinci_ilaç_image.setBackgroundResource(R.drawable.pill_orange);
                ikinci_ilaç_backgournd.setBackgroundResource(R.drawable.oval_button_orange);
                ilaç_adı_2.setText(getString(R.string.Orange));


                dose_ml_1.setText(String.valueOf(sky_blue_dose));
                amount_ml_1.setText(String.valueOf(sky_blue_volume_değeri)+" mL");
                form_vial_1.setText(String.valueOf(sky_blue_vial_değeri)+" Vial");


                dose_ml_2.setText(String.valueOf(orange_dose));
                amount_ml_2.setText(String.valueOf(orange_volume_değeri)+" mL");
                form_vial_2.setText(String.valueOf(orange_vial_değeri)+" Vial");



                total_dose_textview.setText(String.valueOf(total_dose_değeri)+" mG");
                total_volume_textview.setText(String.valueOf(total_volume_değeri+" mL"));

                bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe_değeri));
                iki_uc_syringe_textview.setText(String.valueOf(iki_üç_syringe_değeri));





            }
            else if (ilaç_sıralaması.equals("SPTy")){






                birinci_ilaç_image.setBackgroundResource(R.drawable.pill_sky_blue);
                birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_sky_blue);
                ilaç_adı_1.setText(getString(R.string.SkyBule));


                ikinci_ilaç_image.setBackgroundResource(R.drawable.pill_purple);
                ikinci_ilaç_backgournd.setBackgroundResource(R.drawable.oval_button_purple);
                ilaç_adı_2.setText(getString(R.string.Purple));


                üçüncü_ilaç_image.setBackgroundResource(R.drawable.pill_turquoise);
                üçüncü_ilaç_backgournd.setBackgroundResource(R.drawable.oval_button_turquoise);
                ilaç_adı_3.setText(getString(R.string.Turquoise));

                dose_ml_1.setText(String.valueOf(sky_blue_dose));
                amount_ml_1.setText(String.valueOf(sky_blue_volume_değeri)+" mL");
                form_vial_1.setText(String.valueOf(sky_blue_vial_değeri)+" Vial");


                dose_ml_2.setText(String.valueOf(purple_dose));
                amount_ml_2.setText(String.valueOf(purple_volume_değeri)+" mL");
                form_vial_2.setText(String.valueOf(purple_vial_değeri)+" Vial");



                dose_ml_3.setText(String.valueOf(turquoise_dose));
                amount_ml_3.setText(String.valueOf(turquoise_volume_değeri)+" mL");
                form_vial_3.setText(String.valueOf(turquoise_vial_değeri)+" Vial");



                total_dose_textview.setText(String.valueOf(total_dose_değeri)+" mG");
                total_volume_textview.setText(String.valueOf(total_volume_değeri+" mL"));

                bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe_değeri));
                iki_uc_syringe_textview.setText(String.valueOf(iki_üç_syringe_değeri));



            }

            else if (ilaç_sıralaması.equals("yyTO")){



                üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);


                birinci_ilaç_image.setBackgroundResource(R.drawable.pill_turquoise);
                birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_turquoise);
                ilaç_adı_1.setText(getString(R.string.Turquoise));


                ikinci_ilaç_image.setBackgroundResource(R.drawable.pill_orange);
                ikinci_ilaç_backgournd.setBackgroundResource(R.drawable.oval_button_orange);
                ilaç_adı_2.setText(getString(R.string.Orange));


                dose_ml_1.setText(String.valueOf(turquoise_dose));
                amount_ml_1.setText(String.valueOf(turquoise_volume_değeri)+" mL");
                form_vial_1.setText(String.valueOf(turquoise_vial_değeri)+" Vial");


                dose_ml_2.setText(String.valueOf(orange_dose));
                amount_ml_2.setText(String.valueOf(orange_volume_değeri)+" mL");
                form_vial_2.setText(String.valueOf(orange_vial_değeri)+" Vial");



                total_dose_textview.setText(String.valueOf(total_dose_değeri)+" mG");
                total_volume_textview.setText(String.valueOf(total_volume_değeri+" mL"));

                bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe_değeri));
                iki_uc_syringe_textview.setText(String.valueOf(iki_üç_syringe_değeri));



            }

            else if (ilaç_sıralaması.equals("yPyO")){



                üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);


                birinci_ilaç_image.setBackgroundResource(R.drawable.pill_purple);
                birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_purple);
                ilaç_adı_1.setText(getString(R.string.Purple));


                ikinci_ilaç_image.setBackgroundResource(R.drawable.pill_orange);
                ikinci_ilaç_backgournd.setBackgroundResource(R.drawable.oval_button_orange);
                ilaç_adı_2.setText(getString(R.string.Orange));


                dose_ml_1.setText(String.valueOf(purple_dose));
                amount_ml_1.setText(String.valueOf(purple_volume_değeri)+" mL");
                form_vial_1.setText(String.valueOf(purple_vial_değeri)+" Vial");


                dose_ml_2.setText(String.valueOf(orange_dose));
                amount_ml_2.setText(String.valueOf(orange_volume_değeri)+" mL");
                form_vial_2.setText(String.valueOf(orange_vial_değeri)+" Vial");



                total_dose_textview.setText(String.valueOf(total_dose_değeri)+" mG");
                total_volume_textview.setText(String.valueOf(total_volume_değeri+" mL"));

                bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe_değeri));
                iki_uc_syringe_textview.setText(String.valueOf(iki_üç_syringe_değeri));



            }







            final ViewTreeObserver vto = birinci_ilaç_layout.getViewTreeObserver();
            vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {

                    int width  = birinci_ilaç_layout.getMeasuredWidth();
                    birinci_ilaç_layout_height = birinci_ilaç_layout.getMeasuredHeight();

                    ikinci_ilaç_layout_height = birinci_ilaç_layout.getMeasuredHeight();


                    üçüncü_ilaç_layout_height = birinci_ilaç_layout.getMeasuredHeight();


                    text_layout_height = text_layout.getMeasuredHeight();


                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );





                    if (ilaç_sıralaması.equals("Syyy")){



                        params.setMargins(0, -( ikinci_ilaç_layout_height+üçüncü_ilaç_layout_height + 60), 0, 0);
                        text_layout.setLayoutParams(params);


                    }
                    else if (ilaç_sıralaması.equals("yPyy")){


                        params.setMargins(0, -( ikinci_ilaç_layout_height+üçüncü_ilaç_layout_height + 60), 0, 0);
                        text_layout.setLayoutParams(params);

                    }
                    else if (ilaç_sıralaması.equals("SPyy")){

                        params.setMargins(0, -( üçüncü_ilaç_layout_height + 60), 0, 0);
                        text_layout.setLayoutParams(params);



                    }
                    else if (ilaç_sıralaması.equals("yyTy")){


                        params.setMargins(0, -( ikinci_ilaç_layout_height+üçüncü_ilaç_layout_height + 60), 0, 0);
                        text_layout.setLayoutParams(params);

                    }
                    else if (ilaç_sıralaması.equals("SyTy")){


                        params.setMargins(0, -( üçüncü_ilaç_layout_height + 60), 0, 0);
                        text_layout.setLayoutParams(params);


                    }
                    else if (ilaç_sıralaması.equals("yyyO")){

                        params.setMargins(0, -( ikinci_ilaç_layout_height+üçüncü_ilaç_layout_height + 60), 0, 0);
                        text_layout.setLayoutParams(params);


                    }
                    else if (ilaç_sıralaması.equals("yPTy")){

                        params.setMargins(0, -( üçüncü_ilaç_layout_height + 60), 0, 0);
                        text_layout.setLayoutParams(params);



                    }
                    else if (ilaç_sıralaması.equals("SyyO")){
                        params.setMargins(0, -( üçüncü_ilaç_layout_height + 60), 0, 0);
                        text_layout.setLayoutParams(params);



                    }
                    else if (ilaç_sıralaması.equals("SPTy")){

                        params.setMargins(0, 0, 0, 0);
                        text_layout.setLayoutParams(params);



                    }
                    else if (ilaç_sıralaması.equals("yPTy")){

                        params.setMargins(0, -( üçüncü_ilaç_layout_height + 60), 0, 0);
                        text_layout.setLayoutParams(params);



                    }
                    else if (ilaç_sıralaması.equals("yyTO")){

                        params.setMargins(0, -( üçüncü_ilaç_layout_height + 60), 0, 0);
                        text_layout.setLayoutParams(params);



                    }
                    else if (ilaç_sıralaması.equals("yPyO")){

                        params.setMargins(0, -( üçüncü_ilaç_layout_height + 60), 0, 0);
                        text_layout.setLayoutParams(params);

                    }












                }
            });

















            administrations_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });



        Button menu_button=findViewById(R.id.menu_button);
        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDrawerLayout.openDrawer(Gravity.RIGHT);






            }
        });



        information_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),Information.class);
                i.putExtra("key",1);
                startActivity(i);
                mDrawerLayout.closeDrawer(Gravity.RIGHT);





            }
        });




        log_out_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),Login.class);
                startActivity(i);
                mDrawerLayout.closeDrawer(Gravity.RIGHT);

                FirebaseAuth.getInstance().signOut();




            }
        });



        administrations_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),Administration.class);
                startActivity(i);
                mDrawerLayout.closeDrawer(Gravity.RIGHT);





            }
        });




















        Typeface Trade_Gothic_Bold = Typeface.createFromAsset(getAssets(),  "font/trade_gothic_bold.ttf");
        exaple.setTypeface(Trade_Gothic_Bold);
        vıal_com.setTypeface(Trade_Gothic_Bold);
        inj_text.setTypeface(Trade_Gothic_Bold);

        ilaç_adı_1.setTypeface(Trade_Gothic_Bold);
        dose_1.setTypeface(Trade_Gothic_Bold);
        amount_1.setTypeface(Trade_Gothic_Bold);
        form_1.setTypeface(Trade_Gothic_Bold);
        dose_ml_1.setTypeface(Trade_Gothic_Bold);
        amount_ml_1.setTypeface(Trade_Gothic_Bold);
        form_vial_1.setTypeface(Trade_Gothic_Bold);
        ilaç_adı_2.setTypeface(Trade_Gothic_Bold);
        dose_2.setTypeface(Trade_Gothic_Bold);
        amount_2.setTypeface(Trade_Gothic_Bold);
        form_2.setTypeface(Trade_Gothic_Bold);
        dose_ml_2.setTypeface(Trade_Gothic_Bold);
        amount_ml_2.setTypeface(Trade_Gothic_Bold);
        form_vial_2.setTypeface(Trade_Gothic_Bold);
        ilaç_adı_3.setTypeface(Trade_Gothic_Bold);
        dose_3.setTypeface(Trade_Gothic_Bold);
        amount_3.setTypeface(Trade_Gothic_Bold);
        form_3.setTypeface(Trade_Gothic_Bold);
        dose_ml_3.setTypeface(Trade_Gothic_Bold);
        amount_ml_3.setTypeface(Trade_Gothic_Bold);
        form_vial_3.setTypeface(Trade_Gothic_Bold);












      /*  if ( kilo>=0 && kilo<=10){

            total_dose=kilo*3;

            vial=1;

            amount=1.0;

            volume_1=total_dose/30.0;


            total_volume=volume_1+volume_2+volume_3;

            bir_mg_syringe=1;


            iki_uc_mg_syringe=0;

            dose_int_1=30;

            ilaç_adı_1.setText(getString(R.string.SkyBule));

            dose_ml_1.setText(String.valueOf(dose_int_1)+" mg");
            amount_ml_1.setText(String.valueOf(amount)+" mL");
            form_vial_1.setText(String.valueOf(vial)+" Vial");
            total_dose_textview.setText(String.valueOf(total_dose)+" mG");
            total_volume_textview.setText(String.valueOf(total_volume+" mL"));
            bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe));
            iki_uc_syringe_textview.setText(String.valueOf(iki_uc_mg_syringe));


            ikinci_ilaç_layout.setVisibility(View.INVISIBLE);
            üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);

            birinci_ilaç_image.setBackgroundResource(R.drawable.pill_sky_blue);



        }


        if ( kilo>=11 && kilo<=20){

            total_dose=kilo*3;

            vial=1;

            amount=0.4;

            volume_1=total_dose/150.0;


            total_volume=volume_1+volume_2+volume_3;

            bir_mg_syringe=1;


            iki_uc_mg_syringe=0;

            dose_int_2=60;

            ilaç_adı_1.setText(getString(R.string.Purple));

            dose_ml_1.setText(String.valueOf(dose_int_2)+" mg");
            amount_ml_1.setText(String.valueOf(amount)+" mL");
            form_vial_1.setText(String.valueOf(vial)+" Vial");
            total_dose_textview.setText(String.valueOf(total_dose)+" mG");
            total_volume_textview.setText(String.valueOf(total_volume+" mL"));
            bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe));
            iki_uc_syringe_textview.setText(String.valueOf(iki_uc_mg_syringe));


            ikinci_ilaç_layout.setVisibility(View.INVISIBLE);
            üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);

            birinci_ilaç_image.setBackgroundResource(R.drawable.pill_purple);

            birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_purple);






        }



        if ( kilo>=21 && kilo<=30){

            total_dose=kilo*3;

            vial=1;

            amount=1.0;

            volume_1=total_dose/30.0;
            volume_2=total_dose/150.0;
            volume_3=0.0;


            total_volume=0.50+(kilo-21)*0.10;

            bir_mg_syringe=2;


            iki_uc_mg_syringe=0;

            dose_int_1=30;
            dose_int_2=60;

            ilaç_adı_1.setText(getString(R.string.SkyBule));
            ilaç_adı_2.setText(getString(R.string.Purple));

            dose_ml_1.setText(String.valueOf(dose_int_1)+" mg");
            amount_ml_1.setText(String.valueOf(amount)+" mL");
            form_vial_1.setText(String.valueOf(vial)+" Vial");


            double total_volume_düzeltilmiş = Math.floor(total_volume * 100 + 0.5) / 100;


            total_dose_textview.setText(String.valueOf(total_dose)+" mG");
            total_volume_textview.setText(String.valueOf(total_volume_düzeltilmiş+" mL"));
            bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe));
            iki_uc_syringe_textview.setText(String.valueOf(iki_uc_mg_syringe));


            üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);

            birinci_ilaç_image.setBackgroundResource(R.drawable.pill_sky_blue);
            birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_sky_blue);


            ikinci_ilaç_image.setBackgroundResource(R.drawable.pill_purple);
            ikinci_ilaç_backgournd.setBackgroundResource(R.drawable.oval_button_purple);




        }





        if ( kilo>=31 && kilo<=35){

            total_dose=kilo*3;

            vial=1;

            amount=0.7;

            volume_1=total_dose/150.0;


            total_volume=volume_1+volume_2+volume_3;

            bir_mg_syringe=1;


            iki_uc_mg_syringe=0;

            dose_int_1=105;

            ilaç_adı_1.setText(getString(R.string.Turquoise));

            dose_ml_1.setText(String.valueOf(dose_int_1)+" mg");
            amount_ml_1.setText(String.valueOf(amount)+" mL");
            form_vial_1.setText(String.valueOf(vial)+" Vial");
            total_dose_textview.setText(String.valueOf(total_dose)+" mG");
            total_volume_textview.setText(String.valueOf(total_volume+" mL"));
            bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe));
            iki_uc_syringe_textview.setText(String.valueOf(iki_uc_mg_syringe));


            ikinci_ilaç_layout.setVisibility(View.INVISIBLE);
            üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);

            birinci_ilaç_image.setBackgroundResource(R.drawable.pill_turquoise);
            birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_turquoise);




        }




        if ( kilo>=36 && kilo<=40){

            total_dose=kilo*3;

            vial=1;

            amount=0.4;

            volume_1=total_dose/150.0;


            total_volume=volume_1+volume_2+volume_3;

            bir_mg_syringe=1;


            iki_uc_mg_syringe=0;

            dose_int_1=60;

            ilaç_adı_1.setText(getString(R.string.Purple));

            dose_ml_1.setText(String.valueOf(dose_int_1)+" mg");
            amount_ml_1.setText(String.valueOf(amount)+" mL");
            form_vial_1.setText(String.valueOf(vial)+" Vial");
            total_dose_textview.setText(String.valueOf(total_dose)+" mG");
            total_volume_textview.setText(String.valueOf(total_volume+" mL"));
            bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe));
            iki_uc_syringe_textview.setText(String.valueOf(iki_uc_mg_syringe));


            ikinci_ilaç_layout.setVisibility(View.INVISIBLE);
            üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);

            birinci_ilaç_image.setBackgroundResource(R.drawable.pill_purple);

            birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_purple);






        }




        if ( kilo>=41 && kilo<=45){

            total_dose=kilo*3;

            vial=1;

            amount=0.4;

            volume_1=total_dose/150.0;


            total_volume=volume_1+volume_2+volume_3;

            bir_mg_syringe=2;


            iki_uc_mg_syringe=0;

            dose_int_1=30;
            dose_int_2=105;

            ilaç_adı_1.setText(getString(R.string.SkyBule));
            ilaç_adı_2.setText(getString(R.string.Turquoise));


            dose_ml_1.setText(String.valueOf(dose_int_1)+" mg");
            dose_ml_2.setText(String.valueOf(dose_int_2)+" mg");

            amount_ml_1.setText(String.valueOf(amount)+" mL");
            amount_ml_2.setText(String.valueOf(0.7)+" mL");

            form_vial_1.setText(String.valueOf(vial)+" Vial");
            form_vial_2.setText(String.valueOf(vial)+" Vial");

            total_dose_textview.setText(String.valueOf(total_dose)+" mG");

            total_volume=1.30+((kilo-41)*0.10);

            double total_volume_düzeltilmiş = Math.floor(total_volume * 100 + 0.5) / 100;

            total_volume_textview.setText((BigDecimal.valueOf(total_volume_düzeltilmiş)+" mL"));


            bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe));
            iki_uc_syringe_textview.setText(String.valueOf(iki_uc_mg_syringe));


            üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);

            birinci_ilaç_image.setBackgroundResource(R.drawable.pill_sky_blue);
            birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_sky_blue);


            ikinci_ilaç_backgournd.setBackgroundResource(R.drawable.oval_button_turquoise);
            ikinci_ilaç_image.setBackgroundResource(R.drawable.pill_turquoise);





        }




        if ( kilo>=46 && kilo<=50){

            total_dose=kilo*3;

            vial=1;

            amount=1.0;

            volume_1=total_dose/150.0;


            total_volume=volume_1+volume_2+volume_3;

            bir_mg_syringe=1;


            iki_uc_mg_syringe=0;

            dose_int_1=150;

            ilaç_adı_1.setText(getString(R.string.Orange));

            dose_ml_1.setText(String.valueOf(dose_int_1)+" mg");
            amount_ml_1.setText(String.valueOf(amount)+" mL");
            form_vial_1.setText(String.valueOf(vial)+" Vial");
            total_dose_textview.setText(String.valueOf(total_dose)+" mG");
            total_volume_textview.setText(String.valueOf(total_volume+" mL"));
            bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe));
            iki_uc_syringe_textview.setText(String.valueOf(iki_uc_mg_syringe));


            ikinci_ilaç_layout.setVisibility(View.INVISIBLE);
            üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);

            birinci_ilaç_image.setBackgroundResource(R.drawable.pill_orange);

            birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_orange);






        }




        if ( kilo>=51 && kilo<=55){

            total_dose=kilo*3;

            vial=1;

            amount=0.4;

            volume_1=total_dose/150.0;


            total_volume=1.02+(kilo-51)*0.02;

            double total_volume_düzeltilmiş = Math.floor(total_volume * 100 + 0.5) / 100;


            bir_mg_syringe=2;


            iki_uc_mg_syringe=0;

            dose_int_1=60;
            dose_int_2=105;

            ilaç_adı_1.setText(getString(R.string.SkyBule));
            ilaç_adı_2.setText(getString(R.string.Turquoise));


            dose_ml_1.setText(String.valueOf(dose_int_1)+" mg");
            dose_ml_2.setText(String.valueOf(dose_int_2)+" mg");

            amount_ml_1.setText(String.valueOf(amount)+" mL");
            amount_ml_2.setText(String.valueOf(0.7)+" mL");

            form_vial_1.setText(String.valueOf(vial)+" Vial");
            form_vial_2.setText(String.valueOf(vial)+" Vial");

            total_dose_textview.setText(String.valueOf(total_dose)+" mG");

            total_volume_textview.setText(String.valueOf(total_volume_düzeltilmiş+" mL"));


            bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe));
            iki_uc_syringe_textview.setText(String.valueOf(iki_uc_mg_syringe));


            üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);

            birinci_ilaç_image.setBackgroundResource(R.drawable.pill_sky_blue);
            birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_sky_blue);


            ikinci_ilaç_backgournd.setBackgroundResource(R.drawable.oval_button_turquoise);
            ikinci_ilaç_image.setBackgroundResource(R.drawable.pill_turquoise);





        }





        if ( kilo>=56 && kilo<=60){

            total_dose=kilo*3;

            vial=1;

            amount=1.0;

            volume_1=total_dose/150.0;


            total_volume=1.60+(kilo-56)*0.1;

            double total_volume_düzeltilmiş = Math.floor(total_volume * 100 + 0.5) / 100;


            bir_mg_syringe=2;


            iki_uc_mg_syringe=0;

            dose_int_1=30;
            dose_int_2=150;

            ilaç_adı_1.setText(getString(R.string.SkyBule));
            ilaç_adı_2.setText(getString(R.string.Orange));


            dose_ml_1.setText(String.valueOf(dose_int_1)+" mg");
            dose_ml_2.setText(String.valueOf(dose_int_2)+" mg");

            amount_ml_1.setText(String.valueOf(amount)+" mL");
            amount_ml_2.setText(String.valueOf(0.7)+" mL");

            form_vial_1.setText(String.valueOf(vial)+" Vial");
            form_vial_2.setText(String.valueOf(vial)+" Vial");

            total_dose_textview.setText(String.valueOf(total_dose)+" mG");

            total_volume_textview.setText(String.valueOf(total_volume_düzeltilmiş+" mL"));


            bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe));
            iki_uc_syringe_textview.setText(String.valueOf(iki_uc_mg_syringe));


            üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);

            birinci_ilaç_image.setBackgroundResource(R.drawable.pill_sky_blue);
            birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_sky_blue);


            ikinci_ilaç_backgournd.setBackgroundResource(R.drawable.oval_button_orange);
            ikinci_ilaç_image.setBackgroundResource(R.drawable.pill_orange);







        }





        if ( kilo>=61 && kilo<=65){

            total_dose=kilo*3;


            ilaç_adı_1.setText(getString(R.string.SkyBule));
            ilaç_adı_2.setText(getString(R.string.Purple));
            ilaç_adı_3.setText(getString(R.string.Turquoise));



            dose_ml_1.setText(String.valueOf(30)+" mg");
            dose_ml_2.setText(String.valueOf(60)+" mg");
            dose_ml_3.setText(String.valueOf(105)+" mg");


            amount_ml_1.setText(String.valueOf(1.0)+" mL");
            amount_ml_2.setText(String.valueOf(0.4)+" mL");
            amount_ml_3.setText(String.valueOf(0.7)+" mL");


            form_vial_1.setText(String.valueOf(1)+" Vial");
            form_vial_2.setText(String.valueOf(1)+" Vial");
            form_vial_3.setText(String.valueOf(1)+" Vial");

            total_volume=1.70+((kilo-61)*0.1);


            double total_volume_düzeltilmiş = Math.floor(total_volume * 100 + 0.5) / 100;


            total_dose_textview.setText(String.valueOf(total_dose)+" mG");
            total_volume_textview.setText(String.valueOf(total_volume_düzeltilmiş+" mL"));






            bir_mgl_syringe_textview.setText(String.valueOf(1));
            iki_uc_syringe_textview.setText(String.valueOf(0));



            birinci_ilaç_image.setBackgroundResource(R.drawable.pill_sky_blue);
            birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_sky_blue);


            ikinci_ilaç_backgournd.setBackgroundResource(R.drawable.oval_button_purple);
            ikinci_ilaç_image.setBackgroundResource(R.drawable.pill_purple);



            üçüncü_ilaç_backgournd.setBackgroundResource(R.drawable.oval_button_turquoise);
            üçüncü_ilaç_image.setBackgroundResource(R.drawable.pill_turquoise);




        }





        if ( kilo>=66 && kilo<=70){

            total_dose=kilo*3;


            ilaç_adı_1.setText(getString(R.string.Turquoise));


            dose_ml_1.setText(String.valueOf(105)+" mg");


            amount_ml_1.setText(String.valueOf(0.7)+" mL");


            form_vial_1.setText(String.valueOf(1)+" Vial");


            total_volume=1.32+(kilo-66)*0.02;

            double total_volume_düzeltilmiş = Math.floor(total_volume * 100 + 0.5) / 100;


            total_dose_textview.setText(String.valueOf(total_volume_düzeltilmiş)+" mG");
            total_volume_textview.setText(String.valueOf(1.32+((kilo-66)*0.02)+" mL"));


            bir_mgl_syringe_textview.setText(String.valueOf(2));
            iki_uc_syringe_textview.setText(String.valueOf(0));

            if (kilo==70){

                bir_mgl_syringe_textview.setText(String.valueOf(0));
                iki_uc_syringe_textview.setText(String.valueOf(1));
                form_vial_1.setText(String.valueOf(2)+" Vial");


            }


            ikinci_ilaç_layout.setVisibility(View.INVISIBLE);
            üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);




            birinci_ilaç_image.setBackgroundResource(R.drawable.pill_turquoise);
            birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_turquoise);

        }







        if ( kilo>=71 && kilo<=75){

            total_dose=kilo*3;

            vial=2;

            amount=0.4;

            volume_1=total_dose/150.0;



            bir_mg_syringe=2;


            iki_uc_mg_syringe=0;

            dose_int_1=60;
            dose_int_2=105;

            ilaç_adı_1.setText(getString(R.string.Purple));
            ilaç_adı_2.setText(getString(R.string.Turquoise));


            dose_ml_1.setText(String.valueOf(dose_int_1)+" mg");
            dose_ml_2.setText(String.valueOf(dose_int_2)+" mg");

            amount_ml_1.setText(String.valueOf(amount)+" mL");
            amount_ml_2.setText(String.valueOf(0.7)+" mL");

            form_vial_1.setText(String.valueOf(vial)+" Vial");
            form_vial_2.setText(String.valueOf(1)+" Vial");

            total_dose_textview.setText(String.valueOf(total_dose)+" mG");


            total_volume=1.42+(kilo-71)*0.02;
            double total_volume_düzeltilmiş = Math.floor(total_volume * 100 + 0.5) / 100;


            total_volume_textview.setText(String.valueOf(total_volume_düzeltilmiş)+" mL");


            bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe));
            iki_uc_syringe_textview.setText(String.valueOf(iki_uc_mg_syringe));


            üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);

            birinci_ilaç_image.setBackgroundResource(R.drawable.pill_purple);
            birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_purple);


            ikinci_ilaç_backgournd.setBackgroundResource(R.drawable.oval_button_turquoise);
            ikinci_ilaç_image.setBackgroundResource(R.drawable.pill_turquoise);


            if (kilo==75){

                bir_mgl_syringe_textview.setText(String.valueOf(0));
                iki_uc_syringe_textview.setText(String.valueOf(1));


            }





        }




        if ( kilo>=76 && kilo<=80){

            total_dose=kilo*3;

            vial=3;

            amount=0.4;

            volume_1=total_dose/150.0;



            bir_mg_syringe=2;


            iki_uc_mg_syringe=0;

            dose_int_1=60;

            ilaç_adı_1.setText(getString(R.string.Purple));

            dose_ml_1.setText(String.valueOf(dose_int_1)+" mg");
            amount_ml_1.setText(String.valueOf(amount)+" mL");
            form_vial_1.setText(String.valueOf(vial)+" Vial");
            total_dose_textview.setText(String.valueOf(total_dose)+" mG");


            total_volume=1.52+((kilo-76)*0.02);

            double total_volume_düzeltilmiş = Math.floor(total_volume * 100 + 0.5) / 100;




            total_volume_textview.setText(String.valueOf(total_volume_düzeltilmiş)+" mL");
            bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe));
            iki_uc_syringe_textview.setText(String.valueOf(iki_uc_mg_syringe));


            ikinci_ilaç_layout.setVisibility(View.INVISIBLE);
            üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);

            birinci_ilaç_image.setBackgroundResource(R.drawable.pill_purple);

            birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_purple);



            if (kilo==80){

                form_vial_1.setText(String.valueOf(4)+" Vial");
                bir_mgl_syringe_textview.setText(String.valueOf(0));
                iki_uc_syringe_textview.setText(String.valueOf(1));



            }




        }



        if ( kilo>=76 && kilo<=80){

            total_dose=kilo*3;

            vial=3;

            amount=0.4;

            volume_1=total_dose/150.0;



            bir_mg_syringe=2;


            iki_uc_mg_syringe=0;

            dose_int_1=60;

            ilaç_adı_1.setText(getString(R.string.Purple));

            dose_ml_1.setText(String.valueOf(dose_int_1)+" mg");
            amount_ml_1.setText(String.valueOf(amount)+" mL");
            form_vial_1.setText(String.valueOf(vial)+" Vial");
            total_dose_textview.setText(String.valueOf(total_dose)+" mG");


            total_volume=1.52+((kilo-76)*0.02);

            double total_volume_düzeltilmiş = Math.floor(total_volume * 100 + 0.5) / 100;




            total_volume_textview.setText(String.valueOf(total_volume_düzeltilmiş)+" mL");
            bir_mgl_syringe_textview.setText(String.valueOf(bir_mg_syringe));
            iki_uc_syringe_textview.setText(String.valueOf(iki_uc_mg_syringe));


            ikinci_ilaç_layout.setVisibility(View.INVISIBLE);
            üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);

            birinci_ilaç_image.setBackgroundResource(R.drawable.pill_purple);

            birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_purple);



            if (kilo==80){

                form_vial_1.setText(String.valueOf(4)+" Vial");
                bir_mgl_syringe_textview.setText(String.valueOf(0));
                iki_uc_syringe_textview.setText(String.valueOf(1));



            }




        }






        if ( kilo>=81 && kilo<=85){


            // Hangi ilaçlar?

            üçüncü_ilaç_layout.setVisibility(View.INVISIBLE);






            // İlaç adları

            ilaç_adı_1.setText(getString(R.string.Turquoise));
            ilaç_adı_2.setText(getString(R.string.Orange));






            //İlaç foto ve backgroundları


            birinci_ilaç_image.setBackgroundResource(R.drawable.pill_turquoise);
            birinci_ilaç_backgound.setBackgroundResource(R.drawable.oval_button_turquoise);

            ikinci_ilaç_image.setBackgroundResource(R.drawable.pill_orange);
            ikinci_ilaç_backgournd.setBackgroundResource(R.drawable.oval_button_orange);







            // Total dose hesaplama

            total_dose=kilo*3;
            total_dose_textview.setText(String.valueOf(total_dose)+" mG");








            //Dose işlemleri

            dose_ml_1.setText("105"+" mg");
            dose_ml_2.setText("150"+" mg");








            //Amount işlemleri

            amount_ml_1.setText("0.7"+" mL");
            amount_ml_2.setText("1.0"+" mL");






            //Form vial işlemleri

            form_vial_1.setText("1"+" Vial");
            form_vial_2.setText("1"+" Vial");







            //Total volume işlemleri

            total_volume=1.62+(kilo-81)*0.02;
            double total_volume_düzeltilmiş = Math.floor(total_volume * 100 + 0.5) / 100;
            total_volume_textview.setText(String.valueOf(total_volume_düzeltilmiş)+" mL");







            //Syringe işlemleri

            bir_mgl_syringe_textview.setText("2");
            iki_uc_syringe_textview.setText("0");






            //Ekstra işlemler

            if (kilo==85){

                bir_mgl_syringe_textview.setText("0");
                iki_uc_syringe_textview.setText("1");


            }








        }


       */































        Button calculate_again_button=(Button)findViewById(R.id.calculate_again_button);



        calculate_again_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);



            }
        });




    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {


            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
               }
    }

}
