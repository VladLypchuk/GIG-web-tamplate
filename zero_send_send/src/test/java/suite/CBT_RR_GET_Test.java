// GET test 
package suite;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

public class CBT_RR_GET_Test {
	
	private CBT_RR_GET_API apiA;
	private CBT_RR_POST_API api;
	
	@Test
	public void exec() throws UnirestException, IOException, InterruptedException {
		String username = "max.stepanenko%40a3ventures.co";
        String authkey = "u84e143c026fbf01";
        String suite = "5ca63a7fb69e4a01a8ac0433";
        	        
        // Post
        api = new CBT_RR_POST_API(username, authkey, suite);
        String id = api.testSuiteRun();
        
        System.out.println("GET test_run_id: " + id);
        System.out.println(" ");
		
        // Get
		apiA = new CBT_RR_GET_API(username, authkey, suite);
				
		JSONObject json = apiA.testSuiteResults(id);
				
		// Get is_finished value for first call
		Boolean isFinished = (Boolean) json.get("is_finished");
		
		// Validate whether Condition works
		System.out.println("Expecting to get \"is_finished: pass.\" And now we have: " + isFinished);
				
		// while loop runs until is_finished is true
		while(!isFinished) {
			
			System.out.println("So I Sleep for 30sec...zzz...zzz... ");
			
			// wait for 10 secs
			Thread.sleep(30000);
						
			// make get request
			json = apiA.testSuiteResults(id);
					
			// update 'is_finished' value
			isFinished = (Boolean) json.get("is_finished");
			
			// print message with values from response object 
			System.out.println("is_finished: " + json.get("is_finished"));
		}
		
		// Array
				JSONArray array = (JSONArray) json.get("replays");
				
				System.out.println("obj: " + array.get(0));
				
				JSONObject replayObj = (JSONObject) array.get(0);
				// "array body"
				System.out.println("Array body: " + replayObj);
				// "name" & "score"
				System.out.println("\"script_name:\" " + replayObj.get("script_name"));
				System.out.println("Expected \"score: pass\". Actual score is: " + replayObj.get("score"));
				
				Assert.assertEquals(replayObj.get("score"), "pass");
		
				
		
		}
	}


