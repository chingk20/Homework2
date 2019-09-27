package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SurfaceView guiFaceView = (SurfaceView) findViewById(R.id.surfaceView);
        FaceController guiFaceController = new FaceController((Face) guiFaceView);
        guiFaceView.setOnTouchListener(guiFaceController);

        RadioButton hairButton = (RadioButton) findViewById(R.id.hairButton);
        hairButton.setOnClickListener(guiFaceController);
        RadioButton eyesButton = (RadioButton) findViewById(R.id.eyesButton);
        eyesButton.setOnClickListener(guiFaceController);
        RadioButton skinButton = (RadioButton) findViewById(R.id.skinButton);
        skinButton.setOnClickListener(guiFaceController);
        RadioGroup group= (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton checkedRadioButton = (RadioButton)group.findViewById(group.getCheckedRadioButtonId());

        Spinner hairSpinner = (Spinner) findViewById(R.id.spinner);
        hairSpinner.setOnItemSelectedListener(guiFaceController);
        String[] hairItems = new String[]{"Bowl Cut", "Curly", "Long"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, hairItems);
        hairSpinner.setAdapter(adapter);

        SeekBar redSeekBar = (SeekBar) findViewById(R.id.redSeekBar);
        redSeekBar.setOnSeekBarChangeListener(guiFaceController);
        SeekBar blueSeekBar = (SeekBar) findViewById(R.id.blueSeekBar);
        blueSeekBar.setOnSeekBarChangeListener(guiFaceController);
        SeekBar greenSeekBar = (SeekBar) findViewById(R.id.greenSeekBar);
        greenSeekBar.setOnSeekBarChangeListener(guiFaceController);

        Button randomFaceButton = (Button) findViewById(R.id.button);
        randomFaceButton.setOnClickListener(guiFaceController);
    }
}
