package MIP.Dao;

import MIP.Entity.Masina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("masina")
public class MasinaDaoImpl implements MasinaDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MasinaDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertMasina(Masina masina) {
        String sql = "insert into masina values (?, ?, ?, ?, ?)";

        int id = masina.getMasinaid();
        String marca = masina.getMarca();
        int capacitateMotor = masina.getCapacitateMotor();
        int anFabricatie = masina.getAnFabricatie();
        int price = masina.getPrice();

        return jdbcTemplate.update(sql, id, marca, marca, capacitateMotor, anFabricatie, price);
    }

    @Override
    public List<Masina> selectAllMasina() {
        String sql = "select * from masina;";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("masinaid");
            String marca = resultSet.getString("marca");
            int capacitateMotor = resultSet.getInt("capacitatemotor");
            int anFabricatie = resultSet.getInt("anfabricatie");
            int price = resultSet.getInt("price");

            return new Masina(id, marca, capacitateMotor, anFabricatie, price);
        });
    }

    @Override
    public Optional<Masina> selectMasinaById(int id) {
        final String sql = "select * from masina where masinaid = ?";

        Masina masina = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    int masinaid = resultSet.getInt("masinaid");
                    String marca = resultSet.getString("marca");
                    int capacitateMotor = resultSet.getInt("capacitatemotor");
                    int anFabricatie = resultSet.getInt("anfabricatie");
                    int price = resultSet.getInt("price");

                    return new Masina(masinaid, marca, capacitateMotor, anFabricatie, price);
                });

        return Optional.ofNullable(masina);
    }

    @Override
    public int deleteMasinaById(int id) {
        String sql = "delete from masina where masinaid = ?";

        Object[] masinaid = new Object[]{id};

        return jdbcTemplate.update(sql, masinaid);
    }

    @Override
    public int updateMasinaById(int id, Masina masina) {
        final String sql = "update masina set price = ? where masinaid = ?;";

        return jdbcTemplate.update(sql, masina.getPrice(), masina.getMasinaid());
    }
}
