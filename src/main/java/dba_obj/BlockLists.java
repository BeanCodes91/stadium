package dba_obj;

import java.util.ArrayList;

import obj.*;

/**
 * This class provides ArrayLists with certain blocks.
 * It inherits the ArrayLists from AllLists
 * 
 * @author Melanie Knorn
 *
 */
public class BlockLists extends AllLists{
	
	/**
	 * Field variabled
	 */
	private static ArrayList<StadiumBlock>	sittingBlocks;
	private static ArrayList<StadiumBlock>	standingBlocks;
	
	/**
	 * Gets an ArrayList of all blocks that have enough space for the amount of tickets to be booked
	 * 
	 * @param 	ticketAmount	Amount of tickets to be booked
	 * @return	blockList		ArrayList of available blocks
	 */
	public ArrayList<StadiumBlock> getAvailableBlocks(int ticketAmount) {
		
		for(int i = 0; i < blockList.size(); i++) {
			if(blockList.get(i).getBlockCap() <= ticketAmount) blockList.remove(i--);
		}
		
		return blockList;
	}
	
	/**
	 * Gets an ArrayList of all the blocks with seats in the database
	 * 
	 * @return	sittingBlocks	All the blocks with seats
	 */
	public ArrayList<StadiumBlock> getAllBlocksWithSeats() {
			
		for(StadiumBlock sb: blockList) {
			if(!(sb.getRows().isEmpty())) sittingBlocks.add(sb);
		}
		return sittingBlocks;
	}
	
	/**
	 * Gets an ArrayList of all the blocks without seats in the database
	 * 
	 * @return	standingBlocks	All the blocks without seats
	 */
	public ArrayList<StadiumBlock> getAllBlocksWithoutSeats() {
			
		for(StadiumBlock sb: blockList) {
			if(sb.getRows().isEmpty()) standingBlocks.add(sb);
		}
		return standingBlocks;
	}
}
