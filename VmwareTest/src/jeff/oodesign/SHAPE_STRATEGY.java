package jeff.oodesign;

import java.lang.reflect.InvocationTargetException;

import jeff.oodesign.service.Shape;
import jeff.oodesign.service.impl.Circle;
import jeff.oodesign.service.impl.Rectangle;
import jeff.oodesign.service.impl.Square;

public enum SHAPE_STRATEGY {
	CIRCLE(Circle.class),
	RECTANGLE(Rectangle.class),
	SQUARE(Square.class);
	
	
	private Class<?> shapeClass;
	
	SHAPE_STRATEGY(Class<?> shapeClass) {
		if(!Shape.class.isAssignableFrom(shapeClass)) {
			throw new RuntimeException("Only implementation of interface Shape is allowed here");
		}
		this.shapeClass = shapeClass;
	}
	
	public Shape getShapeInstance() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		return (Shape) shapeClass.getConstructor().newInstance();
	}
	
}
