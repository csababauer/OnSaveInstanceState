package com.example.android.onsaveinstancestate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int counter = 0;
    boolean flag = true;
    boolean flag2 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // add 1 for every click until submit is clicked
    public void click (View v){

        if (flag2){
            counter += 1;
            showText();
        }
    }

    //add +1 and disable button
    public void submitClick(View v) {

        if (flag) {

            flag = false;
            flag2 = false;
        }
    }

    // show result
    public void showText() {
        TextView myCounter = (TextView) findViewById(R.id.text);
        myCounter.setText("" + counter);

    }

    //clean sheet
    public void cancelClick (View v) {
            counter = 0;
            flag = true;
            flag2 = true;
            showText();

    }



    //save data if the device orientation changes
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("counterS", counter);
        savedInstanceState.putBoolean("myButtonS", flag);
        savedInstanceState.putBoolean("flag2", flag2);
    }

    @Override
    public void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);

        if (saveInstanceState != null) {
            counter = saveInstanceState.getInt("counterS");
            flag = saveInstanceState.getBoolean("myButtonS");
            flag2 = saveInstanceState.getBoolean("flag2");
        }
        showText();
    }
}





