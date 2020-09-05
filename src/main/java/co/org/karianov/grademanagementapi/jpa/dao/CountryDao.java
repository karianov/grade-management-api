package co.org.karianov.grademanagementapi.jpa.dao;

import java.util.List;

import co.org.karianov.grademanagementapi.model.dto.CountryDto;

public interface CountryDao {

	public CountryDto getCountryById(Integer countryId);

	public List<CountryDto> getAllCountries();

	public CountryDto createCountry(CountryDto countryToCreate);

	public CountryDto updateCountry(CountryDto countryToUpdate);

	public void deleteCountry(Integer countryId);

}
