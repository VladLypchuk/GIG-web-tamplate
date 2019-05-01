# A3
## zero_send_send
there are 4 files to make API calls to trigger CBT Record & Replay tests Suite(s). POST req is made > response body cheched for object "is_finished": "true" that is false and then GET response triggered every 30sec to chech for the same value > once it true the body is validated for test cases score: Pass or Fail  : 
	- API POST
	- POST Test
	- API GET
	- GET Test