package obj;

import jakarta.persistence.*;

/**
 * This class provides the datatype of StadiumStand representing a stand within the stadium.
 * 
 * @author Melanie Knorn
 */

@Entity
@Table

public class StadiumStand {

	/**
	 * Field variables
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int standID;
	
	@Column
	private String name;

	/**
	 * Constructor without parameters
	 */
	public StadiumStand() {}
	
	/**
	 * Constructor with parameters
	 * 
	 * @param name	Name of the stand
	 */
	public StadiumStand(String name) {
		this.name = name;
	}

	/**
	 * Getter and Setter
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * ToString method
	 */
	@Override
	public String toString() {
		return name;
	}
}
