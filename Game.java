// Luck Test game

/*
 *The user will be given 5000 points to start and will be able to play a variety of games.
 *They must bet a amount of points to play and can either lose their bet or win and gain some points.
 *They can leave the casino after each game, but will be kicked out if they run out of points.
 */

//Importing various packages  

import java.util.*;       
import java.lang.Thread;  // to pause the execution of current thread 

public class Game {

        /* All these below variables are declared static,
           so that they can be shared among all the functions as a single copy. */

        static int balance = 5000;
        static int check = 0;
        static String player_name = "Player";


        /* Main function */

        public static void main(String[] args) throws InterruptedException { // use of throws incase of interrupted exception

                Scanner s = new Scanner(System.in); // Scanner class.         

                welcome_screen(); // function call welcome screen.          

                System.out.println("Enter Player's name");
                String player_name = s.nextLine(); // input username

                System.out.println("Welcome " + player_name + " in our game");
                System.out.println("Ready to have some fun?\n");

                Thread.sleep(400); // pause screen for 400 miliseconds.

                game_Rules(); // function call game rules.

                System.out.println("Ready to check your luck\n");
                System.out.println("LET'S START");

                gamePlay(player_name); // function call gamePlay

        }
        

        /* this function shows the welcome screen i.e. LUCK TEST made by using pattern '|' */

        public static void welcome_screen() {

                // pattern to print luck test

                System.out.println("\n***********************************************************************************************\n");
                System.out.println("||        ||     ||    |||||    ||  |||        ||||||||    ||||||   |||||||   ||||||||");
                System.out.println("||        ||     ||    ||       || ||             ||       ||       ||           ||   ");
                System.out.println("||        ||     ||    ||       |||               ||       |||||      |||        ||   ");
                System.out.println("||        ||     ||    ||       || ||             ||       ||            ||      ||   ");
                System.out.println("|||||||    |||||||     |||||    ||   |||          ||       ||||||   |||||||      ||   ");

                System.out.println("\n***********************************************************************************************\n");

        }
        

        /* Expalaining overall game rules */

        public static void game_Rules() {

                // Rules

                System.out.println("\n===============================================================================================\n");
                System.out.println("\t\t\tGame Rules");
                System.out.println("\n===============================================================================================");
                System.out.println("\n1. You Currently have 5000 points in your game account.");
                System.out.println("\n2. You have to bet some amount in each game and you gain or loose amount in each play");
                System.out.println("\n3. If point balance in your account becomes zero, then it is game over");
                System.out.println("\n4. If point balance in you account is greater than or equal to  10000, You Win i.e. You are lucky");
                System.out.println("\n===============================================================================================\n");
        }


        /* explaining game1 rules */

        public static void game1_Rules() {

                // Rules

                System.out.println("\n===============================================================================================\n"); 
                System.out.println("\t\t\tgame1 Rules");
                System.out.println("\n===============================================================================================");
                System.out.println("\n1.Computer will generate 3 random numbers.");
                System.out.println("\n2.Either all numbers are same, or all divisible by 2 or all not divisble by 2 or all are equal to 7");
                System.out.println("\n3. If any of the 2nd point conditon occurs your balance amount gets 5 times");
                System.out.println("\n4. If none of the conditions mentioned in 2nd point occurs, then you loose all your betted amount");
                System.out.println("\n===============================================================================================\n"); 
        }

        /* explaining game2 rules */

        public static void game2_Rules() {

                // Rules

                System.out.println("\n===============================================================================================\n");
                System.out.println("\t\t\tgame2 Rules");
                System.out.println("\n===================================================================================================================================");
                System.out.println("\n1. You have to guess any number between 1-50.");
                System.out.println("\n2. If you guess the exact number, your points will be 5 times");
                System.out.println("\n3. If you guess the number which is in the range of 5 less or 5 more than the program generated number,your points will be 2 times");
                System.out.println("\n4. If you guess the numbere which is in the range of 10 less or 10 more than the program generated number, your points will be same");
                System.out.println("\n5. If none of the above mentioned points occurs, then you loose all your betted amount");
                System.out.println("\n=================================================================================================================================\n"); 

        }

