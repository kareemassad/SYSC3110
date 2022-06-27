public abstract class Bill {

    private int minutes;
    private double rate;
    private String type;
    private static double GST = 0.9;

    public final void buildBill(){
        getPhoneBillTotal();
        getInternetBillTotal();
        System.out.println("Bill is built");
    }

    public abstract double getPhoneBillTotal();

    public abstract double getInternetBillTotal();

    public double getBillableAmount() {
        double total = getInternetBillTotal() + getPhoneBillTotal();
        return total;
    }
}

public class PhoneBill extends Bill{
    double GST = 0.13;
    double minutes;
    double rate;

    public PhoneBill(int m, double r, String t) {
        minutes = m;
        rate = r;
    }

    @Override
    public double getPhoneBillTotal() {

        double base = 20 + minutes * rate;
        double tax = base * GST * 0.2;
        return base + tax;
    }
}
public class InternetBill extends Bill{
    double GST = 0.13;
    double minutes;
    double rate;

    public InternetBill(int m, double r, String t) {
        minutes = m;
        rate = r;
    }

    @Override
    public double getInternetBillTotal() {

        double base = 30 + minutes * rate;
        double tax = base * GST;
        double total = base + tax;
        return total;
    }
}