
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

public class MenuCliente extends JFrame{

    JToolBar barra;
    JButton bcliente, banimal, sair;
    JLabel  usuario, animal, foto;
    ImageIcon imagens[];
    
    
    public MenuCliente() {
        
        setTitle("Página principal");
        setResizable(false);
        Container tela = getContentPane();
        tela.setLayout(null);
        
        ImageIcon imagem = new ImageIcon("img/Logo2.png");
        foto = new JLabel(imagem);
        
        ImageIcon icone = new ImageIcon("img/logo2.png");
        setIconImage(icone.getImage());
        
        foto.setBounds(70, 30, 250, 250);
        
        tela.setBackground(new Color(52,53,56));
        
             
        String icones[]={"img/Usuario.png","img/Animal.png"};
        imagens = new ImageIcon[2];
        for(int i = 0;i < 2;i++){
            imagens[i] = new ImageIcon(icones[i]);}
        bcliente = new JButton(imagens[0]);
        banimal = new JButton(imagens[1]);
        usuario = new JLabel("Usuario. ");
        animal = new JLabel("Animal. ");
        barra = new JToolBar("Barra de Ferramentas");
        sair = new JButton("Sair");
        barra.setRollover(true); 
        barra.add(bcliente);
        barra.add(usuario);
        usuario = new JLabel("Usuario. ");
        barra.addSeparator();
        barra.setFloatable(false);
        barra.add(banimal);
        barra.add(animal);
        animal = new JLabel("Animal. ");
             
        barra.setBounds(1,1,400,25);
        sair.setBounds(150, 300, 87, 20);
        
        barra.setBackground(new Color(72, 191, 178));
        bcliente.setBackground(new Color(72, 191, 178));
        banimal.setBackground(new Color(72, 191, 178));
        
        sair.setForeground(new Color(72, 191, 178));
        sair.setBackground(new Color(52, 53, 56));
        sair.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(72,191,178),2));
        
        
        bcliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                frmcliente = new InicialCliente(null, "Usuario", true);
//                frmcliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                frmcliente.setVisible(true);
                 
                Cliente mostra = new Cliente();
                mostra.setVisible(true);
                dispose();
            }
        }
        );
        
        banimal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                frmanimal = new InicialAnimal(null, "Animal", true);
//                frmanimal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                frmanimal.setVisible(true);
                  Animais mostra = new Animais();
                  mostra.setVisible(true);
                  dispose();
            }
        }
        );
        
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
        

       
        tela.add(barra);   
        tela.add(sair);
        tela.add(foto);
        tela.setLayout(null);
        setSize(400,400);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
    }
  
}
