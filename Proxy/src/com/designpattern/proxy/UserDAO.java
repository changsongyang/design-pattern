package com.designpattern.proxy;

public class UserDAO implements AbstractUserDAO{

	@Override
	public boolean findUserById(String userId) {
		if(userId.equals("��ΰ")){
			System.out.println("��ѯIDΪ"+userId+"���û���Ϣ�ɹ���");
			return true;
		}else{
			System.out.println("��ѯIDΪ"+userId+"���û���Ϣʧ�ܣ�");
			return false;
		}
	}

}
