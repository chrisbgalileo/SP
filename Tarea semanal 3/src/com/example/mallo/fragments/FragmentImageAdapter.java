package com.example.mallo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mallo.*;

public class FragmentImageAdapter extends FragmentPagerAdapter {
	private int[] arrayImage = new int[]{
			R.drawable.sx1,
			R.drawable.sx2,
			R.drawable.sx3,
			R.drawable.sx4,
			R.drawable.sx5,
			
	};
	public FragmentImageAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		
		Fragment fragment = new Pager();
		Bundle args = new Bundle();
		args.putInt(Pager.RESOURCE, arrayImage[arg0]);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arrayImage.length;
	}

}
