package cn.java.entity;

import java.io.Serializable;

public class OwnerEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3759437824513884341L;
	private Integer id;
	private String yz;
	private String psd;
	private String confirmpsd;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getYz() {
		return yz;
	}

	public void setYz(String yz) {
		this.yz = yz;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	public String getConfirmpsd() {
		return confirmpsd;
	}

	public void setConfirmpsd(String confirmpsd) {
		this.confirmpsd = confirmpsd;
	}

}
