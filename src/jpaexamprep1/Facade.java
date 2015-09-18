/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaexamprep1;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Sindt
 */
public class Facade {

    EntityManagerFactory emf;

    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Projectuser createUser(String userName, String email) {
        EntityManager em = getEntityManager();
        Projectuser user;

        try {
            user = new Projectuser();
            user.setUsername(userName);
            user.setEmail(email);

            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        return user;

    }

    public Projectuser findUser(Long projectUserID) {
        EntityManager em = getEntityManager();
        Projectuser user;

        try {
            user = new Projectuser();
            user = em.find(Projectuser.class, projectUserID);
        } finally {
            em.close();
        }
        return user;

    }

    public List<Projectuser> getAllUsers() {
        EntityManager em = getEntityManager();
        List<Projectuser> userList;
        try {
            userList = new ArrayList();
            Query q = em.createNamedQuery("Projectuser.findAll");
            userList = q.getResultList();
        } finally {
            em.close();
        }
        return userList;

    }

}
