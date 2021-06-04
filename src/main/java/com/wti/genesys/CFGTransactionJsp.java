package com.wti.genesys;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class CFGTransactionJsp extends AbstractHttpJspBase {

	@Override
	public Map<String, Object> executeRequest(Map<String, String> params) {

		Map<String, Object> result = new HashMap<String, Object>();
		
		// Call your transactions jar code here.
		result.put("Peg", "Peg name");
		result.put("Response", "Response from transaction jar");
		
		return result;
	
	}


}
