package jeff.oodesign.service.impl;

import jeff.oodesign.service.Shape;

public class Square implements Shape{

	@Override
	public void draw() {
		System.out.println("Hello, m a square!");
	}

}
