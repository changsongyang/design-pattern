package com.designpattern.proxyprinciple;

public class UserDAO implements AbstractUserDAO {

	@Override
	public void findUserById() {
		System.out.println("��ѯIDΪ" + "X" + "���û���Ϣ�ɹ���");
	}

}
