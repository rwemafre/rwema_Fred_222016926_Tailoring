package tailoring_pac;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;



public class Admin_reserves implements ActionListener,MenuListener{
	private static final Object Successful = null;

	JFrame frame;
	

	
	
	
	
JMenuBar myMenuBar = new JMenuBar();
	
JMenu myMenuS =new JMenu("SERVICE");
JMenu myMenuC =new JMenu("RESERVES");

JMenu myMenuP =new JMenu("CUSTOMERS");

JMenu myMenuL =new JMenu("LOGOUT");
    
    JButton list=new JButton("VIEW LIST OF ALL RESERVES");
    private JLabel title=new JLabel("CLICK HERE TO DISPLAY LIST OF ALL RESERVES");
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	private JLabel code_l=new JLabel("ORDER ID");
	JTextField code_f=new JTextField();
	
	JButton delete=new JButton("APPROVE RESERVE");
//	JButton view=new JButton("VIEW");
//	JButton update=new JButton("UPDATE");
	
	
	public Admin_reserves() {
		createWindow();
		setLocationAndSize();
		AddComponenttoFrame();
		addActionEvent();
	}
	private void addActionEvent() {
//		resetbtn.addActionListener(this);
//		submit.addActionListener(this);
		delete.addActionListener(this);
//		view.addActionListener(this);
		
		list.addActionListener(this);
//	//menu
		myMenuS.addMenuListener(this);
		myMenuP.addMenuListener(this);
		myMenuC.addMenuListener(this);
//		myMenuV.addMenuListener(this);
		myMenuL.addMenuListener(this);
}
////////////////////ADD ELEMENTS TO FRAME///////////////////////////////////////////////////////////////////////////
	private void AddComponenttoFrame() {
		
	

		frame.add(code_l);
		frame.add(code_f);
		
		frame.add(delete);
//		frame.add(view);
        
		//menu
		
        frame.add(myMenuBar);
		
		myMenuBar.add(myMenuS);
		myMenuBar.add(myMenuC);
		myMenuBar.add(myMenuP);
//		myMenuBar.add(myMenuV);
		myMenuBar.add(myMenuL);
		
		frame.add(title);
		frame.add(list);
	}
	
/////////////////////////////POSITIONING//////////////////////////////////////////////////////////////////
	private void setLocationAndSize() {
//		formtitle.setBounds(20, 220, 200, 30);
		
		code_l.setBounds(20, 100, 200, 30);
		code_f.setBounds(210, 100, 150, 30);
		
		delete.setBounds(20, 150, 220, 30);
//		view.setBounds(210, 150, 150, 30);
		
	
		

		myMenuBar.setBounds(10, 20, 700, 30);
		
		title.setBounds(370, 80, 350, 30);
		list.setBounds(370, 119, 350, 60);
	}
	
//////////////////////_____WINDOW________/////////////////////////////////////////////////////////////////////////
	private void createWindow() {
		frame=new JFrame();
		frame.setTitle("ADMIN  MANAGE RESERVES");
		frame.setBounds(10,10,770,670);
		frame.getContentPane().setBackground(Color.gray);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
//		update.getRootPane().setBackground(Color.gray);
	}
	@Override
	
	public void actionPerformed(ActionEvent e) {
 if(e.getSource()==delete) {
		
	 try {  
		  Class.forName("com.mysql.jdbc.Driver");  
	        // establish connection  
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/tailoring", "root", "");  
	        Statement st = con.createStatement();  
	      
	        String ID = code_f.getText();
	        String status = "approved";
//	        
	        if(!ID.equals("") ){
	        	
	        st.executeUpdate("update reserves set status='" +status+ "'  where reserveID="+code_f.getText()+"");
	        JOptionPane.showMessageDialog(code_f, "order eccepted Successful");
	        }else {
	        	JOptionPane.showMessageDialog(null, "fill all field please!");
	        }
	          
	   
	    } catch (SQLException | ClassNotFoundException e1) {  
	         
	    }   	
	}
	
	else if(e.getSource()==list) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List_of_reserves frame = new List_of_reserves();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		
		});
		
		
	}//end of if change
		
	}	
	 public void menuSelected(MenuEvent e) {
	      JMenu myMenuS = (JMenu) e.getSource();
	      JMenu myMenuP = (JMenu) e.getSource();
	      JMenu myMenuC = (JMenu) e.getSource();
//	      JMenu myMenuV = (JMenu) e.getSource();
	      JMenu myMenuL = (JMenu) e.getSource();
	      
	      
	      
//	      System.out.println("Menu Selected: "+myMenuS.getText());
	      
	      if(myMenuS.getText()=="SERVICE")
	      {
	    	
	    	  Admin_service anyname=new Admin_service();
	   			frame.dispose();
	      }
	      if(myMenuP.getText()=="CUSTOMERS")
	      {
	    	  
	    	
	    	  Admin_customer anyname=new Admin_customer();	
	    	  frame.dispose();
	      }
	      
	      if(myMenuC.getText()=="RESERVES")
	      {
	    	
	    	  Admin_reserves anyname=new Admin_reserves();	
	    	  frame.dispose();
	      }
	      
	   
	      if(myMenuL.getText()=="LOGOUT")
	      {
	    	
	    	  LoginForm obj = new LoginForm();
//	    	  obj.my_update(v_code.getText());
	    	  frame.dispose();
	    	  
	    	  
	    	  
	    	  
	      }
	   }
//	

///////////////////////////////////////////////////////////////////////////////////////////////
public static void main(String []args) {
	Admin_reserves anyname=new Admin_reserves();
}

@Override
public void menuDeselected(MenuEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void menuCanceled(MenuEvent e) {
	// TODO Auto-generated method stub
	
}
}
