package com.loanmanagment.hibernate;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the brokrage database table.
 * 
 */
@Entity
@Table(name="brokrage")
@NamedQuery(name="Brokrage.findAll", query="SELECT b FROM Brokrage b")
public class Brokrage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="brokerage_ammount")
	private int brokerageAmmount;

	@Column(name="tds_onbrokerage")
	private int tdsOnbrokerage;

	//bi-directional many-to-one association to TransactionTable
	@ManyToOne
	@JoinColumn(name="transaction_id")
	private TransactionTable transactionTable;

	public Brokrage() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBrokerageAmmount() {
		return this.brokerageAmmount;
	}

	public void setBrokerageAmmount(int brokerageAmmount) {
		this.brokerageAmmount = brokerageAmmount;
	}

	public int getTdsOnbrokerage() {
		return this.tdsOnbrokerage;
	}

	public void setTdsOnbrokerage(int tdsOnbrokerage) {
		this.tdsOnbrokerage = tdsOnbrokerage;
	}

	public TransactionTable getTransactionTable() {
		return this.transactionTable;
	}

	public void setTransactionTable(TransactionTable transactionTable) {
		this.transactionTable = transactionTable;
	}

}