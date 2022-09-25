package com.javapractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeckOfCards {
    private ArrayList<HashMap<String, String>> cards = new ArrayList<>();
    private String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
    private String[] ranks = { "2", "3", "4", "5", "6", "7", "8","9", "10", "Jack", "Queen", "King", "Ace" };
    private Queue queue =new Queue();
    private HashMap<String, String>[][] players = (HashMap<String, String>[][]) new HashMap[4][9];
    private static final Logger log = LogManager.getLogger(DeckOfCards.class);

    private void makeCards() {
        for (String suit : suits) {
            for (String rank : ranks) {
                HashMap<String, String> card = new HashMap<>();
                card.put("suit", suit);
                card.put("rank", rank);
                cards.add(card);
            }
        }
    }

    private void shuffleCards() {
        Random rand = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int r = i + rand.nextInt(52 - i);
            HashMap<String, String> temp = cards.get(r);
            cards.set(r, cards.get(i));
            cards.set(i, temp);
        }
    }

    private void addCardToQueue(){
        for (int i = 0; i < cards.size(); i++) {        
            HashMap<String, String> temp = cards.get(i);
            String suit=temp.get("suit");
            String rank=temp.get("rank");
            INode card=new Card(suit,rank);
            queue.enqueue(card);
        }
        queue.displayQueue();
        
    }
    public void distributeCards() {
        int deckindex = 0;
        for (int i = 0; i < players.length; i++) {
        
            for (int j = 0; j < players[i].length; j++) {
                players[i][j] = cards.get(deckindex);
                deckindex++;
            }

        }
    }

    public void displayCards() {
        for (int i = 0; i < players.length; i++) {
            log.info("player is " + (i + 1));
            for (int j = 0; j < players[i].length; j++) {
                log.info("player " + (i + 1) + " has " + players[i][j].get("suit") + " of " + players[i][j].get("rank"));
            }
        }
    }

    public static void main(String[] args) {
        DeckOfCards deckOfCards = new DeckOfCards();
        System.out.println("Welcome to deck of cards program!");
        deckOfCards.makeCards();
        deckOfCards.shuffleCards();
        deckOfCards.addCardToQueue();
        deckOfCards.distributeCards();
        deckOfCards.displayCards();
    }

}
