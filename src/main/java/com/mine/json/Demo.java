package com.mine.json;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

public class Demo {
	
	public static void main(String[] args) {
		User user = new User();
		user.setUserName("123");
		user.setPassWord("poi");
		String str = JSONObject.toJSONString(user);
		System.out.println(str);
		
		
	}

}
