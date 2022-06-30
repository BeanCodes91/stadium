package obj;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "EVENTS")

public class SportsEvent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eventID;

	@Column(name = "events_name")
	private String eventName;
	
	@Column(name = "events_date")
	private LocalDate eventDate;
	
	@Column(name = "events_capacity")
	private int eventCap;
	
	public SportsEvent() {
		
	}

	public SportsEvent(String eventName, LocalDate eventDate, int eventCap) {
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventCap = eventCap;
	}

	public int getEventID() {
		return eventID;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public int getEventCap() {
		return eventCap;
	}

	public void setEventCap(int eventCap) {
		this.eventCap = eventCap;
	}
	
	
}
