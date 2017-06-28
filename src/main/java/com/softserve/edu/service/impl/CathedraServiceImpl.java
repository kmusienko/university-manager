package com.softserve.edu.service.impl;

import com.softserve.edu.dao.DaoFactory;
import com.softserve.edu.model.Cathedra;
import com.softserve.edu.service.CathedraService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kostya on 27.06.2017.
 */
@Service
public class CathedraServiceImpl implements CathedraService{
    public void addCathedra(Cathedra cathedra) {
        DaoFactory.getInstance().getCathedraDao().addElement(cathedra);
    }

    public void updateCathedra(Cathedra cathedra) {
        DaoFactory.getInstance().getCathedraDao().updateElement(cathedra);
    }

    public Cathedra getCathedraById(int cathedraId) {
        return DaoFactory.getInstance().getCathedraDao().getElementById(cathedraId);
    }

    public List<Cathedra> getAllCathedras() {
        return DaoFactory.getInstance().getCathedraDao().getAllElements();
    }

    public void deleteCathedra(Cathedra cathedra) {
        DaoFactory.getInstance().getCathedraDao().deleteElement(cathedra);
    }
}
