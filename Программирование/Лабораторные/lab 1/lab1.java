class lab1 {
    public static void main(String[] args) {
        // 1
        short[] e = new short[15];
        for (int i=0; i<15; i++) {
            e[i] = (short) (19-i);
        }

        //2
        double[] x = new double[15];
        for (int i=0; i<15; i++) {
            x[i] = -2.0 + 16.0*Math.random();
        }

        //3
        double[][] w = new double[8][15];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 15; j++) {
                w[i][j] = magic.arr3(i,j,e,x);
            }
        }

        //System.out.println(arr2str.convert(e));
        //System.out.println(arr2str.convert(x));
        for (int i = 0; i < 8; i++) {
            System.out.println(arr2str.convert(w[i]));
            System.out.println();
        }
    }
}

class magic{
    static double arr3(int i, int j, short[] e, double[] x_arr){
        double ret;
        double x = x_arr[j];
        short[] condition_arr = {5, 7, 13, 15};
        if (e[i] == 17) {
            ret = x*(x+1);
            ret = Math.pow(ret, 3);
            ret = Math.log(Math.abs(Math.sin(ret)));
        }
        else if ( contains( condition_arr, e[i] ) ) {
            ret = Math.pow(Math.E, Math.log(Math.abs(x)));
            ret = Math.tan(ret);
        }
        else {
            double a = Math.log(Math.abs(x));
            double b =  4/(Math.pow(x, x*(1-x))-0.5);
            double b_1 = Math.pow(x,x*(1-x));
            //System.out.printf("%s, %s, %s | %s \n", a, b, b_1, x);
            ret = Math.pow(a,b);
            ret = ret * (0.25 + Math.cos(Math.asin( (x+6)/16 )));
            ret = Math.pow(ret, 3);
            //asin(sin) is pointless
        }   
        return ret;
    }


    static private boolean contains(short[] arr, int n) {
        for (short i: arr) {
            if (i == n) {
                return true;
            }
        }
        return false;
    }
}


class arr2str{
    static String convert(double[] arr) {
        String ret = "";
        for (double i: arr) {
            if (!ret.isEmpty()) {ret = ret + "; ";}
            ret = ret + String.format("%.3f", i);
        }
        return ret;
    }
    static String convert(short[] arr) {
        String ret = "";
        for (double i: arr) {
            if (!ret.isEmpty()) {ret = ret + "; ";}
            ret = ret + String.valueOf(i);
        }
        return ret;
    }
}