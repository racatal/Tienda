package com.Tienda.controller;

import com.Tienda.domain.Articulo;
import com.Tienda.service.ArticuloService;
import com.Tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticuloController {
    
    @Autowired
    ArticuloService articuloService;
    
    @Autowired
    CategoriaService categoriaService;
    
    @GetMapping("/articulo/listado")
    public String inicio(Model model) {        
        var articulos = articuloService.getArticulos(false);
        model.addAttribute("Articulos", articulos);

        return "/articulos/listado";
    }
    
    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo, Model model){
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("Categorias", categorias);
        return "/articulo/modificar";
    }
    @PostMapping("/articulo/guardar")
    public String guardarArticulo (Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }
    
    @GetMapping ("/articulo/modificar/{id:Articulo}")
    public String modificarArticulo(Articulo articulo, Model model){
      articulo = articuloService.getArticulo(articulo);
      model.addAttribute("articulo", articulo);
      return "/articulo/modificar";
    }
    
    @GetMapping("/articulo/eliminar/{id:Articulo}")
    public String eliminarArticulo(Articulo articulo){
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";
    }
    
}