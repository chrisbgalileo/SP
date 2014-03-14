package com.example.mallo.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mallo.fragments.ComunityFragment;
import com.example.mallo.fragments.Content_Fragment;
import com.example.mallo.fragments.Prom;
import com.example.mallo.*;;



public class MainActivity extends ActionBarActivity{
	private ListView drawerList;
	private DrawerLayout drawerLayout;
	private String[] drawerOptions ;
	private Fragment[] fragments = new Fragment[]{new Prom(),new Content_Fragment(), new ComunityFragment()};
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         drawerList = (ListView) findViewById(R.id.leftDrawer);
     	 drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
     	 drawerOptions = getResources().getStringArray(R.array.drawer_options);
     	 drawerList.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.drawer_items,drawerOptions));
     	 drawerList.setItemChecked(0, true);
     	 drawerList.setOnItemClickListener(new DrawerItemClickListener());
     	 FragmentManager manager = getSupportFragmentManager();
     	 manager.beginTransaction().add(R.id.contentFrame, fragments[0]).show(fragments[0])
     	 						   .add(R.id.contentFrame,fragments[1]).hide(fragments[1])
     	 						   .add(R.id.contentFrame,fragments[2]).hide(fragments[2])
     	 						   .commit();
     	ActionBar actionbar = getSupportActionBar();
     	actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
     	actionbar.setTitle(drawerOptions[0]);
    }
  public void setContent(int index){
	    Fragment toHide = null;
	    Fragment toHide2 = null;
		Fragment toShow = null;
		ActionBar actionbar = getSupportActionBar();
		switch (index) {
		case 0:
			toHide2 = fragments[2];
			toHide = fragments[1];
			toShow = fragments[0];
			actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
			break;
		case 1:
			toHide2 = fragments[2];
			toHide = fragments[0];
			toShow = fragments[1];
			actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
					break;
		case 2:
			toHide = fragments[0];
			toHide2 = fragments[1];
			toShow = fragments[2];
			actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
			break;
		}
		actionbar.setTitle(drawerOptions[index]);
		FragmentManager manager = getSupportFragmentManager();
		manager.beginTransaction().hide(toHide).hide(toHide2).show(toShow).commit();	
		drawerList.setItemChecked(index, true);
		drawerLayout.closeDrawer(drawerList);
  }
  class DrawerItemClickListener implements ListView.OnItemClickListener{

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		setContent(position);
		
	}
	  
  }
    public boolean onCreateOptionsMenu(Menu menu) {
  		// Inflate the menu; this adds items to the action bar if it is present.
  		getMenuInflater().inflate(R.menu.main, menu);
  		return true;
  	}
}