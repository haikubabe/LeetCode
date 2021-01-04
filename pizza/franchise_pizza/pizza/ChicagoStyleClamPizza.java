package pizza.franchise_pizza.pizza;

public class ChicagoStyleClamPizza extends Pizza
{
    @Override
    public void prepare()
    {
        System.out.println("Preparing ChicagoStyleClam Pizza");
    }

    @Override
    public void bake()
    {
        System.out.println("Baking ChicagoStyleClam Pizza");
    }

    @Override
    public void cut()
    {
        System.out.println("Cutting ChicagoStyleClam Pizza");
    }

    @Override
    public void box()
    {
        System.out.println("Boxing ChicagoStyleClam Pizza");
    }
}
