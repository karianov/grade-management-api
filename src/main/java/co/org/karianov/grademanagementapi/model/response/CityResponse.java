package co.org.karianov.grademanagementapi.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityResponse {
	
	private Integer cityId;
	private CountryResponse country;
	private String name;

}
