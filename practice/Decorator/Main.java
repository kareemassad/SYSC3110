package Decorator;

public class Main {
    public static void main(String[] args) {
        SupportPopupDecorator supportPopupDecorator = new SupportPopupDecorator(
                new SupportLinkDecorator(new SupportReport()));

        System.out.println(supportPopupDecorator.getFirstColumnData());
    }
}
