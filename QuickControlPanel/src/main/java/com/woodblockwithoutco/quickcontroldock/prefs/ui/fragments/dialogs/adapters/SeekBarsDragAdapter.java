/*******************************************************************************
 * Copyright 2014 Alexander Leontyev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.woodblockwithoutco.quickcontroldock.prefs.ui.fragments.dialogs.adapters;

import java.util.List;

import com.woodblockwithoutco.quickcontroldock.model.seekbar.SeekbarType;
import com.woodblockwithoutco.quickcontroldock.prefs.resolvers.TogglesResolver;
import com.woodblockwithoutco.quickcontroldock.R;



import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SeekBarsDragAdapter extends ArrayAdapter<String> {

	private static final int COLOR_WHITE = 0xFFFFFFFF;
	private static final int COLOR_GRAY = 0xFF909090;

	
	private List<String> mList;
	
	public SeekBarsDragAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
		super(context, resource, textViewResourceId, objects);
		mList = objects;
	}
	
	public List<String> getList() {
		return mList;
	}
	
	private void refreshEnabledState(View v, int position) {
		boolean isSeekbarEnabled = isSeekbarEnabled(position);
		setItemEnabled(v, isSeekbarEnabled);
	}
	
	private void setItemEnabled(View v, boolean enabled) {
		TextView tv = (TextView) v.findViewById(R.id.list_item_text);
		ImageView iv = (ImageView) v.findViewById(R.id.list_item_image);
		if(enabled) {
			tv.setTextColor(COLOR_WHITE);
			iv.setColorFilter(COLOR_WHITE, PorterDuff.Mode.SRC_ATOP);
		} else {
			tv.setTextColor(COLOR_GRAY);
			iv.setColorFilter(COLOR_GRAY, PorterDuff.Mode.SRC_ATOP);
		}
	}
	
	private boolean isSeekbarEnabled(int position) {
		String stringType = getItem(position);
		SeekbarType type = SeekbarType.valueOf(stringType);
		return TogglesResolver.isSeekbarUsed(getContext(), type);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder;
		
		View rowView = convertView;
		if(rowView == null) {
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflater.inflate(R.layout.toggles_list_item, parent, false);
			holder = new ViewHolder();
			holder.textView = (TextView) rowView.findViewById(R.id.list_item_text);
			holder.imageView = (ImageView) rowView.findViewById(R.id.list_item_image);
			rowView.setTag(holder);
			refreshEnabledState(rowView, position);
		} else {
			holder = (ViewHolder) rowView.getTag();
			refreshEnabledState(rowView, position);
		}
		
		String stringType = getItem(position);
		SeekbarType type = SeekbarType.valueOf(stringType);
		
		int stringId = R.string.toggles_seekbar_brightness;
		int drawableId = R.drawable.brightness_full;
		
		
		switch(type) {
		case BRIGHTNESS:
			stringId = R.string.toggles_seekbar_brightness;
			drawableId = R.drawable.brightness_full;
			break;
		case MEDIA_VOLUME:
			stringId = R.string.toggles_seekbar_media;
			drawableId = R.drawable.music;
			break;
		case RINGER_VOLUME:
			stringId = R.string.toggles_seekbar_ringer;
			drawableId = R.drawable.ringer;
			break;
		}
		Drawable iconDrawable = getContext().getResources().getDrawable(drawableId);
		iconDrawable.setColorFilter(COLOR_WHITE, PorterDuff.Mode.SRC_ATOP);

		holder.textView.setText(getContext().getString(stringId));
		holder.imageView.setImageDrawable(iconDrawable);
		return rowView;
	}
	
	static class ViewHolder {
		TextView textView;
		ImageView imageView;
	}

}
