package tn.esprit.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.services.ContratServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ContratTest {
	@Autowired
	ContratServiceImpl contratServiceImpl;
@Test
public void getAllContractTest() {
	contratServiceImpl.getAllContrats();
	
}
}
