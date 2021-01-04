package pizza.ingredient_pizza;

import pizza.ingredient_pizza.factory.NYPizzaIngredientFactory;
import pizza.ingredient_pizza.factory.PizzaIngredientFactory;

public class NYPizzaStore extends PizzaStore
{

    @Override
    protected Pizza createPizza(String type)
    {
        Pizza pizza = null;
        PizzaIngredientFactory nyIngredientFactory = new NYPizzaIngredientFactory();

        if (type.equals("cheese")) {
            pizza = new CheesePizza(nyIngredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza(nyIngredientFactory);
            pizza.setName("New York Style Veggie Pizza");
        } else if (type.equals("clam")) {
            pizza = new ClamPizza(nyIngredientFactory);
            pizza.setName("New York Style Clam Pizza");
        } else if(type.equals("pepperoni")) {
            pizza = new PepperoniPizza(nyIngredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");
        }
        return pizza;
    }
}
