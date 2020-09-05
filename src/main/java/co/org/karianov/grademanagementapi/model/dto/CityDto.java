package co.org.karianov.grademanagementapi.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDto {
	
	private Integer cityId;
	private CountryDto country;
	private String name;

}
