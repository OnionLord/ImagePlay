package yame.Face.ImageProcess;

/*
 * By 김상현 박재언 박성택
 * yame.ImageProcess.MatCor
 * MatCor Class : 두 이미지 객체(Face클래스 객체)의 Covariance/variance 값을 구한 Correlation 값을 계산한다.
 * Face Class : 각 얼굴 이미지의 정보를 저장한다.
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
	
	private void resize()//이미지 크기가 120*120이 아닐때 120*120으로 변경
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
	
	public Face(String n)//얼굴 이미지 초기화 하는거. 이미지 기본정보, 높이, 너비 저장 및 픽셀값을 배열에 저장.
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
					//Luminance : 순수한 밝기 -> RGB이미지를 Gray Scale 영상처럼 만들어서 처리.
					
					pixel[i][j] = l;
				
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public double getAverage()//픽셀 평균 값 구하기.
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
	
	public int getlum(int x, int y)//해당 좌표의 밝기값(픽셀값) 반환.
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
	
	public MatCor(String or, String ta, int n)//각 Face객체 초기화(비교 대상들 간)
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