package InterfaceSegmentedPrinciple;

interface RestaurantEmployee{
    void washDishes();
    void serverCustomer();
    void cookFood();
}

// waiter is a restaurent employee, but waiter class needs to implement all RestaurantEmployee functions, to fix this create smaller interface
class waiter implements RestaurantEmployee {
    @Override
    public void serverCustomer() {
        System.out.println("serving the customer");
    }

    @Override
    public void cookFood() {
        // not my job
    }

    @Override
    public void washDishes() {
        // not my job
    }
}


