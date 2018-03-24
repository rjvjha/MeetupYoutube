package com.example.rjvjha.meetupyoutube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "AIzaSyCsN7ovkUNH7fzHVbErwTHq6pjCrOmPbUQ";
    // Youtube Listener
    private YouTubePlayer.OnInitializedListener mOnIntializedLIstener;
    //declare view
    private YouTubePlayerSupportFragment fragment;
    private Button playButton;
    private YouTubePlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = (Button) findViewById(R.id.playButton);
        fragment = (YouTubePlayerSupportFragment) getSupportFragmentManager()
                .findFragmentById(R.id.youtube_player);


        mOnIntializedLIstener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                player = youTubePlayer;
                youTubePlayer.loadVideo("D86RtevtfrA");


            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(MainActivity.this,"Load Failed",Toast.LENGTH_SHORT).show();
            }
        };

        fragment.initialize(API_KEY, mOnIntializedLIstener);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.play();

            }
        });







    }
}
