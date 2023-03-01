package com.mapper;

import com.entity.Route;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;


import java.util.List;

@Mapper
public interface RouteMapper {

    @Select("select * from tb_route")
    List<Route> findAllRoute();

    @Select("select * from tb_route where routeNum in('0104','0501','0106','0506')")
    List<Route> findRouteById();

    @Select("select * from tb_route where routeNum=#{routeNum}")
    Route findRouteByRouteNum(String routeNum);

    @Select("select * from tb_route where routeNum=#{routeNum}")
    List<Route> findListRouteByRouteNum(String routeNum);

    @Select("select * from tb_route where routeNum=#{routeNum}")
    List<Route> findRouteByNum(String routeNum);

    @Select("select routeNum from tb_route where departurePlace like concat(#{departurePlace},'%') and arrivalPlace like concat(#{arrivalPlace},'%')")
    Route findRouteNum(@Param("departurePlace") String departurePlace,@Param("arrivalPlace") String arrivalPlace);

    @Insert("insert into tb_route(routeNum,departurePlace,arrivalPlace,minPrice) values(#{routeNum},#{departurePlace},#{arrivalPlace},#{minPrice})")
    void insertRoutr(Route route);

    @Delete("delete from tb_route where routeNum=#{routeNum}")
    void delRoute(String routeNum);

    @Update("update tb_route set departurePlace=#{departurePlace},arrivalPlace=#{arrivalPlace},minPrice=#{minPrice} where routeNum=#{routeNum}")
    void updateRoute(@Param("departurePlace") String departurePlace,@Param("arrivalPlace") String arrivalPlace,@Param("minPrice") double minPrice,@Param("getRouteNum") String routeNum);
}
