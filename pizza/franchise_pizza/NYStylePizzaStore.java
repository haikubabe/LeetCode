package pizza.franchise_pizza;

import pizza.franchise_pizza.pizza.*;

public class NYStylePizzaStore extends PizzaStore
{

    @Override
    protected Pizza createPizza(String type)
    {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new NYStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new NYStylePepperoniPizza();
        } else if (type.equals("veggie")) {
            pizza = new NYStyleVeggiePizza();
        } else if (type.equals("clam")) {
            pizza = new NYStyleClamPizza();
        }
        return pizza;
    }
}
