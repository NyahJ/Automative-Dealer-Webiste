package com.info5100.team5.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.info5100.team5.DTO.VehicleDetails;

public class CarDAO {

	DBConnector dbCon = new DBConnector();
	private ArrayList<VehicleDetails> completeList=new ArrayList<VehicleDetails>();
	
	public ArrayList<VehicleDetails> getAllCars() throws SQLException {
		String query = "select * from Automobiles";
		ResultSet rs = dbCon.queryExecution(query);
		while (rs.next()) {
        	VehicleDetails vehicle = new VehicleDetails();

            vehicle.setId(rs.getString(1));
            vehicle.setBrand(rs.getString(3));
            vehicle.setModel(rs.getString(4));
            vehicle.setYear(rs.getString(5));
            vehicle.setType(rs.getString(6));
            String category = rs.getString(7);
           // rs.getBLO
            if (category.equals("NEW")) {
                vehicle.setCategory("NEW");
            } else {
                vehicle.setCategory("USED");
            }
            vehicle.setColor(rs.getString(8));
            float price = Float.parseFloat(rs.getString(9));
            vehicle.setPrice(price);
            float mileage = Float.parseFloat(rs.getString(10));
            vehicle.setMileage(mileage);
            completeList.add(vehicle);
        }
    
	return completeList;
}
}
