package am.levayv.testing.claio.chess.model;

import am.levayv.testing.claio.chess.model.fsm.State;

class StateMachine<T, S extends State> {
    private T machine;
    private S state;
    StateMachine(T machine, S state) {
        this.machine = machine;
        this.state = state;
    }
    T getMachine(){ //todo delete
        return machine;
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
