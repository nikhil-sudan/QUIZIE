package com.nikhil.quizbee;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Topics extends AppCompatActivity {
    Button btn31,btn32,btn33,btn34,btn35,btn36,btn37,btn38,btn39,btn392;
    TextView username;
    String nameuser;

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("EXIT")
                .setCancelable(false)
                .setMessage("Are you sure you want to close the app")
                .setNegativeButton("No", null)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        btn31=(Button)findViewById(R.id.btn31);
        btn32=(Button)findViewById(R.id.btn32);
        btn33=(Button)findViewById(R.id.btn33);
        btn34=(Button)findViewById(R.id.btn34);
        btn35=(Button)findViewById(R.id.btn35);
        btn36=(Button)findViewById(R.id.btn36);
        btn37=(Button)findViewById(R.id.btn37);
        btn38=(Button)findViewById(R.id.btn38);
        btn39=(Button)findViewById(R.id.btn39);
        btn392=(Button)findViewById(R.id.btn392);
        username=(TextView)findViewById(R.id.username);

        String prevAct=getIntent().getExtras().getString("fromActivity");

/*
        if (prevAct.equals("p")){

            username.setText("Howdy!\t"+nameuser);
        }
*/
        if (prevAct.equals("overview")){
            nameuser=getIntent().getExtras().getString("name1");
            username.setText("Welcome!\t"+nameuser);
        }



/*
        StringBuffer re=new StringBuffer();
        re.append(nameuser);

        username.setText(re);
*/


        btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Topics.this,gkprac.class);
                startActivity(intent);
            }
        });

        btn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Topics.this,gkquiz.class);
                startActivity(intent);
            }
        });

        btn33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Topics.this,igeoprac.class);
                startActivity(intent);
            }
        });

        btn34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Topics.this,igeoquiz.class);
                startActivity(intent);
            }
        });

        btn35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Topics.this,ihistprac.class);
                startActivity(intent);
            }
        });

        btn36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Topics.this,ihistquiz.class);
                startActivity(intent);
            }
        });

        btn37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Topics.this,javaprac.class);
                startActivity(intent);
            }
        });

        btn38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Topics.this,javaquiz.class);
                startActivity(intent);
            }
        });

        btn392.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Topics.this,androprac.class);
                startActivity(intent);
            }
        });

        btn39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Topics.this,androquiz.class);
                startActivity(intent);
            }
        });


    }



}
