package MIP.Dao;

import MIP.Entity.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Repository("laptop")
public class LaptopDaoImpl implements LaptopDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LaptopDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertLaptop(Laptop laptop) {
        String sql = "insert into laptop values(?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
                laptop.getLaptopId(),
                laptop.getModel(),
                laptop.getProcesor(),
                laptop.getPlacaVideo(),
                laptop.getStocare(),
                laptop.getRam(),
                laptop.getPrice());
    }

    @Override
    public List<Laptop> selectAllLaptop() {

        String sql = "select * from laptop";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int laptopId = resultSet.getInt("laptopid");
            String model = resultSet.getString("model");
            String procesor = resultSet.getString("procesor");
            String placaVideo = resultSet.getString("placavideo");
            int stocare = resultSet.getInt("stocare");
            int ram = resultSet.getInt("ram");
            int price = resultSet.getInt("price");

            return new Laptop(laptopId, model, procesor, placaVideo, stocare, ram, price);
        });
    }

    @Override
    public Optional<Laptop> selectLaptopById(int id) {

        final String sql = "select * from laptop where laptopid = ?";

        Laptop laptop = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    int laptopId = resultSet.getInt("laptopid");
                    String model = resultSet.getString("model");
                    String procesor = resultSet.getString("procesor");
                    String placaVideo = resultSet.getString("placavideo");
                    int stocare = resultSet.getInt("stocare");
                    int ram = resultSet.getInt("ram");
                    int price = resultSet.getInt("price");

                    return new Laptop(laptopId, model, procesor, placaVideo, stocare, ram, price);
                }
        );

        return Optional.ofNullable(laptop);
    }

    @Override
    public int deleteLaptopById(int id) {
        String sql = "delete from laptop where laptopid = ?";

        Object[] laptopId = new Object[]{id};

        return jdbcTemplate.update(sql, laptopId);
    }

    @Override
    public int updateLaptopById(int id, Laptop laptop) {
        String sql = "update laptop set price = ? where laptopid = ?";

        return jdbcTemplate.update(sql, laptop.getPrice(), laptop.getLaptopId());
    }
}
