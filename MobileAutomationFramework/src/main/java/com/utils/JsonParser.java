package com.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.constants.Constants;
import com.jayway.jsonpath.JsonPath;


public class JsonParser {
	private static File jsonFile;

	public static String getValue(String path) throws IOException   {
		String temp = "";
		try {
			jsonFile=new File(Constants.JSONPATH);
			temp=JsonPath.read(jsonFile,"$."+path);
		}
		catch(Exception e) {

		}
		return temp;

	}
}
