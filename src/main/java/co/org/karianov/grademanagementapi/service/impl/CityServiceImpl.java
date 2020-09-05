package co.org.karianov.grademanagementapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.org.karianov.grademanagementapi.jpa.dao.CityDao;
import co.org.karianov.grademanagementapi.jpa.dao.CountryDao;
import co.org.karianov.grademanagementapi.model.dto.CityDto;
import co.org.karianov.grademanagementapi.model.dto.CountryDto;
import co.org.karianov.grademanagementapi.model.request.CityRequest;
import co.org.karianov.grademanagementapi.service.CityService;
import co.org.karianov.grademanagementapi.util.exception.NotFoundException;

@Service(value = "cityService")
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDao cityDao;

	@Autowired
	private CountryDao countryDao;

	@Override
	public CityDto getCityById(Integer cityId) {
		return cityDao.getCityById(cityId);
	}

	@Override
	public List<CityDto> getAllCities() {
		return cityDao.getAllCities();
	}

	@Override
	public CityDto createCity(CityRequest cityRequest) {
		CountryDto inputCountry = countryDao.getCountryById(cityRequest.getCountryId());
		if (inputCountry == null)
			throw new NotFoundException("The country with ID " + cityRequest.getCountryId() + " was not found.");
		CityDto cityToCreate = new CityDto();
		cityToCreate.setCountry(inputCountry);
		cityToCreate.setName(cityRequest.getName());
		cityDao.createCity(cityToCreate);
		return cityToCreate;
	}

	@Override
	public CityDto updateCityById(Integer cityId, CityRequest cityRequest) {
		CountryDto inputCountry = countryDao.getCountryById(cityRequest.getCountryId());
		if (inputCountry == null)
			throw new NotFoundException("The country with ID " + cityRequest.getCountryId() + " was not found.");
		CityDto searchedCountry = cityDao.getCityById(cityId);
		if (searchedCountry == null)
			throw new NotFoundException("The city with ID " + cityId + " was not found.");
		CityDto cityToUpdate = new CityDto();
		cityToUpdate.setCityId(cityId);
		cityToUpdate.setName(cityRequest.getName());
		cityToUpdate.setCountry(inputCountry);
		cityDao.updateCity(cityToUpdate);
		return cityToUpdate;
	}

	@Override
	public CityDto deleteCityById(Integer cityId) {
		CityDto searchedCity = cityDao.getCityById(cityId);
		if (searchedCity == null)
			throw new NotFoundException("The city with ID " + cityId + " was not found.");
		cityDao.deleteCity(cityId);
		return searchedCity;
	}

}
