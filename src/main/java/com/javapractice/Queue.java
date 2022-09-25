package com.javapractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Queue {
  private static final Logger log = LogManager.getLogger(DeckOfCards.class);
  private INode front, rear;
  private int currentSize; // number of items

  public boolean isEmpty() {
    return (currentSize == 0);
  }

  public Queue() {
    front = null;
    rear = null;
    currentSize = 0;
  }

  // Add data to the end of the list.
  public void enqueue(INode newNode) {
    INode temp=newNode;
    System.out.println(temp);
    if (isEmpty()) {
      front = temp;
      rear=temp;
    } else {
      rear.setNext(temp);
      rear = temp;
    }
    currentSize++;
  log.info("new "+newNode.getClass().toString()+"added to queue");
  }

  public void displayQueue(){
    INode temp=front;

    while(temp.getNext()!=null){
      System.out.println(temp.getKey1()+ " " +temp.getKey2());
      temp=temp.getNext();
    }
  }
}
