package cn.gameboys.mybatis.utils;

import java.util.UUID;

import org.junit.Test;

public class IDUtils {
	public static String getId() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	@Test
	public void test() {
		System.out.println(IDUtils.getId());
		System.out.println(IDUtils.getId());
		System.out.println(IDUtils.getId());
		System.out.println(IDUtils.getId());
	}
}
