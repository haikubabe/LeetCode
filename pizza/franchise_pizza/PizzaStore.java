package pizza.franchise_pizza;

import pizza.franchise_pizza.pizza.Pizza;

public abstract class PizzaStore
{
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /**
     * Factory method responsible for instantiating objects (in this case it is pizza)
     * @param type
     * @return
     */
    protected abstract Pizza createPizza(String type);
}
