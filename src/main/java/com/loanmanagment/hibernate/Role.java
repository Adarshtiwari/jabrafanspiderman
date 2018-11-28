package com.loanmanagment.hibernate;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="user_role")
	private String userRole;

	//bi-directional many-to-one association to TransactionTable
	@OneToMany(mappedBy="role1")
	private List<TransactionTable> transactionTables1;

	//bi-directional many-to-one association to TransactionTable
	@OneToMany(mappedBy="role2")
	private List<TransactionTable> transactionTables2;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="role")
	private List<UserRole> userRoles;

	public Role() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public List<TransactionTable> getTransactionTables1() {
		return this.transactionTables1;
	}

	public void setTransactionTables1(List<TransactionTable> transactionTables1) {
		this.transactionTables1 = transactionTables1;
	}

	public TransactionTable addTransactionTables1(TransactionTable transactionTables1) {
		getTransactionTables1().add(transactionTables1);
		transactionTables1.setRole1(this);

		return transactionTables1;
	}

	public TransactionTable removeTransactionTables1(TransactionTable transactionTables1) {
		getTransactionTables1().remove(transactionTables1);
		transactionTables1.setRole1(null);

		return transactionTables1;
	}

	public List<TransactionTable> getTransactionTables2() {
		return this.transactionTables2;
	}

	public void setTransactionTables2(List<TransactionTable> transactionTables2) {
		this.transactionTables2 = transactionTables2;
	}

	public TransactionTable addTransactionTables2(TransactionTable transactionTables2) {
		getTransactionTables2().add(transactionTables2);
		transactionTables2.setRole2(this);

		return transactionTables2;
	}

	public TransactionTable removeTransactionTables2(TransactionTable transactionTables2) {
		getTransactionTables2().remove(transactionTables2);
		transactionTables2.setRole2(null);

		return transactionTables2;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setRole(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setRole(null);

		return userRole;
	}

}