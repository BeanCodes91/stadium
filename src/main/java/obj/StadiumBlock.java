package obj;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "BLOCKS")

public class StadiumBlock {

	@Id
	private int blockID;
	
	@Column(name = "block_price")
	private double blockPrice;
	
	@Column(name = "block_capacity")
	private int blockCap;
	
	@ManyToMany
	private List<StadiumRow> rows;
}