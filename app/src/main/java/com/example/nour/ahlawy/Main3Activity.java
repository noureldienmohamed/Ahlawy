package com.example.nour.ahlawy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    TextView mTextView;
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);
        mTextView=findViewById(R.id.start);
        mButton=findViewById(R.id.startbt);

            }

    public void StartOn(View view) {
        Intent main2Activity = new Intent(Main3Activity.this,Main2Activity.class);
        startActivity(main2Activity);
    }
}
