package com.glider;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private Bitmap theBitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // onCreate stuff ...
        super.onCreate(savedInstanceState);
        final ImageView image = (ImageView) findViewById(R.id.gif_image);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                Looper.prepare();
                try {
                    theBitmap = Glide.
                            with(MainActivity.this).
                            load("https://cdn2.iconfinder.com/data/icons/free-3d-printer-icon-set/512/Plastic_model.png").
                            asBitmap().
                            into(-1, -1).
                            get();
                } catch (final ExecutionException e) {

                } catch (final InterruptedException e) {

                }
                return null;
            }

            @Override
            protected void onPostExecute(Void dummy) {
                if (null != theBitmap) {
                    saveImageToExternal(theBitmap);
                    Bitmap bss = getImageFromExternal();
                    //Log.d("asad",bss.getWidth()+"");
                }
                ;
            }
        }.execute();
    }


    public static Bitmap getImageFromExternal() {
        final File file = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "/AsadStuffDemo", "encore-logo.bmp");

        if (file.exists()) {
            Bitmap bmp = BitmapFactory.decodeFile(file.getAbsolutePath());
            return bmp;
        } else {
            return null;
        }
    }
    public static void saveImageToExternal(Bitmap bitmap) {

        String file_path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/AsadStuffDemo";
        File dir = new File(file_path);
        if (!dir.exists())
            dir.mkdirs();
        File file = new File(dir, "encore-logo" + ".bmp");

        try {
            FileOutputStream fOut = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 85, fOut);
            fOut.flush();
            fOut.close();

        } catch (IOException ex) {
        }
    }
}
