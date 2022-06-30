package obj;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "BLOCKS")

public class StadiumBlock {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blockID;
	
	@Column(name = "block_price")
	private double blockPrice;
	
	@Column(name = "block_capacity")
	private int blockCap;
	
	@ManyToMany
	private List<StadiumRow> rows;

	public StadiumBlock() {
		
	}

	public StadiumBlock(double blockPrice, int blockCap, List<StadiumRow> rows) {
		super();
		this.blockPrice = blockPrice;
		this.blockCap = blockCap;
		this.rows = rows;
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