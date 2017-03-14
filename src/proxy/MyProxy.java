package proxy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * ��Ҫ��jdk/lib/tools.jar���Ƶ�java_home�µ�jre/lib��
 * @author kevin
 *
 */
public class MyProxy {
	
	public static void genClass(){
		StringBuffer str = new StringBuffer();
		str.append("package ch.gen; \r\n")
		.append("public class Demo {\r\n")
		.append("public void hello () {\r\n")
		.append("System.out.println(\"Hello,kevin\"); \r\n")
		.append("}\r\n")
		.append("}\r\n");
		
		String filePath = "g:/ch/gen/Demo.java";
		File file = new File(filePath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		FileWriter out = null;
		try {
			out = new FileWriter(file);
			out.write(str.toString());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		/*
		 * ����
		 */
		JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager sjf = jc.getStandardFileManager(null, null, null);
		Iterable units = sjf.getJavaFileObjects(filePath);
		CompilationTask ct = jc.getTask(null, sjf, null, null, null, units);
        ct.call();
        try {
			sjf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        /*
         * ���ص��ڴ�
         */
        Class c;
		try {
			c = ClassLoader.getSystemClassLoader().loadClass("ch.gen.Demo");
		    Method m = c.getMethod("hello", null);
	        Object obj = c.newInstance();
	        if (m !=null) {
	        	m.invoke(obj, null);
	        }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		MyProxy.genClass();
	}

}
