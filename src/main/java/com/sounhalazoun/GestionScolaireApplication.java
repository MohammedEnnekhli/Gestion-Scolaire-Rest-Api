package com.sounhalazoun;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sounhalazoun.dao.*;
import com.sounhalazoun.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class GestionScolaireApplication implements CommandLineRunner{
    
    @Autowired
    EleveRepository eleveRepository;
    @Autowired
    ProfRepository profRepository;
    @Autowired
    EmpRepository empRepository;
    @Autowired
    FiliereRepository filiereRepository;
    @Autowired
    GroupeRepository groupeRepository;
    @Autowired
    MatiereRepository matiereRepository;
    @Autowired
    NiveauRepository niveauRepository;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    AppRoleRepository appRoleRepository;
    @Autowired
   RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(GestionScolaireApplication.class, args);
	}

    @Override
    public void run( String... args ) throws Exception {
        
  /*      repositoryRestConfiguration.getCorsRegistry()
        .addMapping( "/**" )
        .allowedOrigins( "*" )
        .allowedHeaders( "*" )
        .allowedMethods( "OPTIONS","HEAD","GET","PUT","DELETE","PATCH" );*/
        
        DateFormat dateFormat=new SimpleDateFormat( "yyyy-MM-dd" );
        AppRole role1=new AppRole(null,"ADMIN");
        AppRole role2=new AppRole(null,"USER");
        appRoleRepository.save(role1);
        appRoleRepository.save(role2);
        List<AppRole> listRoles=new ArrayList<AppRole>();
        listRoles.add(role1);
        listRoles.add(role2);
       AppUser user1=new AppUser(null,"admin","admin",listRoles);
        appUserRepository.save(user1);
        Matiere mat1=new  Matiere("Maths");
        Matiere mat2=new  Matiere("Physique");
        Matiere mat3=new  Matiere("Philosophie");
        Matiere mat4=new  Matiere("Histo-Geo");
        Filiere fil1=new Filiere("Lettres" );
        Filiere fil2=new Filiere("Sciences" );
        fil1.setMatieres( Arrays.asList( mat3,mat4 ) );
        fil2.setMatieres( Arrays.asList( mat1,mat2 ) );
        mat1.setFilieres(  Arrays.asList( fil1,fil2 ) );
        mat2.setFilieres(  Arrays.asList( fil1,fil2 ) );
        mat3.setFilieres(  Arrays.asList( fil1,fil2 ) );
        mat4.setFilieres(  Arrays.asList( fil1,fil2 ) );
        Niveau niveau1=new Niveau("Tronc commun");
        niveau1.setFilieres( Arrays.asList( fil1,fil2 ) );
        Niveau niveau2=new Niveau( "Bac 1" );
        niveau2.setFilieres( Arrays.asList( fil1,fil2 ) );
        Niveau niveau3=new Niveau( "Bac 2" );
        niveau3.setFilieres( Arrays.asList( fil1,fil2 ) );
        fil1.setNiveaux(Arrays.asList( niveau1,niveau2,niveau3 ) );
        fil2.setNiveaux(Arrays.asList( niveau1,niveau2,niveau3 ) );
        
        
        
        Eleve eleve1=new Eleve(null,"Ennasiri","Badr","Tabreket","M","0661458972","badr@gmail.com",
                dateFormat.parse("1984-07-18"),dateFormat.parse("1994-09-12"),"Salé","Ennasiri","Abderahim","0671458972",true);
        Eleve eleve2=new Eleve(null,"Ben Abdellah","Wisal","Bab Chaafa","M","0672458936","wisal@gmail.com",
                dateFormat.parse("1992-04-18"),dateFormat.parse("2000-09-12"),"Salé","Ben Abdellah","Anass","0674896245",true);
        Eleve eleve3=new Eleve(null,"Baemel","Ibrahim","Bettana","M","0664859672","baemel@gmail.com",
                dateFormat.parse("1986-11-18"),dateFormat.parse("1998-09-12"),"Salé","Ennekhli","Batoul","0674859712",true);
        Eleve eleve4=new Eleve(null,"Rochi","Kawtar","La base","F","0664782145","rochi@gmail.com",
                dateFormat.parse("1992-08-18"),dateFormat.parse("2001-09-12"),"Salé","Ennekhli","Aziza","063458963",true);
        
        Prof prof1=new Prof(null,"Bennani","Said","Agdal","M","0668754892","said@gmail.com",
                dateFormat.parse("1973-11-14"),dateFormat.parse("2000-09-12"),mat3);
        Prof prof2=new Prof(null,"Merraki","Aziz","Hay Riad","M","0662478963","merraki@gmail.com",
                dateFormat.parse("1968-10-01"),dateFormat.parse("1998-09-12"),mat1);
        Prof prof3=new Prof(null,"Sedrati","Mohamed","Hay Salam","M","0664859214","sedrati@gmail.com",
                dateFormat.parse("1961-06-08"),dateFormat.parse("1995-09-12"),mat2);
        Prof prof4=new Prof(null,"Bernousi","Amal","Bab bouhaja","F","0674154236","Bernousi@gmail.com",
                dateFormat.parse("1973-06-21"),dateFormat.parse("2004-09-12"),mat4);
        
        Emp emp1=new Emp(null,"Ghelab","Aicha","Bettana","F","062789645","aicha@gmail.com",
                dateFormat.parse("1981-08-11"),dateFormat.parse("2005-09-12"),"Comptable",5000);
        empRepository.save( emp1 );
        Emp emp2=new Emp(null,"Omari","Nada","Hay Karima","F","0624589327","nada@gmail.com",
                dateFormat.parse("1984-03-11"),dateFormat.parse("2007-09-12"),"Reception",4000);
        

        
        Groupe groupe1=new Groupe( null, "TCS1", Arrays.asList( eleve1,eleve2 ), Arrays.asList( prof1,prof2,prof3 ),fil2,niveau1 );
        Groupe groupe2=new Groupe( null, "2BacL2",null, Arrays.asList( prof3,prof4 ),fil1,niveau3 );
        Groupe groupe3=new Groupe( null, "TCS2", Arrays.asList( eleve3,eleve4 ), Arrays.asList( prof1,prof2,prof4 ),fil2,niveau1 );
        Groupe groupe4=new Groupe( "TCL1" ,fil1,niveau1);
        Groupe groupe5=new Groupe( "TCL2",fil1,niveau1 );
        Groupe groupe6=new Groupe( "1BacS1",fil2,niveau2 );
        Groupe groupe7=new Groupe( "1BacS2" ,fil2,niveau2);
        Groupe groupe8=new Groupe( "1BacL1",fil1,niveau2 );
        Groupe groupe9=new Groupe( "1BacL2",fil1,niveau2 );
        Groupe groupe10=new Groupe( "2BacS1",fil2,niveau3 );
        Groupe groupe11=new Groupe( "2BacS2",fil2,niveau3 );
        Groupe groupe12=new Groupe( "2BacL1",fil1,niveau3 );
   
        fil2.setGroupes( Arrays.asList(groupe1,groupe3,groupe6,groupe7,groupe10,groupe11)  );
        fil1.setGroupes( Arrays.asList(groupe2,groupe4,groupe5,groupe8,groupe9,groupe12 )  );
        eleve1.setGroupe( groupe1 );
        eleve2.setGroupe( groupe1 );
        eleve3.setGroupe( groupe3 );
        eleve4.setGroupe( groupe3 );
        prof1.setGroupe( Arrays.asList(groupe1,groupe3 ) );
        prof2.setGroupe( Arrays.asList(groupe1,groupe3 ) );
        prof3.setGroupe( Arrays.asList(groupe1,groupe2 ) );
        prof4.setGroupe( Arrays.asList(groupe2,groupe3 ) );
        

        matiereRepository.save( mat1 );
        matiereRepository.save( mat2 );
        matiereRepository.save( mat3 );
        matiereRepository.save( mat4 );
        filiereRepository.save( fil1 );
        eleveRepository.save( eleve1 );
        eleveRepository.save( eleve2 );
        profRepository.save( prof1 );
        profRepository.save( prof2 );
        profRepository.save( prof3 );
        profRepository.save( prof4 );
        empRepository.save( emp1 );
        empRepository.save( emp2 );
        filiereRepository.save( fil2 );
        niveauRepository.save( niveau1 );
        niveauRepository.save( niveau2 );
        niveauRepository.save( niveau3 );
        groupeRepository.save( groupe1 );
        groupeRepository.save( groupe2 );
        groupeRepository.save( groupe3 );
        groupeRepository.save( groupe4 );
        groupeRepository.save( groupe5 );
        groupeRepository.save( groupe6 );
        groupeRepository.save( groupe7 );
        groupeRepository.save( groupe8 );
        groupeRepository.save( groupe9 );
        groupeRepository.save( groupe10 );
        groupeRepository.save( groupe11);
        groupeRepository.save( groupe12 );
        
        repositoryRestConfiguration.exposeIdsFor(Filiere.class) ;
        repositoryRestConfiguration.exposeIdsFor(Niveau.class) ;
        repositoryRestConfiguration.exposeIdsFor(Eleve.class) ;
        repositoryRestConfiguration.exposeIdsFor(Prof.class) ;
        repositoryRestConfiguration.exposeIdsFor(Emp.class) ;
        repositoryRestConfiguration.exposeIdsFor(Matiere.class) ;
        repositoryRestConfiguration.exposeIdsFor(Groupe.class) ;
        
        
        System.out.println( groupeRepository.findByFiliereAndNiveau( 1L, 1L ).get( 0 ).getNomG() );
    }
    
    @Bean
    BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }
   
   
    

}
