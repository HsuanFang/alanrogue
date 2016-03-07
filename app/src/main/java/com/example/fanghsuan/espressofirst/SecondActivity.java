package com.example.fanghsuan.espressofirst;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by fanghsuan on 16/2/20.
 */
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView viewById = (TextView) findViewById(R.id.resultView);
        Bundle inputData = getIntent().getExtras();
        String input = inputData.getString("input");
        viewById.setText(input);
    }

}
