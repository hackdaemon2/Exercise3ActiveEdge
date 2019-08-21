package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.models.Stock;
import spring.services.StockService;

import java.util.List;
import org.springframework.stereotype.Controller;
        
@Controller
@RequestMapping("/api")
public class StockController {
    @Autowired
    StockService service;
    
    @RequestMapping( value="/stocks", method = RequestMethod.GET )
    @ResponseBody
    public List<Stock> all(){
        return service.all();
    }
    
    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    @ResponseBody
    public Stock get( @PathVariable( "id" ) Long id ){
        return service.get( id );
    }  
}
   
