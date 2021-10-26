package tn.esprit.spring.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {


	@Autowired
	ContratRepository contratRepository;
	private static final Logger l =  Logger.getLogger(ContratServiceImpl.class);

	public List<Contrat> getAllContrats() {
		List<Contrat> list=null;
		l.debug("debut de la fonction getAllcontarts");
		try {
		list=(List<Contrat>) contratRepository.findAll();
		}catch(Exception e) {
			l.error("l'erreur est "+e );
		}
		l.info("la list de contart est"+list);
		return list  ;
	
	}

}
