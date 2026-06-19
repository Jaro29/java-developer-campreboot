package pl.coderslab.cutstrings;

public class Main02 {

    public static void main(String[] args) {

        String str = "Einstein,Red The Bum,Stella Baines,Lorraine Baines,Joey Baines,Milton Baines,3-D," +
                "Jennifer Parker,Mark Dixon,Linda McFly,Match,Lou,Goldie Wilson,Dr. Emmett Brown,Skinhead,Biff Tannen,Marty McFly," +
                "Mr. Peabody,Marvin Berry,George McFly,Sam Baines,Mr. Strickland,Sally Baines,Dave McFly";

        String[] words = str.split(",");
        for (String word : words) {
            System.out.println(word);
        }
    }


}
