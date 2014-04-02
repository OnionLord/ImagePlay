package yame.Face.ImageProcess;

/*
 * By ����� ����� �ڼ���
 * yame.ImageProcess.MatCor
 * MatCor Class : �� �̹��� ��ü(FaceŬ���� ��ü)�� Covariance/variance ���� ���� Correlation ���� ����Ѵ�.
 * Face Class : �� �� �̹����� ������ �����Ѵ�.
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.*;

import javax.imageio.ImageIO;

import yame.BasicThings.BasicThings;

import java.awt.Graphics;
import java.awt.Image;

class Face
{
	private int [][]pixel;
	private int width;
	private int height;
	private BufferedImage image;
	
	private void resize()//�̹��� ũ�Ⱑ 120*120�� �ƴҶ� 120*120���� ����
	{
		Image resize = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		BufferedImage newImg =  new BufferedImage( 120, 120, BufferedImage.TYPE_INT_RGB );
		Graphics g = newImg.getGraphics();
		g.drawImage(resize, 0, 0, null);
		g.dispose();
		try {
			
			ImageIO.write(newImg, "jpg", new File("yame\\data\\temp"+BasicThings.temps+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Face(String n)//�� �̹��� �ʱ�ȭ �ϴ°�. �̹��� �⺻����, ����, �ʺ� ���� �� �ȼ����� �迭�� ����.
	{
		try {
			image = ImageIO.read(new File(n));
			width = image.getWidth();
			height = image.getHeight();
			
			if(width != 120 || height != 120)
			{
				resize();

				image = ImageIO.read(new File("yame\\data\\temp"+BasicThings.temps+".jpg"));
				BasicThings.orig = "yame\\data\\temp"+BasicThings.temps+".jpg";
				width = image.getWidth();
				height = image.getHeight();
			}
			
			pixel = new int[image.getWidth()][image.getHeight()];
			int i, j;
			
			for ( i = 0 ; i < width ; i ++ )
			{
				for ( j = 0 ; j < height ; j ++ )
				{
					int r = (image.getRGB(i, j) >> 16) & 0xff;
					int g = (image.getRGB(i, j) >> 8) & 0xff;
					int b = image.getRGB(i, j) & 0xff;
					
					int l = (int)((0.299*r) + (0.587*g) + (0.114*b));
					//Luminance : ������ ��� -> RGB�̹����� Gray Scale ����ó�� ���� ó��.
					
					pixel[i][j] = l;
				
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public double getAverage()//�ȼ� ��� �� ���ϱ�.
	{
		int i, j;
		double total = 0;
		for ( i = 0 ; i < width ; i ++ )
		{
			for ( j = 0 ; j < height ; j ++ )
			{
				total += pixel[i][j];
			}
		}
		return total/(width*height);
	}
	
	public int getlum(int x, int y)//�ش� ��ǥ�� ��Ⱚ(�ȼ���) ��ȯ.
	{
		return pixel[x][y];
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
}
//Image Matching by Correlation.
public class MatCor
{
	private Face orig;
	private Face target;
	private double avg_or;
	private double avg_ta;
	private int vsNum;
	
	public MatCor(String or, String ta, int n)//�� Face��ü �ʱ�ȭ(�� ���� ��)
	{
		orig = new Face(or);
		target = new Face(ta);
		avg_or = orig.getAverage();
		avg_ta = target.getAverage();
		vsNum = n;
	}
	
	private double getCov()
	{
	
		int i, j;
		double cov = 0;
		for ( i = 0 ; i < orig.getWidth() ; i ++ )
		{
			for ( j = 0 ; j < orig.getHeight() ; j ++ )
			{
				cov += (orig.getlum(i, j) - avg_or) * (target.getlum(i, j) - avg_ta);
			}
		}
		
		return cov;
	}
	
	public int getvsNum()
	{
		return vsNum;
	}
	
	public int getResult()
	{

		int i, j;
		double var_or = 0, var_ta = 0, var, result;
		for ( i = 0 ; i < orig.getWidth() ; i ++ )
		{
			for ( j = 0 ; j < orig.getHeight() ; j ++ )
			{
				var_or += Math.pow(((double)orig.getlum(i, j) - avg_or),2.0);
				
			}
		}
		
		for ( i = 0 ; i < target.getWidth() ; i ++ )
		{
			for ( j = 0 ; j < target.getHeight() ; j ++ )
			{
				var_ta += Math.pow(((double)target.getlum(i, j) - avg_ta),2.0);
				
			}
		}
		
		var = Math.sqrt(var_or * var_ta);
		
		result = getCov() / var;
		if(result < 0 )
		{
			result *= -1;
		}

		return (int)(result * 100);

	}
}