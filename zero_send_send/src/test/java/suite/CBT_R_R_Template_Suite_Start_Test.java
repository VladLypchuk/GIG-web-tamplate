package suite;

import java.io.IOException;
import org.testng.annotations.Test;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CBT_R_R_Template_Suite_Start_Test {
	
	private CBT_R_R_Template_Suite_Start_API api;
	
	@Test
	public void exec() throws UnirestException, IOException {
		String username = "max.stepanenko%40a3ventures.co";
        String authkey = "u84e143c026fbf01";
        String suite = "5ca63a7fb69e4a01a8ac0433";
        		
	        api = new CBT_R_R_Template_Suite_Start_API(username, authkey, suite);
			
	        api.testSuiteRun();	
	}
	
}
 