package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView result ;
        EditText editweight ,editheightft , editheightin;
        Button buttoncalulate;
        LinearLayout Llmain;

        editweight =    findViewById(R.id.editweight);
        editheightft = findViewById(R.id.editheightft);
        editheightin = findViewById(R.id.editheightin);
        buttoncalulate =findViewById(R.id.buttoncalulate);
        result =findViewById(R.id.result);
        Llmain = findViewById(R.id.Llmain);

        buttoncalulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(editweight.getText().toString());
                int ft = Integer.parseInt(editheightft.getText().toString());
                int in = Integer.parseInt(editheightin.getText().toString());

                int Totalin = ft*12 + in;
                double Totalcm = Totalin*2.53;
                double TotalM = Totalcm/100 ;
                double bmi =wt/(TotalM*TotalM);

                if(bmi>25) {
                    result.setText("You Are Overweight !");
                    Llmain.setBackgroundColor(getResources().getColor(R.color.ColorOV));
                } else if (bmi<18){
                    result.setText("You Are Under Weight !");
                    Llmain.setBackgroundColor(getResources().getColor(R.color.ColorUW));
                } else {
                    result.setText("You Are Healthy !");
                    Llmain.setBackgroundColor(getResources().getColor(R.color.ColorHl));
                }


            }
        });



    }
}