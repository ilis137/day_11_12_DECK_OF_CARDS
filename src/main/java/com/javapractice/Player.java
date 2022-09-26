package com.javapractice;

public class Player<K> implements INode<K>{
 K name;
 K deckOfCards;
 INode<K> next;


 public Player(K name, K cardQueue) {
  this.name=name;
  this.deckOfCards=cardQueue;
  this.next=null;
}
  @Override
  public K getKey1() {
    return this.name;
  }

  @Override
  public void setKey1(K key) {
    this.name=name;

  }

  @Override
  public K getKey2() {
    return deckOfCards;
  }

  @Override
  public void setKey2(K key) {
    this.deckOfCards=key;
  }

  @Override
  public INode<K> getNext() {
    return this.next;
  }

  @Override
  public void setNext(INode<K> next) {
    this.next=next;
  }
  
}
