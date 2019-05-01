# A3
## zero_send_send
There are 4 files to make API calls to trigger CBT Record & Replay tests Suite(s). 
POST req is made > response body cheched for object "is_finished": "true" that is false 
and then GET response triggered every 30sec to chech for the same value > 
once it true the body is validated for test cases score: Pass or Fail: 
	- API POST
	- POST Test
	- API GET
	- GET Test

Also, there are two files for triggering Selenium/Java tests in CBT:
	- test body in TestNG
	- API file to set up Pass/Fail score in CBT