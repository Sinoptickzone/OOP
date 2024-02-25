package Classes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Interfaces.iActorBehaviour;
import Interfaces.iMarketBehaviour;
import Interfaces.iQueueBehaviour;
import Main.App;

/**
 * A market that accepts, takes in queue, and releases actors from the market.
 */
public class Market implements iMarketBehaviour, iQueueBehaviour {
    private List<iActorBehaviour> queue;
    private List<Product> productsList;

    /**
     * Constructs a new market.
     */
    public Market() {
        this.queue = new ArrayList<>();
        makeProductsList();
    }

    /**
     * Makes a list of products in the market.
     */
    private void makeProductsList() {
        productsList = new ArrayList<>();
        productsList.add(new Product("молоко", new BigDecimal(60)));
        productsList.add(new Product("хлеб", new BigDecimal(50)));
        productsList.add(new Product("йогурт", new BigDecimal(40)));
        productsList.add(new Product("кола", new BigDecimal(90)));
        productsList.add(new Product("жвачка", new BigDecimal(30)));
    }

    /**
     * Accepts an actor to the market.
     *
     * @param actor The actor to accept.
     */
    @Override
    public void acceptToMarket(iActorBehaviour actor) {
        App.logger.info(actor.getActor().getName() + " клиент пришел в магазин ");
        takeInQueue(actor);
    }

    /**
     * Takes an actor to add in the queue.
     *
     * @param actor The actor to add in the queue.
     */
    @Override
    public void takeInQueue(iActorBehaviour actor) {
        this.queue.add(actor);
        App.logger.info(actor.getActor().getName() + " клиент добавлен в очередь ");
    }

    /**
     * Releases actors from the market.
     *
     * @param actors The actors to release.
     */
    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            App.logger.info(actor.getName() + " клиент ушел из магазина ");
            queue.remove(actor);
        }
    }

    /**
     * Updates the market.
     */
    @Override
    public void update() {
        takeOrder();
        giveOrder();
        returnOrder();
        releaseFromQueue();
    }

    /**
     * Gives orders to the actors in the queue.
     */
    @Override
    public void giveOrder() {
        for (iActorBehaviour actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);

                Map<Product, Integer> products = new HashMap<>();
                int numOfProducts = (int) (Math.random() * productsList.size() + 1);
                for (int i = 0; i < numOfProducts; i++) {
                    Product product;
                    do {
                        product = productsList.get((int) (Math.random() * productsList.size()));
                    }
                    while (products.containsKey(product));
                    products.put(product, (int) (Math.random() * 10));
                }

                Receipt receipt = new Receipt(products, LocalDateTime.now());
                actor.setReceipt(receipt);
                actor.setProducts(products);

                if (Math.random() < 0.3) actor.setReturnOrder(true);
                App.logger.info(actor.getActor().getName() + " клиент получил свой заказ ");
            }
        }
    }

    /**
     * Accepts returns of orders from actors.
     */
    public void returnOrder() {
        for (iActorBehaviour actor : queue) {
            if (actor.isReturnOrder()) {
                Receipt receipt = actor.showReceipt();
                Map<Product, Integer> products = actor.returnProducts();
                if (products.equals(receipt.getProducts())) {
                    actor.receiveMoney(receipt.getSum());
                    actor.setProducts(null);
                    App.logger.info(actor.getActor().getName() + " клиент вернул свой заказ ");
                }
                else App.logger.info(actor.getActor().getName() + " клиент не смог вернуть свой заказ ");
                actor.setReturnOrder(false);
            }
        }
    }

    /**
     * Releases actors from the queue.
     */
    @Override
    public void releaseFromQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for (iActorBehaviour actor : queue) {
            if (actor.isTakeOrder()) {
                releaseActors.add(actor.getActor());
                App.logger.info(actor.getActor().getName() + " клиент ушел из очереди ");
            }
        }
        releaseFromMarket(releaseActors);
    }

    /**
     * Instructs actors to make orders.
     */
    @Override
    public void takeOrder() {
        for (iActorBehaviour actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                App.logger.info(actor.getActor().getName() + " клиент сделал заказ ");
            }
        }
    }
}
    

