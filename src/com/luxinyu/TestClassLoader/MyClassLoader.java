package com.luxinyu.TestClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader{
	private final String DEFAULT_PATH = "D:\\study\\load";
	private String classPath = DEFAULT_PATH;
	private String classLoaderName;
	public MyClassLoader(String classLoaderName) {
		super();
		this.classLoaderName = classLoaderName;
	}
	
	public MyClassLoader(ClassLoader parent,String classLoaderName) {
		super(parent);
		this.classLoaderName = classLoaderName;
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		if(name==null) {
			throw new ClassNotFoundException();
		}
		
		name = name.replace('.', '/');
		File classFile = new File(classPath, name+".class");
		if(!classFile.exists()) throw new ClassCastException("文件"+name+".class"+"不存在");
		byte[] result = getByteArray(classFile);
		return this.defineClass(name, result, 0, result.length);
	}
	private byte[] getByteArray(File classFile) {
		// TODO Auto-generated method stub
		try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
				FileInputStream fis = new FileInputStream(classFile)){
			byte[] a = new byte[1024];
			int len = 0;
			while((len = fis.read(a))!=-1) {
				baos.write(a, 0, len);
			}
			baos.flush();
			return baos.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getClassPath() {
		return classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}
}
