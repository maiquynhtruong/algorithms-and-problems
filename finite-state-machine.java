// https://gamedevelopment.tutsplus.com/tutorials/finite-state-machines-theory-and-implementation--gamedev-11867
public class FSM {
    public State activeState;
    public Ant ant;
    public void setState(State newState) {
        activeState = newState;
    }
    public void update() {
        if (activeState == State.FIND_LEAF) ant.findLeaf();
        else if (activeState == State.GO_HOME) ant.goHome();
        else if (activeState == State.RUN_AWAY) ant.runAway();
    }
}
public class Ant {
    public Vector3D position;
    public Vector3D velocity;
    public FSM brain;
    
    /* The "find leaf" state where the ant moves toward the leaf */
    public void findLeaf() {
        velocity = new Vector3D(leaf.x - position.x, leaf.y - position.y);
        if (distance(leaf, this) <= 5) {
            // Near the leaf so eat it and go home
            eatLeaf();
            brain.setState(State.GO_HOME);
        }
        if (distance(cursor, this) <= MOUSE_THREAD_RADIUS) {
            // Cursor is near so need to run away
            brain.setState(State.RUN_AWAY);
        }
    }
    
    /* The "go home" state where the ant goes home */
    public void goHome() {
        velocity = new Vector3D(home.x - position.x, home.y - position.y);
        if (distance(home, this) <= 5) {
            // At home and needs to go find leaf
            brain.setState(State.FIND_LEAF);
        }
    }
    
    /* The "run away" state where the ant runs away from the cursor */
    public void runAway() {
        velocity = new Vector3D(cursor.x - position.x, cursor.y - position.y);
        moveOneStep();
        if (distance(cursor, this) > MOUSE_THREAT_RADIUS) {
            brain.setState(State.FIND_LEAF);   
        }
    }
    
    /* call every game frame to determine what the ant should be doing next */
    public void update() {
        brain.update();   
    }
}

/**** Implemenation using stack **/
public class FSM {
    /* The top of the stack contains the active state and transitions are handled by pushing or
    popping states from the stack */
    public Ant ant = new Ant();
    public Stack<State> stack = new Stack<State>();
    public void update() {
        State activeState = stack.peek();
        if (activeState == State.FIND_LEAF) ant.findLeaf();
        else if (activeState == State.GO_HOME) ant.goHome();
        else if (activeState == State.RUN_AWAY) ant.runAway();
    }
    /* A state can pop itself, which means the current state is complete and the next state in teh stack
    should become active */
    public State popState() {
        return stack.pop();   
    }
    /* Currently active state will change for a while, but then it pops itself from the stack,
    the previously active state will take over again */
    public void pushState(State state) {
        if (stack.peek() != state) stack.push(state);
    }
    
    /* Also a state can pop itself and push another state, which means a full transition */
}

public class Ant {
    FSM brain;
    Vector3D velocity;
    Vector3D position;
    /* The "find leaf" state where the ant moves toward the leaf */
    public void findLeaf() {
        velocity = new Vector3D(leaf.x - position.x, leaf.y - position.y);
        if (distance(leaf, this) <= 5) {
            // Near the leaf so eat it and go home
            eatLeaf();
            brain.popState();
            brain.pushState(State.GO_HOME);
        }
        if (distance(cursor, this) <= MOUSE_THREAD_RADIUS) {
            // The "runAway" state is pushed on top of "findLeaf", which means
            // the "findLeaf" state will be active again when "runAway" ends.
            brain.pushState(State.RUN_AWAY);
        }
    }
    
    /* The "go home" state where the ant goes home */
    public void goHome() {
        velocity = new Vector3D(home.x - position.x, home.y - position.y);
        if (distance(home, this) <= 5) {
            // At home and needs to go find leaf
            brain.popState();
            brain.pushState(State.FIND_LEAF);
        }
        if (distance(cursor, this) <= MOUSE_THREAD_RADIUS) {
            // The "runAway" state is pushed on top of "goHome", which means
            // the "goHome" state will be active again when "runAway" ends.
            brain.pushState(State.RUN_AWAY);
        }
    }
    
    /* The "run away" state where the ant runs away from the cursor */
    public void runAway() {
        velocity = new Vector3D(cursor.x - position.x, cursor.y - position.y);
        moveOneStep();
        if (distance(cursor, this) > MOUSE_THREAT_RADIUS) {
            brain.popState();  
        }
    }
    
    /* call every game frame to determine what the ant should be doing next */
    public void update() {
        brain.update();   
    }
}

