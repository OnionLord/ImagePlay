package yame.Face.GUIOutPut;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.imageio.ImageIO;

import yame.BasicThings.*;
import yame.Face.ImageProcess.MatCor;
import yame.Face.ImageProcess.Result;
/*
 * By 김상현 박재언 박성택
 * yame.ImageProcess.MatCor
 * Result_Print Class : 결과를 화면에 저장한 것을 담당한다.
 */
public class Result_Print extends Frame {
	
	Image []res_img;
	Image org_img;
	Label []res_label;
	AudioClip kong;
	Button restart;
	Result a;
	Label lb1, lb2, lb3, lb4, lb5;
	File sergay;
	Font f1, f2, f3, f4, f5;
	Color c1;
	
	public Result_Print(String str)
	{
		super(str);
		f1 = new Font("돋움",Font.BOLD,20);
		f2 = new Font("돋움",Font.PLAIN,13);
		f3 = new Font("돋움",Font.BOLD, 15);
		f4 = new Font("궁서체",Font.BOLD, 15);
		
		
		c1 = new Color(233,107,202);
		
		Print(str);
		
		
	}
	
	public void Print(String str)
	{
		this.dispose();
		this.removeAll();

		a = null;
		a = new Result();
		lb1 = new Label("가장 닮은 사람 ");
		lb2 = new Label("당신이 부른 이미지▼");
		lb3 = new Label("2위");
		lb4 = new Label("3위");
		
		restart = new Button("다른 사진으로 하기");
		
		res_img = new Image[3];
		res_label = new Label[3];
		
		addWindowListener(new WindowHandler());
		setSize(500, 500);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		setLayout(null);
		
		
		
		
		res_img[0] = tk.getImage("yame\\image\\DB_ORIG\\"+a.getResult()[0].getvsNum()+".jpg");
		org_img = tk.getImage(BasicThings.orig);
		System.out.println(BasicThings.orig);
		for ( int i = 0 ; i < 3 ; i ++ )
		{
			res_img[i] = tk.getImage("yame\\image\\DB_ORIG\\"+a.getResult()[i].getvsNum()+".jpg");
			
			res_label[i] = new Label(BasicThings.name[a.getResult()[i].getvsNum() - 1]+ " : " + a.getResult()[i].getResult()+"%");
			res_label[i].setFont(f2);
		}
		
		if(a.getResult()[0].getvsNum() == 2)
		{
			
			try {
				sergay = new File("yame\\data\\2.wav");
				kong = Applet.newAudioClip(sergay.toURL());
				kong.play();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(a.getResult()[1].getvsNum() == 2)
		{
			
			try {
				sergay = new File("yame\\data\\22.wav");
				kong = Applet.newAudioClip(sergay.toURL());
				kong.play();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		int rst = a.getResult()[0].getResult();
		
		if(rst <= 100 && rst >= 85 )
		{
			lb5 = new Label(BasicThings.judge[0]);
		}
		else if(rst <= 84 && rst >= 65 )
		{
			lb5 = new Label(BasicThings.judge[1]);
		}
		else if(rst <= 64 && rst >= 50 )
		{
			lb5 = new Label(BasicThings.judge[2]);
		}
		else
		{
			lb5 = new Label(BasicThings.judge[3]);
		}
		
		lb1.setBounds(310,35,200,23);
		lb2.setBounds(340,175,120,20);
		lb3.setBounds(150,355,100,20);
		lb4.setBounds(380,355,100,20);
		lb5.setBounds(320,110,150,20);
		
		lb1.setFont(f1);
		lb3.setFont(f3);
		lb4.setFont(f3);
		lb5.setFont(f4);
		
		
		lb5.setAlignment(Label.CENTER);
		res_label[0].setBounds(310,58,100,20);
		
		res_label[1].setBounds(150,385,100,20);
		
		res_label[2].setBounds(380,385,100,20);
		
		restart.setBounds(340, 460, 150, 30);
		restart.addActionListener(new EventHandler());
		
		this.add(restart);
		this.add(lb1);
		this.add(lb2);
		this.add(lb3);
		this.add(lb4);
		this.add(lb5);
		this.add(res_label[0]);
		this.add(res_label[1]);
		this.add(res_label[2]);

		setVisible(true);
	}
	

	
	
	static class WindowHandler extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			try
			{
				int i;
				for ( i = 1 ; i <= BasicThings.temps ; i ++)
				{
					File tempFile = new File("yame\\data\\temp"+i+".jpg");
					tempFile.delete();
				}
			}
			catch(Exception ee)
			{
				
			}
			e.getWindow().dispose();
			System.exit(0);
		}
	}
	
	class EventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//setVisible(false);
			Print("역전! 야매인식!");
			
			
			//System.out.println("TEST");
		}
	}
	
	public void paint(Graphics g)
	{
		if ( res_img == null )
		{
			return;
		}
		g.drawImage(org_img,340,195,this);
		g.drawImage(res_img[0],10,35,this);
		g.drawImage(res_img[1],50,345,100,100,this);
		g.drawImage(res_img[2],280,345,100,100,this);
		//g.drawImage(res_img[2],10,35,this);
	}
}
