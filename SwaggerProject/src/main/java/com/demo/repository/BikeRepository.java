package com.demo.repository;

import org.springframework.stereotype.Repository;

import com.demo.model.Bike;

@Repository
public interface BikeRepository extends BaseRepository<Bike, Long>{

}
