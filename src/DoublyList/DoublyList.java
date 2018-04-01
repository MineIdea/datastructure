package DoublyList;

import java.util.Dictionary;

public class DoublyList<T> {
    public DoubleNode<T> head;

    public DoublyList(){
        this.head = new DoubleNode<T>();
    }

    public DoublyList(T[] values){
        this();
        DoubleNode<T> rear = this.head;
        for (int i=0;i<values.length;i++){
            rear.next = new DoubleNode<T>(values[i], rear, null);
            rear = rear.next;
        }
    }

    public boolean isEmpty(){
        return this.head.next == null;
    }

    public T get(int i){
        DoubleNode<T> p = this.head.next;
        for (int j=0;j<i&&p!=null;j++){
            p = p.next;
        }
        return (i>=0&&p!=null) ? p.data : null;
    }

    public void set(int i, T x){
        DoubleNode<T> p = this.head.next;
        for (int j=0;j<i&&p!=null;j++){
            p = p.next;
        }
        if (i>=0&&p!=null)
            p.data = x;
    }

    public DoubleNode<T> insert(int i, T x){
        if(x==null)
            throw new NullPointerException("x == null");
        DoubleNode<T> front = this.head.next;
        for (int j=0;j<i&&front.next!=null;j++){
            front = front.next;
        }
        front.next = new DoubleNode<T>(x, front, front.next);
        return front.next;
    }

    public DoubleNode<T> insert(T x){
        return this.insert(Integer.MAX_VALUE, x);
    }

    public T remove(int i){
        DoubleNode<T> front = this.head;
        for (int j=0;j<i&&front.next!=null;j++){
            front = front.next;
        }
        if (i>=0&&front.next!=null&&front.next.next!=null){
            T old = front.next.data;
            front.next.next.prev = front;
            front.next = front.next.next;
            return old;
        }
        else if (i>=0&&front.next!=null){
            T old = front.next.data;
            front.next = null;
            return old;
        }
        return null;

    }

    public void removeAllMatched(DoublyList<T> pattern) {
        DoubleNode<T> p = this.head.next;
        DoubleNode<T> pn = pattern.head.next;
        DoubleNode<T> begin = p;
        while (p != null) {
            if (p.data.equals(pn.data) && pn.next != null) {
                p = p.next;
                pn = pn.next;
            }
            else if (p.data.equals(pn.data)&&pn.next==null){
                begin.prev.next = p.next;
                if (p.next!=null) {
                    p.next.prev = begin.prev;
                    p = p.next;
                    pn = pattern.head.next;
                }
                else {
                    p = p.next;
                    pn = pattern.head.next;
                }
            }
            else {
                p = begin.next;
                begin = p;
                pn = pattern.head.next;
            }
        }
    }
    public void replaceAll(DoublyList<T>pattern, DoublyList<T>list){

    }

    @Override
    public String toString() {
        String str = this.getClass().getName() + "(";
        for (DoubleNode<T> p = this.head.next; p != null; p = p.next) {
            str += p.data.toString();
            if (p.next != null) {
                str += ",";
            }
        }
        str += ")";
        return str;
    }
    public static void main(String[] args){
        String[] str = {"1", "2", "4","1", "2", "3"};
        DoublyList<String> dl = new DoublyList<String>(str);
        String[] str1 = {"1", "2", "3"};
        DoublyList<String> pattern = new DoublyList<String>(str1);
//        System.out.println(dl.isEmpty());
//        System.out.println(dl);
//        System.out.println(dl.insert("x"));
//        System.out.println(dl);
//        System.out.print(dl.remove(3));
        dl.removeAllMatched(pattern);
        System.out.println(dl);
    }
}