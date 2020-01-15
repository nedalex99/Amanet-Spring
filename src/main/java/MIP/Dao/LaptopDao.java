package MIP.Dao;

import MIP.Entity.Laptop;

import java.util.List;
import java.util.Optional;

public interface LaptopDao {

    int insertLaptop(Laptop laptop);

    List<Laptop> selectAllLaptop();

    Optional<Laptop> selectLaptopById(int id);

    int deleteLaptopById(int id);

    int updateLaptopById(int id, Laptop laptop);

}
