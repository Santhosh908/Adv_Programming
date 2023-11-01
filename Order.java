import java.util.*;


public class Order
{

    int o_id;
    int c_id;
    String status;
    // ArrayList<ArrayList<Integer>> order_items=new ArrayList<ArrayList<Integer>>();
    HashMap<Integer,Integer> order_items=new HashMap<Integer,Integer>();
    Order(int o_id,int c_id,String status){
        this.o_id=o_id;
        this.c_id=c_id;
        this.status=status;
    }  
    public void addToOrder(int p_id,int quantity){
        // ArrayList<Integer> temp=new ArrayList<Integer>();
        // temp.add(p_id);
        // temp.add(quantity);
        this.order_items.put(p_id,order_items.getOrDefault(p_id,0)+quantity);
        // c_hm.get(this.c_id).total_price+=(p_hm.get(p_id).price)*quantity;
        // System.out.println(c_hm.get(this.c_id).c_name+" "+c_hm.get(this.c_id).total_price);
        // this.order_items.add(temp);
    }
}