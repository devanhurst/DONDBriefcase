package com.devanhurst.dondbriefcase;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.media.MediaPlayer;
import android.view.View.OnClickListener;

import com.devanhurst.dondbriefcase.motiondetection.MotionDetector;
import com.devanhurst.dondbriefcase.motiondetection.MotionDetectorCallback;

import com.devanhurst.dondbriefcase.briefcase.*;

public class MainActivity extends AppCompatActivity {
    private MotionDetector motionDetector;
    private Integer gameId;
    private Case briefcase;
    private Integer counter;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_IMMERSIVE
            // Set the content to appear under the system bars so that the
            // content doesn't resize when the system bars hide and show.
            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            // Hide the nav bar and status bar
            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        briefcase = new Case(1);

        button = findViewById(R.id.button);

        final MediaPlayer bgPlayer = MediaPlayer.create(getApplicationContext(), R.raw.offer);
        bgPlayer.start();

        motionDetector = new MotionDetector(this, (SurfaceView) findViewById(R.id.surfaceView));
        motionDetector.setMotionDetectorCallback(new MotionDetectorCallback() {
            @Override
            public void onMotionDetected() {
                Value value = briefcase.getRandomValue();
                button.setText(value.amount);
                MediaPlayer mPlayer = MediaPlayer.create(getApplicationContext(), value.sound);
                bgPlayer.stop();
                mPlayer.start();
            }

            @Override
            public void onNoMotion() {
                // Change value inside the case
                button.setText("???");
            }
        });
        ////// Config Options
        motionDetector.setCheckInterval(500);
        motionDetector.setLeniency(20);
        motionDetector.setMinLuma(1000);
    }

    public void restartGame(View view) {
        new CountDownTimer(5000, 1000) {
            public void onTick(long m) {
                String secs = String.valueOf(m / 1000);
                button.setText(secs);
            }
            public void onFinish() { recreate(); }
        }.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        motionDetector.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        motionDetector.onPause();
    }

}
