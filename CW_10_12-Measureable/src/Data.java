public class Data {
    public static Measureable getMax(Measureable[] arr) {
        Measureable max = null;
        for (Measureable e : arr) {
            if (max == null)
                max = e;
            else if (max.getMeasure() < e.getMeasure())
                max = e;
        }
        return max;
    }


    public static double average(Measureable[] objects) {
        double sum = 0;
        for (Measureable obj : objects) {
            sum = sum + obj.getMeasure();
        }
        if (objects.length > 0) {
            return sum / objects.length;
        } else {
            return 0;
        }
    }

}
