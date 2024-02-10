package com.hopital.hopline.Repository;
import com.hopital.hopline.Model.Modeldocteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface docteur_repo extends JpaRepository<Modeldocteur, Long> {
}
