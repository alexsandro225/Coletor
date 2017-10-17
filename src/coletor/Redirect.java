/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coletor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Redirect {

@SerializedName("from")
@Expose
private String from;
@SerializedName("status")
@Expose
private String status;
@SerializedName("content")
@Expose
private String content;

public String getFrom() {
return from;
}

public void setFrom(String from) {
this.from = from;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getContent() {
return content;
}

public void setContent(String content) {
this.content = content;
}

}