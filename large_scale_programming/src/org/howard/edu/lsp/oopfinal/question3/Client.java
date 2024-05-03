package org.howard.edu.lsp.oopfinal.question3;

public class Client {

	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();

        Shape circle = factory.getShape("CIRCLE");
        circle.draw();

        Shape rectangle = factory.getShape("RECTANGLE");
        rectangle.draw();

	}

}
