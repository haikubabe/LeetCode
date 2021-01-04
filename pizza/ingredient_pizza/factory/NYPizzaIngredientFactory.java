package pizza.ingredient_pizza.factory;

import pizza.ingredient_pizza.dough.Dough;
import pizza.ingredient_pizza.dough.ThinCrustDough;
import pizza.ingredient_pizza.cheese.Cheese;
import pizza.ingredient_pizza.cheese.ReggianoCheese;
import pizza.ingredient_pizza.clams.Clams;
import pizza.ingredient_pizza.clams.FreshClams;
import pizza.ingredient_pizza.pepperoni.Pepperoni;
import pizza.ingredient_pizza.pepperoni.SlicedPepperoni;
import pizza.ingredient_pizza.sauce.MarinaraSauce;
import pizza.ingredient_pizza.sauce.Sauce;
import pizza.ingredient_pizza.veggies.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory
{

    @Override
    public Dough createDough()
    {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce()
    {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese()
    {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies()
    {
        Veggies[] veggies = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni()
    {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam()
    {
        return new FreshClams();
    }
}
