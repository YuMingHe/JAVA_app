package com.example.heyuming_10182267;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

//public class MainActivity extends Activity {
//	private Button button;
//    
//	@Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        button = (Button)findViewById(R.id.button1);
//        button.setOnClickListener(new OnClickListener(){
//        	 public void onClick(View v){ //此处添加逻辑代码
//        		 Toast.makeText(MainActivity.this,"Completed",
//        				 Toast.LENGTH_SHORT).show();
//        	 }
//        });
//	}
//        
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//   
//    
//}

public class MainActivity extends Activity implements OnClickListener{
	private Button button_1,button_2,button_3;
	private EditText editText_1;
	private ProgressBar progressbar_1;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_1 = (Button)findViewById(R.id.button1);
		button_1.setOnClickListener(this);
        button_2 = (Button)findViewById(R.id.button2);
        button_2.setOnClickListener(this);
        button_3 = (Button)findViewById(R.id.button3);
        button_3.setOnClickListener(this);
        editText_1 = (EditText)findViewById(R.id.edit_text1);
        progressbar_1 = (ProgressBar)findViewById(R.id.progress_bar1);
        
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity.this);
        alertdialog.setTitle("重要提示");
        alertdialog.setMessage("超级重要");
        alertdialog.setCancelable(false);
        alertdialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}
		});
		alertdialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}
		});
		alertdialog.show();
	}       
       
    public void onClick(View v){ //此处添加逻辑代码
    	String inputText = editText_1.getText().toString();
    	int progress = progressbar_1.getProgress();
    	switch (v.getId()){
    	  case R.id.button1:Toast.makeText(MainActivity.this, "completed",
    		        Toast.LENGTH_SHORT).show();break;
    	  case R.id.button2:Toast.makeText(MainActivity.this, inputText,
  		        Toast.LENGTH_SHORT).show();break;
    	  case R.id.button3:progressbar_1.setProgress(progress+10);
    	}
    }
         

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public class TitleLayout extends LinearLayout implements View.OnClickListener{
    	
    	private Button btn_back,btn_edit;
    	
    	
    	public TitleLayout(Context context, AttributeSet attrs){
    		super(context, attrs);
    		setContentView(R.layout.page1);
    		View view = LayoutInflater.from(context).inflate(R.layout.page1,this);
    		
    		btn_back = (Button) view.findViewById(R.id.title_back);
    		btn_back.setOnClickListener(this);
        	btn_edit = (Button) view.findViewById(R.id.title_edit);
        	btn_edit.setOnClickListener(this);
    	}
    	
    	 @Override
    	 public void onClick(View a){
    		 if(a==btn_back){
    			 ((MainActivity)getContext()).finish();
    		 }
    		 else if(a==btn_edit){
    			 ((MainActivity)getContext()).finish();
    		 }
    	 }
    	
    	
    }
   
    
}
