package obj;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "STADIUMROWS")

public class StadiumRow {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rowID;
	
	@ManyToMany
	private List<StadiumSeat> seats;

	public StadiumRow() {
	}

	public List<StadiumSeat> getSeats() {
		return seats;
	}

	public void setSeats(List<StadiumSeat> seats) {
		this.seats = seats;
	}

	public int getRowID() {
		return rowID;
	}

	
}