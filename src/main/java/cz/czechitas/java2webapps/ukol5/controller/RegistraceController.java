package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


/**
 * Kontroler obsluhující registraci účastníků dětského tábora.
 */
@Controller

public class RegistraceController {
  @GetMapping("")
  public ModelAndView index(){
    ModelAndView modelAndView = new ModelAndView("/index");
    modelAndView.addObject("form", new RegistraceForm());
    return modelAndView;
  }


  @PostMapping("")

  public Object form(@ModelAttribute("form") @Valid RegistraceForm form, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "/";
    }
    if (form.getVek() <9 || form.getVek()>15) {
      bindingResult.rejectValue("vek", "", "Deti musi mit vek od 9 do 15 let");
      return "/";
    }
    if (form.getSporty().size()<3){
      bindingResult.rejectValue("sport1", "", "Vyberte nejmene 2 sporty");
      return "/";
    }
    return new ModelAndView("/rezervovano")
            .addObject("Jmeno", form.getJmeno() + ""+ form.getPrijmeni())
            .addObject("turnus", form.getTurnus());
  }


  //V metodě controlleru zkontroluj následující podmínky. Pokud nebudou splněné, zařiď,
  // by se u příslušného políčka vypsala odpovídající chybová zpráva.
  //věk mezi 9 a 15 roky (včetně) – připomínám kód pro výpočet věku:
  //Period period = birthDate.until(LocalDate.now());
  //int vek = period.getYears();
  //vybrané alespoň dva sporty – EnumSet má metodu size(), která vrací počet prvků v množině
}
