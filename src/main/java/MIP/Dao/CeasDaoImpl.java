package MIP.Dao;

import MIP.Entity.Ceas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("ceas")
public class CeasDaoImpl implements CeasDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CeasDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertCeas(Ceas ceas) {
        String sql = "insert into ceas values (?, ?, ?, ?)";

        int id = ceas.getCeasId();
        String model = ceas.getModel();
        int anFabricatie = ceas.getAnFabricatie();
        int price = ceas.getPrice();

        return jdbcTemplate.update(sql, id, model, anFabricatie, price);
    }

    @Override
    public List<Ceas> selectAllCeas() {

        String sql = "select * from ceas;";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("ceasid");
            String model = resultSet.getString("model");
            int anFabricatie = resultSet.getInt("anfabricatie");
            int price = resultSet.getInt("price");

            return new Ceas(id, model, anFabricatie, price);
        });

    }

    @Override
    public Optional<Ceas> selectCeasById(int id) {
        final String sql = "select * from ceas where ceasid = ?";

        Ceas ceas = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    int cId = resultSet.getInt("ceasid");
                    String marca = resultSet.getString("model");
                    int anFabricatie = resultSet.getInt("anfabricatie");
                    int price = resultSet.getInt("price");

                    return new Ceas(cId, marca, anFabricatie, price);
                });

        return Optional.ofNullable(ceas);
    }

    @Override
    public int deleteCeasById(int id) {
        String sql = "delete from ceas where ceasid = ?";

        Object[] ceasId = new Object[]{id};

        return jdbcTemplate.update(sql, ceasId);
    }

    @Override
    public int updateCeasById(int id, Ceas ceas) {
        final String sql = "update ceas set price = ? where ceasid = ?;";

        return jdbcTemplate.update(sql, ceas.getPrice(), ceas.getCeasId());
    }
}
