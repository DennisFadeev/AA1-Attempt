package edu.kit.informatik;

import java.util.*;
import java.util.stream.*;

public class Tracks {
    private char type;
    private int trackID;
    int startX;
    int startY;
    int endX;
    int endY;
    protected int endX2;
    protected int endY2;
    private static int length;
    boolean available;
    boolean done;
    boolean position;
    static ArrayList<Tracks> tracks = new ArrayList<>();
    int temp1;
    int temp2;

    Tracks(int temp1, int temp2) {
        this.temp1 = temp1;
        this.temp2 = temp2;
    }

    Tracks(char type, int trackID, int startX, int startY, int endX, int endY) {
        this.type = type;
        this.trackID = trackID;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.length = setLength(startX, startY, endX, endY);
    }

    public static int setLength(int x, int y, int x2, int y2) {
        double distance = Math.sqrt(Math.pow((x2 - x), 2) + (Math.pow((y2 - y), 2)));
        length = (int) distance;
        return length;
    }

    public int getLength() {
        return length;
    }

    public int getTrackID() {
        return trackID;
    }

    public char getType() {
        return type;
    }

    public int getStartY() {
        return startY;
    }

    static void addTrack(int x, int y, int x2, int y2) {
        int ID = tracks.size() + 1;
        if (tracks.size() != 0) {
            if (checkCon(x, y, x2, y2) && checkVert(x, y, x2, y2)) {
                tracks.add(new Track(ID, x, y, x2, y2));
            }
        }
        if (tracks.size() == 0) {
            if (x == x2 || y == y2) {
                tracks.add(new Track(ID, x, y, x2, y2));
            }
        }
    }

    static void addSwitch(int x, int y, int x2, int y2, int x3, int y3) {
        int ID = tracks.size() + 1;
        if (tracks.size() != 0) {
            if (checkCon(x, y, x2, y2) && checkVert(x, y, x2, y2)) {
                if (checkCon(x, y, x3, y3) && checkVert(x, y, x3, y3)) {
                    tracks.add(new TrackSwitch(ID, x, y, x2, y2, x3, y3));
                }
            }
        }
    }

     static void setSwitch(int id, int x, int y) {
        for (int i = 0; i < tracks.size(); i++) {
            Tracks t = tracks.get(i);
            if (id == tracks.get(i).trackID && tracks.get(i) instanceof TrackSwitch) {
                if (x == tracks.get(i).endX && y == tracks.get(i).endY) {
                    setLength(t.startX, t.startY, t.endX, t.endY);
                    tracks.get(i).position = true;
                    tracks.get(i).done = true;
                }
                if (x == tracks.get(i).endX2 && y == tracks.get(i).endY2) {
                    setLength(t.startX, t.startY, t.endX2, t.endY2);
                    tracks.get(i).position = false;
                    tracks.get(i).done = true;
                }
            }
        }
    }

    static boolean checkCon(int x, int y, int x2, int y2) {
        boolean exists = false;
        for (int i = 0; i < tracks.size(); i++) {
            if (tracks.get(i).startX == x && tracks.get(i).startY == y) {
                exists = true;
            }
            if (tracks.get(i).endX == x && tracks.get(i).endY == y) {
                exists = true;
            }
            if (tracks.get(i).startX == x2 && tracks.get(i).startY == y2) {
                exists = true;
            }
            if (tracks.get(i).endX == x2 && tracks.get(i).endY == y2) {
                exists = true;
            }
            if (tracks.get(i).endX2 == x && tracks.get(i).endY2 == y) {
                exists = true;
            }
            if (tracks.get(i).endX2 == x2 && tracks.get(i).endY2 == y2) {
                exists = true;
            }
        }
        return exists;
    }

    static boolean checkVert(int x, int y, int x2, int y2) {
        boolean check = false;
        int max;
        int min;
        ArrayList<Tracks> temp = new ArrayList<>();
        if (x == x2) {
            for (int i = 0; i < tracks.size(); i++) {
                if ((x == tracks.get(i).startX) && (tracks.get(i).startX == tracks.get(i).endX)) {
                    temp.add(tracks.get(i));
                }
            }
            if (temp.size() == 0) {
                return check = true;
            }
            int minS = temp.get(0).startY;
            for (int i = 1; i < temp.size(); i++) {
                if (temp.get(i).startY < minS) {
                    minS = temp.get(i).startY;
                }
            }
            int maxS = temp.get(0).startY;
            for (int i = 1; i < temp.size(); i++) {
                if (temp.get(i).startY > maxS) {
                    maxS = temp.get(i).startY;
                }
            }
            int minE = temp.get(0).endY;
            for (int i = 1; i < temp.size(); i++) {
                if (temp.get(i).endY < minE) {
                    minE = temp.get(i).endY;
                }
            }
            int maxE = temp.get(0).endY;
            for (int i = 1; i < temp.size(); i++) {
                if (temp.get(i).endY > maxE) {
                    maxE = temp.get(i).endY;
                }
            }
            if (maxE > maxS) {
                max = maxE;
            } else {
                max = maxS;
            }

            if (minE < minS) {
                min = minE;
            } else {
                min = minS;
            }
            if ((y >= max && y2 >= max) || (y <= min && y2 <= min)) {
                check = true;
            }
        } else {
            return (checkHor(x, y, x2, y2));
        }
        return check;
    }

