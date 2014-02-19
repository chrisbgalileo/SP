package com.example.tareasemanal;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;



public class MainActivity extends ListActivity {
	Button btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new ButtonListener());
		
		
		//Array con el nombre de las tiendas
		String[] nombres = new String[] {
				"Tienda de Lego",
				"Tienda de comida",
				"Tienda de anime :D",
				"Tienda de videojuegos"				
		};
		
		//Adaptador 
		ListAdapter adaptador = new ArrayAdapter<String>
								(this, android.R.layout.simple_list_item_1,
								nombres);
		//Asociamos el adaptador a la vista
		
		ListView lv = (ListView)findViewById(android.R.id.list);
		lv.setAdapter(adaptador);
		
		
	}

	@Override
	protected void onListItemClick(ListView l, View v,
									int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		String tiendaText = l.getItemAtPosition(position).toString();
		Intent intent = new Intent(getApplicationContext(),
								InfoTiendaActivity.class);
		intent.putExtra(InfoTiendaActivity.QUERY, tiendaText);
		startActivity(intent);
		
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class ButtonListener implements OnClickListener {

		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(getApplicationContext(),
									DetalleFotografiaActivity.class);
			startActivity(intent);
		}

		}


}
