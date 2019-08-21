package spring.services;

import java.util.List;
import spring.models.Stock;

public interface StockService {
    public List<Stock> all();
    public Stock get ( Long id );
    public void create ( Stock stock );
    public void update ( Long id, double price );
    public void delete ( Long id ); 
}
