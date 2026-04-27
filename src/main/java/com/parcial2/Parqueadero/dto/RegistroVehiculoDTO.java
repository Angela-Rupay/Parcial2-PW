package com.parcial2.Parqueadero.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistroVehiculoDTO {

    private String placa;
    private String ubicacion;
    private Long tipoVehiculoId;
}