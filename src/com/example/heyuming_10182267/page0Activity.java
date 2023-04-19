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

public class page0Activity extends Activity{
	
	Button btn_back,btn_edit;
	@Override
    protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page0);
		btn_back = (Button) this.findViewById(R.id.title_back);
		btn_edit = (Button) this.findViewById(R.id.title_edit);
		btn_back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View b) {
				((page0Activity)getBaseContext()).finish();
				
			}
		});
         btn_edit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View b) {
					
				Toast.makeText(page0Activity.this, "edit",
		    		        Toast.LENGTH_SHORT).show();
				
			}
		});
	}
	
}