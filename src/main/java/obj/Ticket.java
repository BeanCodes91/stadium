package obj;

import javax.persistence.*;

@Entity
@Table(name = "TICKETS")

public class Ticket {

	@Id
	private int ticketID;
	
	@OneToOne
	private StadiumBlock blockID;
}
