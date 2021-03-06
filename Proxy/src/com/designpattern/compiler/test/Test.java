package com.designpattern.compiler.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.designpattern.proxyoriginal3.Moveable;
import com.designpattern.proxyoriginal3.Tank;

public class Test {

	/**
	 * 发现这段代码可以生成文件,即动态代理
	 * 但是只能产生Moveable接口的代理，不能产生任意一个接口的代理，接下来增加接口参数看
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
		
		//生成之后进行编译 compile
		//首先拿到编译器对象
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		System.out.println("compiler:"+compiler.getClass().getName());
		// FileManager用来管理我们生成的文件
		StandardJavaFileManager fileManager =compiler.getStandardFileManager(null, null, null);
		// units是我们要编译的内容
		Iterable units = fileManager.getJavaFileObjects(fileName);
		// 编译任务
		CompilationTask compilationTask = compiler.getTask(null, fileManager, null, null, null, units);
		// 就可以编译完成了
		compilationTask.call();
		fileManager.close();
		//通过show view里面的navigator刷新可以看到硬盘上的真实情况有个.class文件产生
		
		//load into memory and create an instance
		//用classloader来load class的是时候必须得保证class在class path里面，即bin内
		//我们用特殊的classloader
		URL[] urls = new URL[]{new URL("file:/"+System.getProperty("user.dir")+"/src")};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.designpattern.proxyoriginal3.TankTimeProxy");
		System.out.println("c = " + c);
		//c = class com.designpattern.proxyoriginal3.TankTimeProxy表示load成功
		
		//反射调用
		//c.newInstance();//会掉用类里面的参数为空的构造方法
		Constructor ctr = c.getConstructor(Moveable.class);
		Moveable m = (Moveable) ctr.newInstance(new Tank());
		m.move();
	}
	
}
