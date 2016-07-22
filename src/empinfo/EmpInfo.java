/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;

/**
 *
 * A project to add employee information and the work information
 * 
 * LECTURER: 
 * MR. MUTUVI STEVE
 * 
 * DEVELOPERS:
 * CIT-221-060/2014	-	JOSHUA ONGAGA ONGWAE
 * CIT-221-052/2014	-	FREDRICK MUIRURI KAMAU
 * CIT-221-010/2014	-	FELIX WATILAH WAKHALE
 * CIT-221-029/2014     -       SHADRACK KIPKIRUI
 */
public class EmpInfo extends javax.swing.JFrame {
    ResultSet Rset;
    Connection con;
    Statement stmt;

    /**
     * Creates new form TabbedPane
     */
    public EmpInfo() {
        initComponents();
        ComboEmp();
        buttGroup();
        bGroup();
    }
    
    //a method to insert Employee Name and Employee type to database employee (table:empinfo)
    private void AddMySql(){
        //Database connection
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","@watilah9911");
            stmt = con.createStatement();    
            
            stmt.executeUpdate("insert into empl (EmpName,EmpType) values('"+empNameTextField.getText()+"','"+empTypeComboBox.getSelectedItem()+"')");
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            notiLabel.setText(e.toString());
        }
    }
    
    //a method to insert lec information into table:empl)
    private void LectMySql(){
        //Database connection
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","@watilah9911");
            stmt = con.createStatement();    
            
            stmt.executeUpdate("update empl set Dept='"+deptTextField.getText()+"',EmplStatus= '"+rLabel.getText()+"' where EmpName='"+empNameTextField.getText()+"'");
            notiLabel.setText("Records for Lecturer, updated successfully");
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            notiLabel.setText(e.toString());
        }
    }
    
    // a method to insert CampName, ProgName and YOS into the database (table:Stude)
    private void StudeMySql(){
        //Database connection
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","@watilah9911");
            stmt = con.createStatement();    
            
            stmt.executeUpdate("update empl set CampName='"+campNameTextField.getText()+"', ProgName='"+progNameTextField.getText()+"',YOS='"+yosComboBox.getSelectedItem()+"' where EmpName='"+empNameTextField.getText()+"'");
            notiLabel.setText("Records for Student, updated successfully");
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            notiLabel.setText(e.toString());
        }
    }
    
     private void SStaffMySql(){
        //Database connection
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","@watilah9911");
            Statement stmnt = connect.createStatement();    
            
            stmnt.executeUpdate("update empl set SArea='"+sAreaTextField.getText()+"',"
                    + "EmplStatus='"+ssLabel.getText()+"' "
                    + "where EmpName='"+empNameTextField.getText()+"'");
            notiLabel.setText("Records for Support Staff, updated successfully");
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            notiLabel.setText(e.toString());
        }
    }
    
    //a method to insert hours worked and pay rate into the database (table: work)
    private void WorkMySql(){
        //Database connection
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","@watilah9911"); 
            stmt = con.createStatement();
                
            stmt.executeUpdate("update empl set HrsWorked='"+hrsWorkedTextField.getText()+"',PayRate='"+payRateTextField.getText()+"',Amount='"+amountLabel.getText()+"'where EmpName='"+empNameTextField.getText()+"'");
            notiLabel.setText("Records for Work information, updated successfully!");
        }
        catch(ClassNotFoundException | SQLException e){
            notiLabel.setText(e.toString());
        }
    }
    //method to get names from the database
    private void ComboEmp(){
        getEmpNameComboBox.setSelectedItem("");
        getEmpNameComboBox.setEnabled(true);
        try{
            String sql="select * from empl";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","@watilah9911");
            stmt = con.prepareStatement(sql);    
            Rset = stmt.executeQuery(sql);
            
            while (Rset.next()){
                String name=Rset.getString("EmpName");
                getEmpNameComboBox.addItem(name);
            }
        }
        catch(ClassNotFoundException | SQLException e){
            notiLabel.setText(e.toString());
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

        empPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        empNameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        empTypeComboBox = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tabsPanel = new javax.swing.JPanel();
        mainTabbedPane = new javax.swing.JTabbedPane();
        LecPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        deptTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        permRadioButton = new javax.swing.JRadioButton();
        nPermRadioButton = new javax.swing.JRadioButton();
        addLecButton = new javax.swing.JButton();
        SStaffPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        campNameTextField = new javax.swing.JTextField();
        progNameTextField = new javax.swing.JTextField();
        yosComboBox = new javax.swing.JComboBox();
        addStudButton = new javax.swing.JButton();
        StudentPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        sAreaTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        unionRadioButton = new javax.swing.JRadioButton();
        nUnionRadioButton = new javax.swing.JRadioButton();
        addSStaffButton = new javax.swing.JButton();
        titlePanel = new javax.swing.JPanel();
        rLabel = new javax.swing.JLabel();
        ssLabel = new javax.swing.JLabel();
        amountLabel = new javax.swing.JLabel();
        icon = new javax.swing.JPanel();
        iconLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        workPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        getEmpNameComboBox = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        hrsWorkedTextField = new javax.swing.JTextField();
        payRateTextField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        addWorkButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        printPanel = new javax.swing.JPanel();
        printScrollPane = new javax.swing.JScrollPane();
        printTextArea = new javax.swing.JTextArea();
        notiLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Information");

        empPanel.setBackground(new java.awt.Color(2, 39, 77));
        empPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Employee Name:");

        empNameTextField.setBackground(new java.awt.Color(51, 51, 51));
        empNameTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        empNameTextField.setForeground(new java.awt.Color(255, 255, 255));
        empNameTextField.setMaximumSize(new java.awt.Dimension(14, 27));
        empNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empNameTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Type of Employee:");

        empTypeComboBox.setBackground(new java.awt.Color(51, 51, 51));
        empTypeComboBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        empTypeComboBox.setForeground(new java.awt.Color(255, 255, 255));
        empTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lecturer", "Student", "Support Staff" }));
        empTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empTypeComboBoxActionPerformed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(0, 51, 51));
        jLabel16.setFont(new java.awt.Font("Bleeding Cowboys", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Add Employee");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout empPanelLayout = new javax.swing.GroupLayout(empPanel);
        empPanel.setLayout(empPanelLayout);
        empPanelLayout.setHorizontalGroup(
            empPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, empPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(empPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(empPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(empPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(empTypeComboBox, 0, 299, Short.MAX_VALUE)
                        .addComponent(empNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)))
                .addGap(61, 61, 61))
        );
        empPanelLayout.setVerticalGroup(
            empPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(empPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(empPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(empPanelLayout.createSequentialGroup()
                        .addGroup(empPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(empNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(empTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabsPanel.setBackground(new java.awt.Color(51, 51, 51));
        tabsPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        mainTabbedPane.setBackground(new java.awt.Color(0, 51, 51));
        mainTabbedPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mainTabbedPane.setForeground(new java.awt.Color(255, 255, 255));
        mainTabbedPane.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        LecPanel.setBackground(new java.awt.Color(2, 39, 76));
        LecPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LecPanel.setForeground(new java.awt.Color(0, 51, 153));
        LecPanel.setFont(new java.awt.Font("Amperzand", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Department:");

        deptTextField.setBackground(new java.awt.Color(51, 51, 51));
        deptTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        deptTextField.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Employment Status:");

        permRadioButton.setBackground(new java.awt.Color(2, 39, 76));
        permRadioButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        permRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        permRadioButton.setSelected(true);
        permRadioButton.setText("Permanent");
        permRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permRadioButtonActionPerformed(evt);
            }
        });

        nPermRadioButton.setBackground(new java.awt.Color(2, 39, 76));
        nPermRadioButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        nPermRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        nPermRadioButton.setText("Not Permanent");
        nPermRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nPermRadioButtonActionPerformed(evt);
            }
        });

        addLecButton.setBackground(new java.awt.Color(0, 0, 0));
        addLecButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        addLecButton.setForeground(new java.awt.Color(255, 255, 255));
        addLecButton.setText("ADD");
        addLecButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLecButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LecPanelLayout = new javax.swing.GroupLayout(LecPanel);
        LecPanel.setLayout(LecPanelLayout);
        LecPanelLayout.setHorizontalGroup(
            LecPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LecPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(LecPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(LecPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addLecButton)
                    .addGroup(LecPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(deptTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(LecPanelLayout.createSequentialGroup()
                            .addComponent(permRadioButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nPermRadioButton))))
                .addGap(53, 53, 53))
        );
        LecPanelLayout.setVerticalGroup(
            LecPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LecPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(LecPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deptTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(36, 36, 36)
                .addGroup(LecPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nPermRadioButton)
                    .addComponent(permRadioButton)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(addLecButton)
                .addGap(33, 33, 33))
        );

        mainTabbedPane.addTab("Lecturer", LecPanel);

        SStaffPanel.setBackground(new java.awt.Color(2, 39, 76));
        SStaffPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SStaffPanel.setFont(new java.awt.Font("Argor Got Scaqh", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Campus Name:");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Programme Name:");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Year Of Study:");

        campNameTextField.setBackground(new java.awt.Color(51, 51, 51));
        campNameTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        campNameTextField.setForeground(new java.awt.Color(255, 255, 255));

        progNameTextField.setBackground(new java.awt.Color(51, 51, 51));
        progNameTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        progNameTextField.setForeground(new java.awt.Color(255, 255, 255));

        yosComboBox.setBackground(new java.awt.Color(51, 51, 51));
        yosComboBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        yosComboBox.setForeground(new java.awt.Color(255, 255, 255));
        yosComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "First Year", "Second Year", "Third Year ", "Fourth Year", "Fifth Year" }));

        addStudButton.setBackground(new java.awt.Color(0, 0, 0));
        addStudButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        addStudButton.setForeground(new java.awt.Color(255, 255, 255));
        addStudButton.setText("ADD");
        addStudButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SStaffPanelLayout = new javax.swing.GroupLayout(SStaffPanel);
        SStaffPanel.setLayout(SStaffPanelLayout);
        SStaffPanelLayout.setHorizontalGroup(
            SStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SStaffPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(SStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(SStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addStudButton)
                    .addComponent(progNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );
        SStaffPanelLayout.setVerticalGroup(
            SStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SStaffPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(SStaffPanelLayout.createSequentialGroup()
                        .addGroup(SStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(SStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(progNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(yosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(addStudButton)
                .addGap(20, 20, 20))
        );

        mainTabbedPane.addTab("Student", SStaffPanel);

        StudentPanel.setBackground(new java.awt.Color(2, 39, 76));
        StudentPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        StudentPanel.setFont(new java.awt.Font("Cooper Std Black", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Support Area:");

        sAreaTextField.setBackground(new java.awt.Color(51, 51, 51));
        sAreaTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        sAreaTextField.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Union Status:");

        unionRadioButton.setBackground(new java.awt.Color(2, 39, 76));
        unionRadioButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        unionRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        unionRadioButton.setSelected(true);
        unionRadioButton.setText("Unionized");
        unionRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unionRadioButtonActionPerformed(evt);
            }
        });

        nUnionRadioButton.setBackground(new java.awt.Color(2, 39, 76));
        nUnionRadioButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        nUnionRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        nUnionRadioButton.setText("Not Unionized");
        nUnionRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nUnionRadioButtonActionPerformed(evt);
            }
        });

        addSStaffButton.setBackground(new java.awt.Color(0, 0, 0));
        addSStaffButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        addSStaffButton.setForeground(new java.awt.Color(255, 255, 255));
        addSStaffButton.setText("ADD");
        addSStaffButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSStaffButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StudentPanelLayout = new javax.swing.GroupLayout(StudentPanel);
        StudentPanel.setLayout(StudentPanelLayout);
        StudentPanelLayout.setHorizontalGroup(
            StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addSStaffButton)
                    .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(StudentPanelLayout.createSequentialGroup()
                            .addComponent(unionRadioButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nUnionRadioButton))
                        .addComponent(sAreaTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
        );
        StudentPanelLayout.setVerticalGroup(
            StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentPanelLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sAreaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(32, 32, 32)
                .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unionRadioButton)
                    .addComponent(nUnionRadioButton)
                    .addComponent(jLabel10))
                .addGap(42, 42, 42)
                .addComponent(addSStaffButton)
                .addGap(31, 31, 31))
        );

        mainTabbedPane.addTab("Support Staff", StudentPanel);

        javax.swing.GroupLayout tabsPanelLayout = new javax.swing.GroupLayout(tabsPanel);
        tabsPanel.setLayout(tabsPanelLayout);
        tabsPanelLayout.setHorizontalGroup(
            tabsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTabbedPane)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabsPanelLayout.setVerticalGroup(
            tabsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTabbedPane)
                .addContainerGap())
        );

        titlePanel.setBackground(new java.awt.Color(0, 51, 51));
        titlePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        icon.setBackground(new java.awt.Color(0, 51, 51));
        icon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/uni.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Bleeding Cowboys", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Employees System");

        javax.swing.GroupLayout iconLayout = new javax.swing.GroupLayout(icon);
        icon.setLayout(iconLayout);
        iconLayout.setHorizontalGroup(
            iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, iconLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        iconLayout.setVerticalGroup(
            iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(404, 404, 404)
                .addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ssLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(ssLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(amountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );

        workPanel.setBackground(new java.awt.Color(2, 39, 76));
        workPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.darkGray, null, null));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Employee :");

        getEmpNameComboBox.setBackground(new java.awt.Color(51, 51, 51));
        getEmpNameComboBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getEmpNameComboBox.setForeground(new java.awt.Color(255, 255, 255));
        getEmpNameComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getEmpNameComboBoxActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Hours Worked:");

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Pay Rate:");

        hrsWorkedTextField.setBackground(new java.awt.Color(51, 51, 51));
        hrsWorkedTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        hrsWorkedTextField.setForeground(new java.awt.Color(255, 255, 255));

        payRateTextField.setBackground(new java.awt.Color(51, 51, 51));
        payRateTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        payRateTextField.setForeground(new java.awt.Color(255, 255, 255));

        submitButton.setBackground(new java.awt.Color(0, 0, 0));
        submitButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        submitButton.setText("SUBMIT");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        addWorkButton.setBackground(new java.awt.Color(0, 0, 0));
        addWorkButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        addWorkButton.setForeground(new java.awt.Color(255, 255, 255));
        addWorkButton.setText("ADD");
        addWorkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWorkButtonActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(0, 51, 51));
        jLabel15.setFont(new java.awt.Font("Bleeding Cowboys", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Work Details");

        javax.swing.GroupLayout workPanelLayout = new javax.swing.GroupLayout(workPanel);
        workPanel.setLayout(workPanelLayout);
        workPanelLayout.setHorizontalGroup(
            workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, workPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(workPanelLayout.createSequentialGroup()
                            .addComponent(addWorkButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(submitButton))
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(payRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hrsWorkedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(getEmpNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(68, 68, 68))
        );
        workPanelLayout.setVerticalGroup(
            workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(getEmpNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(30, 30, 30)
                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hrsWorkedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(33, 33, 33)
                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(payRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addWorkButton)
                    .addComponent(submitButton))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        printPanel.setBackground(new java.awt.Color(51, 51, 51));
        printPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        printTextArea.setBackground(new java.awt.Color(0, 51, 51));
        printTextArea.setColumns(20);
        printTextArea.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        printTextArea.setForeground(new java.awt.Color(255, 255, 255));
        printTextArea.setRows(5);
        printTextArea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        printScrollPane.setViewportView(printTextArea);

        javax.swing.GroupLayout printPanelLayout = new javax.swing.GroupLayout(printPanel);
        printPanel.setLayout(printPanelLayout);
        printPanelLayout.setHorizontalGroup(
            printPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(printPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(printScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addContainerGap())
        );
        printPanelLayout.setVerticalGroup(
            printPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(printPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(printScrollPane)
                .addContainerGap())
        );

        notiLabel.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        notiLabel.setForeground(new java.awt.Color(102, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel14.setFont(new java.awt.Font("Bleeding Cowboys", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Developed By: F. W. Watilah ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        closeButton.setBackground(new java.awt.Color(0, 0, 0));
        closeButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        closeButton.setForeground(new java.awt.Color(255, 255, 255));
        closeButton.setText("CLOSE");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("REPORT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(closeButton)
                .addGap(33, 33, 33)
                .addComponent(jButton2)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tabsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(empPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(printPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(workPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(notiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(notiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(empPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tabsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(workPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(printPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //creating a buttonGroup for Permanent and Not permanent RadioButtons
    private void buttGroup(){
        ButtonGroup bg=new ButtonGroup();
     
        bg.add(permRadioButton);
        bg.add(nPermRadioButton);
        
        if(permRadioButton.isSelected()){
            rLabel.setText("Permanent");
            rLabel.setVisible(false);
        }
        else if(nPermRadioButton.isSelected()) {
            rLabel.setText("Not Permanent");
            rLabel.setVisible(false);
        }
    }
    
    //creating a buttonGroup for Unionized and Not Unionized RadioButtons
    private void bGroup(){
        ButtonGroup bg=new ButtonGroup();
     
        bg.add(unionRadioButton);
        bg.add(nUnionRadioButton);
        
        if(unionRadioButton.isSelected()){
            ssLabel.setText("Unionized");
            ssLabel.setVisible(false);
        }
        else if(nUnionRadioButton.isSelected()) {
            ssLabel.setText("Not Unionized");
            ssLabel.setVisible(false);
        }
    }
    
    private void addLecButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLecButtonActionPerformed
        // TODO add your handling code here:
        LectMySql();
    }//GEN-LAST:event_addLecButtonActionPerformed

    //Adding theemployee name and empoyee type to the database, setting the relevant tab, active,and 
    //adding a name to the Name combobox 
    private void empTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empTypeComboBoxActionPerformed
            
        try{
            String txtCombo;
            txtCombo=(String)empTypeComboBox.getSelectedItem();
            if(txtCombo.equalsIgnoreCase("Lecturer")){
                AddMySql();
                mainTabbedPane.setSelectedIndex(0);
                getEmpNameComboBox.addItem(empNameTextField.getText());
            }
            else if(txtCombo.equalsIgnoreCase("Student")){
                AddMySql();
                mainTabbedPane.setSelectedIndex(1);
                getEmpNameComboBox.addItem(empNameTextField.getText());
            }
            else if(txtCombo.equalsIgnoreCase("Support Staff")){
                AddMySql();
                mainTabbedPane.setSelectedIndex(2);
                getEmpNameComboBox.addItem(empNameTextField.getText());
            }
        }
        catch(Exception e){
            notiLabel.setText(e.toString());
        }
         
    }//GEN-LAST:event_empTypeComboBoxActionPerformed

    private void empNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empNameTextFieldActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        WorkMySql();
    }//GEN-LAST:event_submitButtonActionPerformed

    private void addWorkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWorkButtonActionPerformed
        // TODO add your handling code here:
        try{
            Double hrs, pr, amount;
            hrs=Double.parseDouble(hrsWorkedTextField.getText());
            pr=Double.parseDouble(payRateTextField.getText());
            amount=hrs*pr;
            amountLabel.setVisible(false);
            amountLabel.setText(amount.toString());
            printTextArea.setText("\n  Name: \t\t"+getEmpNameComboBox.getSelectedItem()+""
                    + "\n\n  Hours Worked: \t" +hrsWorkedTextField.getText()+" Hrs"
                    + "\n\n  Pay Rate: \t\tKshs. " +payRateTextField.getText()+""
                    + "\n\n  Total Amount: \tKshs. "+amount+"");
            notiLabel.setText(null);
        }
        catch(Exception e){
            notiLabel.setText(e.toString());
        }
        
    }//GEN-LAST:event_addWorkButtonActionPerformed

    private void addStudButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudButtonActionPerformed
        // TODO add your handling code here:
        String txtCombo;
        txtCombo=(String)yosComboBox.getSelectedItem();
        if(txtCombo.equalsIgnoreCase("First Year")){
        }
        else if(txtCombo.equalsIgnoreCase("Second Year")){
        }
        else if(txtCombo.equalsIgnoreCase("Third Year")){
        }
        else if(txtCombo.equalsIgnoreCase("Fourth Year")){
        }
        else if(!txtCombo.equalsIgnoreCase("Fifth Year")){
        } 
        else {
        }
        
        //add data into empl table
        StudeMySql();
    }//GEN-LAST:event_addStudButtonActionPerformed

    private void permRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permRadioButtonActionPerformed
        // TODO add your handling code here:
        buttGroup();
    }//GEN-LAST:event_permRadioButtonActionPerformed

    private void nPermRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nPermRadioButtonActionPerformed
        // TODO add your handling code here:
        buttGroup();
    }//GEN-LAST:event_nPermRadioButtonActionPerformed

    private void addSStaffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSStaffButtonActionPerformed
        // TODO add your handling code here:
        SStaffMySql();
    }//GEN-LAST:event_addSStaffButtonActionPerformed

    private void unionRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unionRadioButtonActionPerformed
        // TODO add your handling code here:
        bGroup();
    }//GEN-LAST:event_unionRadioButtonActionPerformed

    private void nUnionRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nUnionRadioButtonActionPerformed
        // TODO add your handling code here:
        bGroup();
    }//GEN-LAST:event_nUnionRadioButtonActionPerformed

    private void getEmpNameComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getEmpNameComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getEmpNameComboBoxActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        empNameTextField.setText(null);
        deptTextField.setText(null);
        campNameTextField.setText(null);
        progNameTextField.setText(null);
        sAreaTextField.setText(null);
        hrsWorkedTextField.setText(null);
        payRateTextField.setText(null);
        printTextArea.setText(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Report report = new Report();
        report.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new EmpInfo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LecPanel;
    private javax.swing.JPanel SStaffPanel;
    private javax.swing.JPanel StudentPanel;
    private javax.swing.JButton addLecButton;
    private javax.swing.JButton addSStaffButton;
    private javax.swing.JButton addStudButton;
    private javax.swing.JButton addWorkButton;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JTextField campNameTextField;
    private javax.swing.JButton closeButton;
    private javax.swing.JTextField deptTextField;
    private javax.swing.JTextField empNameTextField;
    private javax.swing.JPanel empPanel;
    private javax.swing.JComboBox empTypeComboBox;
    private javax.swing.JComboBox getEmpNameComboBox;
    private javax.swing.JTextField hrsWorkedTextField;
    private javax.swing.JPanel icon;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JRadioButton nPermRadioButton;
    private javax.swing.JRadioButton nUnionRadioButton;
    private javax.swing.JLabel notiLabel;
    private javax.swing.JTextField payRateTextField;
    private javax.swing.JRadioButton permRadioButton;
    private javax.swing.JPanel printPanel;
    private javax.swing.JScrollPane printScrollPane;
    private javax.swing.JTextArea printTextArea;
    private javax.swing.JTextField progNameTextField;
    private javax.swing.JLabel rLabel;
    private javax.swing.JTextField sAreaTextField;
    private javax.swing.JLabel ssLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JPanel tabsPanel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JRadioButton unionRadioButton;
    private javax.swing.JPanel workPanel;
    private javax.swing.JComboBox yosComboBox;
    // End of variables declaration//GEN-END:variables
}
