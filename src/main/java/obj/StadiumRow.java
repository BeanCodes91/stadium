package obj;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "STADIUMROWS")

public class StadiumRow {
	
	@Id
	private int rowID;
	
	@ManyToMany
	private List<StadiumSeat> seats;
}