package com.example.hwProject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hwProject.R;

/*
P0104 등록 일정 확인페이지
등록 일정 확인을 위해 일정들을 나열한다.
 */

public class P0104 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p0104);

        Button button = (Button) findViewById(R.id.p0102);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), P0102.class);
                startActivity(intent);
            }
        });
    }
}