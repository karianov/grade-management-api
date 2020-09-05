package co.org.karianov.grademanagementapi.jpa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.org.karianov.grademanagementapi.jpa.dao.CityDao;
import co.org.karianov.grademanagementapi.jpa.repo.CityRepo;
import co.org.karianov.grademanagementapi.model.dto.CityDto;
import co.org.karianov.grademanagementapi.model.entity.CityEntity;
import co.org.karianov.grademanagementapi.service.MapperService;

@Component
public class CityDaoImpl implements CityDao {

	@Autowired
	private CityRepo cityRepo;
	
	@Autowired
	private MapperService mapperService;
	
	@Override
	public CityDto getCityById(Integer cityId) {
		CityEntity retrievedCity = cityRepo.findByCityId(cityId);
		return mapperService.map(retrievedCity, CityDto.class);
	}

	@Override
	public List<CityDto> getAllCities() {
		List<CityEntity> retrievedCities = cityRepo.findAll();
		return mapperService.mapList(retrievedCities, CityDto.class);
	}

	@Override
	public CityDto createCity(CityDto cityToCreate) {
		CityEntity newCity = new CityEntity();
		newCity.setCityId(cityToCreate.getCityId());
		newCity.setCountryId(cityToCreate.getCountry().getCountryId());
		newCity.setName(cityToCreate.getName());
		CityEntity createdCity = cityRepo.save(newCity);
		return mapperService.map(createdCity, CityDto.class);
	}

	@Override
	public CityDto updateCity(CityDto cityToUpdate) {
		CityEntity updatedCity = cityRepo.save(mapperService.map(cityToUpdate, CityEntity.class));
		return mapperService.map(updatedCity, CityDto.class);
	}

	@Override
	public void deleteCity(Integer cityId) {
		cityRepo.deleteById(cityId);
	}

}
