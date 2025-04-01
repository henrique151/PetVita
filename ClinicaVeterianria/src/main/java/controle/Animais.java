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

public class Animais extends JFrame{
    Conexao con_cliente, con_cliente2;
        
        JToolBar barra;
        JButton bvoltar, cadastrar, alterar, excluir, pesquisar, primeiro, anterior, proximo, ultimo,novo;
        JLabel rotulo1, rnome, rraca, rnasc, rsexo, rcor, rpeso, rcliente, rcodigo_animal, voltar,tps_animal;
        JTextField tnome, traca, tsexo, tcor, tpeso, tcodigo_cliente, tanimal;
        ImageIcon imagens[];
        JFormattedTextField nasc;
        MaskFormatter mnasc;
        
        InicialPesquisar frmpesquisar;
        int contador = 1;
        
    public Animais(){

            Container tela = getContentPane();
            tela.setLayout(null);
            setTitle("Tela dos Animais");
            con_cliente = new Conexao(); 
            con_cliente.conecta(contador);
            
            con_cliente2 = new Conexao(); 
            con_cliente2.conecta(contador);
            
            String icones[]={"img/Voltar.png"};
            imagens = new ImageIcon[1];
            for(int i = 0;i < 1;i++){
                imagens[i] = new ImageIcon(icones[i]);}
            bvoltar = new JButton(imagens[0]);
            
            ImageIcon imagem = new ImageIcon("img/logo2.png");        
            ImageIcon icone = new ImageIcon("img/logo2.png");
            setIconImage(icone.getImage());
            JLabel imagemLabel = new JLabel(); 
            imagemLabel.setIcon(imagem);
            imagemLabel.setBounds(600, 30, 300, 300);
            tela.setBackground(new Color(241, 241, 241));
            
            voltar = new JLabel("Voltar para a pagina pricipal. ");
            barra = new JToolBar("Barra de Ferramentas");
            
            barra.setRollover(true);
            barra.add(bvoltar);
            barra.add(voltar);
            barra.setFloatable(false);

            barra.setBounds(1,1,1000,25);
            barra.setBackground(new Color(72, 191, 178));
            
            rotulo1 = new JLabel("Cadastrar seu Pet. ");
            rcliente = new JLabel("Codigo do Cliente: ");
            rnome = new JLabel("Nome do Animal: ");
            rraca = new JLabel("Raça: ");
            rsexo = new JLabel("Sexo: ");
            rnasc = new JLabel("Nascido em: ");
            rcor = new JLabel("Cor: ");
            rpeso = new JLabel("Peso: ");
            rcodigo_animal = new JLabel("Código do Animal: ");
            tps_animal = new JLabel("<html>1 - Cachorro <br> 2 - Gato <br> 3 - Cavalo <br> 4 - Ave <br> 5 - Tartaruga <br> 6 - Peixe <br> 7 - Hamster <br> 8 - Coelho <br> 9 - Iguana <br> 10 - Porquinho-da-Índia <br> 11 - Furão <br> 12 - Lhama </html>");

            
            tnome = new JTextField(20);
            traca = new JTextField(20);
            tsexo = new JTextField(20);
            tcor = new JTextField(20);
            tpeso = new JTextField(20);
            tcodigo_cliente = new JTextField(20);
            tanimal = new JTextField(20);
            
            try{
            mnasc = new MaskFormatter("##/##/####");
            mnasc.setPlaceholderCharacter('_');
            }
            catch(ParseException excp){}
            nasc = new JFormattedTextField(mnasc);
            
            
            primeiro = new JButton("Primeiro");
            anterior = new JButton("Anterior");
            proximo = new JButton("Próximo");
            ultimo = new JButton("Último");
            cadastrar = new JButton("Cadastrar");
            alterar = new JButton("Alterar");
            excluir = new JButton("Excluir");
            pesquisar = new JButton("Pesquisa");
            novo = new JButton("Novo Registro");
            
            alterar.setForeground(new Color(72, 191, 178));
            alterar.setBackground(new Color(52, 53, 56));
            alterar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));
            
            cadastrar.setForeground(new Color(72, 191, 178));
            cadastrar.setBackground(new Color(52, 53, 56));
            cadastrar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));
               
            
            
            rotulo1.setBounds(200, 40, 150, 20);
            rcliente.setBounds(25, 80, 200, 20);
            rcodigo_animal.setBounds(220, 80, 200, 25);
            rnome.setBounds(25, 105, 150, 20);
            rnasc.setBounds(25, 130, 80, 20);
            rraca.setBounds(25, 155, 80, 20);
            rpeso.setBounds(25, 185, 80, 20);            
            rcor.setBounds(25, 215, 80, 20);
            rsexo.setBounds(25, 245, 80, 20);
            
            tcodigo_cliente.setBounds(140, 80, 80, 25);
            tnome.setBounds(130, 105, 150, 25);
            nasc.setBounds(100, 130, 80, 25);
            traca.setBounds(70, 155, 80, 25);
            tpeso.setBounds(70, 185, 80, 25);
            tcor.setBounds(70, 215, 100, 25);
            tsexo.setBounds(70, 245, 100, 25);
            tps_animal.setBounds(450, 50, 150, 200);
            
            tanimal.setBounds(325, 80, 80, 25);
            
            tanimal.setEnabled(false);
           
            primeiro.setBounds(50, 400, 100, 20);
            anterior.setBounds(170, 400, 100, 20);
            proximo.setBounds(290, 400, 100, 20);
            ultimo.setBounds(410, 400, 100, 20);
             

            
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
            
            bvoltar.setBackground(new Color(72, 191, 178));
                        bvoltar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   MenuCliente mostra = new MenuCliente();
                        mostra.setVisible(true);
                        dispose();

                }
            }
            );
            
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
            
            cadastrar.addActionListener(new ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    String nome = tnome.getText();
                    String data_nasc = nasc.getText();
                    String raca = traca.getText();
                    String peso = tpeso.getText();
                    String cor = tcor.getText();
                    String sexo = tsexo.getText();
                        
                    // Obtenha o código do cliente do campo tcodigo_cliente
                    String codigo_cliente = tcodigo_cliente.getText();

                    
                        try {
                            String insert_sql = "INSERT INTO animais (Cod_cliente, Nome_animal, DataNasc_animal, Cod_raca, Peso_animal, Cor_animal, Sexo_animal) VALUES ('" + codigo_cliente + "','"+ nome + "','" + data_nasc + "','" + raca + "','" + peso + "','" + cor + "','" + sexo + "')";

                            con_cliente.statement.executeUpdate(insert_sql);

                            JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

                            // Atualize os resultados das consultas após a gravação
                            con_cliente.executaSQL("SELECT * FROM animais ORDER BY Cod_animal");
                            con_cliente2.executaSQL("select * from cliente order by Cod_cliente");
                            posicionarRegistro();
                          
                        } catch (SQLException errosql) {
                            JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    }                 
                }
                
            });
            
            alterar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        String nome =  tnome.getText();
                        String data_nasc = nasc.getText();
                        String raca = traca.getText();
                        String peso = tpeso.getText();
                        String cor = tcor.getText();
                        String sexo = tsexo.getText();
                        String codigo_animal = tanimal.getText();
                        
                        String sql;
                        String msg = "";

                    try {
                        sql="update animais set Nome_animal='" + nome + "', DataNasc_animal='" + data_nasc + "', Cod_raca='" + raca + "', Peso_animal='" + peso + "', Cor_animal='" + cor + "', Sexo_animal='" + sexo + "'  where Cod_animal = " +  codigo_animal;
                        // sql2="update cargo set Descricao_cargo='" + cargo + "' where Cod_cargo = " + t_cod_cargo.getText();
                        msg = "Alteração de um novo registro";
                                                
                        con_cliente.statement.executeUpdate(sql);
                                                
                        JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE );

                        con_cliente.executaSQL("select * from animais order by Cod_animal");
                        posicionarRegistro();
                    } catch(SQLException errosql) {
                         JOptionPane.showMessageDialog(null, "Erro na gravação: " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });
            
            excluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opcao;
                Object[] botoes = {"Sim", "Não"};
                opcao = JOptionPane.showOptionDialog(null,"Deseja excluir o registro?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,botoes,botoes[0]);
                    if (opcao == JOptionPane.YES_OPTION) {
                        String sql = "DELETE FROM animais WHERE Cod_Animal = " + tanimal.getText();
                        try {
                            int excluir = con_cliente.statement.executeUpdate(sql);

                            if (excluir == 1) {
                                JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                                con_cliente.executaSQL("select * from animais order by Cod_animal");
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
            
            novo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               tanimal.setText("");
               tcodigo_cliente.setText("");
               tcor.setText("");
               tnome.setText("");
               tpeso.setText("");
               traca.setText("");
               tsexo.setText("");
               nasc.setText("");
               
            }
        }
        );
            
            pesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmpesquisar = new InicialPesquisar(null, "Pesquisar", true);
                frmpesquisar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frmpesquisar.setVisible(true);
            }
        }
        );        

            tela.add(rcodigo_animal);
            tela.add(rotulo1);
            tela.add(rnome);
            tela.add(rraca);
            tela.add(rsexo);
            tela.add(rnasc);
            tela.add(rcor);
            tela.add(rpeso);
            tela.add(tnome);
            tela.add(traca);
            tela.add(tsexo);
            tela.add(tcor);
            tela.add(tpeso);
            tela.add(tps_animal);
            
            tela.add(nasc);
            tela.add(barra);
            tela.add(cadastrar);
            tela.add(alterar);
            tela.add(tcodigo_cliente);
            tela.add(rcliente);
            tela.add(tanimal);
            tela.add(excluir);
            tela.add(pesquisar);
            tela.add(primeiro);
            tela.add(anterior);
            tela.add(proximo);
            tela.add(ultimo);
            tela.add(novo);
            tela.add(imagemLabel);
            setSize(900, 540);
            setResizable(false);
            setLocationRelativeTo(null);
            
            con_cliente.executaSQL("select * from animais order by Cod_animal");
            con_cliente2.executaSQL("select * from cliente order by Cod_cliente");
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
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null}
                },
                new String[]{"Código_Animal", "Código_Cliente", "Nome_Animal", "Data", "Código", "Peso", "Cor", "Sexo"})
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
            String pesquisa = "Select * from animais where Nome_animal like '" + tnome.getText() + "%'";
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
        tblClientes.getColumnModel().getColumn(0).setPreferredWidth(40);
        tblClientes.getColumnModel().getColumn(1).setPreferredWidth(40);
        tblClientes.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblClientes.getColumnModel().getColumn(3).setPreferredWidth(40);
        tblClientes.getColumnModel().getColumn(4).setPreferredWidth(20);
        tblClientes.getColumnModel().getColumn(5).setPreferredWidth(40);
        tblClientes.getColumnModel().getColumn(6).setPreferredWidth(30);
        tblClientes.getColumnModel().getColumn(7).setPreferredWidth(80);

        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setNumRows(0);

        try {
            con_cliente.resultset.beforeFirst();
            while (con_cliente.resultset.next()) {
                modelo.addRow(new Object[]{
                    con_cliente.resultset.getString("Cod_animal"), con_cliente.resultset.getString("Cod_cliente"), con_cliente.resultset.getString("Nome_animal"), con_cliente.resultset.getString("DataNasc_animal"), con_cliente.resultset.getString("Cod_raca"), con_cliente.resultset.getString("Peso_animal"), con_cliente.resultset.getString("Cor_animal"), con_cliente.resultset.getString("Sexo_animal")
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
                 mostrar_Dados();
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Não foi possivel posicionar no primeiro registro:" + erro, "Mesangem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
         public void mostrar_Dados() {
           try {
               tanimal.setText(con_cliente.resultset.getString("Cod_animal")); // Associar a caixa de texto ao campo cod
               tcodigo_cliente.setText(con_cliente.resultset.getString("Cod_cliente")); // Associar a caixa de texto ao campo nome
               tnome.setText(con_cliente.resultset.getString("Nome_animal"));
               nasc.setText(con_cliente.resultset.getString("DataNasc_animal"));
               traca.setText(con_cliente.resultset.getString("Cod_raca"));
               tpeso.setText(con_cliente.resultset.getString("Peso_animal"));
               tcor.setText(con_cliente.resultset.getString("Cor_animal"));
               tsexo.setText(con_cliente.resultset.getString("Sexo_animal"));
           } catch (SQLException erro) {
               JOptionPane.showMessageDialog(null, "\n Não localizou dados: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
           }
       }
    
  
    }

