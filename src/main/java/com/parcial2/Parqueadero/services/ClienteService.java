package com.parcial2.Parqueadero.services;

import com.parcial2.Parqueadero.model.RegistroVehiculo;
import com.parcial2.Parqueadero.repository.RegistroVehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final RegistroVehiculoRepository registroVehiculoRepository;

    public ClienteService(RegistroVehiculoRepository registroVehiculoRepository) {
        this.registroVehiculoRepository = registroVehiculoRepository;
    }

    public List<RegistroVehiculo> listarVehiculos() {
        return registroVehiculoRepository.findAll();
    }
}