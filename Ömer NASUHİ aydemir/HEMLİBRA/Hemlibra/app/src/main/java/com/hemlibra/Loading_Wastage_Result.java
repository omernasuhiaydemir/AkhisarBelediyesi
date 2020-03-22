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

import java.math.BigDecimal;


public class ResultEnSon extends AppCompatActivity {

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




            total_dose_değeri = String.valueOf(kilo*3);







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

            String aranacak_dizi_str  = bnd.getString("diz_adı_key");




            double loading_wastage_3 [] = {3,	999,	999,	1,	0.3,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.3,	1,	0};
            double loading_wastage_4 [] = {4,	999,	999,	1,	0.4,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.4,	1,	0};
            double loading_wastage_5 [] = {5,	999,	999,	1,	0.5,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.5,	1,	0};
            double loading_wastage_6 [] = {6,	999,	999,	1,	0.6,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.6,	1,	0};
            double loading_wastage_7 [] = {7,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.7,	1,	0};
            double loading_wastage_8 [] = {8,	999,	999,	1,	0.8,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.8,	1,	0};
            double loading_wastage_9 [] = {9,	999,	999,	1,	0.9,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.9,	1,	0};
            double loading_wastage_10 [] = {10,	1,	1,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	0};
            double loading_wastage_11 [] = {11,	999,	999,	999,	999,	999,	999,	1,	0.22,	999,	999,	999,	999,	999,	999,	999,	999,	0.22,	1,	0};
            double loading_wastage_12 [] = {12,	999,	999,	999,	999,	999,	999,	1,	0.24,	999,	999,	999,	999,	999,	999,	999,	999,	0.24,	1,	0};
            double loading_wastage_13 [] = {13,	999,	999,	999,	999,	999,	999,	1,	0.26,	999,	999,	999,	999,	999,	999,	999,	999,	0.26,	1,	0};
            double loading_wastage_14 [] = {14,	999,	999,	999,	999,	999,	999,	1,	0.28,	999,	999,	999,	999,	999,	999,	999,	999,	0.28,	1,	0};
            double loading_wastage_15 [] = {15,	999,	999,	999,	999,	999,	999,	1,	0.3,	999,	999,	999,	999,	999,	999,	999,	999,	0.3,	1,	0};
            double loading_wastage_16 [] = {16,	999,	999,	999,	999,	999,	999,	1,	0.32,	999,	999,	999,	999,	999,	999,	999,	999,	0.32,	1,	0};
            double loading_wastage_17 [] = {17,	999,	999,	999,	999,	999,	999,	1,	0.34,	999,	999,	999,	999,	999,	999,	999,	999,	0.34,	1,	0};
            double loading_wastage_18 [] = {18,	999,	999,	999,	999,	999,	999,	1,	0.36,	999,	999,	999,	999,	999,	999,	999,	999,	0.36,	1,	0};
            double loading_wastage_19 [] = {19,	999,	999,	999,	999,	999,	999,	1,	0.38,	999,	999,	999,	999,	999,	999,	999,	999,	0.38,	1,	0};
            double loading_wastage_20 [] = {20,	999,	999,	999,	999,	1,	0.4,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.4,	1,	0};
            double loading_wastage_21 [] = {21,	999,	999,	1,	0.1,	1,	0.4,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.5,	2,	0};
            double loading_wastage_22 [] = {22,	999,	999,	1,	0.2,	1,	0.4,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.6,	2,	0};
            double loading_wastage_23 [] = {23,	999,	999,	1,	0.3,	1,	0.4,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.7,	2,	0};
            double loading_wastage_24 [] = {24,	999,	999,	1,	0.4,	1,	0.4,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.8,	2,	0};
            double loading_wastage_25 [] = {25,	999,	999,	1,	0.5,	1,	0.4,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.9,	2,	0};
            double loading_wastage_26 [] = {26,	999,	999,	1,	0.6,	1,	0.4,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	2,	0};
            double loading_wastage_27 [] = {27,	999,	999,	1,	0.7,	1,	0.4,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1.1,	2,	0};
            double loading_wastage_28 [] = {28,	999,	999,	1,	0.8,	1,	0.4,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1.2,	2,	0};
            double loading_wastage_29 [] = {29,	999,	999,	1,	0.9,	1,	0.4,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1.3,	2,	0};
            double loading_wastage_30 [] = {30,	1,	1,	999,	999,	1,	0.4,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1.4,	2,	0};
            double loading_wastage_31 [] = {31,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.62,	999,	999,	999,	999,	0.62,	1,	0};
            double loading_wastage_32 [] = {32,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.64,	999,	999,	999,	999,	0.64,	1,	0};
            double loading_wastage_33 [] = {33,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.66,	999,	999,	999,	999,	0.66,	1,	0};
            double loading_wastage_34 [] = {34,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.68,	999,	999,	999,	999,	0.68,	1,	0};
            double loading_wastage_35 [] = {35,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	0.7,	1,	0};
            double loading_wastage_36 [] = {36,	999,	999,	999,	999,	1,	0.4,	1,	0.32,	999,	999,	999,	999,	999,	999,	999,	999,	0.72,	2,	0};
            double loading_wastage_37 [] = {37,	999,	999,	999,	999,	1,	0.4,	1,	0.34,	999,	999,	999,	999,	999,	999,	999,	999,	0.74,	2,	0};
            double loading_wastage_38 [] = {38,	999,	999,	999,	999,	1,	0.4,	1,	0.36,	999,	999,	999,	999,	999,	999,	999,	999,	0.76,	2,	0};
            double loading_wastage_39 [] = {39,	999,	999,	999,	999,	1,	0.4,	1,	0.38,	999,	999,	999,	999,	999,	999,	999,	999,	0.78,	2,	0};
            double loading_wastage_40 [] = {40,	999,	999,	999,	999,	2,	0.4,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	0.8,	1,	0};
            double loading_wastage_41 [] = {41,	999,	999,	1,	0.6,	999,	999,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.3,	2,	0};
            double loading_wastage_42 [] = {42,	999,	999,	1,	0.7,	999,	999,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.4,	2,	0};
            double loading_wastage_43 [] = {43,	999,	999,	1,	0.8,	999,	999,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.5,	2,	0};
            double loading_wastage_44 [] = {44,	999,	999,	1,	0.9,	999,	999,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.6,	2,	0};
            double loading_wastage_45 [] = {45,	1,	1,	999,	999,	999,	999,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.7,	2,	0};
            double loading_wastage_46 [] = {46,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.92,	0.92,	1,	0};
            double loading_wastage_47 [] = {47,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.94,	0.94,	1,	0};
            double loading_wastage_48 [] = {48,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.96,	0.96,	1,	0};
            double loading_wastage_49 [] = {49,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.98,	0.98,	1,	0};
            double loading_wastage_50 [] = {50,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	999,	999,	1,	1,	0};
            double loading_wastage_51 [] = {51,	999,	999,	999,	999,	999,	999,	1,	0.32,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.02,	2,	0};
            double loading_wastage_52 [] = {52,	999,	999,	999,	999,	999,	999,	1,	0.34,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.04,	2,	0};
            double loading_wastage_53 [] = {53,	999,	999,	999,	999,	999,	999,	1,	0.36,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.06,	2,	0};
            double loading_wastage_54 [] = {54,	999,	999,	999,	999,	999,	999,	1,	0.38,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.08,	2,	0};
            double loading_wastage_55 [] = {55,	999,	999,	999,	999,	1,	0.4,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.1,	0,	1};
            double loading_wastage_56 [] = {56,	999,	999,	1,	0.6,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	999,	999,	1.6,	2,	0};
            double loading_wastage_57 [] = {57,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	999,	999,	1.7,	2,	0};
            double loading_wastage_58 [] = {58,	999,	999,	1,	0.8,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	999,	999,	1.8,	2,	0};
            double loading_wastage_59 [] = {59,	999,	999,	1,	0.9,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	999,	999,	1.9,	2,	0};
            double loading_wastage_60 [] = {60,	1,	1,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	999,	999,	2,	2,	0};
            double loading_wastage_61 [] = {61,	999,	999,	1,	0.6,	1,	0.4,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.7,	1,	1};
            double loading_wastage_62 [] = {62,	999,	999,	1,	0.7,	1,	0.4,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.8,	1,	1};
            double loading_wastage_63 [] = {63,	999,	999,	1,	0.8,	1,	0.4,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.9,	1,	1};
            double loading_wastage_64 [] = {64,	999,	999,	1,	0.9,	1,	0.4,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	2,	1,	1};
            double loading_wastage_65 [] = {65,	1,	1,	999,	999,	1,	0.4,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	2.1,	1,	1};
            double loading_wastage_66 [] = {66,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.7,	1,	0.62,	999,	999,	999,	999,	1.32,	2,	0};
            double loading_wastage_67 [] = {67,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.7,	1,	0.64,	999,	999,	999,	999,	1.34,	2,	0};
            double loading_wastage_68 [] = {   68,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.7,	1,	0.66,	999,	999,	999,	999,	1.36,	2,	0 };
            double loading_wastage_69 [] = { 69,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.7,	1,	0.68,	999,	999,	999,	999,	1.38,	2,	0  };
            double loading_wastage_70 [] = {  70,	999,	999,	999,	999,	999,	999,	999,	999,	2,	0.7,	999,	999,	999,	999,	999,	999,	1.4,	0,	1  };
            double loading_wastage_71 [] = {71,	999,	999,	999,	999,	2,	0.4,	999,	999,	999,	999,	1,	0.62,	999,	999,	999,	999,	1.42,	2,	0    };
            double loading_wastage_72 [] = { 72,	999,	999,	999,	999,	2,	0.4,	999,	999,	999,	999,	1,	0.64,	999,	999,	999,	999,	1.44,	2,	0   };
            double loading_wastage_73 [] = {  73,	999,	999,	999,	999,	2,	0.4,	999,	999,	999,	999,	1,	0.66,	999,	999,	999,	999,	1.46,	2,	0  };
            double loading_wastage_74 [] = { 74,	999,	999,	999,	999,	2,	0.4,	999,	999,	999,	999,	1,	0.68,	999,	999,	999,	999,	1.48,	2,	0   };
            double loading_wastage_75 [] = {  75,	999,	999,	999,	999,	2,	0.4,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.5,	0,	1 };
            double loading_wastage_76 [] = { 76,	999,	999,	999,	999,	3,	0.4,	1,	0.32,	999,	999,	999,	999,	999,	999,	999,	999,	1.52,	2,	0   };
            double loading_wastage_77 [] = { 77,	999,	999,	999,	999,	3,	0.4,	1,	0.34,	999,	999,	999,	999,	999,	999,	999,	999,	1.54,	2,	0   };
            double loading_wastage_78 [] = {  78,	999,	999,	999,	999,	3,	0.4,	1,	0.36,	999,	999,	999,	999,	999,	999,	999,	999,	1.56,	2,	0  };
            double loading_wastage_79 [] = { 79,	999,	999,	999,	999,	3,	0.4,	1,	0.38,	999,	999,	999,	999,	999,	999,	999,	999,	1.58,	2,	0   };
            double loading_wastage_80 [] = { 80,	999,	999,	999,	999,	4,	0.4,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1.6,	0,	1   };
            double loading_wastage_81 [] = { 81,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.62,	1,	1,	999,	999,	1.62,	2,	0   };
            double loading_wastage_82 [] = { 82,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.64,	1,	1,	999,	999,	1.64,	2,	0   };
            double loading_wastage_83 [] = { 83,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.66,	1,	1,	999,	999,	1.66,	2,	0   };
            double loading_wastage_84 [] = {  84,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.68,	1,	1,	999,	999,	1.68,	2,	0  };
            double loading_wastage_85 [] = {  85,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.7,	999,	999,	1,	1,	999,	999,	1.7,	0,	1  };
            double loading_wastage_86 [] = {  86,	999,	999,	999,	999,	1,	0.4,	1,	0.32,	999,	999,	999,	999,	1,	1,	999,	999,	1.72,	2,	0  };
            double loading_wastage_87 [] = {87,	999,	999,	999,	999,	1,	0.4,	1,	0.34,	999,	999,	999,	999,	1,	1,	999,	999,	1.74,	2,	0    };
            double loading_wastage_88 [] = { 88,	999,	999,	999,	999,	1,	0.4,	1,	0.36,	999,	999,	999,	999,	1,	1,	999,	999,	1.76,	2,	0   };
            double loading_wastage_89 [] = {  89,	999,	999,	999,	999,	1,	0.4,	1,	0.38,	999,	999,	999,	999,	1,	1,	999,	999,	1.78,	2,	0  };
            double loading_wastage_90 [] = {   90,	999,	999,	999,	999,	2,	0.4,	999,	999,	999,	999,	999,	999,	1,	1,	999,	999,	1.8,	0,	1 };
            double loading_wastage_91 [] = { 91,	999,	999,	999,	999,	2,	0.4,	1,	0.32,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.82,	1,	1   };
            double loading_wastage_92 [] = { 92,	999,	999,	999,	999,	2,	0.4,	1,	0.34,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.84,	1,	1   };
            double loading_wastage_93 [] = {  93,	999,	999,	999,	999,	2,	0.4,	1,	0.36,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.86,	1,	1  };
            double loading_wastage_94 [] = { 94,	999,	999,	999,	999,	2,	0.4,	1,	0.38,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.88,	1,	1   };
            double loading_wastage_95 [] = { 95,	999,	999,	999,	999,	3,	0.4,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	1.9,	0,	1   };
            double loading_wastage_96 [] = { 96,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	1,	0.92,	1.92,	2,	0   };
            double loading_wastage_97 [] = { 97,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	1,	0.94,	1.94,	2,	0   };
            double loading_wastage_98 [] = { 98,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	1,	0.96,	1.96,	2,	0   };
            double loading_wastage_99 [] = { 99,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	1,	1,	0.98,	1.98,	2,	0   };
            double loading_wastage_100 [] = {  100,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	999,	999,	2,	0,	1  };
            double loading_wastage_101 [] = {   101,	999,	999,	999,	999,	999,	999,	999,	999,	2,	0.7,	1,	0.62,	999,	999,	999,	999,	2.02,	1,	1 };
            double loading_wastage_102 [] = { 102,	999,	999,	999,	999,	999,	999,	999,	999,	2,	0.7,	1,	0.64,	999,	999,	999,	999,	2.04,	1,	1   };
            double loading_wastage_103 [] = { 103,	999,	999,	999,	999,	999,	999,	999,	999,	2,	0.7,	1,	0.66,	999,	999,	999,	999,	2.06,	1,	1   };
            double loading_wastage_104 [] = {  104,	999,	999,	999,	999,	999,	999,	999,	999,	2,	0.7,	1,	0.68,	999,	999,	999,	999,	2.08,	1,	1  };
            double loading_wastage_105 [] = {  105,	999,	999,	999,	999,	999,	999,	999,	999,	3,	0.7,	999,	999,	999,	999,	999,	999,	2.1,	1,	1  };
            double loading_wastage_106 [] = { 106,	999,	999,	999,	999,	1,	0.4,	1,	0.32,	2,	0.7,	999,	999,	999,	999,	999,	999,	2.12,	1,	1   };
            double loading_wastage_107 [] = {  107,	999,	999,	999,	999,	1,	0.4,	1,	0.34,	2,	0.7,	999,	999,	999,	999,	999,	999,	2.14,	1,	1  };
            double loading_wastage_108 [] = { 108,	999,	999,	999,	999,	1,	0.4,	1,	0.36,	2,	0.7,	999,	999,	999,	999,	999,	999,	2.16,	1,	1   };
            double loading_wastage_109 [] = { 109,	999,	999,	999,	999,	1,	0.4,	1,	0.38,	2,	0.7,	999,	999,	999,	999,	999,	999,	2.18,	1,	1    };
            double loading_wastage_110 [] = {  110,	999,	999,	999,	999,	2,	0.4,	999,	999,	2,	0.7,	999,	999,	999,	999,	999,	999,	2.2,	1,	1  };
            double loading_wastage_111 [] = { 111,	999,	999,	999,	999,	3,	0.4,	1,	0.32,	1,	0.7,	999,	999,	999,	999,	999,	999,	2.22,	1,	1   };
            double loading_wastage_112 [] = {  112,	999,	999,	999,	999,	3,	0.4,	1,	0.34,	1,	0.7,	999,	999,	999,	999,	999,	999,	2.24,	1,	1,  };
            double loading_wastage_113 [] = {   113,	999,	999,	999,	999,	3,	0.4,	1,	0.36,	1,	0.7,	999,	999,	999,	999,	999,	999,	2.26,	1,	1 };
            double loading_wastage_114 [] = {  114,	999,	999,	999,	999,	3,	0.4,	1,	0.38,	1,	0.7,	999,	999,	999,	999,	999,	999,	2.28,	1,	1  };
            double loading_wastage_115 [] = { 115,	999,	999,	999,	999,	4,	0.4,	999,	999,	1,	0.7,	999,	999,	999,	999,	999,	999,	2.3,	1,	1   };
            double loading_wastage_116 [] = { 116,	999,	999,	999,	999,	999,	999,	1,	0.32,	999,	999,	999,	999,	2,	1,	999,	999,	2.32,	1,	1   };
            double loading_wastage_117 [] = {  117,	999,	999,	999,	999,	999,	999,	1,	0.34,	999,	999,	999,	999,	2,	1,	999,	999,	2.34,	1,	1  };
            double loading_wastage_118 [] = {  118,	999,	999,	999,	999,	999,	999,	1,	0.36,	999,	999,	999,	999,	2,	1,	999,	999,	2.36,	1,	1  };
            double loading_wastage_119 [] = {  119,	999,	999,	999,	999,	999,	999,	1,	0.38,	999,	999,	999,	999,	2,	1,	999,	999,	2.38,	1,	1  };
            double loading_wastage_120 [] = { 120,	999,	999,	999,	999,	1,	0.4,	999,	999,	999,	999,	999,	999,	2,	1,	999,	999,	2.4,	1,	1   };
            double loading_wastage_121 [] = {  121,	999,	999,	999,	999,	999,	999,	1,	0.32,	3,	0.7,	999,	999,	999,	999,	999,	999,	2.42,	2,	1  };
            double loading_wastage_122 [] = { 122,	999,	999,	999,	999,	999,	999,	1,	0.34,	3,	0.7,	999,	999,	999,	999,	999,	999,	2.44,	2,	1   };
            double loading_wastage_123 [] = { 123,	999,	999,	999,	999,	999,	999,	1,	0.36,	3,	0.7,	999,	999,	999,	999,	999,	999,	2.46,	2,	1   };
            double loading_wastage_124 [] = {  124,	999,	999,	999,	999,	999,	999,	1,	0.38,	3,	0.7,	999,	999,	999,	999,	999,	999,	2.48,	2,	1  };
            double loading_wastage_125 [] = {  125,	999,	999,	999,	999,	1,	0.4,	999,	999,	3,	0.7,	999,	999,	999,	999,	999,	999,	2.5,	0,	2  };
            double loading_wastage_126 [] = {  126,	999,	999,	999,	999,	3,	0.4,	1,	0.32,	999,	999,	999,	999,	1,	1,	999,	999,	2.52,	1,	1  };
            double loading_wastage_127 [] = {  127,	999,	999,	999,	999,	3,	0.4,	1,	0.34,	999,	999,	999,	999,	1,	1,	999,	999,	2.54,	1,	1  };
            double loading_wastage_128 [] = {  128,	999,	999,	999,	999,	3,	0.4,	1,	0.36,	999,	999,	999,	999,	1,	1,	999,	999,	2.56,	1,	1  };
            double loading_wastage_129 [] = { 129,	999,	999,	999,	999,	3,	0.4,	1,	0.38,	999,	999,	999,	999,	1,	1,	999,	999,	2.58,	1,	1   };
            double loading_wastage_130 [] = { 130,	999,	999,	999,	999,	4,	0.4,	999,	999,	999,	999,	999,	999,	1,	1,	999,	999,	2.6,	1,	1   };
            double loading_wastage_131 [] = { 131,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.62,	2,	1,	999,	999,	2.62,	1,	1   };
            double loading_wastage_132 [] = { 132,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.64,	2,	1,	999,	999,	2.64,	1,	1   };
            double loading_wastage_133 [] = { 133,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.66,	2,	1,	999,	999,	2.66,	1,	1   };
            double loading_wastage_134 [] = {  134,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.68,	2,	1,	999,	999,	2.68,	1,	1  };
            double loading_wastage_135 [] = {  135,	999,	999,	999,	999,	999,	999,	999,	999,	1,	0.7,	999,	999,	2,	1,	999,	999,	2.7,	1,	1  };
            double loading_wastage_136 [] = {  136,	999,	999,	999,	999,	1,	0.4,	1,	0.32,	999,	999,	999,	999,	2,	1,	999,	999,	2.72,	1,	1  };
            double loading_wastage_137 [] = {  137,	999,	999,	999,	999,	1,	0.4,	1,	0.34,	999,	999,	999,	999,	2,	1,	999,	999,	2.74,	1,	1  };
            double loading_wastage_138 [] = {  138,	999,	999,	999,	999,	1,	0.4,	1,	0.36,	999,	999,	999,	999,	2,	1,	999,	999,	2.76,	1,	1  };
            double loading_wastage_139 [] = {  139,	999,	999,	999,	999,	1,	0.4,	1,	0.38,	999,	999,	999,	999,	2,	1,	999,	999,	2.78,	1,	1  };
            double loading_wastage_140 [] = {  140,	999,	999,	999,	999,	2,	0.4,	999,	999,	999,	999,	999,	999,	2,	1,	999,	999,	2.8,	1,	1  };
            double loading_wastage_141 [] = { 141,	999,	999,	999,	999,	1,	0.4,	1,	0.32,	3,	0.7,	999,	999,	999,	999,	999,	999,	2.82,	2,	1   };
            double loading_wastage_142 [] = {  142,	999,	999,	999,	999,	1,	0.4,	1,	0.34,	3,	0.7,	999,	999,	999,	999,	999,	999,	2.84,	2,	1  };
            double loading_wastage_143 [] = { 143,	999,	999,	999,	999,	1,	0.4,	1,	0.36,	3,	0.7,	999,	999,	999,	999,	999,	999,	2.86,	2,	1   };
            double loading_wastage_144 [] = { 144,	999,	999,	999,	999,	1,	0.4,	1,	0.38,	3,	0.7,	999,	999,	999,	999,	999,	999,	2.88,	2,	1   };
            double loading_wastage_145 [] = { 145,	999,	999,	999,	999,	2,	0.4,	999,	999,	3,	0.7,	999,	999,	999,	999,	999,	999,	2.9,	0,	2   };
            double loading_wastage_146 [] = {146,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	1,	0.92,	2.92,	1,	1    };
            double loading_wastage_147 [] = {  147,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	1,	0.94,	2.94,	1,	1  };
            double loading_wastage_148 [] = { 148,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	1,	0.96,	2.96,	1,	1   };
            double loading_wastage_149 [] = { 149,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	2,	1,	1,	0.98,	2.98,	1,	1   };
            double loading_wastage_150 [] = { 150,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	999,	3,	1,	999,	999,	3,	1,	1   };













