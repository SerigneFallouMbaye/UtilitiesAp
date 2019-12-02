package com.e.utilitiesap;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Button btnCall = (Button) findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intentCall = new Intent(Intent.ACTION_DIAL);
                intentCall.setData(Uri.parse("tel:+221778021479"));
                startActivity(intentCall);
                // Log.i("MainActivity","Lancé un appel");
                Toast.makeText(getApplicationContext(),"Lancer un appel",Toast.LENGTH_LONG).show();
            }
        });

        Button btnSms = (Button) findViewById(R.id.btnSms);
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intentSms = new Intent(Intent.ACTION_SENDTO);
                intentSms.setData(Uri.parse("smsto:" +Uri.encode("+221778021479")));
                startActivity(intentSms);
                Toast.makeText(getApplicationContext(),"Envoyer un SMS",Toast.LENGTH_LONG).show();
            }
        });

        Button btnWeb = (Button) findViewById(R.id.btnWeb);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intentWeb = new Intent(Intent.ACTION_VIEW,Uri.parse("http://google.com"));
                startActivity(intentWeb);
                Toast.makeText(getApplicationContext(),"Chargement de la Page",Toast.LENGTH_LONG).show();
            }
        });



        Button bntMap = (Button) findViewById(R.id.btnMap);
        bntMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoUri = String.format("geo:14.6959099,-16.4805384");
                Uri geo = Uri.parse(geoUri);
                Intent intentMap = new Intent(Intent.ACTION_VIEW, geo);
                startActivity(intentMap);
                Toast.makeText(getApplicationContext(),"Choisir l'App",Toast.LENGTH_LONG).show();
            }
        });

        Button bntShare = (Button) findViewById(R.id.btnShare);
        bntShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intentShare = new Intent(Intent.ACTION_SEND);
                intentShare.setType("text/plain");
                intentShare.putExtra(Intent.EXTRA_SUBJECT, "CS639");
                intentShare.putExtra(Intent.EXTRA_TEXT, "Join CS639");
                startActivity(intentShare.createChooser(intentShare, "Partager"));;
                Toast.makeText(getApplicationContext(),"Choisir l'App",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        else if (id == R.id.action_help);{

            Intent intentHelp = new Intent(getApplicationContext(),HelpActivity.class);
            startActivity(intentHelp);
        }

        return super.onOptionsItemSelected(item);
    }
}