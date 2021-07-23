package com.example.oa.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class MD5UtilsTest {

	@Test
	public void md5Digest() {
		String result = MD5Utils.md5Digest("123456");
		System.out.println(result);
	}

	@Test
	public void md5Digest1() {
		String result = MD5Utils.md5Digest("123456", 888);
		System.out.println(result);
	}
}