package com.example.mallo.fragments;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.mallo.activities.InfoTiendaActivity;
import com.example.mallo.activities.DetalleFotografiaActivity;
import com.sp.mall.R;

public class ListFragment extends Fragment {
	ListView list;
	ArrayAdapter<String> adaptador;
	ArrayList<String> stores;
	Button btnImage;
    Intent intent = null;
		public View onCreateView(LayoutInflater inflater, ViewGroup container, 
		        Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.list_fragment, container, false);
		    stores = new ArrayList<String>();
		    list = (ListView) view.findViewById(R.id.listView1);
		    this.addData();
			 adaptador = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, stores);
			 list.setAdapter(adaptador);
			 list.setTextFilterEnabled(true);
			 list.setOnItemClickListener(new OnItemClickListener() {
					public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
						if(position==4){
							intent = new Intent(getActivity(),DetalleFotografiaActivity.class);
						}else{
							intent = new Intent(getActivity(),InfoTiendaActivity.class);
							intent.putExtra(InfoTiendaActivity.QUERY, (int)position);
						}
							
							startActivity(intent);
			        }
			 });
			return view;
		    }
		
		
		 public void addData(){
		        stores.add("Tienda de Lego"); 
		        stores.add("Tienda de comida"); 
		        stores.add("Tienda de anime :3"); 
		        stores.add("Tienda de Cartas");
		        stores.add("Imagen");
		    }
		    
}
