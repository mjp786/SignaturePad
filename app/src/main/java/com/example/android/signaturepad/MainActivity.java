package com.example.android.signaturepad;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

import static android.graphics.Color.parseColor;

public class MainActivity extends AppCompatActivity {

    Button bt;
    Button bt1;
    GestureOverlayView gestureView;
    String s1,s2,s3;
    Bitmap bm;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        s1 = extras.getString("fileName");
        s2 = extras.getString("BackgroundColor");
        s3 = extras.getString("textColor");



         bt= (Button)findViewById(R.id.DoneButton);
         bt1=(Button) findViewById(R.id.clear);
         gestureView = (GestureOverlayView) findViewById(R.id.signaturePad);



        set(s2,s3);
        //    gestureView.setUncertainGestureColor(0x);
        //    gestureView.setBackgroundColor(Color.parseColor("#00ff00"));

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               save();         }
        });


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gestureView.cancelClearAnimation();
                gestureView.clear(true);
            }
        });

    }





    private void save()
    {
        try{
            Toast.makeText(getApplicationContext(),"image saved",Toast.LENGTH_SHORT).show();
            gestureView.setDrawingCacheEnabled(true);
            bm = Bitmap.createBitmap(gestureView.getDrawingCache());
            File f = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + s1+".png");
            f.createNewFile();
            FileOutputStream os = new FileOutputStream(f);
            //os = new FileOutputStream(f);
            //compress to specified format (PNG), quality - which is ignored for PNG, and out stream
            bm.compress(Bitmap.CompressFormat.PNG, 100, os);
            os.write(bm.getRowBytes());
            os.close();

           //the gallery displays images stored on the media store provider
           //you can use this method to store image file on media store provider:
            MediaStore.Images.Media.insertImage(getContentResolver(), bm, s1 , "");

        } catch (Exception e) {
            Log.v("Gestures", e.getMessage());
            e.printStackTrace();
        }




    }

    private void set(String back,String text)
    {
        if(back.equals("WHITE")){ gestureView.setBackgroundColor(Color.parseColor("#ffffff")); }
        else if(back.equals("BLACK")){ gestureView.setBackgroundColor(Color.parseColor("#000000")); }
        else if(back.equals("VIOLET")){ gestureView.setBackgroundColor(Color.parseColor("#800080")); }
        else if(back.equals("INDIGO")){ gestureView.setBackgroundColor(Color.parseColor("#4B0082")); }
        else if(back.equals("BLUE")){ gestureView.setBackgroundColor(Color.parseColor("#0000ff")); }
        else if(back.equals("GREEN")){ gestureView.setBackgroundColor(Color.parseColor("#32CD32")); }
        else if(back.equals("YELLOW")){ gestureView.setBackgroundColor(Color.parseColor("#FFFF00")); }
        else if(back.equals("ORANGE")){ gestureView.setBackgroundColor(Color.parseColor("#ffa500")); }
        else if(back.equals("RED")){ gestureView.setBackgroundColor(Color.parseColor("#FF0000")); }



        if(text.equals("WHITE")){ gestureView.setGestureColor(Color.parseColor("#ffffff")); }
        else if(text.equals("BLACK")){ gestureView.setGestureColor(Color.parseColor("#000000")); }
        else if(text.equals("VIOLET")){ gestureView.setGestureColor(Color.parseColor("#800080")); }
        else if(text.equals("INDIGO")){ gestureView.setGestureColor(Color.parseColor("#4B0082")); }
        else if(text.equals("BLUE")){ gestureView.setGestureColor(Color.parseColor("#0000ff")); }
        else if(text.equals("GREEN")){ gestureView.setGestureColor(Color.parseColor("#32CD32")); }
        else if(text.equals("YELLOW")){ gestureView.setGestureColor(Color.parseColor("#FFFF00")); }
        else if(text.equals("ORANGE")){ gestureView.setGestureColor(Color.parseColor("#ffa500")); }
        else if(text.equals("RED")){ gestureView.setGestureColor(Color.parseColor("#FF0000")); }


    }

}