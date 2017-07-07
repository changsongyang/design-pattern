package com.designpattern.proxyoriginal;

/**
 * �ۺϣ�һ������������һ����Ķ���ʵ�ֵ���ͬ���Ľӿ�
 * @author lh
 *
 */
public class TankTimeProxy implements Moveable{

	//������Tank���ĳ�Moveable�������������
	Moveable t;
	
	public TankTimeProxy(Moveable t) {
		super();
		this.t = t;
	}

	@Override
	public void move() {
		long start = System.currentTimeMillis();
		t.move();
		long end = System.currentTimeMillis();
		System.out.println("time:"+(end - start));
	}

	
	
}
