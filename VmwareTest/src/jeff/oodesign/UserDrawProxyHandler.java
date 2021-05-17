package jeff.oodesign;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import jeff.oodesign.service.Shape;

public class UserDrawProxyHandler implements InvocationHandler{

	private Shape target;
	
	UserDrawProxyHandler(Shape shapeService){
		this.target = shapeService;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			System.out.println("invoking some pre-proceessing");
			return method.invoke(target, args);
		}  finally {
			System.out.println("invoking some post-processing");
		}
		
	}

}
