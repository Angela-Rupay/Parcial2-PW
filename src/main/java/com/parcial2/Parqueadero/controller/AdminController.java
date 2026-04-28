package com.parcial2.Parqueadero.controller;

import com.parcial2.Parqueadero.dto.RegistroVehiculoDTO;
import com.parcial2.Parqueadero.model.RegistroVehiculo;
import com.parcial2.Parqueadero.repository.TipoVehiculoRepository;
import com.parcial2.Parqueadero.services.AdministradorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@Tag(name = "Administrador", description = "Gestión administrativa del parqueadero")
public class AdminController {

    private final AdministradorService administradorService;
    private final TipoVehiculoRepository tipoVehiculoRepository;

    public AdminController(AdministradorService administradorService,
                           TipoVehiculoRepository tipoVehiculoRepository) {
        this.administradorService = administradorService;
        this.tipoVehiculoRepository = tipoVehiculoRepository;
    }

    // =========================
    // FRONTEND
    // =========================

    @GetMapping("")
    public String panelAdmin() {
        return "admin";
    }

    @GetMapping("/crear-registro")
    public String mostrarFormularioRegistro(Model model) {

        model.addAttribute("registroVehiculoDTO", new RegistroVehiculoDTO());
        model.addAttribute("tiposVehiculo", tipoVehiculoRepository.findAll());

        return "crear-registro";
    }

    @PostMapping("/crear-registro")
    public String crearRegistro(@ModelAttribute RegistroVehiculoDTO dto) {

        administradorService.registrarEntrada(dto);

        return "redirect:/admin/lista-registros";
    }

    @GetMapping("/lista-registros")
    public String listarRegistros(Model model) {

        model.addAttribute("registros",
                administradorService.listarRegistros());

        return "lista-registros";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarRegistro(@PathVariable Long id) {

        administradorService.eliminarRegistro(id);

        return "redirect:/admin/lista-registros";
    }

    @GetMapping("/salida/{id}")
    public String registrarSalida(@PathVariable Long id) {

        administradorService.registrarSalida(id);

        return "redirect:/admin/lista-registros";
    }

    // =========================
    // SWAGGER / API REST
    // =========================

    @Operation(summary = "Consultar todos los registros de vehículos")
    @ResponseBody
    @GetMapping("/api/registros")
    public List<RegistroVehiculo> obtenerRegistrosAPI() {
        return administradorService.listarRegistros();
    }

    @Operation(summary = "Registrar entrada de un vehículo")
    @ResponseBody
    @PostMapping("/api/registros")
    public String crearRegistroAPI(@RequestBody RegistroVehiculoDTO dto) {

        administradorService.registrarEntrada(dto);

        return "Vehículo registrado correctamente";
    }

    @Operation(summary = "Registrar salida de un vehículo")
    @ResponseBody
    @PutMapping("/api/registros/salida/{id}")
    public String registrarSalidaAPI(@PathVariable Long id) {

        administradorService.registrarSalida(id);

        return "Salida registrada correctamente";
    }

    @Operation(summary = "Eliminar registro de vehículo")
    @ResponseBody
    @DeleteMapping("/api/registros/{id}")
    public String eliminarRegistroAPI(@PathVariable Long id) {

        administradorService.eliminarRegistro(id);

        return "Registro eliminado correctamente";
    }
}