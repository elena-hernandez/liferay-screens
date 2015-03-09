/*
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.mobile.screens.testapp;

import android.os.Bundle;
import android.view.View;

import com.liferay.mobile.screens.assetlist.AssetEntry;
import com.liferay.mobile.screens.assetlist.AssetListScreenlet;
import com.liferay.mobile.screens.base.list.BaseListListener;
import com.liferay.mobile.screens.base.list.BaseListScreenlet;
import com.liferay.mobile.screens.ddl.list.DDLEntry;

import java.util.List;

/**
 * @author Javier Gamarra
 */
public class AssetListActivity extends ThemeActivity implements BaseListListener<AssetEntry> {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.asset_list);

		AssetListScreenlet screenlet = (AssetListScreenlet) getActiveScreenlet(R.id.asset_list_default,
				R.id.asset_list_material);

		screenlet.setClassNameId(getIntent().getIntExtra("classNameId", 10011));

		screenlet.setVisibility(View.VISIBLE);
		screenlet.setListener(this);
		screenlet.loadPage(0);

		hideInactiveScreenlet(R.id.asset_list_default, R.id.asset_list_material);
	}

	@Override
	public void onListPageFailed(BaseListScreenlet source, int page, Exception e) {
		error("Page request failed", e);
	}

	@Override
	public void onListPageReceived(BaseListScreenlet source, int page, List<AssetEntry> entries, int rowCount) {
		info("Page " + page + " received!");
	}

	@Override
	public void onListItemSelected(AssetEntry element) {
		info("Item selected: " + element);
	}
}