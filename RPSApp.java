import java.util.Scanner;
import java.util.Random;

enum HandSign {
    ROCK, 
    PAPER,
    SCISSORS 
}

public class RPSApp {
    /**
     * Get the computer’s move (randomly generated)
     */
    public static HandSign getComputerMove(){
        Random rd = new Random();
        int n = rd.nextInt(3); // n will be a random number in {0,1,2}
        
        HandSign computerMove = null; 

        switch (n){
            case 0:
                computerMove = HandSign.ROCK;
                break;
            case 1:
                computerMove = HandSign.PAPER;
                break;
            case 2:
                computerMove = HandSign.SCISSORS;
                break;
            default:
                computerMove = null;
        }

        return computerMove;
    }

    /**
     * Get the player move from the keyboard input
     */
    public static HandSign getPlayerMove(){
        // The Scanner class is used to get the keyboard input
        Scanner in = new Scanner(System.in);
        // Use a variable to tag if the input is valid 
        // (one of the characters {s,S,p,P,r,R,q,Q}) or not
        boolean validInput = false;
        HandSign playerHandSign = null;
        do {// repeat until valid input

            // Add your code to give some description about what input the
            //  users are supposed to give
            System.out.println("Enter R for rock, P for paper or S for scissors (or Q to quit)");

            // convert the input string into a char type
            char inChar = in.next().toLowerCase().charAt(0);

            switch (inChar){
                case 's':
                    playerHandSign = HandSign.SCISSORS;
                    validInput = true;
                    break;
                case 'S':
                    playerHandSign = HandSign.SCISSORS;
                    validInput = true;
                    break;
                case 'r':
                    playerHandSign = HandSign.ROCK;
                    validInput = true;
                    break;
                case 'R':
                    playerHandSign = HandSign.ROCK;
                    validInput = true;
                    break;
                case 'p':
                    playerHandSign = HandSign.PAPER;
                    validInput = true;
                    break;
                case 'P':
                    playerHandSign = HandSign.PAPER;
                    validInput = true;
                    break;
                case 'q':
                    validInput = true;
                    break;
                case 'Q' :
                    validInput = true;
                    break;
                default:
                    playerHandSign = null;
            }


        } while(!validInput);
        
        return playerHandSign;

      }

    /**
     * Check who wins
     *
     * @param h1 the first hand sign
     * @param h2 the second hand sign
     * @return 0 if two signs equal, 
     *        -1 if the second sign wins, 
     *         1 if the first sign wins
     *
     */
    public static int whoWins(HandSign h1, HandSign h2){
         if (h1 == h2){
            return 0;
         } else if ((h1 == HandSign.ROCK && h2 == HandSign.SCISSORS) || (h1 == HandSign.PAPER && h2 == HandSign.ROCK) || h1== HandSign.SCISSORS && h2 == HandSign.PAPER){
            return 1;
         } else {
            return -1;
         }
    }
    
    /**
     * The main method
     */
    public static void main(String[] args) {
        int playerScore = 0;
        int computerScore = 0;

        HandSign playerMove;// player’s sign from keyboard
        HandSign computerMove;// computer’s random sign

        int checkwin;
        boolean gameOver = false;
        while (!gameOver){
            // repeat this process till the user quits
            
        playerMove = getPlayerMove();
        if (playerMove == null){
            gameOver = true;
            continue;
        }

        computerMove = getComputerMove();

        checkwin= whoWins(playerMove, computerMove);

        System.out.println ("Player played : "+ playerMove);
        System.out.println ("Computer played : "+ computerMove);
        switch (checkwin) {
            case 1:
                System.out.println ("Player won!");
                playerScore += 1;
                break;
            case -1:
                System.out.println ("Computer won!");
                computerScore += 1;
                break;
            default:
                System.out.println ("It's a tie!");

        }
        
        System.out.println ("Player score : "+ playerScore);
        System.out.println ("Computer score : "+ computerScore);

        }
    }
}