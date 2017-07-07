package com.designpattern.compiler.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Test {

	/**
	 * ������δ�����������ļ�
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String rt = "\r\n";
		String src = 
				"package com.designpattern.proxyoriginal3;"+ rt +
				"public class TankTimeProxy implements Moveable{"+ rt +
						
					"Moveable t;"+ rt +
				
					"public TankTimeProxy(Moveable t) {"+ rt +
						"super();"+ rt +
						"this.t = t;"+ rt +
					"}"+ rt +
						
					"@Override"+ rt +
					"public void move() {"+ rt +
						"long start = System.currentTimeMillis();"+ rt +
						"t.move();"+ rt +
						"long end = System.currentTimeMillis();"+ rt +
						"System.out.println(\"time:\"+(end - start));"+ rt +
					"}"+ rt +
						
				"}";
		System.out.println("path:"+System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir")+
				"/src/com/designpattern/proxyoriginal3/TankTimeProxy.java";
		
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(src);
		fw.flush();
		fw.close();
		
		//����֮����б���
		//�����õ�����������
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		System.out.println("compiler:"+compiler.getClass().getName());
		// FileManager���������������ɵ��ļ�
		StandardJavaFileManager fileManager =compiler.getStandardFileManager(null, null, null);
		// units������Ҫ���������
		Iterable units = fileManager.getJavaFileObjects(fileName);
		// ��������
		CompilationTask compilationTask = compiler.getTask(null, fileManager, null, null, null, units);
		// �Ϳ��Ա��������
		compilationTask.call();
		fileManager.close();
		
		//ͨ��show view�����navigatorˢ�¿��Կ���Ӳ���ϵ���ʵ����и�.class�ļ�����
		
	}
	
}
