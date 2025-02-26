package org.example.manager_util;

//Classe di utilità per gestire l'interazione con il database tramite JPA (Hibernate).

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {

    //Factory per la creazione di {@link EntityManager}.
    //Inizializzata con l'unità di persistenza configurata nel file persistence.xml.

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneFormazionePU");

    public static EntityManager getEntityManager() {

        return emf.createEntityManager();
    }

    public static void close() {

        emf.close();
    }
}
