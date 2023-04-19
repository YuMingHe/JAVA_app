package com.example.heyuming_10182267;

import java.util.ArrayList;
import java.util.List;

import com.example.heyuming_10182267.levelActivity.LetterAdapter;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;




public class paintActivity extends View{
	
	private Paint mPaint;
	private MyDatabaseHelper dbHelper;
	private EditText user;
	
	
	public paintActivity(Context context){super(context);init();}
	public paintActivity(Context context, AttributeSet attrs){super(context,attrs);init();}
	public paintActivity(Context context, AttributeSet attrs,int defStyleAttr){super(context,attrs,defStyleAttr);init();}
	
	private void init(){
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setColor(Color.BLUE); 
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setTextSize(36);
		mPaint.setStrokeWidth(5);
	}


	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		canvas.drawText("uesrname",200,200,mPaint);
		canvas.drawText("heyuming",200,240,mPaint);
		canvas.drawText("jinwenjing",200,280,mPaint);
		canvas.drawText("hhhh",200,320,mPaint);
	}
	
	
}

