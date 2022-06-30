package obj;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "BLOCKS")

public class StadiumBlock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int blockID;
	
	@Column(name = "block_price")
	private double blockPrice;
	
	@Column(name = "block_capacity")
	private int blockCap;
	
	@ManyToOne
	private StadiumStand standName;
	
	@ManyToMany
	private List<StadiumRow> rows;

	public StadiumBlock() {
		this.blockCap = 0;
	}

	public StadiumBlock(StadiumStand standName, double blockPrice, List<StadiumRow> rows) {
		this.standName = standName;
		this.blockPrice = blockPrice;
		this.rows = rows;
		this.blockCap = 0;
	}

	public double getBlockPrice() {
		return blockPrice;
	}

	public void setBlockPrice(double blockPrice) {
		this.blockPrice = blockPrice;
	}

	public int getBlockCap() {
		return blockCap;
	}

	public void setBlockCap(int blockCap) {
		this.blockCap = blockCap;
	}

	public List<StadiumRow> getRows() {
		return rows;
	}

	public void setRows(List<StadiumRow> rows) {
		this.rows = rows;
	}

	public int getBlockID() {
		return blockID;
	}
	
	
}