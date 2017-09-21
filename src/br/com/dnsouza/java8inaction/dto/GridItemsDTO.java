package br.com.dnsouza.java8inaction.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class GridItemsDTO {

    public static GridItemsDTO sumarizarLinhas(final List<GridItemsDTO> lista) {

        int acquirerCode = lista.get(0).getAcquirerCode();
        int liquidatorBanksCode = lista.get(0).getLiquidatorBanksCode();
        int participantCode = lista.get(0).getAcquirerCode();
        LocalDate expireDate = lista.get(0).getExpireDate();

        BigDecimal totalLiquidValue = lista.stream()
                        .collect(Collectors.reducing(BigDecimal.ZERO, GridItemsDTO::getLiquidValue, BigDecimal::add));

        return new GridItemsDTO(acquirerCode, expireDate, liquidatorBanksCode, participantCode, totalLiquidValue);
    }

    private int acquirerCode;
    private LocalDate expireDate;
    private int participantCode;
    private int liquidatorBanksCode;

    private BigDecimal liquidValue;

    public GridItemsDTO(final int acquirerCode, final LocalDate expireDate, final int participantCode,
        final int liquidatorBanksCode,
        final BigDecimal liquidValue) {
        super();
        this.acquirerCode = acquirerCode;
        this.expireDate = expireDate;
        this.participantCode = participantCode;
        this.liquidatorBanksCode = liquidatorBanksCode;
        this.liquidValue = liquidValue;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        GridItemsDTO other = (GridItemsDTO) obj;
        if (this.acquirerCode != other.acquirerCode) {
            return false;
        }
        if (this.expireDate == null) {
            if (other.expireDate != null) {
                return false;
            }
        } else if (!this.expireDate.equals(other.expireDate)) {
            return false;
        }
        if (this.liquidValue == null) {
            if (other.liquidValue != null) {
                return false;
            }
        } else if (!this.liquidValue.equals(other.liquidValue)) {
            return false;
        }
        if (this.liquidatorBanksCode != other.liquidatorBanksCode) {
            return false;
        }
        if (this.participantCode != other.participantCode) {
            return false;
        }
        return true;
    }

    public int getAcquirerCode() {
        return this.acquirerCode;
    }

    public LocalDate getExpireDate() {
        return this.expireDate;
    }

    public int getLiquidatorBanksCode() {
        return this.liquidatorBanksCode;
    }

    public BigDecimal getLiquidValue() {
        return this.liquidValue;
    }

    public int getParticipantCode() {
        return this.participantCode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.acquirerCode;
        result = prime * result + (this.expireDate == null ? 0 : this.expireDate.hashCode());
        result = prime * result + (this.liquidValue == null ? 0 : this.liquidValue.hashCode());
        result = prime * result + this.liquidatorBanksCode;
        result = prime * result + this.participantCode;
        return result;
    }

    public void setAcquirerCode(final int acquirerCode) {
        this.acquirerCode = acquirerCode;
    }

    public void setExpireDate(final LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public void setLiquidatorBanksCode(final int liquidatorBanksCode) {
        this.liquidatorBanksCode = liquidatorBanksCode;
    }

    public void setLiquidValue(final BigDecimal liquidValue) {
        this.liquidValue = liquidValue;
    }

    public void setParticipantCode(final int participantCode) {
        this.participantCode = participantCode;
    }

    public String toItemKey() {
        return this.acquirerCode + "|"
                        + this.participantCode + "|" + this.liquidatorBanksCode;
    }

    @Override
    public String toString() {
        return "GridItemsDTO [acquirerCode=" + this.acquirerCode + ", expireDate=" + this.expireDate
                        + ", participantCode="
                        + this.participantCode + ", liquidatorBanksCode=" + this.liquidatorBanksCode + ", liquidValue="
                        + this.liquidValue + "]";
    }

}
