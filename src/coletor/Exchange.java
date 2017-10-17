/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coletor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Exchange {

@SerializedName("query")
@Expose
private Query query;

public Query getQuery() {
return query;
}

public void setQuery(Query query) {
this.query = query;
}

}
