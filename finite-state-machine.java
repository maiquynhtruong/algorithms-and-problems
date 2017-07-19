// https://gamedevelopment.tutsplus.com/tutorials/finite-state-machines-theory-and-implementation--gamedev-11867
public class Ant {
    public Vector3D position;
    public Vector3D velocity;
    public FSM brain;
    public State activeState;
    /* The "find leaf" state where the ant moves toward the leaf */
    public void findLeaf() {}
    
    /* The "go home" state where the ant goes home */
    public void goHome() {}
    
    /* The "run away" state where the ant runs away from the cursor */
    public void runAway() {}
    
    public void setState(State newState) {
        activeState = newState;
    }
    public void update() {
        switch(activeState) {
            case FIND_LEAF:
                findLeaf();
                break;
            case GO_HOME: 
                goHome();
                break;
            case RUN_AWAY:
                runAway();
                break;
        }
    }
}
