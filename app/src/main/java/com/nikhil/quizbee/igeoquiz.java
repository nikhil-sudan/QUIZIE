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

public class igeoquiz extends AppCompatActivity {
    SQLiteDatabase sql7;
    RadioButton rbgeoq1,rbgeoq2,rbgeoq3,rbgeoq4;
    RadioGroup rggeoq1;
    ImageButton imgbtngeoq1;
    Button btngeoq1;
    TextView txtvgeoq1;
    Cursor c;
    int flag=0;
    String Ans="";
    public static int score;
    public static int wrongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igeoquiz);

        final ArrayList<String> q = new ArrayList<>();
        q.add("Grand Central Terminal, Park Avenue, New York is the worlds");
        q.add("Garampani sanctuary is located at");
        q.add("");
        q.add("");
        q.add("");
        q.add("");
        q.add("");
        q.add("");
        q.add("");
        q.add("");
        


        ArrayList<String> options1 = new ArrayList<>();
        options1.add("largest railway station");
        options1.add("Junagarh, Gujarat");
        options1.add("");
        options1.add("");
        options1.add("");
        options1.add("");
        options1.add("");
        options1.add("");
        options1.add("");
        options1.add("");
        

        ArrayList<String> options2 = new ArrayList<>();
        options2.add("highest railway station");
        options2.add("Diphu, Assam");
        options2.add("");
        options2.add("");
        options2.add("");
        options2.add("");
        options2.add("");
        options2.add("");
        options2.add("");
        options2.add("");

        ArrayList<String> options3 = new ArrayList<>();
        options3.add("longest railway station");
        options3.add("Kohima, Nagaland");
        options3.add("");
        options3.add("");
        options3.add("");
        options3.add("");
        options3.add("");
        options3.add("");
        options3.add("");
        options3.add("");
        
        
        ArrayList<String> options4 = new ArrayList<>();
        options4.add("None of the above");
        options4.add("Gangtok, Sikkim");
        options4.add("");
        options4.add("");
        options4.add("");
        options4.add("");
        options4.add("");
        options4.add("");
        options4.add("");
        options4.add("");
        




        ArrayList<String> answer = new ArrayList<>();
        answer.add("largest railway station");
        answer.add("Diphu, Assam");
        answer.add("");
        answer.add("");
        answer.add("");
        answer.add("");
        answer.add("");
        answer.add("");
        answer.add("");
        answer.add("");
        
        

        txtvgeoq1=(TextView)findViewById(R.id.txtvgeoq1);
        rbgeoq1=(RadioButton)findViewById(R.id.rbgeoq1);
        rbgeoq2=(RadioButton)findViewById(R.id.rbgeoq2);
        rbgeoq3=(RadioButton)findViewById(R.id.rbgeoq3);
        rbgeoq4=(RadioButton)findViewById(R.id.rbgeoq4);
        imgbtngeoq1=(ImageButton)findViewById(R.id.imgbtngeoq1);
        btngeoq1=(Button)findViewById(R.id.btngeoq1);
        rggeoq1=(RadioGroup)findViewById(R.id.rggeoq1);

        sql7=openOrCreateDatabase("dbgeoq",MODE_PRIVATE,null);
        sql7.execSQL("create table if not exists geoquiz1(serial varchar,question varchar,option1 varchar,option2 varchar,option3 varchar,option4 varchar,answer varchar)");

        for (int i=0;i<q.size();i++){
            sql7.execSQL("insert into geoquiz1 values('"+i+"','"+q.get(i)+"','"+options1.get(i)+"','"+options2.get(i)+"','"+options3.get(i)+"','"+options4.get(i)+"','"+answer.get(i)+"')");
        }

        c=sql7.rawQuery("Select * from geoquiz1 where serial="+flag,null);
        c.moveToFirst();
        txtvgeoq1.setText(c.getString(c.getColumnIndex("question")));
        rbgeoq1.setText(c.getString(c.getColumnIndex("option1")));
        rbgeoq2.setText(c.getString(c.getColumnIndex("option2")));
        rbgeoq3.setText(c.getString(c.getColumnIndex("option3")));
        rbgeoq4.setText(c.getString(c.getColumnIndex("option4")));
        Ans=c.getString(c.getColumnIndex("answer"));

        imgbtngeoq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rbgeoq1.isChecked()){
                    if (rbgeoq1.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                        // Snackbar.make(view, "\tCorrect Answer"+q.size(), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                        // Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }

                if (rbgeoq2.isChecked()){

                    if (rbgeoq2.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                        //Snackbar.make(view, "\tCorrect Answer", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                        //Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }

                if (rbgeoq3.isChecked()){

                    if (rbgeoq3.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                        //Snackbar.make(view, "\tCorrect Answer", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                        //Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }

                if (rbgeoq4.isChecked()){

                    if (rbgeoq4.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                        //Snackbar.make(view, "\tCorrect Answer", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                        //Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }


                if (flag < q.size()) {
                    rggeoq1.clearCheck();
                    c = sql7.rawQuery("select * from geoquiz1 where serial=" + flag, null);
                    c.moveToFirst();
                    txtvgeoq1.setText(c.getString(c.getColumnIndex("question")));
                    rbgeoq1.setText(c.getString(c.getColumnIndex("option1")));
                    rbgeoq2.setText(c.getString(c.getColumnIndex("option2")));
                    rbgeoq3.setText(c.getString(c.getColumnIndex("option3")));
                    rbgeoq4.setText(c.getString(c.getColumnIndex("option4")));
                    Ans = c.getString(c.getColumnIndex("answer"));


                }
                if (flag==q.size()){
                    Intent intent=new Intent(igeoquiz.this,result.class);
                    intent.putExtra("corrects",String.valueOf(score));
                    intent.putExtra("wrong",String.valueOf(wrongs));
                    startActivity(intent);
                }

            }
        });


        btngeoq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(javaquiz.this,"score:"+score,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(igeoquiz.this,result.class);
                intent.putExtra("corrects",String.valueOf(score));
                intent.putExtra("wrong",String.valueOf(wrongs));
                startActivity(intent);
            }
        });
    }
}
