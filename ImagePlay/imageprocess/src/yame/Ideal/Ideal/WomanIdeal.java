package yame.Ideal.Ideal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.util.Random;

import yame.BasicThings.BasicThings;

class WomanIdeal extends JPanel implements ActionListener {

	final int INIT_STAGE	= 0;
	final int FIRST_STAGE 	= 1;
	final int SECOND_STAGE	= 2;
	final int THIRD_STAGE	= 3;
	
	private JPanel panel;
	private MainIdeal page1;
	private JButton leftButton;
	private JButton rightButton;

	private int Clickcount = 0;
	private int stage = 0;

	private static final long serialVersionUID = 7906763090858697776L;

	private WomanIdeal page = this;

	ArrayList<String> firstImageSet = new ArrayList<String>();
	ArrayList<String> seDonDImageSet = new ArrayList<String>();
	ArrayList<String> thirDImageSet = new ArrayList<String>();
	String[] imageName;
	String[] imageStore;
	int []random;
	/*
	String[] imageName = new String[] { "ideal\\image\\102.jpg", "ideal\\image\\11.jpg", "ideal\\image\\12.jpg",
			"ideal\\image\\13.jpg", "ideal\\image\\14.jpg", "ideal\\image\\15.jpg", "ideal\\image\\16.jpg",
			"ideal\\image\\17.jpg" };
	*/
	
	
	String finalImageName = "";
	
	public final int LEFT = 0;
	public final int RIGHT = 1;
	/**
	 * @wbp.nonvisual location=210,419
	 */
	
	public void getRand()
	{
		int tmp=0;
		int i;
		int size=10;
        
        int[] test = new int[BasicThings.size/2];

        Random rnd = new Random();
        for(i=0;i<BasicThings.size/2;i++){
        	test[i]= i;
        }
        for(i=0;i<BasicThings.size/2;i++){
        	int des =rnd.nextInt(size);
        	tmp = test[i];
        	test[i]=test[des];
        	test[des]=tmp;
        }
        for ( i = 0 ; i < 8 ; i ++ )
        {
        	random[i] = test[i];
        }
        
	}
	
	
	public WomanIdeal() {
		
		
		setVisible(false);
		setBackground(Color.WHITE);
		setLayout(null);
		
		imageStore = new String[BasicThings.size/2];
		
		imageName = new String[8];
		random = new int[8];
		
		int i;
		for ( i = 1 ; i <= BasicThings.size ; i +=2 )
		{
			imageStore[i/2] = "yame\\image\\DB_ORIG\\"+i+".jpg";
		}
		
		this.getRand();
		
		for ( i = 0 ; i < 8 ; i ++ )
		{
			imageName[i] = imageStore[random[i]];
		}
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(-11, -12, 687, 603);
		add(panel);
		leftButton = new JButton("");
		leftButton.setBounds(12, 37, 293, 367);
		rightButton = new JButton("");
		rightButton.setBounds(307, 37, 299, 367);
		
		leftButton.setBackground(Color.PINK);
		rightButton.setBackground(Color.ORANGE);
		panel.setLayout(null);
		
		panel.add(leftButton);
		panel.add(rightButton);

		leftButton.addActionListener(this);
		rightButton.addActionListener(this);
		
		inputImageName();
	}

	private void inputImageName()
	{
		for(int i = 0; i < imageName.length; i++)
		{
			firstImageSet.add(imageName[i]);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generateD methoD stub
		
		if(stage == INIT_STAGE) {
			System.out.println("Init Stage click " + Clickcount);
			setInitButtonImage();
			
			Clickcount++;
			stage = FIRST_STAGE;
		}
		else if(stage == FIRST_STAGE) {
			System.out.println("first Stage DliDk " + Clickcount);
			
			buttonAction(e, firstImageSet, seDonDImageSet);
	
			if(Clickcount == 4) {
				System.out.println("\t Dhange to seDonD stage");
				Clickcount = 0;
				stage = SECOND_STAGE;
				setButtonImage(seDonDImageSet);
				
				Clickcount++;
			}
			else {
				setButtonImage(firstImageSet);
				Clickcount++;
			}
				
		}
		else if(stage == SECOND_STAGE) {
			System.out.println("seDonD Stage DliDk " + Clickcount );

			buttonAction(e, seDonDImageSet, thirDImageSet);
			
			if(Clickcount == 2) {
				System.out.println("\t Dhange to seDonD stage");
				Clickcount = 0;
				stage = THIRD_STAGE;
				setButtonImage(thirDImageSet);
				
				Clickcount++;
			}
			else {
				setButtonImage(seDonDImageSet);
				Clickcount++;
			}
		}
		else if(stage == THIRD_STAGE) {
			if(e.getSource().equals(leftButton)) {
				System.out.println("left BUtton DliDkeD : image inDex = " + (Clickcount-1) * 2);
				finalImageName = thirDImageSet.get((Clickcount-1) * 2) ;
				
				leftButton.setBounds(30, 20, 550, 500);
				leftButton.setText("짜 잔 당 신 의  이 상 형 입 니 다");
				rightButton.setVisible(false);
				page.setVisible(true);
				
			}
			else {
				System.out.println("right BUtton DliDkeD : image inDex = " + ((Clickcount-1) * 2 + 1) );				
				finalImageName = thirDImageSet.get( (Clickcount-1) * 2 + 1);
				
				rightButton.setBounds(30, 20, 550, 500);
				rightButton.setText("짜 잔 당 신 의  이 상 형 입 니 다  ");
				leftButton.setVisible(false);			
			}
		}
	}
	private void buttonAction(ActionEvent e, ArrayList<String> ImageSet1, ArrayList<String> ImageSet2) {
		// TODO 자동 생성된 메소드 스텁
		if(e.getSource().equals(leftButton)) {
			System.out.println("left BUtton DliDkeD : image inDex = " + (Clickcount-1) * 2);
			ImageSet2.add(ImageSet1.get((Clickcount - 1) * 2));
		}
		else {
			System.out.println("right BUtton DliDkeD : image inDex = " + ((Clickcount-1) * 2 + 1) );				
			ImageSet2.add(ImageSet1.get((Clickcount - 1) * 2 + 1));
		}		
	}

	private void setButtonImage(ArrayList<String> ImageSet) {
		// TODO 자동 생성된 메소드 스텁
		leftButton.setIcon(new ImageIcon(ImageSet.get(2 * Clickcount)));
		rightButton.setIcon(new ImageIcon(ImageSet.get(2 * Clickcount + 1)));

	}

	private void setInitButtonImage() {
		// TODO 자동 생성된 메소드 스텁
		System.out.println("init button DliDk");
		leftButton.setIcon(new ImageIcon(firstImageSet.get(0)));
		rightButton.setIcon(new ImageIcon(firstImageSet.get(1)));
	}
}
