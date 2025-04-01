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


public class Consulta extends JFrame {
    Conexao con_cliente;
    
    JMenuBar barra;
    JMenu opcoes;
    JMenuItem alterartwo, gravartwo, excluirtwo,pesquisartwo;
    
    JLabel l_cod_cons, l_dthr_cons, l_cod_animal, l_cod_func, l_desc_cons, l_rec, img;
    JTextField t_cod_cons, t_dthr_cons, t_cod_animal, t_cod_func;
    JButton  primeiro, anterior, proximo, ultimo, alterar, gravar, excluir ,voltar,pesquisar, novo;
    JScrollPane painelrolagem,painelrolagem2;
    JPanel painel,painel2;
    JTextArea t_rec, t_desc_cons;
    InicialPesquisar frmpesquisar;
    
    int contador = 1;
    
public Consulta(){
    Container tela = getContentPane();
        tela.setLayout(null);
               
        con_cliente = new Conexao(); 
        con_cliente.conecta(contador);
        
        
        setTitle("Tela da Consulta");
        setResizable(false);
                        
        ImageIcon imagem = new ImageIcon("img/logo3.png");
        ImageIcon icone = new ImageIcon("img/logo2.png");
        setIconImage(icone.getImage());
        
        JLabel imagemLabel = new JLabel(); 
        imagemLabel.setIcon(imagem);
        imagemLabel.setBounds(600, 5, 200, 200);
        tela.setBackground(new Color(241, 241, 241));
        
        barra = new JMenuBar();
        opcoes = new JMenu("Menus");
        alterartwo = new JMenuItem("Alterar");
        excluirtwo = new JMenuItem("Excluir");
        gravartwo = new JMenuItem("Gravar");
        pesquisartwo = new JMenuItem("Pesquisar (Data Hora)");
        
        t_rec = new JTextArea(10,20);
        t_rec.setLineWrap(true);
        t_rec.setWrapStyleWord(true);
                
        t_desc_cons = new JTextArea(10,20);
        t_desc_cons.setLineWrap(true);
        t_desc_cons.setWrapStyleWord(true);
                
        painelrolagem = new JScrollPane(t_rec);
        painelrolagem2 = new JScrollPane(t_desc_cons);
        painelrolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        painelrolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        painelrolagem2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        painelrolagem2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                
        painel = new JPanel();
        painel.add(painelrolagem);
        painel.setBounds(40, 230, 250, 250);
        painel.setBackground(new Color(241, 241, 241));
        
        painel2 = new JPanel();
        painel2.add(painelrolagem2);
        painel2.setBounds(450, 230, 250, 250);
        painel2.setBackground(new Color(241, 241, 241));
        
        primeiro = new JButton("Primeiro");
        anterior = new JButton("Anterior");
        proximo = new JButton("Próximo");
        ultimo = new JButton("Último");
        alterar = new JButton("Alterar");
        voltar = new JButton("Sair");
        gravar = new JButton("Gravar");
        excluir = new JButton("Excluir");
        pesquisar = new JButton("Pesquisar (Data Hora)");
        novo = new JButton("Novo Registro");
        
        l_cod_cons = new JLabel("Código da Consulta:");
        l_dthr_cons = new JLabel("Data e Hora da Consulta:");
        l_cod_animal = new JLabel("Código do animal:");
        l_cod_func = new JLabel("Código do funcionário:");
        l_desc_cons = new JLabel("Descrição da Consulta:");
        l_rec = new JLabel("Receita:");
        
        t_cod_animal = new JTextField(5);
        t_cod_cons = new JTextField(5);
        t_cod_func = new JTextField(5);
        t_dthr_cons = new JTextField(10);
                
        l_cod_cons.setBounds(50, 10, 200,20);
        l_dthr_cons.setBounds(50, 50, 200,20);
        l_cod_animal.setBounds(50,90,200,20);
        l_cod_func.setBounds(50,130,200,20);
        l_desc_cons.setBounds(450, 210, 200,20); 
        l_rec.setBounds(40, 210,100,20); 

        t_cod_cons.setBounds(230, 10, 50,25);
        t_dthr_cons.setBounds(230, 50,130,25);
        t_cod_animal.setBounds(230,90,50,25);
        t_cod_func.setBounds(230,130,50,25);
        t_desc_cons.setBounds(230,170,100,25);
        
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
        
        l_cod_animal.setForeground(new Color(72, 191, 178));
        l_cod_cons.setForeground(new Color(72, 191, 178));
        l_cod_func.setForeground(new Color(72, 191, 178));
        l_desc_cons.setForeground(new Color(72, 191, 178));
        l_dthr_cons.setForeground(new Color(72, 191, 178));
        l_rec.setForeground(new Color(72, 191, 178));
                
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
        
        
        tela.add(imagemLabel);
        
        tela.add(l_cod_animal);
        tela.add(l_cod_cons);
        tela.add(l_cod_func);
        tela.add(l_desc_cons);
        tela.add(l_dthr_cons);
        tela.add(l_rec);
        
        tela.add(t_cod_animal);
        tela.add(t_cod_cons);
        tela.add(t_cod_func);
        tela.add(t_dthr_cons);
        
        tela.add(primeiro);
        tela.add(anterior);
        tela.add(proximo);
        tela.add(ultimo);
        tela.add(alterar);
        tela.add(voltar);  
        tela.add(gravar);
        tela.add(excluir);
        tela.add(pesquisar);
        tela.add(novo);
        
        tela.add(painel);
        tela.add(painel2);
        
        barra.add(opcoes);
        setJMenuBar(barra);
        
        opcoes.add(alterartwo);
        opcoes.add(gravartwo);
        opcoes.add(excluirtwo);
        opcoes.add(pesquisartwo);
        
        voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opcao;
                Object[] botoes = {"Sim", "Não"};
                opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo fechar?", "Fechar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,botoes,botoes[0]);
                    if (opcao == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
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
                        String sql = "DELETE FROM consulta WHERE Cod_consulta = " + t_cod_cons.getText();
                        try {
                            int excluir = con_cliente.statement.executeUpdate(sql);

                            if (excluir == 1) {
                                JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                                con_cliente.executaSQL("select * from consulta order by Cod_consulta");
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
                        String sql = "DELETE FROM consulta WHERE Cod_consulta = " + t_cod_cons.getText();
                        try {
                            int excluir = con_cliente.statement.executeUpdate(sql);

                            if (excluir == 1) {
                                JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                                con_cliente.executaSQL("select * from consulta order by Cod_consulta");
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
               t_cod_cons.setText("");
               t_dthr_cons.setText("");
               t_cod_animal.setText("");
               t_cod_func.setText("");
               t_desc_cons.setText("");
               t_rec.setText("");
               
            }
        }
        );

        
        
        
        alterartwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cod_animal =  t_cod_animal.getText();
                String cod_cons = t_cod_cons.getText();
                String cod_func = t_cod_func.getText();
                String desc_cons = t_desc_cons.getText();
                String dthr_cons = t_dthr_cons.getText();
                String receita = t_rec.getText();
                String sql;
                String msg = "";
                
                try {
                    sql="update consulta set DataHora_consulta='" + dthr_cons + "', Cod_animal='" + cod_animal + "', Cod_func='" + cod_func + "', Descricao_consulta='" + desc_cons + "', Receita='" + receita + "' where Cod_consulta = " +  t_cod_cons.getText();
                    msg = "Alteração de um novo registro";
                    
                    con_cliente.statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE );
                    
                    con_cliente.executaSQL("select * from consulta order by Cod_consulta");
                    posicionarRegistro();
                } catch(SQLException errosql) {
                     JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        
        alterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cod_animal =  t_cod_animal.getText();
                String cod_cons = t_cod_cons.getText();
                String cod_func = t_cod_func.getText();
                String desc_cons = t_desc_cons.getText();
                String dthr_cons = t_dthr_cons.getText();
                String receita = t_rec.getText();
                String sql;
                String msg = "";
                
                try {
                    sql="update consulta set DataHora_consulta='" + dthr_cons + "', Cod_animal='" + cod_animal + "', Cod_func='" + cod_func + "', Descricao_consulta='" + desc_cons + "', Receita='" + receita + "' where Cod_consulta = " +  t_cod_cons.getText();
                    msg = "Alteração de um novo registro";
                    
                    con_cliente.statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE );
                    
                    con_cliente.executaSQL("select * from consulta order by Cod_consulta");
                    posicionarRegistro();
                } catch(SQLException errosql) {
                     JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        gravar.addActionListener(new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            String cod_animal =  t_cod_animal.getText();
                String cod_cons = t_cod_cons.getText();
                String cod_func = t_cod_func.getText();
                String desc_cons = t_desc_cons.getText();
                String dthr_cons = t_dthr_cons.getText();
                String receita = t_rec.getText();

            try {
                String insert_sql = "insert into consulta (DataHora_consulta, Cod_animal, Cod_func, Descricao_consulta, Receita) values ('" + dthr_cons  + "','" + cod_animal + "','" + cod_func + "','" + desc_cons + "','" + receita + "')";
                // String insert_sql2 = "insert into cargo (Cod_cargo, Descricao_cargo) values ('" + Codigo  + "','" + cargo + "')";
            
                con_cliente.statement.executeUpdate(insert_sql);
                //con_cliente2.statement.executeUpdate(insert_sql2);
                JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                // Atualize os resultados das consultas após a gravação
                con_cliente.executaSQL("select * from consulta order by Cod_consulta");
                posicionarRegistro();
                //con_cliente2.executaSQL("select * from cargo order by Cod_cargo");
            } catch (SQLException errosql) {
                JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        });
        
        gravartwo.addActionListener(new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            String cod_animal =  t_cod_animal.getText();
                String cod_cons = t_cod_cons.getText();
                String cod_func = t_cod_func.getText();
                String desc_cons = t_desc_cons.getText();
                String dthr_cons = t_dthr_cons.getText();
                String receita = t_rec.getText();

            try {
                String insert_sql = "insert into consulta (DataHora_consulta, Cod_animal, Cod_func, Descricao_consulta, Receita) values ('" + dthr_cons  + "','" + cod_animal + "','" + cod_func + "','" + desc_cons + "','" + receita + "')";
            
                con_cliente.statement.executeUpdate(insert_sql);
                //con_cliente2.statement.executeUpdate(insert_sql2);

                JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

                // Atualize os resultados das consultas após a gravação
                con_cliente.executaSQL("select * from consulta order by Cod_consulta");
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
        
        con_cliente.executaSQL("select * from consulta order by Cod_consulta");
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
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null}
                },
                new String[]{"Código_Consulta", "Data_Hora", "Cod_Animal","Cod_func", "Descrição", "Receita"})
        {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
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
            String pesquisa = "Select * from consulta where DataHora_consulta like '" + t_dthr_cons.getText() + "%'";
            con_cliente.executaSQL(pesquisa);

            if (con_cliente.resultset.first()) {
                preencherTabela();
            } else {
                JOptionPane.showMessageDialog(null, "\n Não existe dados com este parâmetro!!", "Mensagem do Programa ", JOptionPane.INFORMATION_MESSAGE);
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
        tblClientes.getColumnModel().getColumn(1).setPreferredWidth(40);
        tblClientes.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblClientes.getColumnModel().getColumn(3).setPreferredWidth(40);
        tblClientes.getColumnModel().getColumn(4).setPreferredWidth(20);
        tblClientes.getColumnModel().getColumn(5).setPreferredWidth(40);

        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setNumRows(0);

        try {
            con_cliente.resultset.beforeFirst();
            while (con_cliente.resultset.next()) {
                modelo.addRow(new Object[]{
                    con_cliente.resultset.getString("Cod_consulta"),
                    con_cliente.resultset.getString("DataHora_consulta"), 
                    con_cliente.resultset.getString("Cod_animal"),
                    con_cliente.resultset.getString("Cod_func"),
                    con_cliente.resultset.getString("Descricao_consulta"),
                    con_cliente.resultset.getString("Receita"),
                });
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!! :\n" + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    }
    
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
        t_cod_cons.setText(con_cliente.resultset.getString("Cod_consulta"));
        t_dthr_cons.setText(con_cliente.resultset.getString("DataHora_consulta"));
        t_cod_animal.setText(con_cliente.resultset.getString("Cod_animal"));
        t_cod_func.setText(con_cliente.resultset.getString("Cod_func"));
        t_desc_cons.setText(con_cliente.resultset.getString("Descricao_consulta"));
        t_rec.setText(con_cliente.resultset.getString("Receita"));

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "\n Não localizou dados:"  + erro , "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
    }
}

        
        }
   
   
       

