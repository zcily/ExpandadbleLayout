package com.example.expandlayout;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ExpandableLayoutAdapter extends BaseAdapter {

	private LayoutInflater mInflater = null;
	private ArrayList<HashMap<String, Object>> mData = null;
	private Context mContext;
	
    public static final String FILE_NAME = "fileName";
    public static final String FILE_DATE = "fileDate";
    public static final String FILE_DURATION = "fileDurantion";
    public static final String FILE_PATH = "filePath";

	public final int DEFAULT_SHOW_ITEMS = 10;
	
	public ExpandableLayoutAdapter(Context context, ArrayList<HashMap<String, Object>> data) {
		this.mInflater = LayoutInflater.from(context);
		this.mData = data;
		this.mContext = context;

		if(mData == null)
			mData = new ArrayList<HashMap<String, Object>>();
		
		if(mData == null || mData.size() == 0) {
			setEmptyListViewData();
		}
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mData != null ? (mData.size() < DEFAULT_SHOW_ITEMS ? DEFAULT_SHOW_ITEMS : mData.size()) : DEFAULT_SHOW_ITEMS;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		
		if(convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.view_row, null);
			holder.fileName = (TextView)convertView.findViewById(R.id.file_name);
			holder.fileDate = (TextView)convertView.findViewById(R.id.file_date);
			holder.fileTime = (TextView)convertView.findViewById(R.id.file_time);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder)convertView.getTag();
		}
		
		if(mData != null && position < mData.size()) {
			holder.fileName.setText((String)mData.get(position).get(FILE_NAME));
			holder.fileDate.setText((String)mData.get(position).get(FILE_DATE));
			holder.fileTime.setText((String)mData.get(position).get(FILE_DURATION));
			
/*			final String filename = (String)mData.get(position).get(FILE_PATH);
			convertView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				}
			});*/
		} else {
			holder.fileName.setText("");
			holder.fileDate.setText("");
			holder.fileTime.setText("");
		}
		return convertView;
	}
	
	private void setEmptyListViewData(){
    	HashMap<String, Object> map = new HashMap<String, Object>();
    	map.put("fileName", "empty list");
    	map.put("fileDate", "");
    	map.put("fileTime", "");
    	mData.add(map);
	}
	
	public final class ViewHolder {
		public TextView fileName;
		public TextView fileDate;
		public TextView fileTime;
	}
}
