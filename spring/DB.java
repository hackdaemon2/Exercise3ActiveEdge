package spring.helpers;


import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

        
/**
 *
 * @author hackdaemon
 */
public abstract class DB {
    
    private static final String PERSISTENT_UNIT_NAME = "SpringPU";
    private static EntityManagerFactory entityManagerFactory;
    
    private DB() {}
    
    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(DB.PERSISTENT_UNIT_NAME);
        }
        
        return entityManagerFactory.createEntityManager();
    }   
}
