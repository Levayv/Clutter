package am.levayv.testing.claio.chess.model.fsm;


import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.Status;
import am.levayv.testing.claio.chess.model.piece.data.Color;
import am.levayv.testing.claio.chess.model.piece.data.Pos;

public class Controller{
    //todo polish
    private int count; // todo IMF rounds count
    private boolean isWhiteTurn; //todo delete
    private boolean isMoving; //todo delete
    private Color currentPlayer = Color.WHITE;
    public Color getOwner(){return currentPlayer;}

    private Cell activeCell; // which cell's piece to move on click
    public Cell getActiveCell() {
        return activeCell;
    }
    public void setActiveCell(Cell argCell) {
        if (argCell == null){
            if (this.activeCell != null) {
//                this.activeCell.setActive(false);
                this.activeCell.setStatus(Status.None);
                this.activeCell = null;
            } else {
                // todo delete else block
                assert activeCell == null;
                assert argCell == null;
            }
        } else {
            if (this.activeCell != null) {
//                this.activeCell.setActive(false);
                this.activeCell.setStatus(Status.None);
                this.activeCell = argCell;
//                this.activeCell.setActive(true);
                this.activeCell.setStatus(Status.Active);
            } else {
                this.activeCell = argCell;
                this.activeCell.setStatus(Status.Active);
            }
        }

//        if (activeCell == null){
//            if (this.activeCell == null){
//                //do nothing
//            }else {
//                this.activeCell.setActive(false);
//                this.activeCell = activeCell;
//            }
//        } else {
//            if (this.activeCell == null){
//                //do nothing
//            }else {
//                this.activeCell.setActive(false);
//                this.activeCell = activeCell;
//                this.activeCell.setActive(true);
//            }
//        }
    }

    public void switchPlayer(){
        if (currentPlayer.equals(Color.WHITE))
            currentPlayer = Color.BLACK;
        else
            currentPlayer = Color.WHITE;
    }
//    private MessageDispatcher dispatcher = new MessageDispatcher();
    StateMachine<Controller, ControllerState> stateMachine;
    public Controller(){
        stateMachine = new StateMachine
                <Controller, ControllerState>
                (this, ControllerState.WAITING);
    }

    public void handleEventAt(Pos pos) {
//        System.out.println("!!! handling msg: pos="+pos.x+pos.y);
        stateMachine.getState().onEvent(this, pos);

        //todo remove old gist

//        Gdx.app.debug("FSM",
//                "EntityID:"+this.getEntityName()+
//                        " state:"+this.stateMachine.getCurrentState().name()+
//                        " handleMessage: "+msg.message+"="+BasicEvents.values()[msg.message]);
//        if (msg.message == BasicEvents.NPC_MOVED.getID()){
//            NpcTalk extraInfoBuffer;
//            extraInfoBuffer = (NpcTalk) msg.extraInfo ;
//            //Gdx.app.debug("Npc", "hndleMsg msg = "+this.entityAnim.name()+","+this.getName());
//            //Gdx.app.debug("Npc", "hndleMsg msg = "+msg.message);
//            //Gdx.app.debug("Npc", "hndleMsg msg = "+BasicEvents.values()[msg.message]);
//            //Gdx.app.debug("Npc", "hndleMsg msg = "+extraInfoBuffer.faction.id);
//            //Gdx.app.debug("Npc", "hndleMsg msg = "+extraInfoBuffer.center.x);
//            //Gdx.app.debug("Npc", "hndleMsg msg = "+extraInfoBuffer.center.y);
//            if (extraInfoBuffer.faction.id != this.extraInfo.faction.id){
//                Gdx.app.debug("Npc", "hndleMsg exI is Enemy");
//                if (this.distance.inRange(extraInfoBuffer.getCenter(), extraInfoBuffer.outerBorder)){
//                    Gdx.app.debug("Npc", "hndleMsg exI is in range");
//                }
//            }
//        }

    }


}
