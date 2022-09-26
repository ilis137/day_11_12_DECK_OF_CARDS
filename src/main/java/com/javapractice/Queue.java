package com.javapractice;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Queue<T> {
  private static final Logger log = LogManager.getLogger(DeckOfCards.class);
  private INode front, rear;
  private int currentSize; // number of items
//check if queue is empty
  public boolean isEmpty() {
    return (currentSize == 0);
  }
//initialize the queue
  public Queue() {
    front = null;
    rear = null;
    currentSize = 0;
  }

  // Add card or player to the end of the queue.
  public void enqueue(INode newNode) {
    INode temp = newNode;
    temp.setNext(null);
    if (isEmpty()) {//if queue is empty then front and rear becomes new node
      this.front = temp;
      this.rear = temp;
    } else {//if queue has elements than add new element to the rear,and change rear to next new node;
      this.rear.setNext(temp);
      this.rear = temp;
    }
    currentSize++;
  }
//dequeue the card or player
  public INode dequeue() {
    INode temp = this.front;
    if (isEmpty()) {
      rear = null;
      return null;
    }
    //move the front to xt node and set the old front next to null to remove it
    front = temp.getNext();
    currentSize--;
   
    temp.setNext(null);
    return temp;
  }

  //sort card by rank using bubblesort
  public void sortCardQueueByRank() {
    String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

    INode current = this.front, forward = null;
    if (isEmpty()) {
      return;
    }
    while (current != null) {//choose a node sequentially and check if further nodes have rank less than current node rank
      forward = current.getNext();

      while (forward != null) {
        //get ranks of current node and forward node
        //compare ranks index of ranks array rather than rank itself
        int currentRank = Arrays.asList(ranks).indexOf(current.getKey2());
        int forwardRank = Arrays.asList(ranks).indexOf(forward.getKey2());

        if (currentRank > forwardRank) {
          String rank, suit;//swap nodes if forward rank is less
          suit = (String) current.getKey1();
          rank = (String) current.getKey2();
          current.setKey1(forward.getKey1());
          current.setKey2(forward.getKey2());
          forward.setKey1(suit);
          forward.setKey2(rank);
        }
        forward = forward.getNext();//proceed to next forward node
      }
      current = current.getNext();
    }
  }


}