    static boolean checkHor(int x, int y, int x2, int y2) {
        boolean check = false;
        int max;
        int min;
        ArrayList<Tracks> temp = new ArrayList<>();
        if (y == y2) {
            for (int i = 0; i < tracks.size(); i++) {
                if ((y == tracks.get(i).startY) && (tracks.get(i).startY == tracks.get(i).endY)) {
                    temp.add(tracks.get(i));
                }
            }
            if (temp.size() == 0) {
                return check = true;
            }

            int maxS = temp.get(0).startX;
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i).startX > maxS) {
                    maxS = temp.get(i).startX;
                }
            }
            int minS = temp.get(0).startX;
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i).startX < minS) {
                    minS = temp.get(i).startX;
                }
            }
            int minE = temp.get(0).endX;
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i).endX < minE) {
                    minE = temp.get(i).endX;
                }
            }
            int maxE = temp.get(0).endX;
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i).endX > maxE) {
                    maxE = temp.get(i).endX;
                }
            }
            if (maxE > maxS) {
                max = maxE;
            } else {
                max = maxS;
            }

            if (minE < minS) {
                min = minE;
            } else {
                min = minS;
            }
            if ((x >= max && x2 >= max) || (x <= min && x2 <= min)) {
                check = true;
            }
        }
        return check;
    }

    static boolean deleteTrack(int id) {
        int k = 0;
        Tracks temp = null;
        boolean exists = false;
        boolean checked = false;
        for (int i = 0; i < tracks.size(); i++) {
            if (id == tracks.get(i).trackID) {
                temp = tracks.get(i);
                tracks.remove(i);
                exists = true;
                break;
            }
            if (i == tracks.size() - 1) {
                return exists;
            }
        }
        for (int i = 0; i < tracks.size(); i++) {
            for (int j = i + 1; j < tracks.size(); j++) {
                System.out.println(tracks.size());
                Tracks curr = tracks.get(i);
                Tracks rota = tracks.get(j);
                if (curr.startX == rota.startX && curr.startY == rota.startY) {
                    exists = true;

                } else {
                    k++;

                }
                if (curr.endX == rota.startX && curr.endY == rota.startY) {
                    exists = true;

                } else {
                    k++;

                }
                if (curr.startX == rota.endX && curr.startY == rota.endY) {
                    exists = true;

                } else {
                    k++;

                }
                if (curr.endX == rota.endX && curr.endY == rota.endY) {
                    exists = true;

                } else {
                    k++;

                }
                if (curr instanceof TrackSwitch && rota instanceof TrackSwitch) {
                    if (curr.endX2 == rota.startX && curr.endY2 == rota.startY) {
                        exists = true;

                    } else {
                        k++;

                    }
                    if (curr.endX2 == rota.endX2 && curr.endY2 == rota.endY2) {
                        exists = true;
                        System.out.println(exists + " " + curr.endX2 + " " + curr.endY2);
                    } else {
                        k++;

                    }
                }
                if(k == 4 || k == 6) {
                    System.out.println("OK");
                    tracks.add(temp);
                    tracks.get(tracks.size()).trackID = id;
                    return exists = false;
                }
            }
        }
        return exists;
    }

    static void listTracks() {
        int[] arr = new int[tracks.size()];
        String s = "";
        StringBuilder sb = new StringBuilder();
        if (tracks.size() != 0) {
            for (int i = 0; i < tracks.size(); i++) {
                Tracks t = tracks.get(i);
                if (t instanceof Track) {
                    sb.append(t.type + " " + t.trackID + " " + "(" + t.startX + "," + t.endX + ")" + "->" + "(" + t.endX
                            + "," + t.endY + ")" + " " + t.length + "\n");
                }
                if (t instanceof TrackSwitch) {
                    if (!t.done) {
                        sb.append(t.type + " " + t.trackID + " " + "(" + t.startX + "," + t.endX + ")" + "->" + "("
                                + t.endX + "," + t.endY + ")" + "," + "(" + t.startX + "," + t.endX + ")" + "\n");
                    }
                }
            }
            s = sb.toString();
            String[] lines = s.split(System.getProperty("line.separator"));
            StringBuilder finalStringBuilder= new StringBuilder("");
            for(String finale : lines){
               if(!s.equals("")){
                   finalStringBuilder.append(s).append(System.getProperty("line.separator").substring(0, 0));
                }
            }
            String finalString = finalStringBuilder.toString();
            System.out.print(finalString);
        }
    }
}