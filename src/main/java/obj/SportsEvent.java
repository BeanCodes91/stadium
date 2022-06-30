package obj;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "EVENTS")

public class SportsEvent {
	
	@Id
	private int eventID;

	@Column(name = "events_name")
	private String eventName;
	
	@Column(name = "events_date")
	private LocalDate eventDate;
	
	@Column(name = "events_capacity")
	private int eventCap;
}
