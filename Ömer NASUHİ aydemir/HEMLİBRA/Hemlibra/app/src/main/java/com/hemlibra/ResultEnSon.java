package com.hemlibra;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class ResultActivity extends AppCompatActivity {

    TextView text_result,text_dose,text_dose_mg,text_form,form_vial,text_amount,text_amount_ml,text_ilac_adi,text_example_vial;
    Button least_wastage_button,least_injection_button,loading_button,maintenance_button,calculate_again_button;

    private ImageView birinci_image,ikinci_image,ilac_arka_plan,navi_oval_1,navi_oval_2;
    private  LinearLayout ilaç_arka_plan,navi_oval_kirmizi,navi_oval_mavi;



    private static ViewPager mPager,mPager1;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<ImageModel> imageModelArrayList;
    private int i;
    private int image_int=0;

    private int[] myImageList = new int[]{R.drawable.pill_kirmizi, R.drawable.pill_mavi,
            R.drawable.pill_pembe,R.drawable.pill_yesll};

    private LinearLayout navi_layout_1,navi_layout_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        imageModelArrayList = new ArrayList<>();
       // imageModelArrayList = populateList();

       // init();




        text_result=(TextView)findViewById(R.id.text_result);
        text_dose=(TextView)findViewById(R.id.text_dose);
        text_dose_mg=(TextView)findViewById(R.id.text_dose_mg);
        text_form=(TextView)findViewById(R.id.text_form);
        form_vial=(TextView)findViewById(R.id.form_vial);
        text_amount=(TextView)findViewById(R.id.text_amount);
        text_amount_ml=(TextView)findViewById(R.id.text_amount_ml);
        text_ilac_adi=(TextView)findViewById(R.id.text_ilac_adi);
        text_example_vial=(TextView)findViewById(R.id.text_example_vial);

        ilaç_arka_plan=(LinearLayout)findViewById(R.id.ilac_arka_plan);
        navi_oval_mavi=(LinearLayout)findViewById(R.id.navi_oval_mavi);
        navi_oval_kirmizi=(LinearLayout)findViewById(R.id.navi_oval_kirmizi);



        least_wastage_button=(Button)findViewById(R.id.least_wastage_button);
        least_injection_button=(Button)findViewById(R.id.least_injection_button);
        loading_button=(Button)findViewById(R.id.loading_button);
        maintenance_button=(Button)findViewById(R.id.maintenance_button);

        calculate_again_button=(Button)findViewById(R.id.calculate_again_button);


        Typeface Trade_Gothic_Bold = Typeface.createFromAsset(getAssets(),  "font/trade_gothic_bold.ttf");

        text_result.setTypeface(Trade_Gothic_Bold);
        text_dose.setTypeface(Trade_Gothic_Bold);
        text_dose_mg.setTypeface(Trade_Gothic_Bold);

        text_form.setTypeface(Trade_Gothic_Bold);
        form_vial.setTypeface(Trade_Gothic_Bold);
        text_amount.setTypeface(Trade_Gothic_Bold);

        text_amount_ml.setTypeface(Trade_Gothic_Bold);
        text_ilac_adi.setTypeface(Trade_Gothic_Bold);
        text_example_vial.setTypeface(Trade_Gothic_Bold);


        final HorizontalScrollView scrollView=(HorizontalScrollView)findViewById(R.id.scrollView);
        scrollView.setHorizontalScrollBarEnabled(false);

        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int scrollX = scrollView.getScrollX();
               // Toast.makeText(getApplicationContext(), String.valueOf(scrollX), Toast.LENGTH_LONG).show();

                if (scrollX>200){


                    text_ilac_adi.setText("Blue");
                    text_dose_mg.setText("30 mg");
                    ilaç_arka_plan.setBackgroundResource(R.drawable.kose_gorsel_mavi);
                    text_dose_mg.setTextColor(getResources().getColor(R.color.mavi));
                    form_vial.setTextColor(getResources().getColor(R.color.mavi));
                    text_amount_ml.setTextColor(getResources().getColor(R.color.mavi));
                    text_example_vial.setTextColor(getResources().getColor(R.color.mavi));
                    navi_oval_kirmizi.setVisibility(View.INVISIBLE);
                    navi_oval_mavi.setVisibility(View.VISIBLE);

                }

                else{

                    text_ilac_adi.setText("Red");
                    text_dose_mg.setText("105 mg");


                    ilaç_arka_plan.setBackgroundResource(R.drawable.kose_gorsel_kirmizi);
                    text_dose_mg.setTextColor(getResources().getColor(R.color.kırmızı));
                    form_vial.setTextColor(getResources().getColor(R.color.kırmızı));
                    text_amount_ml.setTextColor(getResources().getColor(R.color.kırmızı));
                    text_example_vial.setTextColor(getResources().getColor(R.color.kırmızı));
                    navi_oval_kirmizi.setVisibility(View.VISIBLE);
                    navi_oval_mavi.setVisibility(View.INVISIBLE);


                }

            }
        });




        calculate_again_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);



            }
        });

      /*  ikinci_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                image_int++;
                if (image_int>4){
                    image_int=1;
                }



                switch (image_int) {




                    case 1:
                        birinci_image.setBackgroundResource(R.drawable.pill_mavi);
                        ikinci_image.setBackgroundResource(R.drawable.pill_yesll);
                        ilac_arka_plan.setBackgroundResource(R.drawable.kose_gorsel_mavi);

                        navi_oval_1.setBackgroundResource(R.drawable.oval_button_mavi);
                        navi_oval_2.setBackgroundResource(R.drawable.oval_button_mavi);


                        text_dose_mg.setTextColor(getResources().getColor(R.color.mavi));
                        form_vial.setTextColor(getResources().getColor(R.color.mavi));
                        text_amount_ml.setTextColor(getResources().getColor(R.color.mavi));
                        text_example_vial.setTextColor(getResources().getColor(R.color.mavi));

                        break;

                    case 2:
                        birinci_image.setBackgroundResource(R.drawable.pill_yesll);
                        ikinci_image.setBackgroundResource(R.drawable.pill_pembe);
                        ilac_arka_plan.setBackgroundResource(R.drawable.kose_gorsel_yesil);

                        navi_oval_1.setBackgroundResource(R.drawable.oval_button_yesil);
                        navi_oval_2.setBackgroundResource(R.drawable.oval_button_yesil);


                        text_dose_mg.setTextColor(getResources().getColor(R.color.yeşil));
                        form_vial.setTextColor(getResources().getColor(R.color.yeşil));
                        text_amount_ml.setTextColor(getResources().getColor(R.color.yeşil));
                        text_example_vial.setTextColor(getResources().getColor(R.color.yeşil));
                        break;
                    case 3:
                        birinci_image.setBackgroundResource(R.drawable.pill_pembe);
                        ikinci_image.setBackgroundResource(R.drawable.pill_kirmizi);
                        ilac_arka_plan.setBackgroundResource(R.drawable.kose_gorsel_pembe);

                        navi_oval_1.setBackgroundResource(R.drawable.oval_button_pembe);
                        navi_oval_2.setBackgroundResource(R.drawable.oval_button_pembe);


                        text_dose_mg.setTextColor(getResources().getColor(R.color.pembe));
                        form_vial.setTextColor(getResources().getColor(R.color.pembe));
                        text_amount_ml.setTextColor(getResources().getColor(R.color.pembe));
                        text_example_vial.setTextColor(getResources().getColor(R.color.pembe));
                        break;
                    case 4:
                        birinci_image.setBackgroundResource(R.drawable.pill_kirmizi);
                        ikinci_image.setBackgroundResource(R.drawable.pill_mavi);
                        ilac_arka_plan.setBackgroundResource(R.drawable.kose_gorsel_kirmizi);

                        navi_oval_1.setBackgroundResource(R.drawable.oval_button_kirmizi);
                        navi_oval_2.setBackgroundResource(R.drawable.oval_button_kirmizi);


                        text_dose_mg.setTextColor(getResources().getColor(R.color.kırmızı));
                        form_vial.setTextColor(getResources().getColor(R.color.kırmızı));
                        text_amount_ml.setTextColor(getResources().getColor(R.color.kırmızı));
                        text_example_vial.setTextColor(getResources().getColor(R.color.kırmızı));
                        break;

                }







            }
        });  */



    }












  /*  private ArrayList<ImageModel> populateList(){

        ArrayList<ImageModel> list = new ArrayList<>();


        for(int i = 0; i < 4; i++){
            ImageModel imageModel = new ImageModel();
            imageModel.setImage_drawable(myImageList[i]);
            list.add(imageModel);

        }

        return list;
    }

    private void init() {

        text_example_vial=(TextView)findViewById(R.id.text_example_vial);


        mPager = (ViewPager) findViewById(R.id.pager);
        mPager1 = (ViewPager) findViewById(R.id.pager);

        mPager.setAdapter(new SlidingImage_Adapter(ResultActivity.this,imageModelArrayList));
        mPager1.setAdapter(new SlidingImage_Adapter(ResultActivity.this,imageModelArrayList));


        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);



        indicator.setViewPager(mPager);



        final float density = getResources().getDisplayMetrics().density;

        indicator.setRadius(5 * density);

        NUM_PAGES =imageModelArrayList.size();

        final Handler handler = new Handler();

        final Runnable Update = new Runnable() {
            public void run() {


                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
                mPager1.setCurrentItem(currentPage++, true);

                if (currentPage==0){

                    text_example_vial.setTextColor(getResources().getColor(R.color.kırmızı));
                }
                else if (currentPage==1){

                    text_example_vial.setTextColor(getResources().getColor(R.color.mavi));
                }
                else if (currentPage==2){

                    text_example_vial.setTextColor(getResources().getColor(R.color.pembe));
                }
                else if (currentPage==3){

                    text_example_vial.setTextColor(getResources().getColor(R.color.yeşil));
                }



            }
        };

        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000,3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {



            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });



    }  */



}
