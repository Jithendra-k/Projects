package P_12;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.io.FileNotFoundException;
public class GUIDemo extends GUI
{
	public static void main(String[] args) throws FileNotFoundException
	{
		GUI k=new GUI();
	}
}

class GUI implements ActionListener, ItemListener
{

	JFrame f;
	JLabel background,background1,t,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JRadioButton r1,r2;
	JComboBox<String> c1,c2,c3,c4,c5,c6;
	ButtonGroup g;
	JTextField t1,t2;
	JButton b1,b2;
	public GUI()
	{
		f=new JFrame("OP Registration");
		f.setSize(1600,700);
		f.setLayout(null);
		t = new JLabel();
		t.setText("Srinivas Hospital's");
		t.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
		t.setBackground(Color.CYAN);
		t.setBounds(600,60, 600, 106);
		f.getContentPane().add(t);
		
		ImageIcon img1=new ImageIcon("plus1.jpg");
		background1 =new JLabel("",img1,JLabel.CENTER);
		background1.setBounds(280,90,550,50);
		
		
		ImageIcon img=new ImageIcon("hospital.jpg");
		background =new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,1500,650);
		
		l1=new JLabel("Name");
		l1.setBackground(Color.PINK);
		l1.setFont(new Font("Tahoma", Font.BOLD, 16));
		l2=new JLabel("Age");
		l2.setBackground(Color.PINK);
		l2.setFont(new Font("Tahoma", Font.BOLD, 16));
		l3=new JLabel("Gender");
		l3.setBackground(Color.PINK);
		l3.setFont(new Font("Tahoma", Font.BOLD, 16));
		l4=new JLabel("Ailment");
		l4.setBackground(Color.PINK);
		l4.setFont(new Font("Tahoma", Font.BOLD, 16));
		l5=new JLabel("Doctor");
		l5.setBackground(Color.PINK);
		l5.setFont(new Font("Tahoma", Font.BOLD, 16));
		l6=new JLabel("Date");
		l6.setBackground(Color.PINK);
		l6.setFont(new Font("Tahoma", Font.BOLD, 16));
		l7=new JLabel("Day");
		l8=new JLabel("Month");
		l9=new JLabel("Year");
		l10=new JLabel("Time");
		l10.setBackground(Color.PINK);
		l10.setFont(new Font("Tahoma", Font.BOLD, 16));
		t1=new JTextField(20);
		t2=new JTextField(10);
		r1=new JRadioButton("M");
		r2=new JRadioButton("F");
		g=new ButtonGroup();
		g.add(r1);g.add(r2);
		c1=new JComboBox<String>();
		c1.addItem("SELECT");
		c1.addItem("ENT");
		c1.addItem("Neuromuscular");
		c1.addItem("Nervous related");
		c1.addItem("Cardiovascular");
		c1.addItem("Eye related");
		c1.addItem("Endocrinology and diabetes");
		c1.addItemListener(this);
		c2=new JComboBox<String>();
		c3=new JComboBox<String>();
		c4=new JComboBox<String>();
		c4.addItem("SELECT");
		c4.addItem("Jan");
		c4.addItem("Feb");
		c4.addItem("Mar");
		c4.addItem("Apr");
		c4.addItem("May");
		c4.addItem("Jun");
		c4.addItem("Jul");
		c4.addItem("Aug");
		c4.addItem("Sep");
		c4.addItem("Oct");
		c4.addItem("Nov");
		c4.addItem("Dec");
		c4.addItemListener(this);
		c5=new JComboBox<String>();
		c5.addItem("2020");
		c6=new JComboBox<String>();
		c6.addItem("SELECT");
		c6.addItem("10:30-12:30");
		c6.addItem("15:30-17:30");
		c6.addItem("18:30-20:30");
		b1=new JButton("Submit");
		b1.setBackground(Color.CYAN);
		b2=new JButton("Reset");
		b2.setBackground(Color.CYAN);
		f.setLayout(null);
		f.setVisible(true);
		f.add(l1).setBounds(50,150,700,30);
		f.add(t1).setBounds(175,150,100,30);
		f.add(l2).setBounds(50,200,50,30);
		f.add(t2).setBounds(175,200,50,30);
		f.add(l3).setBounds(50,250,75,30);
		f.add(r1).setBounds(175,250,50,30);
		f.add(r2).setBounds(230,250,50,30);
		f.add(l4).setBounds(50,300,100,30);
		f.add(c1).setBounds(175,300,150,30);
		f.add(l5).setBounds(50,350,100,30);
		f.add(c2).setBounds(175,350,150,30);
		f.add(l6).setBounds(50,400,100,30);
		f.add(l7).setBounds(175,400,50,30);
		f.add(c3).setBounds(220,400,50,30);
		f.add(l8).setBounds(285,400,50,30);
		f.add(c4).setBounds(335,400,100,30);
		f.add(l9).setBounds(450,400,50,30);
		f.add(c5).setBounds(500,400,70,30);
		f.add(l10).setBounds(50,450,100,30);
		f.add(c6).setBounds(175,450,100,30);
		f.add(b1).setBounds(50,550,100,30);
		f.add(b2).setBounds(175,550,100,30);
		f.add(background1);
		f.add(background);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b2)
		{
		t1.setText(null);
		t2.setText(null);
		r2.setSelected(true);
		c1.setSelectedIndex(0);
		c4.setSelectedIndex(0);
		c6.setSelectedIndex(0);
		}
	
	else if(e.getSource()==b1)
	{
		File f=new File("Hospital.txt");
		try
		{
			PrintWriter p=new PrintWriter(f);
			boolean q[]= {true,true,true,true,true};
			String i=t1.getText(),s=t2.getText();
			int n;
			n=Integer.parseInt(s);
			//---------------------------------------------------------------------------------------------------------
			if(isN(i))
			{
				q[0]=false;JOptionPane.showMessageDialog(t1,"Invalid Name");
			}
		
			if(isA(n))
			{		
				q[1]=false; JOptionPane.showMessageDialog(t2, " Invalid Age");
			}
		
			int c=c1.getSelectedIndex();
		
			if(c==0)
			{
				q[3]=false; JOptionPane.showMessageDialog(c1, "Select the ailment");
			}
			int cc=c2.getSelectedIndex();
		
			if(c4.getSelectedIndex()==0)
			{	
				q[3]=false; JOptionPane.showMessageDialog(c4,"Invalid Date");
			}
		
			if(c6.getSelectedIndex()==0)
			{
				q[4]=false; JOptionPane.showMessageDialog(c6,"Invalid Time");
			}
			if(q[0]&&q[1]&&q[2]&&q[3]&&q[4])
			{
				p.println("Name:"+t1.getText().trim());
				p.println("Age:"+t2.getText().trim());
				System.out.println("Name:"+t1.getText().trim());
				System.out.println("Age:"+t2.getText().trim());
		
				if(r1.isSelected())
				{
					System.out.println("Gender:Male");
					p.println("Gender:Male");
				}
	
				else
				{
					System.out.println("Gender:Female");
					p.println("Gender:Female");
				}
	
				System.out.println("Ailment:"+c1.getSelectedItem());
				p.println("Problem: "+c1.getSelectedItem());
				System.out.println("Doc:"+c2.getSelectedItem());
				p.println("Doc: "+c2.getSelectedItem());
				System.out.println("Appointment on "+c3.getSelectedItem()+"/"+c4.getSelectedIndex()+"/2020 from "+c6.getSelectedItem());
				p.println("Appointment on "+c3.getSelectedItem()+"-"+c4.getSelectedIndex()+"-2020 from "+c6.getSelectedItem());
				p.flush();
	
			}
		}
	
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
	}
}
	
	
	public static boolean isA(int n) 
	{
	if(n>0)
	{
		return false;
	}
	return false;
	}
	
	public static boolean isN(String s)
	{
		if(s.trim().equals("")) 
			return true;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)<='9'&&s.charAt(i)>='0')
			return true;
		}
		return false;
	}
	
	
	public void itemStateChanged(ItemEvent e) 
	{		
		if(e.getSource()==c1)
		{
			if(c1.getSelectedIndex()==0)
			{
				c2.setEnabled(false);
			}
			else if(c1.getSelectedIndex()==1)
			{
				c2.removeAllItems();
				c2.setEnabled(true);
				c2.addItem("-SELECT-");
				c2.addItem("Dr. Brown");
				c2.addItem("Dr. Lentils");
				c2.addItem("Dr. Otto");
				c2.addItem("Dr. Liz");
			}
			else if(c1.getSelectedIndex()==2)
			{
				c2.removeAllItems();
				c2.setEnabled(true);
				c2.addItem("-SELECT-");
				c2.addItem("Dr. Bundy");
				c2.addItem("Dr. Casper");
				c2.addItem("Dr. Weed");
				c2.addItem("Dr. Trotsky");
			}
			else if(c1.getSelectedIndex()==3)
			{
				c2.removeAllItems();
				c2.setEnabled(true);
				c2.addItem("-SELECT-");
				c2.addItem("Dr. Stalin");
				c2.addItem("Dr. Gunderson");
				c2.addItem("Dr. Niagara");
				c2.addItem("Dr. Specter");	
			}
			else if(c1.getSelectedIndex()==4)
			{
				c2.removeAllItems();
				c2.setEnabled(true);
				c2.addItem("-SELECT-");
				c2.addItem("Dr. Ramoray");
				c2.addItem("Dr. Tort");
				c2.addItem("Dr. Alco Free");
				c2.addItem("Dr. Powerson");
			}
			else if(c1.getSelectedIndex()==5)
			{
				c2.removeAllItems();
				c2.setEnabled(true);
				c2.addItem("-SELECT-");
				c2.addItem("Dr. Glitch");
				c2.addItem("Dr. Raeys");
				c2.addItem("Dr. Solenski");
			}
			else
			{
				c2.removeAllItems();
				c2.setEnabled(true);
				c2.addItem("-SELECT-");
				c2.addItem("Dr. Alco Free");
				c2.addItem("Dr. Ferguson");
				c2.addItem("Dr. Kheils");
			}
		}
		else if(e.getSource()==c4)
		{
			if(c4.getSelectedIndex()==0)
			{
				c3.setEnabled(false);
			}
			else if(c4.getSelectedIndex()==2)
			{
				c3.removeAllItems();
				c3.setEnabled(true);
				for(int i=1;i<=29;i++)
					c3.addItem(Integer.toString(i));
			}
			else if(c4.getSelectedIndex()==4||c4.getSelectedIndex()==6||c4.getSelectedIndex()==9||c4.getSelectedIndex()==11)
			{
				c3.removeAllItems();
				c3.setEnabled(true);
				for(int i=1;i<=30;i++)
					c3.addItem(Integer.toString(i));
			}
			else
			{
				c3.removeAllItems();
				c3.setEnabled(true);
				for(int i=1;i<32;i++)
					c3.addItem(Integer.toString(i));
			}
		}
	}
}