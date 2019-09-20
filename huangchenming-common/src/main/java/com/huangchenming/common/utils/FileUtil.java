package com.huangchenming.common.utils;
/**
 * 作者:黄晨明
 * 时间:2019年9月20日上午8:11:24
 */
public class FileUtil {
	/*
	* 方法1：给定一个文件名，返回该文件名的扩展名，例如“aaa.jpg”，返回“.jpg”(10分)
	*/
	public static String getExtendName(String fileName){
	//TODO 实现代码
		return fileName.substring(fileName.lastIndexOf("."),fileName.length());
	}
	
	public static void main(String[] args) {
		String str = "sfasb.jpg";
		String name = FileUtil.getExtendName(str);
		System.out.println(name);
	}
}
