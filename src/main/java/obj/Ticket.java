package obj;

import jakarta.persistence.*;

/**
 * This class provides the datatype of Ticket representing a ticket for a seat within a row within a block.
 * 
 * @author Melanie Knorn
 */

@Entity
@Table

public class Ticket {

	/**
	 * Field variables
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ticketID;
	
	@OneToOne
	private StadiumBlock blockID;
	
	@OneToOne
	private StadiumRow rowID;
	
	@OneToOne
	private StadiumSeat seatID;

	/**
	 * Constructor without parameters
	 */
	public Ticket() {}
	
	/**
	 * Getter and Setter
	 */
	public void setRowID(StadiumRow rowID) {
		this.rowID = rowID;
	}

	public void setSeatID(StadiumSeat seatID) {
		this.seatID = seatID;
	}

	public Ticket(StadiumBlock blockID) {
		this.blockID = blockID;
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public StadiumBlock getBlockID() {
		return blockID;
	}

	public StadiumRow getRowID() {
		return rowID;
	}

	public StadiumSeat getSeatID() {
		return seatID;
	}

	/**
	 * ToString method
	 */
	@Override
	public String toString() {
		return "Block: " + blockID;
	}
}