        /* explaining game3 rules */

        public static void game3_Rules() {

                // Rules

                System.out.println("\n===============================================================================================\n");
                System.out.println("\t\t\tgame3 Rules");
                System.out.println("\n===================================================================================================================================");
                System.out.println("\n1. You have to enter on how many numbers you wanna bet in range [1-50].");
                System.out.println("\n2. Then you enter all the numbers on which you wanna bet");
                System.out.println("\n3. If the computer genrated number matches with any of your entered number, then betted amount per number gets multiplied by 50");

                System.out.println("\n4. If none of the above mentioned points occurs, then you loose all your betted amount");
                System.out.println("\n=================================================================================================================================\n");
        }



        /* 
         * This gamePlay function contains all three games.
         * User will play a game of his/her choice.
         * User can quit game at any moment.
         */

        public static void gamePlay(String player_name) throws InterruptedException {

                Scanner s = new Scanner(System.in);

                /* while loop is true inside so that user can play game again and again */

                while (true) {

                        /* Asking user for his choice of game. */

                        System.out.println("Which of these games do you like to play :- \n");
                        System.out.println("1. [7.7.7] Casino : Vegas Slot game ");
                        System.out.println("2. Guess The Number Between [1 - 50] ");
                        System.out.println("3. Roulette :- Bet On Your Numbers\n ");
                        System.out.println("Press [1] , [2] , [3]");

                        int game_no; // which game
                        int bet_points; // betting amount in points
                        int check; // user want to continue or leave the game

                        game_no = s.nextInt();

                        /* Game no. 1  Casino */

                        if (game_no == 1) {

                                game1_Rules(); // function call game1 rules
                                Thread.sleep(300); // sleep for 3 seconds

                                System.out.println("BET Your points");
                                bet_points = s.nextInt(); // input betted points

                                /* Function call Casino game having bet points as parameters */

                                Casino_game(bet_points);

                                System.out.println();

                                /* Ask user to continue game or leave */

                                System.out.println("[Press 1] :--> If You Like To Try Another game");
                                System.out.println("[Press 2] :--> To QUIT");

                                check = s.nextInt(); // input 1 or 2: continue or leave

                                /* call function newgame to find all possibilities */

                                newgame(check, player_name);

                                if (check == 2) {
                                        break; // out of loop for its own choice
                                }
                                if (balance <= 0) {
                                        break; // out of loop because of 0 balance
                                }
                        }

                        /* Game no. 2  Guess game */

                        if (game_no == 2) {
                                game2_Rules(); // function call game2 rules
                                Thread.sleep(300); // sleep for 3 seconds

                                System.out.println("BET Your points");
                                bet_points = s.nextInt(); // input betted points

                                /* Function call Guess game having bet points as parameters */

                                Guess_game(bet_points);

                                /* Ask user to continue game or leave */

                                System.out.println();
                                System.out.println("[Press 1] :--> If You Like To Try Another game");
                                System.out.println("[Press 2] :--> To QUIT");

                                check = s.nextInt(); // input 1 or 2: continue or leave

                                /* call function newgame to find all possibilities */

                                newgame(check, player_name);

                                if (check == 2) { // out of loop for its own choice
                                        break;
                                }
                                if (balance <= 0) { // out of loop because of 0 balance
                                        break;
                                }
                        }

                        /* Game no. 3  Roulette game */

                        if (game_no == 3) {

                                game3_Rules(); // function call game2 rules
                                Thread.sleep(300); // sleep for 3 seconds

                                System.out.println("BET Your points");
                                bet_points = s.nextInt(); // input betted points

                                /* Function call Roulette game having bet points as parameters */

                                Roulette_game(bet_points);

                                /* Ask user to continue game or leave */

                                System.out.println();
                                System.out.println("[Press 1] :--> If You Like To Try Another game");
                                System.out.println("[Press 2] :--> To QUIT");

                                check = s.nextInt(); // input 1 or 2: continue or leave

                                newgame(check, player_name);

                                if (check == 2) {
                                        break; // out of loops of its own choice
                                }
                                if (balance <= 0) {
                                        break; // out of loop because of 0 balance
                                }

                        }

                        if (balance >= 10000) {
                                System.out.println("You Win , Wow you are so lucky");
                                break; // come out of the loop and game gets over.
                        }

                }

                return;
        }



