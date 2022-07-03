package obj;

import jakarta.persistence.*;

/**
 * This class provides the datatype of SportsEvent representing an event at the stadium.
 * 
 * @author Melanie Knorn
 *
 */

@Entity
@Table

public class SportsEvent {
	
	/**
	 * Field variables
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eventID;

	@Column
	private String eventName;
	
	@Column
	private String eventDate;
	
	@Column
	private int eventCap;
	
	/**
	 * Constructor without parameters
	 */
	public SportsEvent() {
		this.eventCap = 0;
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param eventName		Name of the event
	 * @param eventDate		Date of the event
	 */
	public SportsEvent(String eventName, String eventDate) {
		this();
		this.eventName = eventName;
		this.eventDate = eventDate;
	}

	/**
	 * Getters and Setters
	 */
	public int getEventID() {
		return eventID;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public int getEventCap() {
		return eventCap;
	}

	public void setEventCap(int eventCap) {
		this.eventCap = eventCap;
	}
	
	/**
	 * ToString method
	 */
	@Override
	public String toString() {
		return eventName + ": " + eventDate;
	}
}
