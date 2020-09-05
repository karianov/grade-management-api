package co.org.karianov.grademanagementapi.jpa.dao;

import java.util.List;

import co.org.karianov.grademanagementapi.model.dto.CityDto;

public interface CityDao {

	public CityDto getCityById(Integer cityId);

	public List<CityDto> getAllCities();

	public CityDto createCity(CityDto cityToCreate);

	public CityDto updateCity(CityDto cityToUpdate);

	public void deleteCity(Integer cityId);

}
