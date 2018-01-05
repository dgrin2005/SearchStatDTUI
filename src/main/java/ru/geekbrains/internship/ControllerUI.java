package ru.geekbrains.internship;

import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerUI implements Initializable, ConnectionDBConst {

    private StartWindow mainApp;
    private Command getTotalStatisticsCommand;
    private Command getDailylStatisticsCommand;

    @FXML
    private ChoiceBox<String> totalStatisticsSite;
    @FXML
    private Button totalStatisticsUpdateButton;
    @FXML
    private TableView<TotalStatistics> totalStatisticsTable;
    @FXML
    private TableColumn<TotalStatistics, String> tstColumnName;
    @FXML
    private TableColumn<TotalStatistics, Number> tstColumnQuantity;
    @FXML
    private ChoiceBox<String> dailyStatisticsSite;
    @FXML
    private ChoiceBox<String> dailyStatisticsName;
    @FXML
    private DatePicker dailyStatisticsBeginDate;
    @FXML
    private DatePicker dailyStatisticsEndDate;
    @FXML
    private Button dailyStatisticsUpdateButton;
    @FXML
    private TableView<DailyStatistics> dailyStatisticsTable;
    @FXML
    private TableColumn<DailyStatistics, String> dstColumnDate;
    @FXML
    private TableColumn<DailyStatistics, Number> dstColumnQuantity;
    @FXML
    private TextField dailyStatisticsTotalQuantity;
    @FXML
    private PieChart totalStatisticsChart;
    @FXML
    private LineChart<String, Number> dailyStatisticsChart;

    public void setMainApp(StartWindow mainApp) {
        this.mainApp = mainApp;
        getTotalStatisticsCommand = new GetTotalStatisticsCommand(this.mainApp, totalStatisticsSite,
                totalStatisticsTable, totalStatisticsChart);
        getDailylStatisticsCommand = new GetDailylStatisticsCommand(mainApp, dailyStatisticsSite,dailyStatisticsName, dailyStatisticsBeginDate,
                dailyStatisticsEndDate, dailyStatisticsTable, dailyStatisticsTotalQuantity,
                dailyStatisticsChart);
    }

    public void pressTotalStatisticsUpdateButton() {
        getTotalStatisticsCommand.execute();
    }

    public void pressDailyStatisticsUpdateButton() {
        getDailylStatisticsCommand.execute();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tstColumnName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tstColumnQuantity.setCellValueFactory(cellData -> cellData.getValue().quantityProperty());
        dstColumnDate.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        dstColumnQuantity.setCellValueFactory(cellData -> cellData.getValue().quantityProperty());
    }

    public void fillLists() {

        ObservableList<String> sites;
        /*
        totalStatisticsSite.setItems(mainApp.getRequestDB().getSites(mainApp.getDBStringURL()));
        dailyStatisticsSite.setItems(mainApp.getRequestDB().getSites(mainApp.getDBStringURL()));
        dailyStatisticsName.setItems(mainApp.getRequestDB().getNames(mainApp.getDBStringURL()));
        */
        sites = mainApp.getRequestDB().getList(mainApp.getDBStringURL(), GETSITES);
        totalStatisticsSite.setItems(sites);
        dailyStatisticsSite.setItems(sites);
        dailyStatisticsName.setItems(mainApp.getRequestDB().getList(mainApp.getDBStringURL(), GETPERSONS));
    }

}
