package co.org.karianov.grademanagementapi.service;

import java.util.List;

import co.org.karianov.grademanagementapi.model.dto.CountryDto;
import co.org.karianov.grademanagementapi.model.request.CountryRequest;

public interface CountryService {

	public CountryDto getCountryById(Integer countryId);

	public List<CountryDto> getAllCountries();

	public CountryDto createCountry(CountryRequest countryRequest);

	public CountryDto updateCountryById(Integer countryId, CountryRequest countryRequest);

	public CountryDto deleteCountryById(Integer countryId);

}
