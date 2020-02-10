package com.company;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.company.DataClass.Airplane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ShowTableAirplane {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Airplane> tv1;

    @FXML
    private TableColumn<Airplane,String> tc1;

    @FXML
    private TableColumn<Airplane,String> tc2;

    @FXML
    private TableColumn<Airplane,String> tc3;

    @FXML
    private TableColumn<Airplane,String> tc4;

    @FXML
    private TableColumn<Airplane,String> tc5;

    @FXML
    private TableColumn<Airplane,String> tc6;

    @FXML
    private TableColumn<Airplane,String> tc7;

    @FXML
    private TableColumn<Airplane,String> tc8;

    @FXML
    private TableColumn<Airplane,String> tc9;

    @FXML
    private TableColumn<Airplane,String> tc10;

    @FXML
    private TableColumn<Airplane,String> tc11;

    @FXML
    private TableColumn<Airplane,String> tc12;

    @FXML
    private TableColumn<Airplane,String> tc13;

    @FXML
    private TableColumn<Airplane,String> tc14;

    @FXML
    private TableColumn<Airplane,String> tc15;

    @FXML
    private TableColumn<Airplane,String> tc16;

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
        //barChart.setVisible(false);
    }

    @FXML
    void initialize() {initCols();
    }
    private void initCols(){
        tc1.setCellValueFactory(new PropertyValueFactory<Airplane,String>("ID"));
        tc2.setCellValueFactory(new PropertyValueFactory<Airplane,String>("departureDate"));
        tc3.setCellValueFactory(new PropertyValueFactory<Airplane,String>("departureTime"));
        tc4.setCellValueFactory(new PropertyValueFactory<Airplane,String>("fromCity"));
        tc5.setCellValueFactory(new PropertyValueFactory<Airplane,String>("destination"));
        tc6.setCellValueFactory(new PropertyValueFactory<Airplane,String>("departureAirport"));
        tc7.setCellValueFactory(new PropertyValueFactory<Airplane,String>("distance"));
        tc8.setCellValueFactory(new PropertyValueFactory<Airplane,String>("arrivalAirport"));
        tc9.setCellValueFactory(new PropertyValueFactory<Airplane,String>("ticketPrice"));
        tc10.setCellValueFactory(new PropertyValueFactory<Airplane,String>("typeTicket"));
        tc11.setCellValueFactory(new PropertyValueFactory<Airplane,String>("dateArrival"));
        tc12.setCellValueFactory(new PropertyValueFactory<Airplane,String>("timeArrival"));
        tc13.setCellValueFactory(new PropertyValueFactory<Airplane,String>("numberOfTransfers"));
        tc14.setCellValueFactory(new PropertyValueFactory<Airplane,String>("airlineName"));
        tc15.setCellValueFactory(new PropertyValueFactory<Airplane,String>("maximumLuggage"));
        tc16.setCellValueFactory(new PropertyValueFactory<Airplane,String>("maximumHandLuggage"));
    }



    public void getData(List<Airplane> list) {
        try {
            ObservableList<Airplane> dateserv = FXCollections.observableArrayList();
            dateserv.addAll(list);

        XYChart.Series set1= new XYChart.Series<>();
        for(Airplane air: dateserv){
            set1.getData().add(new XYChart.Data(air.getFromCity()+"-"+air.getDestination(),air.getTicketPrice()));
        }
        barChart.getData().addAll(set1);
            tv1.setItems(dateserv);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
