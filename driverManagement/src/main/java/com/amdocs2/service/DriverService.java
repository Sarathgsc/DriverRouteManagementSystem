package com.amdocs2.service;

import java.util.List;

import com.amdocs2.entity.DriverEntity;

public interface DriverService {
	public boolean registerDriver(DriverEntity dvr);
	
	public List<DriverEntity> getAllDrivers();
	
	public DriverEntity getDriverId(int id);
	
	public boolean update(DriverEntity db);
	
	public boolean deleteDriver(int id);
	

}
