package com.mycompany.refactos_pizza.model;

//padrão observer aplicado para atualizar o status do pedido. Para bem encaixar o padrão,
//fez-se necessário que todos os observadores fossem notificados pela cozinha.

public interface Observer {

    void update(long orderId, String size, String status);
    
}
