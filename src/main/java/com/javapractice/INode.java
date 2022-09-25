package com.javapractice;

public interface INode<K> {
K getKey1 () ;
void setKey1 (K key) ;
K getKey2 () ;
void setKey2 (K key) ;
INode <K> getNext () ;
void setNext (INode<K> next) ;
}
