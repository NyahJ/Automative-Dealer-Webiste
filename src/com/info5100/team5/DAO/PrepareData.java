package com.info5100.team5.DAO;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class PrepareData  {

    public PrepareData(){}
    
    
    public Vector<String> fetchData(ResultSet rs) throws SQLException {
    	Vector<String> columnValues = new Vector<String>();
        ResultSetMetaData data = rs.getMetaData();
        int columnCount = data.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                columnValues.add(rs.getString(i));
            }
        }
        return columnValues;
    }

    

    public String fetchSelectedResult(HashMap<String,String> selectedOption) {
        StringBuilder sb = new StringBuilder();
        if(selectedOption.containsKey("brand")) {
            if(sb.length() > 0)
            {
                sb.append(" and ");
            }
            sb.append("brand = '"+selectedOption.get("brand")+"'");
        }

        if(selectedOption.containsKey("model")) {
            if(sb.length() > 0)
            {
                sb.append(" and ");
            }
            sb.append("model = '"+selectedOption.get("model")+"'");
        }

        if(selectedOption.containsKey("type")) {
            if(sb.length() > 0)
            {
                sb.append(" and ");
            }
            sb.append("type = '"+selectedOption.get("type")+"'");
        }

        if(selectedOption.containsKey("category")) {
            if(sb.length() > 0)
            {
                sb.append(" and ");
            }
            sb.append("category = '"+selectedOption.get("category")+"'");
        }

        if(selectedOption.containsKey("color")) {
            if(sb.length() > 0)
            {
                sb.append(" and ");
            }
            sb.append("color = '"+selectedOption.get("color")+"'");
        }

        if(selectedOption.containsKey("year")) {

                if(sb.length() > 0)
                {
                    sb.append(" and ");
                }
                sb.append("dateofmanufacturing like '%" + Integer.parseInt(selectedOption.get("year"))+"%'");
        }

        if(selectedOption.containsKey("priceMin")) {
            if(selectedOption.containsKey("priceMax")) {
                if(sb.length() > 0)
                {
                    sb.append(" and ");
                }
                String price = selectedOption.get("priceMax");
                if(price.contains("+")){
                    sb.append("price >= "+Integer.parseInt(price.substring(0, price.length()-1)));

                }
                else
                    sb.append("price between "+Integer.parseInt(selectedOption.get("priceMin"))+" and "+Integer.parseInt(selectedOption.get("priceMax")));
            }
        }

        if(selectedOption.containsKey("mileage")) {
        	
        	String selectedMileage=selectedOption.get("mileage");
        	String[] tokens = selectedMileage.trim().split("-");
            if(tokens.length==1) {
                String c =selectedMileage.substring(selectedMileage.length()-1);
                if(c.equals("+")) {
                	tokens[0] = selectedMileage.substring(0,selectedMileage.length()-1);
                	tokens[1] = String.valueOf(Integer.MAX_VALUE);
                }
            }
            if(sb.length() > 0) {
                sb.append(" and ");
            }
            sb.append("mileage between "+Integer.parseInt(tokens[0])+" and "+Integer.parseInt(tokens[1]));
        }

        return  sb.toString();
    }

   
}
