package com.nikhil.quizbee;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class javaquiz extends AppCompatActivity {

    SQLiteDatabase sql5;
    TextView txtvjq1;
    RadioButton rbjq1,rbjq2,rbjq3,rbjq4;
    ImageButton imgbtnjq1;
    Button btnjq1;
    RadioGroup rgjq1;
    Cursor c;
    String Ans="";
    int flag=0;
    public static int score;
    public static int wrongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javaquiz);

        final ArrayList<String> q = new ArrayList<>();
        q.add("is java compiled or interpreted");
        q.add("which class is used to take input from user");
        q.add("Java runs on :?");
        q.add("What is the size of Char in Java");
        q.add("A null reference may be used to access a static variable or method");
        q.add("Following code will result in :\n int a1=5; double a2=(float)a1");
        q.add("Primitive data types are allocated on a stack?");
        q.add("Which one is not correct?");
        q.add("following code will result in: int num=6.7");
        q.add("is empty .java name is a valid source file name");


        ArrayList<String> options1 = new ArrayList<>();
        options1.add("compiled");
        options1.add("Scanf class");
        options1.add("only windows.");
        options1.add("16 bits");
        options1.add("true");
        options1.add("compilation error");
        options1.add("false");
        options1.add("class and object are just different names for the same thing.");
        options1.add("compilation error");
        options1.add("yes");

        ArrayList<String> options2 = new ArrayList<>();
        options2.add("interpreted");
        options2.add("Scanner class");
        options2.add("all operation systems.");
        options2.add("4 bits");
        options2.add("false");
        options2.add("no errors");
        options2.add("true");
        options2.add("An object is a variable, where its type is the class used to declare the variable");
        options2.add("run-time error");
        options2.add("no");

        ArrayList<String> options3 = new ArrayList<>();
        options3.add("interpreted");
        options3.add("Scanner class");
        options3.add("unix/linux os");
        options3.add("8 bits");
        options3.add("false");
        options3.add("no errors");
        options3.add("true");
        options3.add("An object is a variable, where its type is the class used to declare the variable");
        options3.add("run-time error");
        options3.add("i dont know");

        ArrayList<String> options4 = new ArrayList<>();
        options4.add("interpreted");
        options4.add("Scanner class");
        options4.add("ios");
        options4.add("32 bits");
        options4.add("false");
        options4.add("no errors");
        options4.add("true");
        options4.add("An object is a variable, where its type is the class used to declare the variable");
        options4.add("run-time error");
        options4.add("bah..blah..blahh");




        ArrayList<String> answer = new ArrayList<>();
        answer.add("interpreted");
        answer.add("Scanner class");
        answer.add("all operation systems.");
        answer.add("16 bits");
        answer.add("true");
        answer.add("no errors");
        answer.add("false");
        answer.add("class and object are just different names for the same thing.");
        answer.add("compilation error");
        answer.add("yes");

        txtvjq1=(TextView)findViewById(R.id.txtvjq1);
        rbjq1=(RadioButton)findViewById(R.id.rbjq1);
        rbjq2=(RadioButton)findViewById(R.id.rbjq2);
        rbjq3=(RadioButton)findViewById(R.id.rbjq3);
        rbjq4=(RadioButton)findViewById(R.id.rbjq4);
        imgbtnjq1=(ImageButton)findViewById(R.id.imgbtnjq1);
        btnjq1=(Button)findViewById(R.id.btnjq1);
        rgjq1=(RadioGroup)findViewById(R.id.rgjq1);

        sql5=openOrCreateDatabase("javaquiz",MODE_PRIVATE,null);
        sql5.execSQL("create table if not exists javaq(serial varchar,question varchar,option1 varchar,option2 varchar,option3 varchar,option4 varchar,answer varchar)");

        for (int i=0;i<q.size();i++){
            sql5.execSQL("insert into javaq values('"+i+"','"+q.get(i)+"','"+options1.get(i)+"','"+options2.get(i)+"','"+options3.get(i)+"','"+options4.get(i)+"','"+answer.get(i)+"')");
        }

        c=sql5.rawQuery("Select * from javaq where serial="+flag,null);
        c.moveToFirst();
        txtvjq1.setText(c.getString(c.getColumnIndex("question")));
        rbjq1.setText(c.getString(c.getColumnIndex("option1")));
        rbjq2.setText(c.getString(c.getColumnIndex("option2")));
        rbjq3.setText(c.getString(c.getColumnIndex("option3")));
        rbjq4.setText(c.getString(c.getColumnIndex("option4")));
        Ans=c.getString(c.getColumnIndex("answer"));

        imgbtnjq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rbjq1.isChecked()){
                    if (rbjq1.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                       // Snackbar.make(view, "\tCorrect Answer"+q.size(), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                       // Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }

                if (rbjq2.isChecked()){

                    if (rbjq2.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                        //Snackbar.make(view, "\tCorrect Answer", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                        //Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }

                if (rbjq3.isChecked()){

                    if (rbjq3.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                        //Snackbar.make(view, "\tCorrect Answer", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                        //Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }

                if (rbjq4.isChecked()){

                    if (rbjq4.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                        //Snackbar.make(view, "\tCorrect Answer", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                        //Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }


                if (flag < q.size()) {
                    rgjq1.clearCheck();
                    c = sql5.rawQuery("select * from javaq where serial=" + flag, null);
                    c.moveToFirst();
                    txtvjq1.setText(c.getString(c.getColumnIndex("question")));
                    rbjq1.setText(c.getString(c.getColumnIndex("option1")));
                    rbjq2.setText(c.getString(c.getColumnIndex("option2")));
                    rbjq3.setText(c.getString(c.getColumnIndex("option3")));
                    rbjq4.setText(c.getString(c.getColumnIndex("option4")));
                    Ans = c.getString(c.getColumnIndex("answer"));


                }
                if (flag==q.size()){
                    Intent intent=new Intent(javaquiz.this,result.class);
                    intent.putExtra("corrects",String.valueOf(score));
                    intent.putExtra("wrong",String.valueOf(wrongs));
                    startActivity(intent);
                }

            }
        });


        btnjq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(javaquiz.this,"score:"+score,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(javaquiz.this,result.class);
                intent.putExtra("corrects",String.valueOf(score));
                intent.putExtra("wrong",String.valueOf(wrongs));
                startActivity(intent);
            }
        });




    }
}
