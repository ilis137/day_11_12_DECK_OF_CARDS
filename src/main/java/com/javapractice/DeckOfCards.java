package com.javapractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeckOfCards {
    private ArrayList<HashMap<String, String>> cards = new ArrayList<>();
    private String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
    private String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
    private Queue<Card> cardQueue = new Queue<Card>();
    private Queue<Player> playerQueue = new Queue<Player>();
    int noOfPlayers = 4;
    int cardsToDistribute = 9;

    private static final Logger log = LogManager.getLogger(DeckOfCards.class);

    public DeckOfCards() {

    }
    //make cards from suits and rank
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
    //print all the cards in cards array
    private void printCards() {
        log.info("cards in the deck are: ");
        for (HashMap<String, String> card : cards) {
            log.info(card.get("suit") + " of " + card.get("rank"));
        }
    }
    //create players and initialize deck
    private void createPlayers() {
        Scanner sc = new Scanner(System.in);
        String name;
        for (int i = 0; i < noOfPlayers; i++) {
            log.info("Enter the name of player " + (i + 1));
            name = sc.nextLine();//take player names from user
            Player player = new Player(name, new Queue());
            playerQueue.enqueue(player);
        }
    }

    //shuffle cards
    public void shuffleCards() {
        Random rand = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int r = i + rand.nextInt(52 - i);//get a random index in the random part of the array
            HashMap<String, String> temp = cards.get(r);
            //shuffle cards in the remaining part of deck
            cards.set(r, cards.get(i));
            cards.set(i, temp);
        }
    
    }
    

    //add shuffled cards to queue
    private void addCardToQueue() {
        for (int i = 0; i < cards.size(); i++) {

            HashMap<String, String> temp = cards.get(i);//retreving the card from the array
            String suit = temp.get("suit");
            String rank = temp.get("rank");
            INode card = new Card(suit, rank);//create a card with suit and rank;
            cardQueue.enqueue(card);//purt card into the queue
        }
    }


    //distribute cards to players and add cards to their decks
    public void distributeCards() {
        INode player, card;
        int count = 0;

        log.info("distributing cards: ");
        while (count < noOfPlayers) {
            player = playerQueue.dequeue();//deque player from queue to retreive its information
            Queue playerCards = (Queue) player.getKey2();//get the player's  cards queue
            //push nine cards to each player cards queue
            for (int j = 0; j < cardsToDistribute; j++) {
                card = cardQueue.dequeue();
                playerCards.enqueue(card);
            }
            //sort cards queue
            ((Queue) player.getKey2()).sortCardQueueByRank();
            playerQueue.enqueue(player);//re-enter player to player queue
            count++;
        }
    }
    //display the cards assigned to players
    public void display() {
        int count1 = 0;
      
        //iterate over player queue and print player and cards they have
        while (count1 < noOfPlayers) {//use of noOfPlayers as their reference
            int count2 = 0;
            INode player = playerQueue.dequeue();
            String name = (String) player.getKey1();
            log.info("player is " + name);
            Queue deckOfCards = (Queue) player.getKey2();
           
            while(count2<cardsToDistribute){
                INode card=deckOfCards.dequeue();
                log.info("player " + name + " has " + card.getKey2() + " of " + card.getKey1());
                deckOfCards.enqueue(card);
                count2++;
            }
            playerQueue.enqueue(player);
            count1++;
        }
    }

    public static void main(String[] args) {
        DeckOfCards deckOfCards = new DeckOfCards();
        System.out.println("Welcome to deck of cards program!");
        deckOfCards.createPlayers();
        deckOfCards.makeCards();
        deckOfCards.printCards();
        deckOfCards.shuffleCards();
        deckOfCards.addCardToQueue();
        deckOfCards.distributeCards();
        deckOfCards.display();
    }

}
