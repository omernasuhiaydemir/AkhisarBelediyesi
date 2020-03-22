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


public class Injections_Q1_Result extends AppCompatActivity {

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


            total_dose_değeri = String.valueOf(kilo*1.5);



            double  Q1_WASTAGE_3 [] = {             };
            double  Q1_WASTAGE_4 [] = {             };
            double  Q1_WASTAGE_5 [] = {             };
            double  Q1_WASTAGE_6 [] = {             };
            double  Q1_WASTAGE_7 [] = {             };
            double  Q1_WASTAGE_8 [] = {              };
            double  Q1_WASTAGE_9 [] = {              };
            double  Q1_WASTAGE_10 [] = {             };
            double  Q1_WASTAGE_11 [] = {             };
            double  Q1_WASTAGE_12 [] = {             };
            double  Q1_WASTAGE_13 [] = {             };
            double  Q1_WASTAGE_14 [] = {             };
            double  Q1_WASTAGE_15 [] = {             };
            double  Q1_WASTAGE_16 [] = {            };
            double  Q1_WASTAGE_17 [] = {            };
            double  Q1_WASTAGE_18 [] = {            };
            double  Q1_WASTAGE_19 [] = {            };
            double  Q1_WASTAGE_20 [] = {            };
            double  Q1_WASTAGE_21 [] = {        };
            double  Q1_WASTAGE_22 [] = {        };
            double  Q1_WASTAGE_23 [] = {        };
            double  Q1_WASTAGE_24 [] = {        };
            double  Q1_WASTAGE_25 [] = {        };
            double  Q1_WASTAGE_26 [] = {        };
            double  Q1_WASTAGE_27 [] = {        };
            double  Q1_WASTAGE_28 [] = {         };
            double  Q1_WASTAGE_29 [] = {        };
            double  Q1_WASTAGE_30 [] = {        };
            double  Q1_WASTAGE_31 [] = {            };
            double  Q1_WASTAGE_32 [] = {        };
            double  Q1_WASTAGE_33 [] = {        };
            double  Q1_WASTAGE_34 [] = {        };
            double  Q1_WASTAGE_35 [] = {        };
            double  Q1_WASTAGE_36 [] = {         };
            double  Q1_WASTAGE_37 [] = {         };
            double  Q1_WASTAGE_38 [] = {        };
            double  Q1_WASTAGE_39 [] = {        };
            double  Q1_WASTAGE_40 [] = {        };
            double  Q1_WASTAGE_41 [] = {        };
            double  Q1_WASTAGE_42 [] = {        };
            double  Q1_WASTAGE_43 [] = {            };
            double  Q1_WASTAGE_44 [] = {         };
            double  Q1_WASTAGE_45 [] = {         };
            double  Q1_WASTAGE_46 [] = {         };
            double  Q1_WASTAGE_47 [] = {        };
            double  Q1_WASTAGE_48 [] = {        };
            double  Q1_WASTAGE_49 [] = {        };
            double  Q1_WASTAGE_50 [] = {        };
            double  Q1_WASTAGE_51 [] = {        };
            double  Q1_WASTAGE_52 [] = {         };
            double  Q1_WASTAGE_53 [] = {         };
            double  Q1_WASTAGE_54 [] = {         };
            double  Q1_WASTAGE_55 [] = {         };
            double  Q1_WASTAGE_56 [] = {         };
            double  Q1_WASTAGE_57 [] = {         };
            double  Q1_WASTAGE_58 [] = {         };
            double  Q1_WASTAGE_59 [] = {         };
            double  Q1_WASTAGE_60 [] = {        };
            double  Q1_WASTAGE_61 [] = {        };
            double  Q1_WASTAGE_62 [] = {        };
            double  Q1_WASTAGE_63 [] = {        };
            double  Q1_WASTAGE_64 [] = {        };
            double  Q1_WASTAGE_65 [] = {        };
            double  Q1_WASTAGE_66 [] = {         };
            double  Q1_WASTAGE_67 [] = {         };
            double  Q1_WASTAGE_68 [] = {         };
            double  Q1_WASTAGE_69 [] = {         };
            double  Q1_WASTAGE_70 [] = {         };
            double  Q1_WASTAGE_71 [] = {         };
            double  Q1_WASTAGE_72 [] = {         };
            double  Q1_WASTAGE_73 [] = {         };
            double  Q1_WASTAGE_74 [] = {         };
            double  Q1_WASTAGE_75 [] = {         };
            double  Q1_WASTAGE_76 [] = {         };
            double  Q1_WASTAGE_77 [] = {         };
            double  Q1_WASTAGE_78 [] = {         };
            double  Q1_WASTAGE_79 [] = {         };
            double  Q1_WASTAGE_80 [] = {          };
            double  Q1_WASTAGE_81 [] = {          };
            double  Q1_WASTAGE_82 [] = {         };
            double  Q1_WASTAGE_83 [] = {          };
            double  Q1_WASTAGE_84 [] = {         };
            double  Q1_WASTAGE_85 [] = {         };
            double  Q1_WASTAGE_86 [] = {         };
            double  Q1_WASTAGE_87 [] = {         };
            double  Q1_WASTAGE_88 [] = {         };
            double  Q1_WASTAGE_89 [] = {         };
            double  Q1_WASTAGE_90 [] = {         };
            double  Q1_WASTAGE_91 [] = {         };
            double  Q1_WASTAGE_92 [] = {         };
            double  Q1_WASTAGE_93 [] = {         };
            double  Q1_WASTAGE_94 [] = {         };
            double  Q1_WASTAGE_95 [] = {         };
            double  Q1_WASTAGE_96 [] = {         };
            double  Q1_WASTAGE_97 [] = {         };
            double  Q1_WASTAGE_98 [] = {         };
            double  Q1_WASTAGE_99 [] = {         };
            double  Q1_WASTAGE_100 [] = {        };
            double  Q1_WASTAGE_101 [] = {        };
            double  Q1_WASTAGE_102 [] = {        };
            double  Q1_WASTAGE_103 [] = {        };
            double  Q1_WASTAGE_104 [] = {        };
            double  Q1_WASTAGE_105 [] = {        };
            double  Q1_WASTAGE_106 [] = {        };
            double  Q1_WASTAGE_107 [] = {        };
            double  Q1_WASTAGE_108 [] = {        };
            double  Q1_WASTAGE_109 [] = {        };
            double  Q1_WASTAGE_110 [] = {        };
            double  Q1_WASTAGE_111 [] = {        };
            double  Q1_WASTAGE_112 [] = {        };
            double  Q1_WASTAGE_113 [] = {        };
            double  Q1_WASTAGE_114 [] = {        };
            double  Q1_WASTAGE_115 [] = {        };
            double  Q1_WASTAGE_116 [] = {        };
            double  Q1_WASTAGE_117 [] = {        };
            double  Q1_WASTAGE_118 [] = {        };
            double  Q1_WASTAGE_119 [] = {        };
            double  Q1_WASTAGE_120 [] = {        };
            double  Q1_WASTAGE_121 [] = {        };
            double  Q1_WASTAGE_122 [] = {        };
            double  Q1_WASTAGE_123 [] = {        };
            double  Q1_WASTAGE_124 [] = {        };
            double  Q1_WASTAGE_125 [] = {        };
            double  Q1_WASTAGE_126 [] = {        };
            double  Q1_WASTAGE_127 [] = {        };
            double  Q1_WASTAGE_128 [] = {        };
            double  Q1_WASTAGE_129 [] = {        };
            double  Q1_WASTAGE_130 [] = {        };
            double  Q1_WASTAGE_131 [] = {        };
            double  Q1_WASTAGE_132 [] = {        };
            double  Q1_WASTAGE_133 [] = {        };
            double  Q1_WASTAGE_134 [] = {        };
            double  Q1_WASTAGE_135 [] = {        };
            double  Q1_WASTAGE_136 [] = {        };
            double  Q1_WASTAGE_137 [] = {        };
            double  Q1_WASTAGE_138 [] = {        };
            double  Q1_WASTAGE_139 [] = {        };
            double  Q1_WASTAGE_140 [] = {        };
            double  Q1_WASTAGE_141 [] = {        };
            double  Q1_WASTAGE_142 [] = {        };
            double  Q1_WASTAGE_143 [] = {        };
            double  Q1_WASTAGE_144 [] = {        };
            double  Q1_WASTAGE_145 [] = {        };
            double  Q1_WASTAGE_146 [] = {        };
            double  Q1_WASTAGE_147 [] = {        };
            double  Q1_WASTAGE_148 [] = {        };
            double  Q1_WASTAGE_149 [] = {        };
            double  Q1_WASTAGE_150 [] = {        };









