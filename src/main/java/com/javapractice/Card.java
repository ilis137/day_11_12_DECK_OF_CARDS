package com.javapractice;

public class Card<K> implements INode<K>{
  K suit;
  K rank;
  INode next;
 
  public Card(K suit, K rank) {
    this.suit=suit;
    this.rank=rank;
    this.next=null;
  }

  @Override
  public INode getNext() {
    return next;
  }

  @Override
  public void setNext(INode node) {
    this.next=node;
  }
  @Override
  public K getKey1() {
   
    return suit;
  }
  @Override
  public void setKey1(K key) {
   
    this.suit=key;
  }
  
  @Override
  public K getKey2() {
  
    return rank;
  }
  @Override
  public void setKey2(K key) {
  
    this.rank=key;
  }

  
}
