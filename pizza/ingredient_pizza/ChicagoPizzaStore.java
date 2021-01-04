package pizza.ingredient_pizza;

import pizza.ingredient_pizza.factory.ChicagoPizzaIngredientFactory;
import pizza.ingredient_pizza.factory.PizzaIngredientFactory;

public class ChicagoPizzaStore extends PizzaStore
{

    @Override
    protected Pizza createPizza(String type)
    {
        Pizza pizza = null;
        PizzaIngredientFactory chicagoIngredientFactory = new ChicagoPizzaIngredientFactory();

        if (type.equals("cheese")) {
            pizza = new CheesePizza(chicagoIngredientFactory);
            pizza.setName("Chicago Style Cheese Pizza");
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza(chicagoIngredientFactory);
            pizza.setName("Chicago Style Veggie Pizza");
        } else if (type.equals("clam")) {
            pizza = new ClamPizza(chicagoIngredientFactory);
            pizza.setName("Chicago Style Clam Pizza");
        } else if(type.equals("pepperoni")) {
            pizza = new PepperoniPizza(chicagoIngredientFactory);
            pizza.setName("Chicago Style Pepperoni Pizza");
        }
        return pizza;
    }
}
