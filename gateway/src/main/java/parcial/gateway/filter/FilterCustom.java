package parcial.gateway.filter; //CORRECCION PARA APPLICAR EL FILTER DEL GATEWAY OK

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Calendar;
import java.util.logging.Logger;

@Component
public class FilterCustom extends AbstractGatewayFilterFactory<FilterCustom.Config> {

    private static Logger log = Logger.getLogger(FilterCustom.class.getName());
    public FilterCustom() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {
//            Filtro previo a la invocacion del servicio real asociado al gateway
            log.info("Path requested: " + exchange.getRequest().getPath());

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//                        Filtro posterior a la invocacion del servicio real asociado al gateway
                log.info("Time response : " + Calendar.getInstance().getTime());
                    }));
        };

    }

    public static class Config {
    }
}
