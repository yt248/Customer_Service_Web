package com.eugene.spring.boot.web.customer_service_web.repository;

import com.eugene.spring.boot.web.customer_service_web.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {


    @Query("select a.id from Address a where a.cityName = :cityName and a.streetName = :streetName and " +
            "a.houseNumber = :houseNumber")
    Integer findByAddress(@Param("cityName") String cityName,
                          @Param("streetName") String streetName,
                          @Param("houseNumber") String houseNumber);

    Address findAddressByCityNameAndStreetNameAndHouseNumber(String cityName, String streetName, String houseNumber);
}
