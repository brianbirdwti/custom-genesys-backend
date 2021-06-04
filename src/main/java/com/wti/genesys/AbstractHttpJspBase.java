package com.wti.genesys;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.runtime.HttpJspBase;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("serial")
public abstract class AbstractHttpJspBase extends HttpJspBase {

	public final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	public abstract Map<String, Object> executeRequest(Map<String, String> params);
	public void executeRequest(JSONObject state, Map<String, String> additionalParams) {
		executeRequest(additionalParams);
	}

	@Override
	public void _jspService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	
}
