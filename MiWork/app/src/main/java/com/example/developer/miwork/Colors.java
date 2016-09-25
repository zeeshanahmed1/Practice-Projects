package com.example.developer.miwork;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {
    private MediaPlayer mMediaPlayer ;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Sur" ,"Red",R.drawable.color_red,R.raw.sur));
        words.add(new Word("Ziyar","Yellow",R.drawable.color_dusty_yellow,R.raw.maltarang));
        words.add(new Word("Shin","Green",R.drawable.color_green,R.raw.shin));
        words.add(new Word("Kaleji","Brown",R.drawable.color_brown,R.raw.kaleji));
        words.add(new Word("MAlta Rang","Mustard Yellow",R.drawable.color_mustard_yellow,R.raw.ziyar));
        words.add(new Word("Surmai","Gray",R.drawable.color_gray,R.raw.surmai));
        words.add(new Word("SPin","White",R.drawable.color_white,R.raw.spin));
        words.add(new Word("Tor","Black",R.drawable.color_black,R.raw.tor));

        WordAdapter adapter =
                new WordAdapter(this,words,R.color.category_colors);
        GridView listview =(GridView) findViewById(R.id.list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word word = words.get(i);
                releaseMediaPlayer();
                mMediaPlayer= MediaPlayer.create(Colors.this,word.getmAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);


            }
        });
        
    }
    //for stoping media files when app stops
    public void oStop(){
        super.onStop();
        releaseMediaPlayer();

    }

    public void releaseMediaPlayer() {
        if (mMediaPlayer != null) {

            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
