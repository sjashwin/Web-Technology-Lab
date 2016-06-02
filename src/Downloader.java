/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL ;
import java.net.URLConnection ;
/**
 *
 * @author Ashwin
 */
public class Downloader {
    static URL url ;
    static URLConnection connection ;
    static BufferedReader reader ;
    static StringBuilder data ;
    static String temp ;
    Downloader(){
        reader = new BufferedReader(new InputStreamReader(System.in)) ;
        data = new StringBuilder() ;
    }
    public static void main(String args[]) {
        while(true){
            try{
                Downloader downloader = new Downloader();
                url = new URL(reader.readLine()) ;
                reader.close() ;
                connection = url.openConnection() ;
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream())) ;
                while((temp = reader.readLine())!= null)
                    data.append(temp) ;
                reader.close() ; 
                System.out.println("Content-Type : "+connection.getContentType()) ;
                System.out.println("Date : "+connection.getDate()) ;
                System.out.println("Expiration Data : "+connection.getExpiration());
                break ;
            }catch(IOException error){
            System.err.println(error.getMessage()) ;
            }
        }
    }
}
