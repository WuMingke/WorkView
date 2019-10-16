package com.erkuai.workview;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WorkView2 workView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workView = (WorkView2) findViewById(R.id.workView);

    }

    public void left(View view) {
     //   if (workView.getCarX() > workView.getBitmapCar().getWidth() / 2) {
            workView.setCarX(workView.getCarX() - 10);
     //   }
    }

    public void right(View view) {
      //  if (workView.getCarX() < workView.getWidth() - workView.getBitmapCar().getWidth() / 2) {
            workView.setCarX(workView.getCarX() + 10);
       // }
    }


}
