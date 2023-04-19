package com.example.heyuming_10182267;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
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

public class welcomeActivity1 extends Activity{
	
	Button a,b,c;
	@Override
    protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome1);
		a = (Button) this.findViewById(R.id.button001);
		a.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View b) {
				
				Intent intent = new Intent();
                    intent.setClass(welcomeActivity1.this, SQLActivity.class);
					startActivity(intent);
					Toast.makeText(welcomeActivity1.this, "开始游戏",
		    		        Toast.LENGTH_SHORT).show();
			}
		});
		b = (Button) this.findViewById(R.id.button002);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View b) {
				
				Intent intent = new Intent();
                    intent.setClass(welcomeActivity1.this, chat.class);
					startActivity(intent);
					Toast.makeText(welcomeActivity1.this, "开始聊天",
		    		        Toast.LENGTH_SHORT).show();
			}
		});
		c = (Button) this.findViewById(R.id.button003);
		c.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View b) {
				
				Intent intent = new Intent();
                    intent.setClass(welcomeActivity1.this, MainActivity.class);
					startActivity(intent);
					Toast.makeText(welcomeActivity1.this, "评价游戏",
		    		        Toast.LENGTH_SHORT).show();
			}
		});
	}
	
}