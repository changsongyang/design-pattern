package com.designpattern.proxyoriginal5;

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
		
//		Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class,new TimeHandler());
//		m.move();
		
		Tank t = new Tank();
		InvocationHandler h = new TimeHandler(t);
		Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class,h);
		//���ҵ���move������ʱ�������ɵĴ�������ҵ�������Ȼ�����ô�������h��invoke
		//�������ǵ�TimeHandler��invoke,�Ϳ����Լ����߼���Ȼ�����ԭ���Ķ��󷽷������ܾ�ʵ����
		
		//����һ�� 8 - 5:48
		//����������һ��Tank����
		//����Tank����move����ǰ������Լ���һ���߼� 
		//�������ȶ������Լ����߼�TimeHandler,���Tank���󽻸����ǵ�TimeHandler����
		//
		//�ô��ǿ��Զ�����Ķ�������Ľӿڷ�����ʵ������Ĵ���
		//���ż�������proxy.test
		
		//jdk����newProxyInstance�����Ƕ�һ������classloader������д����URLClassLoader
		////jdk����InvocationHandler�����Ƕ��˷����Ĳ���
		
		//ʲô�ж�̬����
		//��̬��������ô������
	}
	
}
