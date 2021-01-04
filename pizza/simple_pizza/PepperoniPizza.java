package pizza.simple_pizza;

public class PepperoniPizza extends Pizza
{

    @Override
    void prepare()
    {
        System.out.println("Preparing Pepperoni Pizza");
    }

    @Override
    void bake()
    {
        System.out.println("Baking Pepperoni Pizza");
    }

    @Override
    void cut()
    {
        System.out.println("Cutting Pepperoni Pizza");
    }

    @Override
    void box()
    {
        System.out.println("Boxing Pepperoni Pizza");
    }
}
