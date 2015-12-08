package com.cksource;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cknotes.R;

public class NotesList extends ListActivity {

	private ArrayAdapter<String> adapter;
	
	String[] from = { "AS-201", "AS-203", "Apollo 11", "Apollo 12", "Apollo 13", "Apollo 14", "Apollo 15", "Apollo 17" };
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		adapter = new ArrayAdapter<String>(this,R.layout.notes_list_item, R.id.title, from);
		
		setListAdapter(adapter);
	}
	
	@Override 
	public void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(this, Editor.class);
	    startActivity(intent);
	}
}
