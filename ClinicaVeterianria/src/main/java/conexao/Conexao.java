/* 
    * Esta classe será reponsável pela conexão com o MySQL e terá 3 métodos:
    * --- Método 1: Abertura da conexão
    * --- Método 2: Fechamento da conexão
    * --- Método 3: Execução de comandos SQL
*/

package conexao;

import javax.swing.JOptionPane;
import java.sql.*; // Para execução de comandos SQL no ambiente Java

public class Conexao {
    final private String driver = "com.mysql.cj.jdbc.Driver"; // Definição do driver MySql para acesso aos dados
    final private String url = "jdbc:mysql://localhost/bd_clinicaveterinaria"; // Acesso ao bd "clientes" no servidor (myAdmin)
    final private String usuario = "root"; // Usuário do MySql
    final private String senha = ""; // Senha do MySql
    private Connection conexao; // Variável que armazenará a conexão aberta
    public Statement statement; // Variável para execução dos comandos SQL dentro do ambiente Java
    public ResultSet resultset; // Variável que armazenará o resultado da execução de um comando SQL
    
    public boolean conecta(int contador) {
        boolean result = true;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,usuario,senha);
            if(contador == 0) {
                JOptionPane.showMessageDialog(null, "Conexão estabelecida", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null, "Driver não localizado" + Driver, "Mesangem do Programa", JOptionPane.INFORMATION_MESSAGE);
            result = false;
        } catch (SQLException Fonte) {
            JOptionPane.showMessageDialog(null, "Fonte de dados não localizado!"+Fonte, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
        return result;
    }
    
    public void desconecta() {
        try {
            conexao.close();
            JOptionPane.showMessageDialog(null, "Conexão com o banco fechada", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException fecha) {
            JOptionPane.showMessageDialog(null,"Erro ao fechar o banco", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void executaSQL(String sql) {
        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        } catch (SQLException excecao) {
            JOptionPane.showMessageDialog(null, "Erro no comando SQL! \n Erro: " + excecao, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
