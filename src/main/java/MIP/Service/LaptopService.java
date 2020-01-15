package MIP.Service;

import MIP.Dao.LaptopDao;
import MIP.Entity.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {

    private final LaptopDao laptopDao;

    @Autowired
    public LaptopService(@Qualifier("laptop") LaptopDao laptopDao) {
        this.laptopDao = laptopDao;
    }

    public void addLaptop(Laptop laptop) {
        laptopDao.insertLaptop(laptop);
    }

    public List<Laptop> getAllLaptop() {
        return laptopDao.selectAllLaptop();
    }

    public Optional<Laptop> getLaptopById(int id) {
        return laptopDao.selectLaptopById(id);
    }

    public void deleteLaptopById(int id) {
        laptopDao.deleteLaptopById(id);
    }

    public void updateLaptopById(int id, Laptop laptop) {
        laptopDao.updateLaptopById(id, laptop);
    }
}
