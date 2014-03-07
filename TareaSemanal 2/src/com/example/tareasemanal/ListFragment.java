package com.example.tareasemanal;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ListFragment extends Fragment implements OnItemClickListener {
	ListView list;
	Button btn;


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		btn = (Button)getView().findViewById(R.id.btn);
		btn.setOnClickListener(new ButtonListener());
		
		//Array con el nombre de las tiendas
		String[] nombres = new String[] {
				"Tienda de Lego",
				"Tienda de comida",
				"Tienda de anime :D",
				"Tienda de videojuegos"				
		};
		
		ArrayList<String> arrayNombres = new ArrayList<String>(Arrays.asList(nombres));
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayNombres);
	
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
	}

	
	
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.list_fragment, container, false);
		
		list = (ListView)view.findViewById(android.R.id.list);
		return view;
	}





	@Override
	public void onItemClick(AdapterView<?> adapterView, View v,
									int position, long id) {		
		String tiendaText = adapterView.getItemAtPosition(position).toString();
		Intent intent = new Intent(getActivity(),
								InfoTiendaActivity.class);
		intent.putExtra(InfoTiendaActivity.QUERY, tiendaText);
		startActivity(intent);
		
		
	}
	
	
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// Inflate the menu; this adds items to the action bar if it is present.
		inflater.inflate(R.menu.main, menu);
	}
	
	class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(getView().getContext().getApplicationContext(),
									DetalleFotografiaActivity.class);
			startActivity(intent);
		}

	}

}
