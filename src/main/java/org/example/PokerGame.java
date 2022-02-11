package org.example;

import java.util.Map;

public class PokerGame {

    boolean isStraight(Object[] key) {

        boolean isHandStraight = true;
        for (int i = 0; i < key.length - 1; i++)
            if (((int) key[i] - (int) key[i + 1]) != 1)
                isHandStraight = false;
        return isHandStraight;
    }


    int[] reverse(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            newArr[i] = arr[arr.length - 1 - i];

        return newArr;
    }

    int result(char[] card, Map<Integer, Integer> map) {
        Object[] key = map.keySet().toArray();
        Object[] value = map.values().toArray();

         boolean isFlush = true;

        //checking if the hand is flush first
        char flush = card[0];
        for (int i = 0; i < card.length; i++) {
            if (flush != card[i]) {
                isFlush = false;
                break;
            }
        }
        if(isFlush && isStraight(key) && (int)key[0]==14 && (int)key[4]==10) {
            return CardRank.ROYAL_FLUSH.showRank();
        }
        else if(isFlush && isStraight(key)){
            return CardRank.STRAIGHT_FLUSH.showRank();
        }
        else if((int)value[0]== 4){
            System.out.println("Card Rank is :" + CardRank.FOUR_OF_A_KIND.showRank());
            return CardRank.FOUR_OF_A_KIND.showRank();
        }
        else if( (int)value[0]==3 && map.size()==2){

            return CardRank.FULL_HOUSE.showRank();
        }
        else if( isFlush ){

            return CardRank.FLUSH.showRank();
        }
        else if(!isFlush && isStraight(key) && map.size()==5){
            return CardRank.STRAIGHT.showRank();
        }
        else if(!isFlush && (int)value[0]==3 && map.size()>2){
            return CardRank.THREE_OF_A_KIND.showRank();
        }
        else if(!isFlush && (int)value[0]==2 && (int)value[1]==2){
            return CardRank.TWO_PAIRS.showRank();
        }
        else if(!isFlush && (int)value[0]==2 && map.size()==4){
            return CardRank.PAIR.showRank();
        }
        else
            return CardRank.HIGH_CARD.showRank();

    }

}
