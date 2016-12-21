package aop.j2se;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

/**
 * 代理类
 * @author kevin
 *
 */
public class HappyPeopleHandler implements InvocationHandler{
	private static Set<String> methodNames = new HashSet<String>();//需要切入的方法
	private IHappyPeople delege;//被代理的对象
	static {
		methodNames.add("travel");
		methodNames.add("celebrate");
		methodNames.add("subscribeTicket");
		methodNames.add("celebrateSpringFestival");
		
	}

	/**
	 * 判断是否是切入点
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
			System.out.println("前增强");
		}
		result = method.invoke(delege, args);
		
		if (isPointcut(method)) {
			System.out.println("后增强");
		}
		return result;
	}
	/**
	 * 生成代理对象
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
