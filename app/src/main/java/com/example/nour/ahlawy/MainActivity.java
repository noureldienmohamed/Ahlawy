package com.example.nour.ahlawy;


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            new Handler().postDelayed(new  Runnable() {
        @Override
        public void run() {
            Intent main3Activity = new Intent(MainActivity.this,Main3Activity.class);
            startActivity(main3Activity);
            finish();
        }
    },4000);

}

}
