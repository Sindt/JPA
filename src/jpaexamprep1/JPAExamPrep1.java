/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaexamprep1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Sindt
 */
public class JPAExamPrep1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAExamPrep1PU");
        EntityManager em = emf.createEntityManager();
        Project p1 = new Project();
        Project p2 = new Project();
        p1.setName("Test");
        
        
        p2.setName("Java");

        Projectuser pu1 = new Projectuser();
        Projectuser pu2 = new Projectuser();
        pu1.setUsername("Bob");
        pu2.setUsername("Alex");

        Task t1 = new Task();
        Task t2 = new Task();
        t2.setName("JavaTask");
        t1.setName("TestTask");
        
        //Test
        t2.setProjectId(p1.getProjectId());
        t2.setProjectId(p2.getProjectId());

  
        em.getTransaction().begin();
        em.merge(p1);
        em.merge(p2);
        em.merge(pu1);
        em.merge(pu2);
        em.merge(t1);
        em.merge(t2);
//        em.persist(p1);
//        em.persist(p2);
//        em.persist(pu2);
//        em.persist(pu1);
        em.getTransaction().commit();

//        Query q = em.createNamedQuery("Project.findByProjectId");
//        q.setParameter("projectId", 1);
//        Project project = (Project) q.getSingleResult();
//        Project p = em.find(Project.class, 1L);
//
        em.close();
//        System.out.println("P Name :" + project.getName());
//        System.out.println("Project user = " + p.getUserList().get(0).getUsername() + ", Project name = " + p.getName());
    }

}
