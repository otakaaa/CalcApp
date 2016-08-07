package jp.techacademy.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class Calc extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText;
    EditText nEditText;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    TextView mTextView;
    TextView nTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        this.mEditText = (EditText) findViewById(R.id.editText);
        this.nEditText = (EditText) findViewById(R.id.editText1);

        this.mTextView = (TextView) findViewById(R.id.textView);
        this.nTextView = (TextView) findViewById(R.id.textView1);

        this.button1 = (Button) findViewById(R.id.button1);
        this.button1.setOnClickListener(this);

        this.button2 = (Button) findViewById(R.id.button2);
        this.button2.setOnClickListener(this);

        this.button3 = (Button) findViewById(R.id.button3);
        this.button3.setOnClickListener(this);

        this.button4 = (Button) findViewById(R.id.button4);
        this.button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String num1 = mEditText.getText().toString().trim();
        String num2 = nEditText.getText().toString().trim();
        String message = "数値を入力してください";

        if (TextUtils.isEmpty(num1) || TextUtils.isEmpty(num2)){
            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, SecondActivity.class);

            this.mTextView.setText(this.mEditText.getText().toString());
            this.nTextView.setText(this.nEditText.getText().toString());

            double mt = Double.parseDouble(this.mTextView.getText().toString());
            double nt = Double.parseDouble(this.nTextView.getText().toString());

            if (v == this.button1) {
                Log.d("debug", String.valueOf(mt + nt));
                intent.putExtra("VALUE", mt + nt);

            } else if (v == this.button2) {
                Log.d("debug", String.valueOf(mt - nt));
                intent.putExtra("VALUE", mt - nt);

            } else if (v == this.button3) {
                Log.d("debug", String.valueOf(mt * nt));
                intent.putExtra("VALUE", mt * nt);

            } else if (v == this.button4) {
                Log.d("debug", String.valueOf(mt / nt));
                intent.putExtra("VALUE", mt / nt);

            }
            startActivity(intent);

        }
    }
