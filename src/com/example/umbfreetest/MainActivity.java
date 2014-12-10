package com.example.umbfreetest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.*;import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import java.io.OutputStream;
import android.content.ContentValues;
import android.graphics.Bitmap.CompressFormat;
import android.provider.MediaStore.Images.Media;
import android.widget.Toast;

public class MainActivity extends Activity {

	ImageView choosenImageView;
	  Button choosePicture;
	  Button savePicture;

	  Bitmap bmp;
	  Bitmap alteredBitmap;
	  Canvas canvas;
	  Paint paint;
	  Matrix matrix;
	  float downx = 0;
	  float downy = 0;
	  float upx = 0;
	  float upy = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView myimage = (ImageView)findViewById(R.id.maps);
        myimage.setBackgroundColor(Color.BLACK);
        Button reset = (Button)findViewById(R.id.button1);
        MediaPlayer ding = MediaPlayer.create(MainActivity.this, R.drawable.ding);
        reset.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MediaPlayer ding2 = MediaPlayer.create(MainActivity.this, R.drawable.ding);
				ding2.start();
				
			}
		});
    }
   /*
    public boolean onTouchEvent(MotionEvent event)
    {
    	
    	return super.onTouchEvent(event);
    }
    
    */
    public boolean onTouchEvent(MotionEvent event){
    	downx=event.getX();
    	downy=event.getY();
    	
    	alteredBitmap=BitmapFactory.decodeResource(getResources(),R.drawable.map2);
    	Paint paint = new Paint();
    	paint.setAntiAlias(true);
    	paint.setColor(Color.BLUE);
    	
    	Bitmap workingBitmap = Bitmap.createBitmap(alteredBitmap);
    	Bitmap mutableBitmap = alteredBitmap.copy(Bitmap.Config.ARGB_8888, true);
    	
    	Canvas canvas = new Canvas(mutableBitmap);
    	canvas.drawCircle(downx,downy,25,paint);
    	
    	Button mybutton = (Button)findViewById(R.id.button1);
    	ImageView myview =(ImageView)findViewById(R.id.maps);
    	myview.setImageBitmap(mutableBitmap);
    
    return super.onTouchEvent(event);
    }
    
    
    
    
    
}
