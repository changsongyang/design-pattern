package com.designpattern.proxyoriginal3;

public class Client {

	/**
	 * �ȿ�compiler.test����һ��
	 * @param args
	 */
	public static void main(String[] args) {
		Moveable moveable = new Tank();
		Moveable m = (Moveable) Proxy.newProxyInstance();
		m.move();
	}
}
