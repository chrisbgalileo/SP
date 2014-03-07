package com.example.demo3.data;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.demo3.BitmapLRUCache;
import com.example.demo3.R;
import com.example.demo3.activities.MainActivity;

public class ImageAdapter extends BaseAdapter {
	private ImageLoader imageLoader;
	private LayoutInflater inflater;
	private ArrayList<Image> dataArray;
	
	public ImageAdapter (Context context, ArrayList<Image> dataArray) {
		this.dataArray = dataArray;
		this.inflater = LayoutInflater.from(context);
		this.imageLoader = new ImageLoader(MainActivity.requestQueue,
								new BitmapLRUCache());
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dataArray.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		Image current = dataArray.get(position);
		if(convertView == null) {
			convertView = inflater.inflate(R.layout.grid_image, null);
			
			holder = new ViewHolder();
			holder.txtName = (TextView)convertView.findViewById(R.id.textName);
			holder.imgFlag = (NetworkImageView)convertView.findViewById(R.id.imageFlag);
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();			
		}
		holder.txtName.setText(current.getUserName());
		holder.imgFlag.setImageUrl(current.getImgUrl(), imageLoader);
		return convertView;
	}
	
	//Para no llamar tantas veces al arreglo
	static class ViewHolder {
		public TextView txtName;
		public NetworkImageView imgFlag;		
	}
	
	//Recalcular tama;o 
	public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight){
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(res, resId, options);
		
		options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
		
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeResource(res, resId, options);
		
		
	}

	//copiada de la documentacion de Android
	//ver tama;o imagen
	public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;
		
		if(height > reqHeight || width > reqWidth){
			final int heightRatio = Math.round((float) height/(float) reqHeight);
			final int widthRatio = Math.round((float) width/(float) reqWidth);
			
			inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;	
		}
		
		return inSampleSize;
	}
	
	
	
	
}
