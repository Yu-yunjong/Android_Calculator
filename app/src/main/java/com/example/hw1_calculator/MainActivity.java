package com.example.hw1_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 더하기 버튼
        Button addBtn = findViewById(R.id.buttonAdd);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc("+");
            }
        });

        // 빼기 버튼
        Button subBtn = findViewById(R.id.buttonSub);
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc("-");
            }
        });

        // 곱하기 버튼
        Button muxBtn = findViewById(R.id.buttonMux);
        muxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc("*");
            }
        });

        // 나누기 버튼
        Button divBtn = findViewById(R.id.buttonDiv);
        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc("/");
            }
        });

    }

    // 계산 로직
    void calc(String operator) {
        // EditText(값1, 값2)
        EditText value1 = findViewById(R.id.editTextValue1);
        EditText value2 = findViewById(R.id.editTextValue2);

        // TextView
        TextView resultText = findViewById(R.id.resultTextView);


        try {
            // 값1과 값2가 비어있는지 확인(둘 다 비어있을 때 토스트메시지 출력)
            if(value1.getText().toString().equals("") || value2.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "입력란이 비어있습니다.", Toast.LENGTH_SHORT).show();
                resultText.setText("err!!");
            }

            else {
                double a = Double.parseDouble(value1.getText().toString());
                double b = Double.parseDouble(value2.getText().toString());

                switch (operator) {
                    case "+":
                        resultText.setText(String.valueOf(a + b));
                        break;
                    case "-":
                        resultText.setText(String.valueOf(a - b));
                        break;
                    case "*":
                        resultText.setText(String.valueOf(a * b));
                        break;
                    case "/":
                        if(b == 0.0) {
                            Toast.makeText(getApplicationContext(), "err: 0으로 나눌 수 없습니다!", Toast.LENGTH_SHORT).show();
                            resultText.setText("err!!");
                        } else {
                            resultText.setText(String.valueOf(a / b));
                        }
                        break;

                }
            }
            // 예외 처리
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "숫자만 입력 가능합니다! (정수 or 실수)", Toast.LENGTH_SHORT).show();
            resultText.setText("err!!");
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "알수없는 오류가 발생했습니다!", Toast.LENGTH_SHORT).show();
            resultText.setText("err!!");
        }
    }
}