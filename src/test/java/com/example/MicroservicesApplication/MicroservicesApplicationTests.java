package com.example.MicroservicesApplication;

import com.example.MicroservicesApplication.dto.Specimen;
import com.example.MicroservicesApplication.service.SpecimenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
		specimen.setSpecimenId(83);
		specimenService.save(specimen);
	}

	private void whenSearchSpecimenWithId83() {
		specimenFetched = specimenService.fetchById(83);
	}

	private void thenReturnSpecimenWithId83andDescriptionRedbud() {
		assertEquals(specimenFetched.getDescription(), "Redbud");
	}
}
