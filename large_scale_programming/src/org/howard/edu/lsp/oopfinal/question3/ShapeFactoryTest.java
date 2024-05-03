package org.howard.edu.lsp.oopfinal.question3;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ShapeFactoryTest {

    @Test
    public void testCreateCircle() {
        ShapeFactory factory = new ShapeFactory();
        Shape shape = factory.getShape("CIRCLE");
        assertNotNull(shape);
        assertTrue(shape instanceof Circle);
    }

    @Test
    public void testCreateRectangle() {
        ShapeFactory factory = new ShapeFactory();
        Shape shape = factory.getShape("RECTANGLE");
        assertNotNull(shape);
        assertTrue(shape instanceof Rectangle);
    }
}
