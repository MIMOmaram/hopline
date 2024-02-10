package com.hopital.hopline.Repository;

import com.hopital.hopline.Model.Modelpatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface patient_repo extends JpaRepository<Modelpatient, Long> {
}
