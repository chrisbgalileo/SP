package com.example.tareasemanal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tareasemanal.R;
public class DetalleFotografiaActivity extends FragmentActivity {
	TextView comment;
	ListView listView;
	ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_fotografia);	
		comment = (TextView)findViewById(R.id.comment_text); 
		listView = (ListView) findViewById(R.id.list_fragment); 
		adapter = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_1); 
		listView.setAdapter(adapter); 
		addcomment();
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
		case R.id.action_favorite:
			return true;
		case R.id.action_share:
			Uri urif = Uri.parse("res/drawable-mdpi/smash.png");
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_SEND);
			intent.putExtra(Intent.EXTRA_STREAM, urif);
			intent.setType("image/png");
			startActivity(Intent.createChooser(intent,  getString(R.string.action_share)));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	public void addcomment() { 
		Button btncall = (Button)findViewById(R.id.btn_comment); 
		btncall.setOnClickListener(new OnClickListener() { 
			@Override 
			public void onClick(View v) { 
				adapter.add(comment.getText().toString()); 
				adapter.notifyDataSetChanged(); 
			} 
		}); 
	}
	
	
	
}
