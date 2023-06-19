
package programacion1.Videojuego;


public class Heroes {
 
     int [][] Posicion_Heroes;
 public Heroes(){
     
    Posicion_Heroes=new int[4][10];  
       int contheroes=1;
  //este for de aqui llena la matriz de numeros del 1 al 40
       for (int i = 0; i < Posicion_Heroes.length; i++) {

            for (int j = 0; j < Posicion_Heroes[0].length; j++) {
                Posicion_Heroes[i][j] = contheroes;
               contheroes++; 
            }
        }
    
      for (int i = 0; i < Posicion_Heroes.length; i++) {

            for (int j = 0; j < Posicion_Heroes[0].length; j++) {
                System.out.print(""+Posicion_Heroes[i][j]);
               
            }
          System.out.println("");  
        } 
     
     
 }   

    public int[][] getPosicion_Heroes() {
        return Posicion_Heroes;
    }
    
    
    
    
    
    
}
