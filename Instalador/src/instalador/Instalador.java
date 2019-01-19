/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instalador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 *
 * @author Paco G
 */
public class Instalador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        try {
		File fileDir = new File("C:/Users/Paco G/Documents/GitHub/java/7d2dmod/ModTutorial/Textos/new.txt");
			
		BufferedReader in = new BufferedReader(
		   new InputStreamReader(
                      new FileInputStream(fileDir), "UTF-8"));
		        
		String str;
		 Writer bw= null;     
		while ((str = in.readLine()) != null) {
		    
                    FileOutputStream fw = null;

                    try {
                        String data = str;
                        File file = new File("C:/Users/Paco G/Documents/GitHub/java/7d2dmod/ModTutorial/Textos/Localization.txt");
                        // Si el archivo no existe, se crea!
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        // flag true, indica adjuntar información al archivo.
                        
                        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
                        bw.append(data).append("\n");
                        System.out.println("información agregada!");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                                        //Cierra instancias de FileWriter y BufferedWriter
                            if (bw != null)
                                bw.close();
                            if (fw != null)
                                fw.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                                }

                                in.close();
	    } 
	    catch (UnsupportedEncodingException e) 
	    {
			System.out.println(e.getMessage());
	    } 
	    catch (IOException e) 
	    {
			System.out.println(e.getMessage());
	    }
	    catch (Exception e)
	    {
			System.out.println(e.getMessage());
	    }
        
        
                    
        }  
    }
    

