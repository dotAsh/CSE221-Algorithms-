
import java.util.Random;

public class MyArray {
    int a[];
    public MyArray(int b[]){
      a = new int[b.length];
      for(int i =0;i<b.length;i++){
        a[i] = b[i];
      }
    }
    
    public  void quickSort(int p,int r) {
        if(p<r){
            int  q = partition(p,r);
            quickSort(p,q-1);
            quickSort(q+1,r);
        }
    }
    
    public  int partition(int p,int q){
        Random r = new Random();
        int k = p + r.nextInt(q - p + 1);
        int t = a[p];
        a[p] = a[k];
        a[k] = t;
        int pivot = a[p];
        int i = p;
        for(int j = i+1;j<=q;j++){
            if(a[j]<=pivot){
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[p];
        a[p] = a[i];
        a[i] = temp;
        return i;
    }
    public  void selectionSort(){
        for(int i =0;i<a.length-1;i++){
            int minIndex = i;
            for(int j =i+1;j<a.length;j++){
                if(a[j]<a[minIndex]){
                    minIndex = j;
                    
                }
            }
            if(minIndex!=i){
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }
    
    
    public String toString(){
      String s = "";
      for(int i = 0;i<a.length;i++){
        s = s+a[i]+"\t";
      }
      return s;
    }
}




