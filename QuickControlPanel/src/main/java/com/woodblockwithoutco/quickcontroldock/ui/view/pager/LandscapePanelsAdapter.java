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
package com.woodblockwithoutco.quickcontroldock.ui.view.pager;


import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class LandscapePanelsAdapter extends PagerAdapter {
	
	public List<View> mViews;
	
	public LandscapePanelsAdapter(List<View> views) {
		mViews = views;
	}

	@Override
	public int getCount() {
		return mViews.size();
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int pos) {
		container.addView(mViews.get(pos));
		return mViews.get(pos);
	}

	@Override
	public boolean isViewFromObject(View v, Object o) {
		return v.equals(o);
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(mViews.get(position));
	}

}
