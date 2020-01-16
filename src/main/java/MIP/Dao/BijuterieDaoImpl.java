package MIP.Dao;

import MIP.Entity.Bijuterie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("bijuterie")
public class BijuterieDaoImpl implements BijuterieDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BijuterieDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertBijuterie(Bijuterie bijuterie) {
        String sql = "insert into bijuterie values(?, ?, ?, ?, ?);";

        return jdbcTemplate.update(sql,
                bijuterie.getBijuterieid(),
                bijuterie.getName(),
                bijuterie.getMaterial(),
                bijuterie.getGramaj(),
                bijuterie.getPrice());
    }

    @Override
    public List<Bijuterie> selectAllBijuterie() {
        String sql = "select * from bijuterie;";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("bijuterieid");
            String name = resultSet.getString("name");
            String material = resultSet.getString("material");
            int gramaj = resultSet.getInt("gramaj");
            int price = resultSet.getInt("price");

            return new Bijuterie(id, name, material, gramaj, price);
        });
    }

    @Override
    public Optional<Bijuterie> selectBijuterieById(int id) {
        final String sql = "select * from bijuterie where bijuterieid = ?";

        Bijuterie bijuterie = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    int bijuterieId = resultSet.getInt("bijuterieid");
                    String name = resultSet.getString("name");
                    String material = resultSet.getString("material");
                    int gramaj = resultSet.getInt("gramaj");
                    int price = resultSet.getInt("price");

                    return new Bijuterie(bijuterieId, name, material, gramaj, price);
                });

        return Optional.ofNullable(bijuterie);

    }

    @Override
    public int deleteBijuterieById(int id) {
        String sql = "delete from bijuterie where bijuterieid = ?";

        Object[] bijuterieId = new Object[]{id};

        return jdbcTemplate.update(sql, bijuterieId);
    }

    @Override
    public int updateBijuterieById(int id, Bijuterie bijuterie) {
        final String sql = "update bijuterie set price = ? where bijuterieid = ?;";

        return jdbcTemplate.update(sql, bijuterie.getPrice(), bijuterie.getBijuterieid());
    }
}
