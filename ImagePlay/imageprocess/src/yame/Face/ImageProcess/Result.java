package yame.Face.ImageProcess;

/*
 * By ����� ����� �ڼ���
 * yame.ImageProcess.Result
 * Result Class : MatCorŬ������ ���� ������ ����� �����Ͽ��� OutPut�� ������ ��ü��.
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Dialog;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

import javax.imageio.ImageIO;

import yame.BasicThings.BasicThings;



public class Result {

	private MatCor results[];

	private void Calculate(String fileName)
	{
		for ( int i = 1 ; i <= BasicThings.size ; i ++ )
		{
			results[i-1] = new MatCor(fileName, "yame\\image\\DB\\"+i+".jpg", i);
		}
	}
	
	public MatCor []getResult()
	{
		return results;
	}
	
	private boolean image_check(String filename)
	{
		BufferedImage image;
		try {
			image = ImageIO.read(new File(filename));
			try
			{
				int width = image.getWidth();
				int height = image.getHeight();
				if( width != 120 || height != 120 )
				{
					BasicThings.temps++;
					/*JOptionPane.showMessageDialog(null, "������ ũ��( 120X120)���� Ů�ϴ�!\n�ٽ� ������ �ּ���!");
					System.out.println("Too Big!");
					return false;*/
					//MatCor class�� resize method�� ���ؼ� �ǹ̰� ������.
				}
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(null, "������ �߸��Ǿ����ϴ�.\n�ٽ� ������ �ּ���");
				System.out.println("File Error!");
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	private void sort_result()
	{
		int i, j;
		int minIndex = 0;
		MatCor temp;
		for ( i = 0 ; i < BasicThings.size ; i ++ )
		{
			minIndex = i;
			for ( j = i + 1 ; j < BasicThings.size ; j ++ )
			{
				if(results[minIndex].getResult() < results[j].getResult())
				{
					minIndex = j;
				}
			}
			if ( minIndex != i )
			{
				temp = results[minIndex];
				results[minIndex] = results[i];
				results[i] = temp;
			}
		}
	}
	
	public Result()
	{
		String Filename;
		results = new MatCor[BasicThings.size];
		Frame f = new Frame("EE");
		
		while(true)
		{
			FileDialog fileOpen = new FileDialog(f, "���� ����", FileDialog.LOAD);
			fileOpen.setVisible(true);
			Filename = fileOpen.getDirectory() + fileOpen.getFile();
			
			if(fileOpen.getFile() == null)
			{
				System.exit(0);
			}
			if(image_check(Filename))
			{
				BasicThings.orig = Filename;
				fileOpen.setVisible(false);
				break;
			}

		}
		System.out.println("EE!");
		Calculate(Filename);
		sort_result();
		

	}
	
	public void Restart()
	{
		String Filename;
		results = new MatCor[BasicThings.size];
		Frame f = new Frame("EE");
		
		while(true)
		{
			FileDialog fileOpen = new FileDialog(f, "���� ����", FileDialog.LOAD);
			fileOpen.setVisible(true);
			Filename = fileOpen.getDirectory() + fileOpen.getFile();
			
			if(fileOpen.getFile() == null)
			{
				System.exit(0);
			}
			if(image_check(Filename))
			{
				BasicThings.orig = Filename;
				break;
			}

		}
		
		Calculate(Filename);
		sort_result();
	}
}
