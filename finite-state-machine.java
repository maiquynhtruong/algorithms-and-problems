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
