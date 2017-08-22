package com.nikhil.quizbee;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class ihistprac extends AppCompatActivity {
    SQLiteDatabase sql5;
    Button btnhistp1, btnhistp2, btnhistp3,btnhistp4;
    ImageButton imgbtn1;
    TextView txtvhistp1;
    Cursor c;
    String Ans="";
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ihistprac);

        final ArrayList<String> q = new ArrayList<>();
        q.add("The Battle of Plassey was fought in");
        q.add("The territory of Porus who offered strong resistance to Alexander was situated between the rivers of");
        q.add("Under Akbar, the Mir Bakshi was required to look after");
        q.add("Tripitakas are sacred books of");
        q.add("The trident-shaped symbol of Buddhism does not represent");
        q.add("The theory of economic drain of India during British imperialism was propounded by");
        q.add("The system of competitive examination for civil service was accepted in principle in the year");
        q.add("The Vijayanagara ruler, Kirshnadev Rayas work Amuktamalyada, was in");
        q.add("Under an agreement with which of the following countries did Subhas Chandra Bose organize the Indian soldiers, taken as prisoners by the Axis Powers, into the Azad Hind Fauj?");
        q.add("The use of Kharoshti in ancient Indian architecture is the result of Indias contact with");


        final ArrayList<String> opt1 = new ArrayList<>();
        opt1.add("1757");
        opt1.add("Sutlej and Beas");
        opt1.add("military affairs");
        opt1.add("Buddhists");
        opt1.add("Nirvana");
        opt1.add("Jawaharlal Nehru");
        opt1.add("1833");
        opt1.add("Telugu");
        opt1.add("China");
        opt1.add("Central Asia");


        ArrayList<String> opt2 = new ArrayList<>();
        opt2.add("1782");
        opt2.add("Jhelum and Chenab");
        opt2.add("the state treasury");
        opt2.add("Hindus");
        opt2.add("Sangha");
        opt2.add("Dadabhai Naoroji");
        opt2.add("1853");
        opt2.add("Sanskrit");
        opt2.add("Germany");
        opt2.add("Iran");

        ArrayList<String> opt3 = new ArrayList<>();
        opt3.add("1748");
        opt3.add("Ravi and Chenab");
        opt3.add("the royal household");
        opt3.add("Jains");
        opt3.add("Buddha");
        opt3.add("R.C. Dutt");
        opt3.add("1858");
        opt3.add("Tamil");
        opt3.add("Italy");
        opt3.add("Greece");


        ArrayList<String> opt4 = new ArrayList<>();
        opt4.add("1764");
        opt4.add("Ganga and Yamuna");
        opt4.add("the land revenue system");
        opt4.add("None of the above");
        opt4.add("Dhamma");
        opt4.add("M.K. Gandhi");
        opt4.add("1882");
        opt4.add("Kannada");
        opt4.add("Japan");
        opt4.add("China");


        ArrayList<String> answer = new ArrayList<>();
        answer.add("1757");
        answer.add("Jhelum and Chenab");
        answer.add("military affairs");
        answer.add("Buddhists");
        answer.add("Nirvana");
        answer.add("Dadabhai Naoroji");
        answer.add("1853");
        answer.add("Telugu");
        answer.add("Japan");
        answer.add("Greece");

        txtvhistp1 = (TextView) findViewById(R.id.txtvhistp1);
        btnhistp1 = (Button) findViewById(R.id.btnhistp1);
        btnhistp2 = (Button) findViewById(R.id.btnhistp2);
        btnhistp3 = (Button) findViewById(R.id.btnhistp3);
        btnhistp4 = (Button) findViewById(R.id.btnhistp4);
        imgbtn1 = (ImageButton) findViewById(R.id.imgbtn1);

        sql5 = openOrCreateDatabase("mydb6", MODE_PRIVATE, null);
        sql5.execSQL("create table if not exists ihistp(serial varchar,question varchar,opt1 varchar,opt2 varchar,opt3 varchar,opt4 varchar,answer varchar)");

        for (int i = 0; i < q.size(); i++) {
            sql5.execSQL("insert into ihistp values('" + i + "','" + q.get(i) + "','" + opt1.get(i) + "','" + opt2.get(i) + "','" + opt3.get(i) + "','" + opt4.get(i) + "','" + answer.get(i) + "')");
        }

        c = sql5.rawQuery("Select * from ihistp where serial=" + flag, null);
        c.moveToFirst();
        txtvhistp1.setText(c.getString(c.getColumnIndex("question")));
        btnhistp1.setText(c.getString(c.getColumnIndex("opt1")));
        btnhistp2.setText(c.getString(c.getColumnIndex("opt2")));
        btnhistp3.setText(c.getString(c.getColumnIndex("opt3")));
        btnhistp4.setText(c.getString(c.getColumnIndex("opt4")));
        Ans = c.getString(c.getColumnIndex("answer"));

        btnhistp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnhistp1.getText().toString().equalsIgnoreCase(Ans)) {
                    btnhistp1.setBackgroundColor(Color.GREEN);
                }
                else
                    btnhistp1.setBackgroundColor(Color.RED);
            }
        });

        btnhistp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnhistp2.getText().toString().equalsIgnoreCase(Ans)) {
                    btnhistp2.setBackgroundColor(Color.GREEN);
                } else
                    btnhistp2.setBackgroundColor(Color.RED);
            }
        });

        btnhistp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnhistp3.getText().toString().equalsIgnoreCase(Ans)) {
                    btnhistp3.setBackgroundColor(Color.GREEN);
                } else
                    btnhistp3.setBackgroundColor(Color.RED);
            }
        });

        btnhistp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnhistp4.getText().toString().equalsIgnoreCase(Ans)) {
                    btnhistp4.setBackgroundColor(Color.GREEN);
                } else
                    btnhistp4.setBackgroundColor(Color.RED);
            }
        });

        imgbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                flag++;
                //q.size=10 ans max value of flag is till 9.
                if (flag <= q.size()-1)
                {

                    btnhistp1.setBackgroundResource(android.R.drawable.btn_default);
                    btnhistp2.setBackgroundResource(android.R.drawable.btn_default);
                    btnhistp3.setBackgroundResource(android.R.drawable.btn_default);
                    btnhistp4.setBackgroundResource(android.R.drawable.btn_default);
                    c = sql5.rawQuery("Select * from ihistp where serial=" + flag, null);
                    c.moveToFirst();
                    txtvhistp1.setText(c.getString(c.getColumnIndex("question")));
                    btnhistp1.setText(c.getString(c.getColumnIndex("opt1")));
                    btnhistp2.setText(c.getString(c.getColumnIndex("opt2")));
                    btnhistp3.setText(c.getString(c.getColumnIndex("opt3")));
                    btnhistp4.setText(c.getString(c.getColumnIndex("opt4")));
                    Ans = c.getString(c.getColumnIndex("answer"));

                    btnhistp1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (btnhistp1.getText().toString().equalsIgnoreCase(Ans)) {
                                btnhistp1.setBackgroundColor(Color.GREEN);
                            } else
                                btnhistp1.setBackgroundColor(Color.RED);
                        }
                    });

                    btnhistp2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (btnhistp2.getText().toString().equalsIgnoreCase(Ans)) {
                                btnhistp2.setBackgroundColor(Color.GREEN);
                            } else
                                btnhistp2.setBackgroundColor(Color.RED);
                        }
                    });

                    btnhistp3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (btnhistp3.getText().toString().equalsIgnoreCase(Ans)) {
                                btnhistp3.setBackgroundColor(Color.GREEN);
                            } else
                                btnhistp3.setBackgroundColor(Color.RED);
                        }
                    });

                    btnhistp4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (btnhistp4.getText().toString().equalsIgnoreCase(Ans)) {
                                btnhistp4.setBackgroundColor(Color.GREEN);
                            } else
                                btnhistp4.setBackgroundColor(Color.RED);
                        }
                    });
                }


                if (flag==q.size())
                {
                    Intent intent = new Intent(ihistprac.this, practise.class);
                    startActivity(intent);
                }



            }

        });
    }
}
