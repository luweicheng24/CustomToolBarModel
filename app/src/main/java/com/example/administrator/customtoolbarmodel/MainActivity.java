package com.example.administrator.customtoolbarmodel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CustomToolBar.LeftOnClickListener, CustomToolBar.RightOnClickListener {
private  CustomToolBar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        toolBar =(CustomToolBar) findViewById(R.id.toolBar);
        toolBar.setleftOnClickListener(this);
        toolBar.setrightOnClickListener(this);

    }

    @Override
    public void leftClick(View view) {
        Toast.makeText(this, "返回", Toast.LENGTH_SHORT).show();
        toolBar.setleftVisible(false);
    }

    @Override
    public void rightClick(View view) {
        Toast.makeText(this, "提交", Toast.LENGTH_SHORT).show();
        toolBar.setrightVisible(false);
    }
}
