package Interfaces;

import java.util.List;

import Classes.Actor;

/**
 * The iMarketBehaviour interface represents the behavior of a market in the system.
 */
public interface iMarketBehaviour {
    /**
     * Accepts an actor to the market.
     *
     * @param actor The actor to be accepted to the market.
     */
    void acceptToMarket(iActorBehaviour actor);
    /**
     * Releases a list of actors from the market.
     *
     * @param actors The list of actors to be released from the market.
     */
    void releaseFromMarket(List<Actor> actors);
    /**
     * Updates the market behavior, such as processing orders and managing actors.
     */
    void update();
}