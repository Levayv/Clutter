package am.levayv.testing.claio.chess.model;


import am.levayv.testing.claio.chess.model.fsm.State;
import am.levayv.testing.claio.chess.model.piece.data.Pos;

enum ControllerState implements State<Controller> {

    WAITING() {
        private Cell cell;

        @Override
        public void update(Controller var1) {
            // tick tack ?
        }

        @Override
        public boolean onEvent(Controller ctrl, Pos pos) {
            cell = Model.getInstance().board.
                    getCell(pos);
            if (cell.isOccupied()) {
                if (cell.isMine(ctrl.getCurrentPlayer())) {
                    if (cell.canMoveThePiece()) {
                        assert cell != null;
                        ctrl.setActiveCell(cell);
                        assert ctrl.getActiveCell() != null;
                        ctrl.stateMachine.changeState(MOVING);
                        // todo polish logging
                        System.out.println("Log: state changed to SELF moving");
                        return true;
                    }
                }
            }
            return false;
        }
    },

    MOVING() {
        private Cell cell;
        private Cell from;
        @Override
        public void update(Controller controller) {
            // tick tack ?
        }
        @Override
        public boolean onEvent(Controller ctrl, Pos pos) {
            cell = Model.getInstance().board
                    .getCell(pos);
            from = ctrl.getActiveCell();
            assert from != null;
            // IF clicked on same cell , abort movement
            if (cell.equals(from)) {
                ctrl.setActiveCell(null);
                ctrl.stateMachine.changeState(WAITING);
                //todo polish logging
                System.out.println("Log: state changed to SELF wait");
                return true;
            } else {
                // IF piece can move here
                if (from.canArriveTo(cell)) {
                    boolean b = cell.moveHere(from); //todo refactor , boolean b not needed
//                    System.out.println("!!! bbb "+((b)?"moved":"notMoved")); //todo delete me
                    ctrl.setActiveCell(null);
                    ctrl.switchPlayer();
                    ctrl.stateMachine.changeState(WAITING);
                    //todo polish logging
                    System.out.println("Log: state changed to OPPONENT wait");
                    System.out.println("Log: player changed");
                    return true;
                } else { // abort movement
                    ctrl.setActiveCell(null);
                    ctrl.stateMachine.changeState(WAITING);
                    //todo polish logging
                    System.out.println("Log: state changed to SELF wait");
                    return false;
                }
            }
        }
    }
}
