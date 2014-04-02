package yame.Face.GUIOutPut;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;


import javax.imageio.ImageIO;

import yame.BasicThings.*;
import yame.Face.GUIOutPut.Result_Print.EventHandler;
import yame.Face.GUIOutPut.Result_Print.WindowHandler;
import yame.Face.ImageProcess.MatCor;
import yame.Face.ImageProcess.Result;

import javax.swing.*;
public class Output_main extends Frame {
	
	Image main_img;
	Button start;

	public Output_main(String str)
	{
		super(str);
		setLayout(null);
		addWindowListener(new WindowHandler());
		setSize(500, 500);
		
		Toolkit tk = Toolkit.getDefaultToolkit();

		main_img = tk.getImage("yame\\data\\face_main.jpg");
		start = new Button("�����ϱ�!");
		start.setBounds(50, 420, 150, 50);
		start.addActionListener(new EventHandler());
		
		this.add(start);

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
		
		new Output_main("����! �߸��ν�!");
		//new Result_Print("����! �߸��ν�!");
		
	}
	class EventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(null, "������� 120X120�� �����մϴ�.\n�ٸ� ����� �����մϴٸ�,\n 120X120���� ���� ����� �� ���ɴϴ�.\n��Ҹ� ������ ����˴ϴ�.");
			new Result_Print("����! �߸��ν�!");
			setVisible(false);
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

		//g.drawImage(res_img[2],10,35,this);
	}
}
