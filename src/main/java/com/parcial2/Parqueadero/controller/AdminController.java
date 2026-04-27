package com.parcial2.Parqueadero.controller;

import com.parcial2.Parqueadero.dto.RegistroVehiculoDTO;
import com.parcial2.Parqueadero.repository.TipoVehiculoRepository;
import com.parcial2.Parqueadero.services.AdministradorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdministradorService administradorService;
    private final TipoVehiculoRepository tipoVehiculoRepository;

    public AdminController(AdministradorService administradorService,
                           TipoVehiculoRepository tipoVehiculoRepository) {
        this.administradorService = administradorService;
        this.tipoVehiculoRepository = tipoVehiculoRepository;
    }

    // Panel principal
    @GetMapping("")
    public String panelAdmin() {
        return "admin";
    }

    // Mostrar formulario
    @GetMapping("/crear-registro")
    public String mostrarFormularioRegistro(Model model) {

        model.addAttribute("registroVehiculoDTO", new RegistroVehiculoDTO());
        model.addAttribute("tiposVehiculo", tipoVehiculoRepository.findAll());

        return "crear-registro";
    }

    // Guardar entrada
    @PostMapping("/crear-registro")
    public String crearRegistro(@ModelAttribute RegistroVehiculoDTO dto) {

        administradorService.registrarEntrada(dto);

        return "redirect:/admin/lista-registros";
    }

    // Lista
    @GetMapping("/lista-registros")
    public String listarRegistros(Model model) {

        model.addAttribute("registros",
                administradorService.listarRegistros());

        return "lista-registros";
    }

    // Eliminar
    @GetMapping("/eliminar/{id}")
    public String eliminarRegistro(@PathVariable Long id) {

        administradorService.eliminarRegistro(id);

        return "redirect:/admin/lista-registros";
    }

    // Registrar salida
    @GetMapping("/salida/{id}")
    public String registrarSalida(@PathVariable Long id) {

        administradorService.registrarSalida(id);

        return "redirect:/admin/lista-registros";
    }
}
