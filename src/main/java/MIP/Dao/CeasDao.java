package MIP.Dao;

import MIP.Entity.Ceas;

import java.util.List;
import java.util.Optional;

public interface CeasDao {

    int insertCeas(Ceas ceas);

    List<Ceas> selectAllCeas();

    Optional<Ceas> selectCeasById(int id);

    int deleteCeasById(int id);

    int updateCeasById(int id, Ceas ceas);
}
