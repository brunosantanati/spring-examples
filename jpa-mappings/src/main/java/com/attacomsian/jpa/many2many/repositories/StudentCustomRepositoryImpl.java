package com.attacomsian.jpa.many2many.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class StudentCustomRepositoryImpl implements StudentCustomRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void clear() {
        em.clear();
    }
}
