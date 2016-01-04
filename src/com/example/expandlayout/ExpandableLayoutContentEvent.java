package com.example.expandlayout;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class ExpandableLayoutContentEvent implements View.OnClickListener {
	private View contentView;
	private ImageButton playButton;
	private ImageButton pauseButton;
	private SeekBar     playSeekBar;
	
	public ExpandableLayoutContentEvent(View view) {
		this.contentView = view;
	}
	
	public void setClickEvent() {
		initButton(contentView);
	}
	
	private void initButton(View view) {
		playButton = (ImageButton)view.findViewById(R.id.mediaPlayerPlay);
		playSeekBar = (SeekBar)view.findViewById(R.id.mediaPlayerSeekBar);
		pauseButton = (ImageButton)view.findViewById(R.id.mediaPlayerPause);
		
		playButton.setOnClickListener(this);
		pauseButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.mediaPlayerPlay:
			Log.e("ZWY", "******************  media play");
			break;
		case R.id.mediaPlayerPause:
			Log.e("ZWY", "******************  media pause");
			break;
		default:
			break;
		}
	}
}
