/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ConsultaController;
import controller.MedicoController;
import controller.PacienteController;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Consulta;
import model.Medico;
import model.Paciente;
import model.Usuario;

/**
 *
 * @author computador
 */
public class TelaConsultas extends javax.swing.JFrame implements WindowListener {

    /**
     * Creates new form TelaConsultas
     */
    JFrame janela;
    ConsultaController ccontroller=new ConsultaController();
    PacienteController pcontroller=new PacienteController();
    MedicoController mcontroller =new MedicoController();
    DefaultComboBoxModel<Paciente> modelPacientes;
    DefaultComboBoxModel<Medico> modelMedicos= new DefaultComboBoxModel<>();
    Usuario usuario;
    public TelaConsultas(JFrame janela,Usuario usuario) {
        initComponents();
        this.usuario=usuario;
        modelPacientes=new DefaultComboBoxModel<>(new Vector(pcontroller.listar()));
        modelMedicos=new DefaultComboBoxModel<>(new Vector(mcontroller.listar()));
        cbPacientes.setModel(modelPacientes);
        cbMedicos.setModel(modelMedicos);
        atualizaTabela(); 
        cbTurno.setSelectedItem(null);
        modelMedicos.setSelectedItem(null);
        modelPacientes.setSelectedItem(null);
        btnAlterar.setEnabled(false);
        btnApagar.setEnabled(false);
        this.janela=janela;
        this.addWindowListener(this);
        janela.setEnabled(false);
        
        
    }
    
    public void atualizaTabela(){
        DefaultTableModel tableModel=new DefaultTableModel();
        tableModel.addColumn("Id");
        tableModel.addColumn("Data Consulta");
        tableModel.addColumn("Turno");
        tableModel.addColumn("Id Paciente");
        tableModel.addColumn("Nome Paciente");
        tableModel.addColumn("Id Médico");
        tableModel.addColumn("Nome Médico");
        for(Consulta c: ccontroller.listar()){
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String data = sdf.format(c.getDtConsulta());
                tableModel.addRow(new String[]{c.getId().toString(),data,c.getTurno(),c.getPaciente().getId().toString(),c.getPaciente().getNome(),c.getMedico().getId().toString(),c.getMedico().getNome()}); 
        }
        tableConsultas.setModel(tableModel);
        
    }
    
    public void filtroPesquisa(){
        DefaultTableModel tableModel=new DefaultTableModel();
        tableModel.addColumn("Id");
        tableModel.addColumn("Data Consulta");
        tableModel.addColumn("Turno");
        tableModel.addColumn("Id Paciente");
        tableModel.addColumn("Nome Paciente");
        tableModel.addColumn("Id Médico");
        tableModel.addColumn("Nome Médico");
        for(Consulta c: ccontroller.listarPorPaciente(txtFiltro.getText())){
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String data = sdf.format(c.getDtConsulta());
                tableModel.addRow(new String[]{c.getId().toString(),data,c.getTurno(),c.getPaciente().getId().toString(),c.getPaciente().getNome(),c.getMedico().getId().toString(),c.getMedico().getNome()}); 
        }
        tableConsultas.setModel(tableModel);
    }
    
