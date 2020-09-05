package co.org.karianov.grademanagementapi.service;

import java.util.List;

import co.org.karianov.grademanagementapi.model.dto.CityDto;
import co.org.karianov.grademanagementapi.model.request.CityRequest;

public interface CityService {

	public CityDto getCityById(Integer cityId);

	public List<CityDto> getAllCities();

	public CityDto createCity(CityRequest cityRequest);

	public CityDto updateCityById(Integer cityId, CityRequest cityRequest);

	public CityDto deleteCityById(Integer cityId);

}
