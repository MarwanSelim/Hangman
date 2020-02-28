package eg.edu.alexu.csd.datastructure.hangman.cs73;

import javax.swing.text.FlowView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Hangman implements IHangman {
    private File file = new  File  ("C:/Users/LENOVO/Desktop/hang man.txt");
    private  Scanner scan1=new Scanner(file);
    private int counter=0;
    private String m;
    private boolean t =true;
    private boolean t1 =true;
    private boolean t2 =true;

    private Scanner scan2=new Scanner(file);
    private int lifes=2;
    private String word ;
    private int num =1000;
    private char[]arr1 = new char[num];
    private String[] diction =new String[100000000];

    public Hangman() throws FileNotFoundException {
    }


    public void setme (String[] words){
        while (scan1.hasNextLine()){
            m=scan1.nextLine();
            words[counter]=m;
            counter++;
        }
    }

    public void setDictionary(String[] words){
        setme(words);
    }
    public String selectRandomSecretWord(){
        setDictionary(diction);
        Random choice =new Random();
        int number =choice.nextInt(counter);
        String ourword=diction[number];
        return ourword;


    }


    public String guess (Character c) throws Exception{
        if (t1) {
            word = selectRandomSecretWord();
            t1=false;
        }
        int i;
        if (t){
            for (i=0;i<word.length();i++) {
                arr1[i] = '_';
            }
            t=false;
        }
        int check=0;
        int temp = (int)c-32;
        char x=(char)temp;
        int temp2 = (int)c+32;
        char y=(char)temp2;
        char[]arr2 = word.toCharArray();

        for (i = 0; i < word.length(); i++) {
            if (c == arr2[i] ){
                arr1[i] = c;
                check++;

            } else if (x == arr2[i]) {
                arr1[i] = x;
                check++;
            }else if (y==arr2[i]){
                arr1[i] = y;
                check++;
            }
        }
        char [] arr3 = new char[2*word.length()];
        int j=0;
        for (i=0;i<word.length()*2;i=i+2){
            arr3[i]=arr1[j];
            arr3[i+1]=' ';
            j++;
        }
        for (i=0;i<word.length()*2;i++){
            if(arr3[i]=='_'){
                t2=false;
                break;
            }else {
                t2=true;
            }
        }

        String show = String.valueOf(arr3);
        if (check == 0) {
            lifes--;
        }
        if (lifes<=0){
            return null;
        }else if (t2){
            return null;
        }else{
            return show;
        }
    }

    public void setMaxWrongGuesses(Integer max){
        lifes =max;
    }
}
