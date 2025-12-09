# TP Client SOAP Android Kotlin avec KSOAP

## 📱 Application Android de Gestion de Comptes Bancaires via SOAP

Application Android développée en Kotlin utilisant le protocole SOAP pour la gestion des comptes bancaires.

### Fonctionnalités
- ✅ Afficher la liste des comptes
- ✅ Ajouter un nouveau compte
- ✅ Modifier un compte existant
- ✅ Supprimer un compte

### Technologies utilisées
- **Android** (Kotlin)
- **KSOAP2** - Bibliothèque SOAP pour Android
- **Spring Boot** - Backend SOAP
- **Apache CXF** - Framework SOAP
- **H2 Database** - Base de données en mémoire

---

## 🎬 Vidéo Démo

[![Vidéo Démo](https://img.shields.io/badge/📺-Voir%20la%20Démo-red?style=for-the-badge)](https://drive.google.com/file/d/10_corazRNGWS1WVKDQPWoEPTEbhX5bUz/view?usp=sharing)

👉 **[Cliquez ici pour voir la démonstration vidéo](https://drive.google.com/file/d/10_corazRNGWS1WVKDQPWoEPTEbhX5bUz/view?usp=sharing)**

---

## 📂 Structure du Projet

```
SOAPCompteApp/
├── app/                          # Application Android
│   └── src/main/java/ma/projet/soapcompteapp/
│       ├── beans/                # Data classes (Compte, TypeCompte)
│       ├── ws/                   # Service SOAP (KSOAP2)
│       ├── adapter/              # RecyclerView Adapter
│       └── MainActivity.kt       # Activité principale
│
└── soap-service/                 # Backend Spring Boot SOAP
    └── src/main/java/ma/projet/soapservice/
        ├── entity/               # Entités JPA
        ├── repository/           # Repositories
        ├── ws/                   # Web Service SOAP
        └── config/               # Configuration CXF
```

---

## 🚀 Comment exécuter

### Backend (SOAP Service)
```bash
cd soap-service
mvn spring-boot:run
```
Le service démarre sur `http://localhost:8082/services/ws`

### Application Android
1. Ouvrir le projet dans Android Studio
2. Lancer l'émulateur Android
3. Exécuter l'application

---

**Réalisé par:** IMADEV
