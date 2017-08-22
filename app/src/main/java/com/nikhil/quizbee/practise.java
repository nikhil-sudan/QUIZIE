package com.nikhil.quizbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class practise extends AppCompatActivity {

    Button btnpr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practise);


        btnpr2=(Button)findViewById(R.id.btnpr2);
        btnpr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(practise.this,Topics.class);
                intent.putExtra("fromActivity","p");
                startActivity(intent);
            }
        });


    }
}
