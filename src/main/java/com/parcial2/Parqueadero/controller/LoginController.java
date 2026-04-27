package com.parcial2.Parqueadero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String mostrarLogin() {
        return "index";
    }

    @GetMapping("/admin")
    public String vistaAdmin() {
        return "admin";
    }

    @GetMapping("/acomodador")
    public String vistaAcomodador() {
        return "acomodador";
    }

    @GetMapping("/cliente")
    public String vistaCliente() {
        return "cliente";
    }
}
