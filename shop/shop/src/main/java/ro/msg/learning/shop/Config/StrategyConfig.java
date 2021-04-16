package ro.msg.learning.shop.Config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.Converters.LocationConverter;
import ro.msg.learning.shop.Converters.ProductConverter;
import ro.msg.learning.shop.Repositories.LocationRepository;
import ro.msg.learning.shop.Repositories.StockRepository;
import ro.msg.learning.shop.Strategies.Interfaces.Strategy;
import ro.msg.learning.shop.Strategies.MostAbundantStrategy;
import ro.msg.learning.shop.Strategies.SingleLocationStrategy;

@Configuration @AllArgsConstructor
public class StrategyConfig {
    private final StockRepository stockRepository;
    private final LocationRepository locationRepository;
    private final ProductConverter productConverter;
    private final LocationConverter locationConverter;

    private enum LStrategy{ SINGLE, ABUNDANT };

    @Bean
    Strategy chooseStrategy(@Value("${strategy}") LStrategy strategy){
        if(strategy.equals(LStrategy.SINGLE))
            return new SingleLocationStrategy(stockRepository, locationRepository, productConverter, locationConverter);
        else if(strategy.equals(LStrategy.ABUNDANT))
            return new MostAbundantStrategy(locationRepository, stockRepository, productConverter, locationConverter);
        else
            throw new RuntimeException("No such strategy - " + strategy);
    }
}