    public void setarCampos(){
        int setar = tableConsultas.getSelectedRow();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        Date data;
        try {
            data = sdf.parse(tableConsultas.getModel().getValueAt(setar, 1).toString());
            dtConsulta.setDate(data);
        } catch (ParseException ex) {
            Logger.getLogger(TelaPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        txtId.setText(tableConsultas.getModel().getValueAt(setar, 0).toString());
        cbTurno.setSelectedItem(tableConsultas.getModel().getValueAt(setar, 2).toString());
        Long idPaciente=Long.parseLong(tableConsultas.getModel().getValueAt(setar, 3).toString());
        Paciente p = pcontroller.listarPorId(idPaciente);
        modelPacientes.setSelectedItem(p);
        Long idMedico=Long.parseLong(tableConsultas.getModel().getValueAt(setar, 5).toString());
        Medico m = mcontroller.listarPorId(idMedico);
        modelPacientes.setSelectedItem(p);
        modelMedicos.setSelectedItem(m);
    }
    
    public void limparCampos(){
        txtId.setText(null);
        dtConsulta.setDate(null);
        modelPacientes.setSelectedItem(null);
        modelMedicos.setSelectedItem(null);
        cbTurno.setSelectedItem(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableConsultas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        cbPacientes = new javax.swing.JComboBox<>();
        cbMedicos = new javax.swing.JComboBox<>();
        cbTurno = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        dtConsulta = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableConsultasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableConsultas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 70, 772, 299));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/zoom.png"))); // NOI18N
        jLabel1.setText("Pesquisar por paciente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 39, -1, -1));

        txtFiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtFiltro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });
        jPanel1.add(txtFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 252, 33));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Data da consulta");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 470, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Id");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 395, -1, -1));

        txtId.setBorder(null);
        txtId.setEnabled(false);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 415, 73, 28));

        cbPacientes.setBorder(null);
        jPanel1.add(cbPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 415, 165, 37));

        cbMedicos.setBorder(null);
        jPanel1.add(cbMedicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 495, 165, 39));

        cbTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manhã", "Tarde", "Noite" }));
        cbTurno.setBorder(null);
        cbTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTurnoActionPerformed(evt);
            }
        });
        jPanel1.add(cbTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 415, 92, 37));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Paciente");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Turno");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 395, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Médico");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 470, -1, -1));

        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/calendar_add.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 573, -1, 46));

        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/calendar_edit.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 571, -1, 51));

        btnApagar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/calendar_delete.png"))); // NOI18N
        btnApagar.setText("Apagar");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });
        jPanel1.add(btnApagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 572, -1, 48));

        btnLimpar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/vassoura.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 571, -1, 51));

        btnSair.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 588, 70, 43));

        dtConsulta.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(dtConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 495, 153, 39));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTurnoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        try {
           if(!cbTurno.getSelectedItem().equals(null)){
               SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
               String data=sdf.format(dtConsulta.getDate());
               int ok= ccontroller.salvar(data,(String) cbTurno.getSelectedItem(), (Paciente) cbPacientes.getSelectedItem(),(Medico) cbMedicos.getSelectedItem(), this.usuario);
                if(ok != 1){
                    JOptionPane.showMessageDialog(this,"Limite de consultas por medico/dia/turno excedida");
                }else{
                    JOptionPane.showMessageDialog(this,"Consulta salva");
                    atualizaTabela();
                }
           }else{
               JOptionPane.showMessageDialog(this, "Campo(s) vazio(s)");
           }
           
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this,"Data inválida");
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(this, "Campo(s) vazio(s)");
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void tableConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableConsultasMouseClicked
        setarCampos();
        btnSalvar.setEnabled(false);
        btnAlterar.setEnabled(true);
        btnApagar.setEnabled(true);
    }//GEN-LAST:event_tableConsultasMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
        btnSalvar.setEnabled(true);
        btnAlterar.setEnabled(false);
        btnApagar.setEnabled(false);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
           SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
           String data=sdf.format(dtConsulta.getDate());
           int ok= ccontroller.editar(Long.parseLong(txtId.getText()),data,(String) cbTurno.getSelectedItem(), (Paciente) cbPacientes.getSelectedItem(),(Medico) cbMedicos.getSelectedItem(), this.usuario);
           if(ok != 1){
               JOptionPane.showMessageDialog(this,"Erro");
           }else{
               JOptionPane.showMessageDialog(this,"Consulta alterada");
               atualizaTabela();
           }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this,"Data inválida");
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(this, "Campo(s) vazio(s)");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja apagar este registro?");
        if(dialogResult == JOptionPane.YES_OPTION){
            int ok= ccontroller.apagar(Long.parseLong(txtId.getText()));
            if(ok !=1){
                JOptionPane.showMessageDialog(this,"Erro");
            }else{
                JOptionPane.showMessageDialog(this,"Consulta excluida");
            }
            atualizaTabela(); 
        }
    }//GEN-LAST:event_btnApagarActionPerformed

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        filtroPesquisa();
    }//GEN-LAST:event_txtFiltroKeyReleased

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Medico> cbMedicos;
    private javax.swing.JComboBox<Paciente> cbPacientes;
    private javax.swing.JComboBox<String> cbTurno;
    private com.toedter.calendar.JDateChooser dtConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableConsultas;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        janela.setEnabled(true);
    }

    @Override
    public void windowIconified(WindowEvent e) {
         
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
}
