package org.example;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class Card {

    static LinkedHashMap<Integer,Integer> sortingCard(int []card){
        //sorting cards in desc order using Linked hashmap
         LinkedHashMap<Integer,Integer> cardMap = new LinkedHashMap<Integer,Integer>();


        int num=0,count=1;

        for(int i=0; i<card.length; i++){
            if(!cardMap.containsKey(card[i])){
                cardMap.put(card[i],1);
            }
            else{
                int value = cardMap.get(card[i]);
                cardMap.put(card[i], ++value);
            }
        }


        // Sorting by card value;
        if(cardMap.size()<5){

            Object []cardValue = cardMap.values().toArray();
            Arrays.sort(cardValue);

            LinkedHashMap<Integer, Integer> newMap = new LinkedHashMap<Integer,Integer>();
            for(int i=0; i<cardValue.length;i++){

                for(Integer key: cardMap.keySet()){

                    if(cardMap.get(key)==(int)cardValue[cardValue.length-1-i]){

                        newMap.put(key, (Integer)cardValue[cardValue.length-1-i]);
                        cardMap.remove(key);
                        break;
                    }
                }
            }

            return newMap;
        }

        return cardMap;
    }

}
