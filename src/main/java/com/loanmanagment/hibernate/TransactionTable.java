package com.loanmanagment.hibernate;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the transaction_table database table.
 * 
 */
@Entity
@Table(name="transaction_table")
@NamedQuery(name="TransactionTable.findAll", query="SELECT t FROM TransactionTable t")
public class TransactionTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int ammount;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	private int rot;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	private int tds;

	//bi-directional many-to-one association to Brokrage
	@OneToMany(mappedBy="transactionTable")
	private List<Brokrage> brokrages;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="investor_id")
	private Role role1;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="receiver_id")
	private Role role2;

	//bi-directional many-to-one association to ModeType
	@ManyToOne
	@JoinColumn(name="mode_id")
	private ModeType modeType;

	public TransactionTable() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmmount() {
		return this.ammount;
	}

	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getRot() {
		return this.rot;
	}

	public void setRot(int rot) {
		this.rot = rot;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getTds() {
		return this.tds;
	}

	public void setTds(int tds) {
		this.tds = tds;
	}

	public List<Brokrage> getBrokrages() {
		return this.brokrages;
	}

	public void setBrokrages(List<Brokrage> brokrages) {
		this.brokrages = brokrages;
	}

	public Brokrage addBrokrage(Brokrage brokrage) {
		getBrokrages().add(brokrage);
		brokrage.setTransactionTable(this);

		return brokrage;
	}

	public Brokrage removeBrokrage(Brokrage brokrage) {
		getBrokrages().remove(brokrage);
		brokrage.setTransactionTable(null);

		return brokrage;
	}

	public Role getRole1() {
		return this.role1;
	}

	public void setRole1(Role role1) {
		this.role1 = role1;
	}

	public Role getRole2() {
		return this.role2;
	}

	public void setRole2(Role role2) {
		this.role2 = role2;
	}

	public ModeType getModeType() {
		return this.modeType;
	}

	public void setModeType(ModeType modeType) {
		this.modeType = modeType;
	}

}