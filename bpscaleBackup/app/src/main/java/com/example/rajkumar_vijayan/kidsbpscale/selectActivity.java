package com.example.rajkumar_vijayan.kidsbpscale;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

public class selectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        NumberPicker np = (NumberPicker) findViewById(R.id.npAge);
        String[] nums = new String[20];
        for(int i=0; i<nums.length; i++)
            nums[i] = Integer.toString(i);

        np.setMinValue(1);
        np.setMaxValue(31);
        np.setWrapSelectorWheel(false);
        np.setDisplayedValues(nums);
        np.setValue(2);



    }

    public void onClickSubmit(View v){
        Intent i = new Intent(selectActivity.this, DisplayActivity.class);
        //Pass Image result to the intent
        // i.putExtra("imageurl", movieResult.getPosterPath());
        i.putExtra("result", "Test");
        //Launch activity
        startActivity(i);
    }
}
