package com.designpattern.proxyoriginal4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

import com.designpattern.proxyoriginal4.Moveable;
import com.designpattern.proxyoriginal4.Tank;

public class Proxy {

	/**
	 * ���ڿ������������ʵ������ӿڵĴ���
	 * @return
	 * @throws Exception 
	 */
	public static Object newProxyInstance(Class infce) throws Exception{ //JDK1.6 Complier API,CGLib, ASM
		String rt = "\r\n";
		String methodStr = "";
		Method[] methods = infce.getMethods();
		for(Method m :methods){
			methodStr += "@Override" + rt +
						"public void "+m.getName() +"(){" + rt +
							"long start = System.currentTimeMillis();"+ rt +
							"t." + m.getName() + "();"+ rt +
							"long end = System.currentTimeMillis();"+ rt +
							"System.out.println(\"time:\"+(end - start));"+ rt +
						"}";
		}
		
		String src = 
				"package com.designpattern.proxyoriginal4;"+ rt +
				"public class TankTimeProxy implements "+ infce.getName()+"{"+ rt +
						
					"Moveable t;"+ rt +
				
					"public TankTimeProxy(Moveable t) {"+ rt +
						"super();"+ rt +
						"this.t = t;"+ rt +
					"}"+ rt +
						
					methodStr + rt +
//					"@Override"+ rt +
//					"public void move() {"+ rt +
//						"long start = System.currentTimeMillis();"+ rt +
//						"t.move();"+ rt +
//						"long end = System.currentTimeMillis();"+ rt +
//						"System.out.println(\"time:\"+(end - start));"+ rt +
//					"}"+ rt +
						
				"}";
		System.out.println("path:"+System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir")+
				"/src/com/designpattern/proxyoriginal4/TankTimeProxy.java";
		
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(src);
		fw.flush();
		fw.close();
		
		//����֮����б��� compile
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
		
		//load into memory and create an instance
		//��classloader��load class����ʱ�����ñ�֤class��class path���棬��bin��
		//�����������classloader
		URL[] urls = new URL[]{new URL("file:/"+System.getProperty("user.dir")+"/src")};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.designpattern.proxyoriginal4.TankTimeProxy");
		System.out.println("c = " + c);
		//c = class com.designpattern.proxyoriginal4.TankTimeProxy��ʾload�ɹ�
		
		//�������
		//c.newInstance();//�����������Ĳ���Ϊ�յĹ��췽��
		Constructor ctr = c.getConstructor(Moveable.class);
//		Moveable m = (Moveable) ctr.newInstance(new Tank());
			
		return null;
		
	}

}
