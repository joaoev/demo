package com.estudo.npi.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@ResponseBody
@RequestMapping("/produtos")
public class ProdutosController {
    @GetMapping
    public String listarProdutos() {
        return "Lista de produtos";
    }
}
