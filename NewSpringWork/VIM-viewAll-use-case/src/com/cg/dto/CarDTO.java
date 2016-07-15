package com.cg.dto;

//Follow TODOs (if available)
/**
 * 
 * This is a CarDTO class
 * @see java.lang.Object
 * @author Abhishek
 * 
 *
 */
public class CarDTO
{
//	ATTRIBUTES
    private int id;
    private String make;
    private String model;
    private String modelYear;

    private static int count;
    
    public CarDTO()
    {
        //TODO 1 initialize id to -1 and rest of the member variables to a blank string
    	id = -1;
    	make = model = modelYear = "NA";
    }

    //TODO 2 Implement the setter and getter methods
    
/*    public void setIdOfACar(int id) {
		this.id = id;
	}
*/    
    public void assignId(){
    	id = ++count;
    }
    
    
    
    public int getIdOfACar() {
		return id;
	}
    
    public void setMake(String make) {
		this.make = make;
	}
    
    public String getMake() {
		return make;
	}
    
    public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}
    
    
    public String getModelYear() {
		return modelYear;
	}
    
    
    public void setModel(String model) {
		this.model = model;
	}
    
    public String getModel() {
		return model;
	}
    
    
    
    
    
    
    
    
}
