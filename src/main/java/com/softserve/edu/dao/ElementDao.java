package com.softserve.edu.dao;

import java.util.List;

public interface ElementDao<E> {
    void addElement(E element0);
    void updateElement(E element);
    E getElementById(int elementId);
    List<E> getAllElements();
    void deleteElement(E element);
}
