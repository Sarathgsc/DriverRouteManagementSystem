package com.amdocs2.service.impl;

import java.util.List;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amdocs2.entity.DriverEntity;
import com.amdocs2.repo.DriverRepository;
import com.amdocs2.service.DriverService;
@Component
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	private DriverRepository dvrRepo;//not understood

	@Override
	public boolean registerDriver(DriverEntity dvr) {
		// TODO Auto-generated method stub
		
		DriverEntity dvrRegister = dvrRepo.save(dvr);
		boolean flag=false;
		if(dvrRegister != null)
			flag = true;
		
		return flag;
	}

	@Override
	public List<DriverEntity> getAllDrivers() {
		// TODO Auto-generated method stub
		List<DriverEntity> dvrRecords = dvrRepo.findAll();
		return dvrRecords;
	}

	@Override
	public DriverEntity getDriverId(int id) {
		// TODO Auto-generated method stub
	Optional<DriverEntity> dvrId =dvrRepo.findById(id);
	DriverEntity dvr = dvrId.get();
	return dvr;
	}

	@Override
	public boolean update(DriverEntity db) {
		// TODO Auto-generated method stub
		return registerDriver(db);
	}

	@Override
	public boolean deleteDriver(int id) {
		// TODO Auto-generated method stub
		DriverEntity dvr = getDriverId(id);
		boolean flag = false;
		if(dvr!=null)
		{
			dvrRepo.delete(dvr);
			flag=true;
		}
		
		return flag;
	}

}
