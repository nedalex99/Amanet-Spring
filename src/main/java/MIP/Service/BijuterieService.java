package MIP.Service;

import MIP.Dao.BijuterieDao;
import MIP.Entity.Bijuterie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BijuterieService {

    private final BijuterieDao bijuterieDao;

    @Autowired
    public BijuterieService(@Qualifier("bijuterie") BijuterieDao bijuterieDao) {
        this.bijuterieDao = bijuterieDao;
    }

    public void addBijuterie(Bijuterie bijuterie) {
        bijuterieDao.insertBijuterie(bijuterie);
    }

    public List<Bijuterie> getAllBijuterie() {
        return bijuterieDao.selectAllBijuterie();
    }

    public Optional<Bijuterie> getBijuterieById(int id) {
        return bijuterieDao.selectBijuterieById(id);
    }

    public void deleteBijuterieById(int id) {
        bijuterieDao.deleteBijuterieById(id);
    }

    public void updateBijuterieById(int id, Bijuterie bijuterie) {
        bijuterieDao.updateBijuterieById(id, bijuterie);
    }
}
