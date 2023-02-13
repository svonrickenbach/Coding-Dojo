//package com.codingdojo.relationships.utilities;
//
//import java.beans.PropertyEditorSupport;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class DateEditor extends PropertyEditorSupport {
//
//    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//    @Override
//    public void setAsText(String text) throws IllegalArgumentException {
//        try {
//            Date date = dateFormat.parse(text);
//            setValue(date);
//        } catch (ParseException e) {
//            setValue(null);
//        }
//    }
//
//    @Override
//    public String getAsText() {
//        return dateFormat.format((Date) getValue());
//    }
//
//}
