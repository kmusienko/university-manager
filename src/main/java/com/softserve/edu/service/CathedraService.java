package com.softserve.edu.service;

import com.softserve.edu.model.Cathedra;

import java.util.List;

/**
 * Created by Kostya on 27.06.2017.
 */
public interface CathedraService {
    void addCathedra(Cathedra cathedra);
    void updateCathedra(Cathedra cathedra);
    Cathedra getCathedraById(int cathedraId);
    List<Cathedra> getAllCathedras();
    void deleteCathedra(Cathedra cathedra);
}
