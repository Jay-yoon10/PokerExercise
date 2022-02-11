package org.example;

public enum CardValue {
    TEN(10, 'T'),
    JACK(11, 'J'),
    QUEEN(12, 'Q'),
    KING(13, 'K'),
    ACE(14, 'A');

    int cardValue;
    char cardLetter;
    CardValue(int i, char a) {
        cardValue = i;
        cardLetter = a;
    }

    int showValue(){
        return cardValue;

    }
    char cardLetter(){
        return cardLetter;
    }

}
