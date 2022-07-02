package obj;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table

public class EventBooking {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookingID;
	
	@OneToOne
	private SportsEvent sportsEvent;
	
	@OneToMany
	private List<Ticket> tickets;
	
	public EventBooking() {
		
	}

	public EventBooking(SportsEvent sportsEvent) {
		this.sportsEvent = sportsEvent;
	}

	public int getBookingID() {
		return bookingID;
	}

	public SportsEvent getSportsEvent() {
		return sportsEvent;
	}

	public void setSportsEvent(SportsEvent sportsEvent) {
		this.sportsEvent = sportsEvent;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	@Override
	public String toString() {
		return "Ihre Bestellung:\n" + tickets;
	}
}
