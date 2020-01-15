package MIP.Dao;

import MIP.Entity.Telefon;

import java.util.List;
import java.util.Optional;

public interface TelefonDao {

    int insertTelefon(Telefon telefon);

    List<Telefon> selectAllTelefon();

    Optional<Telefon> selectTelefonById(int id);

    int deleteTelefonId(int id);

    int updateTelefonById(int id, Telefon amanet);

}
