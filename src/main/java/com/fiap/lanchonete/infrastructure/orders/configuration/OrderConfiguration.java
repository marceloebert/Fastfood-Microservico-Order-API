package com.fiap.lanchonete.infrastructure.orders.configuration;

import com.fiap.lanchonete.application.customers.gateways.CustomerGateway;
import com.fiap.lanchonete.application.orders.usecases.CreateOrderUseCase;
import com.fiap.lanchonete.application.orders.usecases.GetAllOrdersUseCase;
import com.fiap.lanchonete.application.orders.usecases.GetOrderByIdUseCase;
import com.fiap.lanchonete.application.orders.usecases.UpdateOrderStateUseCase;
import com.fiap.lanchonete.application.orders.gateways.OrderGateway;
import com.fiap.lanchonete.application.payments.gateways.PaymentGateway;
import com.fiap.lanchonete.application.products.gateways.ProductGateway;
import com.fiap.lanchonete.crosscutting.util.AppConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fiap.lanchonete.crosscutting.util.RestClient;

@Configuration
public class OrderConfiguration {

    @Bean
    public CreateOrderUseCase createOrderUseCase(OrderGateway orderGateway, ProductGateway productGateway, CustomerGateway customerGateway, PaymentGateway paymentGateway,RestClient restClient, AppConfig appconfig) {
        return new CreateOrderUseCase(orderGateway, productGateway,customerGateway,paymentGateway,restClient,appconfig);
    }

    @Bean
    public GetAllOrdersUseCase getAllOrdersUseCase(OrderGateway orderGateway,RestClient restClient, AppConfig appconfig) {
        return new GetAllOrdersUseCase(orderGateway,restClient,appconfig);
    }

    @Bean
    public GetOrderByIdUseCase getOrderByIdUseCase(OrderGateway orderGateway,RestClient restClient, AppConfig appconfig) {
        return new GetOrderByIdUseCase(orderGateway,restClient,appconfig);
    }

    @Bean
    public UpdateOrderStateUseCase updateOrderStateUseCase(OrderGateway orderGateway) {
        return new UpdateOrderStateUseCase(orderGateway);
    }
}