            //Loading_İnjections

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





            //O1 LEAST WASTAGE





         /*   double  Q1_WASTAGE_3 [] = { 3,	4.5,	4.5,	1,	0.15,	999,	999,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_4 [] = { 4,	6.0,	6.0,	1,	0.20,	999,	999,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_5 [] = { 5,	7.5,	7.5,	1,	0.25,	999,	999,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_6 [] = { 6,	9.0,	9.0,	1,	0.30,	999,	999,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_7 [] = {  7,	10.5,	10.5,	1,	0.35,	999,	999,	999,	999,	999,	999,	1,	999};
            double  Q1_WASTAGE_8 [] = { 8,	12.0,	12.0,	1,	0.40,	999,	999,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_9 [] = { 9,	13.5,	13.5,	1,	0.45,	999,	999,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_10 [] = { 10,	15.0,	15.0,	1,	0.50,	999,	999,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_11 [] = { 11,	16.5,	16.5,	1,	0.55,	999,	999,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_12 [] = { 12,	18.0,	18.0,	1,	0.60,	999,	999,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_13 [] = { 13,	19.5,	19.5,	1,	0.65,	999,	999,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_14 [] = { 14,	21.0,	21.0,	1,	0.70,	999,	999,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_15 [] = {15,	22.5,	22.5,	1,	0.75,	999,	999,	999,	999,	999,	999,	1,	999  };
            double  Q1_WASTAGE_16 [] = { 16,	24.0,	24.0,	1,	0.80,	999,	999,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_17 [] = { 17,	25.5,	25.5,	1,	0.85,	999,	999,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_18 [] = { 18,	27.0,	27.0,	1,	0.90,	999,	999,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_19 [] = {19,	28.5,	28.5,	1,	0.95,	999,	999,	999,	999,	999,	999,	1,	999  };
            double  Q1_WASTAGE_20 [] = { 20,	30.0,	30.0,	1,	1.00,	999,	999,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_21 [] = {  21,	31.5,	31.5,	999,	999,	1,	0.21,	999,	999,	999,	999,	1,	999};
            double  Q1_WASTAGE_22 [] = { 22,	33.0,	33.0,	999,	999,	1,	0.22,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_23 [] = { 23,	34.5,	34.5,	999,	999,	1,	0.23,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_24 [] = { 24,	36.0,	36.0,	999,	999,	1,	0.24,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_25 [] = { 25,	37.5,	37.5,	999,	999,	1,	0.25,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_26 [] = { 26,	39.0,	39.0,	999,	999,	1,	0.26,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_27 [] = { 27,	40.5,	40.5,	999,	999,	1,	0.27,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_28 [] = {28,	42.0,	42.0,	999,	999,	1,	0.28,	999,	999,	999,	999,	1,	999  };
            double  Q1_WASTAGE_29 [] = { 29,	43.5,	43.5,	999,	999,	1,	0.29,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_30 [] = { 30,	45.0,	45.0,	999,	999,	1,	0.30,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_31 [] = { 31,	46.5,	46.5,	999,	999,	1,	0.31,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_32 [] = {32,	48.0,	48.0,	999,	999,	1,	0.32,	999,	999,	999,	999,	1,	999  };
            double  Q1_WASTAGE_33 [] = { 33,	49.5,	49.5,	999,	999,	1,	0.33,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_34 [] = { 34,	51.0,	51.0,	999,	999,	1,	0.34,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_35 [] = {35,	52.5,	52.5,	999,	999,	1,	0.35,	999,	999,	999,	999,	1,	999  };
            double  Q1_WASTAGE_36 [] = { 36,	54.0,	54.0,	999,	999,	1,	0.36,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_37 [] = { 37,	55.5,	55.5,	999,	999,	1,	0.37,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_38 [] = { 38,	57.0,	57.0,	999,	999,	1,	0.38,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_39 [] = { 39,	58.5,	58.5,	999,	999,	1,	0.39,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_40 [] = { 40,	60.0,	60.0,	999,	999,	1,	0.40,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_41 [] = { 41,	61.5,	61.5,	1,	0.05,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_42 [] = { 42,	63.0,	63.0,	1,	0.10,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_43 [] = { 43,	64.5,	64.5,	1,	0.15,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_44 [] = { 44,	66.0,	66.0,	1,	0.20,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_45 [] = { 45,	67.5,	67.5,	1,	0.25,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_46 [] = { 46,	69.0,	69.0,	1,	0.30,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_47 [] = { 47,	70.5,	70.5,	1,	0.35,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_48 [] = { 48,	72.0,	72.0,	1,	0.40,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_49 [] = { 49,	73.5,	73.5,	1,	0.45,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_50 [] = { 50,	75.0,	75.0,	1,	0.50,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_51 [] = { 51,	76.5,	76.5,	1,	0.55,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_52 [] = { 52,	78.0,	78.0,	1,	0.60,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_53 [] = { 53,	79.5,	79.5,	1,	0.65,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_54 [] = { 54,	81.0,	81.0,	1,	0.70,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_55 [] = { 55,	82.5,	82.5,	1,	0.75,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_56 [] = { 56,	84.0,	84.0,	1,	0.80,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_57 [] = { 57,	85.5,	85.5,	1,	0.85,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_58 [] = { 58,	87.0,	87.0,	1,	0.90,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_59 [] = { 59,	88.5,	88.5,	1,	0.95,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_60 [] = { 60,	90.0,	90.0,	1,	1.00,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q1_WASTAGE_61 [] = { 61,	91.5,	91.5,	999,	999,	999,	999,	1,	0.61,	999,	999,	1,	999 };
            double  Q1_WASTAGE_62 [] = { 62,	93.0,	93.0,	999,	999,	999,	999,	1,	0.62,	999,	999,	1,	999 };
            double  Q1_WASTAGE_63 [] = { 63,	94.5,	94.5,	999,	999,	999,	999,	1,	0.63,	999,	999,	1,	999 };
            double  Q1_WASTAGE_64 [] = { 64,	96.0,	96.0,	999,	999,	999,	999,	1,	0.64,	999,	999,	1,	999 };
            double  Q1_WASTAGE_65 [] = { 65,	97.5,	97.5,	999,	999,	999,	999,	1,	0.65,	999,	999,	1,	999 };
            double  Q1_WASTAGE_66 [] = { 66,	99.0,	99.0,	999,	999,	999,	999,	1,	0.66,	999,	999,	1,	999 };
            double  Q1_WASTAGE_67 [] = { 67,	100.5,	100.5,	999,	999,	999,	999,	1,	0.67,	999,	999,	1,	999 };
            double  Q1_WASTAGE_68 [] = { 68,	102.0,	102.0,	999,	999,	999,	999,	1,	0.68,	999,	999,	1,	999 };
            double  Q1_WASTAGE_69 [] = { 69,	103.5,	103.5,	999,	999,	999,	999,	1,	0.69,	999,	999,	1,	999 };
            double  Q1_WASTAGE_70 [] = { 70,	105.0,	105.0,	999,	999,	999,	999,	1,	0.70,	999,	999,	1,	999 };
            double  Q1_WASTAGE_71 [] = { 71,	106.5,	106.5,	999,	999,	2,	0.71,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_72 [] = { 72,	108.0,	108.0,	999,	999,	2,	0.72,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_73 [] = { 73,	109.5,	109.5,	999,	999,	2,	0.73,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_74 [] = { 74,	111.0,	111.0,	999,	999,	2,	0.74,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_75 [] = { 75,	112.5,	112.5,	999,	999,	2,	0.75,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_76 [] = { 76,	114.0,	114.0,	999,	999,	2,	0.76,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_77 [] = { 77,	115.5,	115.5,	999,	999,	2,	0.77,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_78 [] = { 78,	117.0,	117.0,	999,	999,	2,	0.78,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_79 [] = { 79,	118.5,	118.5,	999,	999,	2,	0.79,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_80 [] = { 80,	120.0,	120.0,	999,	999,	2,	0.80,	999,	999,	999,	999,	1,	999 };
            double  Q1_WASTAGE_81 [] = { 81,	121.5,	121.5,	1,	0.55,	999,	999,	1,	0.70,	999,	999,	2,	999     };
            double  Q1_WASTAGE_82 [] = { 82,	123.0,	123.0,	1,	0.60,	999,	999,	1,	0.70,	999,	999,	2,	999     };
            double  Q1_WASTAGE_83 [] = { 83,	124.5,	124.5,	1,	0.65,	999,	999,	1,	0.70,	999,	999,	2,	999     };
            double  Q1_WASTAGE_84 [] = { 84,	126.0,	126.0,	1,	0.70,	999,	999,	1,	0.70,	999,	999,	2,	999     };
            double  Q1_WASTAGE_85 [] = {   85,	127.5,	127.5,	1,	0.75,	999,	999,	1,	0.70,	999,	999,	2,	999           };
            double  Q1_WASTAGE_86 [] = {   86,	129.0,	129.0,	1,	0.80,	999,	999,	1,	0.70,	999,	999,	2,	999           };
            double  Q1_WASTAGE_87 [] = {   87,	130.5,	130.5,	1,	0.85,	999,	999,	1,	0.70,	999,	999,	2,	999           };
            double  Q1_WASTAGE_88 [] = {   88,	132.0,	132.0,	1,	0.90,	999,	999,	1,	0.70,	999,	999,	2,	999           };
            double  Q1_WASTAGE_89 [] = {   89,	133.5,	133.5,	1,	0.95,	999,	999,	1,	0.70,	999,	999,	2,	999           };
            double  Q1_WASTAGE_90 [] = {   90,	135.0,	135.0,	1,	1.00,	999,	999,	1,	0.70,	999,	999,	2,	999           };
            double  Q1_WASTAGE_91 [] = {   91,	136.5,	136.5,	999,	999,	999,	999,	999,	999,	1,	0.91,	1,	999       };
            double  Q1_WASTAGE_92 [] = {   92,	138.0,	138.0,	999,	999,	999,	999,	999,	999,	1,	0.92,	1,	999       };
            double  Q1_WASTAGE_93 [] = {   93,	139.5,	139.5,	999,	999,	999,	999,	999,	999,	1,	0.93,	1,	999       };
            double  Q1_WASTAGE_94 [] = {   94,	141.0,	141.0,	999,	999,	999,	999,	999,	999,	1,	0.94,	1,	999       };
            double  Q1_WASTAGE_95 [] = {   95,	142.5,	142.5,	999,	999,	999,	999,	999,	999,	1,	0.95,	1,	999       };
            double  Q1_WASTAGE_96 [] = {   96,	144.0,	144.0,	999,	999,	999,	999,	999,	999,	1,	0.96,	1,	999       };
            double  Q1_WASTAGE_97 [] = {   97,	145.5,	145.5,	999,	999,	999,	999,	999,	999,	1,	0.97,	1,	999       };
            double  Q1_WASTAGE_98 [] = {   98,	147.0,	147.0,	999,	999,	999,	999,	999,	999,	1,	0.98,	1,	999       };
            double  Q1_WASTAGE_99 [] = {   99,	148.5,	148.5,	999,	999,	999,	999,	999,	999,	1,	0.99,	1,	999       };
            double  Q1_WASTAGE_100 [] = {  100,	150.0,	150.0,	999,	999,	999,	999,	999,	999,	1,	1.00,	1,	999        };
            double  Q1_WASTAGE_101 [] = {  101,	151.5,	151.5,	999,	999,	1,	0.31,	1,	0.70,	999,	999,	999,	1          };
            double  Q1_WASTAGE_102 [] = {  102,	153.0,	153.0,	999,	999,	1,	0.32,	1,	0.70,	999,	999,	999,	1          };
            double  Q1_WASTAGE_103 [] = {  103,	154.5,	154.5,	999,	999,	1,	0.33,	1,	0.70,	999,	999,	999,	1          };
            double  Q1_WASTAGE_104 [] = {  104,	156.0,	156.0,	999,	999,	1,	0.34,	1,	0.70,	999,	999,	999,	1          };
            double  Q1_WASTAGE_105 [] = {  105,	157.5,	157.5,	999,	999,	1,	0.35,	1,	0.70,	999,	999,	999,	1          };
            double  Q1_WASTAGE_106 [] = {  106,	159.0,	159.0,	999,	999,	1,	0.36,	1,	0.70,	999,	999,	999,	1          };
            double  Q1_WASTAGE_107 [] = {  107,	160.5,	160.5,	999,	999,	1,	0.37,	1,	0.70,	999,	999,	999,	1          };
            double  Q1_WASTAGE_108 [] = {  108,	162.0,	162.0,	999,	999,	1,	0.38,	1,	0.70,	999,	999,	999,	1          };
            double  Q1_WASTAGE_109 [] = {  109,	163.5,	163.5,	999,	999,	1,	0.39,	1,	0.70,	999,	999,	999,	1          };
            double  Q1_WASTAGE_110 [] = {  110,	165.0,	165.0,	999,	999,	1,	0.40,	1,	0.70,	999,	999,	999,	1          };
            double  Q1_WASTAGE_111 [] = {  111,	166.5,	166.5,	999,	999,	3,	1.11,	999,	999,	999,	999,	999,	1      };
            double  Q1_WASTAGE_112 [] = {  112,	168.0,	168.0,	999,	999,	3,	1.12,	999,	999,	999,	999,	999,	1      };
            double  Q1_WASTAGE_113 [] = {  113,	169.5,	169.5,	999,	999,	3,	1.13,	999,	999,	999,	999,	999,	1      };
            double  Q1_WASTAGE_114 [] = {  114,	171.0,	171.0,	999,	999,	3,	1.14,	999,	999,	999,	999,	999,	1      };
            double  Q1_WASTAGE_115 [] = {  115,	172.5,	172.5,	999,	999,	3,	1.15,	999,	999,	999,	999,	999,	1      };
            double  Q1_WASTAGE_116 [] = {  116,	174.0,	174.0,	999,	999,	3,	1.16,	999,	999,	999,	999,	999,	1      };
            double  Q1_WASTAGE_117 [] = {  117,	175.5,	175.5,	999,	999,	3,	1.17,	999,	999,	999,	999,	999,	1      };
            double  Q1_WASTAGE_118 [] = {  118,	177.0,	177.0,	999,	999,	3,	1.18,	999,	999,	999,	999,	999,	1      };
            double  Q1_WASTAGE_119 [] = {  119,	178.5,	178.5,	999,	999,	3,	1.19,	999,	999,	999,	999,	999,	1      };
            double  Q1_WASTAGE_120 [] = {  120,	180.0,	180.0,	999,	999,	3,	1.20,	999,	999,	999,	999,	999,	1      };
            double  Q1_WASTAGE_121 [] = {  121,	181.5,	181.5,	1,	0.55,	1,	0.40,	1,	0.70,	999,	999,	1,	1                  };
            double  Q1_WASTAGE_122 [] = {  122,	183.0,	183.0,	1,	0.60,	1,	0.40,	1,	0.70,	999,	999,	1,	1                  };
            double  Q1_WASTAGE_123 [] = {  123,	184.5,	184.5,	1,	0.65,	1,	0.40,	1,	0.70,	999,	999,	1,	1                  };
            double  Q1_WASTAGE_124 [] = {  124,	186.0,	186.0,	1,	0.70,	1,	0.40,	1,	0.70,	999,	999,	1,	1                  };
            double  Q1_WASTAGE_125 [] = {  125,	187.5,	187.5,	1,	0.75,	1,	0.40,	1,	0.70,	999,	999,	1,	1                  };
            double  Q1_WASTAGE_126 [] = {  126,	189.0,	189.0,	1,	0.80,	1,	0.40,	1,	0.70,	999,	999,	1,	1                  };
            double  Q1_WASTAGE_127 [] = {  127,	190.5,	190.5,	1,	0.85,	1,	0.40,	1,	0.70,	999,	999,	1,	1                  };
            double  Q1_WASTAGE_128 [] = {  128,	192.0,	192.0,	1,	0.90,	1,	0.40,	1,	0.70,	999,	999,	1,	1                  };
            double  Q1_WASTAGE_129 [] = {  129,	193.5,	193.5,	1,	0.95,	1,	0.40,	1,	0.70,	999,	999,	1,	1                  };
            double  Q1_WASTAGE_130 [] = {  130,	195.0,	195.0,	1,	1.00,	1,	0.40,	1,	0.70,	999,	999,	1,	1                  };
            double  Q1_WASTAGE_131 [] = {  131,	196.5,	196.5,	999,	999,	999,	999,	2,	1.31,	999,	999,	999,	1      };
            double  Q1_WASTAGE_132 [] = {  132,	198.0,	198.0,	999,	999,	999,	999,	2,	1.32,	999,	999,	999,	1      };
            double  Q1_WASTAGE_133 [] = {  133,	199.5,	199.5,	999,	999,	999,	999,	2,	1.33,	999,	999,	999,	1      };
            double  Q1_WASTAGE_134 [] = {  134,	201.0,	201.0,	999,	999,	999,	999,	2,	1.34,	999,	999,	999,	1      };
            double  Q1_WASTAGE_135 [] = {  135,	202.5,	202.5,	999,	999,	999,	999,	2,	1.35,	999,	999,	999,	1      };
            double  Q1_WASTAGE_136 [] = {  136,	204.0,	204.0,	999,	999,	999,	999,	2,	1.36,	999,	999,	999,	1      };
            double  Q1_WASTAGE_137 [] = {  137,	205.5,	205.5,	999,	999,	999,	999,	2,	1.37,	999,	999,	999,	1      };
            double  Q1_WASTAGE_138 [] = {  138,	207.0,	207.0,	999,	999,	999,	999,	2,	1.38,	999,	999,	999,	1      };
            double  Q1_WASTAGE_139 [] = {  139,	208.5,	208.5,	999,	999,	999,	999,	2,	1.39,	999,	999,	999,	1      };
            double  Q1_WASTAGE_140 [] = {  140,	210.0,	210.0,	999,	999,	999,	999,	2,	1.40,	999,	999,	999,	1      };
            double  Q1_WASTAGE_141 [] = {  141,	211.5,	211.5,	999,	999,	2,	0.71,	1,	0.70,	999,	999,	999,	1          };
            double  Q1_WASTAGE_142 [] = {  142,	213.0,	213.0,	999,	999,	2,	0.72,	1,	0.70,	999,	999,	999,	1          };
            double  Q1_WASTAGE_143 [] = {  143,	214.5,	214.5,	999,	999,	2,	0.73,	1,	0.70,	999,	999,	999,	1          };
            double  Q1_WASTAGE_144 [] = {  144,	216.0,	216.0,	999,	999,	2,	0.74,	1,	0.70,	999,	999,	999,	1          };
            double  Q1_WASTAGE_145 [] = {  145,	217.5,	217.5,	999,	999,	2,	0.75,	1,	0.70,	999,	999,	999,	1          };
            double  Q1_WASTAGE_146 [] = {  146,	219.0,	219.0,	999,	999,	2,	0.76,	1,	0.70,	999,	999,	999,	1          };
            double  Q1_WASTAGE_147 [] = {  147,	220.5,	220.5,	999,	999,	2,	0.77,	1,	0.70,	999,	999,	999,	1          };
            double  Q1_WASTAGE_148 [] = {  148,	222.0,	222.0,	999,	999,	2,	0.78,	1,	0.70,	999,	999,	999,	1          };
            double  Q1_WASTAGE_149 [] = {  149,	223.5,	223.5,	999,	999,	2,	0.79,	1,	0.70,	999,	999,	999,	1          };
            double  Q1_WASTAGE_150 [] = {  150,	225.0,	225.0,	999,	999,	2,	0.80,	1,	0.70,	999,	999,	999,	1          };








            double  Q2_WASTAGE_3 [] = {  3,	9.0,	0.30,	1,	0.30,	999,	999,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_4 [] = {  4,	12.0,	0.40,	1,	0.40,	999,	999,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_5 [] = {  5,	15.0,	0.50,	1,	0.50,	999,	999,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_6 [] = {  6,	18.0,	0.60,	1,	0.60,	999,	999,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_7 [] = {  7,	21.0,	0.70,	1,	0.70,	999,	999,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_8 [] = {  8,	24.0,	0.80,	1,	0.80,	999,	999,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_9 [] = {  9,	27.0,	0.90,	1,	0.90,	999,	999,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_10 [] = { 10,	30.0,	1.00,	1,	1.00,	999,	999,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_11 [] = { 11,	33.0,	0.22,	999,	999,	1,	0.22,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_12 [] = { 12,	36.0,	0.24,	999,	999,	1,	0.24,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_13 [] = { 13,	39.0,	0.26,	999,	999,	1,	0.26,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_14 [] = { 14,	42.0,	0.28,	999,	999,	1,	0.28,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_15 [] = { 15,	45.0,	0.30,	999,	999,	1,	0.30,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_16 [] = { 16,	48.0,	0.32,	999,	999,	1,	0.32,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_17 [] = { 17,	51.0,	0.34,	999,	999,	1,	0.34,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_18 [] = { 18,	54.0,	0.36,	999,	999,	1,	0.36,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_19 [] = { 19,	57.0,	0.38,	999,	999,	1,	0.38,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_20 [] = { 20,	60.0,	0.40,	999,	999,	1,	0.40,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_21 [] = { 21,	63.0,	0.50,	1,	0.10,	1,	0.40,	999,	999,	999,	999,	2,	999      };
            double  Q2_WASTAGE_22 [] = { 22,	66.0,	0.60,	1,	0.20,	1,	0.40,	999,	999,	999,	999,	2,	999      };
            double  Q2_WASTAGE_23 [] = { 23,	69.0,	0.70,	1,	0.30,	1,	0.40,	999,	999,	999,	999,	2,	999      };
            double  Q2_WASTAGE_24 [] = { 24,	72.0,	0.80,	1,	0.40,	1,	0.40,	999,	999,	999,	999,	2,	999      };
            double  Q2_WASTAGE_25 [] = { 25,	75.0,	0.90,	1,	0.50,	1,	0.40,	999,	999,	999,	999,	2,	999      };
            double  Q2_WASTAGE_26 [] = { 26,	78.0,	1.00,	1,	0.60,	1,	0.40,	999,	999,	999,	999,	2,	999      };
            double  Q2_WASTAGE_27 [] = { 27,	81.0,	1.10,	1,	0.70,	1,	0.40,	999,	999,	999,	999,	2,	999      };
            double  Q2_WASTAGE_28 [] = { 28,	84.0,	1.20,	1,	0.80,	1,	0.40,	999,	999,	999,	999,	2,	999      };
            double  Q2_WASTAGE_29 [] = { 29,	87.0,	1.30,	1,	0.90,	1,	0.40,	999,	999,	999,	999,	2,	999      };
            double  Q2_WASTAGE_30 [] = { 30,	90.0,	1.40,	1,	1.00,	1,	0.40,	999,	999,	999,	999,	2,	999      };
            double  Q2_WASTAGE_31 [] = { 31,	93.0,	0.62,	999,	999,	999,	999,	1,	0.62,	999,	999,	1,	999      };
            double  Q2_WASTAGE_32 [] = { 32,	96.0,	0.64,	999,	999,	999,	999,	1,	0.64,	999,	999,	1,	999      };
            double  Q2_WASTAGE_33 [] = { 33,	99.0,	0.66,	999,	999,	999,	999,	1,	0.66,	999,	999,	1,	999      };
            double  Q2_WASTAGE_34 [] = { 34,	102.0,	0.68,	999,	999,	999,	999,	1,	0.68,	999,	999,	1,	999      };
            double  Q2_WASTAGE_35 [] = { 35,	105.0,	0.70,	999,	999,	999,	999,	1,	0.70,	999,	999,	1,	999      };
            double  Q2_WASTAGE_36 [] = { 36,	108.0,	0.72,	999,	999,	2,	0.72,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_37 [] = { 37,	111.0,	0.74,	999,	999,	2,	0.74,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_38 [] = { 38,	114.0,	0.76,	999,	999,	2,	0.76,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_39 [] = { 39,	117.0,	0.78,	999,	999,	2,	0.78,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_40 [] = { 40,	120.0,	0.80,	999,	999,	2,	0.80,	999,	999,	999,	999,	1,	999      };
            double  Q2_WASTAGE_41 [] = { 41,	123.0,	1.30,	1,	0.60,	999,	999,	1,	0.70,	999,	999,	2,	999      };
            double  Q2_WASTAGE_42 [] = { 42,	126.0,	1.40,	1,	0.70,	999,	999,	1,	0.70,	999,	999,	2,	999      };
            double  Q2_WASTAGE_43 [] = { 43,	129.0,	1.50,	1,	0.80,	999,	999,	1,	0.70,	999,	999,	2,	999      };
            double  Q2_WASTAGE_44 [] = { 44,	132.0,	1.60,	1,	0.90,	999,	999,	1,	0.70,	999,	999,	2,	999      };
            double  Q2_WASTAGE_45 [] = { 45,	135.0,	1.70,	1,	1.00,	999,	999,	1,	0.70,	999,	999,	2,	999      };
            double  Q2_WASTAGE_46 [] = { 46,	138.0,	0.92,	999,	999,	999,	999,	999,	999,	1,	0.92,	1,	999      };
            double  Q2_WASTAGE_47 [] = { 47,	141.0,	0.94,	999,	999,	999,	999,	999,	999,	1,	0.94,	1,	999      };
            double  Q2_WASTAGE_48 [] = { 48,	144.0,	0.96,	999,	999,	999,	999,	999,	999,	1,	0.96,	1,	999      };
            double  Q2_WASTAGE_49 [] = { 49,	147.0,	0.98,	999,	999,	999,	999,	999,	999,	1,	0.98,	1,	999      };
            double  Q2_WASTAGE_50 [] = { 50,	150.0,	1.00,	999,	999,	999,	999,	999,	999,	1,	1.00,	1,	999      };
            double  Q2_WASTAGE_51 [] = { 51,	153.0,	1.02,	999,	999,	1,	0.32,	1,	0.70,	999,	999,	999,	1      };
            double  Q2_WASTAGE_52 [] = { 52,	156.0,	1.04,	999,	999,	1,	0.34,	1,	0.70,	999,	999,	999,	1      };
            double  Q2_WASTAGE_53 [] = { 53,	159.0,	1.06,	999,	999,	1,	0.36,	1,	0.70,	999,	999,	999,	1      };
            double  Q2_WASTAGE_54 [] = { 54,	162.0,	1.08,	999,	999,	1,	0.38,	1,	0.70,	999,	999,	999,	1      };
            double  Q2_WASTAGE_55 [] = { 55,	165.0,	1.10,	999,	999,	1,	0.40,	1,	0.70,	999,	999,	999,	1      };
            double  Q2_WASTAGE_56 [] = { 56,	168.0,	1.12,	999,	999,	3,	1.12,	999,	999,	999,	999,	999,	1      };
            double  Q2_WASTAGE_57 [] = { 57,	171.0,	1.14,	999,	999,	3,	1.14,	999,	999,	999,	999,	999,	1      };
            double  Q2_WASTAGE_58 [] = { 58,	174.0,	1.16,	999,	999,	3,	1.16,	999,	999,	999,	999,	999,	1      };
            double  Q2_WASTAGE_59 [] = { 59,	177.0,	1.18,	999,	999,	3,	1.18,	999,	999,	999,	999,	999,	1      };
            double  Q2_WASTAGE_60 [] = { 60,	180.0,	1.20,	999,	999,	3,	1.20,	999,	999,	999,	999,	999,	1      };
            double  Q2_WASTAGE_61 [] = { 61,	183.0,	1.70,	1,	0.60,	1,	0.40,	1,	0.70,	999,	999,	1,	1      };
            double  Q2_WASTAGE_62 [] = { 62,	186.0,	1.80,	1,	0.70,	1,	0.40,	1,	0.70,	999,	999,	1,	1      };
            double  Q2_WASTAGE_63 [] = { 63,	189.0,	1.90,	1,	0.80,	1,	0.40,	1,	0.70,	999,	999,	1,	1      };
            double  Q2_WASTAGE_64 [] = { 64,	192.0,	2.00,	1,	0.90,	1,	0.40,	1,	0.70,	999,	999,	1,	1      };
            double  Q2_WASTAGE_65 [] = { 65,	195.0,	2.10,	1,	1.00,	1,	0.40,	1,	0.70,	999,	999,	1,	1      };
            double  Q2_WASTAGE_66 [] = { 66,	198.0,	1.32,	999,	999,	999,	999,	2,	1.32,	999,	999,	999,	1      };
            double  Q2_WASTAGE_67 [] = { 67,	201.0,	1.34,	999,	999,	999,	999,	2,	1.34,	999,	999,	999,	1      };
            double  Q2_WASTAGE_68 [] = { 68,	204.0,	1.36,	999,	999,	999,	999,	2,	1.36,	999,	999,	999,	1      };
            double  Q2_WASTAGE_69 [] = { 69,	207.0,	1.38,	999,	999,	999,	999,	2,	1.38,	999,	999,	999,	1      };
            double  Q2_WASTAGE_70 [] = { 70,	210.0,	1.40,	999,	999,	999,	999,	2,	1.40,	999,	999,	999,	1      };
            double  Q2_WASTAGE_71 [] = { 71,	213.0,	1.42,	999,	999,	2,	0.72,	1,	0.70,	999,	999,	999,	1      };
            double  Q2_WASTAGE_72 [] = { 72,	216.0,	1.44,	999,	999,	2,	0.74,	1,	0.70,	999,	999,	999,	1      };
            double  Q2_WASTAGE_73 [] = { 73,	219.0,	1.46,	999,	999,	2,	0.76,	1,	0.70,	999,	999,	999,	1      };
            double  Q2_WASTAGE_74 [] = { 74,	222.0,	1.48,	999,	999,	2,	0.78,	1,	0.70,	999,	999,	999,	1      };
            double  Q2_WASTAGE_75 [] = { 75,	225.0,	1.50,	999,	999,	2,	0.80,	1,	0.70,	999,	999,	999,	1      };
            double  Q2_WASTAGE_76 [] = { 76,	228.0,	1.52,	999,	999,	4,	1.52,	999,	999,	999,	999,	999,	1      };
            double  Q2_WASTAGE_77 [] = { 77,	231.0,	1.54,	999,	999,	4,	1.54,	999,	999,	999,	999,	999,	1      };
            double  Q2_WASTAGE_78 [] = { 78,	234.0,	1.56,	999,	999,	4,	1.56,	999,	999,	999,	999,	999,	1      };
            double  Q2_WASTAGE_79 [] = { 79,	237.0,	1.58,	999,	999,	4,	1.58,	999,	999,	999,	999,	999,	1      };
            double  Q2_WASTAGE_80 [] = { 80,	240.0,	1.60,	999,	999,	4,	1.60,	999,	999,	999,	999,	999,	1      };
            double  Q2_WASTAGE_81 [] = { 81,	243.0,	1.62,	999,	999,	999,	999,	1,	0.62,	1,	1.00,	999,	1      };
            double  Q2_WASTAGE_82 [] = { 82,	246.0,	1.64,	999,	999,	999,	999,	1,	0.64,	1,	1.00,	999,	1      };
            double  Q2_WASTAGE_83 [] = { 83,	249.0,	1.66,	999,	999,	999,	999,	1,	0.66,	1,	1.00,	999,	1      };
            double  Q2_WASTAGE_84 [] = { 84,	252.0,	1.68,	999,	999,	999,	999,	1,	0.68,	1,	1.00,	999,	1      };
            double  Q2_WASTAGE_85 [] = { 85,	255.0,	1.70,	999,	999,	999,	999,	1,	0.70,	1,	1.00,	999,	1      };
            double  Q2_WASTAGE_86 [] = { 86,	258.0,	1.72,	999,	999,	2,	0.72,	999,	999,	1,	1.00,	999,	1      };
            double  Q2_WASTAGE_87 [] = { 87,	261.0,	1.74,	999,	999,	2,	0.74,	999,	999,	1,	1.00,	999,	1      };
            double  Q2_WASTAGE_88 [] = { 88,	264.0,	1.76,	999,	999,	2,	0.76,	999,	999,	1,	1.00,	999,	1      };
            double  Q2_WASTAGE_89 [] = { 89,	267.0,	1.78,	999,	999,	2,	0.78,	999,	999,	1,	1.00,	999,	1      };
            double  Q2_WASTAGE_90 [] = { 90,	270.0,	1.80,	999,	999,	2,	0.80,	999,	999,	1,	1.00,	999,	1      };
            double  Q2_WASTAGE_91 [] = { 91,	273.0,	1.82,	999,	999,	3,	1.12,	1,	0.70,	999,	999,	999,	1      };
            double  Q2_WASTAGE_92 [] = { 92,	276.0,	1.84,	999,	999,	3,	1.14,	1,	0.70,	999,	999,	999,	1      };
            double  Q2_WASTAGE_93 [] = { 93,	279.0,	1.86,	999,	999,	3,	1.16,	1,	0.70,	999,	999,	999,	1      };
            double  Q2_WASTAGE_94 [] = { 94,	282.0,	1.88,	999,	999,	3,	1.18,	1,	0.70,	999,	999,	999,	1      };
            double  Q2_WASTAGE_95 [] = { 95,	285.0,	1.90,	999,	999,	3,	1.20,	1,	0.70,	999,	999,	999,	1      };
            double  Q2_WASTAGE_96 [] = { 96,	288.0,	1.92,	999,	999,	999,	999,	999,	999,	2,	1.92,	999,	1      };
            double  Q2_WASTAGE_97 [] = { 97,	291.0,	1.94,	999,	999,	999,	999,	999,	999,	2,	1.94,	999,	1      };
            double  Q2_WASTAGE_98 [] = { 98,	294.0,	1.96,	999,	999,	999,	999,	999,	999,	2,	1.96,	999,	1      };
            double  Q2_WASTAGE_99 [] = { 99,	297.0,	1.98,	999,	999,	999,	999,	999,	999,	2,	1.98,	999,	1      };
            double  Q2_WASTAGE_100 [] = {100,	300.0,	2.00,	999,	999,	999,	999,	999,	999,	2,	2.00,	999,	1      };
            double  Q2_WASTAGE_101 [] = {101,	303.0,	2.02,	999,	999,	999,	999,	3,	2.02,	999,	999,	1,	1      };
            double  Q2_WASTAGE_102 [] = {102,	306.0,	2.04,	999,	999,	999,	999,	3,	2.04,	999,	999,	1,	1      };
            double  Q2_WASTAGE_103 [] = {103,	309.0,	2.06,	999,	999,	999,	999,	3,	2.06,	999,	999,	1,	1      };
            double  Q2_WASTAGE_104 [] = {104,	312.0,	2.08,	999,	999,	999,	999,	3,	2.08,	999,	999,	1,	1      };
            double  Q2_WASTAGE_105 [] = {105,	315.0,	2.10,	999,	999,	999,	999,	3,	2.10,	999,	999,	1,	1      };
            double  Q2_WASTAGE_106 [] = {106,	318.0,	2.12,	999,	999,	2,	0.72,	2,	1.40,	999,	999,	1,	1      };
            double  Q2_WASTAGE_107 [] = {107,	321.0,	2.14,	999,	999,	2,	0.74,	2,	1.40,	999,	999,	1,	1      };
            double  Q2_WASTAGE_108 [] = {108,	324.0,	2.16,	999,	999,	2,	0.76,	2,	1.40,	999,	999,	1,	1      };
            double  Q2_WASTAGE_109 [] = {109,	327.0,	2.18,	999,	999,	2,	0.78,	2,	1.40,	999,	999,	1,	1      };
            double  Q2_WASTAGE_110 [] = {110,	330.0,	2.20,	999,	999,	2,	0.80,	2,	1.40,	999,	999,	1,	1      };
            double  Q2_WASTAGE_111 [] = {111,	333.0,	2.22,	999,	999,	4,	1.52,	1,	0.70,	999,	999,	1,	1      };
            double  Q2_WASTAGE_112 [] = {112,	336.0,	2.24,	999,	999,	4,	1.54,	1,	0.70,	999,	999,	1,	1      };
            double  Q2_WASTAGE_113 [] = {113,	339.0,	2.26,	999,	999,	4,	1.56,	1,	0.70,	999,	999,	1,	1      };
            double  Q2_WASTAGE_114 [] = {114,	342.0,	2.28,	999,	999,	4,	1.58,	1,	0.70,	999,	999,	1,	1      };
            double  Q2_WASTAGE_115 [] = {115,	345.0,	2.30,	999,	999,	4,	1.60,	1,	0.70,	999,	999,	1,	1      };
            double  Q2_WASTAGE_116 [] = {116,	348.0,	2.32,	999,	999,	1,	0.32,	999,	999,	2,	2.00,	1,	1      };
            double  Q2_WASTAGE_117 [] = {117,	351.0,	2.34,	999,	999,	1,	0.34,	999,	999,	2,	2.00,	1,	1      };
            double  Q2_WASTAGE_118 [] = {118,	354.0,	2.36,	999,	999,	1,	0.36,	999,	999,	2,	2.00,	1,	1      };
            double  Q2_WASTAGE_119 [] = {119,	357.0,	2.38,	999,	999,	1,	0.38,	999,	999,	2,	2.00,	1,	1      };
            double  Q2_WASTAGE_120 [] = {120,	360.0,	2.40,	999,	999,	1,	0.40,	999,	999,	2,	2.00,	1,	1      };
            double  Q2_WASTAGE_121 [] = {121,	363.0,	2.42,	999,	999,	1,	0.32,	3,	2.10,	999,	999,	1,	1      };
            double  Q2_WASTAGE_122 [] = {122,	366.0,	2.44,	999,	999,	1,	0.34,	3,	2.10,	999,	999,	1,	1      };
            double  Q2_WASTAGE_123 [] = {123,	369.0,	2.46,	999,	999,	1,	0.36,	3,	2.10,	999,	999,	1,	1      };
            double  Q2_WASTAGE_124 [] = {124,	372.0,	2.48,	999,	999,	1,	0.38,	3,	2.10,	999,	999,	1,	1      };
            double  Q2_WASTAGE_125 [] = {125,	375.0,	2.50,	999,	999,	1,	0.40,	3,	2.10,	999,	999,	1,	1      };
            double  Q2_WASTAGE_126 [] = {126,	378.0,	2.52,	999,	999,	4,	1.52,	999,	999,	1,	1.00,	1,	1      };
            double  Q2_WASTAGE_127 [] = {127,	381.0,	2.54,	999,	999,	4,	1.54,	999,	999,	1,	1.00,	1,	1      };
            double  Q2_WASTAGE_128 [] = {128,	384.0,	2.56,	999,	999,	4,	1.56,	999,	999,	1,	1.00,	1,	1      };
            double  Q2_WASTAGE_129 [] = {129,	387.0,	2.58,	999,	999,	4,	1.58,	999,	999,	1,	1.00,	1,	1      };
            double  Q2_WASTAGE_130 [] = {130,	390.0,	2.60,	999,	999,	4,	1.60,	999,	999,	1,	1.00,	1,	1      };
            double  Q2_WASTAGE_131 [] = {131,	393.0,	2.62,	999,	999,	999,	999,	1,	0.62,	2,	2.00,	1,	1      };
            double  Q2_WASTAGE_132 [] = {132,	396.0,	2.64,	999,	999,	999,	999,	1,	0.64,	2,	2.00,	1,	1      };
            double  Q2_WASTAGE_133 [] = {133,	399.0,	2.66,	999,	999,	999,	999,	1,	0.66,	2,	2.00,	1,	1      };
            double  Q2_WASTAGE_134 [] = {134,	402.0,	2.68,	999,	999,	999,	999,	1,	0.68,	2,	2.00,	1,	1      };
            double  Q2_WASTAGE_135 [] = {135,	405.0,	2.70,	999,	999,	999,	999,	1,	0.70,	2,	2.00,	1,	1      };
            double  Q2_WASTAGE_136 [] = {136,	408.0,	2.72,	999,	999,	2,	0.72,	999,	999,	2,	2.00,	1,	1      };
            double  Q2_WASTAGE_137 [] = {137,	411.0,	2.74,	999,	999,	2,	0.74,	999,	999,	2,	2.00,	1,	1      };
            double  Q2_WASTAGE_138 [] = {138,	414.0,	2.76,	999,	999,	2,	0.76,	999,	999,	2,	2.00,	1,	1      };
            double  Q2_WASTAGE_139 [] = {139,	417.0,	2.78,	999,	999,	2,	0.78,	999,	999,	2,	2.00,	1,	1      };
            double  Q2_WASTAGE_140 [] = {140,	420.0,	2.80,	999,	999,	2,	0.80,	999,	999,	2,	2.00,	1,	1      };
            double  Q2_WASTAGE_141 [] = {141,	423.0,	2.82,	999,	999,	2,	0.72,	3,	2.10,	999,	999,	1,	1      };
            double  Q2_WASTAGE_142 [] = {142,	426.0,	2.84,	999,	999,	2,	0.74,	3,	2.10,	999,	999,	1,	1      };
            double  Q2_WASTAGE_143 [] = {143,	429.0,	2.86,	999,	999,	2,	0.76,	3,	2.10,	999,	999,	1,	1      };
            double  Q2_WASTAGE_144 [] = {144,	432.0,	2.88,	999,	999,	2,	0.78,	3,	2.10,	999,	999,	1,	1      };
            double  Q2_WASTAGE_145 [] = {145,	435.0,	2.90,	999,	999,	2,	0.80,	3,	2.10,	999,	999,	1,	1      };
            double  Q2_WASTAGE_146 [] = {146,	438.0,	2.92,	999,	999,	999,	999,	999,	999,	3,	2.92,	1,	1      };
            double  Q2_WASTAGE_147 [] = {147,	441.0,	2.94,	999,	999,	999,	999,	999,	999,	3,	2.94,	1,	1      };
            double  Q2_WASTAGE_148 [] = {148,	444.0,	2.96,	999,	999,	999,	999,	999,	999,	3,	2.96,	1,	1      };
            double  Q2_WASTAGE_149 [] = {149,	447.0,	2.98,	999,	999,	999,	999,	999,	999,	3,	2.98,	1,	1      };
            double  Q2_WASTAGE_150 [] = {150,	450.0,	3.00,	999,	999,	999,	999,	999,	999,	3,	3.00,	1,	1      };









            double  Q4_WASTAGE_3 [] = {   3,	18,	0.60,	1,	0.60,	999,	999,	999,	999,	999,	999,	1,	999     };
            double  Q4_WASTAGE_4 [] = {   4,	24,	0.80,	1,	0.80,	999,	999,	999,	999,	999,	999,	1,	999     };
            double  Q4_WASTAGE_5 [] = {   5,	30,	1.00,	1,	1.00,	999,	999,	999,	999,	999,	999,	1,	999     };
            double  Q4_WASTAGE_6 [] = {   6,	36,	0.24,	999,	999,	1,	0.24,	999,	999,	999,	999,	1,	999     };
            double  Q4_WASTAGE_7 [] = {   7,	42,	0.28,	999,	999,	1,	0.28,	999,	999,	999,	999,	1,	999     };
            double  Q4_WASTAGE_8 [] = {   8,	48,	0.32,	999,	999,	1,	0.32,	999,	999,	999,	999,	1,	999     };
            double  Q4_WASTAGE_9 [] = {   9,	54,	0.36,	999,	999,	1,	0.36,	999,	999,	999,	999,	1,	999     };
            double  Q4_WASTAGE_10 [] = {  10,	60,	0.40,	999,	999,	1,	0.40,	999,	999,	999,	999,	1,	999     };
            double  Q4_WASTAGE_11 [] = {  11,	66,	0.60,	1,	0.20,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q4_WASTAGE_12 [] = {  12,	72,	0.80,	1,	0.40,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q4_WASTAGE_13 [] = {  13,	78,	1.00,	1,	0.60,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q4_WASTAGE_14 [] = {  14,	84,	1.20,	1,	0.80,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q4_WASTAGE_15 [] = {  15,	90,	1.40,	1,	1.00,	1,	0.40,	999,	999,	999,	999,	2,	999     };
            double  Q4_WASTAGE_16 [] = {  16,	96,	0.64,	999,	999,	999,	999,	1,	0.64,	999,	999,	1,	999     };
            double  Q4_WASTAGE_17 [] = {  17,	102,	0.68,	999,	999,	999,	999,	1,	0.68,	999,	999,	1,	999     };
            double  Q4_WASTAGE_18 [] = {  18,	108,	0.72,	999,	999,	2,	0.72,	999,	999,	999,	999,	1,	999     };
            double  Q4_WASTAGE_19 [] = {  19,	114,	0.76,	999,	999,	2,	0.76,	999,	999,	999,	999,	1,	999     };
            double  Q4_WASTAGE_20 [] = {  20,	120,	0.80,	999,	999,	2,	0.80,	999,	999,	999,	999,	1,	999     };
            double  Q4_WASTAGE_21 [] = {  21,	126,	1.40,	1,	0.70,	999,	999,	1,	0.70,	999,	999,	2,	999     };
            double  Q4_WASTAGE_22 [] = {  22,	132,	1.60,	1,	0.90,	999,	999,	1,	0.70,	999,	999,	2,	999     };
            double  Q4_WASTAGE_23 [] = {  23,	138,	0.92,	999,	999,	999,	999,	999,	999,	1,	0.92,	1,	999     };
            double  Q4_WASTAGE_24 [] = {  24,	144,	0.96,	999,	999,	999,	999,	999,	999,	1,	0.96,	1,	999     };
            double  Q4_WASTAGE_25 [] = {  25,	150,	1.00,	999,	999,	999,	999,	999,	999,	1,	1.00,	1,	999     };
            double  Q4_WASTAGE_26 [] = {  26,	156,	1.04,	999,	999,	1,	0.34,	1,	0.70,	999,	999,	999,	1     };
            double  Q4_WASTAGE_27 [] = {  27,	162,	1.08,	999,	999,	1,	0.38,	1,	0.70,	999,	999,	999,	1     };
            double  Q4_WASTAGE_28 [] = {  28,	168,	1.12,	999,	999,	3,	1.12,	999,	999,	999,	999,	999,	1     };
            double  Q4_WASTAGE_29 [] = {  29,	174,	1.16,	999,	999,	3,	1.16,	999,	999,	999,	999,	999,	1     };
            double  Q4_WASTAGE_30 [] = {  30,	180,	1.20,	999,	999,	3,	1.20,	999,	999,	999,	999,	999,	1     };
            double  Q4_WASTAGE_31 [] = {  31,	186,	1.80,	1,	0.70,	1,	0.40,	1,	0.70,	999,	999,	1,	1     };
            double  Q4_WASTAGE_32 [] = {  32,	192,	2.00,	1,	0.90,	1,	0.40,	1,	0.70,	999,	999,	1,	1     };
            double  Q4_WASTAGE_33 [] = {  33,	198,	1.32,	999,	999,	999,	999,	2,	1.32,	999,	999,	999,	1     };
            double  Q4_WASTAGE_34 [] = {  34,	204,	1.36,	999,	999,	999,	999,	2,	1.36,	999,	999,	999,	1     };
            double  Q4_WASTAGE_35 [] = {  35,	210,	1.40,	999,	999,	999,	999,	2,	1.40,	999,	999,	999,	1     };
            double  Q4_WASTAGE_36 [] = {  36,	216,	1.44,	999,	999,	2,	0.74,	1,	0.70,	999,	999,	999,	1     };
            double  Q4_WASTAGE_37 [] = {  37,	222,	1.48,	999,	999,	2,	0.78,	1,	0.70,	999,	999,	999,	1     };
            double  Q4_WASTAGE_38 [] = {  38,	228,	1.52,	999,	999,	4,	1.52,	999,	999,	999,	999,	999,	1     };
            double  Q4_WASTAGE_39 [] = {  39,	234,	1.56,	999,	999,	4,	1.56,	999,	999,	999,	999,	999,	1     };
            double  Q4_WASTAGE_40 [] = {  40,	240,	1.60,	999,	999,	4,	1.60,	999,	999,	999,	999,	999,	1     };
            double  Q4_WASTAGE_41 [] = {  41,	246,	1.64,	999,	999,	999,	999,	1,	0.64,	1,	1.00,	999,	1     };
            double  Q4_WASTAGE_42 [] = {  42,	252,	1.68,	999,	999,	999,	999,	1,	0.68,	1,	1.00,	999,	1     };
            double  Q4_WASTAGE_43 [] = {  43,	258,	1.72,	999,	999,	2,	0.72,	999,	999,	1,	1.00,	999,	1     };
            double  Q4_WASTAGE_44 [] = {  44,	264,	1.76,	999,	999,	2,	0.76,	999,	999,	1,	1.00,	999,	1     };
            double  Q4_WASTAGE_45 [] = {  45,	270,	1.80,	999,	999,	2,	0.80,	999,	999,	1,	1.00,	999,	1     };
            double  Q4_WASTAGE_46 [] = {  46,	276,	1.84,	999,	999,	3,	1.14,	1,	0.70,	999,	999,	999,	1     };
            double  Q4_WASTAGE_47 [] = {  47,	282,	1.88,	999,	999,	3,	1.18,	1,	0.70,	999,	999,	999,	1     };
            double  Q4_WASTAGE_48 [] = {  48,	288,	1.92,	999,	999,	999,	999,	999,	999,	2,	1.92,	999,	1     };
            double  Q4_WASTAGE_49 [] = {  49,	294,	1.96,	999,	999,	999,	999,	999,	999,	2,	1.96,	999,	1     };
            double  Q4_WASTAGE_50 [] = {  50,	300,	2.00,	999,	999,	999,	999,	999,	999,	2,	2.00,	999,	1     };
            double  Q4_WASTAGE_51 [] = {  51,	306,	2.04,	999,	999,	999,	999,	3,	2.04,	999,	999,	1,	1     };
            double  Q4_WASTAGE_52 [] = {  52,	312,	2.08,	999,	999,	999,	999,	3,	2.08,	999,	999,	1,	1     };
            double  Q4_WASTAGE_53 [] = {  53,	318,	2.12,	999,	999,	2,	0.72,	2,	1.40,	999,	999,	1,	1     };
            double  Q4_WASTAGE_54 [] = {  54,	324,	2.16,	999,	999,	2,	0.76,	2,	1.40,	999,	999,	1,	1     };
            double  Q4_WASTAGE_55 [] = {  55,	330,	2.20,	999,	999,	2,	0.80,	2,	1.40,	999,	999,	1,	1     };
            double  Q4_WASTAGE_56 [] = {  56,	336,	2.24,	999,	999,	4,	1.54,	1,	0.70,	999,	999,	1,	1     };
            double  Q4_WASTAGE_57 [] = {  57,	342,	2.28,	999,	999,	4,	1.58,	1,	0.70,	999,	999,	1,	1     };
            double  Q4_WASTAGE_58 [] = {  58,	348,	2.32,	999,	999,	1,	0.32,	999,	999,	2,	2.00,	1,	1     };
            double  Q4_WASTAGE_59 [] = {  59,	354,	2.36,	999,	999,	1,	0.36,	999,	999,	2,	2.00,	1,	1     };
            double  Q4_WASTAGE_60 [] = {  60,	360,	2.40,	999,	999,	1,	0.40,	999,	999,	2,	2.00,	1,	1     };
            double  Q4_WASTAGE_61 [] = {  61,	366,	2.44,	999,	999,	1,	0.34,	3,	2.10,	999,	999,	1,	1     };
            double  Q4_WASTAGE_62 [] = {  62,	372,	2.48,	999,	999,	1,	0.38,	3,	2.10,	999,	999,	1,	1     };
            double  Q4_WASTAGE_63 [] = {  63,	378,	2.52,	999,	999,	4,	1.52,	999,	999,	1,	1.00,	1,	1     };
            double  Q4_WASTAGE_64 [] = {  64,	384,	2.56,	999,	999,	4,	1.56,	999,	999,	1,	1.00,	1,	1     };
            double  Q4_WASTAGE_65 [] = {  65,	390,	2.60,	999,	999,	4,	1.60,	999,	999,	1,	1.00,	1,	1     };
            double  Q4_WASTAGE_66 [] = {  66,	396,	2.64,	999,	999,	999,	999,	1,	0.64,	2,	2.00,	1,	1     };
            double  Q4_WASTAGE_67 [] = {  67,	402,	2.68,	999,	999,	999,	999,	1,	0.68,	2,	2.00,	1,	1     };
            double  Q4_WASTAGE_68 [] = {  68,	408,	2.72,	999,	999,	2,	0.72,	999,	999,	2,	2.00,	1,	1     };
            double  Q4_WASTAGE_69 [] = {  69,	414,	2.76,	999,	999,	2,	0.76,	999,	999,	2,	2.00,	1,	1     };
            double  Q4_WASTAGE_70 [] = {  70,	420,	2.80,	999,	999,	2,	0.80,	999,	999,	2,	2.00,	1,	1     };
            double  Q4_WASTAGE_71 [] = {  71,	426,	2.84,	999,	999,	2,	0.74,	3,	2.10,	999,	999,	1,	1     };
            double  Q4_WASTAGE_72 [] = {  72,	432,	2.88,	999,	999,	2,	0.78,	3,	2.10,	999,	999,	1,	1     };
            double  Q4_WASTAGE_73 [] = {  73,	438,	2.92,	999,	999,	999,	999,	999,	999,	3,	2.92,	1,	1     };
            double  Q4_WASTAGE_74 [] = {  74,	444,	2.96,	999,	999,	999,	999,	999,	999,	3,	2.96,	1,	1     };
            double  Q4_WASTAGE_75 [] = {  75,	450,	3.00,	999,	999,	999,	999,	999,	999,	3,	3.00,	1,	1     };
            double  Q4_WASTAGE_76 [] = {  76,	456,	3.04,	999,	999,	999,	999,	3,	2.04,	1,	1.00,	999,	2     };
            double  Q4_WASTAGE_77 [] = {  77,	462,	3.08,	999,	999,	999,	999,	3,	2.08,	1,	1.00,	999,	2     };
            double  Q4_WASTAGE_78 [] = {  78,	468,	3.12,	999,	999,	1,	0.32,	4,	2.80,	999,	999,	999,	2     };
            double  Q4_WASTAGE_79 [] = {  79,	474,	3.16,	999,	999,	1,	0.36,	4,	2.80,	999,	999,	999,	2     };
            double  Q4_WASTAGE_80 [] = {  80,	480,	3.20,	999,	999,	1,	0.40,	4,	2.80,	999,	999,	999,	2     };
            double  Q4_WASTAGE_81 [] = {  81,	486,	3.24,	999,	999,	3,	1.14,	3,	2.10,	999,	999,	999,	2     };
            double  Q4_WASTAGE_82 [] = {  82,	492,	3.28,	999,	999,	3,	1.18,	3,	2.10,	999,	999,	999,	2     };
            double  Q4_WASTAGE_83 [] = {  83,	498,	3.32,	999,	999,	1,	0.32,	999,	999,	3,	3.00,	999,	2     };
            double  Q4_WASTAGE_84 [] = {  84,	504,	3.36,	999,	999,	1,	0.36,	999,	999,	3,	3.00,	999,	2     };
            double  Q4_WASTAGE_85 [] = {  85,	510,	3.40,	999,	999,	1,	0.40,	999,	999,	3,	3.00,	999,	2     };
            double  Q4_WASTAGE_86 [] = {  86,	516,	3.44,	999,	999,	999,	999,	5,	3.44,	999,	999,	999,	2     };
            double  Q4_WASTAGE_87 [] = {  87,	522,	3.48,	999,	999,	999,	999,	5,	3.48,	999,	999,	999,	2     };
            double  Q4_WASTAGE_88 [] = {  88,	528,	3.52,	999,	999,	2,	0.72,	4,	2.80,	999,	999,	999,	2     };
            double  Q4_WASTAGE_89 [] = {  89,	534,	3.56,	999,	999,	2,	0.76,	4,	2.80,	999,	999,	999,	2     };
            double  Q4_WASTAGE_90 [] = {  90,	540,	3.60,	999,	999,	2,	0.80,	4,	2.80,	999,	999,	999,	2     };
            double  Q4_WASTAGE_91 [] = {  91,	546,	3.64,	999,	999,	999,	999,	1,	0.64,	3,	3.00,	999,	2     };
            double  Q4_WASTAGE_92 [] = {  92,	552,	3.68,	999,	999,	999,	999,	1,	0.68,	3,	3.00,	999,	2     };
            double  Q4_WASTAGE_93 [] = {  93,	558,	3.72,	999,	999,	999,	999,	4,	2.72,	1,	1.00,	999,	2     };
            double  Q4_WASTAGE_94 [] = {  94,	564,	3.76,	999,	999,	999,	999,	4,	2.76,	1,	1.00,	999,	2     };
            double  Q4_WASTAGE_95 [] = {  95,	570,	3.80,	999,	999,	999,	999,	4,	2.80,	1,	1.00,	999,	2     };
            double  Q4_WASTAGE_96 [] = {  96,	576,	3.84,	999,	999,	1,	0.34,	5,	2.80,	999,	999,	999,	2     };
            double  Q4_WASTAGE_97 [] = {  97,	582,	3.88,	999,	999,	1,	0.38,	5,	2.80,	999,	999,	999,	2     };
            double  Q4_WASTAGE_98 [] = {  98,	588,	3.92,	999,	999,	999,	999,	999,	999,	4,	3.92,	999,	2     };
            double  Q4_WASTAGE_99 [] = {  99,	594,	3.96,	999,	999,	999,	999,	999,	999,	4,	3.96,	999,	2     };
            double  Q4_WASTAGE_100 [] = { 100,	600,	4.00,	999,	999,	999,	999,	999,	999,	4,	4.00,	999,	2     };
            double  Q4_WASTAGE_101 [] = { 101,	606,	4.04,	999,	999,	999,	999,	3,	2.04,	2,	2.00,	1,	2     };
            double  Q4_WASTAGE_102 [] = { 102,	612,	4.08,	999,	999,	999,	999,	3,	2.08,	2,	2.00,	1,	2     };
            double  Q4_WASTAGE_103 [] = { 103,	618,	4.12,	999,	999,	999,	999,	6,	4.12,	999,	999,	1,	2     };
            double  Q4_WASTAGE_104 [] = { 104,	624,	4.16,	999,	999,	999,	999,	6,	4.16,	999,	999,	1,	2     };
            double  Q4_WASTAGE_105 [] = { 105,	630,	4.20,	999,	999,	999,	999,	6,	4.20,	999,	999,	1,	2     };
            double  Q4_WASTAGE_106 [] = { 106,	636,	4.24,	999,	999,	3,	1.14,	3,	2.10,	1,	1.00,	1,	2     };
            double  Q4_WASTAGE_107 [] = { 107,	642,	4.28,	999,	999,	3,	1.18,	3,	2.10,	1,	1.00,	1,	2     };
            double  Q4_WASTAGE_108 [] = { 108,	648,	4.32,	999,	999,	1,	0.32,	999,	999,	4,	4.00,	1,	2     };
            double  Q4_WASTAGE_109 [] = { 109,	654,	4.36,	999,	999,	1,	0.36,	999,	999,	4,	4.00,	1,	2     };
            double  Q4_WASTAGE_110 [] = { 110,	660,	4.40,	999,	999,	1,	0.40,	999,	999,	4,	4.00,	1,	2     };
            double  Q4_WASTAGE_111 [] = { 111,	666,	4.44,	999,	999,	1,	0.34,	3,	2.10,	2,	2.00,	1,	2     };
            double  Q4_WASTAGE_112 [] = { 112,	672,	4.48,	999,	999,	1,	0.38,	3,	2.10,	2,	2.00,	1,	2     };
            double  Q4_WASTAGE_113 [] = { 113,	678,	4.52,	999,	999,	1,	0.32,	6,	4.20,	999,	999,	1,	2     };
            double  Q4_WASTAGE_114 [] = { 114,	684,	4.56,	999,	999,	1,	0.36,	6,	4.20,	999,	999,	1,	2     };
            double  Q4_WASTAGE_115 [] = { 115,	690,	4.60,	999,	999,	1,	0.40,	6,	4.20,	999,	999,	1,	2     };
            double  Q4_WASTAGE_116 [] = { 116,	696,	4.64,	999,	999,	999,	999,	1,	0.64,	4,	4.00,	1,	2     };
            double  Q4_WASTAGE_117 [] = { 117,	702,	4.68,	999,	999,	999,	999,	1,	0.68,	4,	4.00,	1,	2     };
            double  Q4_WASTAGE_118 [] = { 118,	708,	4.72,	999,	999,	2,	0.72,	999,	999,	4,	4.00,	1,	2     };
            double  Q4_WASTAGE_119 [] = { 119,	714,	4.76,	999,	999,	2,	0.76,	999,	999,	4,	4.00,	1,	2     };
            double  Q4_WASTAGE_120 [] = { 120,	720,	4.80,	999,	999,	2,	0.80,	999,	999,	4,	4.00,	1,	2     };
            double  Q4_WASTAGE_121 [] = { 121,	726,	4.84,	999,	999,	999,	999,	7,	4.84,	999,	999,	1,	2     };
            double  Q4_WASTAGE_122 [] = { 122,	732,	4.88,	999,	999,	999,	999,	7,	4.88,	999,	999,	1,	2     };
            double  Q4_WASTAGE_123 [] = { 123,	738,	4.92,	999,	999,	999,	999,	999,	999,	5,	4.92,	1,	2     };
            double  Q4_WASTAGE_124 [] = { 124,	744,	4.96,	999,	999,	999,	999,	999,	999,	5,	4.96,	1,	2     };
            double  Q4_WASTAGE_125 [] = { 125,	750,	5.00,	999,	999,	999,	999,	999,	999,	5,	5.00,	1,	2     };
            double  Q4_WASTAGE_126 [] = { 126,	756,	5.04,	999,	999,	999,	999,	3,	2.04,	3,	3.00,	999,	3     };
            double  Q4_WASTAGE_127 [] = { 127,	762,	5.08,	999,	999,	999,	999,	3,	2.08,	3,	3.00,	999,	3     };
            double  Q4_WASTAGE_128 [] = { 128,	768,	5.12,	999,	999,	3,	1.12,	999,	999,	4,	4.00,	999,	3     };
            double  Q4_WASTAGE_129 [] = { 129,	774,	5.16,	999,	999,	3,	1.16,	999,	999,	4,	4.00,	999,	3     };
            double  Q4_WASTAGE_130 [] = { 130,	780,	5.20,	999,	999,	3,	1.20,	999,	999,	4,	4.00,	999,	3     };
            double  Q4_WASTAGE_131 [] = { 131,	786,	5.24,	999,	999,	1,	0.34,	7,	4.90,	999,	999,	999,	3     };
            double  Q4_WASTAGE_132 [] = { 132,	792,	5.28,	999,	999,	1,	0.38,	7,	4.90,	999,	999,	999,	3     };
            double  Q4_WASTAGE_133 [] = { 133,	798,	5.32,	999,	999,	1,	0.32,	999,	999,	5,	5.00,	999,	3     };
            double  Q4_WASTAGE_134 [] = { 134,	804,	5.36,	999,	999,	1,	0.36,	999,	999,	5,	5.00,	999,	3     };
            double  Q4_WASTAGE_135 [] = { 135,	810,	5.40,	999,	999,	1,	0.40,	999,	999,	5,	5.00,	999,	3     };
            double  Q4_WASTAGE_136 [] = { 136,	816,	5.44,	999,	999,	999,	999,	5,	3.44,	2,	2.00,	999,	3     };
            double  Q4_WASTAGE_137 [] = { 137,	822,	5.48,	999,	999,	999,	999,	5,	3.48,	2,	2.00,	999,	3     };
            double  Q4_WASTAGE_138 [] = { 138,	828,	5.52,	999,	999,	999,	999,	8,	5.52,	999,	999,	999,	3     };
            double  Q4_WASTAGE_139 [] = { 139,	834,	5.56,	999,	999,	999,	999,	8,	5.56,	999,	999,	999,	3     };
            double  Q4_WASTAGE_140 [] = { 140,	840,	5.60,	999,	999,	999,	999,	8,	5.60,	999,	999,	999,	3     };
            double  Q4_WASTAGE_141 [] = { 141,	846,	5.64,	999,	999,	999,	999,	1,	0.64,	5,	5.00,	999,	3     };
            double  Q4_WASTAGE_142 [] = { 142,	852,	5.68,	999,	999,	999,	999,	1,	0.68,	5,	5.00,	999,	3     };
            double  Q4_WASTAGE_143 [] = { 143,	858,	5.72,	999,	999,	2,	0.72,	999,	999,	5,	5.00,	999,	3     };
            double  Q4_WASTAGE_144 [] = { 144,	864,	5.76,	999,	999,	2,	0.76,	999,	999,	5,	5.00,	999,	3     };
            double  Q4_WASTAGE_145 [] = { 145,	870,	5.80,	999,	999,	2,	0.80,	999,	999,	5,	5.00,	999,	3     };
            double  Q4_WASTAGE_146 [] = { 146,	876,	5.84,	999,	999,	999,	999,	7,	4.84,	1,	1.00,	999,	3     };
            double  Q4_WASTAGE_147 [] = { 147,	882,	5.88,	999,	999,	999,	999,	7,	4.88,	1,	1.00,	999,	3     };
            double  Q4_WASTAGE_148 [] = { 148,	888,	5.92,	999,	999,	999,	999,	999,	999,	6,	5.92,	999,	3     };
            double  Q4_WASTAGE_149 [] = { 149,	894,	5.96,	999,	999,	999,	999,	999,	999,	6,	5.96,	999,	3     };
            double  Q4_WASTAGE_150 [] = { 150,	900,	6.00,	999,	999,	999,	999,	999,	999,	6,	6.00,	999,	3     };


          */


















