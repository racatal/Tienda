package com.Tienda.controller;

import com.Tienda.dao.ClienteDao;
import com.Tienda.domain.Cliente;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Catalina Vaverde
 */
@Slf4j
@Controller
public class IndexController {
    
    @Autowired
    ClienteDao clienteDao;

    @GetMapping("/")
    public String inicio(Model model) {
 //       log.info("Ahora utilizando MVC");
//        String mensaje = "Estamos en semana 4, saludos!";
  //      model.addAttribute("MensajeSaludo", mensaje);

    //    Cliente cliente = new Cliente("Catalina", "Valverde Ramirez", "catvalra@gmail.com", "89723567");
      //  Cliente cliente2 = new Cliente("Pablo", "Valverde Muñoz", "jmpl@gmail.com", "67092341");
        //model.addAttribute("cliente", cliente);
        
        //var clientes = Arrays.asList(cliente, cliente2);
       // model.addAttribute("clientes", "clientes");
       
       var clientes = clienteDao.findAll();
       model.addAttribute("Clientes", clientes);
        
        return "index";
    }

}
