public class GalleryIllumination {

    public static void main(String[] args) {
        String[][] rooms = {{"....", "....", "...."},
                            {".....", ".O...", ".....", "....."},
                            {".....", ".OO..", ".....", "....."},
                            {".....", ".O#..", ".#.O.", "....."},
                            {".....", ".O...", "...O.", "....."},
                            {"O"}};

        for (int i = 0; i < rooms.length; i++) {
            System.out.printf("If we turn on the lights in room %d, we go from...\n", i+1);
            printRoom(rooms[i]);
            System.out.println("to a lit room...");
            printRoom(turnOnLights(rooms[i]));
            System.out.println();
        }

    }

    private static String[] turnOnLights(String[] room) {

        // Light Room
        for (int n : new int[2]) {
            for (int row = 0; row < room.length; row++) {
                room[row] = room[row].replaceAll("\\.(?<=O[*.]*)|\\.(?=[*.]*O)", "*");
            }
            room = flipRoom(room);
        }

        return room;
    }

    private static String[] flipRoom(String[] room) {
        String[] rotated = new String[room.length];
        for (int i = 0; i < rotated.length; i++) {
            String row = "";
            for (int j = 0; j < rotated.length; j++) {
                row += room[j].charAt(i);
            }
            rotated[i] = row;
        }
        return rotated;
    }

    private static void printRoom(String[] room) {
        for (String row : room) {
            System.out.printf("| %s |\n", row);
        }
    }

}
