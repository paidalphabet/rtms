package com.rtms.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtms.model.system.BaseBusinessObject;

public class BaseController<T extends BaseBusinessObject> {

	private final static GsonBuilder gsonBuilder = new GsonBuilder();
	
	protected Gson getGson() {
		final Gson gson = gsonBuilder.enableComplexMapKeySerialization().serializeNulls().create();
		return gson;
	}

	protected Object convertFromJson(final Class<T> clazz, final String data) {
		final Gson gson = getGson();
		final Object object = gson.fromJson(data, clazz);
		return object;
	}	
	
	protected String convertToJson(Object object){
		final Gson gson = getGson();
		final String jsonizedString = gson.toJson(object);
		return jsonizedString;
		
	}
}
