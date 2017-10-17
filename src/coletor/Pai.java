/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coletor;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pai implements Comparable<Pai> {

@SerializedName("currencies")
@Expose
private List<Currency> currencies = null;
@SerializedName("name")
@Expose
private String name;
@SerializedName("population")
@Expose
private Integer population;

private String valorReal;

public List<Currency> getCurrencies() {
return currencies;
}

public void setCurrencies(List<Currency> currencies) {
this.currencies = currencies;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Integer getPopulation() {
return population;
}

public void setPopulation(Integer population) {
this.population = population;
}

    public String getValorReal() {
        return valorReal;
    }

    public void setValorReal(String valorReal) {
        this.valorReal = valorReal;
    }

    public int compareTo(Pai outroP) {
        if (this.population > outroP.population) {
            return -1;
        }
        if (this.population < outroP.population) {
            return 1;
        }
        return 0;    
    }
    
}