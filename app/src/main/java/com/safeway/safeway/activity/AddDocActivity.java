package com.safeway.safeway.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.safeway.safeway.R;


public class AddDocActivity extends AppCompatActivity {

    private ImageView backIv;

    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);
//        submitBtn = findViewById(R.id.btn_doc_submit);
//
//        submitBtn.setOnClickListener(v -> sendToActivity(MainActivity.class));

    }

    private void sendToActivity(Class<?> classs) {
        Intent intent = new Intent(AddDocActivity.this, classs);
        startActivity(intent);
    }
}
