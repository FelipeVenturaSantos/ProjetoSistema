/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.SA;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import model.Produto;

/**
 *
 * @author felip
 */
public class Consumidora {
    
    
    public static String sendGet(String url) throws Exception{
    
        URL objeto = new URL(url);
        HttpURLConnection cone = (HttpURLConnection) objeto.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(cone.getInputStream()));
        String inputLine;
        StringBuffer resultado = new StringBuffer();
        while((inputLine = in.readLine()) != null){
        
            resultado.append(inputLine);
            
        }
        return resultado.toString();
    
    }
    
}
