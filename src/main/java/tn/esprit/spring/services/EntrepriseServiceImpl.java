package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
 // test Junit 
	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	private static final Logger l = LoggerFactory.getLogger(EntrepriseServiceImpl.class);

	
	public int ajouterEntreprise(Entreprise entreprise) {
		
	try{
		l.info("In Method ajouterEntreprise : " );

	
		entrepriseRepoistory.save(entreprise);
		
		l.info("Out of Method ajouterEntreprise with Success");

		
	   }catch (Exception e) {
			l.error("Out of Method ajouterEntreprise  with Errors :" + e);
		}
		return entreprise.getId();
	}

	
	
	public int ajouterDepartement(Departement dep) {
		
		try {
			l.info("In Method ajouterDepartement : " );
		
		deptRepoistory.save(dep);
		
		l.info("Out of Method ajouterDepartement with Success");
		
	}  catch (Exception e) {
				l.error("Out of Method ajouterDepartement  with Errors :" + e);
			}

		return dep.getId();
		
		
	}
	
	
	
	
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		//Le bout Master de cette relation N:1 est departement  
				//donc il faut rajouter l'entreprise a departement 
				// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
				//Rappel : la classe qui contient mappedBy represente le bout Slave
				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
		try{
			l.info("In Method affecterDepartementAEntreprise : " );

				Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
				Departement depManagedEntity = deptRepoistory.findById(depId).get();
				depManagedEntity.setEntreprise(entrepriseManagedEntity);
				deptRepoistory.save(depManagedEntity);
				
				l.info("Out of Method affecterDepartementAEntreprise with Success");

				
		} catch (Exception e) {
				l.error("Out of Method affecterDepartementAEntreprise  with Errors :" + e);
			}
		
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		
		List<String> depNames = new ArrayList<>();
		Entreprise entrepriseManagedEntity ;
		
		try{
			l.info("In Method getAllDepartementsNamesByEntreprise : " );
			entrepriseManagedEntity=entrepriseRepoistory.findById(entrepriseId).get();
		
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
		    	depNames.add(dep.getName());
	      }
		      l.info("Out of Method getAllDepartementsNamesByEntreprise with Success");
		}catch (Exception e) {
				l.error("Out of Method getAllDepartementsNamesByEntreprise  with Errors :" + e);
			}

		
		
		return depNames;
	}

	
	
	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		try{
			l.info("In Method deleteEntrepriseById : " );

		entrepriseRepoistory.delete(entrepriseRepoistory.findById(entrepriseId).get());
		 
		l.info("Out of Method deleteEntrepriseById with Success");

		
		}catch (Exception e) {
				l.error("Out of Method deleteEntrepriseById  with Errors :" + e);
			}
	}
	

	@Transactional
	public void deleteDepartementById(int depId) {
		try{
			l.info("In Method deleteDepartementById : " );

		deptRepoistory.delete(deptRepoistory.findById(depId).get());
         
		   l.info("Out of Method deleteDepartementById with Success");

		
		}catch (Exception e) {
				l.error("Out of Method deleteDepartementById  with Errors :" + e);
			}
	}


	public Entreprise getEntrepriseById(int entrepriseId) {
		Entreprise entrep=null;

		try{
		l.info("In Method getEntrepriseById : " );
		entrep=entrepriseRepoistory.findById(entrepriseId).get();
	    l.info("Out of Method getEntrepriseById with Success");

		}catch (Exception e) {
				l.error("Out of Method getEntrepriseById  with Errors :" + e);
			}
		
		
		return entrep;
		}
		

	
	
	
	
	
	
	
}
