package com.designpattern.proxyprinciple;

public class DocumentDAO implements AbstractDocumentDAO {

	@Override
	public void deleteDocumentById() {
		System.out.println("��ѯIDΪ" + "Y" + "���ĵ���Ϣʧ�ܣ�");
	}

}
