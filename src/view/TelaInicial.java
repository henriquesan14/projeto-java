/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ConsultaController;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Consulta;
import model.Relogio;
import model.Usuario;

/**
 *
 * @author computador
 */
public class TelaInicial extends javax.swing.JFrame implements WindowListener{

    /**
     * Creates new form TelaInicial
     */
    ConsultaController controller=new ConsultaController();
    Usuario usuario;
    public TelaInicial(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        this.addWindowListener(this);
        setTitle("App Clínica");
        Relogio relogio=new Relogio(lblHora);
        Thread t1=new Thread(relogio);
        t1.start();
        LocalDate date=LocalDate.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data=date.format(formatter);
        lblData.setText("Data: "+data);
        lblBemVindo.setText("Bem vindo "+usuario.getNome()+"!");
        if(usuario.getRole().equals("user")){
            menuUsuarios.setEnabled(false);
        }
        atualizaTabela();
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
        for(Consulta c: controller.consultasHoje()){
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String data = sdf.format(c.getDtConsulta());
                tableModel.addRow(new String[]{c.getId().toString(),data,c.getTurno(),c.getPaciente().getId().toString(),c.getPaciente().getNome(),c.getMedico().getId().toString(),c.getMedico().getNome()}); 
        }
        tbConsultasHoje.setModel(tableModel);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHora = new javax.swing.JLabel();
        lblBemVindo = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbConsultasHoje = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuUsuarios = new javax.swing.JMenuItem();
        menuPacientes = new javax.swing.JMenuItem();
        menuMedicos = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        lblHora.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/clock.png"))); // NOI18N
        getContentPane().add(lblHora);
        lblHora.setBounds(360, 90, 170, 16);

        lblBemVindo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblBemVindo.setText("Bem vindo!");
        getContentPane().add(lblBemVindo);
        lblBemVindo.setBounds(59, 33, 290, 22);

        lblData.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblData.setText("Data: ");
        getContentPane().add(lblData);
        lblData.setBounds(59, 82, 220, 22);

        tbConsultasHoje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbConsultasHoje.setGridColor(new java.awt.Color(153, 255, 255));
        tbConsultasHoje.setSelectionForeground(new java.awt.Color(51, 51, 0));
        jScrollPane1.setViewportView(tbConsultasHoje);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 200, 713, 384);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Consultas de Hoje");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 160, 126, 17);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(526, 51, 0, 0);

        menuCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/application_add.png"))); // NOI18N
        menuCadastro.setText("Cadastro");

        menuUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        menuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/user.png"))); // NOI18N
        menuUsuarios.setText("Usuários");
        menuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuariosActionPerformed(evt);
            }
        });
        menuCadastro.add(menuUsuarios);

        menuPacientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        menuPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/user_red.png"))); // NOI18N
        menuPacientes.setText("Pacientes");
        menuPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPacientesActionPerformed(evt);
            }
        });
        menuCadastro.add(menuPacientes);

        menuMedicos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        menuMedicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/doctor.png"))); // NOI18N
        menuMedicos.setText("Médicos");
        menuMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMedicosActionPerformed(evt);
            }
        });
        menuCadastro.add(menuMedicos);

        jMenuBar1.add(menuCadastro);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/calendar.png"))); // NOI18N
        jMenu1.setText("Consultas");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/calendar_add.png"))); // NOI18N
        jMenuItem1.setText("Agendar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/help.png"))); // NOI18N
        jMenu4.setText("Ajuda");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/info.jpg"))); // NOI18N
        jMenuItem7.setText("Sobre");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/opcoes.png"))); // NOI18N
        jMenu6.setText("Opções");

        menuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/systemshutdown_94125.png"))); // NOI18N
        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        jMenu6.add(menuSair);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(841, 670));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new Sobre(this).setVisible(true);
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void menuMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMedicosActionPerformed
        new TelaMedicos(this).setVisible(true);
    }//GEN-LAST:event_menuMedicosActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
       int dialogResult = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja sair?");
        if(dialogResult == JOptionPane.YES_OPTION){
            this.dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuariosActionPerformed
        new TelaUsuarios(this).setVisible(true);
    }//GEN-LAST:event_menuUsuariosActionPerformed

    private void menuPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPacientesActionPerformed
        try {
            new TelaPacientes(this).setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuPacientesActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
       
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new TelaConsultas(this,this.usuario).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHora;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem menuMedicos;
    private javax.swing.JMenuItem menuPacientes;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenuItem menuUsuarios;
    private javax.swing.JTable tbConsultasHoje;
    // End of variables declaration//GEN-END:variables

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        atualizaTabela();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
}
