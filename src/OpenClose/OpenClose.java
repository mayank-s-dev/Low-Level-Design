package OpenClose;

public class OpenClose {
}

public class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity){
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal() {
        int price = ((marker.price) * this.quantity);
        return price;
    }
}


class InvoiceDAO{
    Invoice invoice;

    public InvoiceDAO(Invoice invoice){
        this.invoice = invoice;
    }

    public void saveToDB(){
        // save to db
    }

    // you can't add this function to existing class which is already live or tested. It will break open/close principle.
    // create fix it create interface
    public void saveToFile(){
          // save to file
    }
}


