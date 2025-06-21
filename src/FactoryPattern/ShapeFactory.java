package FactoryPattern;

public class ShapeFactory {
    Shape getShape(String input){
        return switch (input) {
            case "CIRCLE" -> new Circle();
            case "SQUARE" -> new Square();
            default -> null;
        };
    }
}
