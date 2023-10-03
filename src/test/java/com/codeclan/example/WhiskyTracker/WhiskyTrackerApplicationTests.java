package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.hibernate.cache.spi.Region;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ActiveProfiles("test") //Indicates it's a test profile so will not run DataLoader
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test

	public void CanFindByYear(){
		List<Whisky> findByYear = whiskyRepository.findByYear(2018);
		assertEquals("The Glendronach Revival", findByYear.get(0).getName());
	}
	@Test
	public void CanFindByRegion(){
		List<Whisky> findByRegion = whiskyRepository.findByDistilleryRegion("Lowland");
		assertEquals("The Rosebank 12 - Flora and Fona",findByRegion.get(0).getName());
	}

	@Test
	public void CanFindByDistilleryNameAndAge(){
		List<Whisky> findWhisky =whiskyRepository.findByDistilleryNameAndAge("Macallan", 25);
		assertEquals("The Macallan Anniversary Malt",findWhisky.get(0).getName());
	}


}
