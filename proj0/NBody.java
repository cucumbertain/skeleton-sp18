public class NBody {
    /** Read the path given and return the file in it.*/
    public static double readRadius(String path) {
        In in = new In(path);
        int N = in.readInt();
        double rad = in.readDouble();
        return rad;
    }

    /**Give back a list of planets */
    public static Planet[] readPlanets(String path) {
        In in = new In(path);
        int N = in.readInt();
        double rad = in.readDouble();
        Planet[] arr = new Planet[N];
        for (int i = 0; i < N; i = i + 1) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            arr[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return arr;
    }

    /**Create Universe State */
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double Rad = readRadius(filename);
        Planet[] p = readPlanets(filename);
        System.out.println(Rad);
    }

}
