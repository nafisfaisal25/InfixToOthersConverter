package com.example.infixtoothersconverter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
    Evaluator mEvaluator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mConverter = new Converter();
        mEvaluator = new Evaluator();
        mConvertButton = findViewById( R.id.ConvertToPostfix);
        mEvaluateButton = findViewById(R.id.evaluate);
        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initialize();
            }
        });

        mEvaluateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluatePostFixValue();
            }
        });


    }

    private void initialize() {
        mInput = findViewById(R.id.input);
        String inputString  = mInput.getText().toString();
        convertToPostFix(inputString);
        showPostFixNotation();
        hideSoftKeyBoard();
    }

    private void hideSoftKeyBoard() {
        InputMethodManager imm = (InputMethodManager)this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
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

    private void evaluatePostFixValue() {
        double value = mEvaluator.evaluatePostFix((mConverter.getPostFixString()));
        mEvaluatedValueOutput.setText(Double.toString(value));
    }
}
