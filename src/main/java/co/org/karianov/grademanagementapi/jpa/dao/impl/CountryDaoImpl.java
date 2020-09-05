package co.org.karianov.grademanagementapi.jpa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.org.karianov.grademanagementapi.jpa.dao.CountryDao;
import co.org.karianov.grademanagementapi.jpa.repo.CountryRepo;
import co.org.karianov.grademanagementapi.model.dto.CountryDto;
import co.org.karianov.grademanagementapi.model.entity.CountryEntity;
import co.org.karianov.grademanagementapi.service.MapperService;

@Component
public class CountryDaoImpl implements CountryDao {

	@Autowired
	private CountryRepo countryRepo;
	
	@Autowired
	private MapperService mapperService;
	
	@Override
	public CountryDto getCountryById(Integer countryId) {
		CountryEntity retrievedCountry = countryRepo.findByCountryId(countryId);
		return mapperService.map(retrievedCountry, CountryDto.class);
	}

	@Override
	public List<CountryDto> getAllCountries() {
		List<CountryEntity> retrievedCountries = countryRepo.findAll();
		return mapperService.mapList(retrievedCountries, CountryDto.class);
	}

	@Override
	public CountryDto createCountry(CountryDto countryToCreate) {
		CountryEntity createdCountry = countryRepo.save(mapperService.map(countryToCreate, CountryEntity.class));
		return mapperService.map(createdCountry, CountryDto.class);
	}

	@Override
	public CountryDto updateCountry(CountryDto countryToUpdate) {
		CountryEntity updatedCountry = countryRepo.save(mapperService.map(countryToUpdate, CountryEntity.class));
		return mapperService.map(updatedCountry, CountryDto.class);
	}

	@Override
	public void deleteCountry(Integer countryId) {
		countryRepo.deleteById(countryId);
	}

}