            if (kilo==3  ){

                aranacak_dizi = Q1_WASTAGE_3;


            }
            else  if (kilo == 4 ){

                aranacak_dizi =   Q1_WASTAGE_4;

            }
            else  if (kilo == 5 ){

                aranacak_dizi =  Q1_WASTAGE_5;

            }
            else  if (kilo == 6 ){

                aranacak_dizi =  Q1_WASTAGE_6;

            }
            else  if (kilo == 7 ){

                aranacak_dizi =  Q1_WASTAGE_7;

            }
            else  if (kilo == 8 ){

                aranacak_dizi =  Q1_WASTAGE_8;

            }
            else  if (kilo == 9 ){

                aranacak_dizi =  Q1_WASTAGE_9;

            }
            else  if (kilo == 10 ){

                aranacak_dizi =  Q1_WASTAGE_10;

            }
            else  if (kilo == 11 ){

                aranacak_dizi =  Q1_WASTAGE_11;

            }
            else  if (kilo == 12 ){

                aranacak_dizi =  Q1_WASTAGE_12;

            }
            else  if (kilo == 13 ){

                aranacak_dizi =  Q1_WASTAGE_13;

            }
            else  if (kilo == 14 ){

                aranacak_dizi =  Q1_WASTAGE_14;

            }
            else  if (kilo == 15 ){

                aranacak_dizi =  Q1_WASTAGE_15;



            }
            else  if (kilo == 16 ){

                aranacak_dizi =  Q1_WASTAGE_16;



            } else  if (kilo == 17 ){

                aranacak_dizi =  Q1_WASTAGE_17;



            } else  if (kilo == 18 ){

                aranacak_dizi =  Q1_WASTAGE_8;



            } else  if (kilo == 19 ){

                aranacak_dizi =  Q1_WASTAGE_19;



            } else  if (kilo == 20 ){

                aranacak_dizi =  Q1_WASTAGE_20;



            } else  if (kilo == 21 ){

                aranacak_dizi =  Q1_WASTAGE_21;



            } else  if (kilo == 22 ){

                aranacak_dizi =  Q1_WASTAGE_22;



            } else  if (kilo == 23 ){

                aranacak_dizi =  Q1_WASTAGE_23;



            } else  if (kilo == 24 ){

                aranacak_dizi =  Q1_WASTAGE_24;



            } else  if (kilo == 25 ){

                aranacak_dizi =  Q1_WASTAGE_25;



            } else  if (kilo == 26 ){

                aranacak_dizi =  Q1_WASTAGE_26;



            } else  if (kilo == 27 ){

                aranacak_dizi =  Q1_WASTAGE_27;



            } else  if (kilo == 28 ){

                aranacak_dizi =  Q1_WASTAGE_28;



            } else  if (kilo == 29 ){

                aranacak_dizi =  Q1_WASTAGE_29;



            } else  if (kilo == 30 ){

                aranacak_dizi =  Q1_WASTAGE_30;



            } else  if (kilo == 31 ){

                aranacak_dizi =  Q1_WASTAGE_31;



            } else  if (kilo == 32 ){

                aranacak_dizi =  Q1_WASTAGE_32;



            } else  if (kilo == 33 ){

                aranacak_dizi =  Q1_WASTAGE_33;



            } else  if (kilo == 34 ){

                aranacak_dizi =  Q1_WASTAGE_34;



            } else  if (kilo == 35 ){

                aranacak_dizi =  Q1_WASTAGE_35;



            } else  if (kilo == 36 ){

                aranacak_dizi =  Q1_WASTAGE_36;



            } else  if (kilo == 37 ){

                aranacak_dizi =  Q1_WASTAGE_37;



            } else  if (kilo == 38 ){

                aranacak_dizi =  Q1_WASTAGE_38;



            } else  if (kilo == 39 ){

                aranacak_dizi =  Q1_WASTAGE_39;



            } else  if (kilo == 40 ){

                aranacak_dizi =  Q1_WASTAGE_40;



            } else  if (kilo == 41 ){

                aranacak_dizi =  Q1_WASTAGE_41;



            } else  if (kilo == 42 ){

                aranacak_dizi =  Q1_WASTAGE_42;



            } else  if (kilo == 43 ){

                aranacak_dizi =  Q1_WASTAGE_43;



            } else  if (kilo == 44 ){

                aranacak_dizi =  Q1_WASTAGE_44;



            } else  if (kilo == 45 ){

                aranacak_dizi =  Q1_WASTAGE_45;



            } else  if (kilo == 46 ){

                aranacak_dizi =  Q1_WASTAGE_46;



            } else  if (kilo == 47 ){

                aranacak_dizi =  Q1_WASTAGE_47;



            } else  if (kilo == 48 ){

                aranacak_dizi =  Q1_WASTAGE_48;



            } else  if (kilo == 49 ){

                aranacak_dizi =  Q1_WASTAGE_49;



            } else  if (kilo == 50 ){

                aranacak_dizi =  Q1_WASTAGE_50;



            } else  if (kilo == 51 ){

                aranacak_dizi =  Q1_WASTAGE_51;



            } else  if (kilo == 52 ){

                aranacak_dizi =  Q1_WASTAGE_52;



            } else  if (kilo == 53 ){

                aranacak_dizi =  Q1_WASTAGE_53;



            } else  if (kilo == 54 ){

                aranacak_dizi = Q1_WASTAGE_54;



            } else  if (kilo == 55 ){

                aranacak_dizi = Q1_WASTAGE_55;



            } else  if (kilo == 56 ){

                aranacak_dizi = Q1_WASTAGE_56;



            } else  if (kilo == 57 ){

                aranacak_dizi = Q1_WASTAGE_57;



            } else  if (kilo == 58 ){

                aranacak_dizi = Q1_WASTAGE_58;



            } else  if (kilo == 59 ){

                aranacak_dizi = Q1_WASTAGE_59;



            } else  if (kilo == 60 ){

                aranacak_dizi = Q1_WASTAGE_60;



            } else  if (kilo == 61 ){

                aranacak_dizi = Q1_WASTAGE_61;



            } else  if (kilo == 62 ){

                aranacak_dizi = Q1_WASTAGE_62;



            } else  if (kilo == 63 ){

                aranacak_dizi = Q1_WASTAGE_63;



            } else  if (kilo == 64 ){

                aranacak_dizi = Q1_WASTAGE_64;



            } else  if (kilo == 65 ){

                aranacak_dizi = Q1_WASTAGE_65;



            } else  if (kilo == 66 ){

                aranacak_dizi = Q1_WASTAGE_66;



            } else  if (kilo == 67 ){

                aranacak_dizi = Q1_WASTAGE_67;



            } else  if (kilo == 68 ){

                aranacak_dizi = Q1_WASTAGE_68;



            } else  if (kilo == 69 ){

                aranacak_dizi = Q1_WASTAGE_69;



            } else  if (kilo == 70 ){

                aranacak_dizi = Q1_WASTAGE_70;



            } else  if (kilo == 71 ){

                aranacak_dizi = Q1_WASTAGE_71;



            } else  if (kilo == 72 ){

                aranacak_dizi = Q1_WASTAGE_72;



            } else  if (kilo == 73 ){

                aranacak_dizi = Q1_WASTAGE_73;



            } else  if (kilo == 74 ){

                aranacak_dizi = Q1_WASTAGE_74;



            } else  if (kilo == 75 ){

                aranacak_dizi = Q1_WASTAGE_75;



            } else  if (kilo == 76 ){

                aranacak_dizi = Q1_WASTAGE_76;



            } else  if (kilo == 77 ){

                aranacak_dizi = Q1_WASTAGE_77;



            } else  if (kilo == 78 ){

                aranacak_dizi = Q1_WASTAGE_78;



            } else  if (kilo == 79 ){

                aranacak_dizi = Q1_WASTAGE_79;



            } else  if (kilo == 80 ){

                aranacak_dizi = Q1_WASTAGE_80;



            } else  if (kilo == 81 ){

                aranacak_dizi = Q1_WASTAGE_81;



            } else  if (kilo == 82 ){

                aranacak_dizi = Q1_WASTAGE_82;



            } else  if (kilo == 83 ){

                aranacak_dizi = Q1_WASTAGE_83;



            } else  if (kilo == 84 ){

                aranacak_dizi = Q1_WASTAGE_84;



            } else  if (kilo == 85 ){

                aranacak_dizi = Q1_WASTAGE_85;



            } else  if (kilo == 86 ){

                aranacak_dizi = Q1_WASTAGE_86;



            } else  if (kilo == 87 ){

                aranacak_dizi = Q1_WASTAGE_87;



            } else  if (kilo == 88 ){

                aranacak_dizi = Q1_WASTAGE_88;



            }

