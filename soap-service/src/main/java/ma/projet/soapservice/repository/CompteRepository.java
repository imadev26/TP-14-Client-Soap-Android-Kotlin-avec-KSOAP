package ma.projet.soapservice.repository;

import ma.projet.soapservice.entity.Compte;
import ma.projet.soapservice.entity.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
    
    // Méthodes de recherche personnalisées
    List<Compte> findByType(TypeCompte type);
    
    List<Compte> findBySoldeGreaterThan(Double solde);
}
