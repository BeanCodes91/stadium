package obj;

import javax.persistence.*;

@Entity
@Table

public class StadiumStand {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int standID;
	
	@Column
	private String name;

	public StadiumStand() {
	}
	
	public StadiumStand(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
