
package programacion1.Videojuego;

public class Usuario {
String Glob_nombre,Glob_contra;
int puntos=0,partidavillanos=0,partidaheroes=0;         
              
 //constructor                          
 public Usuario(String nombre,String contra){
     

  Glob_nombre=nombre;   
    
  Glob_contra=contra;   
     
 }   

public String getcontra(){
    
return this.Glob_contra;
    
    
    
}    
public void setcontra(String contra){
    

    
    this.Glob_contra=contra;
    
}  
 
 
 


public void setnombre(String nameingre){
    
    
  this.Glob_nombre=nameingre; 
    
    
}    

public String getnombre(){
    
    
    
return this.Glob_nombre;    
    
}    

public void setpuntos(int puntos){
    
 this.puntos=puntos;   
    
} 
public int getpuntos(){
    
  return this.puntos;  
    
    
}
public void setpartidavillanos(int partidavillanos){
    
 this.partidavillanos=partidavillanos;   
    
} 
public int getpartidavillanos(){
    
  return this.partidavillanos;  
    
}
public void setpartidaheroes(int partidaheroes){
    
 this.partidaheroes=partidaheroes;   
    
} 
public int getpartidaheroes(){
    
  return this.partidaheroes;  
    
}






      
}
