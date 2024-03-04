package shop;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ProductsForShop {

    public static Map<Integer,Products> data=new HashMap<>();

    {
        data.put(0,new Products("banana", 5    ));
        data.put(1,new Products("coffee", 4   ));
        data.put(2,new Products("tea", 2    ));
        data.put(3,new Products("lemon", 8   ));
    }
    public Map<Integer,Products> getData()   {
        return data;
    }

    public void setData(Map<Integer,Products> data)   {
        ProductsForShop.data = data;
    }

    public Products getProductbyID(int id){
        return data.get(id);
    }
    public static Products getProductbyKey (Integer key){
        return data.get(key);
    }
    public static int getPricebyKey (Integer key){
        return data.get(key).getPrice();
    }

}
