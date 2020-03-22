package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity_BENİM extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int REQUEST_PHONE_CALL = 123;
    final Context context = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_benim);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        toolbar.setTitle("Tatava");

        Button ara_button = (Button) findViewById(R.id.ara_button);

        TextView no_dokuz_cev_sayi=(TextView)findViewById(R.id.no_dokuz_cevrimici_sayısı);









      /*  if (ContextCompat.checkSelfPermission(MainActivity_BENİM.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity_BENİM.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
        }
        else
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

            // alert dialog başlığını tanımlıyoruz.
            alertDialogBuilder.setTitle("Arama yapmak için telefonu kullanmamıza izin vermen gerekiyor!");

            // alert dialog özelliklerini oluşturuyoruz.
            alertDialogBuilder
                    .setCancelable(false)
                    .setIcon(R.mipmap.ic_launcher_round)
                    // Evet butonuna tıklanınca yapılacak işlemleri buraya yazıyoruz.
                    .setPositiveButton("İzin ver", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            ActivityCompat.requestPermissions(MainActivity_BENİM.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);



                        }
                    })
                    // İptal butonuna tıklanınca yapılacak işlemleri buraya yazıyoruz.
                    .setNegativeButton("Reddet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

            // alert dialog nesnesini oluşturuyoruz
            AlertDialog alertDialog = alertDialogBuilder.create();

            // alerti gösteriyoruz
            alertDialog.show();
        }  */

        ara_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0850 466 0 800,9"));
                startActivity(callIntent);


            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.ana_sayfa) {
            Toast.makeText(getApplicationContext(),"Vakıf Kurallarını Seçtiniz.",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.tatava_üni) {
            Intent intent = new Intent(MainActivity_BENİM.this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.tatava_lise) {
            Toast.makeText(getApplicationContext(),"Bize Yazın seçtiniz.",Toast.LENGTH_SHORT).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }











}