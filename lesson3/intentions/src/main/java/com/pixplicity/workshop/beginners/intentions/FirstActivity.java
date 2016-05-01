package com.pixplicity.workshop.beginners.intentions;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends Activity {

    public static final int REQUEST_CODE = 12345;

    private EditText mEmailAddress;

    private EditText mEmailSubject;

    private EditText mEmailMessage;

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mEmailAddress = (EditText) findViewById(R.id.email_address);
        mEmailSubject = (EditText) findViewById(R.id.email_subject);

        mEmailMessage = (EditText) findViewById(R.id.email_message);
        mEmailMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Beware: we need to make sure to convert the text to a String!
                String emailMessage = mEmailMessage.getText().toString();

                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra(SecondActivity.EXTRA_EMAIL_MESSAGE, emailMessage);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        mButton = (Button) findViewById(R.id.next);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress = mEmailAddress.getText().toString();
                String emailSubject = mEmailSubject.getText().toString();
                String emailMessage = mEmailMessage.getText().toString();

                Intent intent = new Intent(
                        Intent.ACTION_SENDTO,
                        Uri.parse("mailto:" + emailAddress));
                intent.putExtra(Intent.EXTRA_SUBJECT,
                        emailSubject);
                intent.putExtra(Intent.EXTRA_TEXT,
                        emailMessage);
                startActivity(Intent.createChooser(intent,
                        "Send mail…"));
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 12345) {
            if (resultCode == RESULT_OK && data != null) {
                mEmailMessage.setText(data.getStringExtra("message"));
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}