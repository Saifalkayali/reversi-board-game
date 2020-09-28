
package model;

import java.io.Serializable;

/**
 *
 * @author saifalkayali
 *
 * For creating this game i need to implement the following steps:
 * 1)View the board in the start status
 *      - initialize the board as a board bean
 *      - assign each disks in the starting position. 
 * 2) Place buttons
 *      - creating methods that manipulate the board
 *          - need to figure out how to not place a hidden field on initial start discs
 * 3) writing a method that takes the coordinates of a selected move and determines if the move is valid
 *      - Have to check directions. is it a valid move to move to the left and flip pieces. 
 *      - if there's one piece of one color followed by another of a different color
 * 
 * 
 * 4) one that takes those arguments and determines the outcome of the move
 * 5) once you have a isValidMove function, you call that when the mouse is clicked and pass the coordinates of the clicked block.
 *     
 *
 */

public final class Reversi implements Serializable {
    
    /** move offset for row */
    private static final int[] OFFSET_ROW = {-1, -1, -1,  0,  0,  1,  1,  1};
	
	/** move offset for column */
    private static final int[] OFFSET_COL = {-1,  0,  1, -1,  1, -1,  0,  1};
    
    
    private String errMsg;
    private int turn;
    public int blackScore=2;
    public int whiteScore=2;
    
    //return the errMsg 
    public String getErrMsg(){
        return errMsg;
    }
    /**
     * Get the value of turn
     *
     * @return the value of turn
     */
    public int getTurn() {
        return turn;
    }

    private Disc[][] board;

    /**
     * Get the value of board
     *
     * @return the value of board
     */
    public Disc[][] getBoard() {
        return board;
    }
    
    // a method for placing a disc ,
    //it takes the color, row and col of the players click and creates a disc object
    public boolean placeDisc(Color color, int row, int col){
        board [row][col] = new Disc(color);
        
        return true;
    }
    /**
     *
     * @return 
     * @returns the mark of the current player
     */
    public Color getCurrentPlayer() {
        return turn % 2 == 0 ? Color.BLACK : Color.WHITE;
    }
    
    // a  method to restart the game 
    public final void reset() {
        board = new Disc [8][8];
        turn = 0;
        errMsg= "";
        placeDisc(Color.WHITE,3 , 3);
        placeDisc(Color.BLACK,3 , 4);
        placeDisc(Color.WHITE,4 , 4);
        placeDisc(Color.BLACK,4 , 3);
    }    
    
    // A constructor to initialize the board
    public  Reversi() {
        board = new Disc [8][8];
        
        placeDisc(Color.WHITE,3 , 3);
        placeDisc(Color.BLACK,3 , 4);
        placeDisc(Color.WHITE,4 , 4);
        placeDisc(Color.BLACK,4 , 3);
        
        }
    

    // a method that takes the specifed row and col and checks if the move is valid 
    public void placeDisc(int row, int col) {
            
            // if move is valid 
            if(isValidMove(new Disc(getCurrentPlayer()), row, col, false)){
                
                isValidMove(new Disc(getCurrentPlayer()), row, col, true);
                errMsg= "";
                //place disc
                placeDisc(getCurrentPlayer(), row, col);
                //increment turn
                turn++;
                
            }
            else{
                //otherwise send out a message
                errMsg= "Move is invalid, give it another shot! ";
            }
            
    }

    public boolean isValidMove(Disc disc, int row, int col, boolean flip){
        
        // creating an oppsite disc and setting its color to the current's player's color(passed thru)
        Disc oppDisc = (new Disc(disc.getColor()));
        
        // flip the opposite disc to the other color
        oppDisc.flipDisc();
        
        //loop thru the board 
        for ( int i= 0; i<8 ; i++){
            
            //checking neighbor cells
            int curRow= row + OFFSET_ROW[i];
            int curCol = col + OFFSET_COL[i];

            boolean hasOppDiscBetween = false;
            
            // while the row and col is within the board 
            while (curRow >=0 && curRow < 8 && curCol >= 0 && curCol < 8) {
                
                //if the the current col and row is not empty and the it is of opposite color then flip discs
                if (board[curRow][curCol] != null && board[curRow][curCol].getColor() == oppDisc.getColor()){
                    if( flip == true){
                        board[curRow][curCol].flipDisc();
                    }    

                    hasOppDiscBetween = true;
                }
                else if ((board[curRow][curCol] != null && board[curRow][curCol].getColor() == disc.getColor()) && hasOppDiscBetween )
                {   
                                        return true;
                                }
                else{
                    break;
                }
                
                curRow += OFFSET_ROW[i];
                curCol += OFFSET_COL[i];
                
                        }

            }
        return false;


        }
    
    private void calScore() {
        for (int i = 0; i < 8; ++i)
            for (int j = 0; j < 8; ++j)
                {
                    if (board[i][j].getColor() == Color.BLACK)
                        ++blackScore;
                    else if (board[i][j].getColor() == Color.WHITE)
                        ++whiteScore;
                
                }
        
    }
    
   
    public int getBlackScore(){
       /* for (int i = 0; i < 8; ++i)
            for (int j = 0; j < 8; ++j)
                {
                    if (board[i][j].getColor() == Color.BLACK)
                        ++blackScore;
        }*/
        return blackScore;
    }
    public int getWhiteScore(){
        /*for (int i = 0; i < 8; ++i)
            for (int j = 0; j < 8; ++j)
                {
                    if (board[i][j].getColor() == Color.WHITE)
                        ++whiteScore;
       
}*/
        return whiteScore;
}
}