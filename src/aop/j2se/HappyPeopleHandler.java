package aop.j2se;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

/**
 * ������
 * @author kevin
 *
 */
public class HappyPeopleHandler implements InvocationHandler{
	private static Set<String> methodNames = new HashSet<String>();//��Ҫ����ķ���
	private IHappyPeople delege;//������Ķ���
	static {
		methodNames.add("travel");
		methodNames.add("celebrate");
		methodNames.add("subscribeTicket");
		methodNames.add("celebrateSpringFestival");
		
	}

	/**
	 * �ж��Ƿ��������
	 * @param method
	 * @return
	 */
	private boolean isPointcut(Method method){
		if (method == null) {
			return false;
		}
		
		return methodNames.contains(method.getName());
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		if (isPointcut(method)) {
			System.out.println("ǰ��ǿ");
		}
		result = method.invoke(delege, args);
		
		if (isPointcut(method)) {
			System.out.println("����ǿ");
		}
		return result;
	}
	/**
	 * ���ɴ������
	 * @param delege
	 * @return
	 */
	public IHappyPeople getProxy(IHappyPeople delege){
		this.delege = delege;
		return (IHappyPeople)Proxy.newProxyInstance(
				               delege.getClass().getClassLoader(),
			                   delege.getClass().getInterfaces(), 
			                   this);
	}

}