        if (kilo==3 && kriter == 1 ){

             aranacak_dizi = loading_wastage_3;


        }
        else  if (kilo == 4 ){

            aranacak_dizi = loading_wastage_4;

        }
        else  if (kilo == 5 ){

            aranacak_dizi = loading_wastage_5;

        }
        else  if (kilo == 6 ){

             aranacak_dizi = loading_wastage_6;

        }
        else  if (kilo == 7 ){

            aranacak_dizi = loading_wastage_7;

        }
        else  if (kilo == 8 ){

             aranacak_dizi = loading_wastage_8;

        }
        else  if (kilo == 9 ){

             aranacak_dizi = loading_wastage_9;

        }
        else  if (kilo == 10 ){

            aranacak_dizi = loading_wastage_10;

        }
        else  if (kilo == 11 ){

             aranacak_dizi = loading_wastage_11;

        }
        else  if (kilo == 12 ){

             aranacak_dizi = loading_wastage_12;

        }
        else  if (kilo == 13 ){

             aranacak_dizi = loading_wastage_13;

        }
        else  if (kilo == 14 ){

             aranacak_dizi = loading_wastage_14;

        }
        else  if (kilo == 15 ){

             aranacak_dizi = loading_wastage_15;



        }
        else  if (kilo == 16 ){

            aranacak_dizi = loading_wastage_16;



        } else  if (kilo == 17 ){

            aranacak_dizi = loading_wastage_17;



        } else  if (kilo == 18 ){

            aranacak_dizi = loading_wastage_18;



        } else  if (kilo == 19 ){

            aranacak_dizi = loading_wastage_19;



        } else  if (kilo == 20 ){

            aranacak_dizi = loading_wastage_20;



        } else  if (kilo == 21 ){

            aranacak_dizi = loading_wastage_21;



        } else  if (kilo == 22 ){

            aranacak_dizi = loading_wastage_22;



        } else  if (kilo == 23 ){

            aranacak_dizi = loading_wastage_23;



        } else  if (kilo == 24 ){

            aranacak_dizi = loading_wastage_24;



        } else  if (kilo == 25 ){

            aranacak_dizi = loading_wastage_25;



        } else  if (kilo == 26 ){

            aranacak_dizi = loading_wastage_26;



        } else  if (kilo == 27 ){

            aranacak_dizi = loading_wastage_27;



        } else  if (kilo == 28 ){

            aranacak_dizi = loading_wastage_28;



        } else  if (kilo == 29 ){

            aranacak_dizi = loading_wastage_29;



        } else  if (kilo == 30 ){

            aranacak_dizi = loading_wastage_30;



        } else  if (kilo == 31 ){

            aranacak_dizi = loading_wastage_31;



        } else  if (kilo == 32 ){

            aranacak_dizi = loading_wastage_32;



        } else  if (kilo == 33 ){

            aranacak_dizi = loading_wastage_33;



        } else  if (kilo == 34 ){

            aranacak_dizi = loading_wastage_34;



        } else  if (kilo == 35 ){

            aranacak_dizi = loading_wastage_35;



        } else  if (kilo == 36 ){

            aranacak_dizi = loading_wastage_36;



        } else  if (kilo == 37 ){

            aranacak_dizi = loading_wastage_37;



        } else  if (kilo == 38 ){

            aranacak_dizi = loading_wastage_38;



        } else  if (kilo == 39 ){

            aranacak_dizi = loading_wastage_39;



        } else  if (kilo == 40 ){

            aranacak_dizi = loading_wastage_40;



        } else  if (kilo == 41 ){

            aranacak_dizi = loading_wastage_41;



        } else  if (kilo == 42 ){

            aranacak_dizi = loading_wastage_42;



        } else  if (kilo == 43 ){

            aranacak_dizi = loading_wastage_43;



        } else  if (kilo == 44 ){

            aranacak_dizi = loading_wastage_44;



        } else  if (kilo == 45 ){

            aranacak_dizi = loading_wastage_45;



        } else  if (kilo == 46 ){

            aranacak_dizi = loading_wastage_46;



        } else  if (kilo == 47 ){

            aranacak_dizi = loading_wastage_47;



        } else  if (kilo == 48 ){

            aranacak_dizi = loading_wastage_48;



        } else  if (kilo == 49 ){

            aranacak_dizi = loading_wastage_49;



        } else  if (kilo == 50 ){

            aranacak_dizi = loading_wastage_50;



        } else  if (kilo == 51 ){

            aranacak_dizi = loading_wastage_51;



        } else  if (kilo == 52 ){

            aranacak_dizi = loading_wastage_52;



        } else  if (kilo == 53 ){

            aranacak_dizi = loading_wastage_53;



        } else  if (kilo == 54 ){

            aranacak_dizi = loading_wastage_54;



        } else  if (kilo == 55 ){

            aranacak_dizi = loading_wastage_55;



        } else  if (kilo == 56 ){

            aranacak_dizi = loading_wastage_56;



        } else  if (kilo == 57 ){

            aranacak_dizi = loading_wastage_57;



        } else  if (kilo == 58 ){

            aranacak_dizi = loading_wastage_58;



        } else  if (kilo == 59 ){

            aranacak_dizi = loading_wastage_59;



        } else  if (kilo == 60 ){

            aranacak_dizi = loading_wastage_60;



        } else  if (kilo == 61 ){

            aranacak_dizi = loading_wastage_61;



        } else  if (kilo == 62 ){

            aranacak_dizi = loading_wastage_62;



        } else  if (kilo == 63 ){

            aranacak_dizi = loading_wastage_63;



        } else  if (kilo == 64 ){

            aranacak_dizi = loading_wastage_64;



        } else  if (kilo == 65 ){

            aranacak_dizi = loading_wastage_65;



        } else  if (kilo == 66 ){

            aranacak_dizi = loading_wastage_66;



        } else  if (kilo == 67 ){

            aranacak_dizi = loading_wastage_67;



        } else  if (kilo == 68 ){

            aranacak_dizi = loading_wastage_68;



        } else  if (kilo == 69 ){

            aranacak_dizi = loading_wastage_69;



        } else  if (kilo == 70 ){

            aranacak_dizi = loading_wastage_70;



        } else  if (kilo == 71 ){

            aranacak_dizi = loading_wastage_71;



        } else  if (kilo == 72 ){

            aranacak_dizi = loading_wastage_72;



        } else  if (kilo == 73 ){

            aranacak_dizi = loading_wastage_73;



        } else  if (kilo == 74 ){

            aranacak_dizi = loading_wastage_74;



        } else  if (kilo == 75 ){

            aranacak_dizi = loading_wastage_75;



        } else  if (kilo == 76 ){

            aranacak_dizi = loading_wastage_76;



        } else  if (kilo == 77 ){

            aranacak_dizi = loading_wastage_77;



        } else  if (kilo == 78 ){

            aranacak_dizi = loading_wastage_78;



        } else  if (kilo == 79 ){

            aranacak_dizi = loading_wastage_79;



        } else  if (kilo == 80 ){

            aranacak_dizi = loading_wastage_80;



        } else  if (kilo == 81 ){

            aranacak_dizi = loading_wastage_81;



        } else  if (kilo == 82 ){

            aranacak_dizi = loading_wastage_82;



        } else  if (kilo == 83 ){

            aranacak_dizi = loading_wastage_83;



        } else  if (kilo == 84 ){

            aranacak_dizi = loading_wastage_84;



        } else  if (kilo == 85 ){

            aranacak_dizi = loading_wastage_85;



        } else  if (kilo == 86 ){

            aranacak_dizi = loading_wastage_86;



        } else  if (kilo == 87 ){

            aranacak_dizi = loading_wastage_87;



        } else  if (kilo == 88 ){

            aranacak_dizi = loading_wastage_88;



        }

