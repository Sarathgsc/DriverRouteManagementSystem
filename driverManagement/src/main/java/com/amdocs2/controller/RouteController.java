package com.amdocs2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs2.entity.RouteEntity;
import com.amdocs2.exception.DriverNotFoundException;
import com.amdocs2.service.DriverService;
import com.amdocs2.service.RouteService;

	@RestController
	@RequestMapping("/route")
	public class RouteController {
		private RouteService routeserv;
		private DriverService driverserv;
		@Autowired
		public RouteController(RouteService routeserv,DriverService driverserv) {
			super();
			this.routeserv = routeserv;
		}
		//http://localhost:8086/route
		@PostMapping("/insert/{did}")
		public RouteEntity saveRoute(@RequestBody RouteEntity route,@PathVariable Integer did) throws DriverNotFoundException
		{
			return routeserv.saveRoute(route,did);
		}
		//http://localhost:8085/route/insert
		
		@GetMapping("/allroutes")
		public List<RouteEntity> getAllRoutes(){
			return routeserv.getAllRoutes();
		}
		//http://localhost:8085/route/allroutes

		@GetMapping("/{routeNo}")
		public RouteEntity getRouteById(@PathVariable Long routeNo) {
			return routeserv.getRouteById(routeNo);
		}
		//http://localhost:8085/route/1
		
		@PutMapping("/update/{routeNo}")
		public RouteEntity updateRoute(@PathVariable Long routeNo,@RequestBody RouteEntity route) {
			return routeserv.updateRoute(routeNo, route);
		}
		
		@DeleteMapping("/delete/{routeNo}")
		public void deleteRoute(@PathVariable Long routeNo) {
			routeserv.deleteRoute(routeNo);
		}
}
	
		
		
