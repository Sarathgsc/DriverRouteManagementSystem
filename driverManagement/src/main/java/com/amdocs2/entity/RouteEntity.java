package com.amdocs2.entity;

import java.util.Date;

import javax.persistence.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class RouteEntity {
	//route id,route name,from point, to point,driver name,two tabels and connect both with sedule table and route 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "route_id")
	private long routeNo;
	
	@Column(name = "startpoint")
	private String startPoint;
	@Column(name = "endpoint")
	private String endPoint;
	@Column(name = "start_date")
	@DateTimeFormat(pattern = "yyyy-mm-dd:HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@ManyToOne
	@JoinColumn(name="did")
	private DriverEntity drivers;
}
