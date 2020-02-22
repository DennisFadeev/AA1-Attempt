package edu.kit.informatik;

import java.util.*;

public class Test {
  
    public static void main(String[] args) {
        /*ArrayList<Tracks> test = new ArrayList<>();
        ArrayList<RollingStock> test2 = new ArrayList<>();
        Coach freight = Coach.freight;
        test.add(new Track(test.size() + 1, -2, 1, -2, -7));
        System.out.println(test.get(0).getTrackID());
        System.out.println(test.get(0).getLength());
        
        test2.add(new Engine(Locomotive.electrical,"ok", "ok", 2, true, false));
        test2.get(0).available = false;
        if(test2.get(0) instanceof RollingStock)
        System.out.println(test2.get(0));
        System.out.println(test2.get(0).locomotive);
    */
        Tracks.addTrack(1, 1, 3, 1);
        //Tracks.addSwitch(1, 2, 3, 2, 1, 5);
        Tracks.addTrack(1, 1, 1, 3);
        Tracks.addTrack(1, 3, 2, 3);
        Tracks.addTrack(2, 3, 3, 3);
        Tracks.addSwitch(3, 3, 3, 4, 4, 3);
        Tracks.addSwitch(4, 3, 5, 3, 4, 4);
        Tracks.listTracks();
        //Tracks.deleteTrack(1);
        //Tracks.listTracks();
        //Tracks.setSwitch(2, 1, 5);
        //Tracks.addTrack(3, 3, 3, 1);
        //Tracks.addTrack(3, 1, 5, 1);
        //Tracks.addTrack(1, 5, 1, 3);
        //System.out.println(Tracks.tracks.get(2));
        //System.out.println(Tracks.checkDup(1, 4, 1, 5));
        //System.out.println(Tracks.tracks.get(1));
       /*System.out.println(Tracks.tracks.get(2).startX);
       System.out.println(Tracks.tracks.get(2).startY);
       System.out.println(Tracks.tracks.get(2).endX);
       System.out.println(Tracks.tracks.get(2).endY);
       System.out.println(Tracks.tracks.get(2).endX2);
       System.out.println(Tracks.tracks.get(2).endY2);
       System.out.println(Tracks.tracks.get(2).position);*/
    }
    
}
