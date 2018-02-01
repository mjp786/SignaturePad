package com.example.android.signaturepad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import static android.R.attr.color;
import static android.R.attr.country;
import static com.example.android.signaturepad.R.array.color_array1;
import static com.example.android.signaturepad.R.array.color_array2;

/**
 * Created by LEN on 11-Jan-18.
 */

public class second extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText et;
    String s0=" ",s1,s2;
    Spinner spinner1, spinner2;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

         spinner1 = (Spinner) findViewById(R.id.spinner1);
         spinner2 = (Spinner) findViewById(R.id.spinner2);
         bt = (Button) findViewById(R.id.go);
         et=(EditText) findViewById(R.id.edit);


        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);


// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                color_array1, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                color_array2, android.R.layout.simple_spinner_item);

// Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        // Apply the adapter to the spinner
        spinner1.setAdapter(adapter1);
// Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);



        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMainPage();
            }
        });






    }


    private void toMainPage()
    {
        s0=et.getText().toString().trim();
        Intent intent = new Intent(second.this,MainActivity.class);
        intent.putExtra("fileName",s0);
        intent.putExtra("BackgroundColor",s1);
        intent.putExtra("textColor",s2);
        startActivity(intent);


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()) {

            case R.id.spinner1:
                // do stuffs with you spinner 1
                // An item was selected. You can retrieve the selected item using
                 s1 =parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"background color : "+s1 ,Toast.LENGTH_LONG).show();
                break;

            case R.id.spinner2:
                // do stuffs with you spinner 2
                 s2 =parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"text color : "+s2 ,Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(getApplicationContext(),"position one is selected" ,Toast.LENGTH_LONG).show();

    }





}
