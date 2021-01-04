package pizza.simple_pizza;

public class ClamPizza extends Pizza
{
    @Override
    void prepare()
    {
        System.out.println("Preparing Clam Pizza");
    }

    @Override
    void bake()
    {
        System.out.println("Baking Clam Pizza");
    }

    @Override
    void cut()
    {
        System.out.println("Cutting Clam Pizza");
    }

    @Override
    void box()
    {
        System.out.println("Boxing Clam Pizza");
    }
}
