public class Test {
    
        public static void main(String[] args){
        // Print "Hello Sam, how are you today?" and "Hello Rick Jones, how are you today?" 
            System.out.println(greeting("sam"));
            System.out.println(greeting("Rick","Jones"));
        }

    // Don't worry about the 'public' and 'static' keywords for now.
    // We will discuss them later.
        public static String greeting(String name){
        return String.format("Hello %s, how are you today?", name);
        }

        public static String greeting(String firstName, String lastName){
        return String.format("Hello %s %s, how are you today?", firstName, lastName);
        }

}



