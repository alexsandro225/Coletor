/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coletor;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Diagnostics {

@SerializedName("redirect")
@Expose
private List<Redirect> redirect = null;
@SerializedName("url")
@Expose
private List<Url> url = null;
@SerializedName("publiclyCallable")
@Expose
private String publiclyCallable;
@SerializedName("query")
@Expose
private List<Query_> query = null;
@SerializedName("javascript")
@Expose
private List<Javascript> javascript = null;
@SerializedName("user-time")
@Expose
private String userTime;
@SerializedName("service-time")
@Expose
private String serviceTime;
@SerializedName("build-version")
@Expose
private String buildVersion;

public List<Redirect> getRedirect() {
return redirect;
}

public void setRedirect(List<Redirect> redirect) {
this.redirect = redirect;
}

public List<Url> getUrl() {
return url;
}

public void setUrl(List<Url> url) {
this.url = url;
}

public String getPubliclyCallable() {
return publiclyCallable;
}

public void setPubliclyCallable(String publiclyCallable) {
this.publiclyCallable = publiclyCallable;
}

public List<Query_> getQuery() {
return query;
}

public void setQuery(List<Query_> query) {
this.query = query;
}

public List<Javascript> getJavascript() {
return javascript;
}

public void setJavascript(List<Javascript> javascript) {
this.javascript = javascript;
}

public String getUserTime() {
return userTime;
}

public void setUserTime(String userTime) {
this.userTime = userTime;
}

public String getServiceTime() {
return serviceTime;
}

public void setServiceTime(String serviceTime) {
this.serviceTime = serviceTime;
}

public String getBuildVersion() {
return buildVersion;
}

public void setBuildVersion(String buildVersion) {
this.buildVersion = buildVersion;
}

}
