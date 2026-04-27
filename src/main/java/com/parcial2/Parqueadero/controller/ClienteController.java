package com.parcial2.Parqueadero.controller;

import com.parcial2.Parqueadero.services.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("")
    public String panelCliente() {
        return "cliente";
    }

    @GetMapping("/vehiculos")
    public String listarVehiculos(Model model) {

        model.addAttribute("registros",
                clienteService.listarVehiculos());

        return "vehiculos-cliente";
    }
}
