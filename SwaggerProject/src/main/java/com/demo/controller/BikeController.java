package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Bike;
import com.demo.service.BikeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="/*", description="Bike Details",produces="application/json")
@RestController
public class BikeController {

	@Autowired
	BikeService bikeService;

//	@RequestMapping(value = "/fetchBike", method = RequestMethod.GET, produces = "application/json")
	@GetMapping(value="/fetchBike", produces = "application/json")
	@ApiOperation(value="Api to fetch All Bike details")
	public List<Bike> fetchBikeController() {
		return bikeService.fetchBikeService();
	}
	
	@ApiOperation(value="Api to save Bike ")
	@PostMapping(value="/saveBike", produces = "application/json")
	public ResponseEntity<Bike> saveBikeController(@RequestBody Bike bike) {
		Bike bikeFromDB = bikeService.saveBikeService(bike);
		return new ResponseEntity<Bike>(bikeFromDB, HttpStatus.ACCEPTED);
	}

	@ApiOperation(value="Api to update Bike")
	@PutMapping(value="/updateBike", produces = "application/json")
	public void updateBikeController() {
		bikeService.updateBikeService();
	}

	@ApiOperation(value="Api to delete a bike")
	@DeleteMapping(value="/deleteBike", produces = "application/json")
	public void deleteBikeController() {
		bikeService.deleteBikeController();
	}
}
