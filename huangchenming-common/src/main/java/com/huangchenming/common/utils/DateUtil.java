package com.huangchenming.common.utils;

import java.util.Date;

/**
 * 作者:黄晨明
 * 时间:2019年9月20日上午8:11:14
 */
public class DateUtil {

	/*
	* 方法1：(10分)
	* 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
	* 则返回的结果为2019-05-01 00:00:00
	*/
	@SuppressWarnings("deprecation")
	public static Date getDateByInitMonth(Date date){
	//TODO 实现代码
		date.setDate(1);
		date.setMinutes(0);
		date.setHours(0);
		date.setSeconds(0);
		return date;
	}
	
	/*
	* 方法2：(10分)
	* 给任意一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	* 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
	* 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	*/
	public static Date getDateByFullMonth(Date date){
	//TODO 实现代码
		int i = date.getMonth()+1;
		if(i==1||i==3||i==5||i==7||i==8||i==10||i==12) {
			date.setDate(31);
		}else if(i==2) {
			date.setDate(28);
		}else {
			date.setDate(30);
		}
		
		date.setMinutes(59);
		date.setHours(23);
		date.setSeconds(59);
		return date;
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date date = new Date("2018/02/13");
		Date date2 = DateUtil.getDateByFullMonth(date);
		System.out.println(date2.toLocaleString() );
	}
}
