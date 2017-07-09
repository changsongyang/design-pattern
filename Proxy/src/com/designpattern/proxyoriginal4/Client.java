package com.designpattern.proxyoriginal4;

import java.io.Serializable;

public class Client {

	/**
	 * ������һ�������ص������ǣ�ֻ������ʱ��Ĵ��� ����ʵ�ֱ���˵Ȩ�������Զ������
	 */
	public static void main(String[] args) throws Exception {
//		Moveable moveable = new Tank();
//		Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class);
//		m.move();
		
//		Moveable moveable = new Tank();
//		Moveable m = (Moveable) Proxy.newProxyInstance(Serializable.class);
		
		Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class);
		m.move();
		
	}
	
}
