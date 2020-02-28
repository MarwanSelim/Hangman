package eg.edu.alexu.csd.datastructure.hangman.cs73;

import java.util.Scanner;

public class main {
    public static void main (String[] args) throws Exception{

        Hangman test = new Hangman();
        Scanner num= new Scanner(System.in);


        char x='0';
        Character y=new Character(x);
        System.out.println(test.guess(x));
        test.setMaxWrongGuesses(5);

        while (true){
            System.out.println("enter");
            x=num.nextLine().charAt(0);
            Character z=new Character(x);
            System.out.println(test.guess(z));

        }
    }
}
