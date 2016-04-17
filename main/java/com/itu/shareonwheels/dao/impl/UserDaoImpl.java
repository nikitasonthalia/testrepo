package com.itu.shareonwheels.dao.impl;

import com.itu.shareonwheels.dao.UserDao;
import com.itu.shareonwheels.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Created by nikitasonthalia on 10/7/15.
 */
@Repository
public class UserDaoImpl extends NamedParameterJdbcDaoSupport implements UserDao {

    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    private static final String USER_CREATION_QUERY = "insert into user (user_name, first_name, last_name, email_address, phone_number, password,status,gender,address_line1,address_line2,state,city,zipcode) " +
            "values (:userName, :firstName, :lastName, :email, :phone, :password, :status, :gender, :addressLine1, :addressLine2, :state, :city, :zipCode)";

    private static final String USER_UPDATION_QUERY = "update user SET first_name = :firstName,last_Name = :lastName,phone_number = :phoneNumber,"+
           "gender = :gender, date_of_birth = :dateOfBirth,address_line1 = :addressLine1, address_line2 = :addressLine2,state = :state, city = :city, zipcode = :zipCode  WHERE user_id = :userId";

    private static final String USER_DELETION_QUERY = "DELETE FROM user WHERE user_id = :userId";


    public Long create(User user) {
            String userName = user.getUserName();
            String VERIFY_DUPLICATE_USER = "select count(*) from user WHERE user_name=:userName";
            SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("userName", userName);

            int rowCount = getNamedParameterJdbcTemplate().queryForObject(VERIFY_DUPLICATE_USER, namedParameters, Integer.class);
            if (rowCount == 1) {
                // to check for duplicate

                return  123456789l;
              //  throw new DuplicateEntityException("User name alredy exists");
            } else {
                KeyHolder userIdHolder = new GeneratedKeyHolder();
                System.out.println("In user DAO" + user.getUserName());
                getNamedParameterJdbcTemplate().update(
                        USER_CREATION_QUERY,
                        new MapSqlParameterSource()
                                .addValue("userName", user.getUserName())
                                .addValue("firstName", user.getFirstName())
                                .addValue("lastName", user.getLastName())
                                .addValue("email", user.getEmailAddress())
                                .addValue("phone", user.getPhoneNumber())
                                .addValue("password", user.getPassword())
                                .addValue("addressLine1", user.getAddressLine1())
                                .addValue("addressLine2", user.getAddressLine2())
                                .addValue("city", user.getCity())
                                .addValue("state", user.getState())
                                .addValue("zipCode", user.getZipCode())
                                .addValue("gender", user.getGender().name())
                                .addValue("status", user.getStatus()),
                        userIdHolder);

                return userIdHolder.getKey().longValue();
            }

      }



    public void update(User user) {
        getNamedParameterJdbcTemplate().update(USER_UPDATION_QUERY, new MapSqlParameterSource()
                .addValue("firstName", user.getFirstName())
                .addValue("lastName", user.getLastName())
                .addValue("phoneNumber", user.getPhoneNumber())
                .addValue("addressLine1", user.getAddressLine1())
                .addValue("addressLine2", user.getAddressLine2())
                .addValue("city", user.getCity())
                .addValue("state", user.getState())
                .addValue("zipCode", user.getZipCode())
                .addValue("gender", user.getGender().name())
                .addValue("userId", user.getUserId())
                .addValue("dateOfBirth", user.getDateOfBirth()));
    }


    public void delete(Long userId) {
        getNamedParameterJdbcTemplate().update(USER_DELETION_QUERY,new MapSqlParameterSource()
                            .addValue("userId",userId));
    }

    public String verifyLogin(String userName, String password) {
        String VERIFY_USER_LOGIN_QUERY = "select count(*) from user WHERE user_name=:userName and password = :password";

        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("userName", userName).addValue("password",password);
        int rowCount = getNamedParameterJdbcTemplate().queryForObject(VERIFY_USER_LOGIN_QUERY, namedParameters, Integer.class);

        if(rowCount == 1){
            String VERIFY_USER_LOGIN_STATUS= "select count(*) from user WHERE user_name=:userName and password = :password and status=:status";
            SqlParameterSource namedParameters1 = new MapSqlParameterSource().addValue("userName",userName).addValue("password",password).addValue("status","Confirmed");
            int statusRowCount = getNamedParameterJdbcTemplate().queryForObject(VERIFY_USER_LOGIN_STATUS, namedParameters1, Integer.class);
            if(statusRowCount == 1)
            {
                return "USER_CONFIRMED";
            }else {
                return "NOT_CONFIRMED";
            }
        }
        else{
            return "USERNAME_PASSWORD_DOES_NOT_MATCH";
        }
    }

    @Override
    public User getByUserName(String userName) {
        User user = new User();

        String GET_USER_ID = "select user_id,first_name,last_name,user_name,email_address,phone_number,date_of_birth,gender,address_line1,address_line2,state,city,zipcode from user WHERE user_name=? ";
        //SqlParameterSource sqlParameter = new MapSqlParameterSource().addValue("userName", userName);
        user  =(User)getJdbcTemplate().queryForObject(GET_USER_ID,new Object[] { userName }, new BeanPropertyRowMapper(User.class));



//        return   getNamedParameterJdbcTemplate().query(GET_USER_ID,sqlParameter, new ResultSetExtractor<User>() {
//            @Override
//            public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//                User user = new User();
//                while (resultSet.next())
//                {
//
//                        user.setUserId(resultSet.getLong("user_id"));
//                        user.setFirstName(resultSet.getString("first_name"));
//                        user.setLastName(resultSet.getString("last_name"));
//                        user.setUserName(resultSet.getString("user_name"));
//                        user.setEmailAddress(resultSet.getString("email_address"));
//                        user.setPhoneNumber(resultSet.getString("phone_number"));
//                        user.setDateOfBirth(resultSet.getDate("date_of_birth"));
//                        user.setGender(Gender.valueOf(resultSet.getString("gender")));
//                        user.setAddressLine1(resultSet.getString("address_line1"));
//                        user.setAddressLine2(resultSet.getString("address_line2"));
//                        user.setState(resultSet.getString("state"));
//                        user.setCity(resultSet.getString("city"));
//                        user.setZipCode(resultSet.getString("zipcode"));
//
//                }
//                return user;
//            }
//        });
       return  user;
    }

    @Override
    public User forgotpassword(String emailId) {
        User user = new User();
        System.out.print(emailId);
        String Forgot_Password_Qrerry="select * from user where email_address=?";
        user  =(User)getJdbcTemplate().queryForObject(Forgot_Password_Qrerry,new Object[] { emailId }, new BeanPropertyRowMapper(User.class));

        return user;
    }


    public void statusUpdate(Long userId, String token)
    {
        String statusUpadte_Query = " update user SET status= 'Confirmed' where user_id= :userId and status=:token";
        KeyHolder keyholder = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(statusUpadte_Query,new MapSqlParameterSource()
                .addValue("userId",userId)
                .addValue("token",token)
                .addValue("status","Confirmed"),keyholder);
    }



}
