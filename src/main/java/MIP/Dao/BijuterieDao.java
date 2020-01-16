package MIP.Dao;

import MIP.Entity.Bijuterie;

import java.util.List;
import java.util.Optional;

public interface BijuterieDao {

    int insertBijuterie(Bijuterie bijuterie);

    List<Bijuterie> selectAllBijuterie();

    Optional<Bijuterie> selectBijuterieById(int id);

    int deleteBijuterieById(int id);

    int updateBijuterieById(int id, Bijuterie bijuterie);

}
