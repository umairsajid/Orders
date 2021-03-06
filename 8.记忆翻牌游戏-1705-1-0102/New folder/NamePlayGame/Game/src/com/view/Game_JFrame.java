package com.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
public class Game_JFrame extends JFrame implements MouseListener{
	private Game_Scene game_Scene;
	//背景面板
	private JPanel jpanel;
	//背景图
	private Image backimage=new ImageIcon("Image/bj2.jpg").getImage();
	JLabel jldenglu;
	public Game_JFrame()
	{
	
		initBackgroundImage();
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		//设置窗口大小
		this.setSize(1024,553);
		
		int x=(Toolkit.getDefaultToolkit().getScreenSize().width-this.getWidth())/2;
		int y=(Toolkit.getDefaultToolkit().getScreenSize().height-this.getHeight())/2-32;
	   
		
		
	    //不允许用户改变窗口大小
	    this.setResizable(false);
	    //居中
	    this.setLocation(x, y);
	    //默认该窗口显示
	    this.setVisible(true);

	}
	
	public void initBackgroundImage()
	{
		jpanel=new Game_Scene(backimage,0,0,1024,553);
		jpanel.setLayout(null);
		JLabel jlusername=new JLabel(new ImageIcon("Image/username.png"));
		JLabel jlpassword=new JLabel(new ImageIcon("Image/password.png"));
		jldenglu=new JLabel(new ImageIcon("Image/denglu.png"));
		jldenglu.setBounds(140, 400, 70, 50);
		jldenglu.setEnabled(false);
		jldenglu.addMouseListener(this);
		JTextField jt1=new JTextField();
		JTextField jt2=new JTextField();
		jlusername.setBounds(22, 300, 80, 30);
		jlpassword.setBounds(20, 350, 80, 30);
		jt1.setBounds(120, 300, 150, 30);
		jt2.setBounds(120, 350, 150, 30);
		jt1.setBackground(Color.LIGHT_GRAY);
		jt2.setBackground(Color.LIGHT_GRAY);
		jpanel.add(jt1);
		jpanel.add(jt2);
		jpanel.add(jlusername);
		jpanel.add(jlpassword);
		jpanel.add(jldenglu);
		this.add(jpanel);
	}	
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根
			System.out.println("1");
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根
			new Game_Play_JFrame();
			this.dispose();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根
			jldenglu.setEnabled(false);
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根
			jldenglu.setEnabled(true);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

}
