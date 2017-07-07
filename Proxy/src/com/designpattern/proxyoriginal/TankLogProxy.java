package com.designpattern.proxyoriginal;

/**
 * �ۺϣ�һ������������һ����Ķ���ʵ�ֵ���ͬ���Ľӿ�
 * @author lh
 *
 */
public class TankLogProxy implements Moveable{

	//������Tank���ĳ�Moveable�������������
	Moveable t;
	
	public TankLogProxy(Moveable t) {
		super();
		this.t = t;
	}

	@Override
	public void move() {
		System.out.println("Tank Start...");
		t.move();
		System.out.println("Tank Stop...");
	}

	
	
}
