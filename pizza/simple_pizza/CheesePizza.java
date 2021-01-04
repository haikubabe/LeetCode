package pizza.simple_pizza;

public class CheesePizza extends Pizza
{

    @Override
    void prepare()
    {
        System.out.println("Preparing Cheese Pizza");
    }

    @Override
    void bake()
    {
        System.out.println("Baking Cheese Pizza");
    }

    @Override
    void cut()
    {
        System.out.println("Cutting Cheese Pizza");
    }

    @Override
    void box()
    {
        System.out.println("Boxing Cheese Pizza");
    }
}
