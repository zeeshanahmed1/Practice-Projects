package com.example.developer.miwork;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Phrase extends AppCompatActivity {
 private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Singa ay?" ,"How are you?",R.raw.singaay));
        words.add(new Word("Charta ay","Where Are You?",R.raw.chartaay));
        words.add(new Word("Sa kay?","What's up?",R.raw.sakay));
        words.add(new Word("Wazgar ay?","Are u free?",R.raw.wazgaray));
        words.add(new Word("Kha yam a ","I am fine",R.raw.khayama));
        words.add(new Word("Zar rasha","come soon ",R.raw.zarrasha));
        words.add(new Word("Dair khan","goood",R.raw.dair_kha));
        words.add(new Word("KHUDAI p aman ","good by",R.raw.waya));
        words.add(new Word("Awra","listen?",R.raw.awra));
        words.add(new Word("Waya","ask ?",R.raw.waya));
        WordAdapter adapter =
                new WordAdapter(this,words,R.color.category_phrase);
        GridView listview =(GridView) findViewById(R.id.list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word word = words.get(i);
                mMediaPlayer= MediaPlayer.create(Phrase.this,word.getmAudioResourceId());
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
