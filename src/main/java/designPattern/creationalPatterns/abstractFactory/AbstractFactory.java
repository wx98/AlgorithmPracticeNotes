package designPattern.creationalPatterns.abstractFactory;

import designPattern.creationalPatterns.abstractFactory.color.Color;
import designPattern.creationalPatterns.abstractFactory.shape.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}