package usj.edu.br.moto;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class MotoController {
    
    @Autowired
    MotoRepository motoRepository;

    @GetMapping(value="/")
    
    public ModelAndView getListar() {
        List<Moto> lista = motoRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }

    @GetMapping(value="/mostrar/{id}")

    public ModelAndView getMostrar(@PathVariable Long id) {
        Moto moto = motoRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("mostrar");
        modelAndView.addObject("moto", moto);
        return modelAndView;
    }

    @GetMapping(value="/cadastrar")
    public ModelAndView getCadastrar() {
        Moto moto = new Moto();
        ModelAndView modelAndView = new ModelAndView("cadastrar");
        modelAndView.addObject("moto", moto);
        return modelAndView;
    }
    
    @PostMapping(value="cadastrar")
    public ModelAndView postCadastrar(Moto moto) {
        Moto motoSalva = motoRepository.save(moto);
        ModelAndView modelAndView = new ModelAndView("/cadastrar");
        modelAndView.addObject("moto", motoSalva);
        return modelAndView;
    }
    
    @GetMapping(value="/deletar/{id}")
    public String getDeletar(@PathVariable Long id) {
        motoRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping(value="/editar/{id}")
    public ModelAndView getEditar(@PathVariable Long id) {
        Moto moto = motoRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("cadastrar");
        modelAndView.addObject("moto", moto);
        return modelAndView;
    }
    
    
} 