package MIP.Controller;

import MIP.Entity.Bijuterie;
import MIP.Service.BijuterieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/bijuterie")
public class BijuterieController {

    private final BijuterieService bijuterieService;

    @Autowired
    public BijuterieController(BijuterieService bijuterieService) {
        this.bijuterieService = bijuterieService;
    }

    @PostMapping
    public void addBijuterie(@Valid @NotNull @RequestBody Bijuterie bijuterie){
        bijuterieService.addBijuterie(bijuterie);
    }

    @GetMapping
    public List<Bijuterie> getAllBijuterie(){
        return bijuterieService.getAllBijuterie();
    }

    @GetMapping(path = "{id}")
    public Bijuterie getBijuterieById(@PathVariable("id") int id){
        return bijuterieService.getBijuterieById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteBijuterieById(@PathVariable("id") int id){
        bijuterieService.deleteBijuterieById(id);
    }

    @PutMapping(path = "{id}")
    public void updateBijuterieById(@PathVariable("id") int id, @RequestBody Bijuterie bijuterie){
        bijuterieService.updateBijuterieById(id, bijuterie);
    }

}
