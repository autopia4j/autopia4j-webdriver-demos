package com.autopia4j.demo.mercurytours.pageObjectModel.basic.datamodel;

public class FlightJourney {
	
	private String origin;
	private String destination;
	private String departureMonth;
	private String departureDay;
	private String returnMonth;
	private String returnDay;
	private String airline;
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String getDepartureMonth() {
		return departureMonth;
	}
	public void setDepartureMonth(String departureMonth) {
		this.departureMonth = departureMonth;
	}
	
	public String getDepartureDay() {
		return departureDay;
	}
	public void setDepartureDay(String departureDay) {
		this.departureDay = departureDay;
	}
	
	public String getArrivalMonth() {
		return returnMonth;
	}
	public void setReturnMonth(String returnMonth) {
		this.returnMonth = returnMonth;
	}
	
	public String getArrivalDay() {
		return returnDay;
	}
	public void setReturnDay(String returnDay) {
		this.returnDay = returnDay;
	}
	
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
}