package DecoratorPattern;

public class PizzaShop {
    public static void main(String[] args){
        BasePizza b = new Margherita();
        System.out.println("Base pizza cost: " + b.cost());

        // add cheese, basically every pizza will be a new base pizza
        b = new ExtraCheese(b);
        System.out.println("With cheese cost: " + b.cost());

        b = new Mushroom(b);
        System.out.println("With mushroom cost: " + b.cost());
    }
}
