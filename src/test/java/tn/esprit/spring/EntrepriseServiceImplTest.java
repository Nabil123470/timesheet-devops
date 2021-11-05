package tn.esprit.spring;




import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.EntrepriseServiceImpl;
import tn.esprit.spring.services.IEntrepriseService;






@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EntrepriseServiceImplTest {
	
	@Autowired
	IEntrepriseService entrp ;
	DepartementRepository deptRepoistory;
	private static final Logger l = LoggerFactory.getLogger(EntrepriseServiceImpl.class);

  
	public void testAjouterDepartement() {
	
		try {
			Departement d = new Departement("Info");
			 deptRepoistory.save(d);
			 int id =d.getId();
			 Assertions.assertNotNull(id);
			deptRepoistory.deleteById(id);
			l.info("End add Department test method");
			} catch (NullPointerException e) {
				l.error(e.getMessage());
			}
		}
	


	
     public void testAjouterEntreprise() {
		try {
			Entreprise e = new Entreprise(1, "esprit");
			int id = entrp.ajouterEntreprise(e);
			Assertions.assertNotNull(id);
			entrp.deleteEntrepriseById(id);
			l.info("End add Entreprise test method");
			
		}
		catch(NullPointerException e) {
			l.error("vvvvv"+e.getMessage());
		}
		
	}
	
	
	
		
		public void testGetAllDepartementsNamesByEntreprise(){
		int entrepriseId = 0;
		List<String> listDepartement=entrp.getAllDepartementsNamesByEntreprise(entrepriseId);
		
		Assertions.assertEquals(0, listDepartement.size());
	}
	


	
	
	
	
	
	public void testGetEntrepriseById(){
		int entrepriseId = 0;
		List<String> listEntreprise=(List<String>) entrp.getEntrepriseById(entrepriseId);
		
		Assertions.assertEquals(0, listEntreprise.size());
	}
	
	
	
	 
	public void testDeleteEntrepriseById(){
		entrp.deleteEntrepriseById(2);
		Assertions.assertNull(entrp.getEntrepriseById(2));
			
	}
	
	

     
    public void testDeleteDepartementById(){
    	entrp.deleteDepartementById(1);
		Assertions.assertNull(deptRepoistory.findById(1));


     	}
     	
    	@Test
    	public void testAll(){
    		try{
    			l.info("In testAll()");
    			testAjouterDepartement();
    			testAjouterEntreprise();
    			testDeleteEntrepriseById();
    			testDeleteDepartementById();
    			l.info("Out of testAll()");
    			
    		}catch (Exception e ){
    			l.error("Out of testAll() wirth Errors : " + e); 
    			
    		}
    	}
    	
	
	

	
    }
	
	
	
	
	
	
	

