package pizza.franchise_pizza.pizza;

public class ChicagoStyleVeggiePizza extends Pizza
{
    @Override
    public void prepare()
    {
        System.out.println("Preparing ChicagoStyleVeggie Pizza");
    }

    @Override
    public void bake()
    {
        System.out.println("Baking ChicagoStyleVeggie Pizza");
    }

    @Override
    public void cut()
    {
        System.out.println("Cutting ChicagoStyleVeggie Pizza");
    }

    @Override
    public void box()
    {
        System.out.println("Boxing ChicagoStyleVeggie Pizza");
    }
}
