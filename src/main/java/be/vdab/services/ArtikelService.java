package be.vdab.services;

import java.util.Optional;

import javax.persistence.PersistenceException;

import be.vdab.entities.Artikel;
import be.vdab.repositories.ArtikelRepository;

public class ArtikelService extends AbstractService {
	private final ArtikelRepository artikelRepository = new ArtikelRepository();
	public Optional<Artikel> read(long id) {
		return artikelRepository.read(id);
	}
	public void create(Artikel artikel) {
		beginTransaction();
		try {
			artikelRepository.create(artikel);
			commit();
		} catch (PersistenceException ex) {
			rollback();
			throw ex;
		} 
	}
}
