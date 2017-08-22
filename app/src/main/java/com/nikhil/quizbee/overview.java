package com.nikhil.quizbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class overview extends AppCompatActivity {
    EditText et21;
    Button btn21;

     String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        et21=(EditText)findViewById(R.id.et21);

            btn21=(Button)findViewById(R.id.btn21);
            btn21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    name=et21.getText().toString();
                    if (name.equalsIgnoreCase("")){
                        Toast.makeText(getApplicationContext(),"You did not enter a username", Toast.LENGTH_SHORT).show();
                    }
                    //  return;

                    else {
                        Intent intent = new Intent(overview.this, Topics.class);
                        intent.putExtra("name1", et21.getText().toString());
                        intent.putExtra("fromActivity","overview");
                        startActivity(intent);
                    }
                }
            });




    }
}
