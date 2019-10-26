package geektime.spring.data.pagehelpermybatis;

import com.github.pagehelper.PageInfo;
import geektime.spring.data.pagehelpermybatis.mapper.CoffeeMapper;
import geektime.spring.data.pagehelpermybatis.model.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
// pageHelper springboot 插件用法。
@SpringBootApplication
@Slf4j
@MapperScan("geektime.spring.data.pagehelpermybatis.mapper")
public class PagehelperMybatisDemoApplication implements ApplicationRunner {
    @Autowired
    private CoffeeMapper coffeeMapper;

    public static void main(String[] args) {
        SpringApplication.run(PagehelperMybatisDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        coffeeMapper.findAllWithRowBounds(new RowBounds(1,3))
                .forEach(c -> log.info("Coffee {}",c));
        coffeeMapper.findAllWithRowBounds(new RowBounds(2,3))
                .forEach(c ->log.info("Coffee2 {}",c));
        log.info("=======================");

        coffeeMapper.findAllWithRowBounds(new RowBounds(1,0))
                .forEach(c -> log.info("Pages1 {}",c));
        log.info("=======================");
        coffeeMapper.findWithparams(1,3)
                .forEach(c -> log.info("Page1 {}",c));
        List<Coffee> list = coffeeMapper.findWithparams(2, 3);
        PageInfo<Coffee> pageInfo = new PageInfo<>(list);
        log.info("page2 {}",pageInfo);
    }
}
