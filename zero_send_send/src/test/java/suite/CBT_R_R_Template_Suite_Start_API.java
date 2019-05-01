package suite;

import java.io.IOException;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CBT_R_R_Template_Suite_Start_API {
	private static String username;
	private static String authkey;
	private static String suite;
	
	public CBT_R_R_Template_Suite_Start_API (String username, String authkey, String suite) {
		this. username = username;
		this. authkey = authkey;
		this. suite = suite;
}   

    public static String testSuiteRun() throws UnirestException, IOException {
    	HttpResponse response = Unirest.post("http://crossbrowsertesting.com/api/v3/automation/suites/" + suite + "/runs")
                .basicAuth(username, authkey)
    		    .asJson();


		System.out.println("POST response body: " + response.getBody().toString());
		
		String JsonString = response.getBody().toString();
		
		JSONObject json = new JSONObject(JsonString);

		
		String suite_run_id = (String) json.get("suite_run_id");
        System.out.println(" ");
		System.out.println("POST suite_run_id: " + suite_run_id);

		
//		suiteRunID = suite_run_id;
		
		return suite_run_id;

    }
    
//    public static String getSuiteRunID() {
//    	return suiteRunID;
//    }
}
