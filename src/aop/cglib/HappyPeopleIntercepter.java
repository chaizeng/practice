package aop.cglib;

import java.lang.reflect.Method;

import aop.j2se.IHappyPeople;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class HappyPeopleIntercepter implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("前增强");
	    Object result = proxy.invokeSuper(obj, args);
		System.out.println("后增强");
		return result;
	}

	/**
	 * 生成代理对象
	 * @param delege
	 * @return
	 */
	public IHappyPeople getProxy(IHappyPeople delege){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(delege.getClass());
		enhancer.setCallback(this);
		return (IHappyPeople)enhancer.create();
	}


}
