package com.info5100.team5.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import com.info5100.team5.DAO.CarDAO;
import com.info5100.team5.DTO.VehicleDetails;
import com.info5100.team5.service.CarService;

public class FilterAndSearchController {
	
	CarDAO carDAO= new CarDAO();
	CarService carService= new CarService();
	
	
	public ArrayList<VehicleDetails> getAllCars() throws SQLException{
		return carDAO.getAllCars();
	}
	
	 public Vector<String> getValidOption(String filterName, ArrayList<VehicleDetails> list) {
		 return carService.getOptionsFromAllCars(filterName,list);
	 }
	 
	 public ArrayList<VehicleDetails> getSearchedData(String searchKeyWord,ArrayList<VehicleDetails> completeCarList) {
		 return carService.getSearchedData(searchKeyWord,completeCarList);
	 }
	 
	 public ArrayList<VehicleDetails> getFilteredData(HashMap<String, String> searchParamsMap,ArrayList<VehicleDetails> completeCarList) {
		 return carService.getFilteredData(searchParamsMap, completeCarList);
	 }
		 
	 
}
