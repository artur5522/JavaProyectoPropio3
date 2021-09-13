

package com.rodrigueza.Entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Elpo
 */

@Entity
@Table(name = "computadora")
public class Computadora implements Serializable{
    
    private static final long serialVersionUID = 1L;
     
    private String codigo;
    
    private String marca;
    
    private String modelo;  
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private BigInteger id;
     
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComputadora")
    private List<Componente> componentes;   

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }
     
    public void agregaComponentes(Componente c){
        if(componentes==null) componentes= new ArrayList();
        componentes.add(c);           
        
        c.setIdComputadora(this);
    }
    
    public BigInteger getId() {
        return id;
    }
    

    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}
