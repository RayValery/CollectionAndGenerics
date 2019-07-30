package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.List;

public class CardDeck {

    public static void main(String[] args) {

        List<Card> DeckOfCard = new ArrayList<>();
        for (Card.Face face : Card.Face.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                DeckOfCard.add(new Card(suit, face));
            }
        }

        Collections.shuffle(DeckOfCard);
        Collections.sort(DeckOfCard);

        Card card = new Card(Card.Suit.HEART, Card.Face.JACK);

        int i = Collections.binarySearch(DeckOfCard, card);
        if (i >= 0) System.out.println("Card was found on the positionn " + i);
        else System.out.println("Card was not found");


        //System.out.println("Original Deck of Cards: ");
        //Out(DeckOfCard);
    }

    private static void Out(List<Card> deckOfCard) {
        for (int i = 0; i < deckOfCard.size(); i++) {
            System.out.printf("%-20s %s", deckOfCard.get(i), (i + 1) % 4 == 0 ? "\n" : "  ");
        }
    }

}


class Card implements Comparable<Card> {
    protected enum Suit {PEAK, CROSS, HEART, TAMB}

    ;

    protected enum Face {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}

    ;

    private final Suit suit;
    private final Face face;

    public Suit getSuit() {
        return suit;
    }

    public Face getFace() {
        return face;
    }


    public Card(Suit s, Face g) {
        this.suit = s;
        this.face = g;
    }

    @Override
    public int compareTo(Card card) {
        List<Face> faces = Arrays.asList(Face.values());
        if (faces.indexOf(card.getFace()) < faces.indexOf(this.getFace())) {
            return -1;
        } else if (faces.indexOf(card.getFace()) > faces.indexOf(this.getFace())) {
            return +1;
        } else return (String.valueOf(this.getSuit()).compareTo(String.valueOf(card.getSuit())));
    }

    @Override
    public String toString() {
        return (face + " of " + suit);
    }
}

class ComparatorCard implements Comparator<Card> {
    List<Card.Face> faces = Arrays.asList(Card.Face.values());

    @Override
    public int compare(Card card1, Card card2) {

        if (faces.indexOf(card1.getFace()) < faces.indexOf(card2.getFace())) {
            return 1;
        } else if (faces.indexOf(card1.getFace()) > faces.indexOf(card2.getFace())) {
            return -1;
        } else return (String.valueOf(card1.getSuit()).compareTo(String.valueOf(card2.getSuit())));
    }
}



