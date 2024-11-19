package com.labs.java.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ManageGenericCollectionsWithWildCards<E> {

    private Collection<E> items = new ArrayList<>();

    // lower bounded wildcard
    public Collection<?> addItemsToCollection(Collection<? super E> items) {

        Collection<E> items1 = new ArrayList<>();
        items1.add((E) "Node JS");
        items1.add((E) "PHP");
        //items1.add(("C#");
        items.addAll(items1);
        return items;
    }

    public Collection getItemsInCollection() {
        return items;
    }

    //upper bounded wildcard
    public void printItemsInCollection(Collection<? extends E> items) {
        for (Object item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        ManageGenericCollectionsWithWildCards<String> obj = new ManageGenericCollectionsWithWildCards<>();
        List items = new ArrayList();
        items.add("Java");
        items.add("Python");
        Collection items1 = obj.addItemsToCollection(items);
        obj.printItemsInCollection(items);
        System.out.println("Manage Generic Collections with Wild Cards");
    }
}
