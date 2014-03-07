package com.example.tareasemanal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Prom extends Fragment {
	ViewPager viewPager;
	
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Pager adapter = new Pager(getChildFragmentManager());
		viewPager.setAdapter(adapter);
		
	}



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.promotions_images, container, false);
		viewPager = (ViewPager)view.findViewById(R.id.pager);
		return view;
	}

}
