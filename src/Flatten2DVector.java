import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by rahilvora on 12/4/16.
 */
public class Flatten2DVector {

    public static void main(String args[]){
        int array[][] = {{1,2,3}, {4,5,6}};
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 2, 3));
        list.add(Arrays.asList(4, 5, 6));
        Vector2D i = new Vector2D(list);
        ArrayList<Integer> list1 = new ArrayList<>();
        while (i.hasNext()) {
            list1.add(i.next());
        }

    }
}
class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> listIndex;
    Iterator<Integer> listElementIndex;

    public Vector2D(List<List<Integer>> vec2d) {
        listIndex = vec2d.iterator();
    }

    @Override
    public Integer next() {
        return listElementIndex.next();
        //hasNext();
    }

    @Override
    public boolean hasNext() {
        while((listElementIndex == null || !listElementIndex.hasNext()) && listIndex.hasNext()){
            listElementIndex = listIndex.next().iterator();
        }
        return listElementIndex != null && listElementIndex.hasNext();
    }
}
