package MIP.Controller;

import MIP.Entity.Laptop;
import MIP.Service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequestMapping("/laptop")
public class LaptopController {

    private final LaptopService laptopService;

    @Autowired
    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @PostMapping
    public void addLaptop(@Valid @NotNull @RequestBody Laptop laptop){
        laptopService.addLaptop(laptop);
    }

    /*@GetMapping
    public List<Laptop> getAllLaptop(){
        return laptopService.getAllLaptop();
    }*/

   @GetMapping
    public String getAllLaptop(Model model){
        List<Laptop> laptops = laptopService.getAllLaptop();

        model.addAttribute("laptop", laptops);

        return "laptop";
    }

    @GetMapping(path = "{id}")
    public Laptop getLaptopById(@PathVariable("id") int id){
        return laptopService.getLaptopById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteLaptopById(@PathVariable("id") int id){
        laptopService.deleteLaptopById(id);
    }

    @PutMapping(path = "{id}")
    public void updateLaptopById(@PathVariable("id") int id, @RequestBody Laptop laptop){
        laptopService.updateLaptopById(id, laptop);
    }

}
