package OpenClose;

public class OpenCloseFix {

}

class FixInvoice {
    private Marker marker;
    private int quantity;

    public FixInvoice(Marker marker, int quantity){
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal() {
        int price = ((marker.price) * this.quantity);
        return price;
    }
}

interface InvoiceDAOFix{
    public void save(FixInvoice invoice);
}

class DatabaseInvoiceDAO implements InvoiceDAOFix{
    @Override
    public void save(FixInvoice invoice) {
        // save to db
    }
}

class FileInvoiceDAO implements InvoiceDAOFix{
    @Override
    public void save(FixInvoice invoice) {
        // save to file
    }
}