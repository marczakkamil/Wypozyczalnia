package net.kamil;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import net.kamil.klienci.Klienci;
import net.kamil.klienci.KlienciRepzytorium;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class KlinciRepozytoriumTest {
	
	@Autowired
	private KlienciRepzytorium repo;

	@Test
	public void tesCreateKlieni() {
		Klienci savedKlienci= repo.save(new Klienci("Kaml1"));
		
		assertThat(savedKlienci.getId()).isGreaterThan(0);
	}
	
}
