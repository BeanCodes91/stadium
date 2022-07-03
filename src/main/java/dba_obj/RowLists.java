package dba_obj;

import java.util.ArrayList;

import obj.StadiumBlock;
import obj.StadiumRow;

/**
 * This class provides ArrayLists with certain rows.
 * It inherits the ArrayLists from AllLists
 * 
 * @author Melanie Knorn
 *
 */

public class RowLists extends AllLists {

	public ArrayList<StadiumRow> getAvailableRows(int ticketAmount) {
		
		for(int i = 0; i < rowList.size(); i++) {
			if(rowList.get(i).getSeatsAvailable() <= ticketAmount) rowList.remove(i--);
		}
		
		return rowList;
	}
	
}
