package com.example.toolbarmodule.com.ui.toolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by Administrator on 2017/3/4 0004.
 */

public class CustomToolBar extends RelativeLayout {
    
    private Button leftButton,rightButton;
    private TextView title;
    
    private String titleText;
    private int titleBackground;
    private float titleSize;
    
    private int leftBackGround;
    private float leftTextSize;
    private String leftButtonText; 
    
    
    private int rightBackGround;
    private float rightTextSize;
    private String rightButtonText;

    private LayoutParams layoutParams;
    
    public CustomToolBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
       super(context, attrs, defStyleAttr) ;
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.toolbar);
        
        titleText = typedArray.getString(R.styleable.toolbar_titleText);
        titleBackground = typedArray.getColor(R.styleable.toolbar_titleColor,0);
        titleSize = typedArray.getFloat(R.styleable.toolbar_titleSize,15);
        
        leftBackGround = typedArray.getColor(R.styleable.toolbar_leftBackGround,0);
        leftButtonText = typedArray.getString(R.styleable.toolbar_leftText);
        leftTextSize = typedArray.getFloat(R.styleable.toolbar_leftTextSize,15);
        
        rightBackGround = typedArray.getColor(R.styleable.toolbar_rightBackGround,0);
        rightButtonText = typedArray.getString(R.styleable.toolbar_rightText);
        rightTextSize = typedArray.getFloat(R.styleable.toolbar_rightTextSize,15);

        typedArray.recycle();//释放资源

        setBackgroundColor(context.getResources().getColor(R.color.red));

        leftButton = new Button(context);
        rightButton = new Button(context);
        title = new TextView(context);

        titleSize = typedArray.getFloat(R.styleable.toolbar_titleSize,15);
        titleBackground = typedArray.getColor(R.styleable.toolbar_titleColor,0);
        titleText = typedArray.getString(R.styleable.toolbar_titleText);
        layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        title.setText(titleText);
        title.setTextSize(titleSize);
        title.setBackgroundColor(titleBackground);
        addView(title,layoutParams);



        leftButton.setText(leftButtonText);
        leftButton.setBackgroundColor(leftBackGround);
        leftButton.setTextSize(leftTextSize);
        layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.ALIGN_LEFT);
        addView(leftButton,layoutParams);



        rightButton.setBackgroundColor(rightBackGround);
        rightButton.setText(rightButtonText);
        rightButton.setTextSize(rightTextSize);
        layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.ALIGN_RIGHT);
        addView(rightButton,layoutParams);



    }
    
    public CustomToolBar(Context context) {
        this(context,null);
    }
}
