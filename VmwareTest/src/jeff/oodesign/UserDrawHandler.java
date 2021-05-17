package jeff.oodesign;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

import jeff.oodesign.service.Shape;

public class UserDrawHandler {

	public void draw(SHAPE_STRATEGY SHAPE_STRATEGY) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if(SHAPE_STRATEGY == null) {
			System.out.println("Shape strategy can't be null!");
		}
		
		Shape shapeService = SHAPE_STRATEGY.getShapeInstance();
		
		
		Shape proxy = (Shape) Proxy.newProxyInstance(shapeService.getClass().getClassLoader(), 
				new Class[] {Shape.class}, new UserDrawProxyHandler(shapeService));
		
		proxy.draw();
	}
}
