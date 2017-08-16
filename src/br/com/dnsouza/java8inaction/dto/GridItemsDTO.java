package br.com.dnsouza.java8inaction.dto;

import java.time.LocalDate;

public class GridItemsDTO {
	
	public GridItemsDTO(int acquirerCode, LocalDate expireDate, int participantCode, int liquidatorBanksCode) {
		super();
		this.acquirerCode = acquirerCode;
		this.expireDate = expireDate;
		this.participantCode = participantCode;
		this.liquidatorBanksCode = liquidatorBanksCode;
	}

	private int acquirerCode;
	private LocalDate expireDate;
	private int participantCode;
	private int liquidatorBanksCode;
	
	public int getAcquirerCode() {
		return acquirerCode;
	}
	public void setAcquirerCode(int acquirerCode) {
		this.acquirerCode = acquirerCode;
	}
	public LocalDate getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}
	public int getParticipantCode() {
		return participantCode;
	}
	public void setParticipantCode(int participantCode) {
		this.participantCode = participantCode;
	}
	public int getLiquidatorBanksCode() {
		return liquidatorBanksCode;
	}
	public void setLiquidatorBanksCode(int liquidatorBanksCode) {
		this.liquidatorBanksCode = liquidatorBanksCode;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acquirerCode;
		result = prime * result
				+ ((expireDate == null) ? 0 : expireDate.hashCode());
		result = prime * result + liquidatorBanksCode;
		result = prime * result + participantCode;
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GridItemsDTO other = (GridItemsDTO) obj;
		if (acquirerCode != other.acquirerCode)
			return false;
		if (expireDate == null) {
			if (other.expireDate != null)
				return false;
		} else if (!expireDate.equals(other.expireDate))
			return false;
		if (liquidatorBanksCode != other.liquidatorBanksCode)
			return false;
		if (participantCode != other.participantCode)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GridItemsDTO [acquirerCode=" + acquirerCode + ", expireDate=" + expireDate + ", participantCode="
				+ participantCode + ", liquidatorBanksCode=" + liquidatorBanksCode + "]";
	}	
	
	
	
}
