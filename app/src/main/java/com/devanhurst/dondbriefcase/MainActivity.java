package com.devanhurst.dondbriefcase;

import android.support.v7.app.AppCompatActivity;

import android.os.CountDownTimer;
import android.os.Bundle;

import android.view.SurfaceView;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.AudioManager;

import com.devanhurst.dondbriefcase.motiondetection.MotionDetector;
import com.devanhurst.dondbriefcase.motiondetection.MotionDetectorCallback;
import com.devanhurst.dondbriefcase.swipe.OnSwipeTouchListener;
import com.devanhurst.dondbriefcase.briefcase.*;


public class MainActivity extends AppCompatActivity {
    private MotionDetector motionDetector;
    private Case briefcase;
    private Button button;
    private Value value;
    public static TextView gameSelector;
    public static Integer gameId = 0;
    public static Boolean bgmEnabled = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        briefcase = new Case(this.gameId);
        gameSelector = findViewById(R.id.gameSelector);
        gameSelector.setText("");

        decorView.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()){
            public void onSwipeRight() {
                MainActivity.gameId++;
                briefcase = new Case(MainActivity.gameId);
                MainActivity.gameSelector.setText(briefcase.getGameName());
            }
            public void onSwipeLeft() {
                MainActivity.bgmEnabled = !MainActivity.bgmEnabled;
                briefcase = new Case(MainActivity.gameId);
                Toast.makeText(getApplicationContext(), MainActivity.getBgmMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        value = briefcase.getRandomValue();

        button = findViewById(R.id.button);
        button.setText(value.amount, Button.BufferType.SPANNABLE);

        final MediaPlayer bgPlayer = MediaPlayer.create(getApplicationContext(), briefcase.getBgm());
        bgPlayer.setLooping(true);

        if (bgmEnabled) {
            bgPlayer.start();
        }

        final SoundPool soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        final int buildup = soundPool.load(getApplicationContext(), R.raw.buildup, 1);
        final int reveal = soundPool.load(getApplicationContext(), value.sound, 1);

        motionDetector = new MotionDetector(this, (SurfaceView) findViewById(R.id.surfaceView));
        motionDetector.setMotionDetectorCallback(new MotionDetectorCallback() {
            @Override
            public void onMotionDetected() {
                soundPool.play(buildup, 1, 1, 0, 0, 1);
                new CountDownTimer(2500, 2500) {
                    public void onTick(long m) { return; }
                    public void onFinish() {
                        soundPool.play(reveal, 1, 1, 0, 0, 1);
                        bgPlayer.stop();
                    }
                }.start();
            }
        });

        ////// Config Options
        motionDetector.setCheckInterval(333);
        motionDetector.setLeniency(10);
    }

    public void restartGame(View view) {
        button.setText("GET READY");
        new CountDownTimer(5000, 100) {
            public void onTick(long m) {
                if (m < 4000) {
                    String secs = String.valueOf(m / 999);
                    button.setText(secs);
                }
            }
            public void onFinish() { recreate(); }
        }.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        motionDetector.onResume();
    }

    public static String getBgmMessage() {
        if (bgmEnabled) {
            return "Music Enabled";
        } else {
            return "Music Disabled";
        }
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        motionDetector.onPause();
//    }

}
