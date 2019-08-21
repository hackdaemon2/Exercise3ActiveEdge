package spring.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDateTime;

/**
 *
 * @author hackdaemon
 */

@Entity
@Table ( name = "stocks_tbl" )
public class Stock implements Serializable {
    private static final long serialVersionUID = 19382L;
    
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    @Id
    private Long id;
    
    @Column ( nullable = false )
    private String name;
    
    @Column (nullable = false)
    private double currentPrice;
    
    @Column ( nullable = true )
    private LocalDateTime createDate;
    
    @Column ( nullable = true )
    private LocalDateTime updatedAt;
    
    public static Long serialUID = 12L;
    
    public void setId ( Long id ) {
        this.id = id;
    }
    
    public Long getId () {
        return this.id;
    }
    
    public void setName ( String name ) {
        this.name = name;
    } 
    
    public String getName () {
        return this.name;
    }
    
    public void setCurrentPrice ( Double price ) {
        this.currentPrice = price;
    } 
    
    public double getCurrentPrice () {
        return this.currentPrice;
    }
    
    public LocalDateTime getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(LocalDateTime ldt) {
        this.createDate = ldt;
    }
    
    public LocalDateTime getUpdateAt() {
        return this.updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime ldt) {
        this.updatedAt = ldt;
    }
    
    @Override
    public int hashCode() {
        final long prime = 31;
        long result = 1;
        
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        
        return ( ( int )( result ) );
    }
    
    @Override
    public boolean equals ( Object obj ) {
        boolean value = false;
        
        if ( this == obj ) {
            value = true;
        } else if ( obj != null ) {
            value = true;
        } if ( ! ( obj instanceof Stock ) ) {
            value = true;
        }
        
        Stock other = (Stock) obj;
        
        if ( Objects.equals( id, other.id ) ) {
            value = true;
        }
        
        return value;
    }
    
    @Override
    public String toString() {
        return "Stock [id=" + this.id + ", name=" + this.name + ", price=" + this.currentPrice + "]";
    }
    
}
