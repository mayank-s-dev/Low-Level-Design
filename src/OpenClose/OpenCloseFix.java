package OpenClose;

public class OpenCloseFix {

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

interface InvoiceDAOFix{
    public void save(Invoice invoice);
}

class DatabaseInvoiceDAO implements InvoiceDAOFix{
    @Override
    public void save(Invoice invoice) {
        // save to db
    }
}

class FileInvoiceDAO implements InvoiceDAOFix{
    @Override
    public void save(Invoice invoice) {
        // save to file
    }
}