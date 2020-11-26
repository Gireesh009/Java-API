
package projava;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


/**
 *
 * @author GIRI
 */
public class viewreg extends JFrame implements ActionListener{
    
    JTable t1;
   
    String x[] = {"Name","Father name","Date of Birth","Gender","email","adress","pin"};
    String y[][] = new String[20][7];
    int i=0, j=0;
    
    viewreg(){
        super("View Details");
        setSize(1200,650);
        setLocation(200,200);
     		 String pname = JOptionPane.showInputDialog("Enter name");

        
        try{
            conn c1  = new conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM registration where name = '" + pname + "'");
          
            while(rs.next()){
                y[i][j++]=rs.getString("Name");
                y[i][j++]=rs.getString("Father name");
                y[i][j++]=rs.getString("Date of Birth");
                y[i][j++]=rs.getString("Gender");
                y[i][j++]=rs.getString("email");
                 y[i][j++]=rs.getString("adress");
                  y[i][j++]=rs.getString("pin");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
     
    }
    public void actionPerformed(ActionEvent ae){
        try{
            t1.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new viewreg().setVisible(true);
    }
    
}
