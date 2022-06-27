package Decorator;

public class SupportPopupDecorator extends ColumnDecorator {
    public SupportPopupDecorator(Report report) {
        super(report);
    }

    public String getFirstColumnData() {
        return addPopup(super.getFirstColumnData());
    }

    public String addPopup(String data) {
        return data + " - support popup -";
    }
}
