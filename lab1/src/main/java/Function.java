public class Function {


    ///ограничение по количеству итераций = "не могу такое посчитать"

    public Object atan(double x, double eps)
    {
        if(x > 1 || x < -1){
            return "No, it's to big to me";
        }
        double p1 = 1, p0 = 1;
        double q1 = 0, q0 = 1;

        double at = x*q0/p0;

        for(int n = 1; ; ++n)
        {
            double z0 = 2*n+1, z1 = n*n*x*x;
            double p = p0*z0+z1*p1;
            double q = q0*z0+z1*q1;
            double r = x*q/p;

            if (Math.abs(at-r) < eps) return r;
            //System.out.println(at + " " + r + " " + " " + x +" "+q+ " "+ p+ " "+ (at - r));
            at = r;
            p1 = p0; p0 = p;
            q1 = q0; q0 = q;

        }
    }
}
