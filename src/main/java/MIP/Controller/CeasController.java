package MIP.Controller;

import MIP.Entity.Ceas;
import MIP.Service.CeasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/ceas")
public class CeasController {

    private final CeasService ceasService;

    @Autowired
    public CeasController(CeasService ceasService) {
        this.ceasService = ceasService;
    }

    @PostMapping
    public void addCeas(@Valid @NotNull @RequestBody Ceas ceas){
        ceasService.addCeas(ceas);
    }

    @GetMapping
    public List<Ceas> getAllCeas(){
        return ceasService.getAllCeas();
    }

    /*@GetMapping
    public String getAllCeas(Model model){
        List<Ceas> ceasuri = ceasService.getAllCeas();

        model.addAttribute("ceas", ceasuri);

        return "ceas";
    }*/

    @GetMapping(path = "{id}")
    public Ceas getCeasById(@PathVariable("id") int id){
        return ceasService.getCeasById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCeasById(@PathVariable("id") int id){
        ceasService.deleteCeasById(id);
    }

    @PutMapping(path = "{id}")
    public void updateCeasById(@PathVariable("id") int id, @RequestBody Ceas ceas){
        ceasService.updateCeasById(id, ceas);
    }
}
