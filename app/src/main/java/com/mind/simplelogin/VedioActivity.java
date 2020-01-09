package com.mind.simplelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VedioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio);
        VideoView video =  findViewById(R.id.videoView);

        video.setVideoPath("androidresource://" + getPackageManager()+"/" +R.raw.ut );

        MediaController controler = new MediaController(this);
        controler.setAnchorView(video);
        video.setMediaController(controler);

        video.start();
    }
}
