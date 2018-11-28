package com.loanmanagment.hibernate;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cheque database table.
 * 
 */
@Entity
@Table(name="cheque")
@NamedQuery(name="Cheque.findAll", query="SELECT c FROM Cheque c")
public class Cheque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="cheque_date")
	private Date chequeDate;

	@Column(name="cheque_no")
	private int chequeNo;

	@Temporal(TemporalType.DATE)
	@Column(name="present_date")
	private Date presentDate;

	//bi-directional many-to-one association to ModeType
	@ManyToOne
	@JoinColumn(name="mode_id")
	private ModeType modeType;

	public Cheque() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getChequeDate() {
		return this.chequeDate;
	}

	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	public int getChequeNo() {
		return this.chequeNo;
	}

	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}

	public Date getPresentDate() {
		return this.presentDate;
	}

	public void setPresentDate(Date presentDate) {
		this.presentDate = presentDate;
	}

	public ModeType getModeType() {
		return this.modeType;
	}

	public void setModeType(ModeType modeType) {
		this.modeType = modeType;
	}

}