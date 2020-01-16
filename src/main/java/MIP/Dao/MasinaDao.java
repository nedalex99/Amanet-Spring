package MIP.Dao;

import MIP.Entity.Masina;

import java.util.List;
import java.util.Optional;

public interface MasinaDao {

    int insertMasina(Masina masina);

    List<Masina> selectAllMasina();

    Optional<Masina> selectMasinaById(int id);

    int deleteMasinaById(int id);

    int updateMasinaById(int id, Masina masina);

}
