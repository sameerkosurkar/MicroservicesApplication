package com.example.MicroservicesApplication;

import com.example.MicroservicesApplication.dto.Specimen;
import com.example.MicroservicesApplication.service.SpecimenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MicroservicesApplicationTests {

	Specimen specimen;
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

	}

	private void whenSearchSpecimenWithId83() {
		specimen = specimenService.fetchById(83);
	}

	private void thenReturnSpecimenWithId83andDescriptionRedbud() {
		assertEquals(specimen.getDescription(), "Redbud");
	}
}
