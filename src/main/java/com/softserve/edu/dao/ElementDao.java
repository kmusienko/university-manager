package com.softserve.edu.dao;

import java.util.List;

/**
 * Created by Kostya on 10.06.2017.
 */
public interface ElementDao<E> {
    E addElement(E element0);
    E updateElement(E element);
    E getElementById(int elementId);
    List<E> getAllElements();
    void deleteElement(E element);
}
