public class Function {
    /*public double atan1(double number) {
        //
        return (number - Math.pow(number, 3) / 3 + Math.pow(number, 5) / 5 - Math.pow(number, 7) / 7 + Math.pow(number, 9) / 9
                - Math.pow(number, 9) / 9 + Math.pow(number, 13) / 13 - Math.pow(number, 15) / 15 + Math.pow(number, 17) / 17 - Math.pow(number, 19)/19 + Math.pow(number, 21)/21);
    }*/
    public double atan(double x, double eps)
    {
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
