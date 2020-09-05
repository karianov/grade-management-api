package co.org.karianov.grademanagementapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.org.karianov.grademanagementapi.jpa.dao.CountryDao;
import co.org.karianov.grademanagementapi.model.dto.CountryDto;
import co.org.karianov.grademanagementapi.model.request.CountryRequest;
import co.org.karianov.grademanagementapi.service.CountryService;
import co.org.karianov.grademanagementapi.service.MapperService;
import co.org.karianov.grademanagementapi.util.exception.NotFoundException;

@Service(value = "countryService")
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	private CountryDao countryDao;
	
	@Autowired
	private MapperService mapperService;

	@Override
	public CountryDto getCountryById(Integer countryId) {
		return countryDao.getCountryById(countryId);
	}

	@Override
	public List<CountryDto> getAllCountries() {
		return countryDao.getAllCountries();
	}

	@Override
	public CountryDto createCountry(CountryRequest countryRequest) {
		CountryDto countryToCreate = mapperService.map(countryRequest, CountryDto.class);
		countryToCreate.setCountryId(null);
		return countryDao.createCountry(countryToCreate);
	}

	@Override
	public CountryDto updateCountryById(Integer countryId, CountryRequest countryRequest) {
		CountryDto searchedCountry = countryDao.getCountryById(countryId);
		if (searchedCountry == null)
			throw new NotFoundException("The country with ID " + countryId + " was not found.");
		CountryDto countryToUpdate = mapperService.map(countryRequest, CountryDto.class);
		countryToUpdate.setCountryId(countryId);
		return countryDao.updateCountry(countryToUpdate);
	}

	@Override
	public CountryDto deleteCountryById(Integer countryId) {
		CountryDto searchedCountry = countryDao.getCountryById(countryId);
		if (searchedCountry == null)
			throw new NotFoundException("The country with ID " + countryId + " was not found.");
		countryDao.deleteCountry(countryId);
		return searchedCountry;
	}
	
}
