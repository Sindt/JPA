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

        Facade f = new Facade(emf);
        f.createUser("Bob", "bo@hotmail.com");
        Projectuser pu = f.createUser("Jens", "Jens@mail.dk");
        System.out.println("Find user metode = " + f.findUser(1L).getUsername());
        
        for (Projectuser user : f.getAllUsers()) {
            System.out.println("getAllUser metode = " + user.getUsername() + " - " + user.getEmail());
        }
        

    }

}