            else  if (kilo == 89 ){

                aranacak_dizi = Q1_WASTAGE_89;



            }
            else  if (kilo == 90 ){

                aranacak_dizi = Q1_WASTAGE_90;



            }else  if (kilo == 91 ){

                aranacak_dizi = Q1_WASTAGE_91;



            }else  if (kilo == 92 ){

                aranacak_dizi = Q1_WASTAGE_92;



            }else  if (kilo == 93 ){

                aranacak_dizi = Q1_WASTAGE_93;



            }else  if (kilo == 94 ){

                aranacak_dizi = Q1_WASTAGE_94;



            }else  if (kilo == 95 ){

                aranacak_dizi = Q1_WASTAGE_95;



            }else  if (kilo == 96 ){

                aranacak_dizi = Q1_WASTAGE_96;



            }else  if (kilo == 97 ){

                aranacak_dizi = Q1_WASTAGE_97;



            }else  if (kilo == 98 ){

                aranacak_dizi = Q1_WASTAGE_98;



            }else  if (kilo == 99 ){

                aranacak_dizi = Q1_WASTAGE_99;



            }else  if (kilo == 100 ){

                aranacak_dizi = Q1_WASTAGE_100;



            }else  if (kilo == 101 ){

                aranacak_dizi = Q1_WASTAGE_101;



            }else  if (kilo == 102 ){

                aranacak_dizi = Q1_WASTAGE_102;



            }else  if (kilo == 103 ){

                aranacak_dizi = Q1_WASTAGE_103;



            }else  if (kilo == 104 ){

                aranacak_dizi = Q1_WASTAGE_104;



            }else  if (kilo == 105 ){

                aranacak_dizi = Q1_WASTAGE_105;



            }else  if (kilo == 106 ){

                aranacak_dizi = Q1_WASTAGE_106;



            }else  if (kilo == 107 ){

                aranacak_dizi = Q1_WASTAGE_107;



            }else  if (kilo == 108 ){

                aranacak_dizi = Q1_WASTAGE_108;



            }else  if (kilo == 109 ){

                aranacak_dizi = Q1_WASTAGE_109;



            }else  if (kilo == 110 ){

                aranacak_dizi = Q1_WASTAGE_110;



            }else  if (kilo == 111 ){

                aranacak_dizi = Q1_WASTAGE_111;



            }else  if (kilo == 112 ){

                aranacak_dizi = Q1_WASTAGE_112;



            }else  if (kilo == 113 ){

                aranacak_dizi = Q1_WASTAGE_113;



            }else  if (kilo == 114 ){

                aranacak_dizi = Q1_WASTAGE_114;



            }else  if (kilo == 115 ){

                aranacak_dizi = Q1_WASTAGE_115;



            }else  if (kilo == 116 ){

                aranacak_dizi = Q1_WASTAGE_116;



            }else  if (kilo == 117 ){

                aranacak_dizi = Q1_WASTAGE_117;



            }else  if (kilo == 118 ){

                aranacak_dizi = Q1_WASTAGE_118;



            }else  if (kilo == 119 ){

                aranacak_dizi = Q1_WASTAGE_119;



            }else  if (kilo == 120 ){

                aranacak_dizi = Q1_WASTAGE_120;



            }else  if (kilo == 121 ){

                aranacak_dizi = Q1_WASTAGE_121;



            }else  if (kilo == 122 ){

                aranacak_dizi = Q1_WASTAGE_122;



            }else  if (kilo == 123 ){

                aranacak_dizi = Q1_WASTAGE_123;



            }else  if (kilo == 124 ){

                aranacak_dizi = Q1_WASTAGE_124;



            }else  if (kilo == 125 ){

                aranacak_dizi = Q1_WASTAGE_125;



            }else  if (kilo == 126 ){

                aranacak_dizi = Q1_WASTAGE_126;



            }else  if (kilo == 127 ){

                aranacak_dizi = Q1_WASTAGE_127;



            }else  if (kilo == 128 ){

                aranacak_dizi = Q1_WASTAGE_128;



            }else  if (kilo == 129 ){

                aranacak_dizi = Q1_WASTAGE_129;



            }else  if (kilo == 130 ){

                aranacak_dizi = Q1_WASTAGE_130;



            }else  if (kilo == 131 ){

                aranacak_dizi = Q1_WASTAGE_131;



            }else  if (kilo == 132 ){

                aranacak_dizi = Q1_WASTAGE_132;



            }else  if (kilo == 133 ){

                aranacak_dizi = Q1_WASTAGE_133;



            }else  if (kilo == 134 ){

                aranacak_dizi = Q1_WASTAGE_134;



            }else  if (kilo == 135 ){

                aranacak_dizi = Q1_WASTAGE_135;



            }else  if (kilo == 136 ){

                aranacak_dizi = Q1_WASTAGE_136;



            }else  if (kilo == 137 ){

                aranacak_dizi = Q1_WASTAGE_137;



            }else  if (kilo == 138 ){

                aranacak_dizi = Q1_WASTAGE_138;



            }else  if (kilo == 139 ){

                aranacak_dizi = Q1_WASTAGE_139;



            }else  if (kilo == 140 ){

                aranacak_dizi = Q1_WASTAGE_140;



            }else  if (kilo == 141 ){

                aranacak_dizi = Q1_WASTAGE_141;



            }else  if (kilo == 142 ){

                aranacak_dizi = Q1_WASTAGE_142;



            }else  if (kilo == 143 ){

                aranacak_dizi = Q1_WASTAGE_143;



            }else  if (kilo == 144 ){

                aranacak_dizi = Q1_WASTAGE_144;



            }else  if (kilo == 145 ){

                aranacak_dizi = Q1_WASTAGE_145;



            }else  if (kilo == 146 ){

                aranacak_dizi = Q1_WASTAGE_146;



            }else  if (kilo == 147 ){

                aranacak_dizi = Q1_WASTAGE_147;



            }else  if (kilo == 148 ){

                aranacak_dizi = Q1_WASTAGE_148;



            }else  if (kilo == 149 ){

                aranacak_dizi = Q1_WASTAGE_149;



            }else  if (kilo == 150 ){

                aranacak_dizi = Q1_WASTAGE_150;



            }












