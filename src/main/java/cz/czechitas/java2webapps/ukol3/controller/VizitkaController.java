package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller()
@RequestMapping()
public class VizitkaController {
  private final List<Vizitka> seznamVizitek = List.of(
          new Vizitka("Anna Šedivá", "ABC s.r.o.", "Pivovarská 1126", "Králíky 561 69", "anna.sediva@email.cz", "777 888 999", "www.anna.cz" ),
          new Vizitka("Jan Rychlý", "CDE s.r.o.", "Valdštejnova 359", "Králíky 561 69", "jan.rychly@email.cz", "777 222 111", "www.jan.cz" ),
          new Vizitka("Martin Mlsný", "FGH s.r.o.", "Dolní 241", "Králíky 561 69", "martin.mlsny@email.cz", "777 333 444", "www.martin.cz" )
          );

  @GetMapping("/")

  public ModelAndView seznam() {
    ModelAndView modelAndView = new ModelAndView("/seznam");
    modelAndView.addObject("vizitky", seznamVizitek);
    return modelAndView;
  }


  @GetMapping("/detail/{id}")
  public ModelAndView detail(@PathVariable int id) {
    ModelAndView modelAndView = new ModelAndView("/detail");
    modelAndView.addObject("vizitka", seznamVizitek.get(id));
    return modelAndView;
  }
}
