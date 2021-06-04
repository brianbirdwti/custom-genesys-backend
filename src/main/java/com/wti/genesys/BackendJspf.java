package com.wti.genesys;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.genesyslab.studio.backendlogic.GVPHttpRequestProcessor;

public class BackendJspf {

		static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
		
		static Logger LOGGER = LogManager.getLogger("backend");
		
		public static void getResult(final AbstractHttpJspBase self, final HttpServletRequest request, final HttpServletResponse response) throws IOException {
			
			PrintWriter printWriter = response.getWriter();
			try {
				
				//TODO Add other response headers if desired
				response.setHeader("Content-Type", "application/json");
				
				GVPHttpRequestProcessor gvpHttpRequestProcessor = new GVPHttpRequestProcessor(request);
				gvpHttpRequestProcessor.parseRequest();
				
				//TODO Optionally, we can update AbstractHttpJspBase to accept other variables provided
				// by GVPHttpRequestProcessor such as JSONObject returned from  'getState()'
				self.executeRequest(gvpHttpRequestProcessor.getAdditionalParams());
				
				Map<String, Object> performLogicResult = null;
				String json = OBJECT_MAPPER.writeValueAsString(performLogicResult);
				
				if(LOGGER.isDebugEnabled()) {
					LOGGER.debug(json);
				}
				
				printWriter.print(json);
				
			} catch (Exception exception) {
				LOGGER.error(exception);
				printWriter.print(" {\"errorMsg\":\"Error:" + exception.getMessage() + "\"}  ");
			}
			
		}
	
}
