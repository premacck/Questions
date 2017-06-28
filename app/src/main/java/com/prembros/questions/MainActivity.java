package com.prembros.questions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_question1:
                startActivity(new Intent(MainActivity.this, Question1.class));
                break;
            case R.id.button_question2:
                startActivity(new Intent(MainActivity.this, Question2.class));
                break;
            default:
                break;
        }
    }
}
