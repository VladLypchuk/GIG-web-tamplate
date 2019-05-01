// GET 
package suite;

import java.io.IOException;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CBT_RR_GET_API {

	private String username, authkey, suite;
	private JSONObject json;
	
	public CBT_RR_GET_API(String username, String authkey, String suite) {
		this. username = username;
		this. authkey = authkey;
		this. suite = suite;
		
}    

    public JSONObject testSuiteResults(String testSuiteID) throws UnirestException, IOException {
    	HttpResponse response = Unirest.get("http://crossbrowsertesting.com/api/v3/automation/suites/" + suite + "/runs/" + testSuiteID)
                .basicAuth(username, authkey)
    		    .asJson();


		String JsonString = response.getBody().toString();
		json = new JSONObject(JsonString);
		
		return json;
    }
    
}
