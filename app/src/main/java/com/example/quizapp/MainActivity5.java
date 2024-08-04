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

public class MainActivity5 extends AppCompatActivity {
    kotlinqs obj=new kotlinqs();
    TextView txtheading1,textqs1;
    RadioGroup radiogp1;
    RadioButton radiobtn10,radiobtn20,radiobtn30,radiobtn40,radiotemp1;
    Button btn10;
    int question=1,questionLimit=50,marks=0,totalMarks=questionLimit,firstClick=1,index=0;
    String Question="Question";
    Random random=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtheading1=findViewById(R.id.txtheading1);
        textqs1=findViewById(R.id.textqs1);
        radiogp1=findViewById(R.id.radiogp1);
        radiobtn10=findViewById(R.id.radiobtn10);
        radiobtn20=findViewById(R.id.radiobtn20);
        radiobtn30=findViewById(R.id.radiobtn30);
        radiobtn40=findViewById(R.id.radiobtn40);
        btn10=findViewById(R.id.btn10);

        txtheading1.setText(Question+(question));
        textqs1.setText(obj.questions1[index]);
        radiobtn10.setText(obj.optiona1[index]);
        radiobtn20.setText(obj.optionb1[index]);
        radiobtn30.setText(obj.optionc1[index]);
        radiobtn40.setText(obj.optiond1[index]);
        radiogp1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radiotemp1 = findViewById(checkedId);
                if (radiotemp1.getText().toString().equals(obj.correctans1[index])) {
                    if (firstClick == 1) {
                        marks++;
                    }
                }
                else{
                    radiotemp1.setTextColor(getColor(R.color.red));
                }
                firstClick++;
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(question==questionLimit){
                    Intent i=new Intent(MainActivity5.this,resultactivity.class);
                    i.putExtra("marks",marks);
                    i.putExtra("totalMarks",totalMarks);
                    startActivity(i);
                    finish();

                }
                else{
                    if(questionLimit==question+1){
                        btn10.setText("Result");
                    }
                    radiotemp1.setChecked(false);
                    //radG.clearCheck();
                    question++;
                    index++;
                    txtheading1.setText(Question+question);
                    textqs1.setText(obj.questions1[index]);
                    radiobtn10.setText(obj.optiona1[index]);
                    radiobtn20.setText(obj.optionb1[index]);
                    radiobtn30.setText(obj.optionc1[index]);
                    radiobtn40.setText(obj.optiond1[index]);

                    radiobtn10.setTextColor(getColor(R.color.black));
                    radiobtn20.setTextColor(getColor(R.color.black));
                    radiobtn30.setTextColor(getColor(R.color.black));
                    radiobtn40.setTextColor(getColor(R.color.black));



                    firstClick=1;

                }
            }
        });

    }

}