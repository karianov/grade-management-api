package co.org.karianov.grademanagementapi.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.org.karianov.grademanagementapi.model.entity.CityEntity;

@Repository
public interface CityRepo extends JpaRepository<CityEntity, Integer> {

	public CityEntity findByCityId(Integer cityId);
	
}
