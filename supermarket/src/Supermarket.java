import java.util.Arrays;

public class Supermarket {

    private static final int SIZE = 50;
    private String products[];
    private int index;

    public String[] getProducts()
    {
        return products;
    }

    Supermarket()
    {
        products = new String[SIZE];
        index = 0;

    }

    private boolean isEmpty()
    {
        return index == 0;
    }

    private boolean isFull()
    {
        return index == SIZE;
    }

    public void showProducts()
    {
        for (int i = 0; i < index; i++)
        {
            System.out.println(products[i]);
        }
    }

    private int find (String product)
    {
        for (int i = 0; i < index; i++)
        {
            if (products[i].toUpperCase().equals(product.toUpperCase()))
            {
                return i;
            }
        }
        return -1;
    }

    public boolean insert (String product)
    {
        int v;

        if (!isFull())
        {
            v = find(product);

            if (v == -1)
            {
                products[index++] = product;
                return true;
            } else
            {
                System.out.println("Το προϊόν υπάρχει ήδη.");
                return false;
            }
        } else
        {
            System.out.println("Το καλάθι είναι γεμάτο.");
            return false;
        }
    }

    public boolean update (String oldProduct, String newProduct)
    {
        int v = find (oldProduct);
        if (v != 1)
        {
            products[v] = newProduct;
            return true;
        } else
        {
            System.out.println("Δεν βρέθηκε το προϊόν.");
            return false;
        }
    }

    public boolean delete (String product)
    {
        int v = find (product);
        if (v != -1)
        {
            products[v] = "Διαγραφή " + product;
            return true;
        } else
        {
            System.out.println("Δεν βρέθηκε το προϊόν.");
            return false;
        }
    }

    public boolean isOnFile (String product)
    {
        return find (product) != 1;
    }

    public String[] copySupermarket()
    {
        return Arrays.copyOf (products, products.length);
    }

}
