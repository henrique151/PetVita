package controle;

import java.awt.*;
import java.text.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import conexao.Conexao;


import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class Funcionario extends JFrame {
    Conexao con_cliente, con_cliente2;
    
    JMenuBar barra;
    JMenu opcoes;
    JMenuItem alterartwo, gravartwo, excluirtwo,pesquisartwo;
    
    JLabel cod_func, cod_cargo, l_nome, l_data_nasc, l_cpf, l_turno, l_sexo, l_endereco, l_telef, l_cargotwo, img;
    JTextField t_cod_func, t_cod_cargo, t_nome, t_cpf, t_turno, t_sexo, t_endereco, t_cargotwo ;
    JFormattedTextField t_telef, t_data_nasc;
    MaskFormatter m_telef, m_data_nasc;
    JButton  primeiro, anterior, proximo, ultimo, alterar, gravar, excluir ,voltar,pesquisar,novo;
    
    
    
    InicialPesquisar frmpesquisar;
    
    int contador = 1;
    
    public Funcionario(){
        Container tela = getContentPane();
        tela.setLayout(null);
               
        con_cliente = new Conexao(); 
        con_cliente.conecta(contador);
        
        con_cliente2 = new Conexao();
        con_cliente2.conecta(contador);
        
        tela.setBackground(new Color(241, 241, 241));
        
        setTitle("Tela do Funcionário");
        setResizable(false);
        
        ImageIcon icone = new ImageIcon("img/logo2.png");
        setIconImage(icone.getImage());
        ImageIcon imagem = new ImageIcon("img/logo2.png");
        
        JLabel imagemLabel = new JLabel(); 
        imagemLabel.setIcon(imagem);
        imagemLabel.setBounds(450, 50, 300, 300);
        
        barra = new JMenuBar();
        opcoes = new JMenu("Menus");
        alterartwo = new JMenuItem("Alterar");
        excluirtwo = new JMenuItem("Excluir");
        gravartwo = new JMenuItem("Gravar");
        pesquisartwo = new JMenuItem("Pesquisar (campo nome)");
        
        cod_func = new JLabel("Código do Funcionario: ");
        cod_cargo = new JLabel("Código do Cargo: ");
        l_nome = new JLabel("Nome: ");
        l_cpf = new JLabel("CPF: ");
        l_turno = new JLabel("Turno: ");
        l_data_nasc = new JLabel("Data de Nascimento: ");
        l_sexo = new JLabel("Sexo: ");;
        l_endereco = new JLabel("Endereço: ");
        l_telef = new JLabel("Telefone: ");
        l_cargotwo = new JLabel("");
        
        primeiro = new JButton("Primeiro");
        anterior = new JButton("Anterior");
        proximo = new JButton("Próximo");
        ultimo = new JButton("Último");
        alterar = new JButton("Alterar");
        voltar = new JButton("Voltar");
        gravar = new JButton("Gravar");
        excluir = new JButton("Excluir");
        pesquisar = new JButton("Pesquisar (campo nome)");
        novo = new JButton("Novo Registro");
        
        t_cod_func = new JTextField(5);
        t_cod_cargo = new JTextField(5);
        t_nome = new JTextField(20);
        t_cpf =  new JTextField(10);
        t_turno = new JTextField(10);
        t_sexo = new JTextField(5);
        t_endereco = new JTextField(10);
        t_cargotwo = new JTextField(10);

        cod_func.setBounds(50, -30, 200,200);
        cod_cargo.setBounds(50, 10,100,200);
        l_nome.setBounds(50,50,100,200);
        l_cpf.setBounds(50,90,100,200);
        l_turno.setBounds(50, 130, 100,200); 
        l_data_nasc.setBounds(50, 170,150,200); 
        l_sexo.setBounds(50,210,100,200);
        l_endereco.setBounds(50,250,100,200);
        l_telef.setBounds(50,290,100,200);
        
        t_cod_func.setBounds(200, 60, 50,23);
        t_cod_cargo.setBounds(200, 100,50,23);
        t_nome.setBounds(200,140,150,23);
        t_cpf.setBounds(200,180,100,23);
        t_turno.setBounds(200, 220, 100,23);
        t_sexo.setBounds(200,300,100,23);
        t_endereco.setBounds(200,340,200,23);
        
        t_cargotwo.setBounds(280, 100, 100, 23);
        t_cargotwo.setEditable(false);
        //t_cargotwo.setBorder(null);

        primeiro.setBounds(50, 500, 100, 20);
        anterior.setBounds(170, 500, 100, 20);
        proximo.setBounds(290, 500, 100, 20);
        ultimo.setBounds(410, 500, 100, 20);
        novo.setBounds(530, 500, 200, 20);
        
        alterar.setBounds(50,440,100,20);
        gravar.setBounds(170,440,100,20);
        excluir.setBounds(290,440,100, 20);
        pesquisar.setBounds(410,440,150, 20);
        
        voltar.setBounds(580,440,100,20);
        
       t_cod_func.setEditable(false);
        t_cargotwo.setBackground(Color.WHITE);
        
        cod_func.setForeground(new Color(72, 191, 178));
        cod_cargo.setForeground(new Color(72, 191, 178));
        l_nome.setForeground(new Color(72, 191, 178));
        l_cpf.setForeground(new Color(72, 191, 178));
        l_turno.setForeground(new Color(72, 191, 178));
        l_data_nasc.setForeground(new Color(72, 191, 178));
        l_sexo.setForeground(new Color(72, 191, 178));
        l_endereco.setForeground(new Color(72, 191, 178));
        l_telef.setForeground(new Color(72, 191, 178));
        
        primeiro.setForeground(new Color(72, 191, 178));
        primeiro.setBackground(new Color(52, 53, 56));
        primeiro.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));
        
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
        
        gravar.setForeground(new Color(72, 191, 178));
        gravar.setBackground(new Color(52, 53, 56));
        gravar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));
        
        excluir.setForeground(new Color(72, 191, 178));
        excluir.setBackground(new Color(52, 53, 56));
        excluir.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));
        
        voltar.setForeground(new Color(72, 191, 178));
        voltar.setBackground(new Color(52, 53, 56));
        voltar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));
        
        pesquisar.setForeground(new Color(72, 191, 178));
        pesquisar.setBackground(new Color(52, 53, 56));
        pesquisar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));
        
        novo.setForeground(new Color(72, 191, 178));
        novo.setBackground(new Color(52, 53, 56));
        novo.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));
        
        try {
            m_telef = new MaskFormatter("(##)####-####");
            m_data_nasc = new MaskFormatter("##/##/####");
            m_telef.setPlaceholderCharacter('_');
            m_data_nasc.setPlaceholderCharacter('_');
        }   catch(ParseException excp){}
        
        t_telef = new JFormattedTextField(m_telef);
        t_data_nasc = new JFormattedTextField(m_data_nasc);
        
        t_data_nasc.setBounds(200, 260, 100, 25);
        t_telef.setBounds(200, 380, 120, 25);   
        
        tela.add(imagemLabel);
        
        tela.add(cod_func);
        tela.add(cod_cargo);
        tela.add(l_nome);
        tela.add(l_cpf);
        tela.add(l_turno);
        tela.add(l_data_nasc);
        tela.add(l_sexo);
        tela.add(l_endereco);
        tela.add(l_telef);
        
        tela.add(t_cod_func);
        tela.add(t_cod_cargo);
        tela.add(t_nome);
        tela.add(t_cpf);
        tela.add(t_turno);
        tela.add(t_data_nasc);
        tela.add(t_sexo);
        tela.add(t_endereco);
        tela.add(t_telef);
        
        tela.add(primeiro);
        tela.add(anterior);
        tela.add(proximo);
        tela.add(ultimo);
        tela.add(alterar);
        tela.add(voltar);  
        tela.add(t_cargotwo);
        tela.add(gravar);
        tela.add(excluir);
        tela.add(pesquisar);
        tela.add(novo);
        
        barra.add(opcoes);
        setJMenuBar(barra);
        
        opcoes.add(alterartwo);
        opcoes.add(gravartwo);
        opcoes.add(excluirtwo);
        opcoes.add(pesquisartwo);
       
        voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuFuncionario mostra = new MenuFuncionario();
                mostra.setVisible(true);
                dispose();
            }
        });
        
        primeiro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               try {
                   if(!con_cliente.resultset.isFirst()) {
                        con_cliente.resultset.first();
                        mostrar_Dados();   
                   } else {
                       JOptionPane.showMessageDialog(null, "Já é o primeiro registro!", "Mesangem do Programa", JOptionPane.INFORMATION_MESSAGE);
                   }
                 
               } catch(SQLException erro) {
                   JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registrao: "+ erro, "Mesangem do Programa", JOptionPane.INFORMATION_MESSAGE);
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
                       JOptionPane.showMessageDialog(null, "Já é o primeiro registro!", "Mesangem do Programa", JOptionPane.INFORMATION_MESSAGE);
                   }
                  
               } catch(SQLException erro) {
                   JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registrao: "+ erro, "Mesangem do Programa", JOptionPane.INFORMATION_MESSAGE);
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
                        JOptionPane.showMessageDialog(null, "Já é o último registro!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Não foi possível acessar o próximo registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
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
                       JOptionPane.showMessageDialog(null, "Já é o ultimo registro!", "Mesangem do Programa", JOptionPane.INFORMATION_MESSAGE);
                   }
               } catch(SQLException erro) {
                   JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registrao: "+ erro, "Mesangem do Programa", JOptionPane.INFORMATION_MESSAGE);
               }
            }
        });
        
        excluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    int opcao;
                Object[] botoes = {"Sim", "Não"};
                opcao = JOptionPane.showOptionDialog(null,"Deseja excluir o registro?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,botoes,botoes[0]);
                    if (opcao == JOptionPane.YES_OPTION) {
                        String sql = "DELETE FROM funcionario WHERE Cod_func = " + t_cod_func.getText();
                        try {
                            int excluir = con_cliente.statement.executeUpdate(sql);

                            if (excluir == 1) {
                                JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                                con_cliente.executaSQL("select * from funcionario order by Cod_func");
                                con_cliente.resultset.first();
                                posicionarRegistro();
                            } else {
                                JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário!!", "Mensagem Do Programa", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } catch (SQLException excecao) {
                            JOptionPane.showMessageDialog(null, "Erro na exclusão: " + excecao.getMessage(), "Mensagem Do Programa", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }      
            }
        });
        
        excluirtwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    int opcao;
                Object[] botoes = {"Sim", "Não"};
                opcao = JOptionPane.showOptionDialog(null,"Deseja excluir o registro?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,botoes,botoes[0]);
                    if (opcao == JOptionPane.YES_OPTION) {
                        String sql = "DELETE FROM funcionario WHERE Cod_func = " + t_cod_func.getText();
                        try {
                            int excluir = con_cliente.statement.executeUpdate(sql);

                            if (excluir == 1) {
                                JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                                con_cliente.executaSQL("select * from funcionario order by Cod_func");
                                con_cliente.resultset.first();
                                posicionarRegistro();
                            } else {
                                JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário!!", "Mensagem Do Programa", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } catch (SQLException excecao) {
                            JOptionPane.showMessageDialog(null, "Erro na exclusão: " + excecao.getMessage(), "Mensagem Do Programa", JOptionPane.INFORMATION_MESSAGE);
                        }
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
        
        pesquisartwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmpesquisar = new InicialPesquisar(null, "Pesquisar", true);
                frmpesquisar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frmpesquisar.setVisible(true);
            }
        }
        );

        novo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               t_cargotwo.setText("");
               t_cod_cargo.setText("");
               t_cpf.setText("");
               t_cod_func.setText("");
               t_data_nasc.setText("");
               t_endereco.setText("");
               t_nome.setText("");
               t_sexo.setText("");
               t_telef.setText("");
               t_turno.setText("");               
            }
        }
        );        
        
        alterartwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome =  t_nome.getText();
                String cpf = t_cpf.getText();
                String turno = t_turno.getText();
                String data_nasc = t_data_nasc.getText();
                String sexo = t_sexo.getText();
                String endereco = t_endereco.getText();
                String telefone = t_telef.getText();
                String cargo = t_cod_cargo.getText();
                String sql;
                String msg = "";
                
                try {
                    sql="update funcionario set Cod_Cargo='" + cargo + "', Nome_func='" + nome + "', CPF_func='" + cpf + "', Turno_func='" + turno + "', DataNasc_func='" + data_nasc + "', Sexo_func='" + sexo + "', Endereco_func='" + endereco + "', Tel_func='" + telefone + "'  where Cod_func = " +  t_cod_func.getText();
                    msg = "Alteração de um novo registro";
                    
                    con_cliente.statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE );
                    
                    con_cliente.executaSQL("select * from funcionario order by Cod_func");
                    posicionarRegistro();
                } catch(SQLException errosql) {
                     JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        
        alterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome =  t_nome.getText();
                String cpf = t_cpf.getText();
                String turno = t_turno.getText();
                String data_nasc = t_data_nasc.getText();
                String sexo = t_sexo.getText();
                String endereco = t_endereco.getText();
                String telefone = t_telef.getText();
                String cargo = t_cod_cargo.getText();
                String sql, sql2;
                String msg = "";
                
                try {
                    sql="update funcionario set Cod_Cargo='" + cargo + "', Nome_func='" + nome + "', CPF_func='" + cpf + "', Turno_func='" + turno + "', DataNasc_func='" + data_nasc + "', Sexo_func='" + sexo + "', Endereco_func='" + endereco + "', Tel_func='" + telefone + "'  where Cod_func = " +  t_cod_func.getText();
                    // sql2="update cargo set Descricao_cargo='" + cargo + "' where Cod_cargo = " + t_cod_cargo.getText();
                    msg = "Alteração de um novo registro";
                    
                    con_cliente.statement.executeUpdate(sql);

                    JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE );
                    
                    con_cliente.executaSQL("select * from funcionario order by Cod_func");
                    // con_cliente2.executaSQL("select * from cargo order by Cod_cargo");
                    posicionarRegistro();
                } catch(SQLException errosql) {
                     JOptionPane.showMessageDialog(null, "Erro na gravação: " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        gravar.addActionListener(new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            String nome =  t_nome.getText();
            String cpf = t_cpf.getText();
            String turno = t_turno.getText();
            String data_nasc = t_data_nasc.getText();
            String sexo = t_sexo.getText();
            String endereco = t_endereco.getText();
            String telefone = t_telef.getText();
            String cargo = t_cargotwo.getText();
            String Codigo = t_cod_cargo.getText();
            try {
                String insert_sql = "insert into funcionario (Cod_cargo, Nome_func, CPF_func, Turno_func, DataNasc_func, Sexo_func, Endereco_func, Tel_func) values ('" + Codigo  + "','" + nome + "','" + cpf + "','" + turno + "','" + data_nasc + "','" + sexo + "','" + endereco + "','" + telefone +  "')";
                // String insert_sql2 = "insert into cargo (Cod_cargo, Descricao_cargo) values ('" + Codigo  + "','" + cargo + "')";
            
                con_cliente.statement.executeUpdate(insert_sql);
                //con_cliente2.statement.executeUpdate(insert_sql2);

                JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

                // Atualize os resultados das consultas após a gravação
                con_cliente.executaSQL("select * from funcionario order by Cod_func");
                posicionarRegistro();
                //con_cliente2.executaSQL("select * from cargo order by Cod_cargo");
            } catch (SQLException errosql) {
                JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        });
        
        gravartwo.addActionListener(new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            String nome =  t_nome.getText();
            String cpf = t_cpf.getText();
            String turno = t_turno.getText();
            String data_nasc = t_data_nasc.getText();
            String sexo = t_sexo.getText();
            String endereco = t_endereco.getText();
            String telefone = t_telef.getText();
            String cargo = t_cargotwo.getText();
            String Codigo = t_cod_cargo.getText();
            try {
                String insert_sql = "insert into funcionario (Cod_cargo, Nome_func, CPF_func, Turno_func, DataNasc_func, Sexo_func, Endereco_func, Tel_func) values ('" + Codigo  + "','" + nome + "','" + cpf + "','" + turno + "','" + data_nasc + "','" + sexo + "','" + endereco + "','" + telefone +  "')";
                // String insert_sql2 = "insert into cargo (Cod_cargo, Descricao_cargo) values ('" + Codigo  + "','" + cargo + "')";
            
                con_cliente.statement.executeUpdate(insert_sql);
                //con_cliente2.statement.executeUpdate(insert_sql2);

                JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

                // Atualize os resultados das consultas após a gravação
                con_cliente.executaSQL("select * from funcionario order by Cod_func");
                posicionarRegistro();
                //con_cliente2.executaSQL("select * from cargo order by Cod_cargo");
            } catch (SQLException errosql) {
                JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        });
            
        setSize(800,600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
        con_cliente.executaSQL("select * from funcionario order by Cod_func");
        con_cliente2.executaSQL("select * from cargo order by Cod_cargo");
        posicionarRegistro();
    }
    
    private class InicialPesquisar extends JDialog {
        Conexao con_cliente;
        JButton bvoltar;
        
        JTable tblClientes;
        JScrollPane scp_tabela;
        
        public  InicialPesquisar(Frame owner, String title, boolean modal) {
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
            imagemLabel.setBounds(450, 20, 250, 250);
            
            bvoltar.setBounds(15,550,100, 20);
            tblClientes.setBounds(15, 280, 850, 200);
            scp_tabela.setBounds(15, 280, 850, 200);
            
            tblClientes.setBackground(new Color(52, 53, 56));
            tblClientes.setForeground(new Color(72, 191, 178));
            
            tela1.setBackground(Color.white);
            tela1.add(tblClientes);
            tela1.add(scp_tabela);
            
            bvoltar.setForeground(new Color(72, 191, 178));
            bvoltar.setBackground(new Color(52, 53, 56));
            bvoltar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));
            
            tblClientes.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
        {null,null,null,null,null,null,null,null,null},
        {null,null,null,null,null,null,null,null,null},
        {null,null,null,null,null,null,null,null,null},    
        {null,null,null,null,null,null,null,null,null}    
        },
        new String [] {"Código_Func", "Código_Cargo", "Nome", "CPF" , "Turno", "Data Nascimento", "Sexo", "Endereço", "Telefone" })
        {
        boolean [] canEdit = new boolean [] {
            false,false,false,false,false,false,false,false,false};
        
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];}
        });
        scp_tabela.setViewportView(tblClientes);
        
            tblClientes.setAutoCreateRowSorter(true);
            
            bvoltar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frmpesquisar.setVisible(false);
                    frmpesquisar.dispose();
                }
            }
            );
            
            try {
                    String pesquisa = "Select * from funcionario where nome_Func like '" + t_nome.getText() + "%'";
                    con_cliente.executaSQL(pesquisa);
                    
                    if (con_cliente.resultset.first()) {
                       preencherTabela();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "\n Não existe dados com este paramêtro!!","Mensagem do Programa ", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException errosql) {
                    JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados!! :\n " +errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            
            tela1.add(imagemLabel);
            tela1.add(bvoltar);
            
            tblClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
        
        tblClientes.setFont(new java.awt.Font("Arial", 1, 12));
        
        
            
            setSize(900, 640);
            setResizable(false);
            setLocationRelativeTo(null);
        }
   
    
                public void preencherTabela() {
        tblClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblClientes.getColumnModel().getColumn(1).setPreferredWidth(60);
        tblClientes.getColumnModel().getColumn(2).setPreferredWidth(70);
        tblClientes.getColumnModel().getColumn(3).setPreferredWidth(60);
        tblClientes.getColumnModel().getColumn(4).setPreferredWidth(30);
        tblClientes.getColumnModel().getColumn(5).setPreferredWidth(65);
        tblClientes.getColumnModel().getColumn(6).setPreferredWidth(30);
        tblClientes.getColumnModel().getColumn(7).setPreferredWidth(90);
        tblClientes.getColumnModel().getColumn(8).setPreferredWidth(60);


        
        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setNumRows(0);
        
        
        try {
            con_cliente.resultset.beforeFirst(); 
        while (con_cliente.resultset.next()) {
            modelo.addRow (new Object[] {
                con_cliente.resultset.getString("Cod_func"),con_cliente.resultset.getString("Cod_cargo"),con_cliente.resultset.getString("Nome_func"),con_cliente.resultset.getString("CPF_func"),con_cliente.resultset.getString("Turno_func"),con_cliente.resultset.getString("DataNasc_func"),con_cliente.resultset.getString("Sexo_func"),con_cliente.resultset.getString("Endereco_func"),con_cliente.resultset.getString("Tel_func")
            });
        }
        }catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"\n Erro ao listar dados da tabela!! :\n"+erro ,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            }
    }}
    
    
    public void posicionarRegistro() {
        try {
             con_cliente.resultset.first();       
             mostrar_Dados(); // Chama o método que irá buscar o dado da tabela
         } catch (SQLException erro) {
             JOptionPane.showMessageDialog(null, "Não foi possível posicionar no primeiro registro:" + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
         }
    }


    public void mostrar_Dados() {
           try {
               t_cod_func.setText(con_cliente.resultset.getString("Cod_func")); // Associar a caixa de texto ao campo cod
               t_cod_cargo.setText(con_cliente.resultset.getString("Cod_cargo")); // Associar a caixa de texto ao campo nome
               t_nome.setText(con_cliente.resultset.getString("Nome_func"));
               t_cpf.setText(con_cliente.resultset.getString("CPF_func"));
               t_turno.setText(con_cliente.resultset.getString("Turno_func"));
               t_data_nasc.setText(con_cliente.resultset.getString("DataNasc_func"));
               t_sexo.setText(con_cliente.resultset.getString("Sexo_func"));
               t_endereco.setText(con_cliente.resultset.getString("Endereco_func"));
               t_telef.setText(con_cliente.resultset.getString("Tel_func"));
               atualizarDescricaoCargo();
           } catch (SQLException erro) {
               JOptionPane.showMessageDialog(null, "\n Não localizou dados: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
           }
       }
    
    
    private void atualizarDescricaoCargo() {
    try {
        String codCargo = t_cod_cargo.getText();
        String query = "SELECT Descricao_cargo FROM cargo WHERE Cod_cargo = " + codCargo;
        con_cliente2.executaSQL(query);
        
        if (con_cliente2.resultset.next()) {
            t_cargotwo.setText(con_cliente2.resultset.getString("Descricao_cargo"));
        } else {
            t_cargotwo.setText(""); // Limpar o campo se não houver correspondência
        }
    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar o cargo: " + erro, "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
    }
}    
}