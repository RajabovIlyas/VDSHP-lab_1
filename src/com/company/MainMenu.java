package com.company;

import java.io.EOFException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import com.company.ClassRead.ReaderAll;
import com.company.DataClass.*;
import com.company.DataClass.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainMenu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup typeFileRead;

    @FXML
    private ToggleGroup Ticket;

    @FXML
    private DatePicker fromDate;

    @FXML
    private TextField fromTime;

    @FXML
    private DatePicker toDate;

    @FXML
    private TextField toTime;

    @FXML
    private TextField fromCity;

    @FXML
    private TextField toCity;

    @FXML
    void exit(MouseEvent event) {
        toCity.getScene().getWindow().hide();
    }

    @FXML
    void selectShow(MouseEvent event) {
        RadioButton button = (RadioButton) typeFileRead.getSelectedToggle();
        switch (button.getText()){
            case"XML":
                XMLData();
                break;
            case"Properties files":
                propertiesFilesData();
                break;
            case"CSV":
                CSVData();
                break;
            default:
                break;
        }
    }




    @FXML
    void initialize() {

    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void XMLData(){
        RadioButton button = (RadioButton) Ticket.getSelectedToggle();
        ReaderAll readerall=ReaderAll.getReaderAll();
        switch (button.getText()){
            case"Автобус":
                List<Bus> list = new ArrayList<>();
                readerall.XMLRead(list);
                checkDateBus(list);
                break;
            case"Поезд":
                List<Train> list2 = new ArrayList<>();
                readerall.XMLReadTrain(list2);
                checkDateTrain(list2);
                break;
            case"Самолет":
                List<Airplane> list3 = new ArrayList<>();
                readerall.XMLReadAirplane(list3);
                checkDateAirplane(list3);
                break;
            default:
                break;
        }
    }
    private void propertiesFilesData() {
        RadioButton button = (RadioButton) Ticket.getSelectedToggle();
        ReaderAll readerall=ReaderAll.getReaderAll();
        switch (button.getText()){
            case"Автобус":
                List<Bus> list = new ArrayList<Bus>();
                readerall.propertiesFilesRead(list);
                checkDateBus(list);
                break;
            case"Поезд":
                List<Train> list2 = new ArrayList<>();
                readerall.propertiesFilesReadTrain(list2);
                checkDateTrain(list2);
                break;
            case"Самолет":
                List<Airplane> list3 = new ArrayList<>();
                readerall.propertiesFilesReadAirplane(list3);
                checkDateAirplane(list3);
                break;
            default:
                break;
        }
    }
    private void CSVData() {
        RadioButton button = (RadioButton) Ticket.getSelectedToggle();
        ReaderAll readerall=ReaderAll.getReaderAll();
        switch (button.getText()){
            case"Автобус":
                List<Bus> list = new ArrayList<Bus>();
                readerall.CSVRead(list);
                checkDateBus(list);
                break;
            case"Поезд":
                List<Train> list2 = new ArrayList<>();
                readerall.CSVReadTrain(list2);
                checkDateTrain(list2);
                break;
            case"Самолет":
                List<Airplane> list3 = new ArrayList<>();
                readerall.CSVReadAirplane(list3);
                checkDateAirplane(list3);
                break;
            default:
                break;
        }
    }



    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////check data
    private void checkDateBus(List<Bus> list) {
        CompositeData Datalist= new CompositeData().addListBus(list);
        checkdata(Datalist);
        list.clear();
        Iterator iterator=Datalist.getIterator();

        while (iterator.hasNext()) {
            list.add((Bus) iterator.next());
        }
        showTableBus(list);
    }

    private void checkDateAirplane(List<Airplane> list) {
        CompositeData Datalist= new CompositeData().addListAirplane(list);
        checkdata(Datalist);
        list.clear();
        Iterator iterator=Datalist.getIterator();

        while (iterator.hasNext()) {
            list.add((Airplane) iterator.next());
        }
        showTableAirplane(list);
    }

    private void checkDateTrain(List<Train> list) {
        CompositeData Datalist= new CompositeData().addListTrain(list);
        checkdata(Datalist);
        list.clear();
        Iterator iterator=Datalist.getIterator();
        while (iterator.hasNext()) {
            list.add((Train) iterator.next());
        }
        showTableTrain(list);
    }



    private void checkdata(CompositeData list) {
        try {
            list.checkCityFrom(fromCity.getText());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            list.checkCityTo(toCity.getText());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            list.checkTimeSmaller(toTime.getText().split(":"));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            list.checkTimeMore(fromTime.getText().split(":"));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            list.checkdateMore(sdf.parse(fromDate.getValue().toString()));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            list.checkdateSmaller(sdf.parse(toDate.getValue().toString()));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////show form

    public void showTableBus(List<Bus> list){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/ShowTableBus.fxml")); // название FXML которое надо открыть
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Расписание автобусов");
            stage.setScene(new Scene(root, 700, 400)); // размеры нового окна
            ShowTableBus controllerEditBook = fxmlLoader.getController(); //получаем контроллер для второй формы
            controllerEditBook.getData(list); // передаем необходимые параметры
            stage.show();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void showTableTrain(List<Train> list) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/ShowTableTrain.fxml")); // название FXML которое надо открыть
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Расписание поездов");
            stage.setScene(new Scene(root, 700, 400)); // размеры нового окна
            ShowTableTrain controllerEditBook = fxmlLoader.getController(); //получаем контроллер для второй формы
            controllerEditBook.getData(list); // передаем необходимые параметры
            stage.show();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void showTableAirplane(List<Airplane> list) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/ShowTableAirplane.fxml")); // название FXML которое надо открыть
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Расписание самолетов");
            stage.setScene(new Scene(root, 700, 400)); // размеры нового окна
            ShowTableAirplane controllerEdit = fxmlLoader.getController(); //получаем контроллер для второй формы
            controllerEdit.getData(list); // передаем необходимые параметры
            stage.show();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
