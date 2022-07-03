package obj;

import java.util.List;
import jakarta.persistence.*;

/**
 * This class provides the datatype of StadiumBlock representing a block within the stadium.
 * 
 * @author Melanie Knorn
 */
@Entity
@Table

public class StadiumBlock {

	/**
	 * Field variables
	 */
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

	/**
	 * Constructor without parameters
	 */
	public StadiumBlock() {
		this.blockCap = 0;
	}

	/**
	 * Constructor with parameters
	 * @param rows		A list of rows within the block
	 */
	public StadiumBlock(List<StadiumRow> rows) {
		this();
		this.rows = rows;
	}

	/**
	 * Getter and Setter
	 */
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
	
	/**
	 * ToString 
	 */
	@Override
	public String toString() {
		return "Block " + blockID;
	}
}