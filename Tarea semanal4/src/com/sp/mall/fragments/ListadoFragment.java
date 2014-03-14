package com.sp.mall.fragments;

import java.util.ArrayList;

import com.sp.mall.R;
import com.sp.mall.R.id;
import com.sp.mall.R.layout;
import com.sp.mall.activities.DetailsActivity;
import com.sp.mall.activities.ImageActivity;

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

public class ListadoFragment extends Fragment {
	ListView lista;
	ArrayAdapter<String> adaptador;
	ArrayList<String> stores;
	Button btnImage;
    Intent intent = null;
		public View onCreateView(LayoutInflater inflater, ViewGroup container, 
		        Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.fragment_list, container, false);
		    stores = new ArrayList<String>();
		    lista = (ListView) view.findViewById(R.id.listView1);
		    this.addData();
			 adaptador = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, stores);
			 lista.setAdapter(adaptador);
			 lista.setTextFilterEnabled(true);
			 lista.setOnItemClickListener(new OnItemClickListener() {
					public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
						if(position==4){
							intent = new Intent(getActivity(),ImageActivity.class);
						}else{
							intent = new Intent(getActivity(),DetailsActivity.class);
							intent.putExtra(DetailsActivity.QUERY, (int)position);
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
		        stores.add("Tienda de mascotas");
		    }
		    
}