            if (aranacak_dizi[3] != 999  ) {


                total_volume_değeri = String.valueOf(aranacak_dizi[2]);
                bir_mg_syringe_değeri = String.valueOf(aranacak_dizi[11]);
                iki_üç_syringe_değeri = String.valueOf(aranacak_dizi[12]);
                sky_blue_vial_değeri = String.valueOf(aranacak_dizi[3]);
                sky_blue_volume_değeri =  String.valueOf(aranacak_dizi[4]);

                if (String.valueOf(aranacak_dizi[11]).equals("999.0")){

                    bir_mg_syringe_değeri = "0";

                }
                if (String.valueOf(aranacak_dizi[12]).equals("999.0")){

                    iki_üç_syringe_değeri = "0";

                }



                ilaç_harf_1 = "S";




               // Log.e("lOOOOG", "İlaç adı: Sky Blue"+ " Dose: 30 mg "+  "Vial dğeri: "+sky_blue_vial_değeri+"Volume değeri: "+sky_blue_volume_değeri+" Total dose "+ String.valueOf(kilo*3)+" Total Volume: "+ String.valueOf(aranacak_dizi[17]) +" 1 mg Syringe: "+ String.valueOf(aranacak_dizi[18])+" 2 or 3 mg Syringe: "+String.valueOf(aranacak_dizi[19]));







            }
            else{


                Log.e("lOOOOG", "İlaç adı: Sky blue DEĞİİL");

            }







