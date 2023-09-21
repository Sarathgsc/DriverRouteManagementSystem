package com.amdocs2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.amdocs2.entity.DriverEntity;
//import com.amdocs2.controller.List;
import com.amdocs2.entity.RouteEntity;
import com.amdocs2.exception.DriverNotFoundException;
import com.amdocs2.repo.DriverRepository;
import com.amdocs2.repo.RouteRepository;
@Service
public class RouteService {
	
	private RouteRepository routerepo;
	private DriverRepository driverrepo;
	@Autowired
	public RouteService(RouteRepository routerepo,DriverRepository driverrepo) {
		super();
		this.routerepo = routerepo;
		this.driverrepo=driverrepo;
	}
	
	public RouteEntity saveRoute(RouteEntity route,int did ) throws DriverNotFoundException 
	{
		DriverEntity driver1 = driverrepo.findById(did).orElse(null);
		if(driver1!=null)
		{
			route.setDrivers(driver1);
		return routerepo.save(route);
		}
		else {
			return null;
		}
		}

	public List<RouteEntity> getAllRoutes() {
		// TODO Auto-generated method stub
		return routerepo.findAll();
	}


	public RouteEntity getRouteById(Long routeNo) {
		// TODO Auto-generated method stub
		return routerepo.findById(routeNo).orElse(null);
	}

	public RouteEntity updateRoute(Long routeNo, RouteEntity route) {
		// TODO Auto-generated method stub
		RouteEntity existingroute = routerepo.findById(routeNo).orElse(null);
		
		if(existingroute!= null)
		{
			existingroute.setEndPoint(route.getEndPoint());
			existingroute.setStartPoint(route.getStartPoint());
			existingroute.setStartDate(route.getStartDate());
			
			return routerepo.save(existingroute);
		}
		
		
		return null;
	}

	public void deleteRoute(Long routeNo) {
		// TODO Auto-generated method stub
		routerepo.deleteById(routeNo);
	}
	

}
