package com.loanmanagment.hibernate;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the online_table database table.
 * 
 */
@Entity
@Table(name="online_table")
@NamedQuery(name="OnlineTable.findAll", query="SELECT o FROM OnlineTable o")
public class OnlineTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String platform;

	@Temporal(TemporalType.DATE)
	@Column(name="present_date")
	private Date presentDate;

	//bi-directional many-to-one association to ModeType
	@ManyToOne
	@JoinColumn(name="mode_id")
	private ModeType modeType;

	public OnlineTable() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlatform() {
		return this.platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
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