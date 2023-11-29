/*Wordle game
by Akash Sahu
Using Java
Topics:Scanner-to take input,substring-to compare strings,loops,ANSI color codes
Special thanks to_youtuber-TokyoEdtech,*/
import java.util.Scanner;
import java.util.Random;
class wordle
    {
    public static void main(String args[]){
        //ANSI Color code-from dominikwilkowski-github.gist
        final String bg_green="\u001b[42m";
        final String bg_yellow="\u001b[43m";
        final String reset="\u001b[0m";

        System.out.println("Wordle!");
       
        String[] words={"SHAKE","SHARE","PANIC","AMUSE","SHADE"};
        int wIndex=(int)(Math.random()*(words.length));
        String correct=words[wIndex];


        Scanner sc=new Scanner(System.in);
        String guess="";

        //Loop for six guesses
        for(int round=0;round<6;round++){

        System.out.print(" Please guess.>");
        guess=sc.nextLine().toUpperCase();//.toUpperCase will change all small leter in Capital letter
        

        //Creating a loop to iterate through each level 
        for(int i=0;i<5;i++)
        {

        if(guess.substring(i,i+1).equals(correct.substring(i,i+1)))
        {
            //letter mmapches,so we will print in green
            //some of the color codes are:
            //background_green="\u001b[42m"
            //background_Yellow="\u001b[43m"
            //Reset="\u001b[0m"
            //here yellow,shows that word is in letter but in different path
            //green shows that word is in right place 
            System.out.print(bg_green+guess.substring(i,i+1)+reset);
        }
        else if(correct.indexOf(guess.substring(i,i+1)) > -1)
        {
            //letter is in word but in different location
            System.out.print(bg_yellow+guess.substring(i,i+1)+reset);
        }
        else
            {
            //Letter,Not in word
            System.out.print(guess.substring(i,i+1));
            }
        }
        System.out.println("");
        if(guess.equals(correct))
        {
            System.out.println("Correct! You win!");
            break;
        }
        }
        //Print correct answer,if player losses
        if(!guess.equals(correct))
        {
            System.out.println("Wrong! The Correct word is" + correct+".");
        }
    }
}