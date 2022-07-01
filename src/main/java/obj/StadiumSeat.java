package obj;

import jakarta.persistence.*;

@Entity
@Table

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
