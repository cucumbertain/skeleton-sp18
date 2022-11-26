public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double G = 6.67e-11;

    /**Create a planet using 6 parameters */
    public Planet(double xPos, double yPos, double xVel, double yVel, double mas, String img) {
        xxPos = xPos;
        yyPos = yPos;
        xxVel = xVel;
        yyVel = yVel;
        mass = mas;
        imgFileName = img;
    }

    /**Copy a planet */
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    
    /**Caculate the distance between two planets */
    public double calcDistance(Planet p) {
        return Math.sqrt((this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) 
                            + (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos));
    }

    /**Caculate the force between two planets */
    public double calcForceExertedBy(Planet p) {
        return this.mass * p.mass * G / (this.calcDistance(p) * this.calcDistance(p));
    }

    /**Caculate the force exerted by X */
    public double calcForceExertedByX(Planet p) {
        return this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
    }

    /**Caculate the force exerted by Y */
    public double calcForceExertedByY(Planet p) {
        return this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
    }

    /**Caculate Netforce exerted by X */
    public double calcNetForceExertedByX (Planet[] planets) {
        double sumX = 0;
        for (int i = 0; i < planets.length; i = i + 1) {
            if (this.equals(planets[i])) {
                continue;
            } else {
                sumX += this.calcForceExertedByX(planets[i]);
            }
        }
        return sumX;
    }

    /**Caculate Netforce exerted by Y */
    public double calcNetForceExertedByY (Planet[] planets) {
        double sumY = 0;
        for (int i = 0; i < planets.length; i = i + 1) {
            if (this.equals(planets[i])) {
                continue;
            } else {
                sumY += this.calcForceExertedByY(planets[i]);
            }
        }
        return sumY;
    }

    /**Caculate updated velocity and postion of a planet. */
    public void update(double dt, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        this.xxVel = this.xxVel + dt * ax;
        this.yyVel = this.yyVel + dt * ay;
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

}
