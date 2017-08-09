package com.glider;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView imageView = (ImageView) findViewById(R.id.gif_image);

        String url ="https://cdn2.iconfinder.com/data/icons/free-3d-printer-icon-set/512/Plastic_model.png";
        // GIF Uri
        Uri gifUri = Uri.parse("http://p.fod4.com/p/media/22e39b6ac0/T58DAqfzR3iXMrL0EzkK_b4.gif");
//
//        Glide.with(this)
//                .load(gifUri)
//                .centerCrop()
//                .crossFade()
//                .into(imageView);
//

        Glide.with(this)
                .load(url)
                .into(imageView);

    }
}