        /* Newgame function is to check multiple possiblities
         * first to quit the game as per user's choice
         * other is to quit the game if balance is equal to 0 
         * or to continue the game if balance is greater than 0
         */

        public static void newgame(int check, String player_name) {
                if (check == 2) {
                        System.out.println("GOODBYE " + player_name + " !!!");
                        return; // return to the function from where it is being called
                } else {
                        if (balance > 0) {
                                System.out.println("LETS PLAY !!!!");

                        } else {
                                System.out.println(" SORRY YOU HAVE NO BALANCE ");
                                return; // return to the function from where it is being called
                        }
                }
        }



        /* Casino game play function with different conditions */

        public static void Casino_game(int bet_points) throws InterruptedException { // use of throws incase of interrupted exception

                // Condition to start the game

                if (bet_points <= balance && bet_points > 0) {
                        System.out.println("LETS SEE YOUR LUCK !!");
                        System.out.println("                     ");

                        Thread.sleep(300); // pause or sleep time of 3 seconds

                        Random random = new Random(); // class and object to generate random no.

                        // generates random number in range 1 to 9

                        int num1 = random.nextInt(10);
                        int num2 = random.nextInt(10);
                        int num3 = random.nextInt(10);

                        System.out.println(num1 + "   " + num2 + "   " + num3 + "   "); // prints all 3 random no. generated by program

                        /*Now set different conditions for all random numbers */

                        if (num1 % 2 == 0 && num2 % 2 == 0 && num3 % 2 == 0) // all are even numbers
                        {
                                System.out.println("CONGRATULATIONS !!!!");

                                balance += bet_points * 5;
                                balance -= bet_points;

                                System.out.println("You Have Won :--> " + bet_points * 5);
                                System.out.println("YOUR CURRENT BALANCE --> " + balance);
                                
                        } else if (num1 % 2 != 0 && num2 % 2 != 0 && num3 % 2 != 0) // all are odd numbers
                        {
                                System.out.println("CONGRATULATIONS !!!!");

                                balance += bet_points * 5;
                                balance -= bet_points;

                                System.out.println("You Have Won :--> " + bet_points * 5);
                                System.out.println("YOUR CURRENT BALANCE --> " + balance);
                                
                        } else if (num1 == num2 && num2 == num3 && num3 == num1) // all numbers are equal
                        {
                                System.out.println("CONGRATULATIONS !!!!");

                                balance = balance + bet_points * 5;
                                balance -= bet_points;

                                System.out.println("You Have Won :--> +" + bet_points * 5);
                                System.out.println("YOUR CURRENT BALANCE --> " + balance);
                                
                        } else if (num1 == 7 && num2 == 7 && num3 == 7) // all are equal to 7
                        {
                                System.out.println("CONGRATULATIONS !!!!");

                                balance += bet_points * 5;
                                balance -= bet_points;
                                System.out.println("You Have Won :--> " + bet_points * 5);
                                System.out.println("YOUR CURRENT BALANCE --> " + balance);
                                
                        } else {
                                System.out.println();
                                System.out.println("OOPS ! You Have Won Nothing !!");

                                balance -= bet_points;

                                System.out.println("YOUR CURRENT BALANCE --> " + balance);

                        }

                } else if (bet_points < 0) // betted points less than 0      
                {
                        System.out.println("You Cannot Place A Bet in Negative");
                } else {
                        System.out.println("You Cannot PLace A Bet More Than Your Current Balance ");
                }
        }



        /* Guess game play function with different conditions */

