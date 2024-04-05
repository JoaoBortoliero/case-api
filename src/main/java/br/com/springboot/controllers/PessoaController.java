package br.com.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.model.Pessoa;
import br.com.springboot.repository.PessoaRepository;

@RestController 
@CrossOrigin("*")
@RequestMapping("/form")  
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping("/cadastrar")
    public Pessoa toAdd(@RequestBody Pessoa pessoa) {
        var p = pessoaRepository.findBycnpjCpf(pessoa.getCnpjCpf()).orElse(null); 
        if (p != null) {
            p.setNome(pessoa.getNome());
            return this.pessoaRepository.save(p);
        }
        return this.pessoaRepository.save(pessoa); 
    }
    
    @GetMapping("/listar")
    public List<Pessoa> toList() {
        return this.pessoaRepository.findAll(); 
    }

    @GetMapping("/complete/{cnpjCpf}")
    public String autoComplete(@PathVariable("cnpjCpf") String cnpjCpf) {
        var pessoa = pessoaRepository.findBycnpjCpf(cnpjCpf).orElse(null);
        if (pessoa != null) {
            return pessoa.getNome(); 
        }
        return null; 
    }
    
    @GetMapping("/{cnpjCpf}")
    public Pessoa findById(@PathVariable("id") Long id) {
        return this.pessoaRepository.findById(id).orElse(null); 
    }

    @DeleteMapping("/{cnpjCpf}") 
    public void delete(@PathVariable("cnpjCpf") String cnpjCpf) {
        var pessoa = pessoaRepository.findBycnpjCpf(cnpjCpf);
        this.pessoaRepository.deleteById(pessoa.get().getId()); 
    }

}
