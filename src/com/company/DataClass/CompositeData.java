package com.company.DataClass;

import java.io.EOFException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompositeData implements Collection {
    private List<FilterCheck> list=new ArrayList<FilterCheck>();
    public void add(FilterCheck data){
        list.add(data);
    }
    public void remove(int index){
        list.remove(index);
    }

    public List<FilterCheck> getList() {
        return list;
    }

    public CompositeData addListBus(List<Bus> check){
        list.addAll(check);
        return this;
    }

    public CompositeData addListTrain(List<Train> check){
        list.addAll(check);
        return this;
    }

    public CompositeData addListAirplane(List<Airplane> check){
        list.addAll(check);
        return this;    }

    public void checkdateMore(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(int i=0;i<list.size();i++){
            Date listdate=sdf.parse(list.get(i).getDepartureDate());
            if(date.compareTo(listdate) > 0){
                list.remove(i--);
            }
        }
    }

    public void checkdateSmaller(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(int i=0;i<list.size();i++){
            Date listdate=sdf.parse(list.get(i).getDepartureDate());
            if(date.compareTo(listdate) < 0){
                list.remove(i--);
            }
        }
    }
    public void checkTimeSmaller(String[] subStr){
        for(int i=0;i<list.size();i++){
            String[] subData=list.get(i).getDepartureTime().split(":");
            if(Integer.parseInt(subStr[0])<Integer.parseInt(subData[0])||
                    ((Integer.parseInt(subStr[0])==Integer.parseInt(subData[0])&&(Integer.parseInt(subStr[1])<Integer.parseInt(subData[1]))))){
                list.remove(i--);
            }
        }
    }

    public void checkTimeMore(String[] subStr){
        for(int i=0;i<list.size();i++){
            String[] subData=list.get(i).getDepartureTime().split(":");
            if(Integer.parseInt(subStr[0])>Integer.parseInt(subData[0])||
                    ((Integer.parseInt(subStr[0])==Integer.parseInt(subData[0])&&(Integer.parseInt(subStr[1])>Integer.parseInt(subData[1]))))){
                list.remove(i--);
            }
        }
    }

    public void checkCityFrom(String fromCity) throws EOFException {
        if (fromCity.length()==0){
            throw new EOFException();
        }
        for(int i=0;i<list.size();i++){
            if(!fromCity.equals(list.get(i).getFromCity())){
                list.remove(i--);
            }
        }
    }

    public void checkCityTo(String toCity) throws EOFException {
        if (toCity.length()==0){
            throw new EOFException();
        }
        for(int i=0;i<list.size();i++){
            if(!toCity.equals(list.get(i).getDestination())){
                list.remove(i--);
            }
        }
    }

    @Override
    public Iterator getIterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator{
        private int index;
        @Override
        public boolean hasNext() {
            if(index<list.size()){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return list.get(index++);
        }
    }
}
