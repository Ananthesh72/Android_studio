package com.example.changewallpaper;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.graphics.Bitmap;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity
{
    Button wallpaper;
    Timer timer;
    Drawable drawable;
    WallpaperManager wpm;
    int prev=1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    { super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = new Timer();
        wpm = WallpaperManager.getInstance(this);
        wallpaper = findViewById(R.id.btn);
        wallpaper.setOnClickListener(new View.OnClickListener()
        { @Override public void onClick(View view) {
            setWallpaper();
        }
        });
    }
    private void setWallpaper() {
        timer.schedule(new TimerTask() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void run() {
                if(prev==1) {
                    drawable = getResources().getDrawable(R.drawable.img1);
                    prev = 2;
                }
                else if(prev==2) {
                    drawable = getResources().getDrawable(R.drawable.img2);
                    prev=3;
                }
                else if(prev==3) {
                    drawable = getResources().getDrawable(R.drawable.img3);
                    prev=4;
                }
                else if(prev==4) {
                    drawable = getResources().getDrawable(R.drawable.img4); prev=5;
                }
                else if(prev==5) {
                    drawable = getResources().getDrawable(R.drawable.img5);
                    prev=1;
                }
                Bitmap wallpaper = ((BitmapDrawable)drawable).getBitmap();
                try {
                    wpm.setBitmap(wallpaper);
                } catch (IOException e) { e.printStackTrace();
                }
            }
        },0,300);}
}
