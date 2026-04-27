package com.parcial2.Parqueadero.services;

import com.parcial2.Parqueadero.model.RegistroVehiculo;
import com.parcial2.Parqueadero.repository.RegistroVehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcomodadorService {

    private final RegistroVehiculoRepository registroVehiculoRepository;

    public AcomodadorService(RegistroVehiculoRepository registroVehiculoRepository) {
        this.registroVehiculoRepository = registroVehiculoRepository;
    }

    // Listar todos
    public List<RegistroVehiculo> listarVehiculos() {
        return registroVehiculoRepository.findAll();
    }

    // Actualizar ubicación
    public void actualizarUbicacion(Long id, String nuevaUbicacion) {

        RegistroVehiculo registro = registroVehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));

        registro.setUbicacion(nuevaUbicacion);

        registroVehiculoRepository.save(registro);
    }
}