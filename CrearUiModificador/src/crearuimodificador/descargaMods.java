/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crearuimodificador;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/**
 *
 * @author pacog
 */
public class descargaMods {
    /**
	 * Descarga un fichero jpeg y lo guarda en e:/foto.jpg
	 * 
	 * @param args
	 */
        

        public static void Descomprimir(String ficheroZip, String directorioSalida)
                throws Exception {
          final int TAM_BUFFER = 4096;
          byte[] buffer = new byte[TAM_BUFFER];

          ZipInputStream flujo = null;
          try {
            flujo = new ZipInputStream(new BufferedInputStream(
                    new FileInputStream(ficheroZip)));
            ZipEntry entrada;
            while ((entrada = flujo.getNextEntry()) != null) {
              String nombreSalida = directorioSalida + File.separator
                      + entrada.getName();
              if (entrada.isDirectory()) {
                File directorio = new File(nombreSalida);
                directorio.mkdir();
              } else {
                BufferedOutputStream salida = null;
                try {
                  int leido;
                  salida = new BufferedOutputStream(
                          new FileOutputStream(nombreSalida), TAM_BUFFER);
                  while ((leido = flujo.read(buffer, 0, TAM_BUFFER)) != -1) {
                    salida.write(buffer, 0, leido);
                  }
                } finally {
                  if (salida != null) {
                    salida.close();
                  }
                }
              }
            }
          } finally {
            if (flujo != null) {
              flujo.close();
            }

          }
        }
      
	public static void main(String[] args) throws Exception {
		try {
			// Url con la foto
			URL url = new URL(
					"http://parafurgonetacamper.com/Mods/brass.zip");

			// establecemos conexion
			URLConnection urlCon = url.openConnection();

			// Sacamos por pantalla el tipo de fichero
			System.out.println(urlCon.getContentType());

			// Se obtiene el inputStream de la foto web y se abre el fichero
			// local.
			InputStream is = urlCon.getInputStream();
			FileOutputStream fos = new FileOutputStream("d:/brass.zip");

			// Lectura de la foto de la web y escritura en fichero local
			byte[] array = new byte[1000]; // buffer temporal de lectura.
			int leido = is.read(array);
			while (leido > 0) {
				fos.write(array, 0, leido);
				leido = is.read(array);
			}

			// cierre de conexion y fichero.
			is.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
                Descomprimir("d:/brass.zip","d:");
	}
}
