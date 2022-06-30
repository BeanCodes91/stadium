package obj;

import javax.persistence.*;

@Entity
@Table(name = "SEATS")

public class StadiumSeat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seatID;

	public StadiumSeat() {
		
	}

	public int getSeatID() {
		return seatID;
	}
}
