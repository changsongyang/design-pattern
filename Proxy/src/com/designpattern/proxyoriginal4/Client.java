package com.designpattern.proxyoriginal4;

import java.io.Serializable;

public class Client {

	/**
	 * ʵ������ӿڵĶ�̬����
	 * ��Ҫ����Ľӿ��ж��ٸ���������ô���Ǿ�Ҫʵ�ֶ��ٸ�����
	 * @param args
	 * @throws Exception 
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
