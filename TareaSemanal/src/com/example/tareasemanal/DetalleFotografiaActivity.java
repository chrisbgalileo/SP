package com.example.tareasemanal;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class DetalleFotografiaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_fotografia);
		TextView comentario = (TextView)findViewById(R.id.comentario);
		comentario.setText("Comentarios que comentan los comentarios comentariados");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detalle_fotografia, menu);
		return true;
	}

}
