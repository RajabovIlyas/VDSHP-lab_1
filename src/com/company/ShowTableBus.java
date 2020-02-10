package com.company;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.company.DataClass.Airplane;
import com.company.DataClass.Bus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;

public class ShowTableBus {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Bus> tv1;

    @FXML
    private TableColumn<Bus,String> tc1;

    @FXML
    private TableColumn<Bus,String> tc2;

    @FXML
    private TableColumn<Bus,String> tc3;

    @FXML
    private TableColumn<Bus,String> tc4;

    @FXML
    private TableColumn<Bus,String> tc5;

    @FXML
    private TableColumn<Bus,String> tc6;

    @FXML
    private TableColumn<Bus,String> tc7;

    @FXML
    private TableColumn<Bus,String> tc8;

    @FXML
    private TableColumn<Bus,String> tc9;

    @FXML
    private TableColumn<Bus,String> tc10;

    @FXML
    private TableColumn<Bus,String> tc11;

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    void exitFromForm(MouseEvent event) {
        tv1.getScene().getWindow().hide();
    }

    @FXML
    void showChart(MouseEvent event) {
        tv1.setVisible(false);
        barChart.setVisible(true);
    }

    @FXML
    void showTable(MouseEvent event) {
        tv1.setVisible(true);
        barChart.setVisible(false);
    }

    @FXML
    void initialize() {
        initCols();
    }
    private void initCols(){
        tc1.setCellValueFactory(new PropertyValueFactory<Bus,String>("ID"));
        tc2.setCellValueFactory(new PropertyValueFactory<Bus,String>("departureDate"));
        tc3.setCellValueFactory(new PropertyValueFactory<Bus,String>("departureTime"));
        tc4.setCellValueFactory(new PropertyValueFactory<Bus,String>("fromCity"));
        tc5.setCellValueFactory(new PropertyValueFactory<Bus,String>("destination"));
        tc6.setCellValueFactory(new PropertyValueFactory<Bus,String>("departureStation"));
        tc7.setCellValueFactory(new PropertyValueFactory<Bus,String>("departurePlatform"));
        tc8.setCellValueFactory(new PropertyValueFactory<Bus,String>("arrivalStation"));
        tc9.setCellValueFactory(new PropertyValueFactory<Bus,String>("ticketPrice"));
        tc10.setCellValueFactory(new PropertyValueFactory<Bus,String>("busBrand"));
        tc11.setCellValueFactory(new PropertyValueFactory<Bus,String>("travelTime"));
    }



    public void getData(List<Bus> list) {
        ObservableList<Bus> dateserv= FXCollections.observableArrayList();
        dateserv.addAll(list);
        XYChart.Series set1= new XYChart.Series<>();
        for(Bus air: dateserv){
            set1.getData().add(new XYChart.Data(air.getFromCity()+"-"+air.getDestination(),air.getTicketPrice()));
        }
        barChart.getData().addAll(set1);
        tv1.setItems(dateserv);

    }
}
