package in.ag.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ag.entity.EdEligDtlsEntity;

public interface EdEligRepository extends JpaRepository<EdEligDtlsEntity, Serializable> {
	
	@Query(" from EdEligDtlsEntity where planStatus = 'Approved'")
	public List<EdEligDtlsEntity> getCitizenData();
	

}
