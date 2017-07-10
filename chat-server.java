/**Design a chat server **/
public class Solution {
    public class UserManager {
        public static UserManager instance;
        public static UserManager getInstance() {
            if (instance == null) instance = new UserManager();
            return instance;
        }
        HashMap<Integer, User> usersById = new HashMap<Integer, User>();
        HashMap<String, User> usersByName = new HashMap<String, User>();
        // sender sends an add request to receiver. 
        // add the request to receiver's queue
        public void addUser(User receiver, User sender) {
            sender.sendAddRequest(receiver);
            receiver.receivedAddRequest(sender);
        } 
        
        public void acceptRequest(AddRequest request) {}
        public void rejectRequest(AddRequest request) {}
        public void sendRequest(String message, User receiver) {}
    }
    
    public class AddRequest {
        User sender, receiver;
        boolean accepted;
    }
    public enum UserStatus {
        ONLINE, OFFLINE, IDLE, AWAY, BUSY
    }
    public class User {
        String name;
        // maps user id with add requests received
        HashMap<Integer, AddRequest> receivedAddRequest = new HashMap<Integer, AddRequest>(); 
        // maps user id with add requests sent
        HashMap<Integer, AddRequest> sentAddRequest = new HashMap<Integer, AddRequest>(); 
        UserStatus status = null;
        private HashMap<Integer, PrivateChat> privateChats; // one to one chat
        private ArrayList<GroupChat> groupChats;
        public requestAddUser(User receiver) {
            UserManager.getInstance().addUser(receiver, this);
        }
        public void receivedAddRequest(User sender) {
            addRequests.add(sender);
            // make decision
        }
        
    }
    
    public class Server {
    
    }
}
