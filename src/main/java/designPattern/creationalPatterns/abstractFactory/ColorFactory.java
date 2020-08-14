package designPattern.creationalPatterns.abstractFactory;

import designPattern.creationalPatterns.abstractFactory.color.Blue;
import designPattern.creationalPatterns.abstractFactory.color.Color;
import designPattern.creationalPatterns.abstractFactory.color.Green;
import designPattern.creationalPatterns.abstractFactory.color.Red;
import designPattern.creationalPatterns.abstractFactory.shape.Shape;

public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        } else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}