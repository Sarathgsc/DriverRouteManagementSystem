package com.amdocs2.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
	@Table(name = "DRIVERTABLE")
	public class DriverEntity {
		@Id
		@Column(name = "DID")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int did;
		@Column(name = "FIRSTNAME")
		private String firstName;
		@Column(name = "LASTNAME")
		private String lastName;
		@Column(name = "LICENCENO")
		private String licenceNo;
		
		//new
		@Column(name = "PHONENUMBER")
		private String phoneNumber;
		@Column(name = "PREFERRED_ROUTE")
		private String preferredRoute;
		@OneToMany(mappedBy = "drivers",cascade = CascadeType.ALL)
		private Set<RouteEntity> routeNo = new HashSet<RouteEntity>();
		
		public DriverEntity(int did, String firstName, String lastName, String licenceNo, String phoneNumber,
				String preferredRoute) {
			super();
			this.did = did;
			this.firstName = firstName;
			this.lastName = lastName;
			this.licenceNo = licenceNo;
			this.phoneNumber = phoneNumber;
			this.preferredRoute = preferredRoute;
		}
		
		public DriverEntity() {
			// TODO Auto-generated constructor stub
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getPreferredRoute() {
			return preferredRoute;
		}
		public void setPreferredRoute(String preferredRoute) {
			this.preferredRoute = preferredRoute;
		}
		public int getDid() {
			return did;
		}
		public void setDid(int did) {
			this.did = did;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getLicenceNo() {
			return licenceNo;
		}
		public void setLicenceNo(String licenceNo) {
			this.licenceNo = licenceNo;
		}

		
		
}
