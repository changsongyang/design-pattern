package com.designpattern.proxy;

public class DocumentDAO implements AbstractDocumentDAO{

	@Override
	public boolean deleteDocumentById(String documentId) {
		if(documentId.equals("���ģʽ������")){
			System.out.println("��ѯIDΪ"+documentId+"���ĵ���Ϣ�ɹ���");
			return true;
		}else{
			System.out.println("��ѯIDΪ"+documentId+"���ĵ���Ϣʧ�ܣ�");
			return false;
		}
	}

}
