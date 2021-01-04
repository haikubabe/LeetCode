package pizza.franchise_pizza.pizza;

public class ChicagoStylePepperoniPizza extends Pizza
{

    @Override
    public void prepare()
    {
        System.out.println("Preparing ChicagoStylePepperoni Pizza");
    }

    @Override
    public void bake()
    {
        System.out.println("Baking ChicagoStylePepperoni Pizza");
    }

    @Override
    public void cut()
    {
        System.out.println("Cutting ChicagoStylePepperoni Pizza");
    }

    @Override
    public void box()
    {
        System.out.println("Boxing ChicagoStylePepperoni Pizza");
    }
}
