package programacion1.Videojuego;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class TableroPrincip {

    boolean turno = true, ganadorheroes = false, ganadorvillanos = false;

    Dimension CoordPersonjSelect = null;
    int[][] Guia_Tablero;
    int[] VencidosVillano;
    int[] VencidosHeroe;
    //constructor
    //de esta clase solo vamos a estar resiviendo 
    Random r = new Random();

    public TableroPrincip() {
        //aqui estamos estamos no mas llenando la matriz de 0
        Guia_Tablero = new int[10][10];
        VencidosVillano = new int[40];
        VencidosHeroe = new int[40];

        for (int i = 0; i < VencidosVillano.length; i++) {

            VencidosVillano[i] = 0;

        }

        for (int i = 0; i < VencidosHeroe.length; i++) {

            VencidosHeroe[i] = 0;

        }

        for (int i = 0; i < Guia_Tablero.length; i++) {

            for (int j = 0; j < Guia_Tablero[0].length; j++) {
                //i es altura y j es anchura
                //asignado donde no se puede llegar en la matriz
                //zona prohibida
                if (i > 3 && j > 1 && i < 6 && j < 4) {
                    Guia_Tablero[i][j] = 41;
//este else if es para el otro cuadro
                } else if (i > 3 && j > 5 && i < 6 && j < 8) {

                    Guia_Tablero[i][j] = 41;

                } else {
//aqui se llena el tablero de cartas blancas
                    Guia_Tablero[i][j] = 0;

                }
                System.out.print("" + Guia_Tablero[i][j]);
            }
            System.out.println("");
        }

        int max = 8, min = 1, NumeroRandom;
        NumeroRandom = r.nextInt((max - min) + 1) + min;
        Guia_Tablero[9][NumeroRandom - 1] = 35;
        //el 11 es la tierra
        Guia_Tablero[9][NumeroRandom] = 11;
        Guia_Tablero[9][NumeroRandom + 1] = 36;
        Guia_Tablero[8][NumeroRandom] = 37;

        NumeroRandom = r.nextInt((max - min) + 1) + min;

        Guia_Tablero[0][NumeroRandom] = -10;

        Guia_Tablero[0][NumeroRandom + 1] = -38;
        Guia_Tablero[0][NumeroRandom - 1] = -36;
        Guia_Tablero[1][NumeroRandom] = -37;

        for (int i = 0; i < 6; i++) {

            while (Guia_Tablero[0][NumeroRandom] != 0) {
                NumeroRandom = r.nextInt((max - min) + 1) + min;
            }
            while (Guia_Tablero[1][NumeroRandom] != 0) {
                NumeroRandom = r.nextInt((max - min) + 1) + min;
            }

            if (i < 3) {

                NumeroRandom = r.nextInt((max - min) + 1) + min;

                if (i > 1) {
                    Guia_Tablero[9][NumeroRandom] = 38;

                } else if (i == 1) {
                    Guia_Tablero[8][NumeroRandom] = 39;

                } else {

                    Guia_Tablero[8][NumeroRandom] = 40;

                }

            } else {
//aqui busca que el numero random(columna) que genere no tenga nada en esa posicion
                NumeroRandom = r.nextInt((max - min) + 1) + min;
                while (Guia_Tablero[0][NumeroRandom] != 0) {
                    NumeroRandom = r.nextInt((max - min) + 1) + min;
                }
                while (Guia_Tablero[1][NumeroRandom] != 0) {
                    NumeroRandom = r.nextInt((max - min) + 1) + min;
                }

                if (i > 1) {
                    Guia_Tablero[0][NumeroRandom] = -30;

                } else if (i == 1) {
                    Guia_Tablero[1][NumeroRandom] = -39;

                } else {

                    Guia_Tablero[1][NumeroRandom] = -25;

                }

            }
        }

        for (int i = 0; i < 8; i++) {
            NumeroRandom = r.nextInt((max - min) + 1) + min;
            while (Guia_Tablero[2][NumeroRandom] != 0) {
                Guia_Tablero[8][NumeroRandom] = 41;
            }

        }
        //este array es para guardar todas las imagenes de rango 2 de los heroes
        int contpersonajes = 1, contvillanos = 1;
        int[] Rango2_Heroes = new int[]{12, 9, 31, 24, 17, 29, 23, 8};
        int[] Rango2_Villanos = new int[]{-11, -31, -33, -40, -20, -16, -35, -29};
        int[] CartasHeroes = new int[]{22, 25, 20, 2, 4, 34, 21, 30, 19, 28, 7, 15, 18, 6, 16, 33, 26, 32, 3, 13, 27, 5, 14, 10, 1, 12, 9, 31, 24, 17, 29, 23, 8, 1, 2};
        int[] CartasVillanos = new int[]{-18, -8, -2, -34, -13, -5, -23, -24, -26, -22, -9, -21, -7, -28, -1, -3, -32, -17, -14, -6, -27, -19, -11, -31, -33, -29, -20, -16, -35, -4, -12, -15, -40, -1};

        int[] Heroes = new int[]{11, 35, 35, 35, 35, 35, 35, 12, 9, 31, 24, 17, 29, 23, 8,
            22, 25, 20, 2, 4, 34, 21, 30, 19, 28, 7, 15, 18, 6, 16, 33, 26, 32, 3, 13, 27, 5, 14, 10, 1, 12, 9, 31, 24, 17, 29, 23, 8, 1, 2};
        int[] Villanos = new int[]{-10, -36, -36, -36, -36, -36, -36, -31, -33, -40, -20, -16, -35, -29,
            -18, -8, -2, -34, -13, -5, -23, -24, -26, -22, -9, -21, -7, -28, -1, -3, -32, -17, -14, -6, -27, -19, -11, -31, -33, -29, -20, -16, -35, -4, -12, -15, -40, -1};
        ArrayList<Integer> RandomsUsados_Heroe = new ArrayList<Integer>();
        Random RA = new Random();

        int Contador = 0; // 0 Plantea
        // 1 a 6 bombas
        // 7 a 15 Rango 2
        // demas cualquier rango
        do {
            int RandomGenerado = 0;
            do {

                if (Contador == 0) {
                    RandomGenerado = RA.nextInt(39 - 32) + 32;
                } else if (Contador >= 4 && Contador <= 6) {
                    RandomGenerado = (RA.nextInt(40 - 21) + 21);
                } else if (Contador >= 7 && Contador <= 15) {
                    RandomGenerado = RA.nextInt(20 - 1) + 1;
                } else {
                    RandomGenerado = RA.nextInt(41 - 1) + 1;

                }

            } while (RandomsUsados_Heroe.contains(RandomGenerado));

            RandomsUsados_Heroe.add(RandomGenerado);

            if (Contador == 0) {
                RandomsUsados_Heroe.add(RandomGenerado - 10);
                RandomsUsados_Heroe.add(RandomGenerado + 1);
                RandomsUsados_Heroe.add(RandomGenerado - 1);
                Contador += 3;
            }

            Contador++;
        } while (RandomsUsados_Heroe.size() != 40);

        for (int i = 0; i < RandomsUsados_Heroe.size(); i++) {
            System.out.print(RandomsUsados_Heroe.get(i) + ", ");

        }

        ArrayList<Integer> RandomsUsados_Villano = new ArrayList<Integer>();

        Contador = 0; // 0 Plantea
        // 1 a 6 bombas
        // 7 a 15 Rango 2
        // demas cualquier rango
        do {
            int RandomGenerado = 0;
            do {

                if (Contador == 0) {
                    RandomGenerado = RA.nextInt(39 - 32) + 32;
                } else if (Contador >= 4 && Contador <= 6) {
                    RandomGenerado = (RA.nextInt(40 - 21) + 21);
                } else if (Contador >= 7 && Contador <= 15) {
                    RandomGenerado = RA.nextInt(20 - 1) + 1;
                } else {
                    RandomGenerado = RA.nextInt(41 - 1) + 1;

                }

            } while (RandomsUsados_Villano.contains(RandomGenerado));

            RandomsUsados_Villano.add(RandomGenerado);

            if (Contador == 0) {
                RandomsUsados_Villano.add(RandomGenerado - 10);
                RandomsUsados_Villano.add(RandomGenerado + 1);
                RandomsUsados_Villano.add(RandomGenerado - 1);
                Contador += 3;
            }

            Contador++;
        } while (RandomsUsados_Villano.size() != 40);

        for (int i = 0; i < RandomsUsados_Villano.size(); i++) {
            System.out.print(RandomsUsados_Villano.get(i) + ", ");

        }

        int PosicionHeroes = 1;
        int PosicionVillanos = 40;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (i < 4) {

                    this.Guia_Tablero[i][j] = PosicionVillanos;
                    PosicionVillanos--;
                }

                if (i > 5) {
                    this.Guia_Tablero[i][j] = PosicionHeroes;
                    PosicionHeroes++;
                }

            }
        }

        //         RandomsUsados_Heroe
        //  RandomsUsados_Villano
        PosicionHeroes = 0;
        PosicionVillanos = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (i < 4) {
                    int IndiceNecesario = RandomsUsados_Villano.indexOf(this.Guia_Tablero[i][j]);

                    this.Guia_Tablero[i][j] = Villanos[IndiceNecesario];
                }

                if (i > 5) {

                    int IndiceNecesario = RandomsUsados_Heroe.indexOf(this.Guia_Tablero[i][j]);

                    this.Guia_Tablero[i][j] = Heroes[IndiceNecesario];

                }

            }
        }

    }

    // }
    //esta funcion booleana hace que nos regrese verdadero si no hay nada en las casillas 
    public boolean filavacilla(int numfilas) {

        for (int i = 0; i < 9; i++) {

            if (this.Guia_Tablero[numfilas][i] == 0) {

                return true;
            }

        }
        return false;
    }

    public int[][] getGuia_Tablero() {

        return Guia_Tablero;

    }

    public void controlmovimientos(int posicionx, int posiciony) {

        //CoordPersonjSelect <-esta variable verifica si dimos el primer click
        try {
            if (this.CoordPersonjSelect == null) { //SELECCIONAR

                if (Guia_Tablero[posicionx][posiciony] == 41) {
                    JOptionPane.showMessageDialog(null, "Zona Prohibida");
                    return;
                }
                if (Guia_Tablero[posicionx][posiciony] == 0) {

                    return;
                }

                if (this.turno == false) {

                    if (this.Guia_Tablero[posicionx][posiciony] > 0) {

                        JOptionPane.showMessageDialog(null, "No se puede mover esta carta ya que no es su turno");

                    } else {

                        this.CoordPersonjSelect = new Dimension(posiciony, posicionx);

                    }
                    if (Guia_Tablero[posicionx][posiciony] == -25 || Guia_Tablero[posicionx][posiciony] == -30 || Guia_Tablero[posicionx][posiciony] == -36 || Guia_Tablero[posicionx][posiciony] == -37 || Guia_Tablero[posicionx][posiciony] == -38 || Guia_Tablero[posicionx][posiciony] == -39 || Guia_Tablero[posicionx][posiciony] == -10) {
                        JOptionPane.showMessageDialog(null, "No se puede mover esta carta");
                        this.CoordPersonjSelect = null;
                        return;
                    }
                } else {

                    if (this.Guia_Tablero[posicionx][posiciony] < 0) {

                        JOptionPane.showMessageDialog(null, "No se puede mover esta carta ya que no es su turno");

                    } else {

                        this.CoordPersonjSelect = new Dimension(posiciony, posicionx);

                    }
                    if (Guia_Tablero[posicionx][posiciony] == 35 || Guia_Tablero[posicionx][posiciony] == 36 || Guia_Tablero[posicionx][posiciony] == 37 || Guia_Tablero[posicionx][posiciony] == 38 || Guia_Tablero[posicionx][posiciony] == 39 || Guia_Tablero[posicionx][posiciony] == 40 || Guia_Tablero[posicionx][posiciony] == 11) {
                        JOptionPane.showMessageDialog(null, "No se puede mover esta carta");
                        this.CoordPersonjSelect = null;

                    }
                }
            } else { //MOVER O COMBATE
                //este else es para seleccionar el movimiento osea a donde quiero poner la carta
                //este if es para que cuando en la dimension Guia_Tablero no haya nada yo pueda moverme ahi de lo contrario no    
                if (Guia_Tablero[posicionx][posiciony] == 0) {

                    //si esta vacilla esa coordenada deja colocar la carta
                    if (posicionx == CoordPersonjSelect.height || posiciony == CoordPersonjSelect.width) {
                        System.out.println("LLEGO00: " + Guia_Tablero[posicionx][posiciony]);
                        //este switch hace que si en la posicion que selecionamos la carta es de rango dos se pueda mover mas largo
                        switch (Guia_Tablero[CoordPersonjSelect.height][CoordPersonjSelect.width]) {

                            case 12:

                            case 9:

                            case 31:

                            case 24:

                            case 17:

                            case 29:

                            case 23:

                            case 8:

                            case -11:

                            case -31:

                            case -33:

                            case -40:

                            case -20:

                            case -16:

                            case -35:

                            case -29:
                                System.out.println("se esta haciendo");
                                Guia_Tablero[posicionx][posiciony] = Guia_Tablero[this.CoordPersonjSelect.height][this.CoordPersonjSelect.width];

                                Guia_Tablero[this.CoordPersonjSelect.height][this.CoordPersonjSelect.width] = 0;
                                //esta null porque ya no es necesario tener seleccionado el personaje
                                CoordPersonjSelect = null;
                                if (this.turno) {

                                    setTurno(false);

                                } else {

                                    setTurno(true);
                                }
                                return;
                        }
                        //aqui verifico que a donde voy a mover el personaje sea cercano a las casillas
                        //
                        if ((CoordPersonjSelect.height + 1 == posicionx && CoordPersonjSelect.width == posiciony)
                                || (CoordPersonjSelect.height - 1 == posicionx && CoordPersonjSelect.width == posiciony)
                                || (CoordPersonjSelect.height == posicionx && CoordPersonjSelect.width + 1 == posiciony)
                                || (CoordPersonjSelect.height == posicionx && CoordPersonjSelect.width - 1 == posiciony)) {

                            Guia_Tablero[posicionx][posiciony] = Guia_Tablero[this.CoordPersonjSelect.height][this.CoordPersonjSelect.width];

                            Guia_Tablero[this.CoordPersonjSelect.height][this.CoordPersonjSelect.width] = 0;
                            //esta null porque ya no es necesario tener seleccionado el personaje
                            CoordPersonjSelect = null;
                            if (this.turno) {

                                setTurno(false);
                            } else {

                                setTurno(true);
                            }
                            return;

                        } else {

                            JOptionPane.showMessageDialog(null, "Solo las cartas de rango 2 pueden moverse mas de dos casillas");
                            return;
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "No se puede mover en diagonal las cartas");
                    }
                } else {

                    if (Guia_Tablero[posicionx][posiciony] == 41) {
                        JOptionPane.showMessageDialog(null, "No se puede poner una carta en la zona prohibida ");
                        return;
                    }

                    if ((CoordPersonjSelect.height + 1 == posicionx && CoordPersonjSelect.width == posiciony)
                            || (CoordPersonjSelect.height - 1 == posicionx && CoordPersonjSelect.width == posiciony)
                            || (CoordPersonjSelect.height == posicionx && CoordPersonjSelect.width + 1 == posiciony)
                            || (CoordPersonjSelect.height == posicionx && CoordPersonjSelect.width - 1 == posiciony)) {
                        int rangoheroe = -1, rangovillano = -1, rangouniversal = 0;
                        switch (this.Guia_Tablero[CoordPersonjSelect.height][CoordPersonjSelect.width]) {

                            //cartas rango 3     
                            case 2:
                                rangoheroe = 1;
                                rangouniversal = 1;
                                break;
                            case 12:

                            case 9:

                            case 31:

                            case 24:

                            case 17:

                            case 29:

                            case 23:

                            case 8:
                                rangoheroe = 2;
                                rangouniversal = 1;
                                break;
                            case 27:
                            case 5:
                            case 14:
                            case 10:
                            case 1:
                                rangoheroe = 3;
                                rangouniversal = 1;
                                break;
                            case 26:
                            case 32:
                            case 3:
                            case 13:
                                rangoheroe = 4;
                                rangouniversal = 1;
                                break;
                            case 18:
                            case 6:
                            case 16:
                            case 33:
                                rangoheroe = 5;
                                rangouniversal = 1;
                                break;
                            case 19:
                            case 28:
                            case 7:
                            case 15:
                                rangoheroe = 6;
                                rangouniversal = 1;
                                break;
                            case 34:
                            case 21:
                            case 30:
                                rangoheroe = 7;
                                rangouniversal = 1;
                                break;
                            case 22:
                            case 25:
                                rangoheroe = 8;
                                rangouniversal = 1;
                                break;
                            case 4:
                                rangoheroe = 9;
                                rangouniversal = 1;
                                break;
                            case 20:
                                rangoheroe = 10;
                                rangouniversal = 1;
                                break;
                            case -4:
                                rangovillano = 1;
                                rangouniversal = -1;
                                break;
                            case -11:
                            case -31:
                            case -40:
                            case -33:
                            case -29:
                            case -20:
                            case -16:
                            case -35:
                                rangovillano = 2;
                                rangouniversal = -1;
                                break;
                            case -17:
                            case -14:
                            case -6:
                            case -27:
                            case -19:
                                rangovillano = 3;
                                rangouniversal = -1;
                                break;
                            case -28:
                            case -1:
                            case -3:

                            case -32:
                                rangovillano = 4;
                                rangouniversal = -1;
                                break;
                            case -22:
                            case -9:
                            case -21:
                            case -7:
                                rangovillano = 5;
                                rangouniversal = -1;
                                break;
                            case -5:
                            case -23:
                            case -24:
                            case -26:
                                rangovillano = 6;
                                rangouniversal = -1;
                                break;
                            case -2:
                            case -34:
                            case -13:
                                rangovillano = 7;
                                rangouniversal = -1;
                                break;
                            case -18:
                            case -15:
                                rangovillano = 8;
                                rangouniversal = -1;
                                break;
                            case -12:
                                rangovillano = 9;
                                rangouniversal = -1;
                                break;
                            case -8:
                                rangovillano = 10;
                                rangouniversal = -1;
                                break;
                            case -10:
                                rangovillano = 11;
                                rangouniversal = -1;
                                break;
                            case 11:
                                rangoheroe = 11;
                                rangouniversal = 1;
                                break;

                        }
                        switch (this.Guia_Tablero[posicionx][posiciony]) {

                            //cartas rango 3     
                            case 2:
                                rangoheroe = 1;
                                rangouniversal = 1;
                                break;
                            case 12:

                            case 9:

                            case 31:

                            case 24:

                            case 17:

                            case 29:

                            case 23:

                            case 8:
                                rangoheroe = 2;
                                rangouniversal = 1;
                                break;
                            case 27:
                            case 5:
                            case 14:
                            case 10:
                            case 1:
                                rangoheroe = 3;
                                rangouniversal = 1;
                                break;
                            case 26:
                            case 32:
                            case 3:
                            case 13:
                                rangoheroe = 4;
                                rangouniversal = 1;
                                break;
                            case 18:
                            case 6:
                            case 16:
                            case 33:
                                rangoheroe = 5;
                                rangouniversal = 1;
                                break;
                            case 19:
                            case 28:
                            case 7:
                            case 15:
                                rangoheroe = 6;
                                rangouniversal = 1;
                                break;
                            case 34:
                            case 21:
                            case 30:
                                rangoheroe = 7;
                                rangouniversal = 1;
                                break;
                            case 22:
                            case 25:
                                rangoheroe = 8;
                                rangouniversal = 1;
                                break;
                            case 4:
                                rangoheroe = 9;
                                rangouniversal = 1;
                                break;
                            case 20:
                                rangoheroe = 10;
                                rangouniversal = 1;
                                break;
                            case -4:
                                rangovillano = 1;
                                rangouniversal = -1;
                                break;
                            case -11:
                            case -31:
                            case -40:
                            case -33:
                            case -29:
                            case -20:
                            case -16:
                            case -35:
                                rangovillano = 2;
                                rangouniversal = -1;
                                break;
                            case -17:
                            case -14:
                            case -6:
                            case -27:
                            case -19:
                                rangovillano = 3;
                                rangouniversal = -1;
                                break;
                            case -28:
                            case -1:
                            case -3:

                            case -32:
                                rangovillano = 4;
                                rangouniversal = -1;
                                break;
                            case -22:
                            case -9:
                            case -21:
                            case -7:
                                rangovillano = 5;
                                rangouniversal = -1;
                                break;
                            case -5:
                            case -23:
                            case -24:
                            case -26:
                                rangovillano = 6;
                                rangouniversal = -1;
                                break;
                            case -2:
                            case -34:
                            case -13:
                                rangovillano = 7;
                                rangouniversal = -1;
                                break;
                            case -18:
                            case -15:
                                rangovillano = 8;
                                rangouniversal = -1;
                                break;
                            case -12:
                                rangovillano = 9;
                                rangouniversal = -1;
                                break;
                            case -8:
                                rangovillano = 10;
                                rangouniversal = -1;
                                break;
                            case -10:
                                rangovillano = 11;
                                rangouniversal = -1;
                                break;
                            case 11:
                                rangoheroe = 11;
                                rangouniversal = 1;
                                break;
                            case -25:
                            case -30:
                            case -36:
                            case -37:
                            case -38:
                            case -39:
                                rangouniversal = -1;
                                rangovillano = 12;
                                break;

                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                                rangouniversal = 1;
                                rangoheroe = 12;
                                break;
                        }
                        String usatacanteheroe = "", usatacantevillano = "";
                        switch (this.Guia_Tablero[this.CoordPersonjSelect.height][CoordPersonjSelect.width]) {

                            case 30:
                                usatacanteheroe = "Spider Man";
                                break;
                            case 19:
                                usatacanteheroe = "Iron Man";
                                break;
                            case 15:
                                usatacanteheroe = "Hulk";
                                break;
                            case 4:
                                usatacanteheroe = "Capain America";
                                break;
                            case 33:
                                usatacanteheroe = "Thor";
                                break;
                            case 34:
                                usatacanteheroe = "Wolverine";
                                break;
                            case 2:
                                usatacanteheroe = "Black Widow";
                                break;
                            case 31:
                                usatacanteheroe = "Storm";
                                break;
                            case 13:
                                usatacanteheroe = "Ghostrider";
                                break;
                            case 7:
                                usatacanteheroe = "Dare Devil";
                                break;
                            case 24:
                                usatacanteheroe = "Pheonix";
                                break;
                            case 32:
                                usatacanteheroe = "Thing";
                                break;
                            case 9:
                                usatacanteheroe = "Elektra";
                                break;
                            case 22:
                                usatacanteheroe = "Nick Fury";
                                break;
                            case 25:
                                usatacanteheroe = "Professor X";
                                break;
                            case 21:
                                usatacanteheroe = "Namor";
                                break;
                            case 28:
                                usatacanteheroe = "Silver Surfer";
                                break;
                            case 20:
                                usatacanteheroe = "Mr.Fantastic";
                                break;
                            case 16:
                                usatacanteheroe = "Humantorch";
                                break;
                            case 6:
                                usatacanteheroe = "Cyclops";
                                break;
                            case 18:
                                usatacanteheroe = "Invisible Woman";
                                break;
                            case 26:
                                usatacanteheroe = "Punisher";
                                break;
                            case 27:
                                usatacanteheroe = "SheHulk";
                                break;
                            case 3:
                                usatacanteheroe = "Blade";
                                break;
                            case 5:
                                usatacanteheroe = "Colossus";
                                break;
                            case 14:
                                usatacanteheroe = "GiantMan";
                                break;
                            case 10:
                                usatacanteheroe = "Emma Frost";
                                break;

                            case 1:
                                usatacanteheroe = "Beast";
                                break;
                            case 12:
                                usatacanteheroe = "Gambit";
                                break;
                            case 17:
                                usatacanteheroe = "IceMan";
                                break;
                            case 29:
                                usatacanteheroe = "SpideGirl";
                                break;
                            case 23:
                                usatacanteheroe = "NightCrawler";
                                break;
                            case 8:
                                usatacanteheroe = "Dr Strange";
                                break;
                            case -18:
                                usatacantevillano = "Magneto";
                                break;
                            case -15:
                                usatacantevillano = "kingpin";
                                break;
                            case -2:
                                usatacantevillano = "Apocalypse";
                                break;
                            case -34:
                                usatacantevillano = "Venom";
                                break;
                            case -13:
                                usatacantevillano = "Green Goblin";
                                break;
                            case -5:
                                usatacantevillano = "Bullseye";
                                break;
                            case -23:
                                usatacantevillano = "Omega Red";
                                break;
                            case -24:
                                usatacantevillano = "Onslaught";
                                break;
                            case -26:
                                usatacantevillano = "Red Skull";
                                break;
                            case -22:
                                usatacantevillano = "Mystique";
                                break;
                            case -9:
                                usatacantevillano = "Dr Octopus";
                                break;
                            case -21:
                                usatacantevillano = "Mysterio";
                                break;
                            case -7:
                                usatacantevillano = "DeathPool";
                                break;
                            case -28:
                                usatacantevillano = "Sabretooth";
                                break;
                            case -1:
                                usatacantevillano = "Abomination";
                                break;
                            case -3:
                                usatacantevillano = "Black Cat";
                                break;
                            case -32:
                                usatacantevillano = "Thanos";
                                break;
                            case -17:
                                usatacantevillano = "Lizard";
                                break;
                            case -14:
                                usatacantevillano = "Juggernaut";
                                break;
                            case -6:
                                usatacantevillano = "Carnage";
                                break;
                            case -27:
                                usatacantevillano = "Rhino";
                                break;
                            case -19:
                                usatacantevillano = "Mole Man";
                                break;
                            case -11:
                                usatacantevillano = "Electro";
                                break;

                            case -31:
                                usatacantevillano = "Sentinel 1";
                                break;
                            case -40:
                                usatacantevillano = "Sentinel 2";
                                break;
                            case -33:

                                usatacantevillano = "Ultron";
                                break;
                            case -29:
                                usatacantevillano = "SandMan";
                                break;
                            case -20:
                                usatacantevillano = "Mr Sinister";
                                break;
                            case -16:
                                usatacantevillano = "Leader";
                                break;

                            case -35:
                                usatacantevillano = "Viper";
                                break;
                            case -12:
                                usatacantevillano = "Galactus";
                                break;
                            case -8:
                                usatacantevillano = "Dr Doom";
                                break;

                        }
                        String usatacadoheroe = "", usatacadovillano = "";
                        switch (this.Guia_Tablero[posicionx][posiciony]) {

                            case 30:
                                usatacadoheroe = "Spider Man";
                                break;
                            case 19:
                                usatacadoheroe = "Iron Man";
                                break;

                            case 15:
                                usatacadoheroe = "Hulk";
                                break;
                            case 4:
                                usatacadoheroe = "Capain America";
                                break;
                            case 33:
                                usatacadoheroe = "Thor";
                                break;

                            case 34:
                                usatacadoheroe = "Wolverine";
                                break;
                            case 2:
                                usatacadoheroe = "Black Widow";
                                break;
                            case 31:
                                usatacadoheroe = "Storm";
                                break;
                            case 13:
                                usatacadoheroe = "Ghostrider";
                                break;
                            case 7:
                                usatacadoheroe = "Dare Devil";
                                break;
                            case 24:
                                usatacadoheroe = "Pheonix";
                                break;
                            case 32:
                                usatacadoheroe = "Thing";
                                break;
                            case 9:
                                usatacadoheroe = "Elektra";
                                break;
                            case 22:
                                usatacadoheroe = "Nick Fury";
                                break;
                            case 25:
                                usatacadoheroe = "Professor X";
                                break;
                            case 21:
                                usatacadoheroe = "Namor";
                                break;
                            case 28:
                                usatacadoheroe = "Silver Surfer";
                                break;
                            case 20:
                                usatacadoheroe = "Mr.Fantastic";
                                break;
                            case 16:
                                usatacadoheroe = "Humantorch";
                                break;
                            case 6:
                                usatacadoheroe = "Cyclops";
                                break;
                            case 18:
                                usatacadoheroe = "Invisible Woman";
                                break;
                            case 26:
                                usatacadoheroe = "Punisher";
                                break;
                            case 27:
                                usatacadoheroe = "SheHulk";
                                break;

                            case 5:
                                usatacadoheroe = "Colossus";
                                break;
                            case 14:
                                usatacadoheroe = "GiantMan";
                                break;
                            case 10:
                                usatacadoheroe = "Emma Frost";
                                break;

                            case 1:
                                usatacadoheroe = "Beast";
                                break;
                            case 12:
                                usatacadoheroe = "Gambit";
                                break;
                            case 17:
                                usatacadoheroe = "IceMan";
                                break;
                            case 29:
                                usatacadoheroe = "SpideGirl";
                                break;
                            case 23:
                                usatacadoheroe = "NightCrawler";
                                break;

                            case 3:
                                usatacadoheroe = "Blade";
                                break;
                            case 8:
                                usatacadoheroe = "Dr Strange";
                                break;
                            case -18:
                                usatacadovillano = "Magneto";
                                break;
                            case -15:
                                usatacadovillano = "kingpin";
                                break;
                            case -2:
                                usatacadovillano = "Apocalypse";
                                break;
                            case -34:
                                usatacadovillano = "Venom";
                                break;
                            case -13:
                                usatacadovillano = "Green Goblin";
                                break;
                            case -5:
                                usatacadovillano = "Bullseye";
                                break;
                            case -23:
                                usatacadovillano = "Omega Red";
                                break;
                            case -24:
                                usatacadovillano = "Onslaught";
                                break;
                            case -26:
                                usatacadovillano = "Red Skull";
                                break;
                            case -22:
                                usatacadovillano = "Mystique";
                                break;
                            case -9:
                                usatacadovillano = "Dr Octopus";
                                break;
                            case -21:
                                usatacadovillano = "Mysterio";
                                break;
                            case -7:
                                usatacadovillano = "DeathPool";

                                break;
                            case -28:
                                usatacadovillano = "Sabretooth";
                                break;
                            case -1:
                                usatacadovillano = "Abomination";
                                break;
                            case -3:
                                usatacadovillano = "Black Cat";
                                break;
                            case -32:
                                usatacadovillano = "Thanos";
                                break;
                            case -17:
                                usatacadovillano = "Lizard";
                                break;
                            case -14:
                                usatacadovillano = "Juggernaut";
                                break;
                            case -6:
                                usatacadovillano = "Carnage";
                                break;
                            case -27:
                                usatacadovillano = "Rhino";
                                break;
                            case -19:
                                usatacadovillano = "Mole Man";
                                break;
                            case -11:
                                usatacadovillano = "Electro";
                                break;

                            case -31:
                                usatacadovillano = "Sentinel 1";
                                break;
                            case -40:
                                usatacadovillano = "Sentinel 2";
                                break;
                            case -33:

                                usatacadovillano = "Ultron";
                                break;
                            case -29:
                                usatacadovillano = "SandMan";
                                break;
                            case -20:
                                usatacadovillano = "Mr Sinister";
                                break;
                            case -16:
                                usatacadovillano = "Leader";
                                break;
                            case -35:
                                usatacadovillano = "Viper";
                                break;
                            case -12:
                                usatacadovillano = "Galactus";
                                break;
                            case -8:
                                usatacadovillano = "Dr Doom";
                                break;

                        }
                     
                        if (this.turno == true) {

                            if (rangovillano == 11) {

                                JOptionPane.showMessageDialog(null, "Ganaste");
                                this.setGanadorheroes(true);
                                return;
                            }
                            if (rangovillano == 12) {

                                if (rangoheroe == 3) {
                                    JOptionPane.showMessageDialog(null, "BOOOM YA NO");
                                    for (int i = 0; i < VencidosVillano.length; i++) {
                                        if (VencidosVillano[i] == 0) {

                                            VencidosVillano[i] = this.Guia_Tablero[posicionx][posiciony];
                                            Guia_Tablero[posicionx][posiciony] = Guia_Tablero[this.CoordPersonjSelect.height][CoordPersonjSelect.width];
                                            Guia_Tablero[this.CoordPersonjSelect.height][CoordPersonjSelect.width] = 0;
                                            break;
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "BOOOM");

                                    for (int i = 0; i < this.VencidosHeroe.length; i++) {
                                        if (VencidosHeroe[i] == 0) {

                                            VencidosHeroe[i] = Guia_Tablero[this.CoordPersonjSelect.height][CoordPersonjSelect.width];

                                            Guia_Tablero[this.CoordPersonjSelect.height][CoordPersonjSelect.width] = 0;
                                            break;
                                        }
                                    }

                                }
                                return;
                            }
                         
                        } else {

                            if (rangoheroe == 11) {

                                JOptionPane.showMessageDialog(null, "Ganaste");
                                //AQUI TIEN QUE PASAR ALGO
                                this.setGanadorvillanos(true);
                                return;
                            }
                            if (rangoheroe == 12) {

                                if (rangovillano == 3) {
                                    JOptionPane.showMessageDialog(null, "Bomba desactivada");
                                    for (int i = 0; i < this.VencidosHeroe.length; i++) {
                                        if (this.VencidosHeroe[i] == 0) {

                                            this.VencidosHeroe[i] = this.Guia_Tablero[posicionx][posiciony];
                                            Guia_Tablero[posicionx][posiciony] = Guia_Tablero[this.CoordPersonjSelect.height][CoordPersonjSelect.width];
                                            Guia_Tablero[this.CoordPersonjSelect.height][CoordPersonjSelect.width] = 0;
                                            break;
                                        }
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(null, "BOOOM");

                                    for (int i = 0; i < this.VencidosVillano.length; i++) {
                                        if (VencidosVillano[i] == 0) {

                                            VencidosVillano[i] = Guia_Tablero[this.CoordPersonjSelect.height][CoordPersonjSelect.width];

                                            Guia_Tablero[this.CoordPersonjSelect.height][CoordPersonjSelect.width] = 0;
                                            break;
                                        }
                                    }

                                }
                                return;
                            }

                        }
                         
                        if (this.turno==true && Guia_Tablero[posicionx][posiciony] < 0) { //SI ES HEROE ATACA VILLANO

                            if (rangoheroe > rangovillano &&  Guia_Tablero[posicionx][posiciony] < 0 ) {

                                for (int i = 0; i < VencidosVillano.length; i++) {
                                    if (VencidosVillano[i] == 0) {

                                        VencidosVillano[i] = this.Guia_Tablero[posicionx][posiciony];
                                        Guia_Tablero[posicionx][posiciony] =Guia_Tablero[CoordPersonjSelect.height][CoordPersonjSelect.width];
                                        Guia_Tablero[CoordPersonjSelect.height][CoordPersonjSelect.width]= 0;

                                        break;
                                    }
                                }
                                
                                JOptionPane.showMessageDialog(null, usatacanteheroe + "VS " + usatacadovillano);
                                JOptionPane.showMessageDialog(null, "Ganador: " + usatacanteheroe);

                            } else if (this.turno==true &&rangoheroe == rangovillano && Guia_Tablero[posicionx][posiciony] < 0) {

                                for (int i = 0; i < VencidosVillano.length; i++) {
                                    if (VencidosVillano[i] == 0) {

                                        VencidosVillano[i] = this.Guia_Tablero[posicionx][posiciony];
                                        Guia_Tablero[posicionx][posiciony] = 0;
                                        //es cero porque la posicion donde estaba antes la carta tiene que quedar en cero para que no quede duplicada la carta
                                     
                                        break;
                                    }
                                }
                                for (int i = 0; i < VencidosHeroe.length; i++) {
                                    if (VencidosHeroe[i] == 0) {

                                        VencidosHeroe[i] = this.Guia_Tablero[CoordPersonjSelect.height][CoordPersonjSelect.width];                           
                                        Guia_Tablero[CoordPersonjSelect.height][CoordPersonjSelect.width] = 0;
                                        
                                        break;
                                    }
                                }
                               
                                JOptionPane.showMessageDialog(null, usatacanteheroe + " VS " + usatacadovillano);
                                JOptionPane.showMessageDialog(null, "Ganador: EMPATE");

                            } else {

                                //este else valida que si el rango del villano es mayor que el del heroe venza al heroe 
                                if (this.turno==true &&Guia_Tablero[posicionx][posiciony] < 0) {
                                    for (int i = 0; i < this.VencidosHeroe.length; i++) {
                                        if (VencidosHeroe[i] == 0) {

                                            //aqui coloco en el array el numero que tiene el heroe vencido
                                            VencidosHeroe[i] = this.Guia_Tablero[this.CoordPersonjSelect.height][this.CoordPersonjSelect.width];
                                            Guia_Tablero[this.CoordPersonjSelect.height][this.CoordPersonjSelect.width] = Guia_Tablero[posicionx][posiciony];
                                            Guia_Tablero[posicionx][posiciony] = 0;
                                            break;
                                        }
                                    }
                                   
                                    JOptionPane.showMessageDialog(null, usatacanteheroe + " VS " + usatacadovillano);
                                    JOptionPane.showMessageDialog(null, "Ganador: " + usatacadovillano);

                                }
                            }
                            this.setTurno(false);
                            return;

                        } else {//SI ES VILLANO ATACA HEROE

                            if (turno == false && rangoheroe > rangovillano && rangouniversal == 1) {

                                for (int i = 0; i < VencidosVillano.length; i++) {
                                    if (VencidosVillano[i] == 0) {

                                        VencidosVillano[i] = this.Guia_Tablero[this.CoordPersonjSelect.height][this.CoordPersonjSelect.width];
                                        Guia_Tablero[this.CoordPersonjSelect.height][this.CoordPersonjSelect.width] = Guia_Tablero[posicionx][posiciony];
                                        Guia_Tablero[posicionx][posiciony] = 0;
                                        this.setTurno(true);
                                        break;
                                    }

                                }
                                JOptionPane.showMessageDialog(null, usatacantevillano + " VS " + usatacadoheroe);
                                JOptionPane.showMessageDialog(null, "Ganador: " + usatacadoheroe);

                            } else if (turno == false && rangoheroe == rangovillano && rangouniversal == 1) {

                                for (int i = 0; i < VencidosVillano.length; i++) {
                                    if (VencidosVillano[i] == 0) {

                                        VencidosVillano[i] = this.Guia_Tablero[CoordPersonjSelect.height][CoordPersonjSelect.width];
                                     Guia_Tablero[CoordPersonjSelect.height][CoordPersonjSelect.width] = 0;
                                       
                                        this.setTurno(true);
                                        break;
                                    }
                                }
                                for (int i = 0; i < VencidosHeroe.length; i++) {
                                    if (VencidosHeroe[i] == 0) {

                                        VencidosHeroe[i] = this.Guia_Tablero[posicionx][posiciony];
                                        
                                        //es cero porque la posicion donde estaba antes la carta tiene que quedar en cero para que no quede duplicada la carta
                                        
                                         Guia_Tablero[posicionx][posiciony] = 0;
                                        this.setTurno(true);
                                        break;
                                    }
                                }

                                if (Guia_Tablero[posicionx][posiciony] == 11) {

                                    JOptionPane.showMessageDialog(null, "Ganaron los villanos ");

                                }
                                JOptionPane.showMessageDialog(null, usatacantevillano + " VS " + usatacadoheroe);
                                JOptionPane.showMessageDialog(null, "Ganador: EMPATE");
                            } else {
                                //este else es cuando el villano gana
                                if (turno == false && rangouniversal == 1) {
                                    for (int i = 0; i < this.VencidosHeroe.length; i++) {
                                        if (VencidosHeroe[i] == 0) {

                                            //aqui coloco en el array el numero que tiene heroe vencido
                                            VencidosHeroe[i] = this.Guia_Tablero[posicionx][posiciony];
                                            Guia_Tablero[posicionx][posiciony] = Guia_Tablero[CoordPersonjSelect.height][CoordPersonjSelect.width];
                                            //es cero porque la posicion donde estaba antes la carta tiene que quedar en cero para que no quede duplicada la carta
                                            Guia_Tablero[CoordPersonjSelect.height][CoordPersonjSelect.width] = 0;
                                            this.setTurno(true);
                                            break;

                                        }
                                    }
                                }
                                JOptionPane.showMessageDialog(null, usatacantevillano + " VS " + usatacadoheroe);
                                JOptionPane.showMessageDialog(null, "Ganador: " + usatacantevillano);
                            }

                        }
                    }

                    // JOptionPane.showMessageDialog(null, "Ya hay una carta en esa posicion ");
                    //esta null porque ya no es necesario tener seleccionado el personaje
                    CoordPersonjSelect = null;
                    return;
                }

            }

        } catch (Exception e) {

            System.out.println("Error ");
            JOptionPane.showMessageDialog(null, "Error salio del rango");

        }

    }

    public boolean getTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;

    }

    public int[] getVencidosVillano() {
        return VencidosVillano;
    }

    public int[] getVencidosHeroe() {
        return VencidosHeroe;
    }

    public void setVencidosVillano(int[] VencidosVillano) {
        this.VencidosVillano = VencidosVillano;
    }

    public void setVencidosHeroe(int[] VencidosHeroe) {
        this.VencidosHeroe = VencidosHeroe;
    }

    public void setGanadorheroes(boolean ganadorheroes) {
        this.ganadorheroes = ganadorheroes;
    }

    public boolean getGanadorheroes() {
        return ganadorheroes;
    }

    public void setGanadorvillanos(boolean ganadorvillanos) {
        this.ganadorvillanos = ganadorvillanos;
    }

    public boolean getGanadorvillanos() {
        return ganadorvillanos;
    }

}
