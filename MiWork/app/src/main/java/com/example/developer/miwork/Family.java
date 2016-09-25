package com.example.developer.miwork;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Family extends AppCompatActivity {
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
        setContentView(R.layout.activity_family);
       final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Dada g","Grand Father",R.drawable.family_grandfather,R.raw.dada));
        words.add(new Word("Abae","Grand Mother",R.drawable.family_grandmother,R.raw.abae));
        words.add(new Word("Plar" ,"Father",R.drawable.family_father,R.raw.plar));
        words.add(new Word("Mor","Mother",R.drawable.family_mother,R.raw.mor));
        words.add(new Word("Kashar Ror","Older Brother",R.drawable.family_older_brother,R.raw.kasharror));
        words.add(new Word("Mashar Ror","Younger Brother",R.drawable.family_younger_brother,R.raw.masharror));
        words.add(new Word("Kashar Khor","Oldar Sister",R.drawable.family_older_sister,R.raw.kasharror));
        words.add(new Word("Mashar Khor","YoungerSister",R.drawable.family_younger_sister,R.raw.masharkhor));
        words.add(new Word("Jinay","Daughter",R.drawable.family_daughter,R.raw.jinay));
        words.add(new Word("Zoya","Son",R.drawable.family_son,R.raw.zoe));
        WordAdapter adapter =
                new WordAdapter(this,words,R.color.category_family);
        GridView listview =(GridView) findViewById(R.id.list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word word = words.get(i);
                releaseMediaPlayer();
                mMediaPlayer= MediaPlayer.create(Family.this,word.getmAudioResourceId());
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
