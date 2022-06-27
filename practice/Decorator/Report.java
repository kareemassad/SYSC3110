package Decorator;

public interface Report {
    public Object[][] getReportData(final String reportID);

    public String getFirstColumnData();
}
