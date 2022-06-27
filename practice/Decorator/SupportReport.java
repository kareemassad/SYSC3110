package Decorator;

public class SupportReport implements Report {

    @Override
    public Object[][] getReportData(final String reportID) {
        return null;
    }

    @Override
    public String getFirstColumnData() {
        return "Support Data";
    }
}
