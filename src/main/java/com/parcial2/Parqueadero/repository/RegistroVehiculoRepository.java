package com.parcial2.Parqueadero.repository;

import com.parcial2.Parqueadero.model.RegistroVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroVehiculoRepository extends JpaRepository<RegistroVehiculo, Long> {
}