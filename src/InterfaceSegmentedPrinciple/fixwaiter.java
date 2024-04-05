package InterfaceSegmentedPrinciple;

interface WaiterInterface{
    void serveCustomers();
    void takeOrders();
}

interface ChefInterface{
    void cookFood();
    void decideMenu();
}

// no unnecessary function implementation
public class fixwaiter implements WaiterInterface{

    @Override
    public void serveCustomers() {
        System.out.println("Serving customers");
    }

    @Override
    public void takeOrders() {
        System.out.println("Taking orders");
    }
}

// no unnecessary function implementation
class fixchef implements ChefInterface{
    @Override
    public void cookFood() {

    }

    @Override
    public void decideMenu() {

    }
}