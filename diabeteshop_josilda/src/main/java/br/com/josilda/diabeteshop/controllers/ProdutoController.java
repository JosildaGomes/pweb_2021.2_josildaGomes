package br.com.josilda.diabeteshop.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.josilda.diabeteshop.model.Produto;
import br.com.josilda.diabeteshop.repositories.ProdutoRepository;

@Controller
public class ProdutoController {
    @Autowired
    ProdutoRepository produtoRepo;
    @GetMapping("/listarProdutos")

    public ModelAndView listarProdutos() {
        List<Produto> lista = produtoRepo.findAll();

        ModelAndView modelAndView= new ModelAndView("listarProdutos");

        modelAndView.addObject("produtos" , lista);

        return modelAndView;
    }
    @GetMapping("/adicionarProdutos")
    public ModelAndView formAdicionarProdutos() {
        ModelAndView modelAndView = new ModelAndView("adicionarProdutos");
        modelAndView.addObject(new Produto());
        return modelAndView;
    }

    @PostMapping("/adicionarProdutos")
    public String adicionarProdutos(Produto p) {
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        p.setDatacadastro(data);
        p.setVolume(p.getAltura()*p.getLargura()*p.getProfundidade());
        this.produtoRepo.save(p);
        return "redirect:/listarProdutos";
    }

    @GetMapping("/edita/{codigo}")
    public ModelAndView formEditarProduto(@PathVariable("codigo") Long codigo) {
        Produto produto = produtoRepo.findById(codigo)
            .orElseThrow(() -> new IllegalArgumentException("ID inválido:" + codigo));
        ModelAndView modelAndView = new ModelAndView("editarProduto");
        modelAndView.addObject(produto);
        return modelAndView;
    }
    @PostMapping("/edita/{codigo}")
    public ModelAndView editarProduto(@PathVariable("codigo") Long codigo, Produto produto){
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        produto.setDatacadastro(data);
        produto.setVolume(produto.getAltura()*produto.getLargura()*produto.getProfundidade());
        this.produtoRepo.save(produto);
        return new ModelAndView("redirect:/listarProdutos");
    }

    
    @GetMapping("/remove/{codigo}")
    public ModelAndView removerProduto(@PathVariable("codigo") Long codigo) {
        Produto aRemover = produtoRepo.findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido:" + codigo));
        produtoRepo.delete(aRemover);
        return new ModelAndView("redirect:/listarProdutos");
    }
}
