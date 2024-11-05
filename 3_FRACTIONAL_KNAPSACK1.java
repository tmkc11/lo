import java.util.*;
public class Assignment3 {

    public static class Item
    {
        int weight;
        int profit;
        double ratio;

        Item(int weight, int profit)
        {
            this.weight =  weight;
            this.profit = profit;

            this.ratio =(double)(profit/weight); 
       }
    }

    public static double solution(int capacity, Item [] item)
    {
        Sort(item);

        double maxProfit = 0;

        for(int i=0;i<item.length;i++)
        {
            if(capacity >= item[i].weight)
            {
                capacity = capacity - item[i].weight;
                maxProfit += item[i].profit;
            }
            else{
                maxProfit += item[i].profit * ((double)(capacity/item[i].weight));
                break;
            }
        }
        return maxProfit;
    }

    public static void Sort(Item []item)
    {
        for(int i=0 ; i<item.length-1; i++)
        {
            for(int j=0 ;j<item.length-i-1;j++)
            {
                if(item[j].ratio < item[j+1].ratio)
                {
                    Item temp = item[j];
                    item[j] = item[j+1];
                    item[j+1] = temp;
                }
            }
        }
    }

    public static void main(String [] args)
    {
        int bag_capacity = 15;

        int profit []={5,10,15,7,8,9,4};
        int weight [] ={1,3,5,4,1,3,2};

        Item items[]= new Item[profit.length];
        // ArrayList <Item> list = new ArrayList<>();

        for(int i=0;i<profit.length ;i++)
        {
            // list.add( new Item ( weight[i],profit[i]));
            items[i] = new Item(weight[i],profit[i]);
        }

        // Item item[] = {new Item(1,5),new Item(3,10),new Item(5,15),new Item(4,7), new Item(1,8),new Item(3,9) ,new Item(2,4)};

        double ans = solution(bag_capacity,items);
        System.out.println("Total value : "+ans);
    }
}
