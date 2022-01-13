package sample;

import static org.junit.jupiter.api.Assertions.*;

class TableDataTest {
    private TableData test1;
    private TableData test2;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        test1 = new TableData(1, "1000", "1", "2000");
        test2 = new TableData(5, "5000", "5", "10000");
    }

    @org.junit.jupiter.api.Test
    void getYear() {
        System.out.println(test1.getYear());
    }

    @org.junit.jupiter.api.Test
    void setYear() {
        test1.setYear(5);
        assertEquals(test2.getYear(), test1.getYear());
    }

    @org.junit.jupiter.api.Test
    void getOpeningBalance() {
        System.out.println(test1.getOpeningBalance());
    }

    @org.junit.jupiter.api.Test
    void setOpeningBalance() {
        test1.setOpeningBalance("5000");
        assertEquals(test2.getOpeningBalance(), test1.getOpeningBalance());
    }

    @org.junit.jupiter.api.Test
    void getInterest() {
        System.out.println(test1.getInterest());
    }

    @org.junit.jupiter.api.Test
    void setInterest() {
        test1.setInterest("5");
        assertEquals(test2.getInterest(), test1.getInterest());
    }

    @org.junit.jupiter.api.Test
    void getClosingBalance() {
        System.out.println(test1.getClosingBalance());
    }

    @org.junit.jupiter.api.Test
    void setClosingBalance() {
        test1.setClosingBalance("10000");
        assertEquals(test2.getClosingBalance(), test1.getClosingBalance());
    }
}