package com.bignerdranch.android.intentmail;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSend = (Button) findViewById(R.id.btnSend);


        final EditText editText = (EditText) findViewById(R.id.Edit_text);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = editText.getText().toString();
                 composeEmail("zeeshan.ahmed9382@gmail.com", "testSubject", message);

               // mapIntent("geo:37.7749,-122.4194");
                // Creates an Intent that will load a map of San Francisco
                //    Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
                //   Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                //  mapIntent.setPackage("com.google.android.apps.maps");
                //  startActivity(mapIntent);

            }
        });
    }




    public void composeEmail(String addresses, String subject, String txt) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, txt);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }






}
