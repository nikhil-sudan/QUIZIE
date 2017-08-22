package com.nikhil.quizbee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class result extends AppCompatActivity {
    TextView txtvres1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String corrans=getIntent().getExtras().getString("corrects");
        String wrngans=getIntent().getExtras().getString("wrong");
        Double cor= Double.valueOf(Integer.parseInt(corrans));
        Double wrn= (double) Integer.parseInt(wrngans);                 //correct way : no need of boxing
        //int total=cor+wrn;
        Double percentage=cor/(cor+wrn)*100;



        txtvres1=(TextView)findViewById(R.id.txtvres1);
        StringBuffer se=new StringBuffer();
        se.append("Correct Answers:\t\t").append(corrans).append("\n").append("wrong answers:\t\t").append(wrngans).append("\n\nPercentage:\t\t\t").append(String.format("%.2f", percentage)).append("%\n\n\nRemarks:\t\t");


        if (percentage<50.0){
            se.append("very poor performance");
        }
        if (percentage<70&&percentage>=50.0){
            se.append("good, but you need to work more!!!!");
        }
        if (percentage<90&&percentage>=70.0){
            se.append("very good, but you can do better");
        }
        if (percentage<=100&&percentage>=90.0){
            se.append("Excellent performance");
        }

        txtvres1.setText(se);

/*      FOOLISH-NESS LOL
        StringBuffer se= new StringBuffer();
        se.append("well done!   "+overview.name+"\n");
        se.append("correct Answer:"+javaquiz.score+"\n");
        se.append("wrong answers : "+javaquiz.wrongs);

        StringBuffer re= new StringBuffer();
        se.append("well done!   "+overview.name+"\n");
        se.append("correct Answer:"+igeoquiz.score+"\n");
        se.append("wrong answers : "+igeoquiz.wrongs);

        txtvres1.setText(re);
*/

    }
}
