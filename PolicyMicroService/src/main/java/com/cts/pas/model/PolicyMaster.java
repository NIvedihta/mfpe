package com.cts.pas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * 
 * @author vishnu mandati
 *
 */
/**
 *  PolicyMaster Entity Class
 * 
 */
@Entity
@Table(name="")
public class PolicyMaster 
{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name ="ID")
		private Long id;
		
		
		@Column(name = "Policy_ID")
		private String pid;
		
		
		@Column(name = "propertyType")
		private String propertyType;
		
		
		@Column(name = "consumerType")
		private String consumerType;

		
		@Column(name = "assuredSum")
		private String assuredSum;

		@Column(name = "Tenure")
		private String tenure;

		
		@Column(name = "businessValue")
		private Long businessValue;
		
		
		@Column(name = "propertyValue")
		private Long propertyValue;
		
		
		@Column(name = "baseLocation")
		private String baseLocation;
		
		
		@Column(name = "Type")
		private String type;

		public PolicyMaster(Long id, String pid, String propertyType, String consumerType, String assuredSum, String tenure,
				Long businessValue, Long propertyValue, String baseLocation, String type) {
			super();
			this.id = id;
			this.pid = pid;
			this.propertyType = propertyType;
			this.consumerType = consumerType;
			this.assuredSum = assuredSum;
			this.tenure = tenure;
			this.businessValue = businessValue;
			this.propertyValue = propertyValue;
			this.baseLocation = baseLocation;
			this.type = type;
		}



		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getPid() {
			return pid;
		}

		public void setPid(String pid) {
			this.pid = pid;
		}

		public String getpropertyType() {
			return propertyType;
		}

		public void setpropertyType(String propertyType) {
			this.propertyType = propertyType;
		}

		public String getconsumerType() {
			return consumerType;
		}

		public void setconsumerType(String consumerType) {
			this.consumerType = consumerType;
		}

		public String getassuredSum() {
			return assuredSum;
		}

		public void setassuredSum(String assuredSum) {
			this.assuredSum = assuredSum;
		}

		public String getTenure() {
			return tenure;
		}

		public void setTenure(String tenure) {
			this.tenure = tenure;
		}

		public Long getbusinessValue() {
			return businessValue;
		}

		public void setbusinessValue(Long businessValue) {
			this.businessValue = businessValue;
		}

		public Long getpropertyValue() {
			return propertyValue;
		}

		public void setpropertyValue(Long propertyValue) {
			this.propertyValue = propertyValue;
		}

		public String getbaseLocation() {
			return baseLocation;
		}

		public void setbaseLocation(String baseLocation) {
			this.baseLocation = baseLocation;
		}

		public String getType() {
			return type;
		}

		public PolicyMaster() {
			super();
		}



		public void setType(String type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return "PolicyMaster [id=" + id + ", pid=" + pid + ", propertyType=" + propertyType + ", consumerType="
					+ consumerType + ", assuredSum=" + assuredSum + ", tenure=" + tenure + ", businessValue="
					+ businessValue + ", propertyValue=" + propertyValue + ", baseLocation=" + baseLocation + ", type="
					+ type + "]";
		}

		
	}


