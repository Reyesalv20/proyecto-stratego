
package programacion1.Videojuego;


public class Villanos {
    
   int [][] Posicion_Villano; 
    
  //constructor
    public Villanos(){
       Posicion_Villano=new int[4][10];  
       int contvillanos=-1;
      //este for de aqui llena la matriz de numeros del -1 al -40
       for (int i = 0; i < Posicion_Villano.length; i++) {

            for (int j = 0; j < Posicion_Villano[0].length; j++) {
                Posicion_Villano[i][j] = contvillanos;
               contvillanos--; 
            }
        }
    
      for (int i = 0; i < Posicion_Villano.length; i++) {

            for (int j = 0; j < Posicion_Villano[0].length; j++) {
                System.out.print(""+Posicion_Villano[i][j]);
               
            }
          System.out.println("");  
        }
       
    }

    public int[][] getPosicion_Villano() {
        return Posicion_Villano;
    }
    
    
       
    }
    
  
    
    
    
    
    

