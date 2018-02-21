package be.vdab.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import be.vdab.entities.Artikel;

public class ArtikelRepository extends AbstractRepository {
	public Optional<Artikel> read(long id) {
		return Optional.ofNullable(getEntityManager().find(Artikel.class, id));
	}
	public void create(Artikel artikel) {
		getEntityManager().persist(artikel);
	}
	public List<Artikel> findByNaamContains(String woord, int vanafRij, int aantalRijen) {
		return getEntityManager()
				.createNamedQuery("Artikel.findByNaamContains", Artikel.class)
				.setParameter("zoals", '%' + woord + '%')
				.setFirstResult(vanafRij)
				.setMaxResults(aantalRijen)
				.getResultList();
	}
	public void prijsVerhoging(BigDecimal factor) {
		getEntityManager().createNamedQuery("Artikel.prijsVerhoging")
				.setParameter("factor", factor)
				.executeUpdate();
	}
}
