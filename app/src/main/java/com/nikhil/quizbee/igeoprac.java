package com.nikhil.quizbee;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class igeoprac extends AppCompatActivity {
    SQLiteDatabase sql5;
    Button btngeo1, btngeo2, btngeo3,btngeo4;
    ImageButton imgbtn1;
    TextView txtvgeo1;
    Cursor c;
    String Ans="";
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igeoprac);

        final ArrayList<String> q = new ArrayList<>();
        q.add("Which latitude passes through the middle of India?");
        q.add("Which of the following is a Trans- Himalayan river?");
        q.add("Which foreign country is closest to Andaman Islands");
        q.add("The state having largest area under waste land is");
        q.add("India lies in the hemisphere");
        q.add("Which water Body separates Andaman and Nicobar Islands");
        q.add("The two Volcanic islands in the Indian territory are");
        q.add("Which state is in the eastern most state of India");
        q.add("The largest southern most single Island in India is");
        q.add("The Eastern coast of India is known as");

        final ArrayList<String> opt1 = new ArrayList<>();
        opt1.add("Equator\t");
        opt1.add("ganga");
        opt1.add("sri lanka");
        opt1.add("rajastan");
        opt1.add("northern and eastern");
        opt1.add("10 Degree Channel");
        opt1.add("Kavaratti and New Moor");
        opt1.add("Assam");
        opt1.add("Rameswaram Island");
        opt1.add("Eastern plateau");

        ArrayList<String> opt2 = new ArrayList<>();
        opt2.add("Arctic Circle");
        opt2.add("yamuna");
        opt2.add("indonesia");
        opt2.add("gujrat");
        opt2.add("southern and eastern");
        opt2.add("11 Degree Channel");
        opt2.add("Bitra and Kavaratti");
        opt2.add("Nagaland");
        opt2.add("Minicoy Island");
        opt2.add("Bengal Coast");

        ArrayList<String> opt3 = new ArrayList<>();
        opt3.add("Tropic of Capricorn");
        opt3.add("indus");
        opt3.add("mynmmar");
        opt3.add("madhya pradesh");
        opt3.add("northern and western");
        opt3.add("andaman sea");
        opt3.add("Pamban and Barren");
        opt3.add("Arunachal Pradesh");
        opt3.add("Car Nicobar Island");
        opt3.add("Coromandal Coast");


        ArrayList<String> opt4 = new ArrayList<>();
        opt4.add("Tropic of Cancer");
        opt4.add("saraswati");
        opt4.add("pakistan");
        opt4.add("jammu & kashmir");
        opt4.add("southern and western");
        opt4.add("bay of bengal");
        opt4.add("Narcodam and Barren");
        opt4.add("Manipur");
        opt4.add("Great Nicobar Island");
        opt4.add("Cyclonic Coast");


        ArrayList<String> answer = new ArrayList<>();
        answer.add("Tropic of Cancer");
        answer.add("indus");
        answer.add("mynmmar");
        answer.add("rajastan");
        answer.add("northern and eastern");
        answer.add("10 degree channel");
        answer.add("Pamban and Barren");
        answer.add("Arunachal Pradesh");
        answer.add("Great Nicobar Island");
        answer.add("Coromandal Coast");

        txtvgeo1 = (TextView) findViewById(R.id.txtvgeo1);
        btngeo1 = (Button) findViewById(R.id.btngeo1);
        btngeo2 = (Button) findViewById(R.id.btngeo2);
        btngeo3 = (Button) findViewById(R.id.btngeo3);
        btngeo4 = (Button) findViewById(R.id.btngeo4);
        imgbtn1 = (ImageButton) findViewById(R.id.imgbtn1);

        sql5 = openOrCreateDatabase("mydb6", MODE_PRIVATE, null);
        sql5.execSQL("create table if not exists igeo(serial varchar,question varchar,opt1 varchar,opt2 varchar,opt3 varchar,opt4 varchar,answer varchar)");

        for (int i = 0; i < q.size(); i++) {
            sql5.execSQL("insert into igeo values('" + i + "','" + q.get(i) + "','" + opt1.get(i) + "','" + opt2.get(i) + "','" + opt3.get(i) + "','" + opt4.get(i) + "','" + answer.get(i) + "')");
        }

        c = sql5.rawQuery("Select * from igeo where serial=" + flag, null);
        c.moveToFirst();
        txtvgeo1.setText(c.getString(c.getColumnIndex("question")));
        btngeo1.setText(c.getString(c.getColumnIndex("opt1")));
        btngeo2.setText(c.getString(c.getColumnIndex("opt2")));
        btngeo3.setText(c.getString(c.getColumnIndex("opt3")));
        btngeo4.setText(c.getString(c.getColumnIndex("opt4")));
        Ans = c.getString(c.getColumnIndex("answer"));

        btngeo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btngeo1.getText().toString().equalsIgnoreCase(Ans)) {
                    btngeo1.setBackgroundColor(Color.GREEN);
                }
                 else
                    btngeo1.setBackgroundColor(Color.RED);
            }
        });

        btngeo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btngeo2.getText().toString().equalsIgnoreCase(Ans)) {
                    btngeo2.setBackgroundColor(Color.GREEN);
                } else
                    btngeo2.setBackgroundColor(Color.RED);
            }
        });

        btngeo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btngeo3.getText().toString().equalsIgnoreCase(Ans)) {
                    btngeo3.setBackgroundColor(Color.GREEN);
                } else
                    btngeo3.setBackgroundColor(Color.RED);
            }
        });

        btngeo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btngeo4.getText().toString().equalsIgnoreCase(Ans)) {
                    btngeo4.setBackgroundColor(Color.GREEN);
                } else
                    btngeo4.setBackgroundColor(Color.RED);
            }
        });

        imgbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                flag++;
                //q.size=10 ans max value of flag is till 9.
                if (flag <= q.size()-1)
                {

                    btngeo1.setBackgroundResource(android.R.drawable.btn_default);
                    btngeo2.setBackgroundResource(android.R.drawable.btn_default);
                    btngeo3.setBackgroundResource(android.R.drawable.btn_default);
                    btngeo4.setBackgroundResource(android.R.drawable.btn_default);
                    c = sql5.rawQuery("Select * from igeo where serial=" + flag, null);
                    c.moveToFirst();
                    txtvgeo1.setText(c.getString(c.getColumnIndex("question")));
                    btngeo1.setText(c.getString(c.getColumnIndex("opt1")));
                    btngeo2.setText(c.getString(c.getColumnIndex("opt2")));
                    btngeo3.setText(c.getString(c.getColumnIndex("opt3")));
                    btngeo4.setText(c.getString(c.getColumnIndex("opt4")));
                    Ans = c.getString(c.getColumnIndex("answer"));

                    btngeo1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (btngeo1.getText().toString().equalsIgnoreCase(Ans)) {
                                btngeo1.setBackgroundColor(Color.GREEN);
                            } else
                                btngeo1.setBackgroundColor(Color.RED);
                        }
                    });

                    btngeo2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (btngeo2.getText().toString().equalsIgnoreCase(Ans)) {
                                btngeo2.setBackgroundColor(Color.GREEN);
                            } else
                                btngeo2.setBackgroundColor(Color.RED);
                        }
                    });

                    btngeo3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (btngeo3.getText().toString().equalsIgnoreCase(Ans)) {
                                btngeo3.setBackgroundColor(Color.GREEN);
                            } else
                                btngeo3.setBackgroundColor(Color.RED);
                        }
                    });

                    btngeo4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (btngeo4.getText().toString().equalsIgnoreCase(Ans)) {
                                btngeo4.setBackgroundColor(Color.GREEN);
                            } else
                                btngeo4.setBackgroundColor(Color.RED);
                        }
                    });
                 }


                  if (flag==q.size())
                  {
                    Intent intent = new Intent(igeoprac.this, practise.class);
                    startActivity(intent);
                   }



            }

        });


    }
}