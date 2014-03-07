package com.example.tareasemanal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Pager extends FragmentPagerAdapter {
	private int[] arrayProm = new int[]{
			R.drawable.pro1,	
			R.drawable.pro2,
			R.drawable.pro3,
			R.drawable.pro4,
			R.drawable.pro5
		};
	
	public Pager(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		
		Fragment fragment = new PromotionsPager();
		Bundle args = new Bundle();
		args.putInt(PromotionsPager.IMAGES, arrayProm[position]);
		fragment.setArguments(args);
		return null;
	}

	@Override
	public int getCount() {
		return arrayProm.length;
	}

}
