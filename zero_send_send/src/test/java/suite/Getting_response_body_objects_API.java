package suite;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Getting_response_body_objects_API {

	private String username, authkey, suite, suite_run_id;
	private JSONObject json;
	
	public Getting_response_body_objects_API(String username, String authkey, String suite, String suite_run_id) {
		this. username = username;
		this. authkey = authkey;
		this. suite = suite;
		this. suite_run_id = suite_run_id;
		
}    

    public void getRequest() throws UnirestException {
    	HttpResponse response = Unirest.get("http://crossbrowsertesting.com/api/v3/automation/suites/" + suite + "/runs/" + suite_run_id)
                .basicAuth(username, authkey)
    		    .asJson();    	
		
		String JsonString = response.getBody().toString();		
		
		JSONObject json = new JSONObject(JsonString);
		
		// "suite_run_id"
		String suite_run_id = (String) json.get("suite_run_id");		
		System.out.println("suite_run_id: " + suite_run_id);
		
		// Array
		JSONArray array = (JSONArray) json.get("replays");
		
		System.out.println("obj: " + array.get(0));
		
		JSONObject replayObj = (JSONObject) array.get(0);
		// "array body"
		System.out.println("Array body: " + replayObj);
		// "name" & "score"
		System.out.println("\"script_name:\" " + replayObj.get("script_name"));
		System.out.println("\"score:\" " + replayObj.get("score"));
		
		Assert.assertEquals("fail", replayObj.get("score"));

    }
}
