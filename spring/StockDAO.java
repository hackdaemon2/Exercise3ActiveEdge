
package spring.dao;

import spring.models.Stock;
import java.util.List;

public interface StockDAO {
    public List<Stock> all();
    public Stock get ( Long id );
    public void create ( Stock user );
    public void update ( Long id, double price );
    public void delete ( Long id );
}
