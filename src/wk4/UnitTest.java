package wk4;

import wk4.HashingWithChaining;

public class UnitTest
{


public static void main(String[] args)
{
HashingWithChaining h = new HashingWithChaining(7);
h.insert(1);
h.insert(2);
h.insert(3);
h.insert(4);
h.insert(5);
h.insert(6);
System.out.println(h.search(6));
h.remove(6);
System.out.println(h.search(6));
}


}