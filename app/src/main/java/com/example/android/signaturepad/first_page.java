package com.example.android.signaturepad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by LEN on 11-Jan-18.
 */

public class first_page extends AppCompatActivity {


    ImageButton img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);

        img = (ImageButton) findViewById(R.id.start);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSecondPage();
            }
        });


    }

    private void toSecondPage()
    {

        startActivity(new Intent(first_page.this,second.class));
    }





}
