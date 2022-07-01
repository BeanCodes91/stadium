package obj;

import java.util.List;

import javax.persistence.*;

@Entity
@Table

public class StadiumRow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rowID;
	
	@Column
	private char name;
	
	@ManyToMany
	private List<StadiumSeat> seats;

	public StadiumRow() {
	}
	
	public StadiumRow(char name, List<StadiumSeat> seats) {
		this.name = name;
		this.seats = seats;
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