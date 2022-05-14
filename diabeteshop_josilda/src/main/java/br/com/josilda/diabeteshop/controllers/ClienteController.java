package br.com.josilda.diabeteshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.josilda.diabeteshop.model.Cliente;
import br.com.josilda.diabeteshop.repositories.ClienteRepository;

@Controller
@RequestMapping("/")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepo;
    
    @GetMapping
    public String inicio() {

        return "index.html";
    }
    @GetMapping("/listarClientes")

    public ModelAndView listarClientes() {
        List<Cliente> lista = clienteRepo.findAll();

        ModelAndView modelAndView= new ModelAndView("listarClientes");

        modelAndView.addObject("clientes" , lista);

        return modelAndView;
    }
    @GetMapping("/adicionarCliente")
    public ModelAndView formAdicionarCliente() {
        ModelAndView modelAndView = new ModelAndView("adicionarCliente");
        modelAndView.addObject(new Cliente());
        return modelAndView;
    }

    @PostMapping("/adicionarCliente")
    public String adicionarCliente(Cliente p) {
        this.clienteRepo.save(p);
        return "redirect:/listarClientes";
    }

    @GetMapping("/editar/{codigo}")
    public ModelAndView formEditarCliente(@PathVariable("codigo") long codigo) {
        Cliente cliente = clienteRepo.findById(codigo)
            .orElseThrow(() -> new IllegalArgumentException("ID inválido:" + codigo));
        ModelAndView modelAndView = new ModelAndView("editarCliente");
        modelAndView.addObject(cliente);
        return modelAndView;
    }
    @PostMapping("/editar/{codigo}")
    public ModelAndView editarCliente(@PathVariable("codigo") long codigo, Cliente cliente){
        this.clienteRepo.save(cliente);
        return new ModelAndView("redirect:/listarClientes");
    }

    @GetMapping("/remover/{codigo}")
    public ModelAndView removerCliente(@PathVariable("codigo") long codigo) {
        Cliente aRemover = clienteRepo.findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido:" + codigo));
        clienteRepo.delete(aRemover);
        return new ModelAndView("redirect:/listarClientes");
    }

    
}
