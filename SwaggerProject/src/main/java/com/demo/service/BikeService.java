package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Bike;
import com.demo.repository.BikeRepository;

@Service
public class BikeService 
{
	@Autowired
	BikeRepository bikeRepository;
	
	public Bike saveBikeService(Bike bike)
	{
		return bikeRepository.save(bike);
	}

	public List<Bike> fetchBikeService() {
		return bikeRepository.findAll();
	}

	public void updateBikeService() {
		// TODO Auto-generated method stub
		
	}

	public void deleteBikeController() {
		// TODO Auto-generated method stub
		
	}
}
