package designPattern.creationalPatterns.factory;

import designPattern.creationalPatterns.abstractFactory.AbstractFactory;
import designPattern.creationalPatterns.abstractFactory.color.Color;
import designPattern.creationalPatterns.abstractFactory.shape.Circle;
import designPattern.creationalPatterns.abstractFactory.shape.Rectangle;
import designPattern.creationalPatterns.abstractFactory.shape.Shape;
import designPattern.creationalPatterns.abstractFactory.shape.Square;

public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}