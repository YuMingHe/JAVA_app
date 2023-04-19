package com.example.heyuming_10182267;

import java.util.ArrayList;
import java.util.List;

import com.example.heyuming_10182267.levelActivity.LetterAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

public class chat extends Activity{
	
	private List<Msg>msgList = new ArrayList<Msg>();
	private EditText edit_chat;
	private ListView list_chat;
	private Button send;
	
	public class Msg{
		public static final int TYPE_RECEIVED = 0;
		public static final int TYPE_SENT = 1;
		public String content;
		public int type;
		
		public Msg(String content,int type){
			this.content = content;
			this.type = type;
		}
		
		public String getContent(){
			return content;
		}
		
		public int getType(){
			return type;
		}
	}
	
	public class MsgAdapter extends ArrayAdapter<Msg>{
		private int resourceId;
		
		public MsgAdapter(Context context, int textViewResourceId, List<Msg>objects){
			super(context, textViewResourceId, objects);
			resourceId = textViewResourceId;
		}
		
		public View getView(int position, View convertView, ViewGroup parent){
			Msg msg = getItem(position);
			View view;
			ViewHolder viewHolder;
			if(convertView == null){
				view = LayoutInflater.from(getContext()).inflate(resourceId, null);
				viewHolder = new ViewHolder();
				viewHolder.leftLayout = (LinearLayout)view.findViewById(R.id.left_layout);
				viewHolder.rightLayout = (LinearLayout)view.findViewById(R.id.right_layout);
				viewHolder.leftMsg = (TextView)view.findViewById(R.id.left_msg);
				viewHolder.rightMsg = (TextView)view.findViewById(R.id.right_msg);
				view.setTag(viewHolder);
			}
			else{
				view = convertView;
				viewHolder = (ViewHolder)view.getTag();
			}
			if(msg.getType()==Msg.TYPE_RECEIVED){
				viewHolder.leftLayout.setVisibility(View.VISIBLE);
				viewHolder.rightLayout.setVisibility(View.GONE);
				viewHolder.leftMsg.setText(msg.getContent());
			}
			else if(msg.getType()==Msg.TYPE_SENT){
				viewHolder.leftLayout.setVisibility(View.GONE);
				viewHolder.rightLayout.setVisibility(View.VISIBLE);
				viewHolder.rightMsg.setText(msg.getContent());
			}
			return view;
		}
		
		class ViewHolder{
			LinearLayout leftLayout;
			LinearLayout rightLayout;
			TextView leftMsg;
			TextView rightMsg;
		}
		
	}
	
	 protected void onCreate(Bundle savedInstanceState){
		 
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.chat);
		 initMsg();
		 MsgAdapter adapter=new MsgAdapter(chat.this,R.layout.msg_item,msgList);
	     edit_chat=(EditText)findViewById(R.id.edit_text_chat);
	     send=(Button)findViewById(R.id.button_chat);
	     list_chat=(ListView)findViewById(R.id.listview_chat);
	     
	     send.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View b) {
					String inputText = edit_chat.getText().toString();	
					Msg msg3 = new Msg(inputText,Msg.TYPE_SENT);
					 msgList.add(msg3);
					 MsgAdapter adapter=new MsgAdapter(chat.this,R.layout.msg_item,msgList);
					 list_chat=(ListView)findViewById(R.id.listview_chat);
					 list_chat.setAdapter(adapter);
					 edit_chat.setText("");
				}
		});
	     list_chat.setAdapter(adapter);
	 }
	
	 private void initMsg(){
		 Msg msg1 = new Msg("你好，我是安卓机器人！",Msg.TYPE_RECEIVED);
		 msgList.add(msg1);
		 Msg msg2 = new Msg("^-^!",Msg.TYPE_SENT);
		 msgList.add(msg2);
	 }
}
