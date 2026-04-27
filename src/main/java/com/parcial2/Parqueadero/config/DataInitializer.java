package com.parcial2.Parqueadero.config;

import com.parcial2.Parqueadero.model.Rol;
import com.parcial2.Parqueadero.model.TipoVehiculo;
import com.parcial2.Parqueadero.repository.RolRepository;
import com.parcial2.Parqueadero.repository.TipoVehiculoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(RolRepository rolRepository,
                               TipoVehiculoRepository tipoVehiculoRepository) {
        return args -> {

            // Roles
            if (rolRepository.findByTipo("ADMINISTRADOR").isEmpty()) {
                rolRepository.save(new Rol(null, "ADMINISTRADOR"));
            }

            if (rolRepository.findByTipo("ACOMODADOR").isEmpty()) {
                rolRepository.save(new Rol(null, "ACOMODADOR"));
            }

            if (rolRepository.findByTipo("CLIENTE").isEmpty()) {
                rolRepository.save(new Rol(null, "CLIENTE"));
            }

            // Tipos de vehículo
            if (tipoVehiculoRepository.findByNombre("CARRO").isEmpty()) {
                tipoVehiculoRepository.save(new TipoVehiculo(null, "CARRO"));
            }

            if (tipoVehiculoRepository.findByNombre("MOTO").isEmpty()) {
                tipoVehiculoRepository.save(new TipoVehiculo(null, "MOTO"));
            }

            if (tipoVehiculoRepository.findByNombre("CAMIONETA").isEmpty()) {
                tipoVehiculoRepository.save(new TipoVehiculo(null, "CAMIONETA"));
            }
        };
    }
}