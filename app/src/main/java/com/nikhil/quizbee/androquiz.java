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

public class androquiz extends AppCompatActivity {
    SQLiteDatabase sql7;
    RadioButton rbandroq1,rbandroq2,rbandroq3,rbandroq4;
    RadioGroup rgandroq1;
    ImageButton imgbtnandroq1;
    Button btnandroq1;
    TextView txtvandroq1;
    Cursor c;
    int flag=0;
    String Ans="";
    public static int score;
    public static int wrongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androquiz);

        final ArrayList<String> q = new ArrayList<>();
        q.add("Is it possible to have an activity without UI to perform action/actions?");
        q.add("What is Manifest.xml in android?");
        q.add("On which thread broadcast receivers will work in android?");
        q.add("What is the difference between content values and cursor in android SQlite?");
        q.add("What is singleton class in android?");
        q.add("What is APK in android?");
        q.add("What is JSON in android?");
        q.add("What is the JSON exception in android?");
        q.add("What are return types of startActivityForResult() in android?");
        q.add("Can a class be immutable in android?");



        ArrayList<String> options1 = new ArrayList<>();
        options1.add("Not possible");
        options1.add("It has information about layout in an application");
        options1.add("Worker Thread");
        options1.add("Content values are key pair values, which are updated or inserted in the database\n");
        options1.add("A class that can create only one object");
        options1.add("Android packages");
        options1.add("Java Script Object Native");
        options1.add("JSon Exception");
        options1.add("RESULT_OK");
        options1.add("No, it can not");


        ArrayList<String> options2 = new ArrayList<>();
        options2.add("Wrong question");
        options2.add("It has the information about activities in an application");
        options2.add("Main Thread");
        options2.add("Cursor is used to store the temporary result");
        options2.add("Anonymous class");
        options2.add("Android pack");
        options2.add("Java Script Oriented Notation");
        options2.add("Json Not found exception");
        options2.add("RESULT_CANCEL");
        options2.add("Yes, Class can be immutable");


        ArrayList<String> options3 = new ArrayList<>();
        options3.add("Yes, it is possible");
        options3.add("It has all the information about an application");
        options3.add("Activity Thread");
        options3.add("A & B");
        options3.add("Java class");
        options3.add("Android packaging kit");
        options3.add("Java Script Object Notation");
        options3.add("Input not found exception");
        options3.add("RESULT_CRASH");
        options3.add("Can not make the class as final class");


        ArrayList<String> options4 = new ArrayList<>();
        options4.add("None of the above");
        options4.add("None of the above");
        options4.add("None of the above");
        options4.add("Cursor is used to store data permanently");
        options4.add("Manifest file");
        options4.add("None of the above.");
        options4.add("None of the above");
        options4.add("None of the above");
        options4.add("A & B");
        options4.add("None of the above");


        ArrayList<String> answer = new ArrayList<>();
        answer.add("Yes, it is possible");
        answer.add("It has all the information about an application\n");
        answer.add("Main Thread");
        answer.add("A & B");
        answer.add("A class that can create only one object");
        answer.add("Android packaging kit");
        answer.add("Java Script Object Notation");
        answer.add("JSon Exception");
        answer.add("A & B");
        answer.add("Yes, Class can be immutable");


        txtvandroq1=(TextView)findViewById(R.id.txtvandroq1);
        rbandroq1=(RadioButton)findViewById(R.id.rbandroq1);
        rbandroq2=(RadioButton)findViewById(R.id.rbandroq2);
        rbandroq3=(RadioButton)findViewById(R.id.rbandroq3);
        rbandroq4=(RadioButton)findViewById(R.id.rbandroq4);
        imgbtnandroq1=(ImageButton)findViewById(R.id.imgbtnandroq1);
        btnandroq1=(Button)findViewById(R.id.btnandroq1);
        rgandroq1=(RadioGroup)findViewById(R.id.rgandroq1);

        sql7=openOrCreateDatabase("dbandroq",MODE_PRIVATE,null);
        sql7.execSQL("create table if not exists androquiz1(serial varchar,question varchar,option1 varchar,option2 varchar,option3 varchar,option4 varchar,answer varchar)");

        for (int i=0;i<q.size();i++){
            sql7.execSQL("insert into androquiz1 values('"+i+"','"+q.get(i)+"','"+options1.get(i)+"','"+options2.get(i)+"','"+options3.get(i)+"','"+options4.get(i)+"','"+answer.get(i)+"')");
        }

        c=sql7.rawQuery("Select * from androquiz1 where serial="+flag,null);
        c.moveToFirst();
        txtvandroq1.setText(c.getString(c.getColumnIndex("question")));
        rbandroq1.setText(c.getString(c.getColumnIndex("option1")));
        rbandroq2.setText(c.getString(c.getColumnIndex("option2")));
        rbandroq3.setText(c.getString(c.getColumnIndex("option3")));
        rbandroq4.setText(c.getString(c.getColumnIndex("option4")));
        Ans=c.getString(c.getColumnIndex("answer"));

        imgbtnandroq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rbandroq1.isChecked()){
                    if (rbandroq1.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                        // Snackbar.make(view, "\tCorrect Answer"+q.size(), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                        // Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }

                if (rbandroq2.isChecked()){

                    if (rbandroq2.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                        //Snackbar.make(view, "\tCorrect Answer", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                        //Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }

                if (rbandroq3.isChecked()){

                    if (rbandroq3.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                        //Snackbar.make(view, "\tCorrect Answer", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                        //Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }

                if (rbandroq4.isChecked()){

                    if (rbandroq4.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                        //Snackbar.make(view, "\tCorrect Answer", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                        //Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }


                if (flag < q.size()) {
                    rgandroq1.clearCheck();
                    c = sql7.rawQuery("select * from androquiz1 where serial=" + flag, null);
                    c.moveToFirst();
                    txtvandroq1.setText(c.getString(c.getColumnIndex("question")));
                    rbandroq1.setText(c.getString(c.getColumnIndex("option1")));
                    rbandroq2.setText(c.getString(c.getColumnIndex("option2")));
                    rbandroq3.setText(c.getString(c.getColumnIndex("option3")));
                    rbandroq4.setText(c.getString(c.getColumnIndex("option4")));
                    Ans = c.getString(c.getColumnIndex("answer"));


                }
                if (flag==q.size()){
                    Intent intent=new Intent(androquiz.this,result.class);
                    intent.putExtra("corrects",String.valueOf(score));
                    intent.putExtra("wrong",String.valueOf(wrongs));
                    startActivity(intent);
                }

            }
        });


        btnandroq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(javaquiz.this,"score:"+score,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(androquiz.this,result.class);
                intent.putExtra("corrects",String.valueOf(score));
                intent.putExtra("wrong",String.valueOf(wrongs));
                startActivity(intent);
            }
        });
        
        
    }
}
