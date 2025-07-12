package org.example.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


/*
Create a custom class `ImmutableStringList` that wraps a List of Strings.

- Once the list is created, no addition or removal should be allowed.
- Methods allowed: `get(int index)`, `size()`, `iterator()`, `toString()`.

**Constraints:**

- Internally use an ArrayList but prevent external modification.
- Ensure defensive copying in constructor.
 */
public class ImmutableListImplementation {
}

final class ImmutableList {
    private final List<String> list;

    //ensures defensive copy
    public ImmutableList(List<String> list){
        this.list = Collections.unmodifiableList(list);
    }

    public String get(int index){
        return list.get(index);
    }

    public int size(){
        return list.size();
    }

    public Iterator<String> iterator(){
        return list.iterator();
    }
}