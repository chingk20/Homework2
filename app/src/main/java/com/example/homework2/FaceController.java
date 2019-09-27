package com.example.homework2;

import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.util.Log;


public class FaceController implements AdapterView.OnItemSelectedListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    private Face myFace;

    public FaceController(Face face)
    {
        myFace = face;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //if(myFace.hairChecked == true){
        switch (i) {
            case 0:
                myFace.hairStyle = 0;
                myFace.invalidate();
                myFace.hairChecked = false;
                break;
            case 1:
                myFace.hairStyle = 1;
                myFace.invalidate();
                myFace.hairChecked = false;
                break;
            case 2:
                myFace.hairStyle = 2;
                myFace.invalidate();
                myFace.hairChecked = false;
                break;
        }
    //}
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId())
        {
            case R.id.redSeekBar:
                myFace.redColor = progress;
                myFace.invalidate();
                break;
            case R.id.blueSeekBar:
                myFace.blueColor = progress;
                myFace.invalidate();
                break;
            case R.id.greenSeekBar:
                myFace.greenColor = progress;
                myFace.invalidate();
                break;
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public void onClick(View view) {
        Log.d("button", "Random Face");
        myFace.randomize();
        myFace.invalidate();
    }

    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int id = group.getCheckedRadioButtonId();
        switch (id) {
            case R.id.hairButton:
                myFace.hairChecked = true;
                myFace.invalidate();
                break;
            case R.id.eyesButton:
                myFace.eyesChecked = true;
                myFace.invalidate();
                break;
            case R.id.skinButton:
                myFace.skinChecked = true;
                myFace.invalidate();
                break;
            default:
                break;
        }
    }


}
