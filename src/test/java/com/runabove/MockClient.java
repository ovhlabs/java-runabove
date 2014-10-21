package com.runabove;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import retrofit.client.Client;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedOutput;

/*
 * Copyright (c) 2014, OVH

 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.

 * Except as contained in this notice, the name of OVH and or its trademarks
 * (and among others RunAbove) shall not be used in advertising or otherwise to
 * promote the sale, use or other dealings in this Software without prior
 * written authorization from OVH.
 * Unit test for run above api
 * 
 * 
 * 
 * this mock class simulates the api responses to different calls
 * 
 * 
 */
/**
 * The Class MockClient.
 */
public class MockClient implements Client {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(ApiTest.class);

	/* (non-Javadoc)
	 * @see retrofit.client.Client#execute(retrofit.client.Request)
	 */
	public Response execute(Request request) throws IOException {
		String uri = request.getUrl().replaceAll("https:\\/\\/api\\.runabove\\.com\\/1\\.0", "");
		String responseString = "";
		String requestBody = null;

		
		if (request.getBody() != null) {
			requestBody = typedOutputToString(request.getBody());
		}

		if (uri.equals("/me")) {
			responseString = "{\n" + "			  \"firstname\": \"jon\",\n" + "			  \"country\": \"FR\",\n" + "			  \"area\": null,\n" + "			  \"twitter\": null,\n"
					+ "			  \"status\": \"validationPending\",\n" + "			  \"cellNumber\": \"+33.1122334455\",\n" + "			  \"name\": \"jon\",\n"
					+ "			  \"email\": \"jon@gmail.com\",\n" + "			  \"accountIdentifier\": \"jon@gmail.com\",\n" + "			  \"city\": null,\n"
					+ "			  \"address\": null,\n" + "			  \"postalCode\": null\n" + "			}";

		} else if (uri.equals("/me/usage?billed=true&from=2014-04-19&to=2014-04-19")) {
			responseString = "[\n" + "  {\n" + "    \"projectId\": \"1ac37bc7014643dab564256d1857b098\",\n" + "    \"region\": \"BHS-1\",\n"
					+ "    \"details\": [\n" + "      {\n" + "        \"storageDetails\": 0,\n" + "        \"bandwidthInstanceDetails\": [\n" + "          {\n"
					+ "            \"quantity\": 1493,\n" + "            \"id\": \"47530dbc-8929-42b6-b221-9ae437665031\"\n" + "          }\n" + "        ],\n"
					+ "        \"instance\": 230000,\n" + "        \"bandwidthStorage\": null,\n" + "        \"bandwidthStorageDetails\": null,\n"
					+ "        \"to\": \"2014-04-19T01:00:00-04:00\",\n" + "        \"bandwidthInstance\": null,\n" + "        \"instanceDetails\": [\n"
					+ "          {\n" + "            \"reference\": \"pci2.d.c1\",\n" + "            \"ids\": [\n"
					+ "              \"47530dbc-8929-42b6-b221-9ae437665031\"\n" + "            ]\n" + "          }\n" + "        ],\n"
					+ "        \"from\": \"2014-04-19T00:00:00-04:00\",\n" + "        \"storage\": 0,\n" + "        \"isBilled\": true\n" + "      }\n"
					+ "    ]\n" + "  }\n" + "]";
		} else if (uri.equals("/ssh")) {
			responseString = "[\n" + "{\n" + "\"publicKey\": \"ssh-rsa very-strong-key1 key-comment\",\n" + "\"name\": \"TestKey1\",\n"
					+ "\"fingerPrint\": \"aa:aa:aa:aa:aa:aa:aa:aa:aa:aa:aa:aa:aa:aa:aa:a1\",\n" + "\"region\": \"BHS-1\"\n" + "},\n" + "{\n"
					+ "\"publicKey\": \"ssh-rsa very-strong-key2 key-comment\",\n" + "\"name\": \"TestKey2\",\n"
					+ "\"fingerPrint\": \"aa:aa:aa:aa:aa:aa:aa:aa:aa:aa:aa:aa:aa:aa:aa:a2\",\n" + "\"region\": \"BHS-1\"\n" + "}\n" + "]";
		} else if (uri.equals("/project")) {
			responseString = "[\"Project-1\", \"Project-2\"]";
		} else if (uri.equals("/token")) {
			responseString = "{\n" + "\"token\": {\n" + "\"catalog\": [\n" + "{\n" + "\"endpoints\": [\n" + "{\n" + "\"id\": \"af64asqa26fda457c0e974f3f\",\n"
					+ "\"interface\": \"public\",\n" + "\"legacy_endpoint_id\": \"fa56f4as64c9a8f4asdf496\",\n" + "\"region\": \"SBG-1\",\n"
					+ "\"url\": \"https://network.compute.sbg-1.runabove.io/\"\n" + "},\n" + "{\n" + "\"id\": \"5af5d46as48q911zs654fd69fc84\",\n"
					+ "\"interface\": \"public\",\n" + "\"legacy_endpoint_id\": \"q984fSDFsa4654164asd98f42c\",\n" + "\"region\": \"BHS-1\",\n"
					+ "\"url\": \"https://network.compute.bhs-1.runabove.io/\"\n" + "}\n" + "],\n" + "\"id\": \"022012d24e3c446948qwef6as135c68j7uy97\",\n"
					+ "\"type\": \"network\"\n" + "},\n" + "{\n" + "\"endpoints\": [\n" + "{\n" + "\"id\": \"asf489a4f541q4f985s1f631a89a7ffd\",\n"
					+ "\"interface\": \"public\",\n" + "\"legacy_endpoint_id\": \"f7a1afas65qfsASDc1456qf6\",\n" + "\"region\": \"BHS-1\",\n"
					+ "\"url\": \"https://storage.bhs-1.runabove.io/v1/AUTH_fRs614a\"\n" + "},\n" + "{\n" + "\"id\": \"aq98465ASDG46543dfag46eg86eg1s32\",\n"
					+ "\"interface\": \"public\",\n" + "\"legacy_endpoint_id\": \"fAFASd73251aplnxzq9899eb68c7\",\n" + "\"region\": \"SBG-1\",\n"
					+ "\"url\": \"https://storage.sbg-1.runabove.io/v1/AUTH_4f6sa5df\"\n" + "}\n" + "],\n" + "\"id\": \"3c7237csdfasd45f4615a654dc9awd4f\",\n"
					+ "\"type\": \"object-store\"\n" + "}\n" + "],\n" + "\"expires_at\": \"2014-07-05T10:40:02.799784Z\",\n"
					+ "\"issued_at\": \"2014-07-04T10:40:02.799807Z\",\n" + "\"project\": \n" + "{\n" + "\"id\": \"aq98465ASDG46543dfag46eg86eg1s32\",\n"
					+ "\"domain\": {\"name\":\"testprojectdomain\"},\n" + "\"name\": \"testprojectname\"\n" + "},\n" + "\"roles\": \n" + "[{\n"
					+ "\"id\": \"aq98465ASDG46543dfag46eg86eg1s32\",\n" + "\"name\": \"testprojectrole\"\n" + "}],\n" + "\"user\": \n" + "{\n"
					+ "\"id\": \"aq98465ASDG46543dfag46eg86eg1s32\",\n" + "\"domain\": {\"name\":\"testprojectdomain\"},\n"
					+ "\"password\":\"aq98465ASDG46543dfag46eg86eg1s32\",\n" + "\"name\": \"testprojectname\"\n" + "}\n" + "},\n"
					+ "\"X-Auth-Token\": \"mbRArjDDI6fpZQRaxg98USPsz1fuK3Jl17ZHxb\"\n" + "}";
		} else if (uri.equals("/region")) {
			responseString = "[\"BHS-1\", \"SBG-1\"]";
		} else if (uri.equals("/flavor")) {
			responseString = "[\n" + "{\n" + "\"id\": \"4245b91e-d9cf-4c9d-a109-f6a32da8a5cc\",\n" + "\"disk\": 240,\n" + "\"name\": \"pci2.d.r1\",\n"
					+ "\"ram\": 28672,\n" + "\"vcpus\": 4,\n" + "\"region\": \"BHS-1\"\n" + "},\n" + "{\n"
					+ "\"id\": \"ab35df0e-4632-48b2-b6a5-c1f1d922bd43\",\n" + "\"disk\": 240,\n" + "\"name\": \"pci2.d.c1\",\n" + "\"ram\": 16384,\n"
					+ "\"vcpus\": 6,\n" + "\"region\": \"BHS-1\"\n" + "}\n" + "]";
		} else if (uri.equals("/image/fedora")) {
			responseString = "{\n" + "\"id\": \"Pfdq813FxcFel78954aFEfcpaW21\",\n" + "\"name\": \"ra-snapshot\",\n" + "\"status\": \"active\",\n"
					+ "\"creationDate\": \"2014-04-15T12:10:05Z\",\n" + "\"minDisk\": 240,\n" + "\"minRam\": 0,\n" + "\"region\": \"BHS-1\"\n" + "}";
		} else if (uri.equals("/image")) {
			responseString = "[\n" + "{\n" + "\"id\": \"fedora\",\n" + "\"name\": \"Fedora 20\",\n" + "\"region\": \"BHS-1\"\n" + "},\n" + "{\n"
					+ "\"id\": \"centos\",\n" + "\"name\": \"CentOS 6\",\n" + "\"region\": \"BHS-1\"\n" + "}\n" + "]";
		} else if (uri.equals("/instance") && requestBody != null && requestBody.length() > 1) {
			responseString = "{\n" + "\"instanceId\": \"8c687d5d-a1c7-4670-aca8-65acfb23ab44\",\n" + "\"name\": \"Test1\",\n" + "\"ip\": \"192.168.0.1\",\n"
					+ "\"flavorId\": \"ab35df0e-4632-48b2-b6a5-c1f1d922bd43\",\n" + "\"imageId\": \"82a56d09-882d-48cc-82ce-eef59820879f\",\n"
					+ "\"keyName\": \"\",\n" + "\"status\": \"ACTIVE\",\n" + "\"created\": \"2014-06-01T09:13:15Z\",\n" + "\"region\": \"BHS-1\"\n" + "}\n";

		} else if (uri.equals("/instance")) {
			responseString = "[\n" + "{\n" + "\"instanceId\": \"8c687d5d-a1c7-4670-aca8-65acfb23ab44\",\n" + "\"name\": \"Test1\",\n"
					+ "\"ip\": \"192.168.0.1\",\n" + "\"flavorId\": \"ab35df0e-4632-48b2-b6a5-c1f1d922bd43\",\n"
					+ "\"imageId\": \"82a56d09-882d-48cc-82ce-eef59820879f\",\n" + "\"keyName\": \"\",\n" + "\"status\": \"ACTIVE\",\n"
					+ "\"created\": \"2014-06-01T09:13:15Z\",\n" + "\"region\": \"BHS-1\"\n" + "},\n" + "{\n"
					+ "\"instanceId\": \"6736e98e-d40c-408d-8198-8a20d21124f3\",\n" + "\"name\": \"Test2\",\n" + "\"ip\": \"192.168.0.1\",\n"
					+ "\"flavorId\": \"ab35df0e-4632-48b2-b6a5-c1f1d922bd43\",\n" + "\"imageId\": \"6915107b-e40d-4fd7-95f5-5e2bd5c106d3\",\n"
					+ "\"keyName\": \"MyTestKey\",\n" + "\"status\": \"ACTIVE\",\n" + "\"created\": \"2014-06-20T10:10:38Z\",\n" + "\"region\": \"BHS-1\"\n"
					+ "}\n" + "]";
		} else if (uri.equals("/storage") && "{\"containerName\":\"dummy\",\"containerRegion\":\"BHS-1\"}".equals(requestBody)) {
			responseString = "{\n" + "\"instanceId\": \"8c687d5d-a1c7-4670-aca8-65acfb23ab44\",\n" + "\"name\": \"Test1\",\n" + "\"ip\": \"192.168.0.1\",\n"
					+ "\"flavorId\": \"ab35df0e-4632-48b2-b6a5-c1f1d922bd43\",\n" + "\"imageId\": \"82a56d09-882d-48cc-82ce-eef59820879f\",\n"
					+ "\"keyName\": \"\",\n" + "\"status\": \"ACTIVE\",\n" + "\"created\": \"2014-06-01T09:13:15Z\",\n" + "\"region\": \"BHS-1\",\n"
					+ "\"objects\":[{" + "\"contentType\": \"image/jpg\"," + "\"lastModified\": \"\"," + "\"name\": \"test.jpg\"," + "\"size\": 1230485"
					+ "}]}\n";
		} else if (uri.equals("/storage/test?limit=10&region=SBG-1")) {
			responseString = "{\n" + "\"instanceId\": \"8c687d5d-a1c7-4670-aca8-65acfb23ab44\",\n" + "\"name\": \"Test1\",\n" + "\"ip\": \"192.168.0.1\",\n"
					+ "\"flavorId\": \"ab35df0e-4632-48b2-b6a5-c1f1d922bd43\",\n" + "\"imageId\": \"82a56d09-882d-48cc-82ce-eef59820879f\",\n"
					+ "\"keyName\": \"\",\n" + "\"status\": \"ACTIVE\",\n" + "\"created\": \"2014-06-01T09:13:15Z\",\n" + "\"region\": \"BHS-1\",\n"
					+ "\"objects\":[{" + "\"contentType\": \"image/jpg\"," + "\"lastModified\": \"\"," + "\"name\": \"test.jpg\"," + "\"size\": 1230485"
					+ "}]}\n";
		} else if (uri.equals("/storage/test2?limit=10&region=SBG-1")) {
			responseString = "{\n" + "\"instanceId\": \"8c687d5d-a1c7-4670-aca8-65acfb23ab44\",\n" + "\"name\": \"Test1\",\n" + "\"ip\": \"192.168.0.1\",\n"
					+ "\"flavorId\": \"ab35df0e-4632-48b2-b6a5-c1f1d922bd43\",\n" + "\"imageId\": \"82a56d09-882d-48cc-82ce-eef59820879f\",\n"
					+ "\"keyName\": \"\",\n" + "\"status\": \"ACTIVE\",\n" + "\"created\": \"2014-06-01T09:13:15Z\",\n" + "\"region\": \"BHS-1\",\n"
					+ "\"objects\":[{" + "\"contentType\": \"image/jpg\"," + "\"lastModified\": \"\"," + "\"name\": \"test.jpg\"," + "\"size\": 1230485"
					+ "}]}\n";
		} else if (uri.equals("/storage")) {
			responseString = "[\n" + "{\n" + "\"totalObjects\": 5,\n" + "\"name\": \"test\",\n" + "\"stored\": 1024,\n" + "\"region\": \"SBG-1\"\n" + "},\n"
					+ "{\n" + "\"totalObjects\": 0,\n" + "\"name\": \"test2\",\n" + "\"stored\": 0,\n" + "\"region\": \"SBG-1\"\n" + "}\n" + "]";
		} else {
			responseString = "{}";
		}

		if ("DELETE".equals(request.getMethod())) {
			return new Response(request.getUrl(), 204, "nothing", Collections.EMPTY_LIST, null);
		}

		return new Response(request.getUrl(), 200, "nothing", Collections.EMPTY_LIST, new TypedByteArray("application/json", responseString.getBytes()));

	}

	/**
	 * Typed output to string.
	 * 
	 * @param t
	 *            the t
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private String typedOutputToString(TypedOutput t) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		t.writeTo(baos);
		return new String(baos.toByteArray(), "utf-8");
	}
}