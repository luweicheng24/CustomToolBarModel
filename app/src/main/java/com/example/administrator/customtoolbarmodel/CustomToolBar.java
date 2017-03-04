package com.example.administrator.customtoolbarmodel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
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

    private Drawable leftBackGround;
    private int leftTextColor;
    private String leftButtonText;


    private Drawable rightBackGround;
    private int rightTextColor;
    private String rightButtonText;

    private LayoutParams leftParams,rightParams,titleParams;
    private Boolean flag = true;


    public CustomToolBar(Context context, AttributeSet attrs) {
        super(context, attrs) ;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomToolBar);

        titleText = typedArray.getString(R.styleable.CustomToolBar_titleText);
        titleBackground = typedArray.getColor(R.styleable.CustomToolBar_titleColor,0);
        titleSize =  typedArray.getDimension(R.styleable.CustomToolBar_titleSize,0);

        leftBackGround = typedArray.getDrawable(R.styleable.CustomToolBar_leftBackGround);
        leftButtonText = typedArray.getString(R.styleable.CustomToolBar_leftText);
        leftTextColor = typedArray.getColor(R.styleable.CustomToolBar_leftTextColor,0);

        rightBackGround = typedArray.getDrawable(R.styleable.CustomToolBar_rightBackGround);
        rightButtonText = typedArray.getString(R.styleable.CustomToolBar_rightText);
        rightTextColor = typedArray.getColor(R.styleable.CustomToolBar_rightTextColor,0);

        typedArray.recycle();//释放资源

        setBackgroundColor(getResources().getColor(R.color.colorgray));

        leftButton = new Button(context);
        rightButton = new Button(context);
        title = new TextView(context);

        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(leftOnClickListener!=null){
                    leftOnClickListener.leftClick(leftButton);
                }
            }
        });

        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rightOnClickListener!=null){
                    rightOnClickListener.rightClick(leftButton);
                }
            }
        });


        title.setText(titleText);
        title.setTextSize(titleSize);
        title.setBackgroundColor(titleBackground);
        title.setGravity(Gravity.CENTER);

        leftButton.setText(leftButtonText);
        leftButton.setTextColor(leftTextColor);
        leftButton.setBackgroundDrawable(leftBackGround);

        rightButton.setBackgroundDrawable(rightBackGround);
        rightButton.setText(rightButtonText);
        rightButton.setTextColor(rightTextColor);


        titleParams = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(title,titleParams);



        leftParams = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        addView(leftButton,leftParams);




        rightParams = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(rightButton,rightParams);

    }

    /**
     * 设置左边控件是否显示
     * @param flag
     */
   public void setleftVisible(Boolean flag){
       if(flag == true){
           leftButton.setVisibility(VISIBLE);
       }else{
           leftButton.setVisibility(GONE);
       }

   }

    /**
     * 设置右边控件是否显示
     * @param flag
     */
    public void setrightVisible(Boolean flag){
       if(flag == true){
          rightButton.setVisibility(VISIBLE);
       }else{
           rightButton.setVisibility(GONE);
       }

   }

    /**
     * 左边按钮的监听事件
     */

    public interface LeftOnClickListener{
        void leftClick(View view);
        
    }
    
    public LeftOnClickListener leftOnClickListener;
    public void setleftOnClickListener(LeftOnClickListener leftOnClickListener){
        this.leftOnClickListener = leftOnClickListener;
    }

    /**
     * 右边按钮的监听事件
     */
    public interface RightOnClickListener{
        void rightClick(View view);

    }

    public RightOnClickListener rightOnClickListener;
    public void setrightOnClickListener(RightOnClickListener rightOnClickListener){
        this.rightOnClickListener = rightOnClickListener;
    }
    
}

