package com.cos.crossfit.util;




import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SmsApp  {

		
		public JSONObject send(String number, String content) {
			String api_key = "NCSGLMYLVJ8VRAQW";		// api_key와 api_secret은 외부에 공개되지 않도록 관리!
		    String api_secret = "DNPN4HXQNJLJBRXNV5B3DCVIC2S18N13";
		    Message coolsms = new Message(api_key, api_secret);

		    // 4 params(to, from, type, text) are mandatory. must be filled
		    HashMap<String, String> params = new HashMap<String, String>();
		    params.put("to", number);
		    params.put("from", "01027258574");
		    params.put("type", "SMS");
		    params.put("text", content);
		    params.put("app_version", "test app 1.2"); // application name and version

		    try {
		      JSONObject obj = (JSONObject) coolsms.send(params);
		      System.out.println(obj.toString());
		      
		      return obj;
		    } catch (CoolsmsException e) {
		      System.out.println(e.getMessage());
		      System.out.println(e.getCode());
		    }
		    return null;
		}

}