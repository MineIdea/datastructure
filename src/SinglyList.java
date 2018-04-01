
public class SinglyList<T> {
	public Node<T> head;
	
	public SinglyList(){
		this.head = new Node<>();
	}
	
	public SinglyList(T[] values){
		this();
		Node<T> rear = this.head;
		for (int i=0;i<values.length;i++){
			rear.next = new Node<>(values[i], null);
			rear = rear.next;
		}
	}
	
	public SinglyList(SinglyList<T> list){
		this();
		Node<T> p_list = list.head.next;
		Node<T> rear = this.head;
		while (p_list!=null){
		    rear.next = new Node<T>(p_list.data, null);
		    rear = rear.next;
		    p_list = p_list.next;
        }
	}
	
	public boolean isEmpty(){
		return this.head.next == null;
	}
	
	public T get(int i){
		Node<T> p = this.head.next;
		for (int j=0;j<i&&p!=null;j++){
			p = p.next;
		}
		return (i>=0&&p!=null) ? p.data : null;
	}
	
	public void set(int i, T x){
		Node<T> p = this.head.next;
		for(int j=0;j<i&&p!=null;j++){
			p = p.next;
		}
		if (p!=null){
			p.data = x;
		}
	}
	
	@Override
	public String toString(){
		String str = this.getClass().getName() +"(";
		for (Node<T> p=this.head.next;p!=null;p=p.next){
			str += p.data.toString();
			if(p.next!=null){
				str += ",";
			}
		}
		return str + ")";
	}
	
	public Node<T> insert(int i, T x){
		if(x==null)
			throw new NullPointerException("x == null");
		Node<T> front = this.head;
		for(int j=0;front.next!=null&&j<i;j++){
			front = front.next;
		}
		front.next = new Node<T>(x, front.next);
		return front.next;
	}
	
	public Node<T> insert(T x){
		return insert(Integer.MAX_VALUE, x);
	}
	
	public T remove(int i){
		Node<T> front = this.head;
		for (int j=0;j<i&&front.next!=null;j++){
			front = front.next;
		}
		if (i>=0&&front.next!=null){
			T old = front.next.data;
			front.next = front.next.next;
			return old;
		}
		return null;
	}
	
	public void clear(){
		this.head.next = null;
	}
	
	public Node<T> search(T key){
		Node<T> p = this.head.next;
		while(p!=null){
			if(key.equals(p.data)){
				return p;
			}
			else
				p = p.next;
		}
		return null;
	}
	
	public boolean contains(T key){
		Node<T> p = this.head.next;
		while(p!=null){
			if(key.equals(p.data)){
				return true;
			}
			else
				p = p.next;
		}
		return false;
	}
	
	public Node<T> insertDifferent(T x){
		Node<T> p = this.head;
		while(p!=null){
			if(x.equals(p.data)){
				return p;
			}
			else
				p = p.next;
		}
		p = new Node<T>(x, null);
		return p;
	}
	
	public T remove(T key){
		Node<T> front = this.head;
		while(front.next!=null){
			if(key.equals(front.next.data)){
				T old = front.next.data;
				front.next = front.next.next;
				return old;
			}
			else
				front = front.next;
		}
		return null;
	}


	
	public static void main(String[] args){
		Integer[] values = {1,2,3};
		SinglyList<Integer> list1 = new SinglyList<Integer>(values);
		System.out.println("list1=" + list1.toString());
//		System.out.println(list1.get(1));
//		System.out.println(list1.search(4));
//		System.out.println(list1.contains(2));
		System.out.println(list1.insertDifferent(5));
		SinglyList<Integer> list2 = new SinglyList<>(list1);
		System.out.println(list2.toString());
		System.out.println(list1 == list2);
	}
}
