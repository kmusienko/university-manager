package com.softserve.edu.service.impl;

import com.softserve.edu.dao.CathedraDao;
import com.softserve.edu.model.Cathedra;
import com.softserve.edu.service.CathedraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CathedraServiceImpl implements CathedraService {

    private CathedraDao cathedraDao;

    @Autowired
    public CathedraServiceImpl(CathedraDao cathedraDao) {
        this.cathedraDao = cathedraDao;
    }

    @Override
    public void addCathedra(Cathedra cathedra) {
        cathedraDao.addElement(cathedra);
    }

    @Override
    public void updateCathedra(Cathedra cathedra) {
        cathedraDao.updateElement(cathedra);
    }

    @Override
    public Cathedra getCathedraById(int cathedraId) {
        return cathedraDao.getElementById(cathedraId);
    }

    @Override
    public List<Cathedra> getAllCathedras() {
        return cathedraDao.getAllElements();
    }

    @Override
    public void deleteCathedra(Cathedra cathedra) {
        cathedraDao.deleteElement(cathedra);
    }
}
