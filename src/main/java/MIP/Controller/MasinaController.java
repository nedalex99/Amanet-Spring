package MIP.Controller;

import MIP.Entity.Ceas;
import MIP.Entity.Masina;
import MIP.Service.MasinaService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/masina")
public class MasinaController {

    private final MasinaService masinaService;

    @Autowired
    public MasinaController(MasinaService masinaService) {
        this.masinaService = masinaService;
    }

    @PostMapping
    public void addMasina(@Valid @NotNull @RequestBody Masina masina){
        masinaService.addMasina(masina);
    }

    @GetMapping
    public List<Masina> getAllMasina(){
        return masinaService.getAllMasina();
    }

    @GetMapping(path = "{id}")
    public Masina getMasinaById(@PathVariable("id") int id){
        return masinaService.getMasinaById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteMasinaById(@PathVariable("id") int id){
        masinaService.deleteMasinaBy(id);
    }

    @PutMapping(path = "{id}")
    public void updateMasinaById(@PathVariable("id") int id, @RequestBody Masina masina){
        masinaService.updateMasinaById(id, masina);
    }
}
