package com.wizinno.lims.common.util;

import org.hibernate.Session;
import org.hibernate.jpa.HibernateEntityManager;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author LiuMei
 * @date 2017-11-22.
 */
@Service
public class HibernateUtil {

    private static HibernateEntityManager hEntityManager = null;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        HibernateUtil.hEntityManager = (HibernateEntityManager) entityManager;
    }

    public static Session getSession(){
        return HibernateUtil.hEntityManager.getSession();
    }

}
