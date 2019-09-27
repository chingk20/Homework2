/*
 *   @author:Keisha Ching
 *   Class: CS 301
 *   Homework 2
 *   Date: 10/01/2019
 *
 */

package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    public SeekBar redSeekBar;
    public SeekBar blueSeekBar;
    public SeekBar greenSeekBar;

    private static MainActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SurfaceView guiFaceView = (SurfaceView) findViewById(R.id.surfaceView);
        FaceController guiFaceController = new FaceController((Face) guiFaceView);

        RadioButton hairButton = (RadioButton) findViewById(R.id.hairButton);
        hairButton.setOnClickListener(guiFaceController);
        RadioButton eyesButton = (RadioButton) findViewById(R.id.eyesButton);
        eyesButton.setOnClickListener(guiFaceController);
        RadioButton skinButton = (RadioButton) findViewById(R.id.skinButton);
        skinButton.setOnClickListener(guiFaceController);

        Spinner hairSpinner = (Spinner) findViewById(R.id.spinner);
        hairSpinner.setOnItemSelectedListener(guiFaceController);
        String[] hairItems = new String[]{"Curly", "Long", "Bowl Cut"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, hairItems);
        hairSpinner.setAdapter(adapter);

        redSeekBar = (SeekBar) findViewById(R.id.redSeekBar);
        redSeekBar.setOnSeekBarChangeListener(guiFaceController);
        blueSeekBar = (SeekBar) findViewById(R.id.blueSeekBar);
        blueSeekBar.setOnSeekBarChangeListener(guiFaceController);
        greenSeekBar = (SeekBar) findViewById(R.id.greenSeekBar);
        greenSeekBar.setOnSeekBarChangeListener(guiFaceController);

        Button randomFaceButton = (Button) findViewById(R.id.button);
        randomFaceButton.setOnClickListener(guiFaceController);

        instance = this;
    }

    public static MainActivity getInstance() {
        return instance;
    }
}
