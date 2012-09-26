package com.fernandomantoan.latinoware.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.fernandomantoan.latinoware.R;
import com.fernandomantoan.latinoware.model.Speech;

public class SpeechAdapter extends ArrayAdapter<Speech> {

	private Context context;
	private int textViewResourceId;
	private Speech[] objects;

	public SpeechAdapter(Context context, int textViewResourceId, Speech[] objects) {
		super(context, textViewResourceId, objects);
		this.context = context;
		this.textViewResourceId = textViewResourceId;
		this.objects = objects;
		
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = ((Activity) context).getLayoutInflater();
		View item = inflater.inflate(textViewResourceId, parent, false);
		
		Speech speech = objects[position];
		
		TextView title = (TextView) item.findViewById(R.id.speech);
		title.setText(speech.getTitle());
		
		TextView speaker = (TextView) item.findViewById(R.id.speaker);
		speaker.setText(speech.getSpeaker());
		
		TextView space = (TextView) item.findViewById(R.id.space);
		space.setText(speech.getSpace());
		
		TextView time = (TextView) item.findViewById(R.id.time);
		time.setText(speech.getTime().substring(0, speech.getTime().length() - 3));
		
		return item;
	}
}