            if (aranacak_dizi[5] != 999  ) {


                total_volume_değeri = String.valueOf(aranacak_dizi[2]);
                bir_mg_syringe_değeri = String.valueOf(aranacak_dizi[11]);
                iki_üç_syringe_değeri = String.valueOf(aranacak_dizi[12]);
                purple_vial_değeri = String.valueOf(aranacak_dizi[5]);
                purple_volume_değeri =  String.valueOf(aranacak_dizi[6]);

                if (String.valueOf(aranacak_dizi[11]).equals("999.0")){

                    bir_mg_syringe_değeri = "0";

                }
                if (String.valueOf(aranacak_dizi[12]).equals("999.0")){

                    iki_üç_syringe_değeri = "0";

                }


                ilaç_harf_2 = "P";


            }
            else{


                Log.e("lOOOOG", "İlaç adı: Purple DEĞİİL");

            }










            if (aranacak_dizi[7] != 999   ) {



                total_volume_değeri = String.valueOf(aranacak_dizi[2]);
                bir_mg_syringe_değeri = String.valueOf(aranacak_dizi[11]);
                iki_üç_syringe_değeri = String.valueOf(aranacak_dizi[12]);
                turquoise_vial_değeri = String.valueOf(aranacak_dizi[7]);
                turquoise_volume_değeri =  String.valueOf(aranacak_dizi[8]);

                if (String.valueOf(aranacak_dizi[11]).equals("999.0")){

                    bir_mg_syringe_değeri = "0";

                }
                if (String.valueOf(aranacak_dizi[12]).equals("999.0")){

                    iki_üç_syringe_değeri = "0";

                }



                ilaç_harf_3 = "T";


            }
            else{


                Log.e("lOOOOG", "İlaç adı: Turquoise DEĞİİL");

            }




            if (aranacak_dizi[9] != 999  ) {


                total_volume_değeri = String.valueOf(aranacak_dizi[2]);
                bir_mg_syringe_değeri = String.valueOf(aranacak_dizi[11]);
                iki_üç_syringe_değeri = String.valueOf(aranacak_dizi[12]);
                orange_vial_değeri = String.valueOf(aranacak_dizi[7]);
                orange_volume_değeri =  String.valueOf(aranacak_dizi[8]);

                if (String.valueOf(aranacak_dizi[11]).equals("999.0")){

                    bir_mg_syringe_değeri = "0";

                }
                if (String.valueOf(aranacak_dizi[12]).equals("999.0")){

                    iki_üç_syringe_değeri = "0";

                }






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
