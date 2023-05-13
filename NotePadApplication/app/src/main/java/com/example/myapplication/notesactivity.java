package com.example.myapplication;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;

import com.example.myapplication.databinding.ActivityNotesactivityBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class notesactivity extends AppCompatActivity {
    FloatingActionButton mcreatenotefab;
    private FirebaseAuth firebaseAuth;

        @Override
protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_notesactivity);


            mcreatenotefab=findViewById(R.id.createnotefab);

            firebaseAuth=FirebaseAuth.getInstance();

            getSupportActionBar().setTitle("All NOTES");

            mcreatenotefab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(notesactivity.this, createnote.class));
                }
            });





        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
            getMenuInflater().inflate(R.menu.menu,menu);
            return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.logout:
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(notesactivity.this, MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

}