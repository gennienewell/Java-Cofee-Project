/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getInt;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

/**
 *
 * @author genni
 */
public class CoffeeShop extends javax.swing.JFrame {
        ImageIcon imgCS = new ImageIcon("coffeeShop.png");
    
    
    //Constructor
    public CoffeeShop() {
        initComponents();
        lblPic.setIcon(imgCS);
    }
    
    public  static void  CreateTables() {
        try {
        
        final String DB_Url = "jdbc:derby://localhost:1527/dbCoffeeStoreData";
        Connection conn = DriverManager.getConnection(DB_Url,"root", "password");
        Statement statement = conn.createStatement();
        //Drop Tables
        statement.execute("DROP TABLE  CustomerTable");
        statement.execute("DROP TABLE  CoffeeTable");
        statement.execute("DROP TABLE  OrdersTable");
        // Cutomer Table :    
        statement.execute("Create Table CustomerTable (customerNumber varchar(25)"
                + ",firstName varchar(25),lastName varchar(25),street varchar(25)"
                + ",city varchar (30),state varchar (30),ZIP varchar (30),"
                + "phone varchar (30),EmailAddress varchar (30),"
                + "creditlimit DOUBLE)");
        // Coffee Table:       
        statement.execute("Create Table CoffeeTable (coffeeId varchar(25), coffeeName varchar(25),"
                + " coffeeDescription varchar(25), price Double, numberInStock Integer)");
        // Orders Table:       
        statement.execute("Create Table OrdersTable (orderId varchar(25), customerId varchar(25),"
                + " coffeeId varchar(25), numberOrdered Double , total Double)");
        
        }
        catch(SQLException ex) {
        System.out.print(ex.getMessage());
         }   
    }
    //Insert Tables
    public  static void  InsertTables() 
    {
    try {
        
        final String DB_Url = "jdbc:derby://localhost:1527/dbCoffeeStoreData";
        Connection conn = DriverManager.getConnection(DB_Url,"root", "password");
        
        PreparedStatement statement1 = conn.prepareStatement("INSERT INTO CustomerTable VALUES "
                + "('111111','Gene','smith','1035 street way',"
                + "'Winston', 'NC','22222','3636656','nn@gmail',0.7)");
        statement1.executeUpdate();
        
        PreparedStatement statement2 = conn.prepareStatement("INSERT INTO CustomerTable VALUES "
                + "('222222','Larry','james','1037 street dr',"
                + "'salem', 'NC','33333','3959595','ff@gmail',0.8)");
        statement2.executeUpdate();
        
        PreparedStatement statement3 = conn.prepareStatement("INSERT INTO CustomerTable VALUES "
                + "('333333','curly','brown','1038 tech way',"
                + "'james', 'NC','44444','989898','ss@gmail',0.9)");
        statement3.executeUpdate();
        
        PreparedStatement statement4 = conn.prepareStatement("INSERT INTO CustomerTable VALUES "
                + "('444444','moe','jackson','1039 ebert way',"
                + "'small', 'NC','55555','2323232','qq@gmail',0.4)");
        statement4.executeUpdate();
        
        PreparedStatement statement5 = conn.prepareStatement("INSERT INTO CustomerTable VALUES "
                + "('555555','steve','green','1040 lexus way',"
                + "'town', 'NC','66666','010010','tt@gmail',0.3)");
        statement5.executeUpdate();
        //CoffeeTable inserts
        PreparedStatement statement6 = conn.prepareStatement("INSERT INTO CoffeeTable VALUES "
                + "('55555','chocalate','Tasty',20,80)");
        statement6.executeUpdate();
        
        PreparedStatement statement7 = conn.prepareStatement("INSERT INTO CoffeeTable VALUES "
                + "('44444','Swirl','Best',40,20)");
        statement7.executeUpdate();
        
        PreparedStatement statement8 = conn.prepareStatement("INSERT INTO CoffeeTable VALUES "
                + "('33333','cherry','great',60,70)");
        statement8.executeUpdate();
        
        PreparedStatement statement9 = conn.prepareStatement("INSERT INTO CoffeeTable VALUES "
                + "('22222','vinilla','best seller',80,60)");
        statement9.executeUpdate();
        
        PreparedStatement statement10 = conn.prepareStatement("INSERT INTO CoffeeTable VALUES "
                + "('11111','lime','wonderful',90,50)");
        statement10.executeUpdate();
        //Orders Table
        PreparedStatement statement11 = conn.prepareStatement("INSERT INTO OrdersTable VALUES "
                + "('10','69857','2323',20,70 )");
        statement11.executeUpdate();
        PreparedStatement statement12 = conn.prepareStatement("INSERT INTO OrdersTable VALUES "
                + "('10','69857','3232',30,60 )");
        statement12.executeUpdate();
        PreparedStatement statement13 = conn.prepareStatement("INSERT INTO OrdersTable VALUES "
                + "('11','69857','1212',90,50 )");
        statement13.executeUpdate();
        PreparedStatement statement14 = conn.prepareStatement("INSERT INTO OrdersTable VALUES "
                + "('12','69857','6565',80,20 )");
        statement14.executeUpdate();
        PreparedStatement statement15 = conn.prepareStatement("INSERT INTO OrdersTable VALUES "
                + "('12','69857','6565',20,10 )");
        statement15.executeUpdate();
        
        }
        catch(SQLException ex) {
        System.out.print(ex.getMessage());
         }   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPic = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnCreateDB = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuDisplayCoffees = new javax.swing.JMenuItem();
        MenuDisplayCustomers = new javax.swing.JMenuItem();
        MenuDisplayOrdersForCustomer = new javax.swing.JMenuItem();
        MenuNewCustomer = new javax.swing.JMenuItem();
        MenuNewOrder = new javax.swing.JMenuItem();
        MenuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MenuAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" FT-Coffee Shop");

