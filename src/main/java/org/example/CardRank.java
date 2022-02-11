package org.example;

public enum CardRank {
    ROYAL_FLUSH(10,"Royal Flush"),
    STRAIGHT_FLUSH(9, "Straight Flush"),
    FOUR_OF_A_KIND(8, "Four of A Kind"),
    FULL_HOUSE(7, "Full House"),
    FLUSH(6, "Flush"),
    STRAIGHT(5, "Straight"),
    THREE_OF_A_KIND(4, "Three of A Kind"),
    TWO_PAIRS(3, "Two Pairs"),
    PAIR(2, "One Pair"),
    HIGH_CARD(1, "High Card");

    int rank;
    String rankName;
    CardRank(int r, String s){
        rank = r;
        rankName = s;
    }
    int showRank(){

        return rank;
    }
    String showRankName(){
        return rankName;
    }
}
