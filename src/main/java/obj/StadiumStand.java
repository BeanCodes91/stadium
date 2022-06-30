package obj;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "STANDS")

public class StadiumStand {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int standID;
	
	@Column(name = "stand_name")
	private String name;
	
	@OneToMany
	private List<StadiumBlock> blocks;

	public StadiumStand() {
	}
	
	public StadiumStand(String name, List<StadiumBlock> blocks) {
		this.name = name;
		this.blocks = blocks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StadiumBlock> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<StadiumBlock> blocks) {
		this.blocks = blocks;
	}

	public int getStandID() {
		return standID;
	}
}
