package programacion1.Videojuego;

/**
 *
 * @author ruthreyes
 */
import java.awt.Dimension;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Stratego extends javax.swing.JFrame {
  
    ArrayList<Loggs> ListadeLoggs;
    boolean turno = true;
    int contjugadas = 0, conttutorial = 0;
    Villanos controlvillanos = new Villanos();
    TableroPrincip controltabl = new TableroPrincip();
    Heroes controlheroes = new Heroes();
    int[] Vencidos_Heroes;
    int[][] Guia_Tablero;
    int[] Vencidos_Villano;
    int partidasjugadasheroes = 0, partidasjugadasvillanos = 0;
    ArrayList<Usuario> ListadeUsuarios;
    String nombreusuario, resptipopartida, respUsuario, tipoinvitado;
    String[] tipopartida = {"Heroe", "Villano"};
    boolean mododejuego_Tutorial = true;

    public Stratego(ArrayList<Usuario> AtributListadeUsuarios, ArrayList<Loggs> AtributListadeLoggs, String nombreusuario, boolean mododejuego) {
        
        this.ListadeUsuarios = AtributListadeUsuarios;
        this.nombreusuario = nombreusuario;
        this.ListadeLoggs = AtributListadeLoggs;
        //esta funcion es para conseguir la matriz de la clase tableroprincip
        Guia_Tablero = controltabl.getGuia_Tablero();
        Vencidos_Villano = controltabl.getVencidosVillano();
        Vencidos_Heroes = controltabl.getVencidosHeroe();
        mododejuego_Tutorial = mododejuego;
        initComponents();
        //le resto uno ya que es para quitar el usario logg

        String[] nomusuarios = new String[ListadeUsuarios.size() - 1];

        int cont = 0;
        for (int i = 0; i < ListadeUsuarios.size(); i++) {

            System.out.println("" + ListadeUsuarios.get(i).getnombre());
            System.out.println("" + this.nombreusuario);

            if (!ListadeUsuarios.get(i).getnombre().equals(this.nombreusuario)) {
                nomusuarios[cont] = ListadeUsuarios.get(i).getnombre();
                cont++;

            }

        }

        resptipopartida = (String) JOptionPane.showInputDialog(null, "¿Quiere jugar como heroe o como villano?", "", JOptionPane.QUESTION_MESSAGE, null, tipopartida, tipopartida[0]);

        if (nomusuarios.length > 1) {
            respUsuario = (String) JOptionPane.showInputDialog(null, "Escoja el usuario", "", JOptionPane.QUESTION_MESSAGE, null, nomusuarios, nomusuarios[0]);
        } else {

            for (int i = 0; i < ListadeUsuarios.size(); i++) {
                if (!ListadeUsuarios.get(i).getnombre().equals(this.nombreusuario)) {
                    respUsuario = ListadeUsuarios.get(i).getnombre();
                }

            }

        }

        System.out.println("" + respUsuario);
        System.out.println("" + resptipopartida);
        //este for llena el jpanel con buttons de 10x10 
        for (int i = 0; i < Guia_Tablero.length; i++) {

            for (int j = 0; j < Guia_Tablero[0].length; j++) {
                JButton bottontemp = new JButton();
                //aqui le agrego caracteristicas al botton 
                // bottontemp.setText(""+i+":"+j);
                bottontemp.setBorder(null);
                bottontemp.setSize(new Dimension(55, 55));
                if (Guia_Tablero[i][j] == 41) {
                    bottontemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programacion1/Videojuego/Imagenes/resized/prohibido.png")));
                } else if (Guia_Tablero[i][j] == 1) {

                    bottontemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programacion1/Videojuego/Imagenes/resized/" + (this.Guia_Tablero[i][j]) + ".png")));

                } else {

                    bottontemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programacion1/Videojuego/Imagenes/resized/base.png")));
                }
                Dimension Dimentemp = new Dimension(j, i);
                bottontemp.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        clickcarta(Dimentemp.height, Dimentemp.width);
                    }
                });
                Tablero.add(bottontemp);
            }
        }
        //i es 4 ya que son 10 filas y 4 columnas
        for (int i = 0; i < 40; i++) {

            JButton botton2 = new JButton();
            botton2.setBorder(null);
            botton2.setSize(new Dimension(55, 55));
            botton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programacion1/Videojuego/Imagenes/resized/" + (this.Vencidos_Heroes[i]) + ".png")));
            //copie de generade code el codigo del boten que les puse mouse listener de ejemplo

            //aqui se van agregando los botones
            jPanel1.add(botton2);

        }

        for (int i = 0; i < 40; i++) {

            JButton botton2 = new JButton();
            botton2.setBorder(null);
            botton2.setSize(new Dimension(55, 55));
            //recorri el for hasta cada posicion de la matriz la cual tenia distintos valores y con ello identifique la imagen 
            botton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programacion1/Videojuego/Imagenes/villains/" + (this.Vencidos_Villano[i]) + ".png")));

            jPanel3.add(botton2);

        }
        //coloque un jlabel para que se actualizara la pantalla 
        jLabel1.setText("");
        mostrartablero();

    }

    //para poder actualizar constantemente el tablero cada vez que se haga un cambio
    //es lo mismo porque arriba es para mostarlo la primera vez pero como es una funcion mostrartablero ahora se ouede repetir varias veces
    public void mostrartablero() {
        this.Vencidos_Heroes = this.controltabl.getVencidosHeroe();
        this.Vencidos_Villano = this.controltabl.getVencidosVillano();
        System.out.println("heroe");
        for (int i = 0; i < Vencidos_Heroes.length; i++) {

            System.out.print("" + Vencidos_Heroes[i]);

        }
        System.out.println("villano");
        for (int i = 0; i < Vencidos_Villano.length; i++) {

            System.out.print("" + Vencidos_Villano[i]);

        }
        if (this.turno == false) {

            jLabel2.setText("Turno Villano");

            if (resptipopartida.equals("Villano")) {

                jLabel3.setText("Usuario: " + nombreusuario);
            } else {

                jLabel3.setText("Usuario: " + respUsuario);

            }

        } else {

            jLabel2.setText("Turno Heroe");
            if (resptipopartida.equals("Heroe")) {
                jLabel3.setText("Usuario: " + nombreusuario);

            } else {

                jLabel3.setText("Usuario: " + respUsuario);
            }
        }

        //estos remove son para quitar los botones de antes y poner los nuevos ya que si se dejan los viejos no se van a mostrar los que estan abajo que son los nuevos
        Tablero.removeAll();
        jPanel1.removeAll();
        jPanel3.removeAll();
        //el primero es lo ancho osea x
        for (int i = 0; i < Guia_Tablero.length; i++) {
            //y este es para recorrer los largo
            for (int j = 0; j < Guia_Tablero[0].length; j++) {
                System.out.print("" + Guia_Tablero[i][j]);

            }
            System.out.println("");
        }

        for (int i = 0; i < Guia_Tablero.length; i++) {
//todos los mauselistener que coloque son para poder seguir cambiando de posicion las cartas
//el primer click es para sellecionar el personaje y el segun es para asignarle la posicion
            for (int j = 0; j < Guia_Tablero[0].length; j++) {
                System.out.print("" + this.Guia_Tablero[i][j]);
                //41 es un numero que no tenemos 
                if (Guia_Tablero[i][j] == 41) {
                    Dimension Dimentemp = new Dimension(j, i);
                    JButton bottontemp = new JButton();
                    //aqui le agrego caracteristicas al botton 
                    // bottontemp.setText(""+i+":"+j);
                    bottontemp.setBorder(null);
                    bottontemp.setSize(new Dimension(55, 55));
                    bottontemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programacion1/Videojuego/Imagenes/resized/prohibido.png")));
                    bottontemp.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            clickcarta(Dimentemp.height, Dimentemp.width);
                        }
                    });

                    Tablero.add(bottontemp);

                } else if (Guia_Tablero[i][j] != 0) {

                    if (this.Guia_Tablero[i][j] > 0) {
                        if (turno || this.mododejuego_Tutorial) {
                            JButton bottontemp = new JButton();
                            Dimension Dimentemp = new Dimension(j, i);
                            //aqui le agrego caracteristicas al botton 
                            // bottontemp.setText(""+i+":"+j);
                            bottontemp.setBorder(null);
                            bottontemp.setSize(new Dimension(55, 55));
                            bottontemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programacion1/Videojuego/Imagenes/resized/" + (this.Guia_Tablero[i][j]) + ".png")));
                            bottontemp.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                    clickcarta(Dimentemp.height, Dimentemp.width);
                                }

                            });

                            Tablero.add(bottontemp);
                        } else {
                            JButton bottontemp = new JButton();
                            Dimension Dimentemp = new Dimension(j, i);
                            //aqui le agrego caracteristicas al botton 
                            // bottontemp.setText(""+i+":"+j);
                            bottontemp.setBorder(null);
                            bottontemp.setSize(new Dimension(55, 55));
                            bottontemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programacion1/Videojuego/Imagenes/resized/CartHeroe.png")));
                            bottontemp.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                    clickcarta(Dimentemp.height, Dimentemp.width);
                                }

                            });

                            Tablero.add(bottontemp);
                        }

                    } else {
                        if ((!turno) || this.mododejuego_Tutorial) {

                            JButton bottontemp = new JButton();
                            Dimension Dimentemp = new Dimension(j, i);
                            //aqui le agrego caracteristicas al botton 
                            // bottontemp.setText(""+i+":"+j);
                            bottontemp.setBorder(null);
                            bottontemp.setSize(new Dimension(55, 55));
                            bottontemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programacion1/Videojuego/Imagenes/resized/" + (this.Guia_Tablero[i][j]) + ".png")));
                            bottontemp.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                    clickcarta(Dimentemp.height, Dimentemp.width);
                                }

                            });

                            Tablero.add(bottontemp);

                        } else {

                            JButton bottontemp = new JButton();
                            Dimension Dimentemp = new Dimension(j, i);
                            //aqui le agrego caracteristicas al botton 
                            // bottontemp.setText(""+i+":"+j);
                            bottontemp.setBorder(null);
                            bottontemp.setSize(new Dimension(55, 55));
                            bottontemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programacion1/Videojuego/Imagenes/resized/CartVillano.png")));
                            bottontemp.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                    clickcarta(Dimentemp.height, Dimentemp.width);
                                }

                            });

                            Tablero.add(bottontemp);

                        }

                    }

                } else {

                    JButton bottontemp = new JButton();
                    Dimension Dimentemp = new Dimension(j, i);
                    //aqui le agrego caracteristicas al botton 
                    // bottontemp.setText(""+i+":"+j);
                    bottontemp.setBorder(null);
                    bottontemp.setSize(new Dimension(55, 55));
                    bottontemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programacion1/Videojuego/Imagenes/resized/base.png")));
                    bottontemp.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            clickcarta(Dimentemp.height, Dimentemp.width);
                        }

                    });

                    Tablero.add(bottontemp);

                }
            }

        }

        for (int i = 0; i < 40; i++) {

            JButton botton2 = new JButton();
            botton2.setBorder(null);
            botton2.setSize(new Dimension(55, 55));
            botton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programacion1/Videojuego/Imagenes/resized/" + (this.Vencidos_Heroes[i]) + ".png")));
            //copie de generade code el codigo del boten que les puse mouse listener de ejemplo

            //aqui se van agregando los botones
            jPanel1.add(botton2);

        }

        for (int i = 0; i < 40; i++) {

            JButton botton2 = new JButton();
            botton2.setBorder(null);
            botton2.setSize(new Dimension(55, 55));
            //recorri el for hasta cada posicion de la matriz la cual tenia distintos valores y con ello identifique la imagen 
            //ME TIRA ERROR ACA
            botton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programacion1/Videojuego/Imagenes/resized/" + (this.Vencidos_Villano[i]) + ".png")));

            jPanel3.add(botton2);

        }

        contjugadas++;
        jLabel1.setText("Click" + contjugadas);
        //esto va a pedir si gano heroe o villano
        boolean ganoheroes = this.controltabl.getGanadorheroes();
        boolean ganovillanos = this.controltabl.ganadorvillanos;
        String villano = "", heroe = "";
        //AQUII 
        if (respUsuario == null) {

            for (int i = 0; i < this.ListadeUsuarios.size(); i++) {

                if (!ListadeUsuarios.get(i).getnombre().equals(this.nombreusuario)) {

                    respUsuario = ListadeUsuarios.get(i).getnombre();
                }
            }
        }
        if (resptipopartida.equals("Villano")) {
            villano = nombreusuario;

            heroe = respUsuario;
        } else {//turno heroe
            heroe = nombreusuario;

            villano = respUsuario;
        }

        if (ganoheroes == true) {
            for (int i = 0; i < this.ListadeUsuarios.size(); i++) {
                if (ListadeUsuarios.get(i).getnombre().equals(heroe)) {
                    ListadeUsuarios.get(i).setpuntos(ListadeUsuarios.get(i).getpuntos() + 3);
                }
            }

            DateTimeFormatter fechapartida = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime fecha = LocalDateTime.now();
            this.ListadeLoggs.add(new Loggs(heroe + "Usando heroes ha ganado y " + villano + " usando villanos ha perdido " + fechapartida.format(fecha), "Heroes"));

            JOptionPane.showMessageDialog(null, "Gano " + heroe + " ante " + villano);
            MenuPrincipal mp3 = new MenuPrincipal(this.ListadeUsuarios, this.ListadeLoggs, nombreusuario, mododejuego_Tutorial);
            mp3.setVisible(true);
            this.setVisible(false);
            partidasjugadasheroes++;
        }
        if (ganovillanos == true) {
            for (int i = 0; i < this.ListadeUsuarios.size(); i++) {
                if (ListadeUsuarios.get(i).getnombre().equals(villano)) {
                    ListadeUsuarios.get(i).setpuntos(ListadeUsuarios.get(i).getpuntos() + 3);
                }
            }

            DateTimeFormatter fechapartida = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime fecha = LocalDateTime.now();
            this.ListadeLoggs.add(new Loggs(villano + "Usando villanos ha ganado ya que " + heroe + " usando heroes " + fechapartida.format(fecha), "Villano"));

            JOptionPane.showMessageDialog(null, "Gano" + villano + " ante " + heroe);
            MenuPrincipal mp3 = new MenuPrincipal(this.ListadeUsuarios, this.ListadeLoggs, nombreusuario, mododejuego_Tutorial);
            mp3.setVisible(true);
            this.setVisible(false);
            partidasjugadasvillanos++;
        }

    }

    //el privatevoid va a ser para poder las fichas cada que las toquen
    private void clickcarta(int posicionx, int posiciony) {

        this.controltabl.controlmovimientos(posicionx, posiciony);
        this.turno = this.controltabl.getTurno();
        this.Guia_Tablero = this.controltabl.getGuia_Tablero();
        if (this.mododejuego_Tutorial == true && conttutorial == 0) {

            JOptionPane.showMessageDialog(null,
                    "<html><br><br>Las Cartas Rango 2 pueden moverse como las torres de Ajedres pero las demas cartas solo se pueden mover 1 casilla" + "<br><br>"
                    + "Las Cartas Rango 3 pueden vencer a las bombas pero las demas cartas no si caen en una bomba explotan" + "<br><br>"
                    + "Las Cartas no se pueden mover de forma diagonal solo adyacente" + "<br><br>"
                    + "Las demas cartas de Rango pueden vencer a las de Rango 10 " + "<br><br>"
                    + "Se gana el juego cuando el contricante se queda sin movimientos o captura a la tierra o si se rinde" + "</html>");

            conttutorial++;
        }
        mostrartablero();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Tablero = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tablero.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.add(Tablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 750, 710));

        jPanel3.setBackground(new java.awt.Color(255, 0, 51));
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 80, 300, 760));

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));
        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 310, 760));

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Numero de Jugadas:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 850, -1, -1));

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("American Typewriter", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setFont(new java.awt.Font("American Typewriter", 1, 14)); // NOI18N
        jButton1.setText("Retirarse");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1274, 20, 130, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1430, 910));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String villano = "", heroe = "";
        //AQUII 
        if (respUsuario == null) {

            for (int i = 0; i < this.ListadeUsuarios.size(); i++) {

                if (!ListadeUsuarios.get(i).getnombre().equals(this.nombreusuario)) {

                    respUsuario = ListadeUsuarios.get(i).getnombre();
                }
            }
        }
        if (resptipopartida.equals("Villano")) {
            villano = nombreusuario;

            heroe = respUsuario;
        } else {//turno heroe
            heroe = nombreusuario;

            villano = respUsuario;
        }

        if (this.turno == true) {
            int answ = JOptionPane.showConfirmDialog(null, "Esta Seguro Que Deseas Rendirte?");

            if (answ == JOptionPane.YES_NO_OPTION) {
                for (int i = 0; i < this.ListadeUsuarios.size(); i++) {
                    if (ListadeUsuarios.get(i).getnombre().equals(villano)) {
                        ListadeUsuarios.get(i).setpuntos(ListadeUsuarios.get(i).getpuntos() + 3);
                    }
                }
                DateTimeFormatter fechapartida = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime fecha = LocalDateTime.now();
                JOptionPane.showMessageDialog(null, "Gano: " + villano + " porque el Heroe " + heroe + " se ha rendido");
                this.ListadeLoggs.add(new Loggs(villano + " usando villanos ha ganado ya que" + heroe + " usando heroes se ha retirado del juego" + fechapartida.format(fecha), "Villano"));
                partidasjugadasvillanos++;
                MenuPrincipal mp3 = new MenuPrincipal(this.ListadeUsuarios, this.ListadeLoggs, nombreusuario, mododejuego_Tutorial);
                mp3.setVisible(true);
                this.setVisible(false);
            }
            if (answ == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Has seleccionado no rendirte");
            }
        } else {
            int answ = JOptionPane.showConfirmDialog(null, "Esta Seguro Que Deseas Rendirte?");

            if (answ == JOptionPane.YES_NO_OPTION) {
                for (int i = 0; i < this.ListadeUsuarios.size(); i++) {
                    if (ListadeUsuarios.get(i).getnombre().equals(heroe)) {
                        ListadeUsuarios.get(i).setpuntos(ListadeUsuarios.get(i).getpuntos() + 3);
                    }
                }
                DateTimeFormatter fechapartida = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime fecha = LocalDateTime.now();
                JOptionPane.showMessageDialog(null, "Gano: " + heroe + " porque el Villano " + villano + " se ha rendido");
                this.ListadeLoggs.add(new Loggs(heroe + " usando heroes ha ganado ya que " + villano + " usando villanos se ha retirado del juego " + fechapartida.format(fecha), "Heroes"));
                MenuPrincipal mp3 = new MenuPrincipal(this.ListadeUsuarios, this.ListadeLoggs, nombreusuario, mododejuego_Tutorial);
                mp3.setVisible(true);
                partidasjugadasheroes++;
                this.setVisible(false);
            }
            if (answ == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Has seleccionado no rendirte");
            }
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Stratego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stratego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stratego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stratego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stratego(null, null, null, true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Tablero;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
