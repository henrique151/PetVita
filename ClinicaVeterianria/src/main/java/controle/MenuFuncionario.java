package controle;


import java.awt.*;
import java.text.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import conexao.Conexao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuFuncionario extends JFrame{
    JMenuBar barra;
    JMenu opcoes;
    JMenuItem adminBarra;
    JLabel img, titulo2;
    JButton sair;
    
    public MenuFuncionario(){
        
        Container tela = getContentPane();
        tela.setLayout(null);
        
        setTitle("Menu do Funcionário");
        setResizable(false);
        
        tela.setBackground(new Color(52,53,56));
        
        ImageIcon image = new ImageIcon("img/admin.png");
        img = new JLabel(image);
        
        ImageIcon icone = new ImageIcon("img/logo2.png");
        setIconImage(icone.getImage());
        
        sair = new JButton("Sair");
        
        titulo2 = new JLabel("Admin");
        
        barra = new JMenuBar();
        opcoes = new JMenu("Menus");
        adminBarra = new JMenuItem("Admin");
        

        titulo2.setForeground(new Color(72, 191, 178));

        titulo2.setBounds(355, 80, 130, 20);
        
        titulo2.setFont(new Font("Arial", Font.BOLD, 20));
        
        img.setBounds(220, 100, 400, 300);;
        
        sair.setBounds(350,450,80,20);
        
        sair.setForeground(new Color(72, 191, 178));
        sair.setBackground(new Color(52, 53, 56));
        sair.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));
        
        class MinhaActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funcionario mostra = new Funcionario();
                mostra.setVisible(true);
                dispose();
            }

        }

        img.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new MinhaActionListener().actionPerformed(null);
            }

        });
       

        
        adminBarra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Funcionario mostra = new Funcionario();
              mostra.setVisible(true);
                dispose();
            }
        });
        
        sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opcao;
                Object[] botoes = {"Sim", "Não"};
                opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo fechar?", "Fechar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,botoes,botoes[0]);
                    if (opcao == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        }
        );
        
        barra.add(opcoes);
        setJMenuBar(barra);
        
        opcoes.add(adminBarra);
        tela.add(img);
        tela.add(titulo2);
        tela.add(sair);
        
        setSize(800,600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
