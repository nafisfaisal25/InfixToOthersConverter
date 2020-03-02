package com.example.infixtoothersconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mInput;
    TextView mConvertedPostfixOutput;
    TextView mEvaluatedValueOutput;
    Button mConvertButton;
    Button mEvaluateButton;
    Converter mConverter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mConverter = new Converter();
        mConvertButton = findViewById( R.id.ConvertToPostfix);
        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initialize();
            }
        });
    }

    private void initialize() {
        mInput = findViewById(R.id.input);
        String inputString  = mInput.getText().toString();
        convertToPostFix(inputString);
        showPostFixNotation();
    }

    private void showPostFixNotation() {
        String  postFixString= mConverter.getPostFixString();
        mConvertedPostfixOutput = findViewById(R.id.postfix_output);
        mConvertedPostfixOutput.setText(postFixString);
        mEvaluateButton = findViewById(R.id.evaluate);
        mEvaluatedValueOutput = findViewById(R.id.output_evaluated_postfix);
        mEvaluateButton.setVisibility(View.VISIBLE);
        mEvaluatedValueOutput.setVisibility(View.VISIBLE);
        TextView textView = findViewById(R.id.postfix_value_string);
        textView.setVisibility(View.VISIBLE);
    }

    private void convertToPostFix(String inputString) {
        mConverter.convertInfixToPostfix(inputString);
    }
}
