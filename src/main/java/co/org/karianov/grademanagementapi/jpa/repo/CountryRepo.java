package co.org.karianov.grademanagementapi.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.org.karianov.grademanagementapi.model.entity.CountryEntity;

@Repository
public interface CountryRepo extends JpaRepository<CountryEntity, Integer> {

	public CountryEntity findByCountryId(Integer countryId);
	
	public CountryEntity findByName(String name);
	
}
