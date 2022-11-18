package de.fi.streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * NICE (JavaDoc)
 *
 * @author Hannes
 */
public class Konto {
	
	private String kontoInhaber;
	
	private Long kontoNummer;
	
	private BigDecimal saldo;

	private final List<Konto> unterkonten = new ArrayList<>();
	
	public Konto(String kontoInhaber, int kontoNummer, BigDecimal saldo) {
		this.kontoInhaber = kontoInhaber;
		this.kontoNummer = Long.valueOf(kontoNummer);
		this.saldo = saldo;
	}

	public List<Konto> getUnterkonten() {
		return unterkonten;
	}

	public String getKontoInhaber() {
		return kontoInhaber;
	}

	public void setKontoInhaber(String kontoInhaber) {
		this.kontoInhaber = kontoInhaber;
	}

	public Long getKontoNummer() {
		return kontoNummer;
	}

	public void setKontoNummer(Long kontoNummer) {
		this.kontoNummer = kontoNummer;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	public boolean isUeberzogen() {
		return saldo.signum() < 0;
	}

}
