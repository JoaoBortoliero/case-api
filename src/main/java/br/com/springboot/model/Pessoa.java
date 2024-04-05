package br.com.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor 
@Entity 
@Table 
@Builder 
@Data 
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;
    private String cnpjCpf;
    private String nome;

}
