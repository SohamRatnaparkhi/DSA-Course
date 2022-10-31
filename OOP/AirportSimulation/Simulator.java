package OOP.AirportSimulation;

import java.util.Scanner;

public class Simulator {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Queue runway1 = new Queue();
        Queue runway2 = new Queue();
        Queue results = new Queue();
        int totalTime = 0;
        int currTime = 0;
        int reqNumber = 0;
        int takeoff = 0;
        int landing = 0;
        // char reqType = ' ';
        while (totalTime <= 120) {
            System.out.print("Enter whether flight is landing(l) or having takeoff(t) - ");
            // if (reqNumber % 2 == 0)
            //     reqType = 'l';
            // else
            //     reqType = 't';
            char reqType = sc.next().charAt(0);
            reqType = Character.toUpperCase(reqType);
            // currTime += 5;
            reqNumber++;
            if (reqType == 'L') {
                landing++;
            } else {
                takeoff++;
            }
            Request newRequest = new Request(currTime, reqNumber, reqType);
            if (reqNumber == 1) {
                runway1.add(newRequest);
                runway1.isActive = true;
                totalTime += 15;
                currTime += 5;
                continue;
            }
            if (currTime == totalTime) {
                // Condition when req can be fullfiled
                Request active = null;
                int activePath = 0;
                if (!runway1.isEmpty() && runway1.isActive) {
                    runway1.isActive = false;
                    active = runway1.poll();
                    Request r1 = runway1.top();
                    Request r2 = runway2.top();
                    if (r1 != null && r1.type == 'L') {
                        runway1.isActive = true;
                        activePath = 1;
                    } else {
                        runway2.isActive = true;
                        activePath = 2;
                    }
                totalTime += 15;

                } else if (!runway2.isEmpty() && runway2.isActive) {
                    runway2.isActive = false;
                    active = runway2.poll();
                    Request r1 = runway1.top();
                    Request r2 = runway2.top();
                    if (r1 != null && r1.type == 'L') {
                        runway1.isActive = true;
                        activePath = 1;
                    } else {
                        runway2.isActive = true;
                        activePath = 2;
                    }
                totalTime += 15;

                } else {
                    runway1.add(newRequest);
                    runway1.isActive = true;
                    activePath = 1;
                totalTime += 15;

                }
                if (active != null) {
                    active.time = currTime;
                    // active.print();
                    results.add(active);
                }
                if (activePath == 1) {
                    runway2.add(newRequest);
                } else {
                    runway1.add(newRequest);
                }

                // if (r1.type == 'L') {
                // active = runway1.poll();
                // } else {
                // active = runway2.poll();
                // }

            } else {
                if (runway1.isActive) {
                    runway2.add(newRequest);
                } else {
                    runway1.add(newRequest);
                }
            }

            currTime += 5;

        }
        System.out.println("Order of carried instructions");
        System.out.println("FlightNum - Time - Type");
        results.print();
        System.out.println();
        System.out.println("Runway 1");
        System.out.println("FlightNum - Time - Type");
        runway1.print();
        System.out.println();
        System.out.println("Runway 2");
        System.out.println("FlightNum - Time - Type");
        runway2.print();
        System.out.println();

    }

    private static void checkQueue(Queue q) {
        for (int i = 0; i < 5; i++) {
            q.add(new Request(0, i, 'L'));
        }
        while (!q.isEmpty()) {
            Request data = q.poll();
            data.print();
        }
    }
}
