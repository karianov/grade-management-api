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

import co.org.karianov.grademanagementapi.model.dto.CountryDto;
import co.org.karianov.grademanagementapi.model.request.CountryRequest;
import co.org.karianov.grademanagementapi.model.response.CountryResponse;
import co.org.karianov.grademanagementapi.service.CountryService;
import co.org.karianov.grademanagementapi.service.MapperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/rest/v1/country")
@Api(tags = { "Country" })
public class CountryController {

	@Autowired
	private CountryService countryService;

	@Autowired
	private MapperService mapperService;

	@GetMapping("/{countryId}")
	@ApiOperation(value = "Get one existing country", notes = "REST service to obtain one existing country")
	public ResponseEntity<CountryResponse> getCountryById(@PathVariable Integer countryId) {
		CountryDto searchedCountry = countryService.getCountryById(countryId);
		CountryResponse response = mapperService.map(searchedCountry, CountryResponse.class);
		return new ResponseEntity<CountryResponse>(response, HttpStatus.OK);
	}

	@GetMapping
	@ApiOperation(value = "Get all existing countries", notes = "REST service to obtain all existing countries")
	public ResponseEntity<List<CountryResponse>> getAllCountries() {
		List<CountryDto> allCountries = countryService.getAllCountries();
		List<CountryResponse> response = mapperService.mapList(allCountries, CountryResponse.class);
		return new ResponseEntity<List<CountryResponse>>(response, HttpStatus.OK);
	}

	@PostMapping
	@ApiOperation(value = "Create one country", notes = "REST service to insert new countries")
	public ResponseEntity<CountryResponse> createCountry(@RequestBody CountryRequest createCountryRequest) {
		CountryDto createdCountry = countryService.createCountry(createCountryRequest);
		CountryResponse response = mapperService.map(createdCountry, CountryResponse.class);
		return new ResponseEntity<CountryResponse>(response, HttpStatus.CREATED);
	}

	@PutMapping("/{countryId}")
	@ApiOperation(value = "Update a country", notes = "REST service to update a searched country")
	public ResponseEntity<CountryResponse> updateCountry(@PathVariable Integer countryId,
			@RequestBody CountryRequest countryToUpdate) {
		CountryDto updatedCountry = countryService.updateCountryById(countryId, countryToUpdate);
		CountryResponse response = mapperService.map(updatedCountry, CountryResponse.class);
		return new ResponseEntity<CountryResponse>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{countryId}")
	@ApiOperation(value = "Delete a country", notes = "REST service to delete a searched country")
	public ResponseEntity<CountryResponse> deleteCountry(@PathVariable Integer countryId) {
		CountryDto deletedCountry = countryService.deleteCountryById(countryId);
		CountryResponse response = mapperService.map(deletedCountry, CountryResponse.class);
		return new ResponseEntity<CountryResponse>(response, HttpStatus.OK);
	}

}