        public static void Guess_game(int bet_points) throws InterruptedException {

                Scanner s = new Scanner(System.in);

                // generates random number in range 1 to 50

                Random random = new Random();
                int num = random.nextInt(51);

                // condition for start of game

                if (bet_points <= balance && bet_points > 0) {
                        System.out.println("Guess the number between 1-50");
                        int n = s.nextInt();

                        System.out.println("Let's check your luck");
                        Thread.sleep(500); // sleep for 3 seconds

                        System.out.println("The number choosen by computer is " + num); // print guessed number

                        if (num == n) // exactly equal
                        {
                                System.out.println("CONGRATULATIONS !!!!");

                                balance += bet_points * 5;
                                balance -= bet_points;

                                System.out.println("You Have Won :--> " + bet_points * 5);
                                System.out.println("YOUR CURRENT BALANCE --> " + balance);
                        } else if ((num - 5) <= n && (num + 5) >= n) // in range of +5 to -5
                        {

                                System.out.println("CONGRATULATIONS !!!!");

                                balance += bet_points * 2;
                                balance -= bet_points;

                                System.out.println("You Have Won :--> " + bet_points * 2);
                                System.out.println("YOUR CURRENT BALANCE --> " + balance);
                        } else if ((num - 10) <= n && (num + 10) >= n) // in range of +10 to -10
                        {

                                System.out.println("CONGRATULATIONS !!!!");

                                balance = balance + bet_points * 1;
                                balance -= bet_points;

                                System.out.println("You Have Won :--> +" + bet_points * 1);
                                System.out.println("YOUR CURRENT BALANCE --> " + balance);
                        } else {
                                System.out.println();
                                System.out.println("OOPS ! You Have Won Nothing !!");

                                balance -= bet_points;
                                System.out.println("YOUR CURRENT BALANCE --> " + balance);

                        }

                } else if (bet_points < 0) // betted points less than 0
                {
                        System.out.println("You Cannot Place A Bet in Negative");
                } else {
                        System.out.println("You Cannot PLace A Bet More Than Your Current Balance ");
                }
        }



        /* Roulette game play function with different conditions */

        public static void Roulette_game(int bet_points) throws InterruptedException {
                Scanner s = new Scanner(System.in);

                // generates random number in range of 1-50

                Random random = new Random();
                int num = random.nextInt(51);

                // Condition for start of game

                if (bet_points <= balance && bet_points > 0) {
                        System.out.println("On how many numbers do you want to place your bet [1 - 50] :- ");
                        
                        int f;
                        f = s.nextInt(); // how many numbers to bet
                        int pointsnum = bet_points / f; // betted amount on each number

                        System.out.println("Bet on EACH Number :- " + pointsnum);

                        int arr_num[] = new int[f]; // declaring array of size betted number

                        /* take input as number entered by the user and store it in array */

                        for (int i = 0; i < f; i++) {
                                System.out.println("On Which Number Do You Want To Place Your Bet :- ");
                                arr_num[i] = s.nextInt();

                        }

                        System.out.println("Lets See Your Luck !!! ");

                        Thread.sleep(3000); // sleep for 3 seconds

                        System.out.println("The Number Choosen By Computer :- " + num);

                        int z = 0; // for condition purpose

                        /* Comparing random number with user entered number */

                        for (int i = 0; i < f; i++) {
                                if (arr_num[i] == num) {
                                        z = z + 1;
                                }
                        }

                        if (z > 0) {
                                System.out.println();
                                System.out.println("CONGRATULATIONS !!!!");

                                balance += pointsnum * 50;
                                balance -= bet_points;

                                System.out.println("You Have Won :--> " + pointsnum * 50);
                                System.out.println("YOUR CURRENT BALANCE --> " + balance);
                                
                        } else {
                                System.out.println();
                                System.out.println("OOPS ! You Have Won Nothing !!");
                                balance -= bet_points;
                                System.out.println("YOUR CURRENT BALANCE --> " + balance);
                        }

                } else if (bet_points < 0) {
                        System.out.println("You Cannot Place A Bet in Negative");
                        
                } else {
                        System.out.println("You Cannot PLace A Bet More Than Your Current Balance ");
                }

        }

}
