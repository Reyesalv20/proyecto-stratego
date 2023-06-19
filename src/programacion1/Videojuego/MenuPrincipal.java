
package programacion1.Videojuego;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ruthreyes
 */
public class MenuPrincipal extends javax.swing.JFrame {
    ArrayList<Loggs> ListadeLoggs;
    ArrayList<Usuario> ListadeUsuarios;
    String nombreusuario;
    boolean mododejuego_Tutorial=true;
    //es usa el string de nombreusuario ya que le estamos mantando que usario es a perfil
    public MenuPrincipal(ArrayList<Usuario> AtributListadeUsuarios,ArrayList<Loggs> AtributListadeLoggs, String nombreusuario,boolean mododejuego) {
        ListadeLoggs=AtributListadeLoggs;
        this.nombreusuario = nombreusuario;
        ListadeUsuarios = AtributListadeUsuarios;
      mododejuego_Tutorial=mododejuego;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setFont(new java.awt.Font("American Typewriter", 0, 18)); // NOI18N
        jButton6.setText("STRATEGO");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 160, 70));

        jButton7.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        jButton7.setText("CONFIGURACION");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 150, 30));

        jButton8.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        jButton8.setText(" PERFIL");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, 30));

        jButton9.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        jButton9.setText("UNIVERSO MARVEL");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 30));

        jButton10.setBackground(new java.awt.Color(204, 204, 204));
        jButton10.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        jButton10.setText("CERRAR SESION");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 10, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programacion1/Videojuego/Imagenes/Configuracion/Configuracion (1) (1).png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked

        perfil pf = new perfil(this.ListadeUsuarios,this.ListadeLoggs, nombreusuario,mododejuego_Tutorial);

        pf.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked

       //AQUIII
        int answ = JOptionPane.showConfirmDialog( null, "Esta Seguro que quiere cerrar sesion?"
    ); 

    if ( answ == JOptionPane.YES_NO_OPTION ) {
      
    MenuInicial mi=new MenuInicial(ListadeUsuarios,ListadeLoggs,mododejuego_Tutorial);
    mi.setVisible(true);
this.setVisible(false);
    }
       

    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        
        if(this.ListadeUsuarios.size()<2){
            
         JOptionPane.showMessageDialog(null, "Tiene que crear mas de 1 usuarios para poder jugar");    
         
         return;
        }else{
        
        Stratego stg = new Stratego(ListadeUsuarios,this.ListadeLoggs,nombreusuario,mododejuego_Tutorial);
        stg.setVisible(true);
        this.setVisible(false);
        } 
    
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
      
       UniversoMarvel um=new UniversoMarvel(ListadeUsuarios, ListadeLoggs,nombreusuario,mododejuego_Tutorial); 
       um.setVisible(true);
       this.setVisible(false);
        
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
       
        Configuracion cf=new Configuracion(ListadeUsuarios,this.ListadeLoggs,nombreusuario,mododejuego_Tutorial);
        cf.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton7MouseClicked

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal(null, null,null,true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
