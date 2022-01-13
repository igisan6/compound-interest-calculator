package sample;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Controller {
    // List for values of the compounding frequency drop-down
    ObservableList<String> frequencyList = FXCollections.observableArrayList("Monthly", "Quarterly", "Semi-annually", "Annually");

    // FXML Elements
    @FXML private TextField principalText;
    @FXML private TextField interestText;
    @FXML private ChoiceBox frequencyChoice;
    @FXML private TextField yearText;
    @FXML private TableView table;
    @FXML private TableColumn yearColumn;
    @FXML private TableColumn openingBalanceColumn;
    @FXML private TableColumn interestColumn;
    @FXML private TableColumn closingBalanceColumn;
    @FXML private BarChart<String, Double> barchart;

    @FXML // Initialize Compounding Frequency drop-down values
    private void initializeFrequency() { frequencyChoice.setItems(frequencyList); }

    @FXML // Calculate values from user input
    public void calculateOnPress() {
        // If the table view and bar chart have existing data, clear it before calculating compounding interest
        table.getItems().clear();
        barchart.getData().clear();

        // Creates data structures for the table view and bar chart
        ObservableList<TableData> dataList = FXCollections.observableArrayList();
        XYChart.Series<String, Double> series = new XYChart.Series<>();

        // Variables for calculating the principal, interest, opening and closing balance
        int yearValue;
        double principalValue, interestValue, frequencyValue, interest;
        principalValue = Double.parseDouble(principalText.getText());
        interestValue = Double.parseDouble(interestText.getText());
        yearValue = Integer.parseInt(yearText.getText());

        // Sets values for frequency from the drop-down menu
        frequencyValue = switch (String.valueOf(frequencyChoice.getValue())) {
            case "Monthly" -> 12;
            case "Quarterly" -> 4;
            case "Semi-annually" -> 2;
            case "Annually" -> 1;
            default -> 0;
        };

        // Calculates and formats opening balance, interest, and closing balance for each year
        // Adds each calculation to the table and bar chart
        for (int i = 1; i <= yearValue; i++) {
            interest = principalValue * Math.pow((1 + (interestValue / 100) / frequencyValue), (frequencyValue * 1)) - principalValue;
            principalValue += interest;
            BigDecimal ob = new BigDecimal(principalValue - interest).setScale(2, RoundingMode.HALF_UP);
            BigDecimal in = new BigDecimal(interest).setScale(2, RoundingMode.HALF_UP);
            BigDecimal p = new BigDecimal(principalValue).setScale(2, RoundingMode.HALF_UP);
            dataList.add(new TableData(i, String.format("$%,.2f", ob.doubleValue()), String.format("$%,.2f", in.doubleValue()), String.format("$%,.2f", p.doubleValue())));
            series.getData().add(new XYChart.Data<>(String.valueOf(i), ob.doubleValue()));
        }

        // Sets the values for the columns in the table view, and adds opening balances to the bar chart
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        openingBalanceColumn.setCellValueFactory(new PropertyValueFactory<>("openingBalance"));
        interestColumn.setCellValueFactory(new PropertyValueFactory<>("interest"));
        closingBalanceColumn.setCellValueFactory(new PropertyValueFactory<>("closingBalance"));
        table.setItems(dataList);
        barchart.getData().addAll(series);
        barchart.setLegendVisible(false);
    }
}