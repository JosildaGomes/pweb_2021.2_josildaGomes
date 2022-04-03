package br.com.josilda.cadpessoas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.josilda.cadpessoas.model.Pessoa;
import br.com.josilda.cadpessoas.repositories.PessoaRepository;

@Controller
@RequestMapping("/")

public class PessoaController {
    @Autowired
    PessoaRepository pessoaRepo;

    PessoaController( PessoaRepository pessoaRepo) {
        this.pessoaRepo = pessoaRepo;
    }

    @GetMapping

    public String inicio() {

        return "index.html";
    }

    @GetMapping("/listarPessoas")

    public ModelAndView listarPessoas() {
        List<Pessoa> lista = pessoaRepo.findAll();

        ModelAndView modelAndView= new ModelAndView("listarPessoas");

        modelAndView.addObject("pessoas" , lista);

        return modelAndView;
    }

    @GetMapping("/adicionarPessoa")
    public ModelAndView formAdicionarPessoa() {
        ModelAndView modelAndView = new ModelAndView("adicionarPessoa");
        modelAndView.addObject(new Pessoa());
        return modelAndView;
    }

    @PostMapping("/adicionarPessoa")
    public String adicionarPessoa(Pessoa p) {
        this.pessoaRepo.save(p);
        return "redirect:/listarPessoas";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView formEditarPessoa(@PathVariable("id") long id) {
        Pessoa pessoa = pessoaRepo.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        ModelAndView modelAndView = new ModelAndView("editarPessoa");
        modelAndView.addObject(pessoa);
        return modelAndView;
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editarPessoa(@PathVariable("id") long id, Pessoa pessoa){
        this.pessoaRepo.save(pessoa);
        return new ModelAndView("redirect:/listarPessoas");
    }

    @GetMapping("/remover/{id}")
    public ModelAndView removerPessoa(@PathVariable("id") long id) {
        Pessoa aRemover = pessoaRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        pessoaRepo.delete(aRemover);
        return new ModelAndView("redirect:/listarPessoas");
    }
}
