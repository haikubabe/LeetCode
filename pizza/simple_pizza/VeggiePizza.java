package pizza.simple_pizza;

public class VeggiePizza extends Pizza
{
    @Override
    void prepare()
    {
        System.out.println("Preparing Veggie Pizza");
    }

    @Override
    void bake()
    {
        System.out.println("Baking Veggie Pizza");
    }

    @Override
    void cut()
    {
        System.out.println("Cutting Veggie Pizza");
    }

    @Override
    void box()
    {
        System.out.println("Boxing Veggie Pizza");
    }
}
