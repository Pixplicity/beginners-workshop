package com.pixplicity.workshop.beginners.intentions;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity implements View.OnClickListener {

    public static final String EXTRA_EMAIL_ADDRESS = "email_address";

    public static final String EXTRA_EMAIL_SUBJECT = "email_subject";

    private String mEmailAddress;
    private String mEmailSubject;

    private EditText mEmailMessage;

    private Button mSendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (savedInstanceState != null) {
            mEmailAddress = savedInstanceState.getString(EXTRA_EMAIL_ADDRESS);
            mEmailSubject = savedInstanceState.getString(EXTRA_EMAIL_SUBJECT);
        } else {
            mEmailAddress = getIntent().getStringExtra(EXTRA_EMAIL_ADDRESS);
            mEmailSubject = getIntent().getStringExtra(EXTRA_EMAIL_SUBJECT);
        }

        if (TextUtils.isEmpty(mEmailAddress) || TextUtils.isEmpty(mEmailSubject)) {
            throw new RuntimeException("The e-mail address and e-mail subject must both be passed as String extras to the Intent");
        }

        mEmailMessage = (EditText) findViewById(R.id.email_message);

        mSendButton = (Button) findViewById(R.id.send);
        mSendButton.setOnClickListener(this);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(EXTRA_EMAIL_ADDRESS, mEmailAddress);
        outState.putString(EXTRA_EMAIL_SUBJECT, mEmailSubject);
    }

    @Override
    public void onClick(View v) {
        // Exercise 3.2

        String emailMessage = mEmailMessage.getText().toString();

        Intent intent = new Intent(
                Intent.ACTION_SENDTO,
                Uri.parse("mailto:" + mEmailAddress));
        intent.putExtra(Intent.EXTRA_SUBJECT,
                mEmailSubject);
        intent.putExtra(Intent.EXTRA_TEXT,
                emailMessage);
        startActivity(Intent.createChooser(intent,
                "Send mail…"));
    }

}