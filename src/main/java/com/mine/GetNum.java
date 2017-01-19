package com.mine;

import org.apache.commons.codec.digest.DigestUtils;


public class GetNum {
	
	public static void main(String[] args) {
		
//		String[] names = new String[] { "13100611016", "13381115959", "13810056056", "147623533@qq.com", "15110088533", "18311001600", "18651832950",
//				"18665906245", "18898775877", "464580063@qq.com", "812886699@qq.com", "club21@qq.com", "jordansir@126.com",
//				"szleichengfeng@ininin.com" };
//		String[] names = new String[] { "1257122963@qq.com", "13202068155", "13430966986", "13430966986", "13502831623", "13590313457",
//				"13710493457", "13710493457", "13710493457", "13802641619", "15313817877", "15814607722", "15889433039", "15899759884",
//				"15919964258", "18030618076", "18588413875", "18588413875", "215035089@qq.com", "349037473@qq.com", "360413888@qq.com",
//				"360891075@qq.com", "40237963@qq.com", "40237963@qq.com", "48169361@qq.com", "48385115@qq.com", "544972792@qq.com",
//				"88942671@qq.com", "chenw@zhongtou8.cn", "chenw@zhongtou8.cn", "chenw@zhongtou8.cn", "chenw@zhongtou8.cn", "chenw@zhongtou8.cn",
//				"chenw@zhongtou8.cn", "chenw@zhongtou8.cn", "haiyantao@upintech.com", "haiyantao@upintech.com", "kongliuhong@umeox.com",
//				"kongliuhong@umeox.com", "levine627@163.com", "marketing@tetelaser.com.cn", "marketing@tetelaser.com.cn", "pazhaopin2013@163.com",
//				"pazhaopin2013@163.com", "szjlh100@163.com", "wyeflash@qq.com", "zuotianzll@vip.qq.com" };
		
//		String[] names = new String[] { "13510905495", "147623533@qq.com", "15919853823", "2585441871@qq.com", "jerry@ininin.com", "wwlxp@163.com" };
//		String[] names = new String[] { "1DE29A7B213B4EBA6DEF83CF82DE9FCE1", "2oobpZt-E5GWgDFz2Sfq5BmhhmQCU", "2oobpZt08QzyTUBQeurZIQPirT524",
//				"2oobpZt2AnS1m-KW5IbHLSMulJaBs" };
//		for(String n : names){
//			System.out.println("db_user_" + getDataBaseNum(n) + ".t_user_link_" + getTableNum(n));
//		}
		
		
		String userName = "15692006436";
		System.out.println(getDataBaseNum(userName) + ";" + getTableNum(userName));
		
		
//		String[] userNames = new String[]{"18575690455","857608382@qq.com","18098953361","18566785282","cooky@dmxapp.com","857608382@qq.com"};
//		String[] invs = new String[]{"PK","PK","GT","PK","lc","PK"};
//		int i = 0;
//		for(String userName : userNames){
//			System.out.println("update db_user_" + getDataBaseNum(userName) + ".t_user_profile_"
//					+ getTableNum(userName) + " set inviter = '" + invs[i] + "' where user_name = '" + userName + "';");
//			i++;
//		}
		System.out.println(DigestUtils.md5Hex(DigestUtils.md5Hex("123456")));
		System.out.println(DigestUtils.md5Hex("123456"));
		
		
		for (int i = 1; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				
			}
		}
	}
	
	/**
	 * 根据用户名获取访问的数据库的ID
	 * 
	 * @param username
	 * @return
	 */
	public static String getDataBaseNum(String userName) {
		if (userName == null || "".equals(userName)) {
			return "0";
		}
		int i = Math.abs(userName.hashCode()) % 10 + 1;
		return String.valueOf(i);
	}

	/**
	 * 根据用户名获取访问的表的ID
	 * 
	 * @param username
	 * @return
	 */
	public static String getTableNum(String userName) {
		if (userName == null || "".equals(userName)) {
			return "0";
		}
		int i = Math.abs(userName.hashCode()) % 100;
		return String.format("%02d", i);
	}
	
}
