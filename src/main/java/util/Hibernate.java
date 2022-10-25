package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Hibernate {

    private static EntityManager ENTITY_MANAGER;

    private Hibernate() {
    }

    public static EntityManager getEntityManager() {
        if (ENTITY_MANAGER == null) {
            ENTITY_MANAGER = Persistence.createEntityManagerFactory("twitter").createEntityManager();
        }
        return ENTITY_MANAGER;
    }
}