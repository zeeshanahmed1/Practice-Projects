package com.bignerdranch.android.getloc;

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
        final EditText editText1 = (EditText) findViewById(R.id.Edit_text1);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = editText.getText().toString();
               // composeEmail("zeeshan.ahmed9382@gmail.com", "testSubject", message);

                mapIntent("geo:"+editText+","+editText1+"");
                // Creates an Intent that will load a map of San Francisco
                //    Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
                //   Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                //  mapIntent.setPackage("com.google.android.apps.maps");
                //  startActivity(mapIntent);

            }
        });
    }



    public void mapIntent(String intentLoc)
    {
        Uri gmmIntentUri = Uri.parse(intentLoc);

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        //   mapIntent.setData(Uri.parse(intentLoc));
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }



    }


}
