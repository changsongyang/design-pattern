package com.designpattern.proxyoriginal5;

import java.lang.reflect.Method;

/**
 * ���õĴ�����
 * @author lh
 *
 */
public interface InvocationHandler {
	
	// ���ڴ������ĵ���
	public void invoke(Object o,Method m);
	
}
