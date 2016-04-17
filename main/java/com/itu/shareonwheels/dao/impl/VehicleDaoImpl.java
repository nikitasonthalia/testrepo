package com.itu.shareonwheels.dao.impl;

import com.itu.shareonwheels.dao.VehicleDao;
import com.itu.shareonwheels.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by nikitasonthalia on 10/8/15.
 */
@Repository
public class VehicleDaoImpl extends NamedParameterJdbcDaoSupport implements VehicleDao {

    private static final String VEHICLE_CREATION_QUERY = "insert into vehicle (car_model_name, capacity, licence_plate_number,owner_id) " +
            "values (:model, :capacity, :licencePlateNumber,:ownerId)";

    private static final String VEHICLE_UPDATION_QUERY = "update vehicle SET car_model_name = :model,capacity = :capacity,licence_plate_number = :licencePlateNumber WHERE vehicle_id = :vehicleId";

    private static final String VEHICLE_DELETION_QUERY = "DELETE FROM vehicle WHERE vehicle_id = :vehicleId";

    @Autowired
    public VehicleDaoImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public Long create(Vehicle vehicle) {
        System.out.println("Entering vehicle dao"+vehicle.getOwnerId());
        Long driverId = vehicle.getOwnerId();
        String VERIFY_USER = "select count(*) from vehicle WHERE owner_id=:driverId";

        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("driverId",driverId);
        int rowCount = getNamedParameterJdbcTemplate().queryForObject(VERIFY_USER, namedParameters, Integer.class);

        if(rowCount == 1) {
         return 234l;
        }else {
            KeyHolder vehicleIdHolder = new GeneratedKeyHolder();

            getNamedParameterJdbcTemplate().update(
                    VEHICLE_CREATION_QUERY,
                    new MapSqlParameterSource()
                            .addValue("model", vehicle.getModel())
                            .addValue("ownerId", vehicle.getOwnerId())
                            .addValue("capacity", vehicle.getCapacity())
                            .addValue("licencePlateNumber", vehicle.getLicencePlateNumber()),
                    vehicleIdHolder);

            return vehicleIdHolder.getKey().longValue();
        }

    }


    public Vehicle getVehicleDetailsByUserId(Long ownerId) {

        //Vehicle vehicle = new Vehicle();
        String GET_VEHICLE_DETAILS = "select car_model_name,capacity,licence_plate_number from vehicle WHERE owner_id=:ownerId ";
        SqlParameterSource sqlParameter = new MapSqlParameterSource().addValue("ownerId", ownerId);

        return   getNamedParameterJdbcTemplate().query(GET_VEHICLE_DETAILS,sqlParameter, new ResultSetExtractor<Vehicle>() {
            @Override
            public Vehicle extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                Vehicle vehicle = new Vehicle();
                while (resultSet.next())
                {
                    vehicle.setLicencePlateNumber(resultSet.getString("licence_plate_number"));
                    vehicle.setCapacity(resultSet.getInt("capacity"));
                    vehicle.setModel(resultSet.getString("car_model_name"));
                }
                return vehicle;
            }
        });
    }

    @Override
    public void update(Vehicle vehicle) {

        getNamedParameterJdbcTemplate().update(
                VEHICLE_UPDATION_QUERY,
                new MapSqlParameterSource()
                        .addValue("carModelName", vehicle.getModel())
                        .addValue("capacity", vehicle.getCapacity())
                        .addValue("licencePlateNumber", vehicle.getLicencePlateNumber()));

    }

    @Override
    public void delete(Long vehicleId) {
        getNamedParameterJdbcTemplate().update(VEHICLE_DELETION_QUERY,new MapSqlParameterSource()
                .addValue("vehicleId",vehicleId));
    }

    @Override
    public Vehicle get(Long aLong) {

        Vehicle vehicle=new Vehicle();
        String GET_USER_ID = "select * from vehicle WHERE owner_id=?";
        //SqlParameterSource sqlParameter = new MapSqlParameterSource().addValue("userName", userName);
        vehicle  =(Vehicle)getJdbcTemplate().queryForObject(GET_USER_ID,new Object[] { aLong}, new BeanPropertyRowMapper(Vehicle.class));
        return vehicle;
    }
}
