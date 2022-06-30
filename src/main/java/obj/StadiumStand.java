package obj;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "STANDS")

public class StadiumStand {

	@Id
	private int standID;
	
	@OneToMany
	private List<StadiumBlock> blocks;
}
