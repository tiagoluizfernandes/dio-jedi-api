package br.com.tts.dio.diojediapi.controller;

import br.com.tts.dio.diojediapi.model.Jedi;
import br.com.tts.dio.diojediapi.repository.JediRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Tiago Luiz Fernandes
 */

@Controller
public class JediController {
    private final JediRepository jediRepository;

    public JediController(JediRepository jediRepository) {this.jediRepository = jediRepository;}

    @GetMapping("/jedi")
    public ModelAndView jedi(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");

        List<Jedi> jediList = jediRepository.getAllJedi();

        modelAndView.addObject("allJedi", jediList);

        return modelAndView;

    }

    @GetMapping("/new-jedi")
    public String createJedi(Model model) {

        model.addAttribute("jedi", new Jedi());

        return "new-jedi";

    }

    @PostMapping("/jedi")
    public String createJedi(@Valid @ModelAttribute("jedi") Jedi jedi, BindingResult result, RedirectAttributes redirect){

        if(result.hasErrors()){
            return "new-jedi";
        }

        jediRepository.save(jedi);
        redirect.addFlashAttribute("message", "Jedi successfully created.");

        return "redirect:jedi";

    }

}
