import java.io.FileNotFoundException;
import java.io.FileReader;

public class LecturaFichero {

	public static void main(String[] args) {
		
		boolean letra=false, numero=false, error=false, numeral=false;
		int cerror = 0, cletra = 0, cnumero = 0, cnumeral = 0; 
		
		String nombreFichero = "datosPrueba.txt";     
        FileReader fr = null;
        try {
            fr = new FileReader(nombreFichero);
            int caract = fr.read();
            while(caract != -1) {
        
            	if ((caract >= 65 && caract <= 90) || (caract >=97 && caract <= 122)) {
            		if (error == true) {
            			System.out.println("error");
           	    		error = false; 
           	    		cerror++;
            		}
            		letra = true;
            	}
            	else if (caract >= 48 && caract <= 57 ) {
            		if (error == true) {
            			System.out.println("error");
           	    		error = false; 
           	    		cerror++;
            		}
            		numero=true;
            	}
            	else if (caract == 35) {
            		if (error == true) {
            			System.out.println("error");
           	    		error = false; 
           	    		cerror++;
            		}
            		if (numero == true) {
            			System.out.println("constante entera");
           	    		numero = false; 
           	    		cnumero ++;
            		}
            		if (letra == true) {
            			System.out.println("identificador");
           	    		letra = false;
           	    		cletra++;
            		}
            		
            		System.out.println("numeral");
            		cnumeral++;
            	}
            	else if ( caract != 32 && caract != 9 && caract != 10){
            		error=true;
            	}
            	
            		
            	switch(caract)
            	{
            	   
            	   case 32 :
            	   {
            		   if ((letra == true && numero == true)|| letra == true) {
            			   System.out.println("identificador");
            			   cletra++;
            		   }
            		   else if (letra == false && numero == true) {
            			   System.out.println("constante entera");
            			   cnumero ++;
            		   }
            		   
            		   numero = false;
            		   letra = false;
            	   }
            	      
            	      break; 
            	      
            	   case 10:
            	   {
            		   if ((letra == true && numero == true)|| letra == true) { 
            			   System.out.println("identificador");
            			   cletra++;
            		   }
            		   
            		   if (letra == false && numero == true) { 
            			   System.out.println("constante entera");
            			   cnumero ++;
            		   }
            		   
            		   if (error == true) {
               			System.out.println("error");
              	    		error = false;
              	    		cerror++;
               		}
            		   if (numeral == true) {
               			System.out.println("numeral");
              	    		numeral = false; 
              	    		cnumeral++;
               		}
            		   
            		   numero = false;
            		   letra = false;
            		   
            		   
            	   }
            	      
            	      break; 
            	  
            	   case 9:
            	   {
            		   if ((letra == true && numero == true)|| letra == true) { 
            			   System.out.println("identificador");
            			   cletra++;
            		   }
            		   
            		   if (letra == false && numero == true) { 
            			   System.out.println("constante entera");
            			   cnumero ++;
            		   }
            		   
            		   if (error == true) {
               			System.out.println("error");
              	    		error = false;
              	    		cerror++;
               		}
            		   if (numeral == true) {
               			System.out.println("numeral");
              	    		numeral = false;
              	    		cnumeral++;
               		}
            		   
            		   numero = false;
            		   letra = false;
            		   
            	   }
            	      
            	      break; 
            	}	
            			
                caract = fr.read();
            }
            System.out.println("-----------------");
            System.out.println("Totales: Identificadores: " + cletra + ", Constantes enteras: " + cnumero + ", Numerales: " + cnumeral + ", errores: " + cerror);
        }
        catch (FileNotFoundException e) {
            
            System.out.println("Error: Fichero no encontrado");
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Error de lectura del fichero");
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if(fr != null)
                    fr.close();
            }
            catch (Exception e) {
                System.out.println("Error al cerrar el fichero");
                System.out.println(e.getMessage());
            }
        }	
	}

}
