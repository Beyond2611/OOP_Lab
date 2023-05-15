package Lab01.hust.soict.globalict.garbage;
public class GarbageCreator {
    public static class Student{
        int id;
        String name;
        @Override
        protected void finalize() throws Throwable
        {
            System.out.println("Garbage collector in action! Deleted one object!");
        }
    }
    public static void studentCreator(){
        for(int i = 0; i <= 3100000; ++i)
        {
            Student temp = new Student();
        }
    }
    public static void main(String[] args){
        studentCreator();
        noGarbage gCollect = new noGarbage();
        gCollect.clearGarbage();
    }
}
