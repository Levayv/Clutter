package am.levayv.testing.claio.chess.model.fsm;

class StateMachine<T, S extends State> {
    private T owner;
    private S state;
    StateMachine(T owner, S state) {
        this.owner = owner;
        this.state = state;
    }
    T getOwner(){ //todo delete
        return owner;
    }
    S getState(){
      return state;
    }
    void changeState(S state){
        this.state = state;
        // todo consider previous state ?
        // something like previous state , stack fsm ?
    }
}
