package MIP.Dao;

import MIP.Entity.Telefon;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("telefon")
public class TelefonDaoImpl implements TelefonDao {

    private final JdbcTemplate jdbcTemplate;

    public TelefonDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertTelefon(Telefon telefon) {
        String sql = "insert into telefon values(?, ?, ?, ?, ?);";

        return jdbcTemplate.update(sql, telefon.getTelefonId(), telefon.getMarca(), telefon.getModel(), telefon.getStocare(), telefon.getPrice());
    }

    @Override
    public List<Telefon> selectAllTelefon() {
        String sql = "select * from telefon;";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("telefonid");
            String marca = resultSet.getString("marca");
            String model = resultSet.getString("model");
            int stocare = resultSet.getInt("stocare");
            int price = resultSet.getInt("price");

            return new Telefon(id, marca, model, stocare, price);
        });
    }

    @Override
    public Optional<Telefon> selectTelefonById(int id) {
        final String sql = "select * from telefon where telefonid = ?";

        Telefon telefon = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    int telefonId = resultSet.getInt("telefonid");
                    String marca = resultSet.getString("marca");
                    String model = resultSet.getString("model");
                    int stocare = resultSet.getInt("stocare");
                    int price = resultSet.getInt("price");

                    return new Telefon(telefonId, marca, model, stocare, price);
                });

        return Optional.ofNullable(telefon);
    }

    @Override
    public int deleteTelefonId(int id) {
        String sql = "delete from telefon where telefonid = ?";

        Object[] telefonId = new Object[]{id};

        return jdbcTemplate.update(sql, telefonId);
    }

    @Override
    public int updateTelefonById(int id, Telefon telefon) {
        final String sql = "update telefon set price = ? where telefonid = ?;";

        return jdbcTemplate.update(sql, telefon.getPrice(), telefon.getTelefonId());
    }
}
