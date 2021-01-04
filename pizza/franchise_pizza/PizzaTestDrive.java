package pizza.franchise_pizza;

import pizza.franchise_pizza.pizza.Pizza;

public class PizzaTestDrive
{

    public static void main(String[] args)
    {
        PizzaStore nyPizzaStore = new NYStylePizzaStore();
        PizzaStore chicagoPizzaStore = new ChicagoStylePizzaStore();

        Pizza nyStylePizza = nyPizzaStore.orderPizza("cheese");
        System.out.println("Pizza: " + nyStylePizza.getName());

        System.out.println("\n\n");
        
        Pizza chicagoStylePizza = chicagoPizzaStore.orderPizza("cheese");
        System.out.println("Pizza: " + chicagoStylePizza.getName());
    }
}
