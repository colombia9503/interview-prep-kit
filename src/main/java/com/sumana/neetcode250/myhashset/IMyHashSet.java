package com.sumana.neetcode250.myhashset;

public interface IMyHashSet<T> {
    void add(T key);
    void remove(T key);
    boolean contains(T key);
}
