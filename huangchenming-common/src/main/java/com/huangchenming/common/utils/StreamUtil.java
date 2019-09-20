package com.huangchenming.common.utils;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 作者:黄晨明 时间:2019年9月20日上午8:11:38
 */
public class StreamUtil {
	/*
	 * 方法1：批量关闭流，参数能传入无限个。(10分)
	 * 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭，并且参数个数不限。
	 */
	public static void closeAll(Closeable... io) {
		// TODO 实现代码
		try {
			if (io != null && io.length > 0) {
				for (Closeable closeable : io) {
					closeable.close();
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(10分)，要求方法内部调用上面第1个方法关闭流(5分)
	 */
	public static String readTextFile(InputStream src) {
		// TODO 实现代码
		String str = "";
		try {
			byte[] b = new byte[127];
			int len = 0;
			while((len=src.read(b))!=-1){
				String string = new String(b,0,len);
				str +=string;
			}

			StreamUtil.closeAll(src);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	/*
	 * 方法3：传入文本文件对象，返回该文件内容(10分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
	 */
	public static String readTextFile(File txtFile) {
		// TODO 实现代码
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(txtFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return StreamUtil.readTextFile(fileInputStream);
	}

	public static void main(String[] args) {
		File file = new File("D:\\JAVA\\dfgdfg.txt");
		String file2 = StreamUtil.readTextFile(file);
		System.out.println(file2);
	}
}
