public class CreateArray {
    public static void main(String[] args)  {
        System.out.println("hi");
    }

    // The actual code for creating an Array to hold DVD's.
    DVD[] dvdCollection = new DVD[15];

    // A simple definition for a DVD.
    public class DVD {
        public String name;
        public int releaseYear;
        public String director;

        public DVD(String name, int releaseYear, String director) {
            this.name = name;
            this.releaseYear = releaseYear;
            this.director = director;
        }


    }
}

