package com.javapractice;

public class Player<K> implements INode<K>{
 K name;
 K cardQueue;
 INode<K> next;
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
    return cardQueue;
  }

  @Override
  public void setKey2(K key) {
    this.cardQueue=cardQueue;
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
