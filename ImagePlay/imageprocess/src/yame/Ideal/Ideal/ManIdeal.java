package yame.Ideal.Ideal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import yame.BasicThings.BasicThings;

class ManIdeal extends JPanel implements ActionListener {

	final int INIT_STAGE	= 0;
	final int FIRST_STAGE 	= 1;
	final int SECOND_STAGE	= 2;
	final int THIRD_STAGE	= 3;
	
	private JPanel panel;

	private JButton leftButton;
	private JButton rightButton;

	private int clickCount = 0;
	private int stage = 0;

	private static final long serialVersionUID = 7906763090858697776L;

	private ManIdeal page = this;

	ArrayList<String> firstImageSet = new ArrayList<String>();
	ArrayList<String> secondImageSet = new ArrayList<String>();
	ArrayList<String> thirdImageSet = new ArrayList<String>();
	
	String[] imageName;
	String[] imageStore;
	int []random;
	
	String finalImageName = "";
	
	public final int LEFT = 0;
	public final int RIGHT = 1;

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
	
	public ManIdeal() {

		setVisible(false);
		setBackground(Color.WHITE);
		setLayout(null);
		imageStore = new String[BasicThings.size/2];
		imageName = new String[8];
		random = new int[8];
		
		int i;
		for ( i = 2 ; i <= BasicThings.size ; i +=2 )
		{
			imageStore[(i/2) - 1] = "yame\\image\\DB_ORIG\\"+i+".jpg";
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

		panel.setLayout(null);
		leftButton = new JButton("");
		rightButton = new JButton("");
		
		leftButton.setBackground(Color.PINK);
		rightButton.setBackground(Color.ORANGE);

		leftButton.setBounds(12, 37, 293, 397);
		rightButton.setBounds(306, 37, 296, 397);
		
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
		// TODO Auto-generated method stub
		
		if(stage == INIT_STAGE) {
			System.out.println("Init Stage click " + clickCount);
			setInitButtonImage();
			
			clickCount++;
			stage = FIRST_STAGE;
		}
		else if(stage == FIRST_STAGE) {
			System.out.println("first Stage click " + clickCount);
			
			buttonAction(e, firstImageSet, secondImageSet);
	
			if(clickCount == 4) {
				System.out.println("\t change to second stage");
				clickCount = 0;
				stage = SECOND_STAGE;
				setButtonImage(secondImageSet);
				
				clickCount++;
			}
			else {
				setButtonImage(firstImageSet);
				clickCount++;
			}
				
		}
		else if(stage == SECOND_STAGE) {
			System.out.println("second Stage click " + clickCount );

			buttonAction(e, secondImageSet, thirdImageSet);
			
			if(clickCount == 2) {
				System.out.println("\t change to second stage");
				clickCount = 0;
				stage = THIRD_STAGE;
				setButtonImage(thirdImageSet);
				
				clickCount++;
			}
			else {
				setButtonImage(secondImageSet);
				clickCount++;
			}
		}
		else if(stage == THIRD_STAGE) {
			if(e.getSource().equals(leftButton)) {
				System.out.println("left BUtton clicked : image index = " + (clickCount-1) * 2);
				finalImageName = thirdImageSet.get((clickCount-1) * 2) ;
				
				leftButton.setBounds(30, 20, 550, 500);
				leftButton.setText("짜 잔 당 신 의 이 상 형 입 니 다");
				rightButton.setVisible(false);
				
			}
			else {
				System.out.println("right BUtton clicked : image index = " + ((clickCount-1) * 2 + 1) );				
				finalImageName = thirdImageSet.get( (clickCount-1) * 2 + 1);
				
				rightButton.setBounds(30, 20, 550, 500);
				rightButton.setText("짜 잔 당 신 의 이 상 형 입 니 다");
				leftButton.setVisible(false);
				
			}			
		}
	}

	private void buttonAction(ActionEvent e, ArrayList<String> ImageSet1, ArrayList<String> ImageSet2) {
		// TODO 자동 생성된 메소드 스텁
		if(e.getSource().equals(leftButton)) {
			System.out.println("left BUtton clicked : image index = " + (clickCount-1) * 2);
			ImageSet2.add(ImageSet1.get((clickCount - 1) * 2));
		}
		else {
			System.out.println("right BUtton clicked : image index = " + ((clickCount-1) * 2 + 1) );				
			ImageSet2.add(ImageSet1.get((clickCount - 1) * 2 + 1));
		}		
	}

	private void setButtonImage(ArrayList<String> ImageSet) {
		// TODO 자동 생성된 메소드 스텁
		leftButton.setIcon(new ImageIcon(ImageSet.get(2 * clickCount)));
		rightButton.setIcon(new ImageIcon(ImageSet.get(2 * clickCount + 1)));

	}

	private void setInitButtonImage() {
		// TODO 자동 생성된 메소드 스텁
		System.out.println("init button click");
		
		leftButton.setIcon(new ImageIcon(firstImageSet.get(0)));
		rightButton.setIcon(new ImageIcon(firstImageSet.get(1)));
	}
}