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

public class ihistquiz extends AppCompatActivity {
    SQLiteDatabase sql7;
    RadioButton rbhistq1,rbhistq2,rbhistq3,rbhistq4;
    RadioGroup rghistq1;
    ImageButton imgbtnhistq1;
    Button btnhistq1;
    TextView txtvhistq1;
    Cursor c;
    int flag=0;
    String Ans="";
    public static int score;
    public static int wrongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ihistquiz);

        final ArrayList<String> q = new ArrayList<>();
        q.add("Vaikhanasa the five-fold conception of Vishnu consists of brahman\n"  + "purusha\n" + "prakriti\n" + "satya\n" + "achyuta\n" + "aniruddha\n");
        q.add("Though Ashoka had many sons, the inscriptions mentioned only one who is not mentioned in any other source. He is");
        q.add("We can know about early vedic period from");
        q.add("The Upanishads are");
        q.add("To which king belongs the Lion capital at Sarnath?");
        q.add("Two of the great Mughals wrote their own memories. There were");
        q.add("Vikramaditya, a king of Ujjain, started the Vikrama samvat in 58 BC in commemoration of his victory over");
        q.add("To which of the following dynasties did King Bhoja, a great patron of literature and art, belong?");
        q.add("The title of Viceroy was added to the office of the Governor-General of India for the first time in");
        q.add("The two principles monuments of Alaud-din Khiljis reign - the Jama at Kana Masjid and Alai Darwaza - were constructed at");



        ArrayList<String> options1 = new ArrayList<>();
        options1.add("I, II, III, IV and V");
        options1.add("Kunala");
        options1.add("archaeological excavations");
        options1.add("a source of Hindu philosophy");
        options1.add("Chandragupta");
        options1.add("Babar and Humayun");
        options1.add("Indo-Greeks");
        options1.add("Karkota");
        options1.add("1848 AD");
        options1.add("Agra");


        ArrayList<String> options2 = new ArrayList<>();
        options2.add("II, III, IV, V and VI");
        options2.add("Tivara");
        options2.add("the Rig Veda");
        options2.add("books of ancient Hindu laws");
        options2.add("Ashoka");
        options2.add("Humayun and Jahangir");
        options2.add("Sakas");
        options2.add("Utpala");
        options2.add("1856 AD");
        options2.add("Delhi");


        ArrayList<String> options3 = new ArrayList<>();
        options3.add("I, II, IV, V and VI");
        options3.add("Mahendra");
        options3.add("Jatak Katha");
        options3.add("books on social behavior of man");
        options3.add("Kanishka");
        options3.add("Babar and Jahangir");
        options3.add("Parthinas");
        options3.add("Paramara");
        options3.add("1858 AD");
        options3.add("Dhar");


        ArrayList<String> options4 = new ArrayList<>();
        options4.add("I, III, IV, V and VI");
        options4.add("Jalauka");
        options4.add("contemporary culture");
        options4.add("prayers to God");
        options4.add("Harsha");
        options4.add("Jahangir and Shahjahan");
        options4.add("Kushanas");
        options4.add("Gurjara Pratihara");
        options4.add("1862 AD");
        options4.add("Gulbarga");



        ArrayList<String> answer = new ArrayList<>();
        answer.add("I, III, IV, V and VI");
        answer.add("Tivara");
        answer.add("the Rig Veda");
        answer.add("a source of Hindu philosophy");
        answer.add("Ashoka");
        answer.add("Babar and Jahangir");
        answer.add("Sakas");
        answer.add("Paramara");
        answer.add("1858 AD");
        answer.add("Delhi");



        txtvhistq1=(TextView)findViewById(R.id.txtvhistq1);
        rbhistq1=(RadioButton)findViewById(R.id.rbhistq1);
        rbhistq2=(RadioButton)findViewById(R.id.rbhistq2);
        rbhistq3=(RadioButton)findViewById(R.id.rbhistq3);
        rbhistq4=(RadioButton)findViewById(R.id.rbhistq4);
        imgbtnhistq1=(ImageButton)findViewById(R.id.imgbtnhistq1);
        btnhistq1=(Button)findViewById(R.id.btnhistq1);
        rghistq1=(RadioGroup)findViewById(R.id.rghistq1);

        sql7=openOrCreateDatabase("dbhistq",MODE_PRIVATE,null);
        sql7.execSQL("create table if not exists histquiz1(serial varchar,question varchar,option1 varchar,option2 varchar,option3 varchar,option4 varchar,answer varchar)");

        for (int i=0;i<q.size();i++){
            sql7.execSQL("insert into histquiz1 values('"+i+"','"+q.get(i)+"','"+options1.get(i)+"','"+options2.get(i)+"','"+options3.get(i)+"','"+options4.get(i)+"','"+answer.get(i)+"')");
        }

        c=sql7.rawQuery("Select * from histquiz1 where serial="+flag,null);
        c.moveToFirst();
        txtvhistq1.setText(c.getString(c.getColumnIndex("question")));
        rbhistq1.setText(c.getString(c.getColumnIndex("option1")));
        rbhistq2.setText(c.getString(c.getColumnIndex("option2")));
        rbhistq3.setText(c.getString(c.getColumnIndex("option3")));
        rbhistq4.setText(c.getString(c.getColumnIndex("option4")));
        Ans=c.getString(c.getColumnIndex("answer"));

        imgbtnhistq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rbhistq1.isChecked()){
                    if (rbhistq1.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                        // Snackbar.make(view, "\tCorrect Answer"+q.size(), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                        // Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }

                if (rbhistq2.isChecked()){

                    if (rbhistq2.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                        //Snackbar.make(view, "\tCorrect Answer", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                        //Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }

                if (rbhistq3.isChecked()){

                    if (rbhistq3.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                        //Snackbar.make(view, "\tCorrect Answer", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                        //Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }

                if (rbhistq4.isChecked()){

                    if (rbhistq4.getText().toString().equalsIgnoreCase(Ans)){
                        score++;flag++;
                        //Snackbar.make(view, "\tCorrect Answer", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                    else{
                        wrongs++;flag++;
                        //Snackbar.make(view, "\tWrong Choice", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }


                if (flag < q.size()) {
                    rghistq1.clearCheck();
                    c = sql7.rawQuery("select * from histquiz1 where serial=" + flag, null);
                    c.moveToFirst();
                    txtvhistq1.setText(c.getString(c.getColumnIndex("question")));
                    rbhistq1.setText(c.getString(c.getColumnIndex("option1")));
                    rbhistq2.setText(c.getString(c.getColumnIndex("option2")));
                    rbhistq3.setText(c.getString(c.getColumnIndex("option3")));
                    rbhistq4.setText(c.getString(c.getColumnIndex("option4")));
                    Ans = c.getString(c.getColumnIndex("answer"));


                }
                if (flag==q.size()){
                    Intent intent=new Intent(ihistquiz.this,result.class);
                    intent.putExtra("corrects",String.valueOf(score));
                    intent.putExtra("wrong",String.valueOf(wrongs));
                    startActivity(intent);
                }

            }
        });


        btnhistq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(javaquiz.this,"score:"+score,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(ihistquiz.this,result.class);
                intent.putExtra("corrects",String.valueOf(score));
                intent.putExtra("wrong",String.valueOf(wrongs));
                startActivity(intent);
            }
        });
        
    }
}
