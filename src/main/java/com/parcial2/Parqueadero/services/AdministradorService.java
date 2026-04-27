package com.parcial2.Parqueadero.services;

import com.parcial2.Parqueadero.dto.RegistroVehiculoDTO;
import com.parcial2.Parqueadero.model.RegistroVehiculo;
import com.parcial2.Parqueadero.model.TipoVehiculo;
import com.parcial2.Parqueadero.repository.RegistroVehiculoRepository;
import com.parcial2.Parqueadero.repository.TipoVehiculoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdministradorService {

    private final RegistroVehiculoRepository registroVehiculoRepository;
    private final TipoVehiculoRepository tipoVehiculoRepository;

    public AdministradorService(RegistroVehiculoRepository registroVehiculoRepository,
                                TipoVehiculoRepository tipoVehiculoRepository) {
        this.registroVehiculoRepository = registroVehiculoRepository;
        this.tipoVehiculoRepository = tipoVehiculoRepository;
    }

    // Crear entrada
    public void registrarEntrada(RegistroVehiculoDTO dto) {

        TipoVehiculo tipoVehiculo = tipoVehiculoRepository.findById(dto.getTipoVehiculoId())
                .orElseThrow(() -> new RuntimeException("Tipo de vehículo no encontrado"));

        RegistroVehiculo registro = new RegistroVehiculo();
        registro.setPlaca(dto.getPlaca());
        registro.setUbicacion(dto.getUbicacion());
        registro.setHoraEntrada(LocalDateTime.now());
        registro.setHoraSalida(null);
        registro.setTipoVehiculo(tipoVehiculo);

        registroVehiculoRepository.save(registro);
    }

    // Listar todos
    public List<RegistroVehiculo> listarRegistros() {
        return registroVehiculoRepository.findAll();
    }

    // Eliminar
    public void eliminarRegistro(Long id) {
        registroVehiculoRepository.deleteById(id);
    }

    // Registrar salida
    public void registrarSalida(Long id) {

        RegistroVehiculo registro = registroVehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));

        registro.setHoraSalida(LocalDateTime.now());

        registroVehiculoRepository.save(registro);
    }
}
