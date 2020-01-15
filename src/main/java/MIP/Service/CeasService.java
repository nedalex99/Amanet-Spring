package MIP.Service;

import MIP.Dao.CeasDao;
import MIP.Entity.Ceas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CeasService {

    private final CeasDao ceasDao;

    @Autowired
    public CeasService(@Qualifier("ceas") CeasDao ceasDao) {
        this.ceasDao = ceasDao;
    }

    public void addCeas(Ceas ceas) {
        ceasDao.insertCeas(ceas);
    }

    public List<Ceas> getAllCeas() {
        return ceasDao.selectAllCeas();
    }

    public Optional<Ceas> getCeasById(int id) {
        return ceasDao.selectCeasById(id);
    }

    public void deleteCeasById(int id) {
        ceasDao.deleteCeasById(id);
    }

    public void updateCeasById(int id, Ceas ceas) {
        ceasDao.updateCeasById(id, ceas);
    }
}
