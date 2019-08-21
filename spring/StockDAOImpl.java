package spring.dao;

import spring.models.Stock;
import spring.helpers.DB;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

public class StockDAOImpl implements StockDAO {
    private static EntityManager entityManager;
    private static Query query;
    private static List<Stock> stockList;
    private static Stock stock;
    
    @Override
    public List<Stock> all() {
        try {
            
            entityManager = DB.getEntityManager();

            if (entityManager != null) {
                
                // check if username exists
                query = entityManager.createNamedQuery("Stock.findAll");
                                
                stockList = query.getResultList();
                
                if (stockList != null && ! stockList.isEmpty()) { // categories exists
                    return stockList;
                }
            }
        
        } catch (EntityNotFoundException | NullPointerException | IllegalArgumentException exception) {
            Logger.getLogger(StockDAOImpl.class.getName()).log(Level.SEVERE, null, exception);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        } 
        
        return null;
    }

    @Override
    public Stock get(Long id) {
        Stock stockData;
        
        try {
            
            entityManager = DB.getEntityManager();

            if (entityManager != null) {

                stockData = entityManager.find(Stock.class, id);
                
                if (stockData != null) { // user is found
                    return stockData;
                }
            }
        
        } catch (EntityNotFoundException | NullPointerException | IllegalArgumentException exception) {
            Logger.getLogger(StockDAOImpl.class.getName()).log(Level.SEVERE, null, exception);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        } 
        
        return null;
    }

    @Override
    public void create(Stock stockBean) {
        try {
            
            entityManager = DB.getEntityManager();

            if (entityManager != null) {
                entityManager.getTransaction().begin();  
                
                stock = new Stock();
                
                stock.setName(stockBean.getName());
                stock.setCurrentPrice(stockBean.getCurrentPrice());
                
                entityManager.persist(stock);
                entityManager.getTransaction().commit();                                     
            }
        
        } catch (EntityNotFoundException | NullPointerException | IllegalArgumentException exception) {
            Logger.getLogger(StockDAOImpl.class.getName()).log(Level.SEVERE, null, exception);         
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }          
    }

    @Override
    public void update(Long id, double price) {
        // todo
    }

    @Override
    public void delete(Long id) {
       Stock stockData;
        
        try {
            
            entityManager = DB.getEntityManager();

            if (entityManager != null) {
                entityManager.getTransaction().begin(); 
                
                stockData = entityManager.find(Stock.class, id);
                
                if (stockData != null) { // user is found
                    entityManager.remove(stockData);
                }
                
                entityManager.getTransaction().commit();
            }
        
        } catch (EntityNotFoundException | NullPointerException | IllegalArgumentException exception) {
            Logger.getLogger(StockDAOImpl.class.getName()).log(Level.SEVERE, null, exception);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        } 
    }
    
}
