import java.util.Date; 
import java.simpleDateFormat; 

public class AlfredQuotes { 

    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name) {
        String guestGreeting = String.format("Hello, %s. Lovely to see you.", name);
        return guestGreeting;
    }

    public String guestGreeting(String name) {
        Date date = new Date();
        SimpleDateFormat Datefor = new SimpleDateFormat("k, a")
        String guestGreeting = String.format("Good %s, %s. Lovely to see you.", dayPeriod, name);
        return guestGreeting;
    }

    public String dateAnnouncement() { 
        Date date = new Date(); 
        String dateAnnouncement = String.format("It is currently %s.", date);
        return dateAnnouncement;
    }

    public String respondBeforeAlexis(String conversation) { 
        String request = conversation; 
        if (request.indexOf("Alexis") > -1) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        else if (request.indexOf("Alfred") > -1) {
            return "At your service. As you wish, naturally.";
        }
        else {
            return "Right. And with that I shall retire.";
        }
    }

}