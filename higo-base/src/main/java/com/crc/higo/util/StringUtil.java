package com.crc.higo.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

public class StringUtil {

	public static String joinSortFieldOrder(String filed,String sord){
		StringBuffer orderFiled = new StringBuffer();
		if(!StringUtil.isEmpty(filed)){
			orderFiled.append(filed);
			if(!StringUtil.isEmpty(sord)){
				orderFiled.append(" ").append(sord);
			}
		}
		return orderFiled.toString();
	}

	/**
	 * 字符串为空
	 *
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	public static String firstCharLowCase(String str) {
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	public static String firstCharUpCase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static String addPrefix(int num, String prefix, int length) {
		return String.format("%04d", num);
	}

	public static boolean isStringAvaliable(String string) {
		return string != null && !"".equals(string.trim());
	}

	public static boolean isListSizeGtZero(List list) {
		return list != null && list.size() > 0;
	}

	public static Boolean notSame(String dest, String scre) {
		if (null == dest || null == scre)
			return false;
		else
			return !dest.equals(scre);
	}

    /**
     * 将异常堆栈转换为字符串
     *
     * @param t
     * @return
     */
    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        t.printStackTrace(pw);
        pw.flush();
        sw.flush();
        return sw.toString();
    }

	/**
	 * 去掉字符串前后空格
	 * 
	 * @param s
	 * @return
	 */
	public static String trim(String s) {
		int i = s.length();
		int j = 0;// 字符串第一个字符
		int k = 0;// 中间变量
		char[] arrayOfChar = s.toCharArray();// 将字符串转换成字符数组
		while ((j < i) && (arrayOfChar[(k + j)] <= ' '))
			++j;// 确定字符串前面的空格数
		while ((j < i) && (arrayOfChar[(k + i - 1)] <= ' '))
			--i;// 确定字符串后面的空格数
		return (((j > 0) || (i < s.length())) ? s.substring(j, i) : s);// 返回去除空格后的字符串
	}

	/**
	 * 删除input字符串中的html格式
	 * 
	 * @param input
	 * @param length
	 * @return
	 */
	public static String splitAndFilterString(String input) {
		if (input == null || input.trim().equals("")) {
			return "";
		}
		// 去掉所有html元素,
		String str = input.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll(
				"<[^>]*>", "");

		return str.replaceAll("[(/>)<]", "");
	}
	
	
	/**
	 * 获得学历名称
	 * 
	 */
	public static String getNameBySchoolStr(String val){
	
		if(val==null)return null;
		switch (val) {
		case "0":return "博士研究生毕业";
		case "1":return "博士研究生结业";
		case "2":return "博士研究生肄业";
		case "3":return "硕士研究生毕业";
		case "4":return "硕士研究生结业";
		case "5":return "硕士研究生肄业";
		case "6":return "研究生班毕业";
		case "7":return "研究生班结业";
		case "8":return "研究生班肄业";
		case "9":return "大学本科毕业";
		case "10":return "大学本科结业";
		case "11":return "大学本科肄业";
		case "12":return "大学普通班毕业";
		case "13":return "大学专科毕业";
		case "14":return "大学专科结业";
		case "15":return "大学专科肄业";
		case "16":return "中等专科毕业";
		case "17":return "中等专科结业";
		case "18":return "中等专科肄业";
		case "19":return "职业高中毕业";
		case "20":return "职业高中结业";
		case "21":return "职业高中肄业";
		case "22":return "技工学校毕业";
		case "23":return "技工学校结业";
		case "24":return "技工学校肄业";
		case "25":return "普通高中毕业";
		case "26":return "普通高中结业";
		case "27":return "普通高中肄业";
		case "30":return "初中毕业";
		case "31":return "初中肄业";
		case "32":return "小学毕业";
		case "33":return "小学肄业";
		case "34":return "其他";
		default: return "";
		
		}
	}
	public static String connect(String arg1, String agr2){
		//加两个变量是为了解决 不改变原有对象的基础上,传进来的参数是null对象的时候不会返回类似"null8888888"这样的字符串
		String mobile="";
		String tel="";
		if(StringUtil.isStringAvaliable(arg1))
			mobile=arg1;
		if (StringUtil.isStringAvaliable(agr2)) {
			tel=agr2;
		}
		if(mobile.length()>0&&tel.length()>0){
			return mobile+"/"+tel;
		}else{
			return mobile+tel;
		}
		
	}
}
