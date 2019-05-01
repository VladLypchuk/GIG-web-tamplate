package suite;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CBT_Selenium_API {
    private String username, authkey;

    public CBT_Selenium_API(String username, String authkey) {
        this.username = username; // Your username
        this.authkey = authkey; // Your authkey
    }

    public void setScore(String score, String seleniumSessionId) throws UnirestException {
        HttpResponse response = Unirest.put("http://crossbrowsertesting.com/api/v3/selenium/{seleniumSessionId}")
                            .basicAuth(username, authkey)
                            .routeParam("seleniumSessionId", seleniumSessionId)
                            .field("action","set_score")
                            .field("score", score)
                            .asJson();                                       
    }

    public void record_video(String seleniumSessionId) throws UnirestException {
        HttpResponse response = Unirest.post("http://crossbrowsertesting.com/api/v3/selenium/{seleniumSessionId}/videos")
                            .basicAuth(username, authkey)
                            .routeParam("seleniumSessionId", seleniumSessionId)
                            .asJson();                                                                                            
    }
    
    public void snapshot_data(String seleniumSessionId) throws UnirestException {
    	HttpResponse response = Unirest.post("http://crossbrowsertesting.com/api/v3/selenium/{seleniumSessionId}/snapshots")
			    			.basicAuth(username, authkey)
			                .routeParam("seleniumSessionId", seleniumSessionId)
			                .asJson(); 
    }
}
