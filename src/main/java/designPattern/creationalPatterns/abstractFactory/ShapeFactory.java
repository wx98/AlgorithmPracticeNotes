package designPattern.creationalPatterns.abstractFactory;

import designPattern.creationalPatterns.abstractFactory.color.Color;
import designPattern.creationalPatterns.abstractFactory.shape.Circle;
import designPattern.creationalPatterns.abstractFactory.shape.Rectangle;
import designPattern.creationalPatterns.abstractFactory.shape.Shape;
import designPattern.creationalPatterns.abstractFactory.shape.Square;

public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        if (shape == null) {
            return null;
        }
        if (shape.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shape.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shape.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}