/**
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

package com.liferay.mobile.screens.ddl.model;

import com.liferay.mobile.screens.ddl.XSDParser;

import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


/**
 * @author Jose Manuel Navarro
 */
public class Record {

	public Record(String xsd, Locale locale) throws SAXException {
		XSDParser parser = new XSDParser();

		_fields = parser.parse(xsd, locale);

		if (_fields == null) {
			_fields = new ArrayList<>();
		}
		else {
			_locale = locale;
		}
	}

	public Field getField(int index) {
		return _fields.get(index);
	}

	public int getFieldCount() {
		return _fields.size();
	}

	public long getRecordSetId() {
		return _recordSetId;
	}

	public long getRecordId() {
		return _recordId;
	}

	public long getCreatorUserId() {
		return _creatorUserId;
	}

	public Map<String, String> getValues() {
		Map<String, String> values = new HashMap<>(_fields.size());

		for (Field f : _fields) {
			String fieldValue = f.toString();

			if (fieldValue != null && !fieldValue.isEmpty()) {
				values.put(f.getName(), fieldValue);
			}
		}

		return values;
	}

	public void setRecordId(long recordId) {
		_recordId = recordId;
	}

	public void setCreatorUserId(long value) {
		_creatorUserId = value;
	}

	private List<Field> _fields;
	private long _creatorUserId;
	private long _recordSetId;
	private long _recordId;
	private Locale _locale;

}