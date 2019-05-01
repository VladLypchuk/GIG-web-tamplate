package suite;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Getting_response_body_objects_Test {
	private Getting_response_body_objects_API apiB;
	
	@Test
	public void exec() throws UnirestException {
		String username = "max.stepanenko%40a3ventures.co";
        String authkey = "u84e143c026fbf01";
        String suite = "5ca63a7fb69e4a01a8ac0433";
        String suite_run_id = "5cc8b63d19156509f39908ab";

		
		apiB = new Getting_response_body_objects_API(username, authkey, suite, suite_run_id);
		apiB.getRequest();
	

	}
}
