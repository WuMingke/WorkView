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

    private WorkView workView;

    private TextView distance;

    private boolean hasTurned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workView = (WorkView) findViewById(R.id.workView);
        distance = (TextView) findViewById(R.id.distance);


    }

    public void start_move(View view) {

        workView.setCarY(workView.getCarY() - 20);


        //测试数据，先往左移动，再往右
        if (workView.getCarX() >= 300) {

            if (!hasTurned) {
                workView.setCarX(workView.getCarX() - 10);
            } else {
                workView.setCarX(workView.getCarX() + 10);
            }

            if ((workView.getCarX() == (workView.getWidth() / 2)) && hasTurned) {
                hasTurned = false;
            }
        }

        if (workView.getCarX() < 300) {
            workView.setCarX(workView.getCarX() + 10);
            hasTurned = true;
        }

        distance.setText(getString(R.string.instance) + Math.abs(workView.getCarX() - workView.getWidth() / 2));

    }
}
