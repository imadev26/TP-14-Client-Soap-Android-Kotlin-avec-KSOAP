package ma.projet.soapservice.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import ma.projet.soapservice.entity.Compte;
import ma.projet.soapservice.entity.TypeCompte;
import ma.projet.soapservice.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@WebService(serviceName = "CompteWS")
public class CompteService {
    
    @Autowired
    private CompteRepository compteRepository;
    
    /**
     * Récupère tous les comptes
     */
    @WebMethod(operationName = "getComptes")
    public List<Compte> getComptes() {
        System.out.println("=== Appel getComptes() ===");
        List<Compte> comptes = compteRepository.findAll();
        System.out.println("Nombre de comptes trouvés: " + comptes.size());
        return comptes;
    }
    
    /**
     * Récupère un compte par son ID
     */
    @WebMethod(operationName = "getCompteById")
    public Compte getCompteById(@WebParam(name = "id") Long id) {
        System.out.println("=== Appel getCompteById(" + id + ") ===");
        return compteRepository.findById(id).orElse(null);
    }
    
    /**
     * Crée un nouveau compte
     */
    @WebMethod(operationName = "createCompte")
    public Compte createCompte(
            @WebParam(name = "solde") Double solde,
            @WebParam(name = "type") String type) {
        System.out.println("=== Appel createCompte(solde=" + solde + ", type=" + type + ") ===");
        
        try {
            TypeCompte typeCompte = TypeCompte.valueOf(type.toUpperCase());
            Compte compte = new Compte(solde, typeCompte);
            Compte savedCompte = compteRepository.save(compte);
            System.out.println("Compte créé: " + savedCompte);
            return savedCompte;
        } catch (IllegalArgumentException e) {
            System.err.println("Type de compte invalide: " + type);
            return null;
        }
    }
    
    /**
     * Met à jour un compte existant
     */
    @WebMethod(operationName = "updateCompte")
    public boolean updateCompte(
            @WebParam(name = "id") Long id,
            @WebParam(name = "solde") Double solde,
            @WebParam(name = "type") String type) {
        System.out.println("=== Appel updateCompte(id=" + id + ", solde=" + solde + ", type=" + type + ") ===");
        
        try {
            Compte compte = compteRepository.findById(id).orElse(null);
            if (compte == null) {
                System.err.println("Compte non trouvé avec l'ID: " + id);
                return false;
            }
            
            compte.setSolde(solde);
            compte.setType(TypeCompte.valueOf(type.toUpperCase()));
            compteRepository.save(compte);
            System.out.println("Compte mis à jour: " + compte);
            return true;
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Supprime un compte par son ID
     */
    @WebMethod(operationName = "deleteCompte")
    public boolean deleteCompte(@WebParam(name = "id") Long id) {
        System.out.println("=== Appel deleteCompte(" + id + ") ===");
        
        try {
            if (compteRepository.existsById(id)) {
                compteRepository.deleteById(id);
                System.out.println("Compte supprimé avec succès: ID=" + id);
                return true;
            } else {
                System.err.println("Compte non trouvé avec l'ID: " + id);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Récupère les comptes par type
     */
    @WebMethod(operationName = "getComptesByType")
    public List<Compte> getComptesByType(@WebParam(name = "type") String type) {
        System.out.println("=== Appel getComptesByType(" + type + ") ===");
        
        try {
            TypeCompte typeCompte = TypeCompte.valueOf(type.toUpperCase());
            return compteRepository.findByType(typeCompte);
        } catch (IllegalArgumentException e) {
            System.err.println("Type de compte invalide: " + type);
            return List.of();
        }
    }
}
