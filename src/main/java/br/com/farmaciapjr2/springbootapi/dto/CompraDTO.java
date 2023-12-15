package br.com.farmaciapjr2.springbootapi.dto;

import br.com.farmaciapjr2.springbootapi.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompraDTO {
    private Long id;
    private Long idCliente;
    private Date dataCompra;
}
