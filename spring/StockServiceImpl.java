package spring.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.StockDAO;
import spring.models.Stock;

@Service("stockService")
@Transactional
public class StockServiceImpl implements StockService {
    @Autowired
    private StockDAO stockDAO;

    @Override
    public List<Stock> all() {
        return stockDAO.all();
    }

    @Override
    public Stock get ( Long id ) {
     return stockDAO.get( id );  
    }

    @Override
    public void create ( Stock stock ) {
       stockDAO.create( stock );
    }

    @Override
    public void update ( Long id, double price ) {
        Stock localStock = stockDAO.get( id );
        
        if ( localStock != null ) {
            localStock.setCurrentPrice( price );
        }
    }

    @Override
    public void delete ( Long id ) {
        stockDAO.delete( id );
    }
}
