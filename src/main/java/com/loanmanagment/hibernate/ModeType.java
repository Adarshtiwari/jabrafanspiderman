package com.loanmanagment.hibernate;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mode_type database table.
 * 
 */
@Entity
@Table(name="mode_type")
@NamedQuery(name="ModeType.findAll", query="SELECT m FROM ModeType m")
public class ModeType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="mode_date")
	private Date modeDate;

	@Column(name="mode_type")
	private String modeType;

	//bi-directional many-to-one association to Cheque
	@OneToMany(mappedBy="modeType")
	private List<Cheque> cheques;

	//bi-directional many-to-one association to OnlineTable
	@OneToMany(mappedBy="modeType")
	private List<OnlineTable> onlineTables;

	//bi-directional many-to-one association to TransactionTable
	@OneToMany(mappedBy="modeType")
	private List<TransactionTable> transactionTables;

	public ModeType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getModeDate() {
		return this.modeDate;
	}

	public void setModeDate(Date modeDate) {
		this.modeDate = modeDate;
	}

	public String getModeType() {
		return this.modeType;
	}

	public void setModeType(String modeType) {
		this.modeType = modeType;
	}

	public List<Cheque> getCheques() {
		return this.cheques;
	}

	public void setCheques(List<Cheque> cheques) {
		this.cheques = cheques;
	}

	public Cheque addCheque(Cheque cheque) {
		getCheques().add(cheque);
		cheque.setModeType(this);

		return cheque;
	}

	public Cheque removeCheque(Cheque cheque) {
		getCheques().remove(cheque);
		cheque.setModeType(null);

		return cheque;
	}

	public List<OnlineTable> getOnlineTables() {
		return this.onlineTables;
	}

	public void setOnlineTables(List<OnlineTable> onlineTables) {
		this.onlineTables = onlineTables;
	}

	public OnlineTable addOnlineTable(OnlineTable onlineTable) {
		getOnlineTables().add(onlineTable);
		onlineTable.setModeType(this);

		return onlineTable;
	}

	public OnlineTable removeOnlineTable(OnlineTable onlineTable) {
		getOnlineTables().remove(onlineTable);
		onlineTable.setModeType(null);

		return onlineTable;
	}

	public List<TransactionTable> getTransactionTables() {
		return this.transactionTables;
	}

	public void setTransactionTables(List<TransactionTable> transactionTables) {
		this.transactionTables = transactionTables;
	}

	public TransactionTable addTransactionTable(TransactionTable transactionTable) {
		getTransactionTables().add(transactionTable);
		transactionTable.setModeType(this);

		return transactionTable;
	}

	public TransactionTable removeTransactionTable(TransactionTable transactionTable) {
		getTransactionTables().remove(transactionTable);
		transactionTable.setModeType(null);

		return transactionTable;
	}

}