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

public class androprac extends AppCompatActivity {
    SQLiteDatabase sql5;
    Button btnandrop1, btnandrop2, btnandrop3,btnandrop4;
    ImageButton imgbtn1;
    TextView txtvandrop1;
    Cursor c;
    String Ans="";
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androprac);

        final ArrayList<String> q = new ArrayList<>();
        q.add("How to pass the data from activity to services in android?");
        q.add("What is an anonymous class in android?");
        q.add("What is LastKnownLocation in android?");
        q.add("What are the functionalities of HTTP Client interface in android?\n");
        q.add("What is the HTTP response error code status in android?");
        q.add("How many levels of securities are there in android?");
        q.add("What is a thread in android?");
        q.add("What is the difference between margin and padding in android layout?");
        q.add("What are the return values of onStartCommand() in android services?");
        q.add("What is the use of content provider in android?");






        final ArrayList<String> opt1 = new ArrayList<>();
        opt1.add("We can store the data in a common database and access the data on services as well as in Activity");
        opt1.add("Interface class");
        opt1.add("To find the last location of a phone");
        opt1.add("Connection management");
        opt1.add("status code < 100");
        opt1.add("App level security and kernel level security");
        opt1.add("Same as services");
        opt1.add("Margin is specifying the extra space left on all four sides in layout");
        opt1.add("START_STICKY");
        opt1.add("To send the data from an application to another application");



        ArrayList<String> opt2 = new ArrayList<>();
        opt2.add("We can not pass data from activity to services.");
        opt2.add("A class that does not have a name but have functionalities in it");
        opt2.add("To find known location of a phone");
        opt2.add("Cookies management");
        opt2.add("status code > 100");
        opt2.add("Android level security");
        opt2.add("Background activity");
        opt2.add("Padding is used to offset the content of a view by specific px or dp\n");
        opt2.add("START_NOT_STICKY");
        opt2.add("To store the data in a database");



        ArrayList<String> opt3 = new ArrayList<>();
        opt3.add("Using putExtra() method in intent, we can pass the data using setResult()");
        opt3.add("Java class");
        opt3.add("To find the last known location of a phone");
        opt3.add("Authentication management");
        opt3.add("status >= 400");
        opt3.add("Java level security");
        opt3.add("Broadcast Receiver");
        opt3.add("Both A and B are correct");
        opt3.add("START_REDELIVER_INTENT");
        opt3.add("To share the data between applications");


        ArrayList<String> opt4 = new ArrayList<>();
        opt4.add("A & C");
        opt4.add("Manifest file");
        opt4.add("None of the above");
        opt4.add("All of the above");
        opt4.add("None of the above");
        opt4.add("None of the above");
        opt4.add("Independent dis-patchable unit is called a thread");
        opt4.add("None of the above");
        opt4.add("All of the above");
        opt4.add("None of the above");





        ArrayList<String> answer = new ArrayList<>();
        answer.add("A & C");
        answer.add("A class that does not have a name but have functionalities in it");
        answer.add("To find the last known location of a phone");
        answer.add("All of the above");
        answer.add("status >= 400");
        answer.add("App level security and kernel level security");
        answer.add("Independent dis-patchable unit is called a thread");
        answer.add("Both A and B are correct");
        answer.add("All of the above");
        answer.add("To share the data between applications");



        txtvandrop1 = (TextView) findViewById(R.id.txtvandrop1);
        btnandrop1 = (Button) findViewById(R.id.btnandrop1);
        btnandrop2 = (Button) findViewById(R.id.btnandrop2);
        btnandrop3 = (Button) findViewById(R.id.btnandrop3);
        btnandrop4 = (Button) findViewById(R.id.btnandrop4);
        imgbtn1 = (ImageButton) findViewById(R.id.imgbtn1);

        sql5 = openOrCreateDatabase("mydb6", MODE_PRIVATE, null);
        sql5.execSQL("create table if not exists iandrop(serial varchar,question varchar,opt1 varchar,opt2 varchar,opt3 varchar,opt4 varchar,answer varchar)");

        for (int i = 0; i < q.size(); i++) {
            sql5.execSQL("insert into iandrop values('" + i + "','" + q.get(i) + "','" + opt1.get(i) + "','" + opt2.get(i) + "','" + opt3.get(i) + "','" + opt4.get(i) + "','" + answer.get(i) + "')");
        }

        c = sql5.rawQuery("Select * from iandrop where serial=" + flag, null);
        c.moveToFirst();
        txtvandrop1.setText(c.getString(c.getColumnIndex("question")));
        btnandrop1.setText(c.getString(c.getColumnIndex("opt1")));
        btnandrop2.setText(c.getString(c.getColumnIndex("opt2")));
        btnandrop3.setText(c.getString(c.getColumnIndex("opt3")));
        btnandrop4.setText(c.getString(c.getColumnIndex("opt4")));
        Ans = c.getString(c.getColumnIndex("answer"));

        btnandrop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnandrop1.getText().toString().equalsIgnoreCase(Ans)) {
                    btnandrop1.setBackgroundColor(Color.GREEN);
                }
                else
                    btnandrop1.setBackgroundColor(Color.RED);
            }
        });

        btnandrop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnandrop2.getText().toString().equalsIgnoreCase(Ans)) {
                    btnandrop2.setBackgroundColor(Color.GREEN);
                } else
                    btnandrop2.setBackgroundColor(Color.RED);
            }
        });

        btnandrop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnandrop3.getText().toString().equalsIgnoreCase(Ans)) {
                    btnandrop3.setBackgroundColor(Color.GREEN);
                } else
                    btnandrop3.setBackgroundColor(Color.RED);
            }
        });

        btnandrop4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnandrop4.getText().toString().equalsIgnoreCase(Ans)) {
                    btnandrop4.setBackgroundColor(Color.GREEN);
                } else
                    btnandrop4.setBackgroundColor(Color.RED);
            }
        });

        imgbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                flag++;
                //q.size=10 ans max value of flag is till 9.
                if (flag <= q.size()-1)
                {

                    btnandrop1.setBackgroundResource(android.R.drawable.btn_default);
                    btnandrop2.setBackgroundResource(android.R.drawable.btn_default);
                    btnandrop3.setBackgroundResource(android.R.drawable.btn_default);
                    btnandrop4.setBackgroundResource(android.R.drawable.btn_default);
                    c = sql5.rawQuery("Select * from iandrop where serial=" + flag, null);
                    c.moveToFirst();
                    txtvandrop1.setText(c.getString(c.getColumnIndex("question")));
                    btnandrop1.setText(c.getString(c.getColumnIndex("opt1")));
                    btnandrop2.setText(c.getString(c.getColumnIndex("opt2")));
                    btnandrop3.setText(c.getString(c.getColumnIndex("opt3")));
                    btnandrop4.setText(c.getString(c.getColumnIndex("opt4")));
                    Ans = c.getString(c.getColumnIndex("answer"));

                    btnandrop1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (btnandrop1.getText().toString().equalsIgnoreCase(Ans)) {
                                btnandrop1.setBackgroundColor(Color.GREEN);
                            } else
                                btnandrop1.setBackgroundColor(Color.RED);
                        }
                    });

                    btnandrop2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (btnandrop2.getText().toString().equalsIgnoreCase(Ans)) {
                                btnandrop2.setBackgroundColor(Color.GREEN);
                            } else
                                btnandrop2.setBackgroundColor(Color.RED);
                        }
                    });

                    btnandrop3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (btnandrop3.getText().toString().equalsIgnoreCase(Ans)) {
                                btnandrop3.setBackgroundColor(Color.GREEN);
                            } else
                                btnandrop3.setBackgroundColor(Color.RED);
                        }
                    });

                    btnandrop4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (btnandrop4.getText().toString().equalsIgnoreCase(Ans)) {
                                btnandrop4.setBackgroundColor(Color.GREEN);
                            } else
                                btnandrop4.setBackgroundColor(Color.RED);
                        }
                    });
                }


                if (flag==q.size())
                {
                    Intent intent = new Intent(androprac.this, practise.class);
                    startActivity(intent);
                }



            }

        });
    }
}
