/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coletor;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {

@SerializedName("rate")
@Expose
private List<Rate> rate = null;

public List<Rate> getRate() {
return rate;
}

public void setRate(List<Rate> rate) {
this.rate = rate;
}

}
