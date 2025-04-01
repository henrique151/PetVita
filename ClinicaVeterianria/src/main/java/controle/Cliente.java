
package controle;

import conexao.Conexao;

import java.awt.*;
import java.text.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel; // Para reconhecimento de Jtable

import java.sql.*;
import javax.swing.border.Border;

public class Cliente extends JFrame{
        
        Conexao con_cliente;     
        JToolBar barra;
        JButton bvoltar, cadastrar, alterar, excluir, pesquisar, primeiro, anterior, proximo, ultimo,novo;
        JLabel rotulo1, voltar, rnome, rtel, rend, rcpf,rcod;
        JTextField tnome, tend, tcpf,tcod;
        JFormattedTextField tel;
        MaskFormatter mtel;
        
         InicialPesquisar frmpesquisar;
        
       // InicialPesquisar frmpesquisar;
        
        int contador = 1;
        ImageIcon imagens[];
        
        public Cliente() {

            Container tela = getContentPane();
            tela.setLayout(null);
            setTitle("Tela do Cliente");
            
            con_cliente = new Conexao(); 
            con_cliente.conecta(contador);
            
            con_cliente.executaSQL("select * from cliente order by Cod_cliente");
            
            
                String icones[]={"img/Voltar.png"};
            imagens = new ImageIcon[1];
            for(int i = 0;i < 1;i++){
                imagens[i] = new ImageIcon(icones[i]);}
            
            ImageIcon imagem = new ImageIcon("img/logo2.png");
            JLabel imagemLabel = new JLabel(); 
            ImageIcon icone = new ImageIcon("img/logo2.png");
            setIconImage(icone.getImage());
            imagemLabel.setIcon(imagem);
            imagemLabel.setBounds(600, 30, 300, 300);
            
            bvoltar = new JButton(imagens[0]);
            voltar = new JLabel("Voltar para a pagina pricipal. ");
            barra = new JToolBar("Barra de Ferramentas");
            barra.setRollover(true); 
            barra.setFloatable(false);
            barra.add(bvoltar);
            barra.add(voltar);     
            
            alterar = new JButton("Alterar ");
            cadastrar = new JButton("Cadastrar ");
            
            alterar.setForeground(new Color(72, 191, 178));
            alterar.setBackground(new Color(52, 53, 56));
            alterar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));
            
            cadastrar.setForeground(new Color(72, 191, 178));
            cadastrar.setBackground(new Color(52, 53, 56));
            cadastrar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));
            
            bvoltar.setBackground(new Color(72, 191, 178));
            
            cadastrar.setBounds(100, 340, 100, 20);
            alterar.setBounds(300, 340, 100, 20);
        
            barra.setBounds(1,1,1000,25);
            barra.setBackground(new Color(72, 191, 178));
            tela.setBackground(new Color(241, 241, 241));
            
            rcod = new JLabel("Codigo do Cliente");
            rotulo1 = new JLabel("Perfil do Cliente. ");
            rnome = new JLabel("Nome do Cliente: ");
            rtel = new JLabel("Telefone: ");
            rend = new JLabel("Endereco: ");
            rcpf = new JLabel("CPF: ");
            
            tnome = new JTextField(20);
            tend = new JTextField(20);
            tcpf = new JTextField(20);
            tcod = new JTextField(20);
            
            try{
            mtel = new MaskFormatter("(##)####-####");
            mtel.setPlaceholderCharacter('_');
            }
            catch(ParseException excp){}

            tel = new JFormattedTextField(mtel);
            
            rotulo1.setBounds(50, 40, 150, 20);
            rnome.setBounds(50, 110, 150, 20);
            rtel.setBounds(50, 140, 80, 20);
            rend.setBounds(50, 170, 80, 20);
            rcpf.setBounds(50, 200, 80, 20);
            rcod.setBounds(50, 80, 120, 20);
            
            tnome.setBounds(160, 110, 250, 25);
            tel.setBounds(160, 140, 250, 25);
            tend.setBounds(160, 170, 250, 25);
            tcpf.setBounds(160, 200, 250, 25);
            tcod.setBounds(160, 80, 30, 25);
            
            primeiro = new JButton("Primeiro");
            anterior = new JButton("Anterior");
            proximo = new JButton("Próximo");
            ultimo = new JButton("Último");
            cadastrar = new JButton("Cadastrar");
            alterar = new JButton("Alterar");
            excluir = new JButton("Excluir");
            pesquisar = new JButton("Pesquisa");
            novo = new JButton("Novo Registro");
            
            rotulo1.setFont(new java.awt.Font("Arial", 1, 12));
            
            alterar.setForeground(new Color(72, 191, 178));
            alterar.setBackground(new Color(52, 53, 56));
            alterar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));
            
            cadastrar.setForeground(new Color(72, 191, 178));
            cadastrar.setBackground(new Color(52, 53, 56));
            cadastrar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));
            
            cadastrar.setBounds(50, 340, 100, 20);
            alterar.setBounds(170, 340, 100, 20);
            pesquisar.setBounds(290, 340, 100, 20);
            excluir.setBounds(410, 340, 100, 20);
            novo.setBounds(530, 370, 200, 20);
            
            primeiro.setForeground(new Color(72, 191, 178));
            primeiro.setBackground(new Color(52, 53, 56));
            primeiro.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));
            
            novo.setForeground(new Color(72, 191, 178));
            novo.setBackground(new Color(52, 53, 56));
            novo.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));

            anterior.setForeground(new Color(72, 191, 178));
            anterior.setBackground(new Color(52, 53, 56));
            anterior.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));

            proximo.setForeground(new Color(72, 191, 178));
            proximo.setBackground(new Color(52, 53, 56));
            proximo.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));

            ultimo.setForeground(new Color(72, 191, 178));
            ultimo.setBackground(new Color(52, 53, 56));
            ultimo.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));

            alterar.setForeground(new Color(72, 191, 178));
            alterar.setBackground(new Color(52, 53, 56));
            alterar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));

            excluir.setForeground(new Color(72, 191, 178));
            excluir.setBackground(new Color(52, 53, 56));
            excluir.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));

            voltar.setForeground(new Color(72, 191, 178));
            voltar.setBackground(new Color(52, 53, 56));
            voltar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));

            pesquisar.setForeground(new Color(72, 191, 178));
            pesquisar.setBackground(new Color(52, 53, 56));
            pesquisar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));
            
            primeiro.setBounds(50, 400, 100, 20);
            anterior.setBounds(170, 400, 100, 20);
            proximo.setBounds(290, 400, 100, 20);
            ultimo.setBounds(410, 400, 100, 20);
                
            primeiro.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   try {
                       if(!con_cliente.resultset.isFirst()) {
                            con_cliente.resultset.first();
                            mostrar_Dados();   
                       } else {
                           JOptionPane.showMessageDialog(null, "Você já esta no primeiro registro!", "Mesangem do Programa", JOptionPane.INFORMATION_MESSAGE);
                       }

                   } catch(SQLException erro) {
                       JOptionPane.showMessageDialog(null, "Não foi possí­vel acessar o primeiro registro: "+ erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                   }
                }
            });
                       
            anterior.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   try {
                       if(!con_cliente.resultset.isFirst()) {
                             con_cliente.resultset.previous();
                             mostrar_Dados();
                       } else {
                           JOptionPane.showMessageDialog(null, "Você já esta no primeiro registro!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                       }

                   } catch(SQLException erro) {
                       JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registro: "+ erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                   }
                }
            });

            proximo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (!con_cliente.resultset.isLast()) {
                            con_cliente.resultset.next();
                            mostrar_Dados();                   
                        } else {
                            JOptionPane.showMessageDialog(null, "Você já esta no ultimo registro!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (SQLException erro) {
                        JOptionPane.showMessageDialog(null, "Não foi possí­vel acessar o próximo registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });

            ultimo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   try {
                       if(!con_cliente.resultset.isLast()) {
                            con_cliente.resultset.last();
                            mostrar_Dados();
                       } else {
                           JOptionPane.showMessageDialog(null, "Você já esta no ultimo registro!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                       }
                   } catch(SQLException erro) {
                       JOptionPane.showMessageDialog(null, "Não foi possí­vel acessar o primeiro registro: "+ erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                   }
                }
            });
            
            bvoltar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MenuCliente mostra = new MenuCliente();
                        mostra.setVisible(true);
                        dispose();
                }
            }
            );
            
            cadastrar.addActionListener(new ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    String nome =  tnome.getText();
                    String Tel = tel.getText();
                    String End = tend.getText();
                    String CPF = tcpf.getText();
            try {
                String insert_sql = "insert into cliente (Nome_cliente, Tel_cliente, Endereco_cliente, CPF_cliente) values ('" + nome  + "','" + Tel + "','" + End + "','" + CPF + "')";
                
                con_cliente.statement.executeUpdate(insert_sql);
                
                JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

                con_cliente.executaSQL("select * from cliente order by Cod_cliente");
                posicionarRegistro();
                
            } catch (SQLException errosql) {
                JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        });
            
            alterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome =  tnome.getText();
                String Tel = tel.getText();
                String End = tend.getText();
                String CPF = tcpf.getText();
                String sql;
                String msg = "";
                
                try {
                    sql="update cliente set Nome_cliente='" + nome + "', Tel_cliente='" + Tel + "', Endereco_cliente='" + End + "', CPF_cliente='" + CPF + "'  where Cod_cliente = " +  tcod.getText();
                    msg = "Alteração de um novo registro";
                    
                    con_cliente.statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE );
                    
                    con_cliente.executaSQL("select * from cliente order by Cod_cliente");
                    posicionarRegistro();
                } catch(SQLException errosql) {
                     JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        excluir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String sql = "";
                try {
                    int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o registro: ","Confirmar Exclusão", JOptionPane.YES_NO_OPTION,3);
                    if (resposta == 0){
                        sql = "delete from cliente where Cod_cliente = " + tcod.getText();
                        int excluir = con_cliente.statement.executeUpdate(sql);
                        if (excluir == 1){
                            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!!", "Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                            con_cliente.executaSQL("select * from cliente order by Cod_cliente");
                            con_cliente.resultset.first();                          
                            posicionarRegistro();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }catch (SQLException excecao){
                    JOptionPane.showMessageDialog(null, " Erro na exclusão: "+excecao, "Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
            
            pesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmpesquisar = new InicialPesquisar(null, "Pesquisar", true);
                frmpesquisar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frmpesquisar.setVisible(true);
            }
        }
        );
           novo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tcod.setText("");
                tcpf.setText("");
                tel.setText("");
                tend.setText("");
                tnome.setText("");
                
            }
        }
        );
            
            tela.add(rotulo1);tela.add(rnome);tela.add(rtel);
            tela.add(rend);tela.add(rcpf);
            tela.add(tnome);tela.add(tel);tela.add(tend);
            tela.add(tcpf);
            tela.add(alterar);tela.add(cadastrar);
            tela.add(barra);
            tela.add(excluir);
            tela.add(pesquisar);
            tela.add(primeiro);
            tela.add(anterior);
            tela.add(proximo);
            tela.add(ultimo);
            tela.add(novo);
            tela.add(rcod);
            tela.add(tcod);
            tela.add(primeiro);
            tela.add(anterior);
            tela.add(proximo);
            tela.add(ultimo);
            tela.add(novo);
            tela.add(imagemLabel);
            setSize(900, 540);
            setResizable(false);
            setLocationRelativeTo(null);
            
            
            posicionarRegistro();
        }
        
        private class InicialPesquisar extends JDialog {
    Conexao con_cliente;
    JButton bvoltar;

    JTable tblClientes;
    JScrollPane scp_tabela;

    public InicialPesquisar(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        Container tela1 = getContentPane();
        tela1.setLayout(null);

        con_cliente = new Conexao();
        con_cliente.conecta(contador);

        bvoltar = new JButton("Voltar");

        tblClientes = new javax.swing.JTable();
        scp_tabela = new javax.swing.JScrollPane();

        ImageIcon imagem = new ImageIcon("img/logo2.png");
        JLabel imagemLabel = new JLabel();
        imagemLabel.setIcon(imagem);
        imagemLabel.setBounds(450, 5, 300, 300);


        bvoltar.setBounds(15, 550, 100, 20);
        tblClientes.setBounds(15, 320, 850, 200);
        scp_tabela.setBounds(15, 320, 850, 200);
        
        tblClientes.setBackground(new Color(52, 53, 56));
        tblClientes.setForeground(new Color(72, 191, 178));
        
        tela1.setBackground(Color.white);
        tela1.add(tblClientes);
        tela1.add(scp_tabela);


        bvoltar.setForeground(new Color(72, 191, 178));
        bvoltar.setBackground(new Color(52, 53, 56));
        bvoltar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72, 191, 178), 2));
        
        tblClientes.setFont(new java.awt.Font ("Arial", 1, 12));

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String[]{"Código", "Nome", "Telefone", "Endereço", "CPF"})
        {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        scp_tabela.setViewportView(tblClientes);

        tblClientes.setAutoCreateRowSorter(true);

        bvoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });

        try {
            String pesquisa = "Select * from cliente where Nome_cliente like '" + tnome.getText() + "%'";
            con_cliente.executaSQL(pesquisa);

            if (con_cliente.resultset.first()) {
                preencherTabela();
            } else {
                JOptionPane.showMessageDialog(null, "\n Não existe dados com este paramêtro!!", "Mensagem do Programa ", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados!! :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }

        tela1.add(imagemLabel);
        tela1.add(bvoltar);

        tblClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblClientes.setFont(new java.awt.Font("Arial", 1, 12));
        
        setSize(900, 640);
        setResizable(false);
        setLocationRelativeTo(null);
    }
         
    
         
public void preencherTabela() {
        tblClientes.getColumnModel().getColumn(0).setPreferredWidth(2);
        tblClientes.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblClientes.getColumnModel().getColumn(2).setPreferredWidth(40);
        tblClientes.getColumnModel().getColumn(3).setPreferredWidth(50);
        tblClientes.getColumnModel().getColumn(4).setPreferredWidth(40);

        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setNumRows(0);

        try {
            con_cliente.resultset.beforeFirst();
            while (con_cliente.resultset.next()) {
                modelo.addRow(new Object[]{
                    con_cliente.resultset.getString("Cod_cliente"),con_cliente.resultset.getString("Nome_cliente"), con_cliente.resultset.getString("Tel_cliente"), con_cliente.resultset.getString("Endereco_cliente"), con_cliente.resultset.getString("CPF_cliente")
                });
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!! :\n" + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
}
         }
        
        public void posicionarRegistro(){
            try{
                con_cliente.resultset.first();// posiciona no 1° registro da tabela
                mostrar_Dados();
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null,"Não foi possivel posicionar no primeiro registro:"+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
            }   
        }
        
        public void mostrar_Dados() {
           try {
               tcod.setText(con_cliente.resultset.getString("Cod_cliente")); // Associar a caixa de texto ao campo cod
               tnome.setText(con_cliente.resultset.getString("Nome_cliente"));
               tel.setText(con_cliente.resultset.getString("Tel_cliente"));
               tend.setText(con_cliente.resultset.getString("Endereco_cliente"));
               tcpf.setText(con_cliente.resultset.getString("CPF_cliente"));
           } catch (SQLException erro) {
               JOptionPane.showMessageDialog(null, "\n Não localizou dados: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
           }
       }
}
   
