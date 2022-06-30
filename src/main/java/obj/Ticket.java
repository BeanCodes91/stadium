package obj;

import javax.persistence.*;

@Entity
@Table(name = "TICKETS")

public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ticketID;
	
	@OneToOne
	private StadiumBlock blockID;

	public Ticket() {
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

}
