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

public class javaprac extends AppCompatActivity {
    SQLiteDatabase sql5;
    Button btnjp1,btnjp2,btnjp3,btnjp4;
    ImageButton imgbtnjp1;
    TextView txtvjp1;
    Cursor c;
    String Ans="";
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javaprac);

        final ArrayList<String> q = new ArrayList<>();
        q.add("Which of the following is not a keyword in java?");
        q.add("Method Overloading is an example of");
        q.add("What are Wrapper classes?");
        q.add("This is the parent of Error and Exception classes.");
        q.add("Which of the following stands true about default modifier of class members?");
        q.add("What is Encapsulation?");
        q.add("What is TreeSet Interface?");
        q.add("What is function overriding?");
        q.add("What is a transient variable?");
        q.add("When finally block gets executed?");

        final ArrayList<String> opt1 = new ArrayList<>();
        opt1.add("static");
        opt1.add("Static Binding");
        opt1.add("These are classes that wraps functionality of an existing class");
        opt1.add("Throwable");
        opt1.add("By default, variables, methods and constructors can be accessed by subclass only");
        opt1.add("Encapsulation is a technique to define different methods of same type");
        opt1.add("It is a Set implemented when we want elements in a tree based order");
        opt1.add("If a subclass uses a method that is already provided by its parent class, it is known as Method Overriding");
        opt1.add("A transient variable is a variable which is serialized during Serialization");
        opt1.add("Always when try block get executed, no matter exception occured or not");

        ArrayList<String> opt2 = new ArrayList<>();
        opt2.add("Boolean");
        opt2.add("Dynamic Binding");
        opt2.add("These are classes that allow primitive types to be accessed as objects");
        opt2.add("Catchable");
        opt2.add("By default, variables, methods and constructors can be accessed by any class lying in any package");
        opt2.add("Encapsulation is the ability of an object to take on many forms");
        opt2.add("It is a Set implemented when we want elements in a sorted order");
        opt2.add("If a subclass provides a specific implementation of a method that is already provided by its parent class, it is known as Method Overriding");
        opt2.add("A transient variable is a variable that may not be serialized during Serialization");
        opt2.add("Always when a method get executed, no matter exception occured or not");

        ArrayList<String> opt3 = new ArrayList<>();
        opt3.add("void");
        opt3.add("Both of the above");
        opt3.add("Both of the above");
        opt3.add("MainError");
        opt3.add("By default, variables, methods and constructors can be accessed by any class lying in the same package");
        opt3.add("Encapsulation is the technique of making the fields in a class private and providing access to the fields via public methods");
        opt3.add("It is a Set implemented when we want elements in a binary tree format");
        opt3.add("Both of the above");
        opt3.add("A transient variable is a variable which is to be marked as serializable");
        opt3.add("Always when a try block get executed, if exception do not occur");



        ArrayList<String> opt4 = new ArrayList<>();
        opt4.add("private");
        opt4.add("None of the above");
        opt4.add("None of the above");
        opt4.add("MainException");
        opt4.add("None of the above");
        opt4.add("None of the above");
        opt4.add("It is a Set implemented when we want elements in a hiearchical order");
        opt4.add("None of the above");
        opt4.add("None of the above");
        opt4.add("Only when exception occurs in try block code");


        ArrayList<String> answer = new ArrayList<>();
        answer.add("Boolean");
        answer.add("Static Binding");
        answer.add("These are classes that allow primitive types to be accessed as objects");
        answer.add("Throwable");
        answer.add("By default, variables, methods and constructors can be accessed by any class lying in the same package");
        answer.add("Encapsulation is the technique of making the fields in a class private and providing access to the fields via public methods");
        answer.add("It is a Set implemented when we want elements in a sorted order");
        answer.add("If a subclass provides a specific implementation of a method that is already provided by its parent class, it is known as Method Overriding");
        answer.add("A transient variable is a variable that may not be serialized during Serialization");
        answer.add("Always when try block get executed, no matter exception occured or not");

        txtvjp1 = (TextView) findViewById(R.id.txtvjp1);
        btnjp1 = (Button) findViewById(R.id.btnjp1);
        btnjp2 = (Button) findViewById(R.id.btnjp2);
        btnjp3 = (Button) findViewById(R.id.btnjp3);
        btnjp4 = (Button) findViewById(R.id.btnjp4);
        imgbtnjp1 = (ImageButton) findViewById(R.id.imgbtnjp1);

        sql5 = openOrCreateDatabase("mydbjp", MODE_PRIVATE, null);
        sql5.execSQL("create table if not exists javaprac(serial varchar,question varchar,opt1 varchar,opt2 varchar,opt3 varchar,opt4 varchar,answer varchar)");

        for (int i = 0; i < q.size(); i++) {
            sql5.execSQL("insert into javaprac values('" + i + "','" + q.get(i) + "','" + opt1.get(i) + "','" + opt2.get(i) + "','" + opt3.get(i) + "','" + opt4.get(i) + "','" + answer.get(i) + "')");
        }

        c = sql5.rawQuery("Select * from javaprac where serial=" + flag, null);
        c.moveToFirst();
        txtvjp1.setText(c.getString(c.getColumnIndex("question")));
        btnjp1.setText(c.getString(c.getColumnIndex("opt1")));
        btnjp2.setText(c.getString(c.getColumnIndex("opt2")));
        btnjp3.setText(c.getString(c.getColumnIndex("opt3")));
        btnjp4.setText(c.getString(c.getColumnIndex("opt4")));
        Ans = c.getString(c.getColumnIndex("answer"));

        btnjp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnjp1.getText().toString().equalsIgnoreCase(Ans)) {
                    btnjp1.setBackgroundColor(Color.GREEN);
                }
                else
                    btnjp1.setBackgroundColor(Color.RED);
            }
        });

        btnjp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnjp2.getText().toString().equalsIgnoreCase(Ans)) {
                    btnjp2.setBackgroundColor(Color.GREEN);
                } else
                    btnjp2.setBackgroundColor(Color.RED);
            }
        });

        btnjp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnjp3.getText().toString().equalsIgnoreCase(Ans)) {
                    btnjp3.setBackgroundColor(Color.GREEN);
                } else
                    btnjp3.setBackgroundColor(Color.RED);
            }
        });

        btnjp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnjp4.getText().toString().equalsIgnoreCase(Ans)) {
                    btnjp4.setBackgroundColor(Color.GREEN);
                } else
                    btnjp4.setBackgroundColor(Color.RED);
            }
        });

        imgbtnjp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                flag++;
                //q.size=10 ans max value of flag is till 9.
                if (flag <= q.size()-1)
                {

                    btnjp1.setBackgroundResource(android.R.drawable.btn_default);
                    btnjp2.setBackgroundResource(android.R.drawable.btn_default);
                    btnjp3.setBackgroundResource(android.R.drawable.btn_default);
                    btnjp4.setBackgroundResource(android.R.drawable.btn_default);
                    c = sql5.rawQuery("Select * from javaprac where serial=" + flag, null);
                    c.moveToFirst();
                    txtvjp1.setText(c.getString(c.getColumnIndex("question")));
                    btnjp1.setText(c.getString(c.getColumnIndex("opt1")));
                    btnjp2.setText(c.getString(c.getColumnIndex("opt2")));
                    btnjp3.setText(c.getString(c.getColumnIndex("opt3")));
                    btnjp4.setText(c.getString(c.getColumnIndex("opt4")));
                    Ans = c.getString(c.getColumnIndex("answer"));

                    btnjp1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (btnjp1.getText().toString().equalsIgnoreCase(Ans)) {
                                btnjp1.setBackgroundColor(Color.GREEN);
                            } else
                                btnjp1.setBackgroundColor(Color.RED);
                        }
                    });

                    btnjp2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (btnjp2.getText().toString().equalsIgnoreCase(Ans)) {
                                btnjp2.setBackgroundColor(Color.GREEN);
                            } else
                                btnjp2.setBackgroundColor(Color.RED);
                        }
                    });

                    btnjp3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (btnjp3.getText().toString().equalsIgnoreCase(Ans)) {
                                btnjp3.setBackgroundColor(Color.GREEN);
                            } else
                                btnjp3.setBackgroundColor(Color.RED);
                        }
                    });

                    btnjp4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (btnjp4.getText().toString().equalsIgnoreCase(Ans)) {
                                btnjp4.setBackgroundColor(Color.GREEN);
                            } else
                                btnjp4.setBackgroundColor(Color.RED);
                        }
                    });
                }


                if (flag==q.size())
                {
                    Intent intent = new Intent(javaprac.this, practise.class);
                    startActivity(intent);
                }



            }

        });

    }
}
