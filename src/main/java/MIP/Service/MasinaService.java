package MIP.Service;

import MIP.Dao.MasinaDao;
import MIP.Entity.Masina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MasinaService {

    private final MasinaDao masinaDao;

    @Autowired
    public MasinaService(@Qualifier("masina") MasinaDao masinaDao) {
        this.masinaDao = masinaDao;
    }

    public void addMasina(Masina masina) {
        masinaDao.insertMasina(masina);
    }

    public List<Masina> getAllMasina() {
        return masinaDao.selectAllMasina();
    }

    public Optional<Masina> getMasinaById(int id) {
        return masinaDao.selectMasinaById(id);
    }

    public void deleteMasinaBy(int id) {
        masinaDao.deleteMasinaById(id);
    }

    public void updateMasinaById(int id, Masina masina) {
        masinaDao.updateMasinaById(id, masina);
    }
}
