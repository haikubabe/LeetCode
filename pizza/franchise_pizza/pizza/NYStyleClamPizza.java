package pizza.franchise_pizza.pizza;

public class NYStyleClamPizza extends Pizza
{
    @Override
    public void prepare()
    {
        System.out.println("Preparing NYStyleClam Pizza");
    }

    @Override
    public void bake()
    {
        System.out.println("Baking NYStyleClam Pizza");
    }

    @Override
    public void cut()
    {
        System.out.println("Cutting NYStyleClam Pizza");
    }

    @Override
    public void box()
    {
        System.out.println("Boxing NYStyleClam Pizza");
    }
}
