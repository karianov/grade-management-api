package co.org.karianov.grademanagementapi.model.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import co.org.karianov.grademanagementapi.jpa.repo.CountryRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CountryRepoIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CountryRepo countryRepo;

	@Test
	public void whenFindByName_thenReturnCountry() {
		CountryEntity colombia = new CountryEntity();
		colombia.setName("Colombia");
		entityManager.persistAndFlush(colombia);

		CountryEntity foundCountry = countryRepo.findByName(colombia.getName());
		assertThat(foundCountry.getName()).isEqualTo(colombia.getName());
	}

	@Test
	public void whenInvalidName_thenReturnNull() {
		CountryEntity entityToSearch = countryRepo.findByName("Finlandia");
		assertThat(entityToSearch).isNull();
	}

	@Test
	public void whenFindById_thenReturnCountry() {
		CountryEntity countryTest = new CountryEntity();
		countryTest.setName("Austria");
		countryTest.setCode(43);
		entityManager.persistAndFlush(countryTest);

		CountryEntity foundCountry = countryRepo.findById(countryTest.getCountryId()).orElse(null);
		assertThat(foundCountry.getName()).isEqualTo(countryTest.getName());
	}

	@Test
	public void whenInvalidId_thenReturnNull() {
		CountryEntity countryTest = countryRepo.findById(-999).orElse(null);
		assertThat(countryTest).isNull();
	}

	@Test
	public void givenSetOfEmployees_whenFindAll_thenReturnAllEmployees() {
		CountryEntity bolivia = new CountryEntity();
		bolivia.setName("Bolivia");
		bolivia.setCode(591);
		CountryEntity brazil = new CountryEntity();
		brazil.setName("Brazil");
		brazil.setCode(55);
		CountryEntity belgium = new CountryEntity();
		belgium.setName("Belgium");
		belgium.setCode(32);

		entityManager.persist(bolivia);
		entityManager.persist(brazil);
		entityManager.persist(belgium);
		entityManager.flush();

		List<CountryEntity> allCountries = countryRepo.findAll();

		assertThat(allCountries).hasSize(3).extracting(CountryEntity::getName).containsOnly(bolivia.getName(),
				brazil.getName(), belgium.getName());
	}

}
