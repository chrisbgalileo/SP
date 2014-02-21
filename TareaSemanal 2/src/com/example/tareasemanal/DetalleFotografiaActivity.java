package com.example.tareasemanal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DetalleFotografiaActivity extends FragmentActivity {
	TextView comentario;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_fotografia);
		comentario = (TextView)findViewById(R.id.editText1);
		comentario.setText("Comentarios que comentan los comentarios comentariados");
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

/*	@Override
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
	*/
	
	
}
