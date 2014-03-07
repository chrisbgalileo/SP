package com.example.tareasemanal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tareasemanal.R;

public class PromotionsPager extends Fragment {
	public final static String IMAGES = "images";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.promotions_images, null);
		ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
		Bundle args = getArguments();
		
		imageView.setImageResource(args.getInt(IMAGES));
	
		return view;
	}

}
