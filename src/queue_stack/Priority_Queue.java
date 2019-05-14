package queue_stack;
class Person1{
	String name;int age;
	Person1(String xName, int xAge) {name = xName;age=xAge;}
	public String toString() {return(name + " " + age);}
}

public class Priority_Queue {
	
	protected  Person1[] a; int top, max;
    public Priority_Queue() 
      { this(50);
      }
    public Priority_Queue(int max1) 
      { max = max1;
        a =  new Person1 [max];
        top = -1;
      }
    protected  boolean grow()
      { int max1 = max + max/2;
      Person1 [] a1 = new Person1 [max1];
        if(a1 == null) return(false);
        for(int i =0; i<=top; i++)
             a1[i] = a[i];
         a = a1;
        return(true);
      }
    
	    public boolean isEmpty()
	    { return(top==-1);}
	    
	  public boolean isFull()
	    { return(top==max-1);}
	  
	  public void clear()
	    { top=-1;}
	  
	  
	  public void enqueue(Person1 p)
	    { if(isFull() && !grow()) return;
	      if(top==-1)
	         { a[0] = p; top = 0;
	           return;
	         }
	      int i = top; 
	      while(i>=0 && p.age < a[i].age) 
	         {  a[i+1] = a[i];
	            i--;
	          }      
	      a[i+1] = p;  top++;
	    }
	  


	    public Person1 dequeue()
	     {assert(!isEmpty());
	     Person1 x = a[top];
	        top--;
	        return(x);
	      }
	    public static void main(String[] args) {
	    	Priority_Queue pri = new Priority_Queue();
	    	pri.enqueue(new Person1("Chuc", 18));
	    	pri.enqueue(new Person1("Mung", 21));
	    	pri.enqueue(new Person1("Nam", 19));
	    	pri.enqueue(new Person1("Moi", 20));
	    	System.out.println(pri.dequeue());
	    	System.out.println(pri.dequeue());
	    	System.out.println(pri.dequeue());
	    	System.out.println(pri.dequeue());

		}

}


