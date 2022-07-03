package obj;

import jakarta.persistence.*;

/**
 * This class provides the datatype of StadiumSeat representing a seat within the stadium.
 * 
 * @author Melanie Knorn
 */
@Entity
@Table

public class StadiumSeat {

	/**
	 * Field variables
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seatID;

	/**
	 * Constructor without parameters
	 */
	public StadiumSeat() {}

	/**
	 * Gets the seatID
	 * 
	 * @return	seatID	Number of the seat in the row
	 */
	public int getSeatID() {
		return seatID;
	}
	
	/**
	 * ToString method
	 */
	@Override
	public String toString() {
		return "" + seatID;
	}
}
