package FactoryPattern;

public class Main {
    public static void main(String[] args){
        ShapeFactory sp = new ShapeFactory();
        Shape circle = sp.getShape("CIRCLE");
        circle.draw();
        Shape square = sp.getShape("SQUARE");
        square.draw();
    }
}
