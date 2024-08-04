package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class MainActivity4 extends AppCompatActivity {
    javaqs obj=new javaqs();
    TextView txtheading,textqs;
    RadioGroup radiogp;
    RadioButton radiobtn1,radiobtn2,radiobtn3,radiobtn4,radiotemp;
    Button btn;
    int question=1,questionLimit=50,marks=0,totalMarks=questionLimit,firstClick=1,index=0;
    String Question="Question";
    Random random=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    txtheading=findViewById(R.id.txtheading);
    textqs=findViewById(R.id.textqs);
    radiogp=findViewById(R.id.radiogp);
    radiobtn1=findViewById(R.id.radiobtn1);
    radiobtn2=findViewById(R.id.radiobtn2);
    radiobtn3=findViewById(R.id.radiobtn3);
    radiobtn4=findViewById(R.id.radiobtn4);
    btn=findViewById(R.id.btn1);

        txtheading.setText(Question+(question));
        textqs.setText(obj.questions[index]);
        radiobtn1.setText(obj.optiona[index]);
        radiobtn2.setText(obj.optionb[index]);
        radiobtn3.setText(obj.optionc[index]);
        radiobtn4.setText(obj.optiond[index]);
        radiogp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radiotemp = findViewById(checkedId);
                if (radiotemp.getText().toString().equals(obj.correctans[index])) {
                    if (firstClick == 1) {
                        marks++;
                    }
                }
                else{
                    radiotemp.setTextColor(getColor(R.color.red));
                }
                firstClick++;
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(question==questionLimit){
                    Intent i=new Intent(MainActivity4.this,resultactivity.class);
                    i.putExtra("marks",marks);
                    i.putExtra("totalMarks",totalMarks);
                    startActivity(i);
                    finish();

                }
                else{
                    if(questionLimit==question+1){
                        btn.setText("Result");
                    }
                    radiotemp.setChecked(false);
                    //radG.clearCheck();
                    question++;
                    index++;
                    txtheading.setText(Question+question);
                    textqs.setText(obj.questions[index]);
                    radiobtn1.setText(obj.optiona[index]);
                    radiobtn2.setText(obj.optionb[index]);
                    radiobtn3.setText(obj.optionc[index]);
                    radiobtn4.setText(obj.optiond[index]);

                    radiobtn1.setTextColor(getColor(R.color.black));
                    radiobtn2.setTextColor(getColor(R.color.black));
                    radiobtn3.setTextColor(getColor(R.color.black));
                    radiobtn4.setTextColor(getColor(R.color.black));



                    firstClick=1;

                }
            }
        });

    }

}