        else  if (kilo == 89 ){

            aranacak_dizi = loading_wastage_89;



        }
        else  if (kilo == 90 ){

            aranacak_dizi = loading_wastage_90;



        }else  if (kilo == 91 ){

            aranacak_dizi = loading_wastage_91;



        }else  if (kilo == 92 ){

            aranacak_dizi = loading_wastage_92;



        }else  if (kilo == 93 ){

            aranacak_dizi = loading_wastage_93;



        }else  if (kilo == 94 ){

            aranacak_dizi = loading_wastage_94;



        }else  if (kilo == 95 ){

            aranacak_dizi = loading_wastage_95;



        }else  if (kilo == 96 ){

            aranacak_dizi = loading_wastage_96;



        }else  if (kilo == 97 ){

            aranacak_dizi = loading_wastage_97;



        }else  if (kilo == 98 ){

            aranacak_dizi = loading_wastage_98;



        }else  if (kilo == 99 ){

            aranacak_dizi = loading_wastage_99;



        }else  if (kilo == 100 ){

            aranacak_dizi = loading_wastage_100;



        }else  if (kilo == 101 ){

            aranacak_dizi = loading_wastage_101;



        }else  if (kilo == 102 ){

            aranacak_dizi = loading_wastage_102;



        }else  if (kilo == 103 ){

            aranacak_dizi = loading_wastage_103;



        }else  if (kilo == 104 ){

            aranacak_dizi = loading_wastage_104;



        }else  if (kilo == 105 ){

            aranacak_dizi = loading_wastage_105;



        }else  if (kilo == 106 ){

            aranacak_dizi = loading_wastage_106;



        }else  if (kilo == 107 ){

            aranacak_dizi = loading_wastage_107;



        }else  if (kilo == 108 ){

            aranacak_dizi = loading_wastage_108;



        }else  if (kilo == 109 ){

            aranacak_dizi = loading_wastage_109;



        }else  if (kilo == 110 ){

            aranacak_dizi = loading_wastage_110;



        }else  if (kilo == 111 ){

            aranacak_dizi = loading_wastage_111;



        }else  if (kilo == 112 ){

            aranacak_dizi = loading_wastage_112;



        }else  if (kilo == 113 ){

            aranacak_dizi = loading_wastage_113;



        }else  if (kilo == 114 ){

            aranacak_dizi = loading_wastage_114;



        }else  if (kilo == 115 ){

            aranacak_dizi = loading_wastage_115;



        }else  if (kilo == 116 ){

            aranacak_dizi = loading_wastage_116;



        }else  if (kilo == 117 ){

            aranacak_dizi = loading_wastage_117;



        }else  if (kilo == 118 ){

            aranacak_dizi = loading_wastage_118;



        }else  if (kilo == 119 ){

            aranacak_dizi = loading_wastage_119;



        }else  if (kilo == 120 ){

            aranacak_dizi = loading_wastage_120;



        }else  if (kilo == 121 ){

            aranacak_dizi = loading_wastage_121;



        }else  if (kilo == 122 ){

            aranacak_dizi = loading_wastage_122;



        }else  if (kilo == 123 ){

            aranacak_dizi = loading_wastage_123;



        }else  if (kilo == 124 ){

            aranacak_dizi = loading_wastage_124;



        }else  if (kilo == 125 ){

            aranacak_dizi = loading_wastage_125;



        }else  if (kilo == 126 ){

            aranacak_dizi = loading_wastage_126;



        }else  if (kilo == 127 ){

            aranacak_dizi = loading_wastage_127;



        }else  if (kilo == 128 ){

            aranacak_dizi = loading_wastage_128;



        }else  if (kilo == 129 ){

            aranacak_dizi = loading_wastage_129;



        }else  if (kilo == 130 ){

            aranacak_dizi = loading_wastage_130;



        }else  if (kilo == 131 ){

            aranacak_dizi = loading_wastage_131;



        }else  if (kilo == 132 ){

            aranacak_dizi = loading_wastage_132;



        }else  if (kilo == 133 ){

            aranacak_dizi = loading_wastage_133;



        }else  if (kilo == 134 ){

            aranacak_dizi = loading_wastage_134;



        }else  if (kilo == 135 ){

            aranacak_dizi = loading_wastage_135;



        }else  if (kilo == 136 ){

            aranacak_dizi = loading_wastage_136;



        }else  if (kilo == 137 ){

            aranacak_dizi = loading_wastage_137;



        }else  if (kilo == 138 ){

            aranacak_dizi = loading_wastage_138;



        }else  if (kilo == 139 ){

            aranacak_dizi = loading_wastage_139;



        }else  if (kilo == 140 ){

            aranacak_dizi = loading_wastage_140;



        }else  if (kilo == 141 ){

            aranacak_dizi = loading_wastage_141;



        }else  if (kilo == 142 ){

            aranacak_dizi = loading_wastage_142;



        }else  if (kilo == 143 ){

            aranacak_dizi = loading_wastage_143;



        }else  if (kilo == 144 ){

            aranacak_dizi = loading_wastage_144;



        }else  if (kilo == 145 ){

            aranacak_dizi = loading_wastage_145;



        }else  if (kilo == 146 ){

            aranacak_dizi = loading_wastage_146;



        }else  if (kilo == 147 ){

            aranacak_dizi = loading_wastage_147;



        }else  if (kilo == 148 ){

            aranacak_dizi = loading_wastage_148;



        }else  if (kilo == 149 ){

            aranacak_dizi = loading_wastage_149;



        }else  if (kilo == 150 ){

            aranacak_dizi = loading_wastage_150;



        }










            //LOADNG WASTAGE------------------------------------------------------------------------------



            //LOADNG INJECTIONS------------------------------------------------------------------------------







            if (kilo==3 && kriter == 2 ){

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










               /* if( ( kilo>=21 && kilo<=30)||( kilo>=41 && kilo<=45)||( kilo>=51 && kilo<=55) ||( kilo>=56 && kilo<=60)||( kilo>=71 && kilo<=75)||( kilo>=81 && kilo<=85)){



                    //ikili
                    params.setMargins(0, -( üçüncü_ilaç_layout_height + 60), 0, 0);
                    text_layout.setLayoutParams(params);




                }

                else {


                    //tekli

                    params.setMargins(0, -( ikinci_ilaç_layout_height+üçüncü_ilaç_layout_height + 60), 0, 0);
                    text_layout.setLayoutParams(params);




                }



                if ( kilo>=61 && kilo<=65){
                    //üçlü

                    params.setMargins(0, 0, 0, 0);
                    text_layout.setLayoutParams(params);


                }



                */




                }
            });




































        }















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
