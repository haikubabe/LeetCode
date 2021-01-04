package pizza.ingredient_pizza;

import pizza.ingredient_pizza.cheese.Cheese;
import pizza.ingredient_pizza.clams.Clams;
import pizza.ingredient_pizza.dough.Dough;
import pizza.ingredient_pizza.pepperoni.Pepperoni;
import pizza.ingredient_pizza.sauce.Sauce;
import pizza.ingredient_pizza.veggies.Veggies;

public abstract class Pizza
{
    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Veggies[] veggies;
    protected Cheese cheese;
    protected Clams clams;
    protected Pepperoni pepperoni;

    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official pizza box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
