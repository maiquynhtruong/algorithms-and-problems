/**Design a chat server **/
public class Solution {
    public class User {
        public User (String name, String statusMessage, boolean online) {
            String name;
            String statusMessage;
            boolean online;
        }
        public void acceptRequest(User other) {}
        public void rejectRequest(User other) {}
        public void sendRequest(String message, User receiver) {}
    }
    public class Server {
    
    }
}
