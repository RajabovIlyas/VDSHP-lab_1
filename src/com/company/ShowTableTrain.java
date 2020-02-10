package com.company;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.company.DataClass.Bus;
import com.company.DataClass.Train;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ShowTableTrain {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Train> tv1;

    @FXML
    private TableColumn<Train,String> tc1;

    @FXML
    private TableColumn<Train,String> tc2;

    @FXML
    private TableColumn<Train,String> tc3;

    @FXML
    private TableColumn<Train,String> tc4;

    @FXML
    private TableColumn<Train,String> tc5;

    @FXML
    private TableColumn<Train,String> tc6;

    @FXML
    private TableColumn<Train,String> tc7;

    @FXML
    private TableColumn<Train,String> tc8;

    @FXML
    private TableColumn<Train,String> tc9;

    @FXML
    private TableColumn<Train,String> tc10;

    @FXML
    private TableColumn<Train,String> tc11;

    @FXML
    private TableColumn<Train,String> tc12;

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
        tc1.setCellValueFactory(new PropertyValueFactory<Train,String>("ID"));
        tc2.setCellValueFactory(new PropertyValueFactory<Train,String>("departureDate"));
        tc3.setCellValueFactory(new PropertyValueFactory<Train,String>("departureTime"));
        tc4.setCellValueFactory(new PropertyValueFactory<Train,String>("fromCity"));
        tc5.setCellValueFactory(new PropertyValueFactory<Train,String>("destination"));
        tc6.setCellValueFactory(new PropertyValueFactory<Train,String>("departureStation"));
        tc7.setCellValueFactory(new PropertyValueFactory<Train,String>("departurePlatform"));
        tc8.setCellValueFactory(new PropertyValueFactory<Train,String>("arrivalStation"));
        tc9.setCellValueFactory(new PropertyValueFactory<Train,String>("ticketPrice"));
        tc10.setCellValueFactory(new PropertyValueFactory<Train,String>("typeTicket"));
        tc11.setCellValueFactory(new PropertyValueFactory<Train,String>("dateOfArrival"));
        tc12.setCellValueFactory(new PropertyValueFactory<Train,String>("timeOfArrival"));
    }



    public void getData(List<Train> list) {
        ObservableList<Train> dateserv= FXCollections.observableArrayList();
        dateserv.addAll(list);
        XYChart.Series set1= new XYChart.Series<>();
        for(Train air: dateserv){
            set1.getData().add(new XYChart.Data(air.getFromCity()+"-"+air.getDestination(),air.getTicketPrice()));
        }
        barChart.getData().addAll(set1);
        tv1.setItems(dateserv);
    }
}
