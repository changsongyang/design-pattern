package com.designpattern.proxyoriginal2;

public class Client {

	public static void main(String[] args) {
		//�ۺϵĺô���
		//��������κε��඼���Դ��������3
		Moveable moveable = new Tank();
		TankTimeProxy ttp = new TankTimeProxy(moveable);
		ttp.move();
	}
}
