package MIP.Controller;

import MIP.Entity.Telefon;
import MIP.Service.TelefonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/telefon")
public class TelefonController {

    private final TelefonService telefonService;

    @Autowired
    public TelefonController(TelefonService telefonService) {
        this.telefonService = telefonService;
    }

    @PostMapping
    public void addTelefon(@Valid @NotNull @RequestBody Telefon telefon){
        telefonService.addTelefon(telefon);
    }

    @GetMapping
    public List<Telefon> getAllTelefon(){
        return telefonService.getAllTelefon();
    }

/*    @GetMapping
    public String getAllTelefon(Model model){
        List<Telefon> telefons = telefonService.getAllTelefon();

        model.addAttribute("telefon", telefons);

        return "telefon";
    }*/

    @GetMapping(path = "{id}")
    public Telefon getTelefonById(@PathVariable("id") int id){
        return telefonService.getTelefonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTelefonById(@PathVariable("id") int id){
        telefonService.deleteTelefonById(id);
    }

    @PutMapping(path = "{id}")
    public void updateTelefonById(@PathVariable("id") int id, @RequestBody Telefon telefon){
        telefonService.updateTelefonById(id, telefon);
    }


}
