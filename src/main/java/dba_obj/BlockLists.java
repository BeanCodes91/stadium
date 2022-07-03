package dba_obj;

import java.util.ArrayList;

import obj.*;

/**
 * This class provides ArrayLists with certain blocks
 * 
 * @author Melanie Knorn
 *
 */
public class BlockLists extends GetAllLists{
	
	/**
	 * Gets an ArrayList of all blocks that have enough space for the amount of tickets to be booked
	 * 
	 * @param 	ticketAmount	Amount of tickets to be booked
	 * @return	blockList		ArrayList of available blocks
	 */
	public ArrayList<StadiumBlock> getAvailableBlocks(int ticketAmount) {
		
		for(int i = 0; i < blockList.size(); i++) {
			if(blockList.get(i).getBlockCap() <= (500 - ticketAmount)) blockList.remove(i--);
		}
		
		return blockList;
	}
	
	/**
	 * Gets an ArrayList of all the blocks with seats in the database
	 * 
	 * @return	blockList	All the blocks with seats
	 */
	public ArrayList<StadiumBlock> getAllBlocksWithSeats() {
			
		for(int i = 0; i < blockList.size(); i++) {
			if(blockList.get(i).getRows().isEmpty()) blockList.remove(i--);
		}
		return blockList;
	}
	
	/**
	 * Gets an ArrayList of all the blocks without seats in the database
	 * 
	 * @return	blockList	All the blocks without seats
	 */
	public ArrayList<StadiumBlock> getAllBlocksWithoutSeats() {
			
		for(int i = 0; i < blockList.size(); i++) {
			if(!(blockList.get(i).getRows().isEmpty())) blockList.remove(i--);
		}
		return blockList;
	}
}
