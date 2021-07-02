package poly.util;

import javax.servlet.http.HttpServletRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Fetch {
	public static JSONObject post(HttpServletRequest request, JSONObject obj ) {
		
		JSONObject result = new JSONObject();
		result.put("code", 0);
		result.put("message", "success");
		
		JSONArray arr = new JSONArray();
		
		result.put("result", arr);
		
		return result;
	}
}
