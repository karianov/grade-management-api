package co.org.karianov.grademanagementapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.org.karianov.grademanagementapi.model.dto.CityDto;
import co.org.karianov.grademanagementapi.model.request.CityRequest;
import co.org.karianov.grademanagementapi.model.response.CityResponse;
import co.org.karianov.grademanagementapi.service.CityService;
import co.org.karianov.grademanagementapi.service.MapperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/rest/v1/city")
@Api(tags = { "City" })
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private MapperService mapperService;

	@GetMapping("/{cityId}")
	@ApiOperation(value = "Get one existing city", notes = "REST service to obtain one existing city")
	public ResponseEntity<CityResponse> getCityById(@PathVariable Integer cityId) {
		CityDto searchedCity = cityService.getCityById(cityId);
		CityResponse response = mapperService.map(searchedCity, CityResponse.class);
		return new ResponseEntity<CityResponse>(response, HttpStatus.OK);
	}

	@GetMapping
	@ApiOperation(value = "Get all existing cities", notes = "REST service to obtain all existing cities")
	public ResponseEntity<List<CityResponse>> getAllCities() {
		List<CityDto> allCities = cityService.getAllCities();
		List<CityResponse> response = mapperService.mapList(allCities, CityResponse.class);
		return new ResponseEntity<List<CityResponse>>(response, HttpStatus.OK);
	}

	@PostMapping
	@ApiOperation(value = "Create one city", notes = "REST service to insert new cities")
	public ResponseEntity<CityResponse> createCity(@RequestBody CityRequest createCityRequest) {
		CityDto createdCity = cityService.createCity(createCityRequest);
		CityResponse response = mapperService.map(createdCity, CityResponse.class);
		return new ResponseEntity<CityResponse>(response, HttpStatus.CREATED);
	}

	@PutMapping("/{cityId}")
	@ApiOperation(value = "Update a city", notes = "REST service to update a searched city")
	public ResponseEntity<CityResponse> updateCountry(@PathVariable Integer cityId,
			@RequestBody CityRequest cityToUpdate) {
		CityDto updatedCity = cityService.updateCityById(cityId, cityToUpdate);
		CityResponse response = mapperService.map(updatedCity, CityResponse.class);
		return new ResponseEntity<CityResponse>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{cityId}")
	@ApiOperation(value = "Delete a city", notes = "REST service to delete a searched city")
	public ResponseEntity<CityResponse> deleteCountry(@PathVariable Integer cityId) {
		CityDto deletedCity = cityService.deleteCityById(cityId);
		CityResponse response = mapperService.map(deletedCity, CityResponse.class);
		return new ResponseEntity<CityResponse>(response, HttpStatus.OK);
	}

}
