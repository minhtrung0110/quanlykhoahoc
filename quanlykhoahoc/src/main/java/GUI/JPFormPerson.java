/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.PersonBUS;
import DTO.PersonDTO;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khôi
 */
public class JPFormPerson extends javax.swing.JDialog {

    DefaultTableModel model=new DefaultTableModel();
    public JPFormPerson(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public JPFormPerson() throws Exception{
        setModal(true); 
        initComponents();
        txTim.requestFocus();
        this.LoadDSKH();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKH = new javax.swing.JTable();
        btXacNhan = new javax.swing.JButton();
        btDong = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txPersonID = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btTim = new javax.swing.JButton();
        cbbTim = new javax.swing.JComboBox<>();
        txTim = new javax.swing.JTextField();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(500, 150, 0, 0));

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));

        jLabel1.setBackground(new java.awt.Color(51, 0, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("LIST TEACHER");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PersonID", "FirstName", "LastName", "HireDate", "EnrollmentDate"
            }
        ));
        tbKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbKH);
        if (tbKH.getColumnModel().getColumnCount() > 0) {
            tbKH.getColumnModel().getColumn(0).setMinWidth(70);
            tbKH.getColumnModel().getColumn(1).setMinWidth(150);
            tbKH.getColumnModel().getColumn(4).setMinWidth(150);
        }

        btXacNhan.setBackground(new java.awt.Color(0, 153, 0));
        btXacNhan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btXacNhan.setForeground(new java.awt.Color(255, 255, 255));
        btXacNhan.setText("CONFIRM");
        btXacNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btXacNhanMouseClicked(evt);
            }
        });

        btDong.setBackground(new java.awt.Color(255, 153, 0));
        btDong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btDong.setForeground(new java.awt.Color(51, 51, 51));
        btDong.setText("CANCEL");
        btDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDongMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("PersonID :");

        txPersonID.setEditable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "SEARCH", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        btTim.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btTim.setText("SEARCH");
        btTim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btTimMouseClicked(evt);
            }
        });

        cbbTim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PersonID", "FirstName", "LastName" }));
        cbbTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimActionPerformed(evt);
            }
        });

        txTim.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(cbbTim, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txTim, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btTim)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbTim, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txTim, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btTim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(btXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btDong, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txPersonID, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txPersonID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public int getPersonID(){
        int personID=Integer.parseInt(txPersonID.getText());
        return personID;
    }
    private void btXacNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btXacNhanMouseClicked
         dispose();
    }//GEN-LAST:event_btXacNhanMouseClicked

    private void tbKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKHMouseClicked
       Click();
    }//GEN-LAST:event_tbKHMouseClicked

    private void btTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTimMouseClicked
       Tim();
    }//GEN-LAST:event_btTimMouseClicked

    private void btDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDongMouseClicked
        txTim.setText("");
        setVisible(false);
    }//GEN-LAST:event_btDongMouseClicked

    private void cbbTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbTimActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JPFormPerson dialog = null;
                try {
                    dialog = new JPFormPerson();
                } catch (Exception ex) {
                    Logger.getLogger(JPFormPerson.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                
            }
        });
    }
/***********************************ĐỌC DSKH******************************************/
    public void outModel(DefaultTableModel model,ArrayList<PersonDTO> listPerson){
        Vector row;
        model.setRowCount(0);
        for(PersonDTO kh: listPerson){
            row=new Vector();
            row.add(kh.getPersonID());
            row.add(kh.getFirstname());
            row.add(kh.getLastname());
            row.add(kh.getHireDate());
            row.add(kh.getEnrollmentDate());
             model.addRow(row);
        }
        tbKH.setModel(model);
    }
    public void LoadDSKH() throws Exception{
        PersonBUS khBUS=new PersonBUS();
        Vector header=new Vector();
        header.add("TeacherID ");
        header.add("FirstName");
        header.add("LastName");
        header.add("HireDate");
        header.add("EnrollmentDate");
        if(model.getRowCount()==0)
            model=new DefaultTableModel(header,0);
        if(khBUS.getListPerson()==null) khBUS.loadDSPerson();
        ArrayList<PersonDTO> listPerson=new ArrayList<>();
        listPerson=khBUS.getListPerson();
        outModel(model,listPerson);
    }
/************************lấy mã kh*****************************************/
    public String maKH(){
        int i=tbKH.getSelectedRow();
        String makh=txPersonID.getText();
        return makh;
    }
    public void Click(){
        int i=tbKH.getSelectedRow();
        txPersonID.setText(tbKH.getModel().getValueAt(i,0).toString());
    }
//tìm***********************************************************************
    public void Tim(){
        PersonBUS kh=new PersonBUS();
        String a=cbbTim.getSelectedItem().toString();
        ArrayList<PersonDTO> DSKH=new ArrayList<>();
        ArrayList<PersonDTO> kh1=new ArrayList<>();
        DSKH=kh.getListPerson();
        if((a.equals("PersonID") || a.equals("FirstName") || a.equals("LastName")) && txTim.getText().isEmpty())
            outModel(model,DSKH);
        else if(a.equals("PersonID")){
            kh1=kh.searchPersonWithID(Integer.parseInt(txTim.getText()));
            outModel(model,kh1);
        }else if(a.equals("FirstName")){
          kh1=kh.searchPersonWithFirstName(txTim.getText());
            outModel(model,kh1);
        }else if(a.equals("LastName")){
            kh1=kh.searchPersonWithLastName(txTim.getText());
            outModel(model,kh1);
        }     
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDong;
    private javax.swing.JButton btTim;
    private javax.swing.JButton btXacNhan;
    private javax.swing.JComboBox<String> cbbTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbKH;
    private javax.swing.JTextField txPersonID;
    private javax.swing.JTextField txTim;
    // End of variables declaration//GEN-END:variables
}
