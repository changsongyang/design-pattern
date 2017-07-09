package com.designpattern.proxyoriginal5;

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

import com.designpattern.proxyoriginal5.Moveable;
import com.designpattern.proxyoriginal5.Tank;

public class Proxy {

	/**
	 * ��̬����7��һ��Ƚ���
	 * 
	 * ���ڿ������������ʵ������ӿڵĴ���
	 * ������һ�������ص������ǣ�ֻ������ʱ��Ĵ��� ����ʵ�ֱ���˵Ȩ�������Զ������
	 * �κη����ڵ��õ�ʱ�� ��û��ܹ����ñ���ָ�����ҵ�һ�ִ���ʽ��
	 * ����������Ҫһ�������ܶ�ָ̬������ĳһ���������д����һ������
	 */
	public static Object newProxyInstance(Class infce,InvocationHandler h) throws Exception{ //JDK1.6 Complier API,CGLib, ASM
		String rt = "\r\n";
		String methodStr = "";
		Method[] methods = infce.getMethods();
		// ����ط���Ҫ�ı���
		for(Method m :methods){
			methodStr += "@Override" + rt +
						"public void "+m.getName() +"(){" + rt +
							"try{"+ rt +
							"Method md = " + infce.getName() +".class.getMethod(\"" + m.getName() + "\");" + rt +
							// this ָ�������ǵĴ������
							"h.invoke(this,md);" + rt + 
//							"t." + m.getName() + "();"+ rt +
							"}catch(Exception e){"+ rt +
							"e.printStackTrace();"+ rt +
							"}"+ rt +
						"}";
		}
		
		String src = 
				"package com.designpattern.proxyoriginal5;"+ rt +
				"import java.lang.reflect.Method;"+ rt +
				// jdk����������������$Proxy1
				"public class $Proxy1 implements "+ infce.getName()+"{"+ rt +
				
					"public $Proxy1(InvocationHandler h) {"+ rt +
//						"super();"+ rt +
						"this.h = h;"+ rt +
					"}"+ rt +
					"com.designpattern.proxyoriginal5.InvocationHandler h;" + rt +
						
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
//		String fileName = System.getProperty("user.dir")+
		String fileName = "d:"+
				"/src/com/designpattern/proxyoriginal5/$Proxy1.java";
		
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
		URL[] urls = new URL[]{new URL("file:/"+"d:/src")};
//		URL[] urls = new URL[]{new URL("file:/"+System.getProperty("user.dir")+"/src")};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.designpattern.proxyoriginal5.$Proxy1");
		System.out.println("c = " + c);
		//c = class com.designpattern.proxyoriginal5.TankTimeProxy��ʾload�ɹ�
		
		//�������
		//c.newInstance();//�����������Ĳ���Ϊ�յĹ��췽��
		Constructor ctr = c.getConstructor(com.designpattern.proxyoriginal5.InvocationHandler.class);
		Object object = ctr.newInstance(h);
			
		//���Ҷ�object����move��ʱ��ʵ���ϻ�������ɴ����h.invoke(this,method)
		//�����method���Ǿ�������ʵ���˵�InvocationHandler�������method
		return object;
		
	}

}
