package pizza.franchise_pizza.pizza;

public class NYStylePepperoniPizza extends Pizza
{

    @Override
    public void prepare()
    {
        System.out.println("Preparing NYStylePepperoni Pizza");
    }

    @Override
    public void bake()
    {
        System.out.println("Baking NYStylePepperoni Pizza");
    }

    @Override
    public void cut()
    {
        System.out.println("Cutting NYStylePepperoni Pizza");
    }

    @Override
    public void box()
    {
        System.out.println("Boxing NYStylePepperoni Pizza");
    }
}
