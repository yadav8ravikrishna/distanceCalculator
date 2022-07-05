package com.shortestdistance.distanceCalculator;

import com.sun.org.apache.xml.internal.security.utils.Signature11ElementProxy;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface citiyRepository extends JpaRepository<cities,String> {
    cities findByCityname(String cityname);
    @Query("Select c.Latitude from cities c where c.cityname = :cityname")
    Double findLatitudeByCityname(@Param("cityname") String cityname);

    @Query("Select c.Longitude from cities c where c.cityname = :cityname")
    Double findLongitudeByCityname(@Param("cityname") String cityname);

    @Query("Select c.cityname from cities c")
    ArrayList<ArrayList<String>> findCityname();

    @Query("Select c.cityname from cities c where c.cityname = :cityname")
    String getcity(@Param("cityname") String cityname);
}


