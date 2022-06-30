package obj;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "BOOKINGS")

public class EventBooking {

	@Id
	@Column(name="booking_id")
	private int bookingID;
	
	@OneToOne
	private SportsEvent sportsEvent;
	
	@OneToMany
	private List<Ticket> tickets;
}
