package yame.BasicThings;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import yame.Ideal.Ideal.MainIdeal;
import yame.Face.*;
import yame.Face.GUIOutPut.Output_main;



public class Intro extends Frame implements MouseListener {

	
	Image main_img;
	Image button1;
	Image button2;
	Button start;

	
	
	public Intro(String str)
	{
		super(str);
		setLayout(null);
		addMouseListener(this);
		addWindowListener(new WindowHandler());
		setSize(550, 550);
		
		Toolkit tk = Toolkit.getDefaultToolkit();

		main_img = tk.getImage("yame\\data\\intro.jpg");
		button1 = tk.getImage("yame\\data\\button1.png");
		button2 = tk.getImage("yame\\data\\button2.png");
		


		setVisible(true);

	}
	

	
	
	static class WindowHandler extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
	}
	
	static public void main(String args[])
	{
		
		new Intro("[JAVA 5��]�̹��� ������!");
		
	}
	class EventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//JOptionPane.showMessageDialog(null, "������� 120X120�� �����մϴ�.\n�ٸ� ����� �����մϴٸ�,\n 120X120���� ���� ����� �� ���ɴϴ�.\n��Ҹ� ������ ����˴ϴ�.");
			//new Result_Print("����! �߸��ν�!");
			//setVisible(false);
			//System.out.println("TEST");
		}
	}
	public void paint(Graphics g)
	{
		if ( main_img == null )
		{
			return;
		}
		
		g.drawImage(main_img,0,10,this);
		g.drawImage(button1,70,180,this);
		g.drawImage(button2,70,320,this);

		//g.drawImage(res_img[2],10,35,this);
	}
	
	public void mouseClicked(MouseEvent ee)
	{
		if ( ee.getX()>= 70 && ee.getX() <= 470 && ee.getY() >= 180 && ee.getY()<=280)
		{
			MainIdeal.main(null);
			setVisible(false);
			
		}
		if ( ee.getX()>= 70 && ee.getX() <= 470 && ee.getY() >= 320 && ee.getY()<=420)
		{
			new Output_main("����! �߸��ν�!");
			setVisible(false);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	public void mouseDragged(MouseEvent arg0)
	{
		
	}
	
	public void mouseMoved(MouseEvent arg0)
	{

		if ( arg0.getX()>= 70 && arg0.getX() <= 470 && arg0.getY() >= 180 && arg0.getY()<=280)
		{
			System.out.println("�̻���");
		}
		if ( arg0.getX()>= 70 && arg0.getX() <= 470 && arg0.getY() >= 320 && arg0.getY()<=420)
		{
			System.out.println("�߸��ν�");
		}

	}*/
}
