package org.example.core.questions;


import java.util.*;

/*
LRU cache
put -> adds new key value pair, if cache is full, remove least recently used.
get -> returns, if not present returns -1
 */
public class LRUCache {

    public static void main(String[] args) {
        LRU cache = new LRU(2);
        cache.put(1, 10);
        cache.put(2, 10);
        System.out.println(cache.get(1));
        cache.put(3, 30);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }

}

class LRU extends LinkedHashMap<Integer, Integer>{
   private final int capacity;

   public LRU(int capacity){
       super(capacity, 0.75f, true);
       this.capacity = capacity;
   }

   public int get(int key){
       return super.getOrDefault(key, -1);
   }

   public void put(int key, int value){
        super.put(key, value);
   }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
