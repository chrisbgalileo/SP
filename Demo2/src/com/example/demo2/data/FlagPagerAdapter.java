package com.example.demo2.data;

import com.example.demo2.R;
import com.example.demo2.fragments.FlagFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FlagPagerAdapter extends FragmentPagerAdapter {
	private int[] arrayFlags = new int[]{
			R.drawable.sakura,
			R.drawable.sakuya,
			R.drawable.momiji,
			R.drawable.patch
	};;
	
	
	public FlagPagerAdapter(FragmentManager fm) {
		super(fm);
		
	}

	@Override
	public Fragment getItem(int position) {
		
		
		Fragment fragment = new FlagFragment();
		Bundle args = new Bundle();
		args.putInt(FlagFragment.RESOURCE, arrayFlags[position]);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int getCount() {
		return arrayFlags.length;
	}

}
