package be.vdab.valueObjects;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Korting implements Serializable {
	private static final long serialVersionUID = 1L;
	private int vanafAantal;
	private BigDecimal kortingsPercentage;
	public Korting(int vanafAantal, BigDecimal kortingsPercentage) {
		this.vanafAantal = vanafAantal;
		this.kortingsPercentage = kortingsPercentage;
	}
	protected Korting() {
	}
	public int getVanafAantal() {
		return vanafAantal;
	}
	public BigDecimal getKortingsPercentage() {
		return kortingsPercentage;
	}
	@Override
	public int hashCode() {
		return kortingsPercentage.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Korting)) {
			return false;
		}
		Korting korting = (Korting) obj;
		return kortingsPercentage.compareTo(korting.kortingsPercentage) == 0;
	}
		
}
