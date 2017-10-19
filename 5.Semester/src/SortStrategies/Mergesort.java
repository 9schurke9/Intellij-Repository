package SortStrategies;

import com.sun.scenario.effect.Merge;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Mergesort implements Sortable {

    private Comparable[] array;
    public Mergesort(Comparable[] array){
        this.array = array;
        sort(this.array);
    }
    public Mergesort(){

    }
    public void merge(Comparable[] a, Comparable[] aux,
                              int lo, int mid, int hi)
    {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
    public void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
    {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }
    public  void sort(Comparable[] a)
    {
       // this.array = a;
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
    public boolean less(Comparable a, Comparable b){
        return a.compareTo(b)<0;
    }

    @Override
    public void exch(Comparable[] a, int i, int j) {

    }
   public void printArray(){
       for(Comparable i: this.array){
           System.out.println(i);
       }
   }

}
