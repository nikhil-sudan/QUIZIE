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

public class gkquiz extends AppCompatActivity {
    SQLiteDatabase sql7;
    RadioButton rbgkq1,rbgkq2,rbgkq3,rbgkq4;
    RadioGroup rggkq1;
    ImageButton imgbtngkq1;
    Button btngkq1;
    TextView txtvgkq1;
    Cursor c;
    int flag=0;
    String Ans="";
    public static int score;
    public static int wrongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gkquiz);

        final ArrayList<String> q = new ArrayList<>();
        q.add("First human heart transplant operation conducted by Dr. Christiaan Barnard on Louis Washkansky, was conducted in");
        q.add("Exposure to sunlight helps a person improve his health because");
        q.add("When is the Worlds Diabetes Day?");
        q.add("When light passes from air into glass it experiences change of");
        q.add("When is the International Workers Day?");
        q.add("When a moving bus stops suddenly, the passenger are pushed forward because of the");
        q.add("When and where was hockey introduced for women in Olympics?");
        q.add("When did Afghanistan ends monarchy and became a republic?");
        q.add("When and where was tennis introduced in the Asian Games?");
        q.add("Zakir Hussain was");



        ArrayList<String> options1 = new ArrayList<>();
        options1.add("1967");
        options1.add("the infrared light kills bacteria in the body");
        options1.add("14th November");
        options1.add("frequency and wavelength");
        options1.add("15th April");
        options1.add("friction between the earth and the bus");
        options1.add("1908 at London");
        options1.add("1949");
        options1.add("In 1958 at Tokyo");
        options1.add("the third President of India");


        ArrayList<String> options2 = new ArrayList<>();
        options2.add("1968");
        options2.add("resistance power increases");
        options2.add("11th December");
        options2.add("frequency and speed");
        options2.add("12th December");
        options2.add("friction between the passengers and the earth");
        options2.add("1980 at Moscow");
        options2.add("1973");
        options2.add("In 1962 at Jakarta");
        options2.add("Indias second vice President");

        ArrayList<String> options3 = new ArrayList<>();
        options3.add("1958");
        options3.add("the pigment cells in the skin get stimulated and produce a healthy tan");
        options3.add("15th October");
        options3.add("wavelength and speed");
        options3.add("1st May");
        options3.add("inertia of the passengers");
        options3.add("1936 at Berlin");
        options3.add("1965");
        options3.add("In 1966 at Bangkok");
        options3.add("both (a) and (b)");


        ArrayList<String> options4 = new ArrayList<>();
        options4.add("1922");
        options4.add("the ultraviolet rays convert skin oil into Vitamin D");
        options4.add("1st July");
        options4.add("frequency, wavelength and speed");
        options4.add("1st August");
        options4.add("inertia of the bus");
        options4.add("1924 at Paris");
        options4.add("2000");
        options4.add("In 1974 at Teheran");
        options4.add("None of the above");





        ArrayList<String> answer = new ArrayList<>();
        answer.add("1967");
        answer.add("the ultraviolet rays convert skin oil into Vitamin D");
        answer.add("14th November");
        answer.add("wavelength and speed");
        answer.add("1st May");
        answer.add("inertia of the passengers");
        answer.add("1980 at Moscow");
        answer.add("1973");
        answer.add("In 1958 at Tokyo");
        answer.add("both (a) and (b)");

        txtvgkq1=(TextView)findViewById(R.id.txtvgkq1);
        rbgkq1=(RadioButton)findViewById(R.id.rbgkq1);
        rbgkq2=(RadioButton)findViewById(R.id.rbgkq2);
        rbgkq3=(RadioButton)findViewById(R.id.rbgkq3);
        rbgkq4=(RadioButton)findViewById(R.id.rbgkq4);
        imgbtngkq1=(ImageButton)findViewById(R.id.imgbtngkq1);
        btngkq1=(Button)findViewById(R.id.btngkq1);
        rggkq1=(RadioGroup)findViewById(R.id.rggkq1);

        sql7=openOrCreateDatabase("dbgkq",MODE_PRIVATE,null);
        sql7.execSQL("create table if not exists gkquiz1(serial varchar,question varchar,option1 varchar,option2 varchar,option3 varchar,option4 varchar,answer varchar)");

        for (int i=0;i<q.size();i++){
            sql7.execSQL("insert into gkquiz1 values('"+i+"','"+q.get(i)+"','"+options1.get(i)+"','"+options2.get(i)+"','"+options3.get(i)+"','"+options4.get(i)+"','"+answer.get(i)+"')");
        }

        c=sql7.rawQuery("Select * from gkquiz1 where serial="+flag,null);
        c.moveToFirst();
        txtvgkq1.setText(c.getString(c.getColumnIndex("question")));
        rbgkq1.setText(c.getString(c.getColumnIndex("option1")));
        rbgkq2.setText(c.getString(c.getColumnIndex("option2")));
        rbgkq3.setText(c.getString(c.getColumnIndex("option3")));
        rbgkq4.setText(c.getString(c.getColumnIndex("option4")));
        Ans=c.getString(c.getColumnIndex("answer"));

        imgbtngkq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rbgkq1.isChecked()){
                    if (rbgkq1.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                        // Snackbar.make(view, "\tCorrect Answer"+q.size(), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                        // Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }

                if (rbgkq2.isChecked()){

                    if (rbgkq2.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                        //Snackbar.make(view, "\tCorrect Answer", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                        //Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }

                if (rbgkq3.isChecked()){

                    if (rbgkq3.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                        //Snackbar.make(view, "\tCorrect Answer", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                        //Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }

                if (rbgkq4.isChecked()){

                    if (rbgkq4.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                        //Snackbar.make(view, "\tCorrect Answer", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                        //Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }


                if (flag < q.size()) {
                    rggkq1.clearCheck();
                    c = sql7.rawQuery("select * from gkquiz1 where serial=" + flag, null);
                    c.moveToFirst();
                    txtvgkq1.setText(c.getString(c.getColumnIndex("question")));
                    rbgkq1.setText(c.getString(c.getColumnIndex("option1")));
                    rbgkq2.setText(c.getString(c.getColumnIndex("option2")));
                    rbgkq3.setText(c.getString(c.getColumnIndex("option3")));
                    rbgkq4.setText(c.getString(c.getColumnIndex("option4")));
                    Ans = c.getString(c.getColumnIndex("answer"));


                }
                if (flag==q.size()){
                    Intent intent=new Intent(gkquiz.this,result.class);
                    intent.putExtra("corrects",String.valueOf(score));
                    intent.putExtra("wrong",String.valueOf(wrongs));
                    startActivity(intent);
                }

            }
        });


        btngkq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(javaquiz.this,"score:"+score,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(gkquiz.this,result.class);
                intent.putExtra("corrects",String.valueOf(score));
                intent.putExtra("wrong",String.valueOf(wrongs));
                startActivity(intent);
            }
        });
    }
}
