package com.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class Client {
	public static void main(String[] args) {
		InvocationHandler handler = null;
		
		AbstractUserDAO userDAO = new UserDAO();

		handler = new DAOLogHandler(userDAO);
		AbstractUserDAO proxy = null;
		
		//Proxy.newProxyInstance���ڷ���һ����̬�����Ĵ������ʵ��
		//����һ����������������    ������:��������ʵ�ֽӿڵķ���    ����������ָ�ɵĵ��ô��������
		proxy = (AbstractUserDAO)Proxy.newProxyInstance(AbstractUserDAO.class.getClassLoader(),
				new Class[]{AbstractUserDAO.class},handler);
		proxy.findUserById("��ΰ");
		
		System.out.println("--------------------------------");
		System.out.println("---------------ͬ��--------------");
		
		AbstractDocumentDAO documentDAO = new DocumentDAO();
		handler = new DAOLogHandler(documentDAO);
		AbstractDocumentDAO proxy_new = null;
		proxy_new = (AbstractDocumentDAO)Proxy.newProxyInstance(AbstractDocumentDAO.class.getClassLoader(),
				new Class[]{AbstractDocumentDAO.class},handler);
		proxy_new.deleteDocumentById("���ģʽ������");
	}
}
