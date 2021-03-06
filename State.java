/*
 * State
 * 
 * Version 0.1
 * 
 * Represents the Sokoban State.
 * 
 * Should not be confused with the class Map. 
 */

import java.util.Vector;

public class State implements Cloneable {
	
	private Vector<Box> boxes;
	private Vector<Cell> reachableCells;
	private Vector<Cell> unReachableCells;

	private int playerRow;
	private int playerCol;
	private int parentKey; //reference to make it possible to find parent state - for final path building.
	
	/**
	 * Constructs the internal representation of the State
	 *
	 * USED ONLY WHEN CREATING INITIAL STATE
	 * @param 
	 */
	public State(Vector<Box> pBoxes, int pPlayerRow, int pPlayerCol) {
		boxes = pBoxes;
		playerRow = pPlayerRow;
		playerCol= pPlayerCol;
		
		/*
		 * TODO move player to one box...
		 */
		
		for(Box box : pBoxes){
			if(isConnected(playerRow, playerCol, box.getRow(),box.getCol())){
				if(isConnected(playerRow, playerCol, box.getRow(),box.getCol()));
			}
		}
		
	} // End constructor State


    /**
     * Constructs a state which is the result of applying one move.
     * "final" in arguments to avoid applying changes to parent state
     *
     * @param pParentState
     * @param pBoxIndex    index if the boxes vector
     * @param pMoveDir     the direction to move the box
     */
    public State(final State pParentState, int pBoxIndex, char pMoveDir) {
        // set boxes
        this.boxes = (Vector<Box>) pParentState.boxes.clone();
        System.out.println(pMoveDir);

        // set player position before moving the box
        playerRow = this.boxes.get(pBoxIndex).getRow();
        playerCol = this.boxes.get(pBoxIndex).getCol();

        // move the box
        this.boxes.get(pBoxIndex).move(pMoveDir);

    } // End constructor State


    /**
     * Does all necessary checks to see if a box is movable to the position.
     * 
     * Checks are:
     * 1) no wall in that position
     * 2) no box in that position
     * 3) no dead lock type 0 in that position (i.e. a corner)
     * 4) can player reach the opposite position.
     *
     * @return
     */
    public boolean tryMove(Box pBox, char pDir){
    	
        int lR = pBox.getRow();
        int lC = pBox.getCol();

        int lMoveToRow = 0;
        int lMoveToCol = 0;
        int lPlayerRow = 0;
        int lPlayerCol = 0;
        
        boolean lCorrectInput=false;
        
        switch (pDir) {
            case 'U':
            	lMoveToRow = lR - 1;
            	lMoveToCol = lC;
            	lPlayerRow = lR + 1;
            	lPlayerCol = lC;
            	lCorrectInput = true;
            case 'D':
            	lMoveToRow = lR + 1;
            	lMoveToCol = lC;
            	lPlayerRow = lR - 1;
            	lPlayerCol = lC;
            	lCorrectInput = true;
            case 'R':
            	lMoveToRow = lR;
            	lMoveToCol = lC + 1;
            	lPlayerRow = lR;
            	lPlayerCol = lC - 1;
            	lCorrectInput = true;
            case 'L':
            	lMoveToRow = lR;
            	lMoveToCol = lC - 1;
            	lPlayerRow = lR;
            	lPlayerCol = lC + 1;
            	lCorrectInput = true;

        }
    	
        if(!lCorrectInput){
        	if (Main.debugMode) System.out.println("StateError: TryMove: wrong direction input");
    	}
        
    	return (!Board.isWall(lMoveToRow, lMoveToCol) &&
    			!this.isBox(lMoveToRow, lMoveToCol) &&
    			!Board.isDeadLockT0(lMoveToRow, lMoveToCol) &&
    			this.isConnected(playerRow, playerCol, lPlayerRow, lPlayerCol));
    }
    
	public boolean isBox( int pRow, int pCol){
		/*
		 * TODO
		 * 
		 * Very inefficient way of checking must be rewritten later.
		 */
		
		for(Box box : boxes){
			if (box.getRow() == pRow && box.getCol() == pCol){
			 return true;
			}
		}
		return false;
	}
	
	private boolean isConnected(Cell pCell1, Cell pCell){
		
		//skrivs av Adam...
		
		return true;
	}
	
	private boolean isConnected(int pRow1, int pCol1,  int pRow2 , int pCol2){
		
		//skrivs av Adam...
		
		return true;
	}
	/**
	 * Returnerar den cell som expanderades senast innan
	 * 
	 * @param pRow1
	 * @param pCol1
	 * @param pRow2
	 * @param pCol2
	 * @return
	 */
	private Cell cellNeighbour(int pRow1, int pCol1,  int pRTarget , int pCTarget){
		
		//skrivs av Adam...
		
		return new Cell(0, 0);
	}
	

/**
 * Operates on an (empty) Vector with States
 * and "fills" with all successor states
 *
 * @param pStates
 */
public void allSuccessors(Vector<State> pStates) {
    /*
     * TODO
     * 
     * Idea taken from HW1
     * I guess that the reason for sending in an empty vector that this function
     * "operates" on is to avoid incorrect references...
     * 
   */

        pStates.clear();

        int boxIndex = 0;
        for (Box box : boxes) {
                /* If a move is possible, then add the new state in the pStates vector */
            if (tryMove(box, 'U'))
                pStates.add(new State(this, boxIndex, 'U'));
            if (tryMove(box, 'D'))
                pStates.add(new State(this, boxIndex, 'D'));
            if (tryMove(box, 'R'))
                pStates.add(new State(this, boxIndex, 'R'));
            if (tryMove(box, 'L'))
                pStates.add(new State(this, boxIndex, 'L'));
            boxIndex++;
        } // End for boxes
    } // End allSuccessors

    /**
     * Tries to make a move from a certain position
     * <p/>
     * up = row - 1
     * down = row + 1
     * right = column + 1
     * left = column - 1
     *
     * @param pDir direction
     */

} // End Class State
