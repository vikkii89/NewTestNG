package oopsMay16;

public class iphone15Child extends iphone14Parent{

    public static void main(String args[]) throws Exception{

        iphone15Child obj = new iphone15Child();
        obj.callUsingPhone();
        obj.textUsingPhone();
        obj.seeGoogleMaps();
        obj.securityByFingerprint();
        obj.hdPicture();
        obj.lockByDoubletap();
    }
    public void securityByFingerprint(){
        System.out.println("We can unlock using finger touch in iphone15");
    }

    public void hdPicture(){
        System.out.println("We can take  HD picture in iphone15");
    }

    public void lockByDoubletap(){
        System.out.println("we can lock it by double tap in iphone15");
    }
}
