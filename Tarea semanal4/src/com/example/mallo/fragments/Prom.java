package com.example.mallo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sp.mall.R;

public class Prom extends Fragment {
	ViewPager viewpager;
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		FragmentImageAdapter adapter = new FragmentImageAdapter(getChildFragmentManager());
		viewpager.setAdapter(adapter);
	}

	public Prom() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.promotions_viewpager, container,false);
		viewpager = (ViewPager) view.findViewById(R.id.pager);
		return view;
	}

}
