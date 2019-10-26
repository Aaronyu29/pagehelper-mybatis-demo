package geektime.spring.data.pagehelpermybatis.mapper;

import geektime.spring.data.pagehelpermybatis.model.Coffee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
//@Repository
public interface CoffeeMapper {
    @Select("select * from t_coffee order by id")
    List<Coffee> findAllWithRowBounds(RowBounds rowBounds);
    @Select("select * from t_coffee order by id")
    List<Coffee> findWithparams(@Param("pageNum") int pageNum,
                                @Param("pageSize") int pageSize);
}
