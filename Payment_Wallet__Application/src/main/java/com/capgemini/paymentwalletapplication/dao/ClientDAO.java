package com.capgemini.paymentwalletapplication.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import com.capgemini.paymentwalletapplication.bean.Account;
import com.capgemini.paymentwalletapplication.service.DBUtil;



public class ClientDAO implements IClientDAO {
	

	static long tid;
	static Connection con;
	static ResultSet rs1,rs2,rs3;
	
	public int createAccount(Account bean) {
	try {
		 con=DBUtil.getConnection();
		String insert="insert into customer values(?,?,?,?,?,?,?,?)";
		java.sql.PreparedStatement stmt= con.prepareStatement(insert);
		stmt.setString(1,bean.getCust().getFullName());
		stmt.setLong(2,bean.getCust().getAadharNum());
		stmt.setString(3, bean.getCust().getUserName());
		stmt.setString(4, bean.getCust().getPassword());
		stmt.setString(5, bean.getCust().getGender());
		stmt.setInt(6, bean.getCust().getAge());
		stmt.setString(7, bean.getCust().getPhoneNumber());
		stmt.setString(8, bean.getCust().getEmail());
		int n1=stmt.executeUpdate();
		
		String insert2="insert into account values(?,curdate(),?,?)";
		java.sql.PreparedStatement stmt2= con.prepareStatement(insert2);
		stmt2.setLong(1, bean.getAccNo());
		stmt2.setDouble(2, bean.getBalance());
		stmt2.setLong(3, bean.getCust().getAadharNum());
		int n2=stmt2.executeUpdate();
		
		if(n1==1&&n2==1) {
			return 1;
		}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		return 0;
	}
	
	public boolean testLogin(String userName, String password) {
		try {
			 con=DBUtil.getConnection();
			String select="select * from customer where username='"+userName+"'and password='"+password+"'";
			java.sql.PreparedStatement stmt=con.prepareStatement(select);
			rs1=stmt.executeQuery();
			if(rs1.first()) {
				int d=rs1.getInt(2);
				String select2="select * from account where aadharNum="+d;
				java.sql.PreparedStatement stmt2=con.prepareStatement(select2);
				rs2=stmt2.executeQuery();
				if(rs2.first()) {
					return true;
				}
			}
			
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
		public double showBalance() {
			
			try {
				if(rs2.first()) {
					return rs2.getDouble(3);
					}	
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
					return 0;	
			}
	
	public int deposit(double amount) {
		try {
			if(rs2.first()) {
				tid = ((long) (Math.random() * 1234 + 9999));
				LocalDateTime date = LocalDateTime.now();
				String s = date.toString()+" TransactionID is " + Long.toString(tid) + " at "
						+ "and deposited amount is:" + Double.toString(amount);
				String insert = "insert into transactions values(" + rs2.getInt(4) + ",'" + s + "')";
				java.sql.PreparedStatement pst = con.prepareStatement(insert);
				pst.executeUpdate();
				
				double d=rs2.getDouble(3)+amount;
				String updateQuery="update account set initial_balance='"+d+"'where aadharNum='"+rs1.getLong(2)+"'";
				String selectQuery="select * from account where aadharNum='"+rs1.getLong(2)+"'";
				System.out.println("-----------------------------amount in your account after deposit is:"+d+"------------------------");
				java.sql.PreparedStatement stmt=con.prepareStatement(updateQuery);
				int r=stmt.executeUpdate();
				rs2=stmt.executeQuery(selectQuery);
				if(r==1) {
					return 1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		}
		

	public int withdraw(double amount) {
		try {
			if(rs2.first()) {
				tid = ((long) (Math.random() * 1234 + 9999));
				LocalDateTime date = LocalDateTime.now();
				String s = date.toString()+" TransactionID is " + Long.toString(tid) + " at "
						+ "and withrawn amount is:" + Double.toString(amount);
				String insert = "insert into transactions values(" + rs2.getInt(4) + ",'" + s + "')";
				java.sql.PreparedStatement pst = con.prepareStatement(insert);
				pst.executeUpdate();
				double d=rs2.getDouble(3)-amount;
				String updateQuery="update account set initial_balance='"+d+"'where aadharNum='"+rs1.getLong(2)+"'";
				System.out.println("-----------------------------amount in your account after withdraw is:"+d+"------------------------");
				String selectQuery="select * from account where aadharNum='"+rs1.getLong(2)+"'";
				java.sql.PreparedStatement stmt=con.prepareStatement(updateQuery);
				int r=stmt.executeUpdate();
				rs2=stmt.executeQuery(selectQuery);
				if(r==1) {
					return 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				return 0;
			}
			
	
	public int fundTransfer(long accNo, double amount) {
		try {
			if (rs2.first()) {
				double d = rs2.getDouble(3) - amount;
				String update1 = "update wallet set initial_balance=" + d + "where aadharNum='" + rs2.getLong(4) + "'";
				System.out.println("-----------------------------amount in your account after fund transfer is:"+d+"------------------------");
				java.sql.PreparedStatement stmt11 = con.prepareStatement(update1);
				String select = "select *from wallet where accountNo=" + accNo;
				java.sql.PreparedStatement stmt1 = con.prepareStatement(select);
				rs3 = stmt1.executeQuery();
				if (rs3.first()) {
					double d1 = rs3.getDouble(3) + amount;
					String update = "update wallet set initial_balance= " + d1 + "where aadharNum='" + rs2.getLong(4)
							+ "'";
					java.sql.PreparedStatement stmt = con.prepareStatement(update);
					if (stmt11.executeUpdate() == 1) {
						tid = ((long) (Math.random() * 1234 + 9999));
						LocalDateTime date = LocalDateTime.now();
						String s = date.toString()+" TransactionID is " + Long.toString(tid) + " at "
								+ "and tranferred amount is:" + Double.toString(amount) + "to accountNumber" + accNo;
						String insert = "insert into transactions values(" + rs2.getInt(4) + ",'" + s + "')";
						java.sql.PreparedStatement pst = con.prepareStatement(insert);
						pst.executeUpdate();
						System.out.println(amount + "amount debited from your account");
						int b = rs1.getInt(2);
						String select2 = "select * from wallet where aadharNum=" + b;
						java.sql.PreparedStatement stmt2 = con.prepareStatement(select2);
						rs2 = stmt2.executeQuery();
						return 1;
					}
				}
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;

	}

	public void printTransaction() {

		try {
			
				String select = "select * from transactions where aadharNum=" + rs2.getInt(4);
				java.sql.PreparedStatement pst = con.prepareStatement(select);
				ResultSet rs4 = pst.executeQuery();
				while (rs4.next()) {
					System.out.println(rs4.getString(2));
				}
			} catch(SQLException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	public void close() {

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------------------succesfully logged out----------------------------");
		
	}
}


