/**
 * Created by LT on 2018/3/5.
 */
public class SeqList<T>{
    protected Object[] element;
    protected int n;
    public SeqList(int length){
        this.element = new Object[length];
        this.n = 0;
    }
    public SeqList(){
        this(64);
    }
    public SeqList(T[] values){
        this(values.length);
        for(int i=0;i<values.length;i++)
            this.element[i] = values[i];
        this.n = element.length;
    }

    public boolean isEmpty(){
        return this.n == 0;
    }

    public int size(){
        return this.n;
    }

    public T get(int i){
        if(i>=0&&i<this.n) {
            return (T)this.element[i];
        }
        return null;
    }

    public void set(int i, T x){
        if(x==null)
            throw new NullPointerException("x == null");
        if(i>=0 && i<this.n)
            this.element[i] = x;
        else
            throw new java.lang.IndexOutOfBoundsException(i+"");
    }

    public String toString(){
        String str = this.getClass().getName()+"(";
        if(this.n>0){
            str += this.element[0].toString();
        }
        for(int i=1;i<this.n;i++){
            str += this.element[i].toString();
        }
        return str+")";
    }
    public static void main(String[] agrs){
        String values[] = {"A","B","C","D","E"};
        SeqList<String> lista = new SeqList<String>(values);
        SeqList<Integer> list1 = new SeqList<Integer>();
        System.out.print(lista.toString());
        System.out.print(list1.toString());
    }
}
