package obj;

import java.util.List;
import javax.persistence.*;

@Entity
@Table

public class StadiumBlock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int blockID;
	
	@Column
	private double blockPrice;
	
	@Column
	private int blockCap;
	
	@ManyToOne
	private StadiumStand standName;
	
	@ManyToMany
	private List<StadiumRow> rows;

	public StadiumBlock() {
		this.blockCap = 0;
	}

	public StadiumBlock(List<StadiumRow> rows) {
		this();
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
	
	public void setStandAndPrice(StadiumStand standName, double blockPrice) {
		this.standName 	= standName;
		this.blockPrice = blockPrice;
	}

	public StadiumStand getStandName() {
		return standName;
	}

	public void setStandName(StadiumStand standName) {
		this.standName = standName;
	}
	
	@Override
	public String toString() {
		return "Block " + blockID;
	}
}