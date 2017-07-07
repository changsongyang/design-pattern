package com.designpattern.proxyoriginal3;

public class Proxy {

	/**
	 * ���������µĴ�����
	 * ʵ����TankTimeProxy�Ĵ������
	 * ����Proxy�Ĵ��ڣ�TankTimeProxy���Զ�̬�����ˣ����Է�����
	 * @return
	 */
	public static Object newProxyInstance(){ //JDK1.6 Complier API,CGLib, ASM
		String src = 
		"package com.designpattern.proxyoriginal3;"+
		"public class TankTimeProxy implements Moveable{"+
				
			"Moveable t;"+
		
			"public TankTimeProxy(Moveable t) {"+
				"super();"+
				"this.t = t;"+
			"}"+
				
			"@Override"+
			"public void move() {"+
				"long start = System.currentTimeMillis();"+
				"t.move();"+
				"long end = System.currentTimeMillis();"+
				"System.out.println(\"time:\"+(end - start));"+
			"}"+
				
		"}";
			
		return null;
		
	}
}
