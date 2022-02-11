package org.example;

import java.io.*;
import java.util.*;
public class App 
{
    static PokerGame pg = new PokerGame();

    //Converting the letters to value
    static int numConverter(char c){

        if(c == CardValue.TEN.cardLetter)
            return CardValue.TEN.cardValue;
        else if(c == CardValue.JACK.cardLetter)
            return CardValue.JACK.cardValue;
        else if(c == CardValue.QUEEN.cardLetter)
            return CardValue.QUEEN.cardValue;
        else if(c == CardValue.KING.cardLetter)
            return CardValue.KING.cardValue;
        else if(c == CardValue.ACE.cardLetter)
            return CardValue.ACE.cardValue;
        else
            return Integer.parseInt(String.valueOf(c));
    }

    public static void main(String[] args) throws Exception {

        File pokerFile = new File("poker-hands.txt");
        Scanner scanner = new Scanner(pokerFile);
        int player1cnt = 0;
        int player2cnt = 0;
        while(scanner.hasNext()){

            int player1Hand[]= new int[5];
            char player1Suit[] = new char[5];
            int player2Hand[]= new int[5];
            char player2Suit[] = new char[5];


            for(int i=0; i<5; i++){
                String card = scanner.next();
                char tmp = card.charAt(0);
                player1Hand[i] = numConverter(tmp);
                player1Suit[i] = card.charAt(1);
            }

            for(int i=0; i<5; i++){
                String card = scanner.next();
                char tmp = card.charAt(0);
                player2Hand[i] = numConverter(tmp);
                player2Suit[i] = card.charAt(1);
            }

            Arrays.sort(player1Hand);
            player1Hand = pg.reverse(player1Hand);
            Arrays.sort(player2Hand);
            player2Hand = pg.reverse(player2Hand);

            LinkedHashMap<Integer,Integer> player1HandMap = Card.sortingCard(player1Hand);
            LinkedHashMap<Integer,Integer> player2HandMap = Card.sortingCard(player2Hand);


            // Saving results
            int result1 = pg.result(player1Suit, player1HandMap);
            int result2 = pg.result(player2Suit, player2HandMap);


            // Compare the results from both players and evaluate the winner
            if(result1>result2){
                player1cnt++;
                System.out.println("Player1's rank : " + result1 + " || Player2's rank: " + result2 +"|| Player1 wins.");
            }
            else if(result1<result2){
                player2cnt++;
                System.out.println("Player1's rank : " + result1 + " || Player2's rank: " + result2 +"|| Player2 wins.");

            }
            else{   //if the hands are same rank then follow the poker rule.
                Object[] key_b = player1HandMap.keySet().toArray();
                Object[] key_w = player2HandMap.keySet().toArray();

                int suit=0;

                for(int i =0 ; i<key_b.length; i++){
                    if((int)key_b[i]>(int)key_w[i]){
                        player1cnt++;
                        System.out.println("Player1's rank : " + result1 + " || Player2's rank: " + result2 +"|| Player1 wins.");
                        suit=1;
                        break;
                    }
                    else if((int)key_b[i]<(int)key_w[i]){
                        player2cnt++;
                        System.out.println("Player1's rank : " + result1 + " || Player2's rank: " + result2 +"|| Player2 wins.");
                        suit=1;
                        break;
                    }
                }

                if(suit==0)
                    System.out.println("Tie.");
            }
        }


        System.out.println("----------Total Score:----------");
        System.out.println("   Player1 : " + player1cnt + " || " + "Player2 : " + player2cnt);



    }
}
