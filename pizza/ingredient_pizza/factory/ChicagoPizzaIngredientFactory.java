package pizza.ingredient_pizza.factory;

import pizza.ingredient_pizza.dough.Dough;
import pizza.ingredient_pizza.dough.ThickCrustDough;
import pizza.ingredient_pizza.cheese.Cheese;
import pizza.ingredient_pizza.cheese.MozzarellaCheese;
import pizza.ingredient_pizza.clams.Clams;
import pizza.ingredient_pizza.clams.FrozenClams;
import pizza.ingredient_pizza.pepperoni.Pepperoni;
import pizza.ingredient_pizza.pepperoni.SlicedPepperoni;
import pizza.ingredient_pizza.sauce.PlumTomatoSauce;
import pizza.ingredient_pizza.sauce.Sauce;
import pizza.ingredient_pizza.veggies.BlackOlives;
import pizza.ingredient_pizza.veggies.EggPlant;
import pizza.ingredient_pizza.veggies.Spinach;
import pizza.ingredient_pizza.veggies.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory
{

    @Override
    public Dough createDough()
    {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce()
    {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese()
    {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies()
    {
        Veggies[] veggies = { new Spinach(), new EggPlant(), new BlackOlives() };
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
        return new FrozenClams();
    }
}
