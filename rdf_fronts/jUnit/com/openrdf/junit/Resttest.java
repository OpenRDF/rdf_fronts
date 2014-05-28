package com.openrdf.junit;

import com.openrdf.utils.rest.client.RESTClient;

public class Resttest {

	public static void main(String[] args) {
		RESTClient client = new RESTClient();
		String result = client.RESTGET("http://lookup.dbpedia.org/api/search.asmx/PrefixSearch?QueryClass=&MaxHits=5&QueryString=" + "zhengzhou");
		System.out.println(result);
		
	}
}
