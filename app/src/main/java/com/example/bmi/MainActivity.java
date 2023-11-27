package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtWeight, edtHeightFt, edtHeightIn;
    TextView txtResult;
    AppCompatButton calBtn;

    RelativeLayout appBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        calBtn = findViewById(R.id.calBtn);
        txtResult = findViewById(R.id.txtResult);
        appBg = findViewById(R.id.bg);

        calBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = ft*12 +in;
                double totalCm = totalIn*2.53;
                double totalM = totalCm/100;

                double bmi = wt/Math.pow(totalM, 2);
                if (bmi >25){
                    txtResult.setText("Your over weight");
                    appBg.setBackgroundColor(getResources().getColor(R.color.ow));
                } else if (bmi < 18) {
                    txtResult.setText("Your  under weight");
                    appBg.setBackgroundColor(getResources().getColor(R.color.uw));
                }else{
                    txtResult.setText("Your healthy");
                    appBg.setBackgroundColor(getResources().getColor(R.color.h));

                }
            }
        });

    }
}