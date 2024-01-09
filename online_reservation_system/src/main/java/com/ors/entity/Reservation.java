package com.ors.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="reservation")
@Table(name="reservation")
public class Reservation {

	@Id
	@Column(name="pnr_number")
	int pnrNumber;
	
	@Column(name="train_number")
	int trainNumber;
	
	@Column(name="class_type")
	String classType;
	
	@Column(name="date_of_journey")
	String date;
	
	@Column(name="boarding_point")
	String boardingPoint;
	
	@Column(name="destination_point")
	String destinationPoint;
	
	@Column(name="user_id")
	String userId;
	
	@Column(name="status")
	String status;

	public Reservation(int trainNumber, String classType, String date, String boardingPoint, String destinationPoint,
			String userId) {
		
		
		
		this.pnrNumber=(int)(Math.random()*1000000);
		this.trainNumber = trainNumber;
		this.classType = classType;
		this.date = date;
		this.boardingPoint = boardingPoint;
		this.destinationPoint = destinationPoint;
		this.userId = userId;
		this.status="ACTIVE";
	}

	public Reservation() {
	
	}

	public int getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(int pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public int getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBoardingPoint() {
		return boardingPoint;
	}

	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	public String getDestinationPoint() {
		return destinationPoint;
	}

	public void setDestinationPoint(String destinationPoint) {
		this.destinationPoint = destinationPoint;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
