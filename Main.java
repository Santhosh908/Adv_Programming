
import java.util.*;

public class Main
{
    public static HashMap<Integer,Product> p_hm=new HashMap<Integer,Product>();
    public static HashMap<Integer,Customer> c_hm=new HashMap<Integer,Customer>();
    public static HashMap<Integer,Order> o_hm=new HashMap<Integer,Order>();

    public static void listOrders(String status){

    System.out.println("Order ids "+status);
    if(status=="ALL")
    for(Integer a:o_hm.keySet()){
          System.out.println(o_hm.get(a).o_id);
    }
    for(Integer a:o_hm.keySet()){
         if(o_hm.get(a).status==status){
                System.out.println(o_hm.get(a).o_id);
            }
    }
    
    }
    public static void listCustomer(String status){

        HashMap<String,Integer> hm =new HashMap<String,Integer>();
        for(Integer a:o_hm.keySet()){
            if(o_hm.get(a).status==status){
                String s_key=c_hm.get(o_hm.get(a).c_id).c_name;
                hm.put(s_key,hm.getOrDefault(s_key,0)+1);
            }
        }
        Set<String> t_name=hm.keySet();
        System.out.println("Customer Name | "+status);
        for(String a:t_name){
        System.out.println(a+" | "+hm.get(a));    
        }
        
    }
    public static void DisplayHighestOrder(){

        int m=0;
        String name="";
        for(Integer a:o_hm.keySet()){
            // System.out.println(o_hm.get(a).order_items);

            for(Integer b:(o_hm.get(a).order_items).keySet())
            // System.out.println(p_hm.get(b).price*(o_hm.get(a).order_items.get(b)));
            c_hm.get(o_hm.get(a).c_id).total_price+=p_hm.get(b).price*(o_hm.get(a).order_items.get(b));
        }
        for(Integer a:c_hm.keySet()){
            // System.out.println(c_hm.get(a).total_price+" "+c_hm.get(a).c_name);
            if(c_hm.get(a).total_price>m){
                m=c_hm.get(a).total_price;
                name=c_hm.get(a).c_name;
            }
        }
        System.out.println("Customer Name | Order amount");
        System.out.println(name+" "+m);

    }
    public static void Top_N_selling(int n){
        HashMap<String,Integer>hm=new HashMap<String,Integer>();
        TreeMap<Integer,String> tm=new TreeMap<Integer,String>();
        // ArrayList<ArrayList<String,Integer>> arr=new ArrayList<ArrayList<String,Integer>>();
        for(Integer a:o_hm.keySet()){
            for(Integer b:o_hm.get(a).order_items.keySet()){
                // System.out.println(p_hm.get(b).p_name+" "+hm.getOrDefault(p_hm.get(b).p_name,0)+" "+(o_hm.get(a).order_items).get(b)+" "+b);
                hm.put(p_hm.get(b).p_name,hm.getOrDefault(p_hm.get(b).p_name,0)+o_hm.get(a).order_items.get(b));
            }
        }
        int m=0;
        String name="";
        for(String a:hm.keySet()){
            tm.put(hm.get(a),a);
        }
        
        System.out.println(tm);
        for(Integer a:tm.descendingKeySet()){
            System.out.print(tm.get(a)+" "+a);
        }
        Stack<Integer> s=new Stack<Integer>();
        // for(Integer a:tm.keySet()){
        //     s.push(a);
        // }
        // while(n>0){
        //     System.out.println(tm.get(s.peek())+" "s.pop());
        //     n--;
        // }
        // System.out.println();
    }
    
    public static void main(String args[]){
        
        Product p1 =new Product(1,"Pencil",10);
        p_hm.put(p1.p_id,p1);
        Product p2 =new Product(2,"Pen",20);
        p_hm.put(p2.p_id,p2);   
        Product p3 =new Product(3,"Eraser",5);
        p_hm.put(p3.p_id,p3);
        Product p4 =new Product(4,"Bag",200);
        p_hm.put(p4.p_id,p4);
        Product p5 =new Product(5,"Shoes",100);
        p_hm.put(p5.p_id,p5);
        
        Customer c1=new Customer(1,"Rohit");
        c_hm.put(c1.c_id,c1);
        Customer c2=new Customer(2,"Virat");
        c_hm.put(c2.c_id,c2);
        Customer c3=new Customer(3,"Bumrah");
        c_hm.put(c3.c_id,c3);
        Customer c4=new Customer(4,"Shubman");
        c_hm.put(c4.c_id,c4);

        Order o1=new Order(1,1,"IN_PROGRESS");
        o_hm.put(o1.o_id,o1);
        Order o2=new Order(2,2,"DELIVERED");
        o_hm.put(o2.o_id,o2);
        Order o3=new Order(3,3,"CANCELLED");
        o_hm.put(o3.o_id,o3);
        Order o4=new Order(4,1,"DELIVERED");
        o_hm.put(o4.o_id,o4);
        Order o5=new Order(5,1,"IN_PROGRESS");
        o_hm.put(o5.o_id,o5);
        Order o6=new Order(6,4,"IN_PROGRESS");

        o_hm.put(o6.o_id,o6);
        o1.addToOrder(1,4);
        o1.addToOrder(2,4);
        o2.addToOrder(3,10);
        o3.addToOrder(5,2);
        o3.addToOrder(1,5);
        o4.addToOrder(4,2);
        o5.addToOrder(3,8);
        o5.addToOrder(2,4);
        o5.addToOrder(5,2);
        o6.addToOrder(1,3);
        o6.addToOrder(4,3);
        
        listOrders("DELIVERED");
        listCustomer("IN_PROGRESS");
        DisplayHighestOrder();
        Top_N_selling(2);
    }
}