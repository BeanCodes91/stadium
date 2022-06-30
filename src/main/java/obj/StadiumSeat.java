package obj;

import javax.persistence.*;

@Entity
@Table(name = "SEATS")

public class StadiumSeat {

	@Id
	private int seatID;
}
