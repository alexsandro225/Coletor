/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coletor;
import com.google.gson.Gson;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
/**
 *
 * @author Alexsandro Oliveira
 */
public class Coletor  {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        // TODO code application logic here
    Gson gson = new Gson();
    URL url = new URL("http://restcountries.eu/rest/v2/region/europe?fields=currencies;population;name");
    InputStream is = json(url);
    StringBuilder sb = lerJson(is);
    
    Pai[] p; 
    p = gson.fromJson(sb.toString(), Pai[].class);
    List<Document> documents = new ArrayList<Document>();
    List<Currency> lista = new ArrayList<Currency>();
    Arrays.sort(p);
    
        for (int i = 0; i < 10; i++) {
            lista = p[i].getCurrencies();

            Document moeda = new Document("code",lista.get(0).getCode())
                    .append("name",lista.get(0).getName())
                    .append("symbol",lista.get(0).getSymbol());
            
            String var1 = lista.get(0).getCode();
            
            Gson g = new Gson();
            URL newUrl = new URL("http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22"+var1+"%22%2C%20%22BRL%22)&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback="/*fullUrlStr*/);
            InputStream newis = json(newUrl);
            StringBuilder newsb = lerJson(newis);
            Exchange exc = g.fromJson(newsb.toString(), Exchange.class);
            
            Document doc1 = new Document("name",p[i].getName())
             .append("population",p[i].getPopulation())
                    .append("currencies",moeda)
                    .append("valorReal", exc.getQuery().getResults().getRate().get(1).getRate());    
                    
            documents.add(doc1); 
            
            
            System.out.println("País: " + p[i].getName() + " População: " 
                    + p[i].getPopulation() + " Valor em reais: " 
                    + exc.getQuery().getResults().getRate().get(1).getRate());
        }

        
        MongoClient mongo = new MongoClient();
        MongoDatabase database = mongo.getDatabase("paises");
        MongoCollection<Document> collection = database.getCollection("pais");
        collection.insertMany(documents);
        
       
       /*Block<Document> printBlock = new Block<Document>() {
       @Override
       public void apply(final Document document) {
           System.out.println(document);
       }
       };
        
       collection.find().forEach(printBlock);
       */
    }
    
    
    public static StringBuilder lerJson (InputStream is){
            BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    	while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
        return sb;        
    }
    
    public static InputStream json(URL url)throws MalformedURLException, IOException{
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream iso = connection.getInputStream();
        
        return iso;
    }
}