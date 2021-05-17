package jeff.oodesign;

import java.lang.reflect.InvocationTargetException;

public class DrawTest {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		UserDrawHandler ud = new UserDrawHandler();
		ud.draw(SHAPE_STRATEGY.CIRCLE);
	}

}
