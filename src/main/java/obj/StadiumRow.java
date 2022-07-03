package obj;

import java.util.List;

import jakarta.persistence.*;

/**
 * This class provides the datatype of StadiumRow representing a row within the stadium.
 * 
 * @author Melanie Knorn
 */
@Entity
@Table

public class StadiumRow {
	
	/**
	 * Field variables
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rowID;
	
	@Column
	private char name;
	
	@Column
	private int seatsAvailable;
	
	@ManyToMany
	private List<StadiumSeat> seats;

	/**
	 * Constructor without parameters
	 */
	public StadiumRow() {
		seatsAvailable = 50;
	}
	
	/**
	 * Constructor with parameters
	 * 
	 * @param name		Name of the row
	 * @param seats		List of seats within the row
	 */
	public StadiumRow(char name, List<StadiumSeat> seats) {
		this();
		this.name = name;
		this.seats = seats;
	}

	/**
	 * Getter and Setter
	 */
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
	
	/**
	 * ToString method
	 */
	@Override
	public String toString() {
		return "Reihe: " + name;
	}
}