//********************************************************************************
// STUDENT NAME:  [Luis Oliveros]
// FIU EMAIL: [loliv061@fiu.edu]
// CLASS: COP 2210 – [Fall 2018]
// ASSIGNMENT # [5]
// DATE: [11/25/2018]
//
// I hereby swear and affirm that this work is solely my own, and not the work 
// or the derivative of the work of someone else, except as outlined in the 
// assignment instructions.
//********************************************************************************


package tictactoe;
import java.util.Random;
import javax.swing.JOptionPane;

public class TicTacToe
{
   /*array for tic tac to board a boolean to set to true when game 
    ends a char that collects the letter of the winner O OR X for 
    user or the computer 
   */
    public static char board[][] = new char[3][3];
    public static boolean end = false;
    public static char win;
    public static String name;

    /* two nested for loop that prints the board starts in the main as well
    as the two possible starting points in the game the user first or 
    the computer is plans accordingly and has to loops that executed based 
    on the random outcome. these loops further call the other methods to execute*/
    public static void main(String[] args)  
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                board[i][j] = '-';
            }
        }
        for(int i = 0; i < 3; i++)
        {
             for(int j = 0; j < 3; j++)
             {
                 System.out.print(board[i][j] + " ");
             }
             System.out.println();
         }
         
        /* varaible name that holds users name and a random object 
        created to see who goes first the computer or the user based 
        on a int c with a length of 2.
        */
        name  = JOptionPane.showInputDialog("Welcome To the Game What Is Your Name?");
        String whoGoes = null;
        Random r = new Random();
        int c  = r.nextInt(2)+1;
        
        /*conditional if statement that choices randomly who goes first*/
        if(c == 1)
        {
            whoGoes = "The Computer";
        }
        else if(c == 2)
        {
            whoGoes = name;
        }
      
        JOptionPane.showMessageDialog(null,"It has been randomly decided that " + whoGoes + " will go first");
       
        /*if statement that runs if the computer goes first with a while loop
        that continues to run until there is a draw, win or loss for the user
        or computer then ends with the equal boolean ser to true and the loop is terminated
        */
        if(whoGoes.equals("The Computer"))
        {
            move();
            while(!end)
            {
                for(int i = 0; i < 3; i++)
                {
                    for(int j = 0; j < 3; j++)
                    {
                        System.out.print(board[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
                
                String move = JOptionPane.showInputDialog("enter your move, select the row and column from (0-2)");
              
                //possible moves from the play that get added to the char 2-D array
                if(move.equals("00") && board[0][0] == '-')
                {
                    board[0][0] = 'O';
                }
                else if(move.equals("01") && board[0][1] == '-')
                {
                    board[0][1] = 'O';
                }
                else if(move.equals("02") && board[0][2] == '-')
                {
                    board[0][2] = 'O';
                }
                else if(move.equals("10") && board[1][0] == '-')
                {
                    board[1][0] = 'O';
                }
                else if(move.equals("11") && board[1][1] == '-')
                {
                    board[1][1] = 'O';
                }
                else if(move.equals("12") && board[1][2] == '-')
                {
                    board[1][2] = 'O';
                }
                else if(move.equals("20") && board[2][0] == '-')
                {
                    board[2][0] = 'O';
                }
                else if(move.equals("21") && board[2][1] == '-')
                {
                    board[2][1] = 'O';
                }
                else if(move.equals("22") && board[2][2] == '-')
                {
                    board[2][2] = 'O';
                }
                else
                {
                    System.out.println("That is not a valid move");
                }
                
                System.out.println();
                end = won();
                move();
                
            }
            
            if(win == 'o')
            {
                JOptionPane.showMessageDialog(null,name + " Won");
            }
            else if(win == 'x')
            {
                 JOptionPane.showMessageDialog(null,"Computer Won");
            }
            else if(win == 'd' || win == 'D')
            {
                JOptionPane.showMessageDialog(null,"Game is a draw");
            }
            
        }
         /* second loop that runs but this time the user goes first and then
        the computer goes with the call to the move method, rinse and repeat 
        until the loop is broken with a boolean that switches to true.
        */
        else if(whoGoes.equals(name))
        {
            
            System.out.println(name + " goes first");     
            String move = JOptionPane.showInputDialog("enter your move, select both the row and column from (0-2)");
           //loop of possible outcomes of user followed by the 2-D array postion filled
            if(move.equals("00") && board[0][0] == '-')
            {
                board[0][0] = 'O';
            }
            else if(move.equals("01") && board[0][1] == '-')
            {
                board[0][1] = 'O';
            }
            else if(move.equals("02") && board[0][2] == '-')
            {
                board[0][2] = 'O';
            }
            else if(move.equals("10") && board[1][0] == '-')
            {
                board[1][0] = 'O';
            }
            else if(move.equals("11") && board[1][1] == '-')
            {
                board[1][1] = 'O';
            }
            else if(move.equals("12") && board[1][2] == '-')
            {
                board[1][2] = 'O';
            }
            else if(move.equals("20") && board[2][0] == '-')
            {
                board[2][0] = 'O';
            }
            else if(move.equals("21") && board[2][1] == '-')
            {
                board[2][1] = 'O';
            }
            else if(move.equals("22") && board[2][2] == '-')
            {
                board[2][2] = 'O';
            }
            else
            {
               JOptionPane.showMessageDialog(null,"That is not a valid move");
            }
             
            for(int i = 0; i < 3; i++)
            {
                for(int j = 0; j < 3; j++)
                {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            //loop the check the status of the game
            while(!end)
            {
                move();
                
                end = won();
                
                if(end)
                {
                    break;
                }
                
                for(int i = 0; i < 3; i++)
                {
                    for(int j = 0; j < 3; j++)
                    {
                        System.out.print(board[i][j] + " ");
                    }
                    System.out.println();
                }
                
                move = JOptionPane.showInputDialog("enter your move, select the row and column from (0-2)");

                if(move.equals("00") && board[0][0] == '-')
                {
                    board[0][0] = 'O';
                }
                else if(move.equals("01") && board[0][1] == '-')
                {
                    board[0][1] = 'O';
                }
                else if(move.equals("02") && board[0][2] == '-')
                {
                    board[0][2] = 'O';
                }
                else if(move.equals("10") && board[1][0] == '-')
                {
                    board[1][0] = 'O';
                }
                else if(move.equals("11") && board[1][1] == '-')
                {
                    board[1][1] = 'O';
                }
                else if(move.equals("12") && board[1][2] == '-')
                {
                    board[1][2] = 'O';
                }
                else if(move.equals("20") && board[2][0] == '-')
                {
                    board[2][0] = 'O';
                }
                else if(move.equals("21") && board[2][1] == '-')
                {
                    board[2][1] = 'O';
                }
                else if(move.equals("22") && board[2][2] == '-')
                {
                    board[2][2] = 'O';
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"That is not a valid input program will close"); 
                }

                System.out.println();
                                
                end = won();
                
            }
            
            
            for(int i = 0; i < 3; i++)
            {
                for(int j = 0; j < 3; j++)
                {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            
            if(win == 'x')
            {
                 JOptionPane.showMessageDialog(null, "Computer Won");
            }
            else if(win == 'o')
            {
                JOptionPane.showMessageDialog(null, name + " Won");
            }
            else if(win == 'd')
            {
                 JOptionPane.showMessageDialog(null,"Game is a Draw");
            }
            
        }
        else
        {
             JOptionPane.showMessageDialog(null,"That is not a valid input program will close");  
        }
        
    }
    /* this methods mimics a psuedo random response from the computer
    as it checks every postions of the 2-d char array to see if it has a
    dash. if its does it means it is empty and it adds its move with a X.
    witin each loop is a call to the won method to check if the game ends after
    that loop or continues until won is satisfied.
    */ 
    public static void move()
    {
        if(board[0][0] == '-')
        {
            board[0][0] = 'X';
            won();
        }
        else if(board[0][1] == '-')
        {
            board[0][1] = 'X';
            won();
        }
        else if(board[0][2] == '-')
        {
            board[0][2] = 'X';
            won();
        }
        else if(board[1][0] == '-')
        {
            board[1][0] = 'X';
            won();
        }
        else if(board[1][1] == '-')
        {
            board[1][1] = 'X';
            won();
        }
        else if(board[1][2] == '-')
        {
            board[1][2] = 'X';
            won();
        }
        else if(board[2][0] == '-')
        {
            board[2][0] = 'X';
            won();
        }
        else if(board[2][1] == '-')
        {
            board[2][1] = 'X';
            won();
        }
        else if(board[2][2] == '-')
        {
            board[2][2] = 'X';
            won();
        }
        
    }
    /* method that checks and returns true if the game is over. the game is over
    if in the array there are three spaces that are the same. when one of these
    if statements is true then the method is returned as true and the win will
    equals to etheir o or x to signify who has won the game o being the user 
    and x being the computer
    */
     public static boolean won()
    {
        boolean won  = false;
        
        if(board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[0][1] == 'O' && board[0][2] == 'O' && board[0][0] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[1][0] == 'O' && board[2][0] == 'O' && board[0][0] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[2][1] == 'O' && board[1][1] == 'O' && board[0][1] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[2][2] == 'O' && board[1][1] == 'O' && board[0][0] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[1][1] == 'O' && board[1][2] == 'O' && board[1][0] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[2][2] == 'O' && board[1][2] == 'O' && board[0][2] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[2][1] == 'O' && board[2][2] == 'O' && board[2][0] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[0][0] == 'O' && board[0][2] == 'O' && board[0][1] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[0][0] == 'O' && board[2][0] == 'O' && board[1][0] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[0][2] == 'O' && board[2][2] == 'O' && board[1][2] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[2][0] == 'O' && board[2][2] == 'O' && board[2][1] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[0][0] == 'O' && board[2][2] == 'O' && board[1][1] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[0][2] == 'O' && board[2][0] == 'O' && board[1][1] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[0][1] == 'O' && board[2][1] == 'O' && board[1][1] == 'O')
        {
            won = true; win = 'o';
        }
        else if(board[1][0] == 'O' && board[1][2] == 'O' && board[1][1] == 'O')
        {
            won = true; win = 'o';
        }
        
        if(board[0][0] == 'X' && board[0][1]== 'X' && board[0][2] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[0][1] == 'X' && board[0][2] == 'X' && board[0][0] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[1][0] == 'X' && board[2][0] == 'X' && board[0][0] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[2][1] == 'X' && board[1][1] == 'X' && board[0][1] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[2][2] == 'X' && board[1][1] == 'X' && board[0][0] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[1][1] == 'X' && board[1][2] == 'X' && board[1][0] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[2][2] == 'X' && board[1][2] == 'X' && board[0][2] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[2][1] == 'X' && board[2][2] == 'X' && board[2][0] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[0][0] == 'X' && board[0][2] == 'X' && board[0][1] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[0][0] == 'X' && board[2][0] == 'X' && board[1][0] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[0][2] == 'X' && board[2][2] == 'X' && board[1][2] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[2][0] == 'X' && board[2][2] == 'X' && board[2][1] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[0][0] == 'X' && board[2][2] == 'X' && board[1][1] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[0][2] == 'X' && board[2][0] == 'X' && board[1][1] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[0][1] == 'X' && board[2][1] == 'X' && board[1][1] == 'X')
        {
            won = true; win = 'x';
        }
        else if(board[1][0] == 'X' && board[1][2] == 'X' && board[1][1] == 'X')
        {
            won = true; win = 'x';
        }
        
        // loop that checks if there is a tie in the game
        boolean dash = true;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(board[i][j] == '-')
                {
                    dash = false;
                }
            }
        }
        
        if(dash)
        {
            win = 'd'; won = true;
        }
        return won;
    }
  }
    
    
