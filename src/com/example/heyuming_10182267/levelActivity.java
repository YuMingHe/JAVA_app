package com.example.heyuming_10182267;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class levelActivity extends Activity{
	private ListView listview;
	private int[] imageid={R.drawable.page1,R.drawable.page2,R.drawable.page3,R.drawable.page4,R.drawable.page5,R.drawable.page6};
	private List<Letter> letterlist=new ArrayList<Letter>();
	
	public class Letter{
		private String letter_name;
		private int image_id;
		
		public Letter(String letter_name,int image_id){
			this.letter_name=letter_name;
			this.image_id=image_id;
		}
		
		public String getLetterName(){
			return letter_name;
		}
		
		public int getImageId(){
			return image_id;
		}
	}
	
	public class LetterAdapter extends ArrayAdapter<Letter>{
		private int resourceId;
		public LetterAdapter(Context context, int textViewResourceld,List<Letter>objects) {
			super(context, textViewResourceld,objects);
			resourceId=textViewResourceld;
			// TODO Auto-generated constructor stub
		}
		@Override
		public View getView(int position,View convertView,ViewGroup parent){
			Letter letter=getItem(position);
			View view=LayoutInflater.from(getContext()).inflate(resourceId, null);
			ImageView letter_image=(ImageView)view.findViewById(R.id.letter_image);
			TextView letter_name=(TextView)view.findViewById(R.id.letter_name);
			letter_image.setImageResource(letter.getImageId());
			letter_name.setText(letter.getLetterName());
			return view;
		}
	}
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level);
        initLetter();
        LetterAdapter adapter=new LetterAdapter(levelActivity.this,R.layout.letter_item,letterlist);
        listview=(ListView)findViewById(R.id.listview);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Letter letter=letterlist.get(position);
				Toast.makeText(levelActivity.this, letter.getLetterName(), Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(levelActivity.this, logActivity.class);
                intent.putExtra("detail_img", letter.getImageId());
				startActivity(intent);// TODO Auto-generated method stub
				
			}
        	
        });
        
        
	} 

	private void initLetter() {
		// TODO Auto-generated method stub
		Letter a =new Letter("1",R.drawable.page1);
    	letterlist.add(a);
    	Letter b =new Letter("2",R.drawable.page2);
    	letterlist.add(b);
    	Letter c =new Letter("3",R.drawable.page3);
    	letterlist.add(c);
    	Letter d =new Letter("4",R.drawable.page4);
    	letterlist.add(d);
    	Letter e =new Letter("5",R.drawable.page5);
    	letterlist.add(e);
    	Letter f =new Letter("6",R.drawable.page6);
    	letterlist.add(f);
    	
	}
}