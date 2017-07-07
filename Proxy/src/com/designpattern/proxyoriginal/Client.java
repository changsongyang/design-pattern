package com.designpattern.proxyoriginal;

public class Client {

	public static void main(String[] args) {
		//�ۺϵĺô���
		//���뿽��һ�ݼ���
		Moveable moveable = new Tank();
		TankTimeProxy ttp = new TankTimeProxy(moveable);
		TankLogProxy tlp = new TankLogProxy(ttp);
		tlp.move();
	}
}
