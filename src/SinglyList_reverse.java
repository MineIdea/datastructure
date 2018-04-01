public class SinglyList_reverse {
    public static <T> SinglyList<T> createReverse(T[] values){
        Object[] temp = new Object[values.length];
        for (int i=values.length-1;i>=0;i--){
            temp[values.length-1-i] = values[i];
        }
        return new SinglyList<T>((T[])temp);
    }

    public static <T> void reverse(SinglyList<T> list) {
        Node<T> front = null;
        Node<T> p = list.head.next;
        while (p != null) {
            Node<T> after = p.next;
            p.next = front;
            front = p;
            p = after;
        }
        list.head.next = front;
    }

    public static void main(String[] args){
        String[] values = {"A", "B", "C", "D", "E", "F"};
        SinglyList<String> list = createReverse(values);
        System.out.println("list=" + list.toString());
        reverse(list);
        System.out.println(",逆转后"+list);
    }
}