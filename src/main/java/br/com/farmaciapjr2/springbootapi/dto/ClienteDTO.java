package br.com.farmaciapjr2.springbootapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDTO {

    private Long id;

    private String nome;

    private String endereco;

    private String telefone;

    private String codigoPostal;

    private String localidade;

    private String numeroContribuinte;
}
