package com.windows.fourInput;
/*
 * 添加窗口（之后的删除、修改和查找类似）
 */
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.dao.EmployeeDAO;
import com.entity.Employee;
import com.windows.ManagementWindow;
import com.windows.PublicWindowSet;

public class AddWindows extends JFrame implements ActionListener {


	// 窗口高和宽
	private static final int WINDOWWIDE = 700;
	private static final int WINDOWHIGH = 300;
	
	// 主窗口类（父窗口，即管理窗口）
	private ManagementWindow managementWindow = null;
	
	// 7个输入提示框（如：id：）
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;

	// 与7个输入提示框对应，这是7个输入框（id后面的空白输入）
	private JTextField jText1 = null;
	private JTextField jText2 = null;
	private JTextField jText3 = null;
	private JTextField jText4 = null;
	private JTextField jText5 = null;
	private JTextField jText6 = null;
	private JTextField jText7 = null;

	// 按钮（“添加”）
	private JButton getItemsBtn = null;

	// 构造函数
	public AddWindows(ManagementWindow managementWindow) {
		this.managementWindow = managementWindow; // 首先声明设置父窗口
		this.liftInformation(); // 向窗口中加入输入提示框、输入框、按钮等
		PublicWindowSet.windowAttribute(this, WINDOWWIDE, WINDOWHIGH, "添加员工");// 高度、宽度和标题
	}

	// 向窗口中加入输入提示框、输入框、按钮等
	public void liftInformation() {
		// 1).
		jLabel1 = new JLabel("id：");
		jLabel1.setFont(new Font("黑体", Font.BOLD, 16));
		jLabel1.setBounds(30, 40, 120, 25);
		this.add(jLabel1);

		jLabel2 = new JLabel("姓名：");
		jLabel2.setFont(new Font("黑体", Font.BOLD, 16));
		jLabel2.setBounds(30, 70, 120, 25);
		this.add(jLabel2);

		jLabel3 = new JLabel("性别：");
		jLabel3.setFont(new Font("黑体", Font.BOLD, 16));
		jLabel3.setBounds(30, 100, 120, 25);
		this.add(jLabel3);

		jLabel4 = new JLabel("年龄：");
		jLabel4.setFont(new Font("黑体", Font.BOLD, 16));
		jLabel4.setBounds(30, 130, 120, 25);
		this.add(jLabel4);

		jLabel5 = new JLabel("出生日期：");
		jLabel5.setFont(new Font("黑体", Font.BOLD, 16));
		jLabel5.setBounds(30, 160, 120, 25);
		this.add(jLabel5);

		jLabel6 = new JLabel("职务：");
		jLabel6.setFont(new Font("黑体", Font.BOLD, 16));
		jLabel6.setBounds(360, 40, 120, 25);
		this.add(jLabel6);

		jLabel7 = new JLabel("薪水：");
		jLabel7.setFont(new Font("黑体", Font.BOLD, 16));
		jLabel7.setBounds(360, 70, 120, 25);
		this.add(jLabel7);

		// 2).
		jText1 = new JTextField();
		jText2 = new JTextField();
		jText3 = new JTextField();
		jText4 = new JTextField();
		jText5 = new JTextField();
		jText6 = new JTextField();
		jText7 = new JTextField();

		jText1.setFont(new Font("黑体", Font.BOLD, 16));
		jText2.setFont(new Font("黑体", Font.BOLD, 16));
		jText3.setFont(new Font("黑体", Font.BOLD, 16));
		jText4.setFont(new Font("黑体", Font.BOLD, 16));
		jText5.setFont(new Font("黑体", Font.BOLD, 16));
		jText6.setFont(new Font("黑体", Font.BOLD, 16));
		jText7.setFont(new Font("黑体", Font.BOLD, 16));

		jText1.setBounds(160, 40, 120, 25);
		jText2.setBounds(160, 70, 120, 25);
		jText3.setBounds(160, 100, 120, 25);
		jText4.setBounds(160, 130, 120, 25);
		jText5.setBounds(160, 160, 120, 25);
		jText6.setBounds(490, 40, 120, 25);
		jText7.setBounds(490, 70, 120, 25);

		this.add(jText1);
		this.add(jText2);
		this.add(jText3);
		this.add(jText4);
		this.add(jText5);
		this.add(jText6);
		this.add(jText7);

		// 3).
		getItemsBtn = new JButton("添加");

		getItemsBtn.setBounds(30, 190, 120, 25);

		this.add(getItemsBtn);

		//
		this.getItemsBtn.addActionListener(this);

		// 4).
		JLabel awayLabel = new JLabel();
		awayLabel.setBounds(200, 50, 10, 450);
		this.add(awayLabel);
	}

	// 按钮监听
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.getItemsBtn) {
			EmployeeDAO employeeDao = new EmployeeDAO();
			String id = jText1.getText();
			String name = jText2.getText();
			String gender = jText3.getText();
			String age = jText4.getText();
			String birthday = jText5.getText();
			String position = jText6.getText();
			String galary = jText7.getText();
			Employee employee = new Employee();
			
			employee.setEmployeeID(id);
			employee.setName(name);
			employee.setGender(gender);
			employee.setAge(age);
			employee.setBirthday(birthday);
			employee.setPosition(position);
			employee.setSalary(galary);
			
			// 向数据库中添加员工信息
			boolean flag = employeeDao.insert(employee);
			
			// 添加成功后，刷新管理窗口中的图表信息
			managementWindow.setdList(new EmployeeDAO().selectAll());
			managementWindow.flushUserWindow(managementWindow.getdList());
			PublicWindowSet.promptPopUp("添加用户成功!!!", "promptʾ", this);
			
			// 关闭添加小窗口
			this.dispose();
		}
	}

}
