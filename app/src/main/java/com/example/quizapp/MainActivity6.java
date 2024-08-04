package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class MainActivity6 extends AppCompatActivity {
    Androidqs obj=new Androidqs();
    TextView txtheading10,textqs10;
    RadioGroup radiogp10;
    RadioButton radiobtn100,radiobtn200,radiobtn300,radiobtn400,radiotemp10;
    Button btn100;
    int question=1,questionLimit=50,marks=0,totalMarks=questionLimit,firstClick=1,index=0;
    String Question="Question";
    Random random=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtheading10=findViewById(R.id.txtheading10);
        textqs10=findViewById(R.id.textqs10);
        radiogp10=findViewById(R.id.radiogp10);
        radiobtn100=findViewById(R.id.radiobtn100);
        radiobtn200=findViewById(R.id.radiobtn200);
        radiobtn300=findViewById(R.id.radiobtn300);
        radiobtn400=findViewById(R.id.radiobtn400);
        btn100=findViewById(R.id.btn100);

        txtheading10.setText(Question+(question));
        textqs10.setText(obj.questions2[index]);
        radiobtn100.setText(obj.optiona2[index]);
        radiobtn200.setText(obj.optionb2[index]);
        radiobtn300.setText(obj.optionc2[index]);
        radiobtn400.setText(obj.optiond2[index]);
        radiogp10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radiotemp10 = findViewById(checkedId);

                if (radiotemp10.getText().toString().equals(obj.correctans2[index])) {
                    if (firstClick == 1) {
                        marks++;
                    }
                } else {
                    radiotemp10.setTextColor(getColor(R.color.red));
                }
                firstClick++;
            }
        });
        btn100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(question==questionLimit){
                    Intent i=new Intent(MainActivity6.this,resultactivity.class);
                    i.putExtra("marks",marks);
                    i.putExtra("totalMarks",totalMarks);
                    startActivity(i);
                    finish();

                }
                else{
                    if(questionLimit==question+1){
                        btn100.setText("Result");
                    }
                    radiotemp10.setChecked(false);
                    question++;
                    index++;
                    txtheading10.setText(Question+question);
                    textqs10.setText(obj.questions2[index]);
                    radiobtn100.setText(obj.optiona2[index]);
                    radiobtn200.setText(obj.optionb2[index]);
                    radiobtn300.setText(obj.optionc2[index]);
                    radiobtn400.setText(obj.optiond2[index]);

                    radiobtn100.setTextColor(getColor(R.color.black));
                    radiobtn200.setTextColor(getColor(R.color.black));
                    radiobtn300.setTextColor(getColor(R.color.black));
                    radiobtn400.setTextColor(getColor(R.color.black));



                    firstClick=1;

                }
            }
        });

    }

}