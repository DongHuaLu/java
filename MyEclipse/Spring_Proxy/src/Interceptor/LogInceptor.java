package Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInceptor implements InvocationHandler {
	private Object target;
	
	public void before(){
		System.out.println("before");
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		before();
		method.invoke(target, args);		
		return null;
	}
	public Object getTarget() {
		return target;
	}
	public void setTarget(Object target) {
		this.target = target;
	}
	
}
