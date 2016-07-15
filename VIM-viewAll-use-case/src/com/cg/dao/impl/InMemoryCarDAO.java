package com.cg.dao.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.cg.dao.CarDAO;
import com.cg.dto.CarDTO;

public class InMemoryCarDAO implements CarDAO {
	public InMemoryCarDAO() {
		System.out.println("InMemoryCarDAO  instantiated ...");
		
		CarDTO carDTO = new CarDTO();
		carDTO.setMake("Honda");
		carDTO.setModel("City");
		carDTO.setModelYear("2016");
		
		System.out.println("car added");
		carsEntries.put(carDTO.getIdOfACar(), carDTO);
	}
	
	
//	private List<CarDTO> cars = new LinkedList<CarDTO>();
	private Map<Integer, CarDTO> carsEntries = new HashMap<Integer, CarDTO>();
	
	@Override
	public List<CarDTO> findAll() {
		// TODO Auto-generated method stub
		System.out.println("cars retrieved");
		return new LinkedList(carsEntries.values());
	}

	@Override
	public CarDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(CarDTO car) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(CarDTO car) {
	}

	@Override
	public void delete(String[] ids) {
	}

}