        jLabel1.setText("\"The Best Coffe in Town Come on in and Try our Famous Lime Coffee!\"");

        btnCreateDB.setText("Create/Reset  Databases");
        btnCreateDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateDBActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        MenuDisplayCoffees.setText("Display Coffee Table");
        MenuDisplayCoffees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuDisplayCoffeesActionPerformed(evt);
            }
        });
        jMenu1.add(MenuDisplayCoffees);

        MenuDisplayCustomers.setText("Display Customers Table");
        MenuDisplayCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuDisplayCustomersActionPerformed(evt);
            }
        });
        jMenu1.add(MenuDisplayCustomers);

        MenuDisplayOrdersForCustomer.setText("Display Selected Orders ");
        MenuDisplayOrdersForCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuDisplayOrdersForCustomerActionPerformed(evt);
            }
        });
        jMenu1.add(MenuDisplayOrdersForCustomer);

        MenuNewCustomer.setText("New Customer");
        MenuNewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuNewCustomerActionPerformed(evt);
            }
        });
        jMenu1.add(MenuNewCustomer);

        MenuNewOrder.setText("New Order");
        MenuNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuNewOrderActionPerformed(evt);
            }
        });
        jMenu1.add(MenuNewOrder);

        MenuExit.setText("Exit");
        MenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuExitActionPerformed(evt);
            }
        });
        jMenu1.add(MenuExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("About us");

        MenuAbout.setText("About:");
        MenuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAboutActionPerformed(evt);
            }
        });
        jMenu2.add(MenuAbout);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblPic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btnCreateDB)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCreateDB)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAboutActionPerformed
        // Shows Information About Program:
        JOptionPane.showMessageDialog(null,"Coffee shop program that keeps track of Customers orders!");
    }//GEN-LAST:event_MenuAboutActionPerformed

    private void MenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuExitActionPerformed
         //Exits the Program!:
        System.exit(0); // stop program  
    }//GEN-LAST:event_MenuExitActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // Does Nothing!
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void MenuDisplayCoffeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDisplayCoffeesActionPerformed
        // Displays Coffee Table form:
        new DisplayCoffee().setVisible(true);
    }//GEN-LAST:event_MenuDisplayCoffeesActionPerformed

    private void MenuDisplayCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDisplayCustomersActionPerformed
        // Displays Customers Table form:
        new DisplayCustomers().setVisible(true);
    }//GEN-LAST:event_MenuDisplayCustomersActionPerformed

    private void MenuNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuNewCustomerActionPerformed
        // Displays New Customers window form
        new NewCustomers().setVisible(true);
    }//GEN-LAST:event_MenuNewCustomerActionPerformed

    private void MenuDisplayOrdersForCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDisplayOrdersForCustomerActionPerformed
        // Displays Orders  Table form
        new DisplayOrders().setVisible(true);
    }//GEN-LAST:event_MenuDisplayOrdersForCustomerActionPerformed

    private void MenuNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuNewOrderActionPerformed
         // Displays New Order Window  form
        new NewOrder().setVisible(true);
    }//GEN-LAST:event_MenuNewOrderActionPerformed

    private void btnCreateDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateDBActionPerformed
        //Creates Initial DataBases and Inserts
        CreateTables();
        InsertTables();
    }//GEN-LAST:event_btnCreateDBActionPerformed

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
            java.util.logging.Logger.getLogger(CoffeeShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CoffeeShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CoffeeShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CoffeeShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CoffeeShop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuAbout;
    private javax.swing.JMenuItem MenuDisplayCoffees;
    private javax.swing.JMenuItem MenuDisplayCustomers;
    private javax.swing.JMenuItem MenuDisplayOrdersForCustomer;
    private javax.swing.JMenuItem MenuExit;
    private javax.swing.JMenuItem MenuNewCustomer;
    private javax.swing.JMenuItem MenuNewOrder;
    private javax.swing.JButton btnCreateDB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblPic;
    // End of variables declaration//GEN-END:variables
}
