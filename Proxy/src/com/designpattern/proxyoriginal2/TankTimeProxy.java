package com.designpattern.proxyoriginal2;

/**
 * �ۺϣ�һ������������һ����Ķ���ʵ�ֵ���ͬ���Ľӿ�
 * @author lh
 * ̹�˵Ĵ���
 */
public class TankTimeProxy implements Moveable{

	//������Tank���ĳ�Moveable�������������
	Moveable t;
	
	public TankTimeProxy(Moveable t) {
		super();
		this.t = t;
	}

	/**
	 * ���Ƿ�װһ�´�ӡʱ��
	 */
	@Override
	public void move() {
		long start = System.currentTimeMillis();
		t.move();
		long end = System.currentTimeMillis();
		System.out.println("time:"+(end - start));
	}

	@Override
	public void stop() {
		long start = System.currentTimeMillis();
		t.stop();
		long end = System.currentTimeMillis();
		System.out.println("time:"+(end - start));
	}
	
	
}
