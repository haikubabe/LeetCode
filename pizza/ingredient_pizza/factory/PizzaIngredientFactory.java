package pizza.ingredient_pizza.factory;

import pizza.ingredient_pizza.cheese.Cheese;
import pizza.ingredient_pizza.clams.Clams;
import pizza.ingredient_pizza.dough.Dough;
import pizza.ingredient_pizza.pepperoni.Pepperoni;
import pizza.ingredient_pizza.sauce.Sauce;
import pizza.ingredient_pizza.veggies.Veggies;

public interface PizzaIngredientFactory
{
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clams createClam();
}
