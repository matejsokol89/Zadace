package sokol.ljetnizadatak.view;

import sokol.ljetnizadatak.view.NbaTimovi;
import sokol.ljetnizadatak.model.NbaTeam;


public class Menu extends javax.swing.JFrame {
    
private String gitUrl =  new String();

    public Menu() {
        initComponents();
        gitUrl = "https://github.com/matejsokol89/Zadace/tree/master/LjetniZadatak/src/sokol/ljetnizadatak";
               
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNbaTimovi = new javax.swing.JButton();
        btnEraDijagram = new javax.swing.JButton();
        lblSlika = new javax.swing.JLabel();
        lblUrlGit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 255));

        btnNbaTimovi.setBackground(new java.awt.Color(255, 102, 102));
        btnNbaTimovi.setFont(new java.awt.Font("Snap ITC", 1, 18)); // NOI18N
        btnNbaTimovi.setForeground(new java.awt.Color(51, 51, 255));
        btnNbaTimovi.setText("Nba Timovi");
        btnNbaTimovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNbaTimoviActionPerformed(evt);
            }
        });

        btnEraDijagram.setBackground(new java.awt.Color(255, 102, 102));
        btnEraDijagram.setFont(new java.awt.Font("Snap ITC", 1, 18)); // NOI18N
        btnEraDijagram.setForeground(new java.awt.Color(51, 51, 255));
        btnEraDijagram.setText("ERA Dijagram");
        btnEraDijagram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEraDijagramActionPerformed(evt);
            }
        });

        lblSlika.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sokol\\Documents\\NetBeansProjects\\LjetniZadatak\\nbasmall.png")); // NOI18N

        lblUrlGit.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        lblUrlGit.setForeground(new java.awt.Color(51, 51, 255));
        lblUrlGit.setText("Otvori link");
        lblUrlGit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUrlGitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblSlika, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNbaTimovi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEraDijagram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(lblUrlGit, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnNbaTimovi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btnEraDijagram, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSlika, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblUrlGit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNbaTimoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNbaTimoviActionPerformed
        NbaTimovi nbaBaza = new NbaTimovi();
        nbaBaza.setVisible(true);

        
    }//GEN-LAST:event_btnNbaTimoviActionPerformed

    private void btnEraDijagramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEraDijagramActionPerformed
    EraDijagram era = new EraDijagram();
    era.setVisible(true);
    }//GEN-LAST:event_btnEraDijagramActionPerformed

    private void lblUrlGitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUrlGitMouseClicked
        NbaTimovi.openUrl(gitUrl);
    }//GEN-LAST:event_lblUrlGitMouseClicked

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEraDijagram;
    private javax.swing.JButton btnNbaTimovi;
    private javax.swing.JLabel lblSlika;
    private javax.swing.JLabel lblUrlGit;
    // End of variables declaration//GEN-END:variables
}
