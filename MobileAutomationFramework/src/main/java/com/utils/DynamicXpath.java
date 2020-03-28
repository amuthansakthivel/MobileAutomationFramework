package com.utils;

/*
 * It will be used to handle dynamic xpaths at run time
 */
public class DynamicXpath {

	public static String get(String xpath, String data) {

		String rawxpath = xpath.replaceAll("%replaceable%", data);
		return rawxpath;

	}

	public static String get(String xpath, String data1,String data2) {

		String rawxpath = xpath.replaceAll("%replaceable1%", data1).replaceAll("%replaceable2%", data2);
		return rawxpath;

	}
}
