package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quiz.lesson07.entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer>{

	// JPQL => Entity에 조회
	// quiz02_2
	public List<RecruitEntity> findByCompanyId(int companyId);
	
	// quiz02_3
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	
	// quiz02_4
	public List<RecruitEntity> findByTypeOrSalaryGreaterThan(String type, int salary);
	
	// quiz02_5
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	
	// quiz02_6
	public List<RecruitEntity> findByRegionAndSalaryBetween(String string, int salaryStart, int salaryEnd);
	
	// quiz02_7_1
	@Query(value="select * from `Recruit`"
			+ "where `deadline` > :deadline"
			+ "and `salary` >= :Salary"
			+ "and `type` = :Type"
			+ "order by `salary` desc", nativeQuery = true)
	public List<RecruitEntity> findByDeadlineAndSalaryAndType(@Param("deadline")String deadline,
			@Param("Salary") int Salary,
			@Param("Type") String Type);
	

	
}
