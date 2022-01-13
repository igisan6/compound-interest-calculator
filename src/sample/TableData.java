package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

// TableData class for populating data into the table
// Consists of year, opening balance, interest, and closing balance
public class TableData {
    public SimpleIntegerProperty year;
    public SimpleStringProperty openingBalance, interest, closingBalance;

    // Constructor for TableData
    TableData(Integer year, String openingBalance, String interest, String closingBalance) {
        this.year = new SimpleIntegerProperty(year);
        this.openingBalance = new SimpleStringProperty(openingBalance);
        this.interest = new SimpleStringProperty(interest);
        this.closingBalance = new SimpleStringProperty(closingBalance);
    }

    // Getter and setter methods for year, opening balance, interest, and closing balance
    public int getYear() { return year.get(); }
    public void setYear(int year) { this.year = new SimpleIntegerProperty(year); }

    public String getOpeningBalance() { return openingBalance.get(); }
    public void setOpeningBalance(String openingBalance) { this.openingBalance = new SimpleStringProperty(openingBalance); }

    public String getInterest() { return interest.get(); }
    public void setInterest(String interest) { this.interest = new SimpleStringProperty(interest); }

    public String getClosingBalance() { return closingBalance.get(); }
    public void setClosingBalance(String closingBalance) { this.closingBalance = new SimpleStringProperty(closingBalance); }
}
