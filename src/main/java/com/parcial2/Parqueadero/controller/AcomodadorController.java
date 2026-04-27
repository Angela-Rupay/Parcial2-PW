package com.parcial2.Parqueadero.controller;

import com.parcial2.Parqueadero.services.AcomodadorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/acomodador")
public class AcomodadorController {

    private final AcomodadorService acomodadorService;

    public AcomodadorController(AcomodadorService acomodadorService) {
        this.acomodadorService = acomodadorService;
    }

    // Panel principal
    @GetMapping("")
    public String panelAcomodador() {
        return "acomodador";
    }

    // Ver vehículos
    @GetMapping("/vehiculos")
    public String listarVehiculos(Model model) {

        model.addAttribute("registros",
                acomodadorService.listarVehiculos());

        return "vehiculos-acomodador";
    }

    // Actualizar ubicación
    @PostMapping("/actualizar-ubicacion/{id}")
    public String actualizarUbicacion(@PathVariable Long id,
                                      @RequestParam String ubicacion) {

        acomodadorService.actualizarUbicacion(id, ubicacion);

        return "redirect:/acomodador/vehiculos";
    }
}