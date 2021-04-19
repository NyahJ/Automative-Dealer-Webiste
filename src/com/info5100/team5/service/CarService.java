package com.info5100.team5.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.stream.Collectors;
import com.info5100.team5.DTO.VehicleDetails;

public class CarService {

	public Vector<String> getOptionsFromAllCars(String filterName, ArrayList<VehicleDetails> list) {

		if (filterName.equalsIgnoreCase("brand")) {
			return new Vector<String>(list.stream().map(vehicle -> vehicle.getBrand()).collect(Collectors.toSet()));
		}

		if (filterName.equalsIgnoreCase("model")) {
			return new Vector<String>(list.stream().map(vehicle -> vehicle.getModel()).collect(Collectors.toSet()));
		}

		if (filterName.equalsIgnoreCase("category")) {
			return new Vector<String>(list.stream().map(vehicle -> vehicle.getCategory()).collect(Collectors.toSet()));
		}

		if (filterName.equalsIgnoreCase("color")) {
			return new Vector<String>(list.stream().map(vehicle -> vehicle.getColor()).collect(Collectors.toSet()));
		}
		if (filterName.equalsIgnoreCase("type")) {
			return new Vector<String>(list.stream().map(vehicle -> vehicle.getType()).collect(Collectors.toSet()));
		}
		return null;
	}
	
	
	public ArrayList<VehicleDetails> getSearchedData(String searchKeyWord, ArrayList<VehicleDetails> completeCarList) {
		ArrayList<VehicleDetails> resultList = (ArrayList<VehicleDetails>) completeCarList.stream()
				  .filter( ( vehicle -> vehicle.getBrand().contains(searchKeyWord)
									  || vehicle.getModel().contains(searchKeyWord)
									  || vehicle.getType().contains(searchKeyWord)
									  || vehicle.getCategory().contains(searchKeyWord)
									  || vehicle.getColor().contains(searchKeyWord)
									  || vehicle.getYear().contains(searchKeyWord)
									  )
						  )
				  .collect(Collectors.toList());
		
		return resultList;
				
    }

	
	 public ArrayList<VehicleDetails> getFilteredData(HashMap<String, String> searchParamsMap,ArrayList<VehicleDetails> completeList ) { // model = 'SEDAN' and type = 'type1'
	    	ArrayList<ArrayList<VehicleDetails>> filteredLists= new ArrayList<ArrayList<VehicleDetails>>();
	         ArrayList<VehicleDetails> filterListOnBrand= new ArrayList<VehicleDetails>();
	         ArrayList<VehicleDetails> filterListOnModel= new ArrayList<VehicleDetails>();
	         ArrayList<VehicleDetails> filterListOnType= new ArrayList<VehicleDetails>();
	         ArrayList<VehicleDetails> filterListOnCategory= new ArrayList<VehicleDetails>();
	         ArrayList<VehicleDetails> filterListOnColor = new ArrayList<VehicleDetails>();
	         
	         for(String key: searchParamsMap.keySet()) {
	        	 System.out.println("key" + key);
	        	 
	        	 if(key.equalsIgnoreCase("brand")) {
	        		 filterListOnBrand = (ArrayList<VehicleDetails>) completeList.stream()
	        				 					  .filter(vehicle -> vehicle.getBrand().equals(searchParamsMap.get(key)))
	        				 					  .collect(Collectors.toList());
	        		 if(!filterListOnBrand.isEmpty())
	        		 filteredLists.add(filterListOnBrand);
	        	 }
	        	 
	        	 if(key.equalsIgnoreCase("model")) {
	        		 filterListOnModel = (ArrayList<VehicleDetails>) completeList.stream()
	        				 					  .filter(vehicle -> vehicle.getModel().equalsIgnoreCase(searchParamsMap.get(key)))
	        				 					  .collect(Collectors.toList());
	        		 if(!filterListOnModel.isEmpty())
	        		 filteredLists.add(filterListOnModel);
	        	 }
	        	         	 
	        	 if(key.equalsIgnoreCase("type")) {
	        		 filterListOnType = (ArrayList<VehicleDetails>) completeList.stream()
	        				 					  .filter(vehicle -> vehicle.getType().equalsIgnoreCase(searchParamsMap.get(key)))
	        				 					  .collect(Collectors.toList());
	        		 if(!filterListOnType.isEmpty())
	        		 filteredLists.add(filterListOnType);
	        	 }
	        	 if(key.equalsIgnoreCase("category")) {
	        		 filterListOnCategory = (ArrayList<VehicleDetails>) completeList.stream()
	        				 					  .filter(vehicle -> vehicle.getCategory().equalsIgnoreCase(searchParamsMap.get(key)))
	        				 					  .collect(Collectors.toList());
	        		 if(!filterListOnCategory.isEmpty())
	        		 filteredLists.add(filterListOnCategory);
	        	 }
	        	 if(key.equalsIgnoreCase("color")) {
	        		 filterListOnColor = (ArrayList<VehicleDetails>) completeList.stream()
	        				 					  .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(searchParamsMap.get(key)))
	        				 					  .collect(Collectors.toList());
	        		 if(!filterListOnColor.isEmpty())
	        		 filteredLists.add(filterListOnColor);
	        	 }
	         }
	         return intersectLists(filteredLists);
	         
	    }
	    
	 
	 public ArrayList<VehicleDetails> intersectLists(ArrayList<ArrayList<VehicleDetails>> filteredLists){
    	 
    	 ArrayList<VehicleDetails> resultFilteredList= filteredLists.get(0);
    	 for(ArrayList li: filteredLists) {
    		 
    		 if(!li.isEmpty()) {
    			 resultFilteredList.retainAll(li);
    		 }
    	 }
		return resultFilteredList;
     }
}
