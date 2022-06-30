package obj;

import javax.persistence.*;

@Entity
@Table(name = "STANDS")

public class StadiumStand {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int standID;
	
	@Column(name = "stand_name")
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
