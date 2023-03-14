package com.Tienda.controller;

import com.Tienda.dao.ClienteDao;
import com.Tienda.domain.Cliente;
import com.Tienda.service.ClienteService;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Catalina Vaverde
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora utilizando MVC");
//        String mensaje = "Estamos en semana 4, saludos!";
        //      model.addAttribute("MensajeSaludo", mensaje);

        //    Cliente cliente = new Cliente("Catalina", "Valverde Ramirez", "catvalra@gmail.com", "89723567");
        //  Cliente cliente2 = new Cliente("Pablo", "Valverde Muñoz", "jmpl@gmail.com", "67092341");
        //model.addAttribute("cliente", cliente);
        //var clientes = Arrays.asList(cliente, cliente2);
        // model.addAttribute("clientes", "clientes");
        var clientes = clienteService.getClientes();
        model.addAttribute("Clientes", clientes);

        return "index";
    }
    
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        return "modificarCliente";
    }
    @PostMapping("/guardarcliente")
    public String guardarCliente (Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/";
    }
    
    @GetMapping ("/modificarCliente/{id:Cliente}")
    public String modificarCliente(Cliente cliente, Model model){
      cliente = clienteService.getCliente(cliente);
      model.addAttribute("cliente", cliente);
      return "modificarCliente";
    }
    
    @GetMapping("/eliminarCliente/{id:Cliente}")
    public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/";
    }

}
