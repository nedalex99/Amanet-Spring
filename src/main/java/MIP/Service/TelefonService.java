package MIP.Service;

import MIP.Dao.TelefonDao;
import MIP.Entity.Telefon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefonService {

    private final TelefonDao telefonDao;

    @Autowired
    public TelefonService(@Qualifier("telefon") TelefonDao telefonDao) {
        this.telefonDao = telefonDao;
    }

    public int addTelefon(Telefon telefon) {return telefonDao.insertTelefon(telefon);
    }

    public List<Telefon> getAllTelefon(){
        return telefonDao.selectAllTelefon();
    }

    public Optional<Telefon> getTelefonById(int id){
        return telefonDao.selectTelefonById(id);
    }

    public void deleteTelefonById(int id){
        telefonDao.deleteTelefonId(id);
    }

    public void updateTelefonById(int id, Telefon telefon) {
        telefonDao.updateTelefonById(id, telefon);
    }
}
