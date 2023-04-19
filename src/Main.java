//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import spybug.HeadingType;
import spybug.Room;
import spybug.SpyBug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /*  As assignment was simple, I was focusing more on design patterns here instead of actual logic.
        Things that are not covered:
        1. add messages so that user can be informed about the format of the input
        2. validating the input
        3. tests
     */
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] roomSize = reader.readLine().toCharArray();
        Integer width = Character.getNumericValue(roomSize[0]);
        Integer height = Character.getNumericValue(roomSize[1]);

        Room room = new Room(height, width);
        List<SpyBug> deployedBugs = new ArrayList<>();

        while(true) {
            char[] currentPosition = reader.readLine().toCharArray();
            Integer x = Character.getNumericValue(currentPosition[0]);
            Integer y = Character.getNumericValue(currentPosition[1]);
            HeadingType headingType = HeadingType.valueOf(String.valueOf(currentPosition[2]));

            SpyBug spyBug = new SpyBug(headingType, x, y, room, deployedBugs);

            char[] command = reader.readLine().toCharArray();

            for(char c : command) {
                if(c == 'L') {
                    spyBug.moveLeft();
                }
                if(c == 'R') {
                    spyBug.moveRight();
                }
                if(c == 'F') {
                    spyBug.moveForward();
                }
            }

            deployedBugs.add(spyBug);
            System.out.println(spyBug.getX() + " " + spyBug.getY() + " " + spyBug.getCurrentHeading().getHeadingType());
        }
    }
}
