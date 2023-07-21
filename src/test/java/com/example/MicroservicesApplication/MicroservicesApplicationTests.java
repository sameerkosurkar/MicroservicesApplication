package com.example.MicroservicesApplication;

import com.example.MicroservicesApplication.dto.Specimen;
import com.example.MicroservicesApplication.service.SpecimenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MicroservicesApplicationTests {

	Specimen specimenFetched;

	@Autowired
	SpecimenService specimenService;

	@Test
	void contextLoads() {
	}

	@Test
	void fetchById_AcceptId83andReturnSpecimenDescriptionRedbud() {
		givenSpecimenInfo();
		whenSearchSpecimenWithId83();
		thenReturnSpecimenWithId83andDescriptionRedbud();
	}

	private void givenSpecimenInfo() {
		Specimen specimen = new Specimen();
		specimen.setDescription("Redbud");
		specimen.setSpecimenId(1);
		specimenService.save(specimen);
	}

	private void whenSearchSpecimenWithId83() {
		specimenFetched = specimenService.fetchById(1);
	}

	private void thenReturnSpecimenWithId83andDescriptionRedbud() {
		specimenService.delete(1);
		assertEquals(specimenFetched.getDescription(), "Redbud");
	}

	@Test
	void crudOperationsTest() {
		createSpecimen1();
		createSpecimen2();
		getAllspecimens();
		getSpecimenById();
		deleteSpecimen();
	}

	Specimen specimen = new Specimen();
	List<Specimen> specimens = new ArrayList<>();

	private void createSpecimen1() {
		specimen.setSpecimenId(2);
		specimen.setDescription("d1");
		specimenService.save(specimen);
		specimens.add(specimen);
	}

	Specimen specimen1 = new Specimen();

	private void createSpecimen2() {
		specimen1.setSpecimenId(3);
		specimen1.setDescription("d2");
		specimenService.save(specimen1);
		specimens.add(specimen1);
	}

	private void getAllspecimens() {
		List<Specimen> specimenList = specimenService.fetchAll();
		assertEquals(specimens, specimenList);
	}

	private void getSpecimenById() {
		specimenFetched = specimenService.fetchById(2);
		assertEquals(specimen, specimenFetched);
	}

	private void deleteSpecimen() {
		specimenService.delete(2);
		List<Specimen> specimenList = specimenService.fetchAll();
		assertEquals(1, specimenList.size());
	}

}
