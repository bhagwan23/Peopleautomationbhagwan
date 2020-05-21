package deskera.web.automation.core;

import java.util.ArrayList;
import java.util.List;

import deskera.web.automation.utils.ReadPropertyUtil;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TestRailUpdator {
	static Response resultResponse;
	public List<Header> headerlist = new ArrayList<Header>();
	public Response resp1, resp;
	public Headers headers = new Headers(headerlist);
	int count = 0;

	
	/**
	 * Desc - Update Testrail via API
	 * @param testResult
	 * @param testId
	 * @param runId
	 */
	public void UpdateTestCaseResult(String testResult, String testId, String runId) {
		System.out.println("Inside UpdateTestCaseResult");
		String userEmail = ReadPropertyUtil.readProperty("userEmail", "src/test/resources/testRail.config");
		String userPass = ReadPropertyUtil.readProperty("userPass", "src/test/resources/testRail.config");
		String testrailURL = ReadPropertyUtil.readProperty("testrailURL", "src/test/resources/testRail.config");
		RestAssured.baseURI = testrailURL;
		System.out.println("runid" + runId);
		if (count < 1) {
			resp1 = RestAssured.given().auth().preemptive().basic(userEmail, userPass).body(testResult)
					.contentType("application/json").accept("application/json").when()
					.post("index.php?/api/v2/add_result_for_case/" + runId + "/" + testId + "");
			System.out.println("resp1" + resp1.asString());
			count = 1;
		}
	}
}
