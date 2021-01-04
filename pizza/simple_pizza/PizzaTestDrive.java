package pizza.simple_pizza;

public class PizzaTestDrive
{

    public static void main(String[] args)
    {
        PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
        pizzaStore.orderPizza("cheese");
        pizzaStore.orderPizza("veggie");
    }
}
