package SingleResponsibility;

public class SingleResponsibility {

}

//this class doesn't follow single responsibility because it has multiple func to save to db, print invoice, if we create separate class for these functionality it will follow Single responsibility
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

    public void saveToDB(){
        // save to db
    }

    public void printInvoice(){
        // save to db
    }
}

// one responsibility to save to db
class InvoiceDAO{
    Invoice invoice;

    public InvoiceDAO(Invoice invoice){
        this.invoice = invoice;
    }

    public void saveToDB(){
        // save to db
    }
}

// one responsibility to print
class InvoicePrinter{
    Invoice invoice;

    public InvoicePrinter(Invoice invoice){
        this.invoice = invoice;
    }

    public void saveToDB(){
        // save to db
    }
}
