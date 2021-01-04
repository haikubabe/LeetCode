package pizza.franchise_pizza.pizza;

public class NYStyleVeggiePizza extends Pizza
{
    @Override
    public void prepare()
    {
        System.out.println("Preparing NYStyleVeggie Pizza");
    }

    @Override
    public void bake()
    {
        System.out.println("Baking NYStyleVeggie Pizza");
    }

    @Override
    public void cut()
    {
        System.out.println("Cutting NYStyleVeggie Pizza");
    }

    @Override
    public void box()
    {
        System.out.println("Boxing NYStyleVeggie Pizza");
    }
}
