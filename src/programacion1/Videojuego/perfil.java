
package programacion1.Videojuego;

import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author ruthreyes
 */
public class perfil extends javax.swing.JFrame {

    ArrayList<Usuario> ListadeUsuarios;
    ArrayList<Loggs> ListadeLoggs;
    int puntos, partidasheroes, partidasvillanos;
    String GbUsuario;
    boolean mododejuego_Tutorial=true;
    public perfil(ArrayList<Usuario> AtributListadeUsuarios,ArrayList<Loggs> AtributListadeLoggs, String nombreusuario,boolean mododejuego) {
       
        this.GbUsuario = nombreusuario;
        this.ListadeUsuarios = AtributListadeUsuarios;
        this.ListadeLoggs=AtributListadeLoggs;
              mododejuego_Tutorial=mododejuego;
        for (int i = 0; i < ListadeUsuarios.size(); i++) {

            if (this.ListadeUsuarios.get(i).getnombre().equals(nombreusuario)) {
                puntos = this.ListadeUsuarios.get(i).getpuntos();
            }
            partidasheroes = this.ListadeUsuarios.get(i).getpartidaheroes();
            partidasvillanos = this.ListadeUsuarios.get(i).getpartidavillanos();

        }

//despues del initcomponents porque primero se debe crear la ventana para añadirle los botones
        initComponents();

        jLabel1.setText("Nombre: " + nombreusuario);
        jLabel2.setText("Puntos: " + puntos);
        jLabel3.setText("Partidas Villanos: " + partidasvillanos);
        jLabel4.setText("Partidas Heroes: " + partidasheroes);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setFont(new java.awt.Font("American Typewriter", 1, 14)); // NOI18N
        jButton1.setText("LOG DE MIS ULTIMOS JUEGOS");
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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 270, 30));

        jButton2.setBackground(new java.awt.Color(255, 0, 51));
        jButton2.setFont(new java.awt.Font("American Typewriter", 1, 14)); // NOI18N
        jButton2.setText("CAMBIAR MI PASSWORD");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 270, 30));

        jButton3.setBackground(new java.awt.Color(255, 0, 51));
        jButton3.setFont(new java.awt.Font("American Typewriter", 1, 14)); // NOI18N
        jButton3.setText("ELIMINAR MI CUENTA");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 270, 30));

        jLabel1.setBackground(new java.awt.Color(255, 51, 0));
        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 12)); // NOI18N
        jLabel2.setText("Puntos:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Partidas Villanos:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Partidas Heroes:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, -1));

        jButton4.setFont(new java.awt.Font("American Typewriter", 1, 12)); // NOI18N
        jButton4.setText("Volver");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programacion1/Videojuego/Imagenes/Configuracion/Configuracion (2) (1).png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

        for (int i = 0; i < ListadeUsuarios.size(); i++) {

            if (this.ListadeUsuarios.get(i).getnombre().equals(this.GbUsuario)) {
                this.ListadeUsuarios.remove(i);
            }

            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            MenuInicial Mi = new MenuInicial(this.ListadeUsuarios,this.ListadeLoggs,mododejuego_Tutorial);
            Mi.setVisible(true);
            this.setVisible(false);

        }


    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        String contraactual = JOptionPane.showInputDialog(null, "Escriba la contraseña actual");

        for (int i = 0; i < ListadeUsuarios.size(); i++) {

            //aqui estamos buscando la contraseña actual dentro del array para cambiarla
            if (ListadeUsuarios.get(i).getnombre().equals(GbUsuario)) {

                if (ListadeUsuarios.get(i).getcontra().equals(contraactual)) {

                    String nuevacontra = JOptionPane.showInputDialog(null, "Escriba la nueva contraseña: ");
                    while (nuevacontra.length() != 5) {
                        nuevacontra = JOptionPane.showInputDialog(null, "Contraseña invalida,ingrese una de 5 caracteres");

                    }
                    this.ListadeUsuarios.get(i).setcontra(nuevacontra);

                } else {

                    JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");

                }

            }

        }


    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

      MostrarLoggs mlgs=new MostrarLoggs(this.ListadeUsuarios,this.ListadeLoggs, GbUsuario,mododejuego_Tutorial);
      mlgs.setVisible(true);
      this.setVisible(false);
            
        
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked

        MenuPrincipal mp = new MenuPrincipal(this.ListadeUsuarios,this.ListadeLoggs, GbUsuario,mododejuego_Tutorial);
        mp.setVisible(true);
        this.setVisible(false);


    }//GEN-LAST:event_jButton4MouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new perfil(null, null,null,true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
