package obj;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table

public class StadiumRow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rowID;
	
	@Column
	private char name;
	
	@Column
	private int seatsAvailable;
	
	@ManyToMany
	private List<StadiumSeat> seats;

	public StadiumRow() {
		seatsAvailable = 50;
	}
	
	public StadiumRow(char name, List<StadiumSeat> seats) {
		this();
		this.name = name;
		this.seats = seats;
	}

	public List<StadiumSeat> getSeats() {
		return seats;
	}

	public void setSeats(List<StadiumSeat> seats) {
		this.seats = seats;
	}

	public int getRowID() {
		return rowID;
	}
	
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public int getSeatsBooked() {
		return seatsAvailable;
	}
	
	@Override
	public String toString() {
		return "Reihe: " + name;
	}
}