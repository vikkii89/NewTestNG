package oopsMay16;

public class arrayConcept {

    int roll = 10;


    public String[] studentName;

    public static void main(String[] args) throws Exception {
        arrayConcept obj = new arrayConcept();
        obj.iAmLearningArray();

    }

    public void iAmLearningArray() {
        studentName = new String[200];

        studentName[0] = "abc";
        studentName[1] = "def";
        studentName[2] = "ghi";
        studentName[3] = "jkl";
        studentName[4] = "mno";

        for (int i = 0; i <= studentName.length-1; i++) {
            studentName[i] = "studentName" + i;
        }

        for (int j = 0; j <= studentName.length-1; j++) {
            System.out.println("Name is " + studentName[j]);
        }
    }

}




