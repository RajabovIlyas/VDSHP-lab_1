package com.company.ClassRead;

import com.company.DataClass.Airplane;
import com.company.DataClass.Bus;
import com.company.DataClass.Train;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class ReaderAll {
    private static ReaderAll readerall;

    public static synchronized ReaderAll getReaderAll() {
        if (readerall == null) {
            readerall = new ReaderAll();
        }
        return readerall;
    }

    public void XMLRead(List<Bus> bus) {
        File fXmlFile = new File("src/com/company/DataFile/file.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Bus");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    bus.add(new Bus(Integer.parseInt(eElement.getElementsByTagName("ID").item(0).getTextContent()),
                            eElement.getElementsByTagName("departureDate").item(0).getTextContent(),
                            eElement.getElementsByTagName("departureTime").item(0).getTextContent(),
                            eElement.getElementsByTagName("destination").item(0).getTextContent(),
                            eElement.getElementsByTagName("departureStation").item(0).getTextContent(),
                            eElement.getElementsByTagName("departurePlatform").item(0).getTextContent(),
                            eElement.getElementsByTagName("arrivalStation").item(0).getTextContent(),
                            Double.valueOf(eElement.getElementsByTagName("ticketPrice").item(0).getTextContent()),
                            eElement.getElementsByTagName("busBrand").item(0).getTextContent(),
                            eElement.getElementsByTagName("travelTime").item(0).getTextContent(),
                            eElement.getElementsByTagName("fromcity").item(0).getTextContent()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void XMLReadTrain(List<Train> train) {
        File fXmlFile = new File("src/com/company/DataFile/file.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Train");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    train.add(new Train(Integer.parseInt(eElement.getElementsByTagName("ID").item(0).getTextContent()),
                            eElement.getElementsByTagName("departureDate").item(0).getTextContent(),
                            eElement.getElementsByTagName("departureTime").item(0).getTextContent(),
                            eElement.getElementsByTagName("destination").item(0).getTextContent(),
                            eElement.getElementsByTagName("departureStation").item(0).getTextContent(),
                            eElement.getElementsByTagName("departurePlatform").item(0).getTextContent(),
                            eElement.getElementsByTagName("arrivalStation").item(0).getTextContent(),
                            Double.valueOf(eElement.getElementsByTagName("ticketPrice").item(0).getTextContent()),
                            eElement.getElementsByTagName("typeTicket").item(0).getTextContent(),
                            eElement.getElementsByTagName("dateOfArrival").item(0).getTextContent(),
                            eElement.getElementsByTagName("timeOfArrival").item(0).getTextContent(),
                            eElement.getElementsByTagName("fromCity").item(0).getTextContent()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void XMLReadAirplane(List<Airplane> airplane) {
        File fXmlFile = new File("src/com/company/DataFile/file.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Airline");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    airplane.add(new Airplane(Integer.parseInt(eElement.getElementsByTagName("ID").item(0).getTextContent()),
                            eElement.getElementsByTagName("departureDate").item(0).getTextContent(),
                            eElement.getElementsByTagName("departureTime").item(0).getTextContent(),
                            eElement.getElementsByTagName("destination").item(0).getTextContent(),
                            eElement.getElementsByTagName("departureAirport").item(0).getTextContent(),
                            eElement.getElementsByTagName("distance").item(0).getTextContent(),
                            eElement.getElementsByTagName("arrivalAirport").item(0).getTextContent(),
                            Double.valueOf(eElement.getElementsByTagName("ticketPrice").item(0).getTextContent()),
                            eElement.getElementsByTagName("typeTicket").item(0).getTextContent(),
                            eElement.getElementsByTagName("dateOfArrival").item(0).getTextContent(),
                            eElement.getElementsByTagName("timeOfArrival").item(0).getTextContent(),
                            Integer.parseInt(eElement.getElementsByTagName("numberOfTransfers").item(0).getTextContent()),
                            eElement.getElementsByTagName("airlineName").item(0).getTextContent(),
                            eElement.getElementsByTagName("maximumLuggage").item(0).getTextContent(),
                            eElement.getElementsByTagName("doublemaximumHandLuggage").item(0).getTextContent(),
                            eElement.getElementsByTagName("fromCity").item(0).getTextContent()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void propertiesFilesRead(List<Bus> list) {
        Properties prop;
        InputStream stream = null;
        InputStreamReader reader = null;
        try {
            stream = new FileInputStream(new File("src/com/company/DataFile/file.properties"));
            reader = new InputStreamReader(stream, "windows-1251");
            prop = new Properties();
            prop.load(reader);

            // load a properties file
            for (int i = 1; i <= Integer.parseInt(prop.getProperty("bus")); i++) {
                list.add(new Bus(Integer.parseInt(prop.getProperty("bus." + i + ".ID")),
                        prop.getProperty("bus." + i + ".departureDate"),
                        prop.getProperty("bus." + i + ".departureTime"),
                        prop.getProperty("bus." + i + ".destination"),
                        prop.getProperty("bus." + i + ".departureStation"),
                        prop.getProperty("bus." + i + ".departurePlatform"),
                        prop.getProperty("bus." + i + ".arrivalStation"),
                        Double.valueOf(prop.getProperty("bus." + i + ".ticketPrice")),
                        prop.getProperty("bus." + i + ".busBrand"),
                        prop.getProperty("bus." + i + ".travelTime"),
                        prop.getProperty("bus." + i + ".fromcity")));
                System.out.println(prop.getProperty("bus." + i + ".departureDate"));
            }
            // get the property value and print it out

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void propertiesFilesReadAirplane(List<Airplane> list) {
        Properties prop;
        InputStream stream = null;
        InputStreamReader reader = null;
        try {
            stream = new FileInputStream(new File("src/com/company/DataFile/file.properties"));
            reader = new InputStreamReader(stream, "windows-1251");
            prop = new Properties();
            prop.load(reader);

            // load a properties file
            for (int i = 1; i <= Integer.parseInt(prop.getProperty("airplane")); i++) {
                list.add(new Airplane(Integer.parseInt(prop.getProperty("airplane." + i + ".ID")),
                        prop.getProperty("airplane." + i + ".departureDate"),
                        prop.getProperty("airplane." + i + ".departureTime"),
                        prop.getProperty("airplane." + i + ".destination"),
                        prop.getProperty("airplane." + i + ".departureAirport"),
                        prop.getProperty("airplane." + i + ".distance"),
                        prop.getProperty("airplane." + i + ".arrivalAirport"),
                        Double.valueOf(prop.getProperty("airplane." + i + ".ticketPrice")),
                        prop.getProperty("airplane." + i + ".typeTicket"),
                        prop.getProperty("airplane." + i + ".dateOfArrival"),
                        prop.getProperty("airplane." + i + ".timeOfArrival"),
                        Integer.parseInt(prop.getProperty("airplane." + i + ".numberOfTransfers")),
                        prop.getProperty("airplane." + i + ".airlineName"),
                        prop.getProperty("airplane." + i + ".maximumLuggage"),
                        prop.getProperty("airplane." + i + ".maximumHandLuggage"),
                        prop.getProperty("airplane." + i + ".fromCity")));
            }
            // get the property value and print it out

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void propertiesFilesReadTrain(List<Train> list) {
        Properties prop;
        InputStream stream = null;
        InputStreamReader reader = null;
        try {
            stream = new FileInputStream(new File("src/com/company/DataFile/file.properties"));
            reader = new InputStreamReader(stream, "windows-1251");
            prop = new Properties();
            prop.load(reader);

            // load a properties file
            for (int i = 1; i <= Integer.parseInt(prop.getProperty("train")); i++) {
                list.add(new Train(Integer.parseInt(prop.getProperty("train." + i + ".ID")),
                        prop.getProperty("train." + i + ".departureDate"),
                        prop.getProperty("train." + i + ".departureTime"),
                        prop.getProperty("train." + i + ".destination"),
                        prop.getProperty("train." + i + ".departureStation"),
                        prop.getProperty("train." + i + ".departurePlatform"),
                        prop.getProperty("train." + i + ".arrivalStation"),
                        Double.valueOf(prop.getProperty("train." + i + ".ticketPrice")),
                        prop.getProperty("train." + i + ".typeTicket"),
                        prop.getProperty("train." + i + ".dateOfArrival"),
                        prop.getProperty("train." + i + ".timeOfArrival"),
                        prop.getProperty("train." + i + ".fromCity")));
            }
            // get the property value and print it out

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void CSVRead(List<Bus> list) {
        try {
            //Build reader instance
            //Read data.csv
            //Default seperator is comma
            //Default quote character is double quote
            //Start reading from line number 2 (line numbers start from zero)
            CSVReader reader = new CSVReader(new FileReader("src/com/company/DataFile/bus.csv"), ',' , '"' , 1);
            //Read all rows at once
            List<String[]> allRows = reader.readAll();
            //Read CSV line by line and use the string array as you want
            for(String[] row : allRows){
                list.add(new Bus(Integer.parseInt(row[0]), row[1], row[2], row[3], row[4],
                        row[5], row[6], Double.valueOf(row[7]), row[8], row[9], row[10]));
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }


    public void CSVReadTrain(List<Train> list) {
        try {
            CSVReader reader = new CSVReader(new FileReader("src/com/company/DataFile/train.csv"), ',' , '"' , 1);
            List<String[]> allRows = reader.readAll();
            for(String[] row : allRows){
                list.add(new Train(Integer.parseInt(row[0]), row[1], row[2], row[3], row[4],
                        row[5], row[6], Double.valueOf(row[7]), row[8], row[9], row[10], row[11]));
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void CSVReadAirplane(List<Airplane> list) {
        try {
            CSVReader reader = new CSVReader(new FileReader("src/com/company/DataFile/airplane.csv"), ',' , '"' , 1);
            List<String[]> allRows = reader.readAll();
            for(String[] row : allRows){
                list.add(new Airplane(Integer.parseInt(row[0]), row[1], row[2], row[3], row[4],
                        row[5], row[6], Double.valueOf(row[7]), row[8], row[9], row[10], Integer.parseInt(row[11]), row[12], row[13], row[14], row[15]));
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
