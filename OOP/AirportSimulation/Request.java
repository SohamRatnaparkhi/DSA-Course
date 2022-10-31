package OOP.AirportSimulation;

public class Request {
    int time;
    int flightNumber;
    char type;

    public Request(int time, int flightNumber, char type) {
        this.time = time;
        this.flightNumber = flightNumber;
        this.type = type;
    }
    public Request (int time) {
        this.time = time;
        this.flightNumber = 0;
    }
    public Request() {
        this.time = 0;
        this.flightNumber = 0;
    }
    public String printFormat() {
       return (this.flightNumber + " - " + this.time + " - " + this.type);
    }
    
    public void print() {
        System.out.println(this.flightNumber + " - " + this.time + " - " + this.type);
    }
}
