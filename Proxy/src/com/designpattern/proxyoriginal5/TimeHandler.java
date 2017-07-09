package com.designpattern.proxyoriginal5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//��Ҫʵ��InvocationHandler
public class TimeHandler implements InvocationHandler{

	//��������û�б�����Ķ���
	//sunҪ��ѱ�����Ķ���д��������
	// ��Ҫ����ö��ĸ�������д���
	private Object target; //�������ǵı��������

	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object o,Method m){
		System.out.println(""+o.getClass().getName());//��ʵ�������ɵĴ�����
		//��Ҫ�����Լ��Ĵ����߼�
		long start = System.currentTimeMillis();
		//���˾�̬�������㶼����Ҫ֪�����÷����Ķ�����˭������invoke�ڱ������һ��Object����
		try {
//			m.invoke(o,new Object[]{});
			//��Ҫ�Ա�����������
			m.invoke(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("time:"+(end - start));
		
	}

}
