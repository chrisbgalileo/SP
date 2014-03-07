package com.example.tareasemanal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class InfoTiendaActivity extends FragmentActivity {
	
	Button call_btn;
	String tel = "00000000";
	private String queryText = "";
	public static final String QUERY = "query";
	
	TextView comment;
	ListView listView;
	ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info_tienda);
		
		call_btn = (Button) findViewById(R.id.call_btn);
		call_btn.setOnClickListener(new ButtonListener());
		
		Intent intent = getIntent();
		queryText = intent.getStringExtra(QUERY);
		if(queryText != null) {
			TextView txtMsg = (TextView)findViewById(R.id.txtMsg);
			if(queryText.equals("Tienda de Lego")) {
				txtMsg.setText(queryText  + "\n 1600 Amphitheatre Pkwy, Mountain View, CA 94043, Estados Unidos \n 12345678 \n Horarios: \n Lunes 10:00 a.m. - 10:00 p.m. \n Website: http://fireemblemwod.net \n Email: chitosabt@gmail.com");
				tel = "12345678";
			} else if(queryText.equals("Tienda de comida")) {
				txtMsg.setText(queryText  + "\n 14 avenida 0-14 zona 10 \n 87654321 \n Horarios: \n Martes 12:00 a.m. - 12:00 p.m. \n Website: http://google.com \n Email: chitosabt@gmail.com");
				tel = "87654321";
			} else if(queryText.equals("Tienda de anime :D")) {
				txtMsg.setText(queryText  + "\n 15 avenida 45-60 zona 15 \n 45365088 \n Horarios: \n Jueves 1:00 a.m. - 1:00 p.m. \n Website: http://fireemblemwod.net \n Email: chitosabt@gmail.com");
				tel = "45365088";	
			} else {
				txtMsg.setText(queryText);
			}
			Linkify.addLinks(txtMsg, Linkify.ALL);
			
		}
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
			if(!queryText.equals("")) {
				String url = "Te comparto " + queryText;
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_SEND);
				intent.putExtra(Intent.EXTRA_TEXT, url);
				intent.setType("text/plain");
				startActivity(Intent.createChooser(intent,  getString(R.string.action_share)));
				
			}
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

class ButtonListener implements OnClickListener {

	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tel));
		startActivity(intent);
	}

	}

}