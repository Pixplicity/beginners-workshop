package com.pixplicity.workshop.beginners.intentions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity implements View.OnClickListener {

    public static final String EXTRA_EMAIL_MESSAGE = "email_message";

    private EditText mEmailMessage;

    private Button mSendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mEmailMessage = (EditText) findViewById(R.id.email_message);

        Intent intent = getIntent();
        if (intent != null) {
            mEmailMessage.setText(intent.getStringExtra(EXTRA_EMAIL_MESSAGE));
        }

        mSendButton = (Button) findViewById(R.id.send);
        mSendButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("message", mEmailMessage.